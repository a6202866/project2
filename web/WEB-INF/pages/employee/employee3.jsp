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
        .dowebok { position: absolute; left: 50%; top: 50%; width: 430px; height: 550px; margin: -300px 0 0 -215px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(/images/login.png) 0 0 no-repeat; }
        .form-item { position: relative; width: 360px; margin: 0 auto; padding-bottom: 30px;}
        .form-item input { width: 288px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .form-item button { width: 360px; height: 50px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>

    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l1").removeClass();
            $("#l3").addClass('active');
            $("#ipt3").blur(function () {
                if($("#ipt2").val()!=$("#ipt3").val()){
                    $("#sp1").show();
                    $("#btn1").attr('disabled',true);
                }else {
                    $("#sp1").hide();
                    $("#btn1").attr('disabled',false);
                }
            })
            $("#ipt2").blur(function () {
                if($("#ipt2").val()!=$("#ipt3").val()){
                    $("#sp1").show();
                    $("#btn1").attr('disabled',true);
                }else {
                    $("#sp1").hide();
                    $("#btn1").attr('disabled',false);
                }
            })
            $("#btn1").click(function () {
                if($("#ipt1").val()!=${sessionScope.user.password}){
                    alert("原密码错误");
                    return false;
                }else {
                    alert("修改成功！");
                }
            })
        })
    </script>
</head>
<body>
<jsp:include page="/employeeModel.jsp"></jsp:include>
<div class="dowebok">
    <br><br><br>
    <form action="/Visitor/changePassword1">
        <div  class="form-item">
            <p style="font-size: large;color:whitesmoke">请输入原密码:</p><br>
            <input type="text" name="name" value="${sessionScope.user.name}" hidden>
            <input id="ipt1" type="text" class="form-control" >
        </div>
        <div class="form-item">
            <p style="font-size: large;color:whitesmoke">请输入新密码:</p>
            <input id="ipt2" name="password" type="text" class="form-control">
        </div>

        <div class="form-item">
            <p style="font-size: large;color:whitesmoke">再输次新密码:</p>
            <input id="ipt3" type="text" class="form-control">
            <span id="sp1" style=" font-size:larger;color: coral" hidden>新密码不一致！</span>
        </div>
        <div class="form-item">
            <button id="btn1" type="submit">提交</button>
        </div>
    </form>
</div>
</body>
</html>
