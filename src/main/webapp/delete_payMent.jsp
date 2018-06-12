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
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script>
        $(document).ready(function deletePayMent() {
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
                url: 'http://localhost:8080/deletePay?id='+params.id,
                data: {},
                async: false,
                success: function (data) {
                    alert(data)
                    window.location.href="payMent_list.jsp"
                },
                error:function () {
                    alert("删除失败！系统错误，请重新尝试")
                    window.location.href="payMent_list.jsp"
                }
            })
        })
    </script>
</head>
<body>

</body>
</html>
