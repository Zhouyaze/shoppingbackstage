<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="nofollow"/>
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<style>
body{width:100%;height:100%;overflow:hidden;background:url(images/pc_loginBg.jpg) no-repeat;background-size:cover;position:absolute;}
</style>
<script src="js/jquery.js"></script>
<script src="js/Particleground.js"></script>
<script>
$(document).ready(function() {
  $('body').particleground({
    dotColor:'green',
    lineColor:'#c9ec6e'
  });
  $('.intro').css({
    'margin-top': -($('.intro').height() /2)
  });
  $(".loginform input[type='button']").click(function(){
	  alert("登陆成功，程序对接时将其删除，此处测试！");
	  location.href="http://localhost:8080/login";
	  });
});
</script>

</head>
<body>
  <form class="loginform" action="/login" method="post">
   <h1>后台管理系统</h1>
   <ul>
    <li>
     <label>账号：</label>
     <input id="user" type="text" name="loginName" class="textBox" placeholder="管理员账号"/>
    </li>
    <li>
     <label>密码：</label>
     <input id="pwd" type="password" name="logingPassword" class="textBox" placeholder="登陆密码"/>
    </li>
    <li>
     <input type="submit" value="立即登陆" />
    </li>
   </ul>
  </form>
</body>
</html>