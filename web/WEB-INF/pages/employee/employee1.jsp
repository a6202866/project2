<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11 0011
  Time: 下午 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工平台</title>
    <style>
        * { margin: 0; padding: 0; }
        html { height: 100%; }
        body { height: 100%; background: #fff url(/images/backgroud.png) 50% 50% no-repeat; background-size: cover;}
        .dowebok { position: absolute; left: 40%; top: 50%; width: 782px; height: 465px; margin: -250px 50px 50px -205px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(/images/login.png) 0 0 no-repeat; }
        .f1{ font-size: 20px; line-height: 1.4; color: #fff;}
        .f2{ font-size: 20px; line-height: 1.4; color: #fff;}
        .fp1 { width: 288px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .fp2 { width: 688px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .form-item1 { width: 200px; height: 50px; border: 0; border-radius: 25px; font-size: 25px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>
    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l1").addClass('active');

        })
    </script>
</head>
<body>
<jsp:include page="/employeeModel.jsp"></jsp:include>
<h1 align="center" style="color: whitesmoke">个人信息</h1>
<div id="t2" class="dowebok">
    <table style="border: whitesmoke" border="1px" cellspacing="10px" cellpadding="10px" >
        <br>
        <form action="/Employee/updateEmployee">
            <input type="text" value="${sessionScope.employeeDetail.id}" name="id" hidden>
            <input type="text" value="${sessionScope.employeeDetail.username}" name="username" hidden>
            <input type="text" value="${sessionScope.employeeDetail.date}" name="date"hidden>
            <input type="text" value="${sessionScope.employeeDetail.state}" name="state" hidden>
            <tr>
                <td class="f1"><span><br>&nbsp;&nbsp;&nbsp;姓名:&nbsp;&nbsp;&nbsp;<br><br></span></td>
                <td><input class="fp1" type="text" value="${sessionScope.employeeDetail.name}" name="name"></td>
                <td class="f1"><span><br>&nbsp;&nbsp;&nbsp;年龄:&nbsp;&nbsp;&nbsp;<br><br></span></td>
                <td><input class="fp1" type="text" value="${sessionScope.employeeDetail.age}" name="age"></td>
            </tr>
            <tr>
                <td class="f1"><span><br>&nbsp;&nbsp;&nbsp;性别:&nbsp;&nbsp;&nbsp;<br><br></span></td>
                <td><input class="fp1" type="text" value="${sessionScope.employeeDetail.sex}" name="sex">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td class="f1"><span><br>&nbsp;&nbsp;&nbsp;学历:&nbsp;&nbsp;&nbsp;<br><br></span></td>
                <td><input class="fp1" type="text"value="${sessionScope.employeeDetail.school}" name="school">&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td class="f1"><span><br>&nbsp;&nbsp;&nbsp;手机:&nbsp;&nbsp;&nbsp;<br><br></span></td>
                <td><input class="fp1" type="text"value="${sessionScope.employeeDetail.pnumber}"name="pnumber"></td>
                <td class="f1"><span><br>&nbsp;&nbsp;&nbsp;邮箱:&nbsp;&nbsp;&nbsp;<br><br></span></td>
                <td><input class="fp1" type="text"value="${sessionScope.employeeDetail.email}" name="email"></td>
            </tr>
            <tr>
                <td class="f1"><span><br>&nbsp;&nbsp;&nbsp;部门:&nbsp;&nbsp;&nbsp;<br><br></span></td>
                <td class="f1"><input class="fp1" type="text"value="${sessionScope.employeeDetail.dept}" name="dept" disabled></td>
                <td class="f1"><span><br>&nbsp;&nbsp;&nbsp;职位:&nbsp;&nbsp;&nbsp;<br><br></span></td>
                <td class="f1"><input class="fp1" type="text"value="${sessionScope.employeeDetail.position}" name="position" disabled></td>
            <tr>
                <td class="f1" colspan="2" align="center">
                    <br><button id="but1" class="form-item1" type="submit">修改</button><br><br>
                </td>
                <td class="f1" colspan="2" align="center"><br><button class="form-item1" ><a href="/Employee/employee">取消</a></button><br><br></td>
            </tr>
        </form>
    </table>
</div>
</body>
</html>
