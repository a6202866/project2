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
            $("#l11").addClass('active');

        })
    </script>
</head>
<body>
    <jsp:include page="/managerModel.jsp"></jsp:include>
    <h1 align="center" style="color: palevioletred">招聘详情</h1>
    <div class="dowebok" style="background-color: #bce8f1">
    <table class="table table-hover" style="background-color: white">
        <tr>
            <td align="center">ID</td>
            <td align="center">公司名</td>
            <td align="center">公司地址</td>
            <td align="center">招聘部门</td>
            <td align="center">招聘职位</td>
            <td align="center">招聘薪水</td>
            <td colspan="2" align="center">操作</td>
        </tr>
        <c:forEach items="${sessionScope.recruits}" var="recruit">
            <tr>
                <td align="center">${recruit.id}</td>
                <td align="center">${recruit.name}</td>
                <td align="center">${recruit.address}</td>
                <td align="center">${recruit.dept}</td>
                <td align="center">${recruit.position}</td>
                <td align="center">${recruit.salary}</td>
                <td align="center"><a href="/Manager/updateRecruit?id=${recruit.id}">修改</a></td>
                <td align="center"><a href="/Manager/deleteRecruit?id=${recruit.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    </div>
</body>
</html>
