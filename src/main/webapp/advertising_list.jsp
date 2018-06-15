<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>广告列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script type="text/javascript">
        var totalPageCount;
        var currentPage;
        $(document).ready(function showAdvertisingInfo() {
            currentPage = 1;
            getAdvertisingInfo(currentPage);
        })
    </script>
    <script type="text/javascript">
        function getAdvertisingInfo(currentPage) {
            $.ajax({
                type: "GET",
                contentType: "application/json; charset=utf-8",
                async: true,
                url: "http://localhost:8080/selectAll",
                data: {currentPage: currentPage},
                success: function (data) {
                    var str = ""
                    optionJson = data.t.page.records
                    totalPageCount=data.t.page.totalPageCount
                    for (var index = 0; index < optionJson.length; index++) {
                        str += "<tr>" +
                            "<td>" + optionJson[index].id + "</td>" +
                            "<td>" + optionJson[index].title + "</td>" +
                            "<td><img src=" + optionJson[index].pictureUrl + " alt=" + optionJson[index].pictureUrl + "></td>" +
                            "<td>" + optionJson[index].commodityId + "</td>" +
                            "<td>" + optionJson[index].place + "</td>" +
                            "<td>" + optionJson[index].floorId + "</td>" +
                            "<td>" + optionJson[index].startTime + "</td>" +
                            "<td>" + optionJson[index].endTime + "</td>"
                                if(optionJson[index].status==1){
                            str+="<td>是</td>"
                                }else{
                            str+="<td>否</td>"
                                }

                            str+="<td class=\"center\">" +
                            "<a href=\"edit_advertising.jsp?id="+optionJson[index].id+"&title="+optionJson[index].title+
                            "&pictureUrl="+optionJson[index].pictureUrl+
                            "&commodityId="+optionJson[index].commodityId+
                            "&place="+optionJson[index].place+
                            "&floorId="+optionJson[index].floorId+
                            "&startTime="+optionJson[index].startTime+
                            "&endTime="+optionJson[index].endTime+
                            "&status="+optionJson[index].status+
                            "\" title=\"编辑\"><img src=\"images/icon_edit.gif\"/></a>" +
                            "<a href=\"delete_advertising.jsp?id="+optionJson[index].id+"\" title=\"删除\"><img src=\"images/icon_drop.gif\"/></a>" +
                            "</td>" +
                            "</tr>"
                        document.getElementById("bodyInfo").innerHTML=str
                    }
                    document.getElementById("result").innerHTML = currentPage + "/" + totalPageCount;
                }
            })
        }
    </script>
    <script type="text/javascript">

        /*
        分页下一页
        */
        function pageJia() {
            if (currentPage < totalPageCount) {
                currentPage++;
                getAdvertisingInfo(currentPage)
                document.getElementById("result").innerHTML = currentPage + "/" + totalPageCount;
            }
        }

        /*
        分页上一页
        */
        function pageJian() {
            if (currentPage > 1) {
                currentPage--;
                getAdvertisingInfo(currentPage)
                document.getElementById("result").innerHTML = currentPage + "/" + totalPageCount;
            }
        }

        /*
         * 分页跳转
         */
        function tiaozhuan() {
            currentPage = parseInt($("#yema").val());
            if (currentPage > totalPageCount) {
                currentPage = totalPageCount
                document.getElementById("yema").value = totalPageCount;
            } else if (currentPage < 1) {
                pagecount = 1
                document.getElementById("yema").value = 1;
            }
            getAdvertisingInfo(currentPage)
            document.getElementById("result").innerHTML = currentPage + "/" + totalPageCount;
        }
    </script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i></i><em>广告列表</em></span>
        <span class="modular fr"><a href="advertising.jsp" class="pt-link-btn">+添加广告</a></span>
    </div>
    <table class="list-style Interlaced">
        <tr>
            <th>广告编号</th>
            <th>广告名称</th>
            <th>图片路径</th>
            <th>广告商品ID</th>
            <th>广告位置</th>
            <th>楼层</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>是否禁用</th>
            <th>操作</th>
        </tr>

        <tbody id="bodyInfo"></tbody>
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
                <a onclick="pageJian()">上一页</a>
                <a>跳转至</a>
                <input type="text" id="yema" style="width: 20px;"/>
                <a onclick="tiaozhuan()">跳转</a>
                <a onclick="pageJia()">下一页</a>
                <a id="result"></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>