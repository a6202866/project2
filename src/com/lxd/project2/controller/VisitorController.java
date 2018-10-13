package com.lxd.project2.controller;

import com.alibaba.fastjson.JSON;
import com.lxd.project2.dao.IInterviewDao;
import com.lxd.project2.entity.*;
import com.lxd.project2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
@RequestMapping("Visitor")
@Controller
public class VisitorController {
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
    @RequestMapping("queryByName")
    @ResponseBody
    public String queryByName(String name){
        if(iVisitorService.queryByName(name)!=null){
            return "1";
        }
        return "0";
    }
    @RequestMapping(value = "regist", produces = "application/json; charset=utf-8")
    public String regist(Visitor visitor){
        iVisitorService.regist(visitor);
        return "redirect:/login.jsp";
    }
    @RequestMapping("ajaxLogin")
    @ResponseBody
    public String ajaxLogin(Visitor visitor){
        if(iVisitorService.queryByNamePassword(visitor)!=null){
            return "0";
        }else {
            return "1";
        }
    }
    @RequestMapping(value = "login")
    public String login(Visitor visitor, HttpSession session,HttpServletRequest request){
        Visitor visitor1 = iVisitorService.queryByNamePassword(visitor);
        session.setAttribute("user",visitor1);
        List<Recruit> list = iRecruitService.queryAll();
        request.setAttribute("recruit",list);
        if(visitor1.getCls()==0){
            return "manager/manager";
        }else if(visitor1.getCls()==1){
            return "visitor/visitor";
        }else{
            return "employee/employee";
        }
    }


    @RequestMapping(value="findByDept", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByDept(String dept){
        List<Position> list = iPositionService.queryByDept(dept);
        String  json = JSON.toJSONString(list);
        return json;
    }
    @RequestMapping("changePassword")
    public String changePassword(Visitor visitor,HttpSession session){
        iVisitorService.changePassword(visitor);
        Visitor visitor1 = iVisitorService.queryByNamePassword(visitor);
        session.setAttribute("user",visitor1);
        return "visitor/visitor";
    }

    @RequestMapping("visitor")
    public String visitor(HttpServletRequest request){
        List<Recruit> list = iRecruitService.queryAll();
        request.setAttribute("recruit",list);
        return "visitor/visitor";
    }
    @RequestMapping("addInterview")
    public String addInterview(HttpSession session,int recruitID){
        Visitor visitor = (Visitor) session.getAttribute("user");

        if(iInterviewService.queryByName(visitor.getName())!=null){
            return "redirect:/visitor/visitor";
        }
        Resume resume = iResumeService.queryByUserName(visitor.getName());
        resume.setDate(new Date());
        iInterviewService.add(resume);
        Interview interview = iInterviewService.queryByName(resume.getUsername());
        IID iid = new IID(resume.getId(),recruitID,interview.getId());
        iidService.add(iid);
        return "redirect:/visitor/visitor";
    }
    @RequestMapping("visitor1")
    public String visitor1(){
        return "visitor/visitor1";
    }
    @RequestMapping("visitor2")
    public String visitor2(HttpServletRequest request,HttpSession session){
        List<Dept> depts = iDeptService.queryAll();
        List<Position> positions = iPositionService.queryAll();
        Visitor visitor = (Visitor) session.getAttribute("user");
        String name = visitor.getName();
        Resume resume = iResumeService.queryByUserName(name);
        session.setAttribute("resume",resume);
        request.setAttribute("dept",depts);
        request.setAttribute("position",positions);
        return "visitor/visitor2";
    }
    @RequestMapping("addResume")
    public String addResume(HttpSession session,Resume resume){
        resume.setDate(new Date());
        iResumeService.add(resume);
        Visitor visitor = (Visitor) session.getAttribute("user");
        String name = visitor.getName();
        Resume resume1 = iResumeService.queryByUserName(name);
        session.setAttribute("resume",resume);
        return "visitor/visitor2";
    }
    @RequestMapping("updateesume")
    public String updateesume(Resume resume,HttpSession session){
        resume.setDate(new Date());
        iResumeService.update(resume);
        Visitor visitor = (Visitor) session.getAttribute("user");
        String name = visitor.getName();
        Resume resume1 = iResumeService.queryByUserName(name);
        session.setAttribute("resume",resume);
        return "visitor/visitor2";
    }
    @RequestMapping("visitor3")
    public String visitor3(){
        return "visitor/visitor3";
    }
    @RequestMapping("visitor4")
    public String visitor4(){
        return "visitor/visitor4";
    }
}
