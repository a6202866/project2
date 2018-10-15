package com.lxd.project2.controller;

import com.alibaba.fastjson.JSON;
import com.lxd.project2.entity.*;
import com.lxd.project2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    /*
    ��ת������1
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
    ͨ��������ְλ
     */
    @RequestMapping(value="findByDept", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String findByDept(String dept){
        List<Position> list = iPositionService.queryByDept(dept);
        String  json = JSON.toJSONString(list);
        return json;
    }
/*
    �����Ƹ
 */
    @RequestMapping("zp")
    public String zp(Recruit recruit){
        iRecruitService.add(recruit);
        return "manager/manager1";
    }
    /*
    ��תĬ�Ͻ���
     */
    @RequestMapping("manager")
    public String manager(){
        return "manager/manager";
    }
    /*
    ��ת����2
     */
    @RequestMapping("manager2")
    public String manager2(HttpSession session){
        List<Interview> list = iInterviewService.queryAll();

        session.setAttribute("interview",list);
        return "manager/manager2";
    }
    /*
    �鿴����
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
     * ɾ������
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
     * ���ͼ���
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
        Recruit recruit = iRecruitService.queryByID(iid1.getRecruitID());
        Inform inform = new Inform(recruit.getName(),recruit.getAddress(),recruit.getPosition(),idate);
        iInformService.add(inform);

        return "manager/managerSee";
    }
    /*
    ¼ȡ
     */
    @RequestMapping("admin")
    public String changeVisitorCls2(int interviewID){
        Interview interview = iInterviewService.queryByID(interviewID);
        iVisitorService.changeVisitorCls2(interview.getUsername());
        return "manager/manager2";
    }
    /*
    ��ת����3
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
        if(dept2==null||dept2.equals("")){
            iDeptService.add(dept);
        }else {
            iDeptService.changeDept(dept,dept2);
        }
        List<Dept> depts = iDeptService.queryAll();
        session.setAttribute("dept",depts);
        session.setAttribute("updateDept","");
        return "manager/manager3";
    }
    @RequestMapping("deptDetail")
    public String deptDetail(String dept,HttpSession session){
        List<Position> list = iPositionService.queryByDept(dept);
        session.setAttribute("positionOfDept",list);
        session.setAttribute("dept1",dept);
        return "positionOfDept";
    }
    @RequestMapping("addUpdatePosition")
    public String addUpdatePosition(HttpSession session,String position){
        if(position==null){
            return "manager/addUpdateDept";
        }
        session.setAttribute("updatePositon",position);
        return "manager/addUpdatePosition";
    }
    /*
   ��ת����4
    */
    @RequestMapping("manager4")
    public String manager4(){
        return "manager/manager4";
    }
    /*
    ��ת����5
     */
    @RequestMapping("manager5")
    public String manager5(){
        return "manager/manager5";
    }
    /*
   ��ת����6
    */
    @RequestMapping("manager6")
    public String manager6(){
        return "manager/manager6";
    }
    /*
   ��ת����7
    */
    @RequestMapping("manager7")
    public String manager7(){
        return "manager/manager7";
    }
    /*
   ��ת����8
    */
    @RequestMapping("manager8")
    public String manager8(){
        return "manager/manager8";
    }
}
