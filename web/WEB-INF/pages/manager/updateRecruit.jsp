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
            $("#sel3").change(function () {
                var dept = $("#sel3").val();
                $.ajax({
                    url:"/Visitor/findByDept",
                    contentType: "json; charset=utf-8",
                    data:{dept:dept},
                    success:function (data) {
                        if(data!=0){
                            $("#sel4 option").remove();
                            for(var i = 0;i<data.length;i++){
                                $("#sel4").append("<option >"+data[i].position+"</option>")
                            }
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
    <jsp:include page="/managerModel.jsp"></jsp:include>
    <h1 align="center" style="color: palevioletred">招聘详情</h1>
    <div class="dowebok" style="background-color: #bce8f1">
    <table class="table table-hover" style="background-color: white">
        <tr>
            <td align="center" hidden>ID</td>
            <td align="center">公司名</td>
            <td align="center">公司地址</td>
            <td align="center">招聘部门</td>
            <td align="center">招聘职位</td>
            <td align="center">招聘薪水</td>
            <td align="center">操作</td>
        </tr>
        <form action="/Manager/changeRecruit">
            <tr>
                <td align="center" hidden><input type="text" value="${requestScope.changeR.id}" name="id" hidden></td>
                <td align="center"><input type="text" value="${requestScope.changeR.name}" name="name"></td>
                <td align="center"><input type="text" value="${requestScope.changeR.address}" name="address"></td>
                <td align="center">
                    <select id="sel3" name="dept">
                    <c:forEach items="${sessionScope.dept}" var="dept">
                        <option <c:if test="${dept.dept==requestScope.changeR.dept}">selected</c:if>>${dept.dept}</option>
                    </c:forEach>
                </select>
                <td align="center">
                <select id="sel4" name="position">
                <c:forEach items="${sessionScope.positions}" var="position">
                    <option <c:if test="${position.position==requestScope.changeR.position}">selected</c:if>>${position.position}</option>
                </c:forEach>
                </select>
                <td align="center"><input type="text" value="${requestScope.changeR.salary}" name="salary"></td>
                <td align="center"><button type="submit">修改</button></td>
            </tr>
        </form>
    </table>
    </div>
</body>
</html>
