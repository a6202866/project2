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
            <a class="navbar-brand" href="/Employee/employee">主页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li id="l1"><a href="/Employee/employee1">个人信息</a></li>
                <li id="l2"><a href="/Employee/employee2">我的考勤 <span class="sr-only">(current)</span></a></li>
                <li id="l3"><a href="/Employee/employee3">修改密码</a></li>
                <li id="l4"><a href="/Employee/employee4">我的奖惩</a></li>
                <li id="l5"><a href="/Employee/employee5">部门职位</a></li>
                <li id="l6"><a href="/Employee/employee6">培训学习</a></li>
                <li id="l7"><a href="/Employee/employee7">我的薪资</a></li>

                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">

                <li id="l8"><a href="/Employee/employee8">上班签到</a></li>
                <li id="l9"><a href="/Employee/employee9">下班签到</a></li>
                <li id="l0"><a href="#">退出</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>
