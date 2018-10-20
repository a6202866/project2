<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11 0011
  Time: 下午 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            $("#l4").addClass('active');
            $("#addT").click(function () {
                $(".addtarin").show();
            })
            $(".changeT").click(function () {
                var x = $(this).parents().parents().parents().children()[0];
                var y = $(x);
                var z = $($(this).parents().parents().parents().children()[1]);
                z.hide();
                y.show();
            })
            $(".date1").change(function () {
                $(".but1").attr("disabled",false);
            })
            $(".but1").click(function () {
                var x = new Date();
                var y = $(".date1").val();
                var cha = (Date.parse(x) - Date.parse(y)) / 86400000 * 24;
                if (cha > 0) {
                    alert("不能选择今天以前的时间");
                    return false;
                }
                else {
                    alert("发布成功！");
                }
            })

        })
    </script>
</head>
<body>
<jsp:include page="/managerModel.jsp"></jsp:include>
<h1 align="center" style="color: palevioletred">培训管理</h1>
<div class="dowebok" style="background-color: #bce8f1">
    <table  class="table table-hover" style="background-color: white">
        <tr>
            <td align="center">&nbsp;&nbsp;&nbsp;&nbsp;培训名称</td>
            <td  align="center">培训时间</td>
            <td  align="center">培训部门</td>

            <td  align="center">  <a id="addT">添加培训</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>操作</span></td>
        </tr>
        <form action="/Manager/addTrain">
            <tr class="addtarin" hidden>
                <td align="center"><input type="text" name="name"></td>
                <td align="center"><input type="date" name="date" class="date1"></td>
                <td align="center"><select name="dept">
                    <c:forEach items="${sessionScope.dept}" var="dept">
                        <option>${dept.dept}</option>
                    </c:forEach>
                </select></td>
                <td colspan="2" align="center"><button class="but1" type="submit" disabled>提交</button></td>
            </tr>
        </form>

        <c:forEach items="${sessionScope.train}" var="train">
            <table  class="table table-hover" style="background-color: white">
            <tr hidden><form action="/Manager/changeTrain"><input type="text" value="${train.id}" name="id" hidden>
                <td style="height: 40px;width: 100px" align="center"><input type="text" name="name"value="${train.name}"></td>
                <td  style="height: 40px;width: 100px" align="center"><input type="date" name="date" class="date1" ></td>
                <td style="height: 40px;width: 100px" align="center"><select name="dept">
                    <c:forEach items="${sessionScope.dept}" var="dept">
                        <option <c:if test="${dept.dept==train.dept}">selected</c:if>>${dept.dept}</option>
                    </c:forEach>
                </select></td>
                <td  style="height: 40px;width: 100px"align="center"><button class="but1" disabled>修改</button>&nbsp;&nbsp;&nbsp;</td>
            </form>
            </tr>
            <tr>
                <td style="height: 40px;width: 100px" align="center">${train.name}</td>
                <td  style="height: 40px;width: 100px"align="center"><fmt:formatDate value="${train.date}" pattern="yyyy-MM-dd"/></td>
                <td  style="height: 40px;width: 100px"align="center">${train.dept}</td>
                <td  style="height: 40px;width: 100px" align="center"><a class="changeT">修改</a>&nbsp;&nbsp;&nbsp;<a href="/Manager/delTrain?id=${train.id}">删除</a></td>
            </tr>
            </table>
        </c:forEach>
    </table>




</div>
</body>
</html>
