package com.lxd.project2.controller;

import com.lxd.project2.entity.Employee;
import com.lxd.project2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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
    @RequestMapping("employee")
    public String employee(){
        return "employee/employee";
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
    @RequestMapping("employee3")
    public String employee3(){
        return "employee/employee3";
    }
    @RequestMapping("employee4")
    public String employee4(){
        return "employee/employee4";
    }
    @RequestMapping("employee5")
    public String employee5(){
        return "employee/employee5";
    }
    @RequestMapping("employee6")
    public String employee6(){
        return "employee/employee6";
    }
}
