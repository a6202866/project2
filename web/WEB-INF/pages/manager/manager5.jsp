<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11 0011
  Time: 下午 4:22
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    </style>

    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l5").addClass('active');
            $("#sele1").change(function () {

                if($(this).val()=="在职员工"){
                    $(".tb1").show();
                    $(".tb2").hide();
                }
                if($(this).val()=="试用期"){
                    $(".tb2").show();
                    $(".tb1").hide();
                }
            })
            $(".deleteEmp").click(function () {
                var x = confirm("确认开除？")
                if(x==true){
                    alert("开除成功!");
                }else {
                    return false;
                }
            })
        })
    </script>
</head>
<body>
<jsp:include page="/managerModel.jsp"></jsp:include>
<h1 align="center" style="color: palevioletred">员工管理</h1>
<div class="dowebok" style="background-color: #bce8f1">
    <table  class="table table-hover" style="background-color: white">
        <tr>
            <td align="center">编号</td>
            <td align="center">姓名</td>
            <td align="center">部门</td>
            <td align="center">职位</td>
            <td colspan="2" align="center" ><span style="margin:0 0 0 150px">操作</span></td>
            <td align="center"><select id="sele1">
                <option>在职员工</option>
                <option>试用期</option>
            </select></td>
        </tr>

        <c:forEach items="${sessionScope.zzyg}" var="employee">
            <tr class="tb1">
                <td align="center">${employee.id}</td>
                <td align="center"><a href="/Manager/empDetail?id=${employee.id}">${employee.name}</a></td>
                <td align="center">${employee.dept}</td>
                <td align="center">${employee.position}</td>
                <td align="center"><a href="/Manager/changeEmployee?id=${employee.id}">人事调动</a></td>
                <td align="center"><a href="/Manager/seeCheck?username=${employee.username}">考勤</a></td>
                <td align="center"><a class="deleteEmp" href="/Manager/deleteEmployee?id=${employee.id}">开除</a></td>
            </tr>
        </c:forEach>

            <c:forEach items="${sessionScope.syq}" var="employee">
                <tr class="tb2" hidden>
                    <td align="center">${employee.id}</td>
                    <td align="center"><a href="/Manager/empDetail?id=${employee.id}">${employee.name}</a></td>
                    <td align="center">${employee.dept}</td>
                    <td align="center">${employee.position}</td>
                    <td align="center"><a href="/Manager/changeEmployee?id=${employee.id}">人事调动</a></td>
                    <td align="center"><a href="/Manager/seeCheck?username=${employee.username}">考勤</a></td>
                    <td align="center"><a class="deleteEmp" href="/Manager/deleteEmployee?id=${employee.id}">开除</a></td>
                </tr>
            </c:forEach>

    </table>




</div>
</body>
</html>
