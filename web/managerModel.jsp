<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11 0011
  Time: 下午 5:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/js/bootstrap.min.css" rel="stylesheet">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/Manager/manager">主页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li id="l1"><a href="/Manager/manager1">写招聘</a></li>
                <li id="l2"><a href="/Manager/manager2">应聘管理 <span class="sr-only">(current)</span></a></li>
                <li id="l3"><a href="/Manager/manager3">部门职位</a></li>
                <li id="l4"><a href="/Manager/manager4">培训管理</a></li>
                <li id="l5"><a href="/Manager/manager5">员工管理</a></li>
                <li id="l6"><a href="/Manager/manager6">奖惩管理</a></li>
                <li id="l7"><a href="/Manager/manager7">薪资管理</a></li>
                <li id="l8"><a href="/Manager/manager8">工资异议</a></li>

                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li id="l0"><a href="#">退出</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>
