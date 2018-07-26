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
    <title>退货商品列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script>
        var pagecount = 1;
        var optionJson = null;
        function promotionInfo(pagecount) {
            messageType=  $("#select").val()
            $.ajax({
                type: "GET",
                contentType: "application/json; charset=utf-8",
                url: '${pageContext.request.contextPath}/selectType',
                data: {currentPage:pagecount,
                        messageType:messageType
                        },
                async: false,
                success: function (data) {
                    optionJson=data;
                    var str=""
                    if (messageType==1){
                       str+= "<tr>" +
                        "<th>审核编号</th>" +
                        "<th>类型</th>" +
                        "<th>订单编号</th>" +
                        "<th>审核状态</th>"+
                        "<th>退货人</th>" +
                        "<th>退货人地址</th>" +
                        "<th>商品名称</th>" +

                        "<th>创建时间</th>"+
                        "<th>后台操作人</th>" +
                        "<th>进销存操作人</th>" +
                        "<th>操作</th>" +
                        "</tr>"
                        } else{
                        str+="<tr>" +
                            "<th>审核编号</th>" +
                            "<th>类型</th>" +
                            "<th>订单编号</th>" +
                            "<th>审核状态</th>"+
                            "<th>收货人</th>" +
                            "<th>收货人地址</th>" +
                            "<th>商品名称</th>" +

                            "<th>创建时间</th>"+
                            "<th>后台操作人</th>" +
                            "<th>进销存操作人</th>" +
                            "<th>操作</th>" +
                            "</tr>"
                        }
                    for(var i=0;i<optionJson.length;i++){
                        str+="<tr>"+
                                "<td>"+optionJson[i].id+"</td>"
                                if (optionJson[i].messageType==1){
                                    str+="<td>退货</td>"
                                }else{
                                    str+="<td>发货</td>"
                                }

                               str+= "<td>"+optionJson[i].manifest+"</td>"
                                if(optionJson[i].operatingStatus==1){
                                    str+="<td>未审核</td>"
                                }else if(optionJson[i].operatingStatus==2){
                                    str+="<td>审核中</td>"
                                }else if(optionJson[i].operatingStatus==3){
                                    str+="<td>已审核</td>"
                                }else{
                                    str+="<td>未通过</td>"
                                }
                                str+="<td>"+optionJson[i].returnUserName+"</td>"+
                                "<td>"+optionJson[i].returnUserAddress+"</td>"+
                                "<td>"+optionJson[i].returnCommodityName+"</td>"+
                                "<td>"+optionJson[i].messageCreateTime+"</td>"+
                                "<td>"+optionJson[i].backstageHandlersint+"</td>"+
                                "<td>"+optionJson[i].purchaseHandlersint+"</td>"+
                                    "<td>"+
                                    "<a title=\"查看\"><img src=\"images/icon_view.gif\"/></a>"+
                                    "<a title=\"编辑\"><img src=\"images/icon_edit.gif\"/></a>"+
                                    "<a title=\"删除\"><img src=\"images/icon_drop.gif\"/></a>"+
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
        <span class="modular fl"><i></i><em>退货商品列表</em></span>
        <span class="modular fr"><a href="edit_product.jsp" class="pt-link-btn"></a></span>
    </div>
    <div class="operate">
        <form onclick="promotionInfo(1)">
            <input id="tiaojian" type="text" class="textBox length-long" placeholder="输入产品名称..."/>
            <select class="inline-select" onchange="promotionInfo(1)" id="select">
                <option value="1">退货</option>
                <option value="2">发货</option>
            </select>
            <input id="chaxun" type="button" value="查询" class="tdBtn"/>
        </form>
    </div>
    <table class="list-style Interlaced">

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
