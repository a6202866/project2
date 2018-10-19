<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11 0011
  Time: 下午 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<html>
<head>
    <title>管理员平台</title>
    <style>
        * { margin: 0; padding: 0; }
        html { height: 100%; }
        body { height: 100%; background: #fff url(/images/backgroud.png) 50% 50% no-repeat; background-size: cover;}
        .dowebok { position: absolute; left: 40%; top: 50%; width: 795px; height: 560px; margin: -250px 50px 50px -205px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(/images/login.png) 0 0 no-repeat; }
        .f1{ font-size: 20px; line-height: 1.4; color: #fff;}
        .f2{ font-size: 20px; line-height: 1.4; color: #fff;}
        .fp1 { width: 288px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .fp2 { width: 688px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .form-item1 { width: 200px; height: 50px; border: 0; border-radius: 25px; font-size: 28px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }
        .form-item2 { width: 150px; height: 50px; border: 0; border-radius: 10px; font-size: 22px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>

    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l2").addClass('active');
            $("#but1").click(function () {
                var x = new Date();
                var y = $("#date1").val();
                var cha = (Date.parse(x) - Date.parse(y)) / 86400000 * 24;
                if (cha > 0) {
                    alert("不能选择今天以前的时间");
                    return false;
                }
                else {
                    alert("预约成功！");
                }
            })
            $("#but2").click(function () {
                alert("录取成功！")
            })
            $("#date1").change(function () {
                $("#but1").attr("disabled",false);
            })
            $("#basicSalary").change(function () {
                $("#but2").attr("disabled",false);
            })
        })
    </script>
</head>
<body>
    <jsp:include page="/managerModel.jsp"></jsp:include>
    <h1 align="center" style="color: palevioletred">应聘管理</h1>
    <div id="t2" class="dowebok">
        <form action="/Manager/sendInterview">
        <table style="border: whitesmoke" border="1px" cellspacing="10px" cellpadding="10px" >
            <br>
                <input type="number" name="interviewID" value="${sessionScope.interviewID}" hidden>
                <input type="number" name="resumeID" value="${sessionScope.resume.id}" hidden>
                <input type="text" value="${sessionScope.user.name}" name="username" hidden >
                <tr>
                    <td class="f1"><span>姓名:</span></td>
                    <td><input class="fp1" type="text" value="${sessionScope.resume.name}" name="name" disabled></td>
                    <td class="f1"><span>年龄:</span></td>
                    <td><input class="fp1" type="text" value="${sessionScope.resume.age}" name="age" disabled></td>
                </tr>
                <tr>
                    <td class="f1"><span>性别:</span></td>
                    <td><input class="fp1" type="text" value="${sessionScope.resume.sex}" name="sex" disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td class="f1"><span>学历:</span></td>
                    <td><input class="fp1" type="text"value="${sessionScope.resume.school}" name="school" disabled>&nbsp;&nbsp;&nbsp;</td>
                </tr>
                <tr>
                    <td class="f1"><span>手机:</span></td>
                    <td><input class="fp1" type="text"value="${sessionScope.resume.pnumber}"name="pnumber" disabled></td>
                    <td class="f1"><span>邮箱:</span></td>
                    <td><input class="fp1" type="text"value="${sessionScope.resume.email}" name="email" disabled></td>
                </tr>
                <tr>
                    <td class="f1"><span>应聘职位:</span></td>
                    <td><input class="fp1" type="text"value="${sessionScope.resume.position}" name="position" disabled></td>
                    <td class="f1"><span>期望薪资:</span></td>
                    <td><input class="fp1" type="text"value="${sessionScope.resume.salary}" name="salary" disabled></td>
                <tr>
                    <td class="f1"><span><br>拥有技能:<br><br></span></td>
                    <td><input class="fp1" type="text"value="${sessionScope.resume.skill}" name="skill" disabled></td>
                    <td class="f1"><span>政治面貌:</span></td>
                    <td><input class="fp1" type="text"value="${sessionScope.resume.politics}" disabled name="politics"></td>
                </tr>
                <tr>
                    <td class="f2"><span><br>工作经验:<br><br></span></td>
                    <td colspan="3"><input class="fp2" type="text"value="${sessionScope.resume.experience}" name="experience" disabled></td>
                </tr>
            <tr>
                <td class="f2"><span><br>面试日期:<br><br></span></td>
                <td align="center"><input class="fp1" id="date1" name="idate" type="date"></td>
                <td colspan="2" align="center"><button id="but1" class="form-item1" type="submit" disabled>面试</button>&nbsp;&nbsp;&nbsp;</td>
            </tr>
        </form>
            <tr>
                <form action="/Manager/admin">
                    <input type="number" name="interviewID" value="${sessionScope.interviewID}" hidden>
                    <input type="number" name="resumeID" value="${sessionScope.resume.id}" hidden>
                <td class="f2">录取工资:</td><td align="center"><input id="basicSalary" class="fp1" type="number" name="basicSalary"></td>
                <td colspan="2" align="center"><br>
                   <button  type="submit" id="but2"  class="form-item2" disabled>录取</button></form>
                <button type="button" class="form-item2" ><a href="/Manager/manager2">返回</a></button><br>&nbsp;&nbsp;&nbsp;</td>
            </tr>

        </table>




            </tr>

    </div>
</body>
</html>
