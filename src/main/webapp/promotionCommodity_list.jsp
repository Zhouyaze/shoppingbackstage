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
        var pagecount = 1;
        var optionJson = null;
        function promotionInfo(pagecount) {
            $.ajax({
                type: "GET",
                contentType: "application/json; charset=utf-8",
                url: '${pageContext.request.contextPath}/getProMsg',
                data: {currentPage:pagecount},
                async: false,
                success: function (data) {
                    optionJson=data;
                    var str=""
                    for(var i=0;i<optionJson.items.length;i++){
                        str+="<tr>"+
                            "<td>"+optionJson.items[i].id+"</td>"+
                            "<td>"+optionJson.items[i].commodityId+"</td>"+
                            "<td>"+optionJson.items[i].commodityEntity.commodityName+"</td>"+
                            "<td><img src="+optionJson.items[i].picture+"/></td>"+
                            "<td>"+optionJson.items[i].commodityNumber+"</td>"+
                            "<td>"+optionJson.items[i].discountPrice+"</td>"+
                            "<td>"
                            if(optionJson.items[i].specifications1!=null){
                                str+=optionJson.items[i].specifications1+","
                            }
                            if(optionJson.items[i].specifications2!=null){
                                str+=optionJson.items[i].specifications2+","
                            }
                            if(optionJson.items[i].specifications3!=null){
                                str+=optionJson.items[i].specifications3+","
                            }
                            if(optionJson.items[i].specifications4!=null){
                                str+=optionJson.items[i].specifications4
                            }
                        str+="<td>"+optionJson.items[i].startTime+"</td>"+
                             "<td>"+optionJson.items[i].endTime+"</td>"+
                            "</td>"+
                            "<td>"+
                            "<a title=\"查看\" href=\"commodity_specification_info.jsp?commodityId="+optionJson.items[i].commodityId+"&commodityName="+optionJson.items[i].commodityEntity.commodityName+"&id="+optionJson.items[i].id+"\"><img src=\"images/icon_view.gif\"/></a>"+
                            "<a href=\"update_promotion.jsp?id="+optionJson.items[i].id+ "\" title=\"修改促销\"><img src=\"images/icon_edit.gif\"/></a>"+
                            "<a href=\"delete_Commodity.jsp?commodityId="+optionJson.items[i].commodityId+"\" title=\"删除\"><img src=\"images/icon_drop.gif\"/></a>"+
                            "</td>"+
                            "</tr>";
                        document.getElementById("tbodydata").innerHTML = str;
                    }
                    document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                }
            })
        }
    </script>
    <script type="text/javascript">

        /*
        分页下一页
        */
        function pageJia() {
            if (pagecount > 1) {
                pagecount--;
                promotionInfo(pagecount)
                document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
            }
        }

        /*
        分页上一页
        */
        function pageJian() {
            if (pagecount < optionJson.totalPage) {
                pagecount++;
                promotionInfo(pagecount)
                document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
            }
            // fun();
        }

        /*
         * 分页跳转
         */
        function tiaozhuan() {
            pagecount = parseInt($("#yema").val());
            if (pagecount > optionJson.totalPage) {
                pagecount = optionJson.totalPage
                document.getElementById("yema").value = optionJson.totalPage;
            } else if (pagecount < 1) {
                pagecount = 1
                document.getElementById("yema").value = 1;
            }
            promotionInfo(pagecount)
            document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
        }
    </script>

</head>
<body onload="promotionInfo(1)">
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i></i><em>促销商品列表</em></span>
        <span class="modular fr"><a href="edit_product.jsp" class="pt-link-btn">+添加商品</a></span>
    </div>
    <div class="operate">
        <form onclick="promotionInfo(1)">
            <input id="tiaojian" type="text" class="textBox length-long" placeholder="输入产品名称..."/>
            <input id="chaxun" type="button" value="查询" class="tdBtn"/>
        </form>
    </div>
    <table class="list-style Interlaced">
        <tr>
            <th>促销编号</th>
            <th>商品编号</th>
            <th>产品名称</th>
            <th>产品图片</th>
            <th>促销数量</th>
            <th>价格</th>
            <th>产品规格信息</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>操作</th>
        </tr>
        <tbody id="tbodydata"></tbody>
    </table>
    <!-- BatchOperation -->
    <div style="overflow:hidden;">
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
