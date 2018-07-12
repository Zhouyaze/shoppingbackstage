<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 2018/6/13
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改广告</title>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script>
        $(document).ready(function updateAdvertisement() {
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
            var url=decodeURI(location.search)
            params = {};
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    params[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
            $("#commodityId").val(params.commodityId)
            $("#endTime").val(params.endTime)
            $("#floorId").val(params.floorId)
            $("#id").val(params.id)
            $("#place").val(params.place)
            $("#startTime").val(params.startTime)
            $("#title").val(params.title)
            var radios = document.getElementsByName("status");

            for (var i=0;i<$("#status input[name=status]").length;i++){
                if (radios[i].value==params.status){
                    $("input[name='status'][value="+(i+1)+"]").attr("checked",'checked');
                }
            }
        })
    </script>
    <script>
        function baocun() {

            var form = new FormData(document.getElementById("form"));
            if(form.get("file").name == ""){
                form.delete("file");
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/updateAll?id="+params.id,
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(data){
                    alert("修改成功")
                    window.location.href="advertising_list.jsp"
                },
                error:function(e){
                    alert("修改失败");
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
        <span class="modular fl"><i class="user"></i><em>修改广告</em></span>
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
