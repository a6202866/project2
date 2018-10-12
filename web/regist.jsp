
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>游客注册界面</title>
    <script src="images/jquery.min.js"></script>
    <script>
        $(function () {
            $("#name").blur(function () {
                var name = $("#name").val();
                $.ajax({
                    url:"/Visitor/queryByName",
                    data:{name:name},
                    success:function (data) {
                        if(data=="1"){
                            $("#tip1").show();
                            $("#submit").attr('disabled',true);
                            $("#submit").css({'background-color':'red'});
                        }else {
                            $("#tip1").hide();
                            $("#submit").attr('disabled',false);
                            $("#submit").css({'background-color':'white'});
                        }
                    }
                })
            })


            $("#password1").blur(function () {
                if($("#password").val()!=$("#password1").val()){
                    $("#tip").show();
                    $("#submit").attr('disabled',true);
                    $("#submit").css({'background-color':'red'});
                }else {
                    $("#tip").hide();
                    $("#submit").attr('disabled',false);
                    $("#submit").css({'background-color':'white'});
                }
            })
        })
    </script>
    <style>
        * { margin: 0; padding: 0; }
        html { height: 100%; }
        body { height: 100%; background: #fff url(images/backgroud.png) 50% 50% no-repeat; background-size: cover;}
        .dowebok { position: absolute; left: 50%; top: 50%; width: 430px; height: 550px; margin: -300px 0 0 -215px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(images/login.png) 0 0 no-repeat; }
        .form-item { position: relative; width: 360px; margin: 0 auto; padding-bottom: 30px;}
        .form-item input { width: 288px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .form-item button { width: 360px; height: 50px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }
        #username { background: url(images/emil.png) 20px 14px no-repeat; }
        #password { background: url(images/password.png) 23px 11px no-repeat; }
        .tip { display: none; position: absolute; left: 20px; top: 52px; font-size: 14px; color: #f50; }
        .reg-bar { width: 360px; margin: 20px auto 0; font-size: 14px; overflow: hidden;}
        .reg-bar a { color: #fff; text-decoration: none; }
        .reg-bar a:hover { text-decoration: underline; }
        .reg-bar .reg { float: left; }
        .reg-bar .forget { float: right; }
        .dowebok ::-webkit-input-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok :-moz-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok ::-moz-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok :-ms-input-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}

        @media screen and (max-width: 500px) {
            * { box-sizing: border-box; }
            .dowebok { position: static; width: auto; height: auto; margin: 0 30px; border: 0; border-radius: 0; }
            .logo { margin: 50px auto; }
            .form-item { width: auto; }
            .form-item input, .form-item button, .reg-bar { width: 100%; }
        }
    </style>

</head>
<body>
    <div class="dowebok">
        <div class="logo"></div>
        <form action="Visitor/regist">
        <div class="form-item">
            <input id="name" type="text" name = "name" autocomplete="off" placeholder="请输入用户名">
            <p id="tip1" align="center" style="color:coral;font-size: larger" hidden>账号已被注册</p>
        </div>
        <div class="form-item">
            <input id="password" name="password" type="password" autocomplete="off" placeholder="请输入登录密码">
        </div>
            <div class="form-item">
                <input  id="password1" type="password" autocomplete="off" placeholder="请再输入登录密码">
                <p id="tip" align="center" style="color:coral;font-size: larger" hidden>密码不一致</p>
            </div>
            <div class="form-item"><button id="submit">注 册</button></div>
        </form>
    </div>

</body>
</html>