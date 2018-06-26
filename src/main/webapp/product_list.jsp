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
     var pagecount = 1;
     var optionJson = null;
     function refurbishIndex(currentPage) {
         var tiaojian=$("#tiaojian").val();
         console.log(tiaojian)
         if (tiaojian==""){
             $.ajax({
                 type: "GET",
                 contentType:"application/json; charset=utf-8",
                 url: 'http://localhost:8080/selectCommodity?currentPage='+currentPage,
                 data: {},
                 async: true,
                 success: function (data) {
                     optionJson=data
                     var str="";
                     for(var i=0;i<data.items.length;i++){
                         str+="<tr>"+
                             "<td>"+optionJson.items[i].id+"</td>"+
                             "<td>"+optionJson.items[i].commodityId+"</td>"+
                             "<td>"+optionJson.items[i].commodityEntity.commodityName+"</td>"+
                             "<td><img src="+optionJson.items[i].picture+"/></td>"+
                             "<td>"+optionJson.items[i].commodityEntity.typeName+"</td>"+
                             "<td>"+optionJson.items[i].price+"</td>"+
                             "<td>"
                         if(optionJson.items[i].specification1!=null){
                             str+=optionJson.items[i].specification1+"\n"
                         }
                         if(optionJson.items[i].specification2!=null){
                             str+=optionJson.items[i].specification2+"\n"
                         }
                         if(optionJson.items[i].specification3!=null){
                             str+=optionJson.items[i].specification3+"\n"
                         }
                         if(optionJson.items[i].specification4!=null){
                             str+=optionJson.items[i].specification4+"\n"
                         }
                         str+="</td>"+
                             "<td>"+optionJson.items[i].inventory+"</td>"+
                             "<td>"+
                             "<a title=\"查看\" target=\"_blank\"><img src=\"images/icon_view.gif\"/></a>"+
                             "<a title=\"编辑\"><img src=\"images/icon_edit.gif\"/></a>"+
                             "<a title=\"删除\"><img src=\"images/icon_drop.gif\"/></a>"+
                             "</td>"+
                             "</tr>";
                         document.getElementById("tbodydata").innerHTML = str;
                     }
                     document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                 }
             });
         } else{
             $.ajax({
                 type: "GET",
                 contentType:"application/json; charset=utf-8",
                 url: 'http://localhost:8080/selectCommodity?currentPage='+currentPage+"&commodityName="+tiaojian,
                 data: {},
                 async: true,
                 success: function (data) {
                     optionJson=data
                     var str="";
                     for(var i=0;i<data.items.length;i++){
                         str+="<tr>"+
                             "<td>"+optionJson.items[i].id+"</td>"+
                             "<td>"+optionJson.items[i].commodityId+"</td>"+
                             "<td>"+optionJson.items[i].commodityEntity.commodityName+"</td>"+
                             "<td><img src="+optionJson.items[i].picture+"/></td>"+
                             "<td>"+optionJson.items[i].commodityEntity.typeName+"</td>"+
                             "<td>"+optionJson.items[i].price+"</td>"+
                             "<td>"
                         if(optionJson.items[i].specification1!=null){
                             str+=optionJson.items[i].specification1+"\n"
                         }
                         if(optionJson.items[i].specification2!=null){
                             str+=optionJson.items[i].specification2+"\n"
                         }
                         if(optionJson.items[i].specification3!=null){
                             str+=optionJson.items[i].specification3+"\n"
                         }
                         if(optionJson.items[i].specification4!=null){
                             str+=optionJson.items[i].specification4+"\n"
                         }
                         str+="</td>"+
                             "<td>"+optionJson.items[i].inventory+"</td>"+
                             "<td>"+
                             "<a title=\"查看\" target=\"_blank\"><img src=\"images/icon_view.gif\"/></a>"+
                             "<a title=\"编辑\"><img src=\"images/icon_edit.gif\"/></a>"+
                             "<a title=\"删除\"><img src=\"images/icon_drop.gif\"/></a>"+
                             "</td>"+
                             "</tr>";
                         document.getElementById("tbodydata").innerHTML = str;
                     }
                     document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                 }
             });
         }
     }
 </script>
    <script type="text/javascript">

        /*
        分页下一页
        */
        function pageJia() {
            if (pagecount > 1) {
                pagecount--;
                refurbishIndex(pagecount)
                document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
            }
        }

        /*
        分页上一页
        */
        function pageJian() {
            if (pagecount < optionJson.totalPage) {
                pagecount++;
                    refurbishIndex(pagecount)
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
            refurbishIndex(pagecount)
            document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
        }
    </script>
</head>
<body onload="refurbishIndex(1)">
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i></i><em>产品列表</em></span>
    <span class="modular fr"><a href="edit_product.jsp" class="pt-link-btn">+添加商品</a></span>
  </div>
  <div class="operate">
   <form onclick="refurbishIndex(1)">
    <input id="tiaojian" type="text" class="textBox length-long" placeholder="输入产品名称..."/>
    <input id="chaxun" type="button" value="查询" class="tdBtn"/>
   </form>
  </div>
  <table class="list-style Interlaced">
   <tr>
    <th>商品信息编号</th>
       <th>商品编号</th>
    <th>产品名称</th>
    <th>产品图片</th>
    <th>产品类型</th>
    <th>价格</th>
    <th>产品规格信息</th>
    <th>库存</th>
    <th>操作</th>
   </tr>
      <tbody id="tbodydata"></tbody>
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