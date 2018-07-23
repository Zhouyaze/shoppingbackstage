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
    <title>修改促销商品</title>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script>
        var optionJson=null

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
            $.ajax({
                url:"${pageContext.request.contextPath}/getProMsgById?id="+params.id,
                type:"post",
                processData:false,
                contentType:false,
                success:function(data){
                    optionJson=data
                    $("#commodityId").val(data[0].commodityId)
                    $("#commodityName").val(data[0].commodityEntity.commodityName)
                    $("#specifications1").val(data[0].specifications1)
                    $("#specifications2").val(data[0].specifications2)
                    $("#specifications3").val(data[0].specifications3)
                    $("#specifications4").val(data[0].specifications4)
                    $("#discountPrice").val(data[0].discountPrice)
                    $("#startTime").val(data[0].startTime)
                    $("#endTime").val(data[0].endTime)
                    $("#commodityNumber").val(data[0].commodityNumber)
                }
            })
        })
    </script>
    <script>
        function baocun() {
            var form = new FormData(document.getElementById("form"));
            form.delete("commodityName");
            $.ajax({
                url:"${pageContext.request.contextPath}/updatePromotionitemMsg?id="+optionJson[0].id,
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(data){
                    alert("修改促销商品成功！！")
                    window.location.href="promotionCommodity_list.jsp"
                },
                error:function(e){
                    alert("修改促销商品失败！！");
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
                <td><input onclick="baocun()" type="submit" class="tdBtn" value="修改"/></td>
            </tr>
        </table>
    </form>
    <iframe id="ajaxFrame" name="ajaxFrame" style="display:none;"></iframe>
</div>
</body>
</html>

