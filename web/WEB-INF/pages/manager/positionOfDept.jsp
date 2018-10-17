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
        .form-item1 { width: 200px; height: 60px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>
    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l3").addClass('active');
            $(".delposition").click(function () {
                var x =$(this).parents().parents().children()[0];
                var y = $(x);
                var z = y.children()[0].innerHTML;
                var employeeAll = $("#employeeAll").val();
                if(employeeAll.indexOf(z)>0){
                    alert("该职位下还有员工，请确认无员工再删除")
                    return false;
                }else {
                    alert("删除成功！")
                }
            })
        })
    </script>
</head>
<body>
    <jsp:include page="/managerModel.jsp"></jsp:include>
    <h1 align="center" style="color: palevioletred">${sessionScope.dept1}</h1>
    <div id="t2" class="dowebok" style="background-color: white">
        <input  id="employeeAll" type="text" value="${sessionScope.employeeAll}" hidden>
        <form action="/Manager/sendInterview">
            <table class="table table-hover" style="border: whitesmoke" border="1px" cellspacing="10px" cellpadding="10px" >
                <tr>
                    <td align="center">职位</td>
                    <td align="center">创建时间</td>
                    <td align="center">操作 <a href="/Manager/addUpdatePosition?dept=${sessionScope.dept1}" class="nav navbar-nav navbar-right">增加职位 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
                </tr>
                <c:forEach items="${sessionScope.positionOfDept}" var="position">
                    <tr>
                        <td align="center"><a>${position.position}</a></td>
                        <td align="center"><fmt:formatDate value="${position.date}"  pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td align="center">
                            <input type="text" value="${position.id}" hidden>
                                <a href="/Manager/addUpdatePosition?position=${position.position}&id=${position.id}&dept=${sessionScope.dept1}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="delposition" href="/Manager/deletePosition?position=${position.position}&id=${position.id}&dept=${sessionScope.dept1}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
</body>
</html>
