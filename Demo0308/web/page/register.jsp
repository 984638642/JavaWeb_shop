<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/03/08
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <style type="text/css">
        .tip {
            color: red;
            display: none;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $("#username").blur(function () {
                usernameTip();
            });
            $("#password").blur(function () {
                passwordTip();
            });
            $("#repwd").blur(function () {
                repwdTip();
            });
            $("#email").blur(function () {
                emailTip();
            });
            $("#code").blur(function () {
                codeTip();
            });
            $("#sub_btn").click(function () {
                var onTip=true;
                if(!usernameTip()){
                    onTip=false;
                }
                if(!passwordTip()){
                    onTip=false;
                }
                if(!repwdTip()){
                    onTip=false;
                }
                if(!emailTip()){
                    onTip=false;
                }
                if(!codeTip()){
                    onTip=false;
                }
                return onTip;
            });
        });

        function usernameTip() {
            var username = $("#username").val();
            if (!(/\w{5,12}/.test(username))) {
                $("#username+span").css("display", "inline");
                return false;
            } else {
                $("#username+span").css("display", "none");
                return true;
            }
        }

        function passwordTip() {
            var password = $("#password").val();
            if (!(/\w{5,12}/.test(password))) {
                $("#password+span").css("display", "inline");
                return false;
            } else {
                $("#password+span").css("display", "none");
                return true;
            }
        }

        function repwdTip() {
            var password = $("#password").val();
            var repwd = $("#repwd").val();
            if ((password != repwd) || !repwd) {
                $("#repwd +span").css("display", "inline");
                return false;
            } else {
                $("#repwd +span").css("display", "none");
                return true;
            }
        }

        function emailTip() {
            var email = $("#email").val();
            if (!(/\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/.test(email))) {
                $("#email +span").css("display", "inline");
                return false;
            } else {
                $("#email+span").css("display", "none");
                return true;
            }
        }

        function codeTip() {
            var code = $("#code").val();
            if (!code) {
                $("#code + img + span").css("display", "inline");
                return false;
            } else {
                $("#code + img + span").css("display", "none");
                return true;
            }
        }

        function imgClick() {
            $("#img").prop("src", "http://localhost:8080/VerifyCode.do?" + new Date());
        }
    </script>
</head>
<body>
<div class="form">
    <form action="/page/test.jsp" method="post">
        <label>用户名称：</label>
        <input type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"/>
        <span class="tip">必须由字母，数字下划线组成，并且长度为5到12位!</span>
        <br/>
        <br/>
        <label>用户密码：</label>
        <input type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password"/>
        <span class="tip">必须由字母，数字下划线组成，并且长度为5到12位!</span>
        <br/>
        <br/>
        <label>确认密码：</label>
        <input type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
        <span class="tip">和密码不相同!</span>
        <br/>
        <br/>
        <label>电子邮件：</label>
        <input type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"/>
        <span class="tip">例如：xxxxx@xxx.com!</span>
        <br/>
        <br/>&nbsp;&nbsp;
        <label>验证码：</label>
        <input type="text" placeholder="请输入验证码" id="code"/>
        <img src="http://localhost:8080/VerifyCode.do" id="img" onclick="imgClick()">
        <span class="tip">验证码不得为空!</span>
        <br/>
        <br/>
        <input type="submit" value="注册" id="sub_btn"/>
    </form>
</div>
</body>
</html>
