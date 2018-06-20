<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>产品列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
 <script type="text/javascript">
     function refurbishIndex() {
         var optionJson = [];
         $.ajax({
             type: "GET",
             contentType:"application/json; charset=utf-8",
             url: 'http://localhost:8080/selectCommodity',
             data: {},
             async: true,
             success: function (data) {
                 optionJson = data;
                 console.log(optionJson)
                 // for (var index=0;index<optionJson.map.size;index++){
                 //     console.log(optionJson.map())
                 // }
                 // var str = "";
                 // for(var index=0;index<optionJson.length;index++){
                 //     str +=<tr>
                 //     <td>
                 //     <span>
                 //     <input type="checkbox" class="middle children-checkbox"/>
                 //         <i>0</i>
                 //         </span>
                 //         </td>
                 //         <td class="center pic-area"><img src="#" class="thumbnail"/></td>
                 //         <td class="td-name">
                 //         <span class="ellipsis td-name block">这是产品或服务名称(宽度350px,样式自动截取，以省略号表示哦，程序可以处理“截取字符串”)</span>
                 //     </td>
                 //     <td class="center">
                 //         <span>
                 //         <i>￥</i>
                 //         <em>0.00</em>
                 //         </span>
                 //         </td>
                 //         <td class="center">
                 //         <span>
                 //         <i>￥</i>
                 //         <em>0.00</em>
                 //         </span>
                 //         </td>
                 //         <td class="center">
                 //         <span>
                 //         <em>589</em>
                 //         <i>件</i>
                 //         </span>
                 //         </td>
                 //         <td class="center"><img src="images/yes.gif"/></td>
                 //         <td class="center"><img src="images/no.gif"/></td>
                 //         <td class="center"><img src="images/yes.gif"/></td>
                 //         <td class="center">
                 //         <a title="查看" target="_blank"><img src="images/icon_view.gif"/></a>
                 //         <a title="编辑"><img src="images/icon_edit.gif"/></a>
                 //         <a title="删除"><img src="images/icon_drop.gif"/></a>
                 //         </td>
                 //         </tr>;
                 //     document.getElementById("tbodydata").innerHTML = str;
                 // }
             }
         });
     }
 </script>
</head>
<body onload="refurbishIndex()">
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>产品列表</em></span>
    <span class="modular fr"><a href="edit_product.jsp" class="pt-link-btn">+添加商品</a></span>
  </div>
  <div class="operate">
   <form>
    <select class="inline-select">
     <option>A店铺</option>
     <option>B店铺</option>
    </select>
    <input type="text" class="textBox length-long" placeholder="输入产品名称..."/>
    <input type="button" value="查询" class="tdBtn"/>
   </form>
  </div>
  <table class="list-style Interlaced">
   <tr>
    <th>ID编号</th>
    <th>产品名称</th>
    <th>产品图片</th>
    <th>产品类型</th>
    <th>产品详细信息</th>
    <th>库存</th>
    <th>精品</th>
    <th>新品</th>
    <th>热销</th>
    <th>操作</th>
   </tr>


  </table>
  <!-- BatchOperation -->
  <div style="overflow:hidden;">
      <!-- Operation -->
	  <div class="BatchOperation fl">
	   <input type="checkbox" id="del"/>
	   <label for="del" class="btnStyle middle">全选</label>
	   <input type="button" value="批量删除" class="btnStyle"/>
	  </div>
	  <!-- turn page -->
	  <div class="turnPage center fr">
	   <a>第一页</a>
	   <a>1</a>
	   <a>最后一页</a>
	  </div>
  </div>
 </div>
</body>
</html>