package com.lxd.project2.controller;

import com.alibaba.fastjson.JSON;
import com.lxd.project2.dao.ICheckDao;
import com.lxd.project2.dao.IRpDao;
import com.lxd.project2.entity.*;
import com.lxd.project2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/17 0017.
 */
@RequestMapping("Employee")
@Controller
public class EmployeeController {
    @Autowired
    private IVisitorService iVisitorService;
    @Autowired
    private IRecruitService iRecruitService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IDeptService iDeptService;
    @Autowired
    private IResumeService iResumeService;
    @Autowired
    private IInterviewService iInterviewService;
    @Autowired
    private IIDService iidService;
    @Autowired
    private IInformService iInformService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private ICheckService iCheckService;
    @Autowired
    private IRpService iRpService;
    @Autowired
    private ISalaryService iSalaryService;
    @Autowired
    private IReasonService iReasonService;
    @RequestMapping("employee")
    public String employee(){
        return "employee/employee";
    }
    @RequestMapping("addOnDuty")
    public String addOnDuty(HttpSession session) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String likeDay = "%"+sdf1.format(date)+"%";
        if(iCheckService.queryByOnState(likeDay)!=null){
            session.setAttribute("check",iCheckService.queryByOnState(likeDay));
            return "employee/employee2";
        }
        Check check = new Check();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Employee employee = (Employee) session.getAttribute("employeeDetail");
        System.out.println(employee);
        String d1 = sdf.format(date);
        Date time = sdf.parse("9:00:00");
        Date time1 = sdf.parse(d1);
        if(time1.getTime()-time.getTime()>0&&time1.getTime()-time.getTime()<10800000){
            check.setOndutystate("迟到");
            Rp rp = new Rp(employee.getUsername(),employee.getName(),-50,"迟到",new Date());
            iRpService.add(rp);
        }else if(time1.getTime()-time.getTime()>=10800000){
            check.setOndutystate("旷工");
            Rp rp = new Rp(employee.getUsername(),employee.getName(),-200,"旷工",new Date());
            iRpService.add(rp);
        }else{
            check.setOndutystate("准时");
        }
        check.setOffdutystate("缺卡");
        check.setUsername(employee.getUsername());
        check.setName(employee.getName());
        check.setOnduty(date);
        iCheckService.addOnDuty(check);
        session.setAttribute("check",iCheckService.queryByOnState(likeDay));
       return "employee/employee2";
    }
    @RequestMapping("addOffDuty")
    public String addOffDuty(HttpSession session) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String likeDay = "%"+sdf1.format(date)+"%";
        Check check = iCheckService.queryByOnState(likeDay);
        if(check.getOffduty()!=null){
            return "employee/employee2";
        }
        if(check!=null){
            check.setOffduty(date);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date time = sdf.parse("18:00:00");
            String d1 = sdf.format(date);
            Date time1 = sdf.parse(d1);
            if(time.getTime()-time1.getTime()>0&&time.getTime()-time1.getTime()<10800000){
                Rp rp = new Rp(check.getUsername(),check.getName(),-50,"早退",new Date());
                iRpService.add(rp);
                check.setOffdutystate("早退");
            }else if(time.getTime()-time1.getTime()>=10800000){
                check.setOffdutystate("旷工");
                Rp rp = new Rp(check.getUsername(),check.getName(),-200,"旷工",new Date());
                iRpService.add(rp);
            } else {
                check.setOffdutystate("准时");
            }
            iCheckService.addOffDuty(check);
            session.setAttribute("check",iCheckService.queryByOnState(likeDay));
            return "employee/employee2";
        }
        return "employee/employee2";
    }
    @RequestMapping("employee1")
    public String employee1(){
        return "employee/employee1";
    }
    @RequestMapping("updateEmployee")
    public String updateEmployee(HttpSession session, Employee employee){
        iEmployeeService.updateEmp(employee);
        Employee employee1 = iEmployeeService.queryByID(employee.getId());
        session.setAttribute("employeeDetail",employee1);
        return "employee/employee1";
    }
    @RequestMapping("employee2")
    public String employee2(){
        return "employee/employee2";
    }
    @RequestMapping( value = "seeChcek", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String seeChcek(String date){
        System.out.println(date);
        List<Check> list = iCheckService.queryByMonth(date);
        System.out.println(list);
        String json = JSON.toJSONString(list);
        return json;
    }
    @RequestMapping("employee3")
    public String employee3(){
        return "employee/employee3";
    }
    @RequestMapping("employee4")
    public String employee4(HttpSession session){
        Visitor visitor = (Visitor) session.getAttribute("user");
        String username = visitor.getName();
        List<Rp> list = iRpService.queryByUsername(username);
        session.setAttribute("rpss",list);
        return "employee/employee4";
    }
    @RequestMapping(value = "seeRp1", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String seeRp1(String date,HttpSession session){
        Visitor visitor = (Visitor) session.getAttribute("user");
        String username= visitor.getName();
        List<Rp> list = iRpService.queryByDateUsername(username,date);
        String json = JSON.toJSONString(list);
        return json;

    }
    @RequestMapping("employee5")
    public String employee5(){
        return "employee/employee5";
    }
    @RequestMapping("employee6")
    public String employee6(){
        return "employee/employee6";
    }
    @RequestMapping("employee7")
    public String employee7(HttpSession session){
        List<Salary> list = iSalaryService.queryAll();
        List<Salary> list1 = new ArrayList<Salary>() ;
        Visitor visitor = (Visitor) session.getAttribute("user");
        String username= visitor.getName();
        for(Salary salary:list){
            if(username.equals(salary.getUsername())){
                list1.add(salary);
            }
        }
        int i = -1;
        for(Salary salary:list1){
            if(salary.getSocialSalary()==0){
                i=list1.indexOf(salary);
            }
        }
        if(i!=-1){
            list1.remove(i);
        }
        session.setAttribute("allSalary1",list1);
        return "employee/employee7";
    }
    @RequestMapping("addDif")
    public String addDif(int Sid,String reason,String name,String username){
        Reason reason1 = new Reason();
        reason1.setDate(new Date());
        reason1.setReason(reason);
        reason1.setSid(Sid);
        reason1.setName(name);
        reason1.setUsername(username);
        iReasonService.add(reason1);
        return "employee/employee7";

    }
    @RequestMapping(value = "seeSalary1", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String seeSalary(String date,HttpSession session){
        List<Salary> list= iSalaryService.qeuryByDate(date);
        List<Salary> list1 = new ArrayList<Salary>() ;
        Visitor visitor = (Visitor) session.getAttribute("user");
        String username= visitor.getName();
        for(Salary salary:list){
            if(username.equals(salary.getUsername())){
                list1.add(salary);
            }
        }
        int i = -1;
        for(Salary salary:list1){
            if(salary.getSocialSalary()==0){
                i=list1.indexOf(salary);
            }
        }
        if(i!=-1){
            list1.remove(i);
        }
        String json = JSON.toJSONString(list1);
        return json;
    }
}
