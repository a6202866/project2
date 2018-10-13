<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11 0011
  Time: 下午 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游客平台</title>
    <style>
        * { margin: 0; padding: 0; }
        html { height: 100%; }
        body { height: 100%; background: #fff url(/images/backgroud.png) 50% 50% no-repeat; background-size: cover;}
       .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(/images/login.png) 0 0 no-repeat; }
        .dowebok { position: absolute; left: 30%; top: 50%; width: 1000px; height: 550px; margin: -200px 50px 50px -155px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .form-item1 { width: 70px; height: 25px; border: 0; border-radius: 2px; font-size: 4px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }

    </style>

    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>

    <script src="js/bootstrap-table-zh-CN.min.js"></script>
    <script>

        $(function () {
            $("#l1").removeClass();
        })
       /* $(function () {
            $('#tb1').bootstrapTable({
                url: "/Visitor/getRecruit",         //请求后台的URL（*）
                method: 'post',                        //请求方式（*）
                contentType: "application/json; charset=utf-8",
                striped: true,                      //是否显示行间隔色
                sortOrder: "asc",                   //排序方式
                sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pagination: true,
                pageSize: 5,                       //每页的记录行数（*）
                minimumCountColumns: 2,             //最少允许的列数
                uniqueId: "processId",                     //每一行的唯一标识，一般为主键列
                cardView: false,                    //是否显示详细视图
                detailView: true,                   //是否显示父子表
                showExport: true,                     //是否显示导出
                exportDataType: "basic",              //basic', 'all', 'selected'.
                columns: [{
                    field: 'name',
                    title: '公司名称'
                },{
                    field: 'address',
                    title: '地址'
                }, {
                    field: 'dept',
                    title: '部门'
                }, {
                    field: 'position',
                    title: '职位'
                }, {
                    field: 'salary',
                    title: '薪资'
                },{
                    field:'xx',
                    title: '操作',
                    width: 120,
                    align: 'center',
                    valign: 'middle',
                    formatter: actionFormatter
                }],
            });
            function actionFormatter(value, row, index) {
                var id = value;
                var result = "";
                result += "<button id='addInterview' class='form-item1'><a  href='/Visitor/addInterview'>投递简历</a></button>";
                return result;
            }
        })*/
    </script>
</head>
<body>
<jsp:include page="/visitorModel.jsp"></jsp:include>
<br><br>
<h1 align="center" style="color: white">招聘信息</h1>
<div class="dowebok" style="background-color: white">
<table id="tb1" class="table" >
    <br>
    <form>
        <tr>
            <td>公司名称</td>
            <td>地址</td>
            <td>部门</td>
            <td>职位</td>
            <td>薪资</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.recruit}" var="recruit">
            <tr>
                <td>${recruit.name}</td>
                <td>${recruit.address}</td>
                <td>${recruit.dept}</td>
                <td>${recruit.position}</td>
                <td>${recruit.salary}</td>
                <td><a href="/Visitor/addInterview?recruitID=${recruit.id}&name=${recruit.name}">投递简历</a></td>
            </tr>
        </c:forEach>
    </form>
</table>

</div>

</body>
</html>
