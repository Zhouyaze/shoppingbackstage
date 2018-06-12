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
            var temp= document.getElementById("select");
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
function baocun() {
            $.ajax({
                type: "GET",
                contentType:"application/json; charset=utf-8",
                url: 'http://localhost:8080/userUpdate?id='+params.id+"&nickName="+$("#nickName").val()+"&logingPassword="+$("#password").val()+"&userTypeName="+$("#select").val(),
                data: {},
                async: false,
                success: function (data) {
                    alert(data)
                        $.ajax({
                            async : false,
                            url:'http://localhost:8080/updateAuthentication?id='+params.authenticationId+"&userPhoneNumber="+$("#userPhoneNumber").val(),
                            type:'GET',
                            dataType:'json',
                            data:{},
                            success:function(){
                                window.location.href = "user_list.jsp";
                            },
                            fail:function () {
                                alert("修改失败")
                            }
                        })

                },
                fail:function () {
                    alert("修改失败")
                }
            });
}
 </script>
</head>
<body onload="chuanzhi()">
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="edit_user"></i><em>编辑会员资料</em></span>
  </div>
  <table class="list-style">
   <tr>
    <td style="width:15%;text-align:right;">会员昵称：</td>
    <td><input id="nickName" type="text" class="textBox length-middle" value="DeathGhost"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">手机号码：</td>
    <td><input id="userPhoneNumber" type="text" class="textBox length-middle" value=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;">会员等级：</td>
    <td>
     <select id="select" name="select" class="textBox">
      <option>请选择会员等级</option>
     </select>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">重置密码：</td>
    <td><input id="password" type="password" class="textBox length-middle" value=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;">确认密码：</td>
    <td><input type="password" class="textBox length-middle" value=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input onclick="baocun()" type="submit" class="tdBtn" value="更新保存"/></td>
   </tr>
  </table>
 </div>
</body>
</html>