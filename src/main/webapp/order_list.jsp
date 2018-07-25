<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <title>订单列表</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
 <script src="js/jquery.js"></script>
 <script src="js/public.js"></script>
    <script>
        function printOrderFrom() {
            window.location.href="${pageContext.request.contextPath}/generateOrder"
            alert("订单已打印")
        }
    </script>
 <!--查询全部  初始化-->
 <script type="text/javascript">
     var pagecount=1;
     var optionJson = [];
     function refurbishIndex(currentPage,pageSize) {
         $.ajax({
             type: "GET",
             contentType:"application/json; charset=utf-8",
             url: '${pageContext.request.contextPath}/getOrderFromInfoByCond?'+"currentPage="+currentPage+"&pageSize="+pageSize,
             data: {},
             async: true,
             success: function (data) {
                 optionJson = data;
                 var str = "";
                 var orderType=$("#select").val();
                 if (orderType=="1"){
                     for(var index=0;index<optionJson.items.length;index++){
                         str +="<tr>"+
                             "<td>"+
                             "<input type=\"checkbox\"/>"+
                             "<a href="+""+optionJson.items[index].orderNumber+""+"order_detail.jsp?id=+>"+optionJson.items[index].orderNumber+"</a>"+
                             "</td>"+
                             "<td class=\"center\">"+optionJson.items[index].orderCreationTime+"</td>" +
                             "<td width=\"450\">\n" +
                             "<span class=\"block\">"+optionJson.items[index].harvestAddressEntity.userName+"["+optionJson.items[index].harvestAddressEntity.userPhone+"]"+"</span>\n" +
                             "<address>"+optionJson.items[index].harvestAddressEntity.harvestAddressName+"</address>\n" +
                             "</td>"+
                             "<td class=\"center\">￥"+optionJson.items[index].orderfromPrice+"</td>"
                         if (optionJson.items[index].paymentTypeId==2){
                             str+="<td>未付款</td>"
                         }else{
                             str+="<td>已付款</td>"
                         }
                         str+="<td><a href=\"order_detail.jsp?userName="+optionJson.items[index].harvestAddressEntity.userName+
                             "&userPhone="+optionJson.items[index].harvestAddressEntity.userPhone+
                             "&harvestAddressName="+optionJson.items[index].harvestAddressEntity.harvestAddressName+
                             "&paymentTypeId="+optionJson.items[index].paymentTypeId+
                             "&orderCreationTime="+optionJson.items[index].orderCreationTime+
                             "&orderEndTime="+optionJson.items[index].orderEndTime+
                             "&orderNumber="+optionJson.items[index].orderNumber+
                             "&orderfromPrice="+optionJson.items[index].orderfromPrice+"\" class=\"inline-block\" title=\"查看订单\"><img src=\"images/icon_view.gif\"/>"+
                             "</a>"+
                             "<a href=\"deleteOrderFrom.jsp?orderNumber="+optionJson.items[index].orderNumber+"\" class=\"inline-block\" title=\"删除订单\">" +
                             "<img id=\"deletefrom\"  src=\"images/icon_trash.gif\"/></a>"+
                             "</td>" +
                             "</tr>";
                         document.getElementById("orderfromData").innerHTML = str;
                     }
                 } else{
                     document.getElementById("orderfromData").innerHTML = "";
                     $.ajax({
                         type: "GET",
                         contentType:"application/json; charset=utf-8",
                         url: '${pageContext.request.contextPath}/getOrderFromInfoByCond?'+"paymentTypeId="+orderType+"&currentPage="+currentPage+"&pageSize="+pageSize,
                         data: {},
                         async: true,
                         success: function (data) {
                             optionJson = data;
                             var str = "";
                             for(var index=0;index<optionJson.items.length;index++){
                                 str +="<tr>"+
                                     "<td>"+
                                     "<input type=\"checkbox\"/>"+
                                     "<a href="+""+optionJson.items[index].orderNumber+""+"order_detail.jsp?id=+>"+optionJson.items[index].orderNumber+"</a>"+
                                     "</td>"+
                                     "<td class=\"center\">"+optionJson.items[index].orderCreationTime+"</td>" +
                                     "<td width=\"450\">\n" +
                                     "<span class=\"block\">"+optionJson.items[index].harvestAddressEntity.userName+"["+optionJson.items[index].harvestAddressEntity.userPhone+"]"+"</span>\n" +
                                     "<address>"+optionJson.items[index].harvestAddressEntity.harvestAddressName+"</address>\n" +
                                     "</td>"+
                                     "<td class=\"center\">￥"+optionJson.items[index].orderfromPrice+"</td>"
                                 if (optionJson.items[index].paymentTypeId==2){
                                     str+="<td>未付款</td>"
                                 }else{
                                     str+="<td>已付款</td>"
                                 }
                                 str+="<td><a href=\"order_detail.jsp?userName="+optionJson.items[index].harvestAddressEntity.userName+
                             "&userPhone="+optionJson.items[index].harvestAddressEntity.userPhone+
                             "&harvestAddressName="+optionJson.items[index].harvestAddressEntity.harvestAddressName+
                             "&paymentTypeId="+optionJson.items[index].paymentTypeId+
                             "&orderCreationTime="+optionJson.items[index].orderCreationTime+
                             "&orderEndTime="+optionJson.items[index].orderEndTime+
                             "&orderNumber="+optionJson.items[index].orderNumber+
                             "&orderfromPrice="+optionJson.items[index].orderfromPrice+"\" class=\"inline-block\" title=\"查看订单\"><img src=\"images/icon_view.gif\"/>"+
                             "</a>"+
                             "<a href=\"deleteOrderFrom.jsp?orderNumber="+optionJson.items[index].orderNumber+"\" class=\"inline-block\" title=\"删除订单\">" +
                             "<img id=\"deletefrom\"  src=\"images/icon_trash.gif\"/></a>"+
                                     "</td>" +
                                     "</tr>";
                                 document.getElementById("orderfromData").innerHTML = str;
                             }
                         }
                     });
                 }
                 document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
             }
         });
     }
 </script>
 <script type="text/javascript">
     //付款状态类型选择
     function fukuanzhuangtai() {
         $.ajax({
             type: "GET",
             contentType:"application/json; charset=utf-8",
             url: '${pageContext.request.contextPath}/getOrderFromType',
             data: {},
             async: false,
             success: function (data) {
                 var obj=document.getElementById('select');
                 for (var i = 0; i < data.length; i++) {
                     obj.options.add(new Option(data[i].typeName,data[i].id)); //这个兼容IE与firefox
                 }
             }
         });
     }
 </script>
 <script type="text/javascript">
     function tiaojianSelect(currentPage,pageSize) {
         var orderType=$("#select").val();
         if ($("#tiaojian").val()==""){
             refurbishIndex(currentPage,5)
         } else {
             if (orderType=="1"){
                 document.getElementById("orderfromData").innerHTML = "";
                 var optionJson = [];
                 $.ajax({
                     type: "GET",
                     contentType:"application/json; charset=utf-8",
                     url: '${pageContext.request.contextPath}/getOrderFromInfoByCond?'+"orderNumber="+$("#tiaojian").val()+"&currentPage="+currentPage+"&pageSize="+pageSize,
                     data: {},
                     async: true,
                     success: function (data) {
                         optionJson = data;
                         var str = "";
                         for(var index=0;index<optionJson.items.length;index++){
                             str +="<tr>"+
                                 "<td>"+
                                 "<input type=\"checkbox\"/>"+
                                 "<a href="+""+optionJson.items[index].orderNumber+""+"order_detail.jsp?id=+>"+optionJson.items[index].orderNumber+"</a>"+
                                 "</td>"+
                                 "<td class=\"center\">"+optionJson.items[index].orderCreationTime+"</td>" +
                                 "<td width=\"450\">\n" +
                                 "<span class=\"block\">"+optionJson.items[index].harvestAddressEntity.userName+"["+optionJson.items[index].harvestAddressEntity.userPhone+"]"+"</span>\n" +
                                 "<address>"+optionJson.items[index].harvestAddressEntity.harvestAddressName+"</address>\n" +
                                 "</td>"+
                                 "<td class=\"center\">￥"+optionJson.items[index].orderfromPrice+"</td>"
                             if (optionJson.items[index].paymentTypeId==2){
                                 str+="<td>未付款</td>"
                             }else{
                                 str+="<td>已付款</td>"
                             }
                             str+="<td>" +"<a href=\"order_detail.jsp\" class=\"inline-block\" title=\"查看订单\">"+"<img src=\"images/icon_view.gif\"/>"+"</a>"+
                                 "<a class=\"inline-block\" title=\"删除订单\"><img id=\"deletefrom\"  src=\"images/icon_trash.gif\"/></a>"+
                                 "</td>" +
                                 "</tr>";
                             document.getElementById("orderfromData").innerHTML = str;
                         }
                         document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                     }
                 });
             } else{
                 document.getElementById("orderfromData").innerHTML = "";
                 $.ajax({
                     type: "GET",
                     contentType:"application/json; charset=utf-8",
                     url: '${pageContext.request.contextPath}/getOrderFromInfoByCond?'+"paymentTypeId="+orderType+"&orderNumber="+$("#tiaojian").val()+"&currentPage="+currentPage+"&pageSize="+pageSize,
                     data: {},
                     async: true,
                     success: function (data) {
                         optionJson = data;
                         var str = "";
                         for(var index=0;index<optionJson.items.length;index++){
                             str +="<tr>"+
                                 "<td>"+
                                 "<input type=\"checkbox\"/>"+
                                 "<a href="+""+optionJson.items[index].orderNumber+""+"order_detail.jsp?id=+>"+optionJson.items[index].orderNumber+"</a>"+
                                 "</td>"+
                                 "<td class=\"center\">"+optionJson.items[index].orderCreationTime+"</td>" +
                                 "<td width=\"450\">\n" +
                                 "<span class=\"block\">"+optionJson.items[index].harvestAddressEntity.userName+"["+optionJson.items[index].harvestAddressEntity.userPhone+"]"+"</span>\n" +
                                 "<address>"+optionJson.items[index].harvestAddressEntity.harvestAddressName+"</address>\n" +
                                 "</td>"+
                                 "<td class=\"center\">￥"+optionJson.items[index].orderfromPrice+"</td>"
                             if (optionJson.items[index].paymentTypeId==2){
                                 str+="<td>未付款</td>"
                             }else{
                                 str+="<td>已付款</td>"
                             }
                             str+="<td>" +"<a href=\"order_detail.jsp\" class=\"inline-block\" title=\"查看订单\">"+"<img src=\"images/icon_view.gif\"/>"+"</a>"+
                                 "<a class=\"inline-block\" title=\"删除订单\"><img id=\"deletefrom\"  src=\"images/icon_trash.gif\"/></a>"+
                                 "</td>" +
                                 "</tr>";
                             document.getElementById("orderfromData").innerHTML = str;
                         }
                         document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                     }
                 });
             }
         }
     }
 </script>
 <script type="text/javascript">
     /*
       分页下一页
       */
     function pageJia() {
         if (pagecount>1){
             pagecount--;
             if ($("#select").val()!=""||$("#tiaojian").val()!=""){
                 tiaojianSelect(pagecount,optionJson.pageSize)
             } else{
                 refurbishIndex(pagecount,optionJson.pageSize)
             }
             document.getElementById("result").innerHTML =  pagecount+"/"+optionJson.totalPage;
         }
     }
     /*
     分页上一页
     */
     function pageJian() {
         if (pagecount < optionJson.totalPage){
             pagecount++;
             if ($("#select").val()!=""||$("#tiaojian").val()!=""){
                 tiaojianSelect(pagecount,optionJson.pageSize)
             } else{
                 refurbishIndex(pagecount,optionJson.pageSize)
             }
             document.getElementById("result").innerHTML =  pagecount+"/"+optionJson.totalPage;
         }
         // fun();
     }

     /*
      * 分页跳转
      */
     function tiaozhuan() {
         pagecount=parseInt($("#yema").val());
         if (pagecount>optionJson.totalPage) {
             pagecount=optionJson.totalPage
             document.getElementById("yema").value =  optionJson.totalPage;
         }else if(pagecount<1){
             pagecount=1
             document.getElementById("yema").value =1;
         }
         refurbishIndex(pagecount,optionJson.pageSize)
         document.getElementById("result").innerHTML =  pagecount+"/"+optionJson.totalPage;
     }

 </script>
