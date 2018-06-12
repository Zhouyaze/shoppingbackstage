<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>添加新会员</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="js/jquery.js"></script>
 <script type="text/javascript">
  function jiazai() {
      $.ajax({
          type: "GET",
          contentType:"application/json; charset=utf-8",
          url: 'http://localhost:8080/getUserType',
          data: {},
          async: false,
          success: function (data) {
              var option = null;
              var temp= document.getElementById("userTypeName");
              console.log(data)
              for (var i = 0; i < data.length; i++) {
                  option = document.createElement("option");
                  option.appendChild(document.createTextNode(option.vaule =data[i].userTypeName));
                  option.vaule =data[i].userTypeName
                  temp.appendChild(option);
              }
          }
      });
  }
  function tijiao() {

      var form = new FormData(document.getElementById("form"));
      $.ajax({
          url:"${pageContext.request.contextPath}/userAdd?authenticationId=0",
          type:"post",
          data:form,
          processData:false,
          contentType:false,
          success:function(data){
              alert(data)
              window.location.href="user_list.jsp"
          },
          error:function(e){
              alert(e);
              window.location.href="user_list.jsp"
          }
      });
  }
  // function showImg() {
      var reader = new FileReader();
      function showImg(file){
          var img = document.getElementById('imgHeader');
          //读取File对象的数据
          reader.onload = function(evt){
              //data:img base64 编码数据显示
              img.width  =  "100";
              img.height =  "100";
              img.src = evt.target.result;
          }
          reader.readAsDataURL(file.files[0]);
  }
 </script>
</head>
<body onload="jiazai()">
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add_user"></i><em>添加新会员</em></span>
  </div>
  <form id="form" method="post" enctype="multipart/form-data" target="ajaxFrame">
  <table class="list-style">
   <tr>
    <td style="width:15%;text-align:right;">会员昵称：</td>
    <td><input name="nickName" id="nickName" type="text" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">会员帐号：</td>
    <td><input name="loginName" id="loginName" type="text" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">会员等级</td>
    <td>
     <select id="userTypeName" name="userTypeName" class="textBox">
      <option>请选择会员等级</option>
     </select>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">选择头像：</td>
    <td><input onchange="showImg(this)" name="File" id="headPortraitUrl" type="file" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;width: 100px;height: 100px">头像预览</td>
    <td><img src="" id="imgHeader" alt=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;">设置密码：</td>
    <td><input id="logingPassword" type="password" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">确认密码：</td>
    <td><input name="logingPassword" type="password" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <!--onclick="tijiao()"-->
    <td><input onclick="tijiao()" type="submit" class="tdBtn" value="添加新用户"/></td>
   </tr>
  </table>
  </form>
  <iframe id="ajaxFrame" name="ajaxFrame" style="display:none;"></iframe>
 </div>
</body>
</html>