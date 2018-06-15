<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/6/13
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function deleteAdvertising() {
            var url=decodeURI(location.search)
            params = {};
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    params[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
            $.ajax({
                type:"get",
                url:"http://localhost:8080/deleteAdvertise",
                data:{id:params.id},
                success:function (data) {
                    alert(data)
                    window.location.href="advertising_list.jsp"
                }
            })
        })
    </script>
</head>
<body>

</body>
</html>
