

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11 0011
  Time: 下午 4:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            $("#l7").addClass('active');
            $("#but1").click(function () {
                var date = $("#sele1").val()+"-"+$("#sele2").val();
                $.ajax({
                    url:"/Manager/seeSalary",
                    contentType: "json; charset=utf-8",
                    data:{date:date},
                    success:function (data) {
                        if(data!=0){
                            $("#tb1 tr:not(:first)").remove();
                            for(var i = 0;i<data.length;i++){
                                $("#tb1").append("<tr><td align='center'>"+data[i].id+"</td><td align='center'>"+
                                    data[i].name+"</td><td align='center'>"+
                                    data[i].allSalary+"</td><td align='center'>"+
                                    data[i].basicSalary+"</td><td align='center'>"+
                                    data[i].pSalary+"</td><td align='center'>"+
                                    data[i].overtimeSalary+"</td><td align='center'>"+
                                    data[i].checkSalry+"</td><td align='center'>"+
                                    data[i].socialSalary+"</td><td align='center'>"+data[i].date+
                                  "</td><tr>")
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
<h1 align="center" style="color: palevioletred">薪资管理</h1>
<div class="dowebok" style="background-color: #bce8f1">
    <table id="tb1" class="table table-hover" style="background-color: white">
        <tr>
            <td align="center">编号</td>
            <td align="center">姓名</td>
            <td align="center">总工资</td>
            <td align="center">基本工资</td>
            <td align="center" >绩效工资</td>
            <td align="center">加班工资</td>
            <td align="center">奖惩工资</td>
            <td align="center">社保</td>
            <td align="center">日期</td>
            <form action="/Manager/fSalary">
            <td align="center"><select id="sele1" name="year">
                <option>2016</option>
                <option>2017</option>
                <option>2018</option>
            </select>
                <select id="sele2" name="month">
                    <option>1</option><option>2</option><option>3</option>
                    <option>4</option><option>5</option><option>6</option>
                    <option>7</option><option>8</option><option>9</option>
                    <option>10</option><option>11</option><option>12</option>
                </select>
                <button id="but1" type="button">查看</button>
                <button id="but3" type="submit">发工资</button></td>
            </form>
        </tr>
        <c:forEach items="${sessionScope.allSalary}" var="Salary">
            <tr>
                <td align="center">${Salary.id}</td>
                <td align="center">${Salary.name}</td>
                <td align="center">${Salary.allSalary}</td>
                <td align="center">${Salary.basicSalary}</td>
                <td align="center" >${Salary.pSalary}</td>
                <td align="center" >${Salary.overtimeSalary}</td>
                <td align="center" >${Salary.checkSalry}</td>
                <td align="center" >${Salary.socialSalary}</td>
                <td align="center" >${Salary.date}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
