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
        .dowebok { position: absolute; left: 50%; top: 50%; width: 430px; height: 550px; margin: -300px 0 0 -215px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(/images/login.png) 0 0 no-repeat; }

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
                if($("#ipt1").val()!=${sessionScope.password}){
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
<jsp:include page="/visitorModel.jsp"></jsp:include>
<div class="dowebok">
    <form>
    请输入原密码:<br>
        <input type="text" name="name" value="${sessionScope.name}">
    <input id="ipt1" type="text" class="form-control" placeholder="Text input">
    请输入新密码:
    <input id="ipt2" name="password" type="text" class="form-control" placeholder="Text input">
    请在输入一次新密码:
    <input id="ipt3" type="text" class="form-control" placeholder="Text input">
    <span id="sp1" style="color: coral" hidden>新密码不一致！</span>
    <button id="btn1" type="submit">提交</button>
    </form>
</div>
</body>
</html>
