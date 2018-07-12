<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/7/10
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js"></script>
    <script>
        $(document).ready(function deleteCommodity() {
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
                url:"${pageContext.request.contextPath}/deleteCommodity",
                data:{id:params.commodityId},
                success:function (data) {
                    alert("删除成功！")
                    window.location.href="product_list.jsp"
                }
            })
        })
    </script>
</head>
<body>

</body>
</html>
