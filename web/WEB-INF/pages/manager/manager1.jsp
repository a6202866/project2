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
        .dowebok { position: absolute; left: 40%; top: 50%; width: 700px; height: 400px; margin: -200px 50px 50px -155px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(/images/login.png) 0 0 no-repeat; }
        .form-item { position: relative; width: 360px; margin: 0 auto; padding-bottom: 30px;}
        .form-item input { width: 288px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .form-item1 { width: 300px; height: 50px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }
        .dowebok1{ font-size: 18px; line-height: 1.4; color: #fff;}
    </style>
    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script>
        $(function () {
            $("#l1").addClass('active');
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
            $("#btn1").click(function () {
                alert("发布信息成功!")
            })
            })
        })
    </script>
</head>
<body>
    <jsp:include page="/managerModel.jsp"></jsp:include>
    <br><br>
    <h1 align="center" style="color: whitesmoke">员工招聘表</h1>
    <div class="dowebok">
            <form action="/Manager/zp">
            <table class="table table-bordered">

                <tr>
                    <td><span style="color: white;font-size: larger">公司:</span></td>
                    <td><input  class="form-item" type="text" name="name"></td>
                </tr>
                <tr>
                    <td><span style="color: white;font-size: larger">地址:</span></td>
                    <td><input type="text" class="form-item" name="address"></td>
                </tr>
                <tr>
                    <td><span style="color: white;font-size: larger">招聘:</span></td>
                    <td><select class="form-control" id="sel1" name="dept">
                        <option>--请选择--</option>
                        <c:forEach items="${requestScope.dept}" var="dept">
                            <option>${dept.dept}</option>
                        </c:forEach>
                    </select>
                        <select id="sel2" class="form-control" name ="position" >
                            <option>--请选择--</option>
                    </select></td>
                </tr>
                <tr>
                    <td><span style="color: white;font-size: larger">薪资:</span></td>
                    <td><input class="form-item" type="text" name="salary"></td>
                </tr>
        </table>
                <br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button id="btn1" class="form-item1" type="submit">招聘</button>
                <button class="form-item1">返回</button>
            </form>
        </div>

</body>
</html>
