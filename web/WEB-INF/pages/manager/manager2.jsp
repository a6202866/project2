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
        .dowebok { position: absolute; left: 40%; top: 50%; width: 1200px; height: 600px; margin: -260px 50px 50px -405px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(/images/login.png) 0 0 no-repeat; }

    </style>

    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l2").addClass('active');

        })
    </script>
</head>
<body>
    <jsp:include page="/managerModel.jsp"></jsp:include>
    <h1 align="center" style="color: palevioletred">应聘管理</h1>
    <div class="dowebok" style="background-color: #bce8f1">
    <table class="table table-hover" style="background-color: white">
        <tr>
            <td>ID</td>
            <td>应聘者</td>
            <td>投递时间</td>
            <td>查看状态</td>
            <td>面试状态</td>
            <td colspan="2" align="center">操作</td>
        </tr>
        <c:forEach items="${sessionScope.interview}" var="interview">
            <tr>
                <td>${interview.id}</td>
                <td>${interview.name}</td>
                <td><fmt:formatDate value="${interview.date}" pattern="yyyy-MM-dd"/></td>
                <td>${interview.look}</td>
                <td>${interview.interview}</td>
                <td><a href="/Manager/lookInterview?username=${interview.username}&interviewID=${interview.id}">查看</a></td>
                <td><a href="/Manager/deleteInterview?username=${interview.username}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    </div>
</body>
</html>
