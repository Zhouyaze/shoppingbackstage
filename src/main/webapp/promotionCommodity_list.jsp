<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/7/21
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>促销商品列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script>
        $(document).ready(function promotionInfo() {
            var pagecount = 1;
            var optionJson = null;
            $.ajax({
                type: "GET",
                contentType: "application/json; charset=utf-8",
                url: '${pageContext.request.contextPath}/getProMsg',
                data: {},
                async: false,
                success: function (data) {
                    optionJson=data;
                    var str=""
                    for (var i=0;i<optionJson.length;i++){
                        str+=
                    }
                }
            })
        })
    </script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i></i><em>促销商品列表</em></span>
        <span class="modular fr"><a href="edit_product.jsp" class="pt-link-btn">+添加商品</a></span>
    </div>
    <div class="operate">
        <form onclick="refurbishIndex(1)">
            <input id="tiaojian" type="text" class="textBox length-long" placeholder="输入产品名称..."/>
            <input id="chaxun" type="button" value="查询" class="tdBtn"/>
        </form>
    </div>
    <table class="list-style Interlaced">
        <tr>
            <th>促销商品编号</th>
            <th>商品编号</th>
            <th>产品名称</th>
            <th>产品图片</th>
            <th>促销数量</th>
            <th>价格</th>
            <th>产品规格信息</th>
            <th>操作</th>
        </tr>
        <tbody id="tbodydata"></tbody>
    </table>
    <!-- BatchOperation -->
    <div style="overflow:hidden;">
        <!-- Operation -->
        <%--<div class="BatchOperation fl">--%>
            <%--<input type="checkbox" id="del"/>--%>
            <%--<label for="del" class="btnStyle middle">全选</label>--%>
            <%--<input type="button" value="批量删除" class="btnStyle"/>--%>
            <%--<input type="button" value="打印报表" class="btnStyle" onclick="printCommodity()"/>--%>
        <%--</div>--%>
        <!-- turn page -->

        <div style="overflow:hidden;">
            <div class="turnPage center fr" id="pageBtn" style="width: auto;display:inline-block !important;height: auto;">
                <a onclick="pageJia()">上一页</a>
                <a>跳转至</a>
                <input type="text" id="yema" style="width: 20px;"/>
                <a onclick="tiaozhuan()">跳转</a>
                <a onclick="pageJian()">下一页</a>
                <a id="result"></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
