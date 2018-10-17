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
    <title>员工平台</title>
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
        .form-item1 { width: 200px; height: 60px; border: 0; border-radius: 25px; font-size: 25px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>
    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l5").addClass('active');
            $(".depttoposition").click(function () {
                var dept = $(this).text();
                $.ajax({
                    url:"/Manager/findByDept",
                    contentType: "json; charset=utf-8",
                    data:{dept:dept},
                    success:function (data) {
                        if(data!=0){
                            $("#t1 tr").remove();
                            $("#t1").append("<tr><td align='center'><span style='font-size:xx-large'>职位</span></td></tr>");
                            for(var i = 0;i<data.length;i++){
                                $("#t1").append("<tr><td align='center'><span style='font-size: x-large'>"+data[i].position+"</span></td></tr>")
                            }
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
    <jsp:include page="/employeeModel.jsp"></jsp:include>
    <h1 align="center" style="color: palevioletred">部门职位</h1>
    <c:forEach items="${sessionScope.dept}" var="dept">
        <br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button class="form-item1"><a class="depttoposition">${dept.dept}</a></button><br><br>
    </c:forEach>
    <div id="t2" class="dowebok" style="background-color: white">
        <table id="t1" class="table table-hover"></table>
    </div>
</body>
</html>
