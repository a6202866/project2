package com.lxd.project2.controller;

import com.lxd.project2.entity.Visitor;
import com.lxd.project2.service.IVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/10/11 0011.
 */
@RequestMapping("Visitor")
@Controller
public class VisitorController {
    @Autowired
    private IVisitorService iVisitorService;
    @RequestMapping("queryByName")
    @ResponseBody
    public String queryByName(String name){
        if(iVisitorService.queryByName(name)!=null){
            return "1";
        }
        return "0";
    }
    @RequestMapping("regist")
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
    @RequestMapping("login")
    public String login(Visitor visitor){
        Visitor visitor1 = iVisitorService.queryByNamePassword(visitor);
        if(visitor1.getCls()==0){
            return "manager";
        }else if(visitor1.getCls()==1){
            return "visitor";
        }else{
            return "employee";
        }
    }
}
