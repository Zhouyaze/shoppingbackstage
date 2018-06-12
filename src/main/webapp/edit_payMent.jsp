<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/6/11
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改付款方式</title>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script type="text/javascript">
        $(document).ready(function updatePayMent() {
            var url=decodeURI(location.search)
            params = {};
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    params[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
            $("#payName").val(params.payWayName)
            $("#payImg").val(params.PictureUrl)
            $("#payInterface").val(params.payInterface)
            var radios = document.getElementsByName("status");
            for (var i=0;i<$("#status input[name=status]").length;i++){
                if (radios[i].value==params.payStatus){
                    $("input[name='status'][value="+(i+1)+"]").attr("checked",'checked');
                }
            }
        })
    </script>
    <script type="text/javascript">

        // function baocun() {
        //     $.ajax({
        //         type: "GET",
        //         contentType:"application/json; charset=utf-8",
        //         url: 'http://localhost:8080/updatePay?payWayName='+$("#payName").val()+"&PictureUrl="+$("#payImg").val()+"&payStatus="+$('#status input[name="status"]:checked ').val()+"&payInterface="+$("#payInterface").val()+"&id="+params.id,
        //         data: {},
        //         async: false,
        //         success: function (data) {
        //             alert(data)
        //             window.location.href="payMent_list.html"
        //         }
        //     })
        // }
    </script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="user"></i><em>添加付款方式</em></span>
    </div>
    <table class="noborder">
        <tr>
            <td width="15%" style="text-align:right;">名称：</td>
            <td><input id="payName" type="text" class="textBox length-middle"/></td>
        </tr>
        <tr>
            <td style="text-align:right;">图片：</td>
            <td><input id="payImg" type="text" class="textBox length-middle"/></td>
        </tr>
        <tr>
            <td style="text-align:right;">链接接口：</td>
            <td><input id="payInterface" type="text" class="textBox length-middle"/></td>
        </tr>
        <tr>
            <td style="text-align:right;">是否禁用：</td>
            <!--class="textBox length-middle"-->
            <td id="status"><input name="status" type="radio" value="2"/>是<input name="status" type="radio" value="1"/>否</td>
            <td></td>
        </tr>
        <tr>
            <td style="text-align:right;"></td>
            <td><input onclick="baocun()" type="submit" class="tdBtn" value="保存"/></td>
        </tr>
    </table>
</div>
</body>
</html>
