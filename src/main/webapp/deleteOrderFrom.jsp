<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/6/12
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function deleteUser() {
            var url=location.search;
            params={};
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for(var i = 0; i < strs.length; i ++) {
                    params[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
                }
            }
            $.ajax({
                type: "GET",
                contentType:"application/json; charset=utf-8",
                url: '${pageContext.request.contextPath}/deleteOrderFrom?orderNumber='+params.orderNumber,
                data: {},
                async: false,
                success: function (data) {
                    if (data>0)
                        alert("删除成功！")
                    else
                        alert("删除失败！")
                    window.location.href="order_list.jsp"
                },
                error:function () {
                    alert("删除失败！系统错误，请重新尝试")
                    window.location.href="order_list.jsp"
                }
            })
        })
    </script>
</head>
<body >
</body>
</html>