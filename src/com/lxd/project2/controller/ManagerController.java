package com.lxd.project2.controller;

import com.alibaba.fastjson.JSON;
import com.lxd.project2.entity.*;
import com.lxd.project2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */
@RequestMapping("Manager")
@Controller()
public class ManagerController {
    @Autowired
    private IVisitorService iVisitorService;
    @Autowired
    private IDeptService iDeptService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IRecruitService iRecruitService;
    @Autowired
    private IInterviewService iInterviewService;
    @Autowired
    private IResumeService iResumeService;
    @Autowired
    private IInformService iInformService;
    @Autowired
    private IIDService iidService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private ITrainService iTrainService;
    @Autowired
    private ISalaryService iSalaryService;
    @Autowired
    private IRpService iRpService;
    @Autowired
    private ICheckService iCheckService;
    /*
    跳转到界面1
     */
    @RequestMapping("manager1")
    public String manager1(HttpServletRequest request){
        List<Dept> depts = iDeptService.queryAll();
        List<Position> positions = iPositionService.queryAll();
        request.setAttribute("dept",depts);
        request.setAttribute("position",positions);
        return "manager/manager1";
    }
    /*
    通过部门找职位
     */
    @RequestMapping(value="findByDept", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String findByDept(String dept){
        List<Position> list = iPositionService.queryByDept(dept);
        String  json = JSON.toJSONString(list);
        return json;
    }
/*
    添加招聘
 */
    @RequestMapping("zp")
    public String zp(Recruit recruit){
        iRecruitService.add(recruit);
        return "manager/manager1";
    }
    /*
    跳转默认界面
     */
    @RequestMapping("manager")
    public String manager(){
        return "manager/manager";
    }
    /*
    跳转界面2
     */
    @RequestMapping("manager2")
    public String manager2(HttpSession session){
        List<Interview> list = iInterviewService.queryAll();

        session.setAttribute("interview",list);
        return "manager/manager2";
    }
    /*
    查看简历
     */
    @RequestMapping("lookInterview")
    public String lookInterview(String username,HttpSession session,int interviewID){
        iInterviewService.update(username);
        List<Interview> list = iInterviewService.queryAll();
        session.setAttribute("interview",list);
        Resume resume = iResumeService.queryByUserName(username);
        session.setAttribute("resume",resume);
        session.setAttribute("interviewID",interviewID);
        return "manager/managerSee";
    }

    /**
     * 删除简历
     * @param username
     * @param session
     * @return
     */
    @RequestMapping("deleteInterview")
    public String deleteInterview(String username,HttpSession session){
        iInterviewService.deleteByName(username);
        List<Interview> list = iInterviewService.queryAll();
        session.setAttribute("interview",list);
        return "manager/manager2";
    }

    /**
     * 面试
     * @param resumeID
     * @param interviewID
     * @param idate
     * @param dept
     * @param position
     * @return
     */
    @RequestMapping("sendInterview")
    public String sendInterview(int resumeID, int interviewID, java.sql.Date idate, Dept dept, Position position){
        iInterviewService.updatein(interviewID);
        IID iid = new IID();
        iid.setResumeID(resumeID);
        iid.setInterviewID(interviewID);
        IID iid1 = iidService.queryByRID(iid);
        String username = iInterviewService.queryByID(interviewID).getUsername();
        Recruit recruit = iRecruitService.queryByID(iid1.getRecruitID());
        Inform inform = new Inform(username,recruit.getName(),recruit.getAddress(),recruit.getPosition(),idate);
        iInformService.add(inform);

        return "manager/managerSee";
    }
    @RequestMapping("changeEmployee")
    public String changeEmployee(int id,HttpSession session){
        Employee employee = iEmployeeService.queryByID(id);
        session.setAttribute("changeEmployee",employee);
        return "manager/ChangeEmployee";
    }
    @RequestMapping("changeEmp")
    public String changeEmp(Employee employee,HttpSession session){
        iEmployeeService.changeEmp(employee);
        List<Employee> list = iEmployeeService.queryByState("在职员工");
        List<Employee> list1 = iEmployeeService.queryByState("试用期");
        session.setAttribute("zzyg",list);
        session.setAttribute("syq",list1);
        return "manager/manager5";
    }
    @RequestMapping("deleteEmployee")
    public String deleteEmployee(int id,HttpSession session){
        iEmployeeService.deleteById(id);
        List<Employee> list = iEmployeeService.queryByState("在职员工");
        List<Employee> list1 = iEmployeeService.queryByState("试用期");
        session.setAttribute("zzyg",list);
        session.setAttribute("syq",list1);
        return "manager/manager5";
    }
    /*
    录取
     */
    @RequestMapping("admin")
    public String changeVisitorCls2(int interviewID,int resumeID,int basicSalary){
        Interview interview = iInterviewService.queryByID(interviewID);
        IID iid =new IID();
        iid.setInterviewID(interviewID);
        iid.setResumeID(resumeID);
        IID iid1 = iidService.queryByRID(iid);
        Recruit recruit = iRecruitService.queryByID(iid1.getRecruitID());
        iVisitorService.changeVisitorCls2(interview.getUsername());
        Resume resume = iResumeService.queryByUserName(interview.getUsername());
        Employee employee1 = iEmployeeService.queryByUsername(interview.getUsername());
        if(employee1!=null){
            return  "manager/manager2";
        }
        Employee employee = new Employee(resume.getUsername(),resume.getName(),
                resume.getSex(),resume.getAge(),resume.getSchool(),resume.getPnumber(),
                resume.getEmail(),new Date(),recruit.getDept(),recruit.getPosition());
        iEmployeeService.add(employee);
        //加进工资
        Salary salary = new Salary();
        salary.setUsername(interview.getUsername());
        salary.setUsername(interview.getName());
        salary.setBasicSalary(basicSalary);
        iSalaryService.add(salary);
        return "manager/manager2";
    }
    /*
    跳转界面3
     */
    @RequestMapping("manager3")
    public String manager3(HttpSession session){
        List<Dept> depts = iDeptService.queryAll();
        List<Position> positions = iPositionService.queryAll();
        session.setAttribute("dept",depts);
        session.setAttribute("position",positions);
        return "manager/manager3";
    }
    @RequestMapping("addUpdateDept")
    public String addUpdateDept(String dept,HttpSession session){
        if(dept==null){
            return "manager/addUpdateDept";
        }
        session.setAttribute("updateDept",dept);
        return "manager/addUpdateDept";
    }
    @RequestMapping("addUpdateDepting")
    public String addUpdateDepting(HttpSession session,String dept){
        String dept2 = (String) session.getAttribute("updateDept");
        Dept dept1 = new Dept(dept,new Date());
        if(dept2==null||dept2.equals("")){
            iDeptService.add(dept1);
        }else {
            iDeptService.changeDept(dept,dept2);
            iPositionService.changeP(dept,dept2);
        }
        List<Position> positions = iPositionService.queryAll();
        List<Dept> depts = iDeptService.queryAll();
        session.setAttribute("position",positions);
        session.setAttribute("dept",depts);
        session.setAttribute("updateDept","");
        return "manager/manager3";
    }
    @RequestMapping("deleteDept")
    public String deleteDept(String dept,HttpSession session){
        iDeptService.deleteByDept(dept);
        List<Dept> depts = iDeptService.queryAll();
        session.setAttribute("dept",depts);
        return "manager/manager3";
    }
    @RequestMapping("deptDetail")
    public String deptDetail(String dept,HttpSession session){
        List<Position> list = iPositionService.queryByDept(dept);
        session.setAttribute("positionOfDept",list);
        session.setAttribute("dept1",dept);
        return "manager/positionOfDept";
    }
    @RequestMapping("addUpdatePosition")
    public String addUpdatePosition(HttpSession session,String position,Position position1){
        if(position==null||position.equals("")){
            return "manager/addPosition";

        }
        /*Position position1 = new Position(id,dept,position);*/
        session.setAttribute("updatePositon",position1);
        return "manager/UpdatePosition";
    }
    @RequestMapping("addUpdatePositioning")
    public String addUpdatePositioning(Position position,HttpSession session){
            iPositionService.changePosition(position);
        List<Position> list = iPositionService.queryByDept(position.getDept());
        session.setAttribute("positionOfDept",list);
        return "manager/positionOfDept";
    }
    @RequestMapping("addPosition")
    public String addPosition(String dept,String position,HttpSession session){
        Position position1 = new Position(dept,position,new Date());

        iPositionService.add(position1);
        List<Position> list = iPositionService.queryByDept(position1.getDept());
        session.setAttribute("positionOfDept",list);
        return "manager/positionOfDept";
    }
    @RequestMapping("deletePosition")
    public String deletePosition(Position position,HttpSession session){
        iPositionService.deletePosition(position);
        List<Position> list = iPositionService.queryByDept(position.getDept());
        session.setAttribute("positionOfDept",list);
        return "manager/positionOfDept";
    }
    /*
   跳转界面4
    */
    @RequestMapping("manager4")
    public String manager4(HttpSession session){
        List<Train> list = iTrainService.queryAll();
        session.setAttribute("train",list);
        return "manager/manager4";
    }
    @RequestMapping("addTrain")
    public String addTrain(HttpSession session, String name, String dept, java.sql.Date date){
        Train train = new Train();
        train.setDept(dept);
        train.setName(name);
        train.setDate(date);
        iTrainService.add(train);
        List<Train> list = iTrainService.queryAll();
        session.setAttribute("train",list);
        return "manager/manager4";
    }
    @RequestMapping("delTrain")
    public String delTrain(HttpSession session,int id){
        iTrainService.delByID(id);
        List<Train> list = iTrainService.queryAll();
        session.setAttribute("train",list);
        return "manager/manager4";
    }
    @RequestMapping("changeTrain")
    public String changeTrain(HttpSession session, String name, String dept, java.sql.Date date,int id){
        Train train = new Train();
        train.setDept(dept);
        train.setId(id);
        train.setName(name);
        train.setDate(date);
        iTrainService.update(train);
        List<Train> list = iTrainService.queryAll();
        session.setAttribute("train",list);
        return "manager/manager4";
    }
    /*
    跳转界面5
     */
    @RequestMapping("manager5")
    public String manager5(HttpSession session){
        List<Employee> list = iEmployeeService.queryByState("在职员工");
        List<Employee> list1 = iEmployeeService.queryByState("试用期");
        session.setAttribute("zzyg",list);
        session.setAttribute("syq",list1);
        return "manager/manager5";
    }
    @RequestMapping("addRp")
    public String addRp(Rp rp){
        rp.setDate(new Date());
        iRpService.add(rp);
        return "manager/manager5";
    }
    @RequestMapping("empDetail")
    public String empDetail(int id,HttpSession session){
        Employee employee = iEmployeeService.queryByID(id);
        session.setAttribute("employeeDetail",employee);
        return "manager/empDetail";
    }
    @RequestMapping("seeCheck")
    public String seeCheck(String username,HttpSession session){
        List<Check> checks = iCheckService.queryByUsername(username);
        session.setAttribute("checkall",checks);
        return "manager/seeCheck";
    }
    /*
   跳转界面6
    */
    @RequestMapping("manager6")
    public String manager6(){
        return "manager/manager6";
    }
    /*
   跳转界面7
    */
    @RequestMapping("manager7")
    public String manager7(){
        return "manager/manager7";
    }
    /*
   跳转界面8
    */
    @RequestMapping("manager8")
    public String manager8(){
        return "manager/manager8";
    }

}
