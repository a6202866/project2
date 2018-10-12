package com.lxd.project2.controller;

import com.alibaba.fastjson.JSON;
import com.lxd.project2.entity.Recruit;
import com.lxd.project2.entity.Visitor;
import com.lxd.project2.service.IRecruitService;
import com.lxd.project2.service.IVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String login(Visitor visitor, HttpSession session){
        Visitor visitor1 = iVisitorService.queryByNamePassword(visitor);
        session.setAttribute("user",visitor1);
        if(visitor1.getCls()==0){
            return "manager/manager";
        }else if(visitor1.getCls()==1){
            return "visitor/visitor";
        }else{
            return "employee/employee";
        }
    }
    @RequestMapping("getRecruit")
    @ResponseBody
    public String getRecruit(HttpServletRequest request){
        List<Recruit> list = iRecruitService.queryAll();
        request.setAttribute("recruit",list);
        String json = JSON.toJSONString(list);
        System.out.println(json);
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
    public String visitor(){
        return "visitor/visitor";
    }
    @RequestMapping("visitor1")
    public String visitor1(){
        return "visitor/visitor1";
    }
    @RequestMapping("visitor2")
    public String visitor2(){
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