</head>
<body onload="refurbishIndex(1,5),fukuanzhuangtai()">
<div class="wrap">
 <div class="page-title">
  <span class="modular fl"><i class="order"></i><em>订单列表</em></span>
 </div>
 <div class="operate">
  <form>
   <img src="images/icon_search.gif"/>
   <input type="text" id="tiaojian" class="textBox length-long" placeholder="输入订单编号或收件人姓名..."/>
   <select class="inline-select" id="select">
  </select>
   <input onclick="tiaojianSelect(1,5)" type="button" value="查询" class="tdBtn"/>
  </form>
 </div>
 <table class="list-style Interlaced">
  <tr>
   <th>订单编号</th>
   <th>下单时间</th>
   <th>收件人</th>
   <th>订单金额</th>
   <th>订单状态</th>
   <th>操作</th>
  </tr>
  <tbody id="orderfromData"></tbody>
 </table>
 <!-- BatchOperation -->
 <div style="overflow:hidden;">
  <!-- Operation -->
  <div class="BatchOperation fl">
   <input type="checkbox" id="del"/>
   <label for="del" class="btnStyle middle">全选</label>
   <input onclick="printOrderFrom()" type="button" value="打印订单" class="btnStyle"/>
   <input type="button" value="配货" class="btnStyle"/>
   <input type="button" value="删除订单" class="btnStyle"/>
  </div>
  <!-- turn page -->
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
</body>

</html>