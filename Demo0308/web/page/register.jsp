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
        <label>???????????????</label>
        <input type="text" placeholder="??????????????????" autocomplete="off" tabindex="1" name="username" id="username"/>
        <span class="tip">?????????????????????????????????????????????????????????5???12???!</span>
        <br/>
        <br/>
        <label>???????????????</label>
        <input type="password" placeholder="???????????????" autocomplete="off" tabindex="1" name="password" id="password"/>
        <span class="tip">?????????????????????????????????????????????????????????5???12???!</span>
        <br/>
        <br/>
        <label>???????????????</label>
        <input type="password" placeholder="????????????" autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
        <span class="tip">??????????????????!</span>
        <br/>
        <br/>
        <label>???????????????</label>
        <input type="text" placeholder="?????????????????????" autocomplete="off" tabindex="1" name="email" id="email"/>
        <span class="tip">?????????xxxxx@xxx.com!</span>
        <br/>
        <br/>&nbsp;&nbsp;
        <label>????????????</label>
        <input type="text" placeholder="??????????????????" id="code"/>
        <img src="http://localhost:8080/VerifyCode.do" id="img" onclick="imgClick()">
        <span class="tip">?????????????????????!</span>
        <br/>
        <br/>
        <input type="submit" value="??????" id="sub_btn"/>
    </form>
</div>
</body>
</html>
