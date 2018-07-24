<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/7/23
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除促销商品</title>
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
                url: '${pageContext.request.contextPath}/delPromotionitemMsg',
                data: {id:params.id},
                async: false,
                success: function (data) {
                    alert("删除促销商品成功")
                    window.location.href="promotionCommodity_list.jsp"
                },
                error:function () {
                    alert("删除失败！系统错误，请重新尝试")
                    window.location.href="promotionCommodity_list.jsp"
                }
            })
        })
    </script>
</head>
<body>

</body>
</html>
