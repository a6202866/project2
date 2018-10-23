<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11 0011
  Time: 下午 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员平台</title>
    <style>
        * { margin: 0; padding: 0; }
        html { height: 100%; }
        body { height: 100%; background: #fff url(/images/backgroud.png) 50% 50% no-repeat; background-size: cover;}
        .dowebok { position: absolute; left: 40%; top: 50%; width: 1200px; height: 600px; margin: -260px 50px 50px -405px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(/images/login.png) 0 0 no-repeat; }
        tem1 { width: 200px; height: 60px; border: 0; border-radius: 25px; font-size: 25px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>
    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l8").addClass('active');

        })
    </script>
</head>
<body>
<jsp:include page="/managerModel.jsp"></jsp:include>
<h1 align="center" style="color: palevioletred">薪资异议管理</h1>
<div class="dowebok" style="background-color: #bce8f1">
    <table id="tb1" class="table table-hover" style="background-color: white">
        <tr>
            <td align="center">编号</td>
            <td align="center">姓名</td>
            <td align="center">异议原因</td>
            <td align="center" >异议时间</td>
            <td align="center">操作</td>
        </tr>
        <c:forEach items="${sessionScope.reasons}" var="reason">
            <tr>
                <td align="center">${reason.id}</td>
                <td align="center">${reason.name}</td>
                <td align="center">${reason.reason}</td>
                <td align="center" ><fmt:formatDate value="${reason.date}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                <td align="center" ><a href="/Manager/empDetail1?username=${reason.username}">奖</a>&nbsp;&nbsp;&nbsp;&nbsp;<a  href="/Manager/delReason?id=${reason.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
