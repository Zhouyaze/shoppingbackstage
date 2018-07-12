<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/7/12
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除商品规格</title>
    <script src="js/jquery.js"></script>
    <script>
        $(document).ready(function delete_specification() {
            var url=decodeURI(location.search)
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
                url: '${pageContext.request.contextPath}/deleteCommoditySpecification?id='+params.id,
                data: {},
                async: false,
                success: function (data) {
                    if (data>0){
                        alert("删除规格成功！")
                        window.location.href="commodity_specification_info.jsp?id="+params.id+
                                                "&commodityName="+params.commodityName+
                                                "&commodityId="+params.commodityId
                    } else{
                        alert("删除规格失败！")
                        window.location.href="commodity_specification_info.jsp?id="+params.id+
                            "&commodityName="+params.commodityName+
                            "&commodityId="+params.commodityId
                    }
                },
                error:function () {
                    alert("删除失败！系统错误，请重新尝试")
                    window.location.href="commodity_specification_info.jsp?id="+params.id+
                        "&commodityName="+params.commodityName+
                        "&commodityId="+params.commodityId
                }
            })
        })
    </script>
</head>
<body>

</body>
</html>
