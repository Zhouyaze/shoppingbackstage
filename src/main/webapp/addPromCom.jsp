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
    <title>添加促销商品</title>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script>
        $(document).ready(function commSpecification() {
            var params = {};
            var url = decodeURI(location.search)
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    params[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
            $("#commodityId").val(params.commodityId)
            $("#commodityName").val(params.commodityName)
            $("#specifications1").val(params.specification1)
            $("#specifications2").val(params.specification2)
            $("#specifications3").val(params.specification3)
            $("#specifications4").val(params.specification4)
        })
    </script>
    <script>
        function baocun() {
            var form = new FormData(document.getElementById("form"));
                form.delete("commodityName");
            $.ajax({
                url:"${pageContext.request.contextPath}/savePromotionitemMsg",
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(data){
                    alert("添加促销商品成功！！")
                    window.location.href="promotionCommodity_list.jsp"
                },
                error:function(e){
                    alert("添加促销商品失败！！");
                }
            });
        }
    </script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="user"></i><em>添加促销商品</em></span>
    </div>
    <form id="form" target="ajaxFrame">
        <table class="list-style">
            <tr>
                <td width="15%" style="text-align:right;">促销商品编号：</td>
                <td><input readonly="readonly" name="commodityId" id="commodityId" type="text" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td width="15%" style="text-align:right;">促销商品名称：</td>
                <td><input readonly="readonly" name="commodityName" id="commodityName" type="text" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td width="15%" style="text-align:right;">促销价格：</td>
                <td><input name="discountPrice" id="discountPrice" type="text" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td width="15%" style="text-align:right;">促销商品数量：：</td>
                <td><input name="commodityNumber" id="commodityNumber" type="number" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td width="15%" style="text-align:right;">规格①：</td>
                <td><input readonly="readonly" name="specifications1" id="specifications1" type="text" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td width="15%" style="text-align:right;">规格②：</td>
                <td><input readonly="readonly" name="specifications2" id="specifications2" type="text" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td width="15%" style="text-align:right;">规格③：</td>
                <td><input readonly="readonly" name="specifications3" id="specifications3" type="text" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td width="15%" style="text-align:right;">规格④：</td>
                <td><input readonly="readonly" name="specifications4" id="specifications4" type="text" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td width="15%" style="text-align:right;">开始时间：</td>
                <td><input name="startTime" id="startTime" type="text" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td width="15%" style="text-align:right;">结束时间：</td>
                <td><input name="endTime" id="endTime" type="text" class="textBox length-middle"/></td>
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

