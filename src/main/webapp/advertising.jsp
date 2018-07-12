<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>添加广告</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
 <script src="js/jquery.js"></script>
 <script src="js/public.js"></script>
 <script type="text/javascript">
  $(document).ready(function getPlace() {
      $.ajax({
          type: "GET",
          contentType:"application/json; charset=utf-8",
          url: '${pageContext.request.contextPath}/getPlace',
          data: {},
          async: false,
          success: function (data) {
              for (var i = 0; i < data.length; i++) {
                  var obj=document.getElementById('place');
                  for (var i = 0; i < data.length; i++) {
                      obj.options.add(new Option(data[i].place,data[i].id)); //这个兼容IE与firefox
                  }
              }
          }
      });
  })
 </script>
 <script type="text/javascript">
     function baocun() {
         // endTime=$("#endTime").val()
         // startTime==$("#startTime").val()
         // params = {};
         // if (endTime.indexOf("T") != -1) {
         //     var str = endTime.substr(0);
         //     strs = str.split("T");
         //     endTime=strs[0]+" "+strs[1]+":00"
         // }
         // if (startTime.indexOf("T") != -1) {
         //     var str = startTime.substr(0);
         //     strs = str.split("T");
         //     startTime=strs[0]+" "+strs[1]+":00"
         // }
         var form = new FormData(document.getElementById("form"));
         $.ajax({
             url:"${pageContext.request.contextPath}/addAdvertise",
             type:"post",
             data:form,
             processData:false,
             contentType:false,
             success:function(data){
                 alert(data)
                 window.location.href="advertising_list.jsp"
             },
             error:function(e){
                 alert("添加失败");
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
 </script>
</head>
<body>
<div class="wrap">
 <div class="page-title">
  <span class="modular fl"><i class="user"></i><em>添加广告</em></span>
 </div>
 <form id="form" target="ajaxFrame">
  <table class="noborder">
   <tr>
    <td width="15%" style="text-align:right;">广告名称：</td>
    <td><input name="title" id="title" type="text" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">广告图片：</td>
    <td><input onchange="showImg(this)" name="file" id="payImg" type="file" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;width: 100px;height: 100px">图片预览</td>
    <td><img src="" id="imgHeader" alt=""/></td>
   </tr>
   <tr>
    <td style="text-align:right;">广告商品ID：</td>
    <td><input name="commodityId" id="commodityId" type="number" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">广告位置：</td>
    <td>
     <select id="place" name="place" class="inline-select">
     <option>请选择广告位置</option>
    </select>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">广告楼层：</td>
    <td><input name="floorId" id="floorId" type="text" class="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">开始时间：</td>
    <td><input name="startTime" id="startTime" type="datetime" class="textBox length-middle"/></td>
    <td>年/月/日 时:分:秒</td>
   </tr>
   <tr>
    <td style="text-align:right;">结束时间：</td>
    <td><input name="endTime" id="endTime" type="datetime" class="textBox length-middle"/></td>
    <td>年/月/日 时:分:秒</td>
   </tr>
   <tr>
    <td style="text-align:right;">是否禁用：</td>
    <!--class="textBox length-middle"-->
    <td id="status"><input name="status" type="radio" value="2"/>是<input name="status" type="radio" value="1"/>否</td>
    <td></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input onclick="baocun()" type="submit" class="tdBtn" value="保存"/></td>
   </tr>
  </table>
 </form>
 <iframe id="ajaxFrame" name="ajaxFrame" style="display:none;"></iframe>
 </div>
</body>
</html>