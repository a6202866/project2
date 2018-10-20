<%@ page import="com.lxd.project2.entity.Resume" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11 0011
  Time: 下午 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游客平台</title>
    <style>
        * { margin: 0; padding: 0; }
        html { height: 100%; }
        body { height: 100%; background: #fff url(/images/backgroud.png) 50% 50% no-repeat; background-size: cover;}
        .dowebok { position: absolute; left: 40%; top: 50%; width: 795px; height: 515px; margin: -250px 50px 50px -205px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(/images/login.png) 0 0 no-repeat; }
        .f1{ font-size: 20px; line-height: 1.4; color: #fff;}
        .f2{ font-size: 20px; line-height: 1.4; color: #fff;}
        .fp1 { width: 288px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .fp2 { width: 688px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .form-item1 { width: 200px; height: 40px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>

    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {

            $("#l1").removeClass();
            $("#l2").addClass('active');
            $("#sel1").change(function () {
                var dept = $("#sel1").val();
                $.ajax({
                    url:"/Visitor/findByDept",
                    contentType: "json; charset=utf-8",
                    data:{dept:dept},
                    success:function (data) {
                        if(data!=0){
                            $("#sel2 option").remove();
                            $("#sel2").append("<option>请选择</option>");
                            for(var i = 0;i<data.length;i++){
                                $("#sel2").append("<option>"+data[i].position+"</option>")
                            }
                        }
                    }
                })
            })
            $("#sel3").change(function () {
                var dept = $("#sel3").val();
                $.ajax({
                    url:"/Visitor/findByDept",
                    contentType: "json; charset=utf-8",
                    data:{dept:dept},
                    success:function (data) {
                        if(data!=0){
                            $("#sel4 option").remove();
                            $("#sel4").append("<option>请选择</option>");
                            for(var i = 0;i<data.length;i++){
                                $("#sel4").append("<option >"+data[i].position+"</option>")
                            }
                        }
                    }
                })
            })
            $("#but1").click(function () {
                alert("修改成功！")
            })
            $("#but2").click(function () {
                alert("保存成功！")
            })
        })
    </script>
</head>
<body>
<jsp:include page="/visitorModel.jsp"></jsp:include>
<h1 align="center" style="color: whitesmoke">我的简历</h1>
<%Resume resume = (Resume) session.getAttribute("resume");
    if(resume!=null){
   %> <div id="t2" class="dowebok">
    <table style="border: whitesmoke" border="1px" cellspacing="10px" cellpadding="10px" >
        <br>
        <form action="/Visitor/updateesume">
            <input type="text" value="${sessionScope.user.name}" name="username" hidden>
            <tr>
                <td class="f1"><span>&nbsp;&nbsp;&nbsp;姓名:&nbsp;&nbsp;&nbsp;</span></td>
                <td><input class="fp1" type="text" value="${sessionScope.resume.name}" name="name"></td>
                <td class="f1"><span>&nbsp;&nbsp;&nbsp;年龄:&nbsp;&nbsp;&nbsp;</span></td>
                <td><input class="fp1" type="text" value="${sessionScope.resume.age}" name="age"></td>
            </tr>
            <tr>
                <td class="f1"><span>&nbsp;&nbsp;&nbsp;性别:&nbsp;&nbsp;&nbsp;</span></td>
                <td><input class="fp1" type="text" value="${sessionScope.resume.sex}" name="sex">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td class="f1"><span>&nbsp;&nbsp;&nbsp;学历:&nbsp;&nbsp;&nbsp;</span></td>
                <td><input class="fp1" type="text"value="${sessionScope.resume.school}" name="school">&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td class="f1"><span>&nbsp;&nbsp;&nbsp;手机:&nbsp;&nbsp;&nbsp;</span></td>
                <td><input class="fp1" type="text"value="${sessionScope.resume.pnumber}"name="pnumber"></td>
                <td class="f1"><span>&nbsp;&nbsp;&nbsp;邮箱:&nbsp;&nbsp;&nbsp;</span></td>
                <td><input class="fp1" type="text"value="${sessionScope.resume.email}" name="email"></td>
            </tr>
            <tr>
                <td class="f1"><span><br>应聘职位:<br><br></span></td>
                <td><select class="form-control" id="sel3" name="dept">
                    <option>--请选择--</option>
                    <c:forEach items="${requestScope.dept}" var="dept">
                        <option <c:if test="${dept.dept==sessionScope.resume.dept}">selected</c:if>>${dept.dept}</option>
                    </c:forEach>
                </select>
                    <select id="sel4" class="form-control" name ="position" >
                        <option>--请选择--</option>
                        <c:forEach items="${sessionScope.positions}" var="position">
                        <option <c:if test="${position.position==sessionScope.resume.position}">selected</c:if>>${position.position}</option>
                    </c:forEach>
                    </select></td>
                <td class="f1"><span>期望薪资:</span></td>
                <td><input class="fp1" type="text"value="${sessionScope.resume.salary}" name="salary"></td>
            <tr>
                <td class="f1"><span><br>拥有技能:<br><br></span></td>
                <td><input class="fp1" type="text"value="${sessionScope.resume.skill}" name="skill"></td>
                <td class="f1"><span>政治面貌:</span></td>
                <td><input class="fp1" type="text"value="${sessionScope.resume.politics}" name="politics"></td>
            </tr>
            <tr>
                <td class="f2"><span><br>工作经验:<br><br></span></td>
                <td colspan="3"><input class="fp2" type="text"value="${sessionScope.resume.experience}" name="experience"></td>
            </tr>
            <tr>
                <td class="f1" colspan="2" align="center">
                    <br><button id="but1" class="form-item1" type="submit">修改</button><br><br>
                </td>
                <td class="f1" colspan="2" align="center"><br><button class="form-item1" ><a href="/Visitor/visitor">取消</a></button><br><br></td>
            </tr>
        </form>
    </table>
    </div>
<%}else{%> <div id="t1" class="dowebok" >

    <table style="border: whitesmoke" border="1px" cellspacing="10px" cellpadding="10px">
    <br>
    <form action="/Visitor/addResume">
    <input type="text" value="${sessionScope.user.name}" name="username" hidden>
    <tr>
    <td class="f1"><span>&nbsp;&nbsp;&nbsp;姓名:&nbsp;&nbsp;&nbsp;</span></td>
    <td><input class="fp1" type="text" value="请输入姓名" name="name"></td>
    <td class="f1"><span>&nbsp;&nbsp;&nbsp;年龄:&nbsp;&nbsp;&nbsp;</span></td>
    <td><input class="fp1" type="text" value="请输入年龄" name="age"></td>
    </tr>
    <tr>
    <td class="f1"><span>&nbsp;&nbsp;&nbsp;性别:&nbsp;&nbsp;&nbsp;</span></td>
    <td><input class="fp1" type="text" value="请输入性别" name="sex">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td class="f1"><span>&nbsp;&nbsp;&nbsp;学历:&nbsp;&nbsp;&nbsp;</span></td>
    <td><input class="fp1" type="text"value="请输入学历" name="school">&nbsp;&nbsp;&nbsp;</td>
    </tr>
    <tr>
    <td class="f1"><span>&nbsp;&nbsp;&nbsp;手机:&nbsp;&nbsp;&nbsp;</span></td>
    <td><input class="fp1" type="text"value="请输入手机号码" name="pnumber"></td>
    <td class="f1"><span>&nbsp;&nbsp;&nbsp;邮箱:&nbsp;&nbsp;&nbsp;</span></td>
    <td><input class="fp1" type="text"value="请输入邮箱" name="email"></td>
    </tr>
    <tr>
    <td class="f1"><span><br>应聘职位:<br><br></span></td>
    <td><select class="form-control" id="sel1" name="dept">
    <option>--请选择--</option>
    <c:forEach items="${requestScope.dept}" var="dept">
    <option>${dept.dept}</option>
    </c:forEach>
    </select>
    <select id="sel2" class="form-control" name ="position" >
    <option>--请选择--</option>
    </select></td>
    <td class="f1"><span>期望薪资:</span></td>
    <td><input class="fp1" type="text"value="请输入期望薪资" name="salary"></td>
    <tr>
    <td class="f1"><span><br>拥有技能:<br><br></span></td>
    <td><input class="fp1" type="text"value="请输入拥有技能" name="skill"></td>
    <td class="f1"><span>政治面貌:</span></td>
    <td><input class="fp1" type="text"value="请输入政治面貌" name="politics"></td>
    </tr>
    <tr>
    <td class="f2"><span><br>工作经验:<br><br></span></td>
    <td colspan="3"><input class="fp2" type="text"value="请输入工作经验" name="experience"></td>
    </tr>
    <tr>
    <td class="f1" colspan="2" align="center">
    <br><button class="form-item1" id="but2" type="submit">保存</button><br><br>
    </td>
        <td class="f1" colspan="2" align="center"><br><button class="form-item1"><a href="/Visitor/visitor">取消</a></button><br><br></td>
    </tr>
    </form>
    </table>
    </div><%}
%>

</body>
</html>
