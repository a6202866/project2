<%@ page import="java.util.List" %>
<%@ page import="com.lxd.project2.entity.Position" %>
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
        .form-item1 { width: 200px; height: 60px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>
    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l3").addClass('active');

            $(".del1").click(function () {
                var x = $(this).attr("href");
                x = x.substring(25,x.length);

                var y = $("#deptall").val()

                if(y.search(x)>0){
                    alert("该部门还有职位未删除");
                    return false;
                }
                alert("删除成功！");
            })
        })
    </script>
</head>
<body>
    <jsp:include page="/managerModel.jsp"></jsp:include>
    <h1 align="center" style="color: palevioletred">管理部门</h1>
    <div id="t2" class="dowebok" style="background-color: white">
        <form action="/Manager/sendInterview">
            <%List<Position> list = (List<Position>) session.getAttribute("position");%>
            <input type="text" id="deptall" value="${sessionScope.position}" hidden>
            <table class="table table-hover" style="border: whitesmoke" border="1px" cellspacing="10px" cellpadding="10px" >
                <tr>
                    <td align="center">部门</td>
                    <td align="center">创立时间</td>
                    <td align="center">操作 <a href="/Manager/addUpdateDept" class="nav navbar-nav navbar-right">增加部门 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></td>
                </tr>
                <c:forEach items="${sessionScope.dept}" var="dept">
                    <tr>
                        <td align="center"><a href="deptDetail?dept=${dept.dept}">${dept.dept}</a></td>
                        <td align="center"><fmt:formatDate value="${dept.date}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td align="center">
                            <a href="/Manager/addUpdateDept?dept=${dept.dept}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="del1" href="/Manager/deleteDept?dept=${dept.dept}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
</body>
</html>
