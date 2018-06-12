<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <title>订单详情</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
   var params = {};
    function chuanzhi() {
        var url = location.search;
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                params[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
            }
        }
        $("#userName").text(params.userName);
        $("#harvestAddressName").text(params.harvestAddressName)
        $("#orderCreationTime").text(params.orderCreationTime)
        $("#orderEndTime").text(params.orderEndTime)
        $("#orderNumber").text("订单编号:"+params.orderNumber)
        $("#userPhone").text(params.userPhone)
        if (params.paymentTypeId==2){
            $("#paymentType").text("未付款")
        }else{
            $("#paymentType").text("已付款")
        }
    }
</script>
<script>
    function shangpinInfo() {
        $.ajax({
            type: "GET",
            contentType:"application/json; charset=utf-8",
            url: 'http://localhost:8080/getOrderFromShopInfo?orderFromId='+params.orderNumber,
            data: {},
            async: false,
            success: function (data) {
                optionJson = data;
                var str = "";
                for (var index = 0; index < optionJson.length; index++) {
                    str+="<tr>"+
                          "<td><img src=\"optionJson.commodityEntity.bigPictureUrl\" class=\"thumbnail\"/></td>"+
                          "<td>"+optionJson[index].commodityEntity.commodityName+"</td>"+
                          "<td>"+
                            "<span>"+
                              "<i>￥</i>"+
                              "<em>"+optionJson[index].commodityPrice+"</em>"+
                              "</span>"+
                          "</td>"+
                          "<td>"+optionJson[index].commodityNumber+"</td>"+
                          "<td>"+
                            "<span>"+
                              "<i>￥</i>"+
                              "<em>"+optionJson[index].commodityPrice+"</em>"+
                            "</span>"+
                          "</td>"+
                          "</tr>"+
                          "<tr>"+

                        "</tr>"
                    document.getElementById("shangpin").innerHTML = str;
                }
                $("#orderfromPrice").text(params.orderfromPrice)
            }
        });
    }
</script>
<body onload="chuanzhi(),shangpinInfo()">
<div class="wrap">
 <div class="page-title">
  <span class="modular fl"><i class="order"></i><em id="orderNumber">订单编号：</em></span>
 </div>
 <dl class="orderDetail">
  <dt class="order-h">订单详情</dt>
  <dd>
   <ul>
    <li>
     <span class="h-cont h-right">收件人姓名：</span>
     <span id="userName" class="h-cont h-left"></span>
    </li>
    <li>
     <span class="h-cont h-right">联系电话：</span>
     <span id="userPhone" class="h-cont h-left"></span>
    </li>
    <li>
     <span class="h-cont h-right">联系地址：</span>
     <span id="harvestAddressName" class="h-cont h-left"></span>
    </li>
    <li>
     <span class="h-cont h-right">付款状态：</span>
     <span id="paymentType" class="h-cont h-left"></span>
    </li>
    <li>
     <span class="h-cont h-right">下单时间：</span>
     <span id="orderCreationTime" class="h-cont h-left"></span>
    </li>
    <li>
     <span class="h-cont h-right">结束时间：</span>
     <span id="orderEndTime" class="h-cont h-left"></span>
    </li>
   </ul>
  </dd>

  <dd>
   <table class="list-style">
    <tr>
     <th>缩略图</th>
     <th>产品</th>
     <th>单价</th>
     <th>数量</th>
     <th>小计</th>
    </tr>
    <tbody id="shangpin"></tbody>
    <td colspan="5">
     <div class="fr">
        <span style="font-size:15px;font-weight:bold;">
         <i>订单共计金额：￥</i>
         <b id="orderfromPrice"></b>
        </span>
     </div>
    </td>
   </table>
  </dd>
  <dd>
   <table class="noborder">
    <tr>
     <td width="10%" style="text-align:right;"><b>管理员操作：</b></td>
     <td>
      <textarea class="block" style="width:80%;height:35px;outline:none;"></textarea>
     </td>
    </tr>
   </table>
  </dd>
  <dd>
   <!-- Operation -->
   <div class="BatchOperation">
    <input type="button" value="打印订单" class="btnStyle"/>
    <input type="button" value="配送" class="btnStyle"/>
    <input type="button" value="发货" class="btnStyle"/>
    <input type="button" value="取消订单" class="btnStyle"/>
   </div>
  </dd>
 </dl>
</div>
</body>
</html>