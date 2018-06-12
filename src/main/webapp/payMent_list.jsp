<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/6/11
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>付款方式</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script type="text/javascript">
        $(document).ready(function getPayMent() {
            $.ajax({
                type: "GET",
                contentType: "application/json; charset=utf-8",
                url: 'http://localhost:8080/selectPay',
                data: {},
                async: false,
                success: function (data) {
                    var str = ""
                    console.log(data)
                    for (var index = 0; index < data.length; index++) {
                        str += "<tr>" +
                            "<td>" + data[index].id + "</td>" +
                            "<td>" + data[index].payWayName + "</td>" +
                            "<td><img src=" + data[index].pictureUrl + " alt=" + data[index].pictureUrl + "></td>" +
                            "<td>" + data[index].payInterface + "</td>"
                        if (data[index].payStatus == 1) {
                            str += "<td>是</td>"
                        } else {
                            str += "<td>否</td>"
                        }
                        str += "<td class=\"center\">" +
                            "<a href=\"edit_payMent.jsp?id=" + data[index].id + "&PictureUrl=" + data[index].pictureUrl + "&payWayName=" + data[index].payWayName + "&payInterface=" + data[index].payInterface + "&payStatus=" + data[index].payStatus + "\" title=\"编辑\"><img src=\"images/icon_edit.gif\"/></a>" +
                            "<a href=\"delete_payMent.jsp?id=" + data[index].id + "\" class=\"inline-block\" title=\"删除\"><img src=\"images/icon_drop.gif\"/></a>" +
                            "</td>" +
                            "</tr>"
                        document.getElementById("body").innerHTML = str
                    }
                }
            })
        })
    </script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i></i><em>付款方式列表</em></span>
        <span class="modular fr"><a href="add_payMent.jsp" class="pt-link-btn">+添加付款方式</a></span>
    </div>
    <table class="list-style Interlaced">
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>图片</th>
            <th>链接地址</th>
            <th>是否禁用</th>
            <th>操作</th>
        </tr>
        <tbody id="body"></tbody>
    </table>
</div>
</body>
</html>
