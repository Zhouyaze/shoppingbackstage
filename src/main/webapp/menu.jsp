<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>左侧导航</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
<body style="background:#313131">
<div class="menu-list">
 <a href="main.jsp" target="mainCont" class="block menu-list-title center" style="border:none;margin-bottom:8px;color:#fff;">起始页</a>
 <ul>
  <li class="menu-list-title">
   <span>订单管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="order_list.jsp" title="商品列表" target="mainCont">订单列表</a></li>
   </ul>
  </li>
 
  <li class="menu-list-title">
   <span>商品管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="product_list.jsp" title="商品列表" target="mainCont">商品列表</a></li>
    <li><a href="product_category.jsp" title="商品分类" target="mainCont">商品分类</a></li>
    <li><a href="recycle_bin.jsp" title="商品分类" target="mainCont">商品回收站</a></li>
   </ul>
  </li>

  <li class="menu-list-title">
   <span>促销商品管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="promotionCommodity_list.jsp" title="促销商品列表" target="mainCont">促销商品列表</a></li>
   </ul>
  </li>
  <li class="menu-list-title">
   <span>会员管理</span>
   <i>◢</i>
  </li>

  <li>
   <ul class="menu-children">
    <li><a href="user_list.jsp" title="会员列表" target="mainCont">会员列表</a></li>
    <li><a href="add_user.jsp" title="添加会员" target="mainCont">添加会员</a></li>
    <!--<li><a href="user_rank.jsp" title="会员等级" target="mainCont">会员等级</a></li>-->
    <!--<li><a href="user_message.jsp" title="会员留言" target="mainCont">会员留言</a></li>-->
   </ul>
  </li>

  <li class="menu-list-title">
   <span>广告管理</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="advertising_list.jsp" title="广告信息展示" target="mainCont">广告列表</a></li>
   </ul>
  </li>

  <li class="menu-list-title">
   <span>付款方式</span>
   <i>◢</i>
  </li>
  <li>
   <ul class="menu-children">
    <li><a href="payMent_list.jsp" title="付款方式列表" target="mainCont">付款方式</a></li>
   </ul>
  </li>
 </ul>
</div>

</body>
</html>