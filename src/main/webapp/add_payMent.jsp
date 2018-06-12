<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/6/11
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加付款方式</title>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script type="text/javascript">
        function baocun() {
            var form = new FormData(document.getElementById("form"));
            $.ajax({
                url:"${pageContext.request.contextPath}/insertPay",
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(data){
                    alert("添加付款方式成功！！")
                    window.location.href="payMent_list.jsp"
                },
                error:function(e){
                    alert("添加付款方式失败！！");
                    window.location.href="payMent_list.jsp"
                }
            });
        }
    </script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="user"></i><em>添加付款方式</em></span>
    </div>
    <form id="form" target="ajaxFrame">
    <table class="noborder">
        <tr>
            <td width="15%" style="text-align:right;">名称：</td>
            <td><input name="payWayName" id="payName" type="text" class="textBox length-middle"/></td>
        </tr>
        <tr>
            <td style="text-align:right;">图片：</td>
            <td><input name="PictureUrl" id="payImg" type="text" class="textBox length-middle"/></td>
        </tr>
        <tr>
            <td style="text-align:right;">链接接口：</td>
            <td><input name="payInterface" id="payInterface" type="text" class="textBox length-middle"/></td>
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
    </form>
    <iframe id="ajaxFrame" name="ajaxFrame" style="display:none;"></iframe>
</div>
</body>
</html>

