<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>编辑会员资料</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />.
 <script type="text/javascript" src="js/jquery.js"></script>
 <script type="text/javascript">
function chuanzhi() {
    $.ajax({
        type: "GET",
        contentType:"application/json; charset=utf-8",
        url: 'http://localhost:8080/getUserType',
        data: {},
        async: false,
        success: function (data) {
            var option = null;
            var temp= document.getElementById("userTypeName");
            for (var i = 0; i < data.length; i++) {
                option = document.createElement("option");
                option.appendChild(document.createTextNode(option.vaule =data[i].userTypeName));
                option.vaule =data[i].userTypeName
                temp.appendChild(option);
            }
        }
    });
    var url=decodeURI(location.search)
    params={};
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            params[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }
    $("#nickName").val(params.nickName);
        $("#userPhoneNumber").val(params.userPhoneNumber)
    if (params.userPhoneNumber=="此用户还未实名认证"){
        $("#userPhoneNumber").attr("readOnly","true")
    }
    $("#select").val(params.userTypeName);
}

 </script>
 <script type="text/javascript">
     function baocun() {
         var form = new FormData(document.getElementById("form"));
         $.ajax({
             url:"${pageContext.request.contextPath}/userUpdate?id="+params.id,
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
     function showImg(file) {
         var img = document.getElementById('imgHeader');
         //读取File对象的数据
         reader.onload = function (evt) {
             //data:img base64 编码数据显示
             img.width = "100";
             img.height = "100";
             img.src = evt.target.result;
         }
         reader.readAsDataURL(file.files[0]);
     }
 </script>
</head>
<body onload="chuanzhi()">
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="edit_user"></i><em>编辑会员资料</em></span>
  </div>
  <form id="form" method="post" enctype="multipart/form-data" target="ajaxFrame">
  <table class="list-style">
   <tr>
    <td style="width:15%;text-align:right;">会员昵称：</td>
    <td><input name="nickName" id="nickName" type="text" class="textBox length-middle" value="DeathGhost"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">手机号码：</td>
    <td><input name="userPhoneNumber" id="userPhoneNumber" type="text" class="textBox length-middle" value=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;">会员等级：</td>
    <td>
     <select id="userTypeName" name="userTypeName" class="textBox">
      <option>请选择会员等级</option>
     </select>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">选择头像：</td>
    <td><input onchange="showImg(this)" name="file" id="headPortraitUrl" type="file" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;width: 100px;height: 100px">头像预览</td>
    <td><img src="" id="imgHeader" alt=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;">重置密码：</td>
    <td><input id="password" type="password" class="textBox length-middle" value=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;">确认密码：</td>
    <td><input name="logingPassword" type="password" class="textBox length-middle" value=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input onclick="baocun()" type="submit" class="tdBtn" value="更新保存"/></td>
   </tr>
  </table>
   </form>
  <iframe id="ajaxFrame" name="ajaxFrame" style="display:none;"></iframe>
 </div>
</body>
</html>