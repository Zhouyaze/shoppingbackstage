<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/7/10
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script>
        $(document).ready(function commSpecification() {

        }
    </script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="order"></i><em id="commodityId">商品编号：</em></span>
        <span style="margin-left:30%" class="modular fl"><i class="order"></i><em id="commodityName">商品名称：</em></span>
    </div>
    <dl class="orderDetail">
        <dt class="order-h">订单详情</dt>
        <dd>
            <table class="list-style">
                <tr>
                    <th>楼层编号</th>
                    <th>标题</th>
                    <th>logo地址</th>
                    <th>排序</th>
                    <th>操作</th>
                </tr>
                <tbody id="commSpecification"></tbody>
            </table>
        </dd>
    </dl>
    <div class="BatchOperation" style="float: right">
        <a id="addProm" class="btnStyle"
           href="#"
           title=\"添加规格\">添加规格</a>
    </div>
    <a href=""></a>
</div>
</body>
</html>
