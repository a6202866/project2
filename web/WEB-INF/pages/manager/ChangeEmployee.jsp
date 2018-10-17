<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        .dowebok { position: absolute; left: 40%; top: 50%; width: 700px; height: 200px; margin: -250px 50px 50px -205px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(/images/login.png) 0 0 no-repeat; }
        .f1{ font-size: 20px; line-height: 1.4; color: #fff;}
        .f2{ font-size: 20px; line-height: 1.4; color: #fff;}
        .fp1 { width: 288px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 35px; color: #fff; background-color: transparent; outline: none;}
        .fp2 { width: 688px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .form-item1 { width: 150px; height: 50px; border: 0; border-radius: 25px; font-size: 33px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>
    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l5").addClass('active');
            $("#sel1").change(function () {
                var dept = $("#sel1").val();
                $.ajax({
                    url:"/Manager/findByDept",
                    contentType: "json; charset=utf-8",
                    data:{dept:dept},
                    success:function (data) {
                        if(data!=0){
                            $("#sel2 option").remove();
                            $("#sel2").append("<option>请选择</option>");
                            for(var i = 0;i<data.length;i++){
                                $("#sel2").append("<option>"+data[i].position+"</option>")
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
    <h1 align="center" style="color: palevioletred">人事调动</h1>
    <div id="t2" class="dowebok">
        <br><br>
        <form action="/Manager/changeEmp">
            &nbsp; <span style="color:white;font-size: x-large">请选择部门:</span>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <select class="form-control" id="sel1" name="dept">
                <option>--请选择--</option>
                <c:forEach items="${sessionScope.dept}" var="dept" >
                    <option>${dept.dept}</option>
                </c:forEach>
            </select>
            <select class="form-control" id="sel2" name="position">
                <option>--请选择--</option>
            </select>
            <input type="text" name="id" value="${sessionScope.changeEmployee.id}" hidden>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button class="form-item1" type="submit">修改</button>
        </form>
    </div>
</body>
</html>
