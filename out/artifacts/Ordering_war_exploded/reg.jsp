<%--
  Created by IntelliJ IDEA.
  User: Dodd
  Date: 2015/4/17
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="res/jquery.js"></script>
    <script type="text/javascript">
        var code = (Math.random() * 10000) % 10000;
        while (code < 1000) {
            code = (Math.random() * 10000) % 10000;
        }
        code = parseInt(code);
        $(document).ready(function () {
            $("#getcode").click(function () {
                if (document.getElementById("loginid").value != "") {
                    $.ajax({url: "/sendemail?code=" + code + "&email=" + document.getElementById("loginid").value});
                } else {
                    document.getElementById("loginid").focus();
                    alert("邮箱不能为空！")
                }
            })
        });
        function loginblur(d) {
            var s = d.value;
            var regBox = {
                regEmail: /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/,//邮箱
                regMobile: /^0?1[3|4|5|8][0-9]\d{8}$/,//手机
                regTel: /^0[\d]{2,3}-[\d]{7,8}$/
            }
            if (regBox.regEmail.test(s) || regBox.regMobile.test(s)) {
                return true;
            } else {
                alert("请输入正确的邮箱地址或手机号。");
                return false;
            }
        }
        function sbmt() {
            var username = document.getElementById("username");
            var userage = document.getElementById("userage");
            var recode = document.getElementById("recode");
            var usertel = document.getElementById("teltext");
            var usermail = document.getElementById("loginid");
            var userps = document.getElementById("userps");
            if (userage.value == "" || usermail.value == "" || userps.value == "" || recode.value == "" || usertel.value == "" || recode.value == "") {
                alert("请输入信息");
            } else if (parseInt(recode.value) != code) {
                alert("请输入正确的验证码！");
            } else {
                document.forms["reg"].submit();
            }
        }
    </script>
    <script type="text/javascript">

    </script>
    <link type="text/css" rel="stylesheet" href="css/reg.css">
</head>
<body>
<header>
</header>
<div class="content">
    <form action="reg" method="post" class="formclass" id="reg">
        <input type="text" placeholder="请输入邮箱" name="email" id="loginid" onblur="loginblur(this)" class="">
        <br/>
        <input type="password" placeholder="请输入密码" name="pswd" id="userps">
        <span></span>
        <button id="getcode" type="button" class="">发送验证码到邮箱</button>
        <br/>
        <input type="text" placeholder="验证码" id="recode"><br/>
        <input type="text" name="username" placeholder="昵称" id="username"><br>
        <input type="tel" name="tel" placeholder="手机号" id="teltext"><br>
        <input type="number" name="age" placeholder="年龄" id="userage"><br>
        <input type="button" value="注册" onclick="sbmt()">
    </form>
</div>
<footer></footer>
</body>
</html>
