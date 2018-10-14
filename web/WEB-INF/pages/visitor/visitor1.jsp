<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11 0011
  Time: 下午 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<html>
<head>
    <title>游客平台</title>
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
        .form-item1 { width: 200px; height: 60px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>

    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
        })
    </script>
</head>
<body>
<jsp:include page="/visitorModel.jsp"></jsp:include>
<h1 align="center" style="color: palevioletred">反馈</h1>
<div id="t2" class="dowebok" style="background-color: white">
    <form action="/Manager/sendInterview">
        <table class="table table-hover" style="border: whitesmoke" border="1px" cellspacing="10px" cellpadding="10px" >
            <tr>
                <td>公司名</td>
                <td>公司地址</td>
                <td>面试职位</td>
                <td>面试时间</td>
            </tr>
            <c:forEach items="${sessionScope.informs}" var="inform">
                <tr>
                    <td>${inform.name}</td>
                    <td>${inform.address}</td>
                    <td>${inform.position}</td>
                    <td><fmt:formatDate value="${inform.date}"  pattern="yyyy-MM-dd"></fmt:formatDate></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
