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
            var params = {};
            var url=decodeURI(location.search)
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    params[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
            $("#commodityId").text("商品编号:"+params.commodityId)
            $("#commodityName").text("商品名称:"+params.commodityName)
            var str="";
            $.ajax({
                url: '${pageContext.request.contextPath}/selectAllspecification',
                type:"get",
                data:{id:params.commodityId},
                success:function(data){
                   for(var index=0;index<data.length;index++){
                       str+="<tr>"+
                           "<td><img src="+data[index].picture+" alt=\"这是商品规格图片\"></td>"+
                           "<td>"+data[index].specification1+"</td>"+
                           "<td>"+data[index].specification2+"</td>"+
                           "<td>"+data[index].specification3+"</td>"+
                           "<td>"+data[index].specification4+"</td>"+
                           "<td>"+data[index].inventory+"</td>"+
                           "<td>"+data[index].price+"</td>"+
                           "<td>"+
                           "<a href=\"add_comSpecification.jsp?commodityId="+params.commodityId+"\" title=\"添加\"><img src=\"images/icon_add.jpg\"/></a>"+
                           "<a href=\"edit_comSpecification.jsp?commodityId="+params.commodityId+"&commodityName="+params.commodityName+
                           "&specification1="+data[index].specification1+
                           "&specification2="+data[index].specification1+
                           "&specification3="+data[index].specification1+
                           "&specification4="+data[index].specification1+
                           "&inventory="+data[index].inventory+
                           "&price="+data[index].price+
                           "&id="+data[index].id+
                           "\" title=\"编辑\"><img src=\"images/icon_edit.gif\"/></a>"+
                           "<a href=\"delete_comSpecification.jsp?commodityId="+params.commodityId+
                           "&commodityName="+params.commodityName+
                           "&id="+params.id+
                           "\" title=\"删除\"><img src=\"images/icon_drop.gif\"/></a>"+
                           "</td>"+
                           "</tr>"
                       document.getElementById("commSpecification").innerHTML=str
                   }
                }
            })
        })
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
                    <th>规格图片</th>
                    <th>规格属性①</th>
                    <th>规格属性②</th>
                    <th>规格属性③</th>
                    <th>规格属性④</th>
                    <th>库存</th>
                    <th>价格</th>
                    <th>操作</th>
                </tr>
                <tbody id="commSpecification"></tbody>
            </table>
        </dd>
    </dl>
</div>
</body>
</html>
