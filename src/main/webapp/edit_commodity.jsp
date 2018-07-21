<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/7/10
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script>
        $(document).ready(function getTypeName(){
            $.ajax({
                url:"${pageContext.request.contextPath}/SelectTypeLevels",
                data:[],
                type:"get",
                success:function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var obj=document.getElementById('typeName');
                        for (var i = 0; i < data.length; i++) {
                            obj.options.add(new Option(data[i].typeName,data[i].typeName)); //这个兼容IE与firefox
                        }
                    }
                }
            })
        })
    </script>
    <script>
        var params = {};
        function jiazai() {
            var url=decodeURI(location.search)
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    params[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
        }
    </script>
    <script>
        function baocun() {
            var form = new FormData(document.getElementById("form"));
            $.ajax({
                url:"${pageContext.request.contextPath}/updateCommodity?id="+params.id,
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(data){
                    if (data>0) {
                        alert("修改商品成功")
                        window.location.href = "product_list.jsp"
                    }else{
                        alert("修改商品失败，请再次尝试")
                    }
                },
                error:function(e){
                    alert("修改商品失败");
                    window.location.href="product_list.jsp"
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
<body onload="jiazai()">
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="add_user"></i><em>修改商品信息</em></span>
    </div>
    <form id="form" method="post" enctype="multipart/form-data" target="ajaxFrame">
        <table class="list-style">
            <tr>
                <td style="width:15%;text-align:right;">商品名称：</td>
                <td><input name="commodityName" id="commodityName" type="text" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td style="text-align:right;">商品类型：</td>
                <td><select id="typeName" name="typeName" class="inline-select">
                    <option>请选择商品类型</option>
                </select></td>
            </tr>
            <tr>
                <td style="text-align:right;">商品图片：</td>
                <td><input onchange="showImg(this)" name="picture" id="picture" type="file" class="textBox length-middle"/></td>
            </tr>
            <tr>
                <td style="text-align:right;width: 100px;height: 100px">商品图片预览：</td>
                <td><img src="" id="imgHeader" alt=""/></td>
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
