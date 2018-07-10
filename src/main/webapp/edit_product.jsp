<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>产品列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
 <script type="text/javascript">
     $(document).ready(function getTypeName(){
         $.ajax({
             url:"${pageContext.request.contextPath}/SelectTypeLevels",
             data:[],
             type:"get",
             success:function (data) {
                 for (var i = 0; i < data.length; i++) {
                     var obj=document.getElementById('typeName');
                     for (var i = 0; i < data.length; i++) {
                         obj.options.add(new Option(data[i].typeName,data[i].id)); //这个兼容IE与firefox
                     }
                 }
             }
         })
     })
 </script>
<script type="text/javascript">
 function baocun() {
     var form = new FormData(document.getElementById("form"));
     $.ajax({
         url:"${pageContext.request.contextPath}/saveCommodity",
         type:"post",
         data:form,
         processData:false,
         contentType:false,
         success:function(data){
             if (data>0) {
                 alert("添加商品成功")
                 window.location.href = "add_comSpecification.jsp"
             }else{
                 alert("添加商品失败，请再次尝试")
             }
         },
         error:function(e){
             alert("添加商品失败，请再次尝试")
         }
     });
 }
</script>
 <script>
     var reader = new FileReader();
     function showImg(file) {
         var img = document.getElementById('imgHeader');
         //读取File对象的数据
         reader.onload = function (evt) {
             //data:img base64 编码数据显示
             img.width = "100";
             img.height = "100";
             img.src = evt.target.result;
         }
         reader.readAsDataURL(file.files[0]);
     }
     function showLunBoImg(file) {
         var img = document.getElementById('lunbo');
         //读取File对象的数据
         reader.onload = function (evt) {
             //data:img base64 编码数据显示
             img.width = "100";
             img.height = "100";
             img.src = evt.target.result;
         }
         reader.readAsDataURL(file.files[0]);
     }
     function showxiangqingImg(file) {
         var img = document.getElementById('xiangqing');
         //读取File对象的数据
         reader.onload = function (evt) {
             //data:img base64 编码数据显示
             img.width = "100";
             img.height = "100";
             img.src = evt.target.result;
         }
         reader.readAsDataURL(file.files[0]);
     }
 </script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add"></i><em>编辑/添加产品</em></span>
    <span class="modular fr"><a href="product_list.jsp" class="pt-link-btn">产品列表</a></span>
  </div>
  <form id="form" target="ajaxFrame">
   <table style="margin-left: 6%" class="noborder">
    <%--<tr>--%>
     <%--<td style="text-align:right;">广告楼层：</td>--%>
     <%--<td><input name="floorId" id="floorId" type="text" class="textBox length-middle"/></td>--%>
    <%--</tr>--%>
    <tr>
     <td style="text-align:right;">商品名称：</td>
     <td><input name="commodityName" id="commodityName" type="text" class="textBox length-middle"/></td>
    </tr>
     <tr>
      <td style="text-align:right;">商品图片：</td>
      <td><input onchange="showImg(this)" name="bigPicture" id="bigPictureUrl" type="file" class="textBox length-middle"/></td>
     </tr>
     <tr>
      <td style="text-align:right;width: 100px;height: 100px">图片预览:</td>
      <td style="border: 1px;"><img src="" id="imgHeader" alt=""/></td>
     </tr>
     <tr>
      <td style="text-align:right;">商品类型：</td>
      <td><select id="typeName" name="typeName" class="inline-select">
       <option>请选择商品类型</option>
      </select></td>
     </tr>
     <tr>
      <td style="text-align:right;">轮播图片：</td>
      <td><input onchange="showLunBoImg(this)" name="file" id="lunboPicture" type="file" class="textBox length-middle"/>
     </tr>
     <tr>
      <td style="text-align:right;width: 100px;height: 100px">图片预览:</td>
      <td style="border: 1px;"><img src="" id="lunbo" alt=""/></td>
     </tr>
     <tr>
      <td style="text-align:right;">详情图片：</td>
      <td><input onchange="showxiangqingImg(this)" name="file" id="xiangqingPicture" type="file" class="textBox length-middle"/></td>
     </tr>
     <tr>
      <td style="text-align:right;width: 100px;height: 100px">图片预览:</td>
      <td style="border: 1px;"><img src="" id="xiangqing" alt=""/></td>
     </tr>
    <tr>
     <td></td>
     <td><input onclick="baocun()" type="submit" class="tdBtn"  value="保存"/><input style="margin-left: 50px" type="reset" class="tdBtn"  value="重置"/></td>
    </tr>
   </table>
  </form>
  <iframe id="ajaxFrame" name="ajaxFrame" style="display:none;"></iframe>
 </div>
</body>
</html>