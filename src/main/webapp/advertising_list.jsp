﻿<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>广告列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
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
            <th>广告商品</th>
            <th>广告位置</th>
            <th>楼层</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>图片</td>
            <td>商品名</td>
            <td>位置</td>
            <td>楼层</td>
            <td>开始时间</td>
            <td>结束时间</td>
            <td class="center">
                <a href="advertising.jsp" title="编辑"><img src="images/icon_edit.gif"/></a>
                <a title="删除"><img src="images/icon_drop.gif"/></a>
            </td>
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