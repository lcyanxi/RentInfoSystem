<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Account</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary JavaScript plugins) -->
<script type='text/javascript' src="js/jquery-1.11.1.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Furnyish Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.useso.com/css?family=Montserrat|Raleway:400,200,300,500,600,700,800,900,100' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Playfair+Display:400,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Aladin' rel='stylesheet' type='text/css'>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/menu_jquery.js"></script>
<script src="js/simpleCart.min.js"> </script>
  <style type="text/css">
    th{
      width: 150px;
      height: 50px;
    }
  </style>
  <script type="text/javascript">
	function disp_confirm() {
		var r = confirm("Are you sure ?");
		if (r) {
			login();
		}else{
		}
	}
	
	function login() {
        $.ajax({
            type: "POST",
            url: "checkOut.action",
            data: {
                "outId": $.trim($("[type = 'radio']:checked").prop("name")),
                "message": $.trim($("[type = 'radio']:checked").val())
            },
           // dataType: "json",
            //jsonp: "callbackparam",
           // async: true,
            success: function (data) { 
                 alert("success");              
                window.location.reload();
            },
            error: function () {
                alert("error");
            } 
        });
    }
	
	
	
</script>
</head>
<body>
<!-- header -->
<!-- header -->
<div class="top_bg">
	<div class="container">
		<div class="header_top-sec">
			<div class="top_right">
				<ul>
				  <h2>Beihua University</h2>
				</ul>
			</div>
			<div class="top_left">
				<ul>
				    <li class="top_link"> <c:if test="${session.username!=null}">
				    <img alt="我的头像" src="Image/${session.head_Image}" width="50px" height="50px"></c:if>
				    </li>
					<li class="top_link">用户名:${session.username}</li>
					<li class="top_link"><c:choose>  <c:when test="${session.username!=null}"><a href="logout.action">注销</a></c:when>
					                      <c:otherwise>注销</c:otherwise></c:choose></li>|					
				</ul>
				<div class="social">
					<ul>
						<li><a href="#"><i class="facebook"></i></a></li>
						<li><a href="#"><i class="twitter"></i></a></li>
						<li><a href="#"><i class="dribble"></i></a></li>	
						<li><a href="#"><i class="google"></i></a></li>										
					</ul>
				</div>
			</div>
				<div class="clearfix"> </div>
		</div>
	</div>
</div>
<div class="header_top">
	 <div class="container">
		 <div class="logo">
		 <h1>租房管理系统</h1>		 
		 </div>
		 <div class="header_right">	
			 <div class="login">
				 <a href="login.jsp">登录</a>
			 </div>
			 <div class="cart box_1">
				<a href="#">
					<h3> <span class="simpleCart_total">$0.00</span> (<span id="simpleCart_quantity" class="simpleCart_quantity">0</span> items)<img src="images/bag.png" alt=""></h3>
				</a>	
				<p><a href="javascript:;" class="simpleCart_empty">Empty cart</a></p>
				<div class="clearfix"> </div>
			 </div>				 
		 </div>
		  <div class="clearfix"></div>	
	 </div>
</div>
<!--cart-->
	 
<!------>
<div class="mega_nav">
	 <div class="container">
		 <div class="menu_sec">
		 <!-- start header menu -->
		 <ul class="megamenu skyblue">
			 <li class="active grid"><a class="color1" href="index.jsp">首页</a></li>
			 <li class="grid"><a class="color2" href="rentIn.jsp">求租申请</a></li>
			<li><a class="color4" href="rentOut.jsp">出租申请</a></li>
			<li><a class="color7" href="showRentInData.action">求租结果</a></li>					
			<li><a class="color5" href="userInfo.action">个人中心</a></li>	
			<li><a class="color6" href="#">安全退出</a></li>					
		 </ul> 
			   <div class="search">
				 <form>
					<input type="text" value="" placeholder="Search...">
					<input type="submit" value="">
					</form>
			 </div>
			 <div class="clearfix"></div>
		 </div>
	  </div>
</div>
<!---->
<div class="container">
	  <ol class="breadcrumb">
		  <li><a href="index.jsp">首页</a></li>
		  <li class="active">出租结果</li>
		 </ol>
	 <div class="registration">
		 <div class="registration_left">
			 <h2>出租史|<span><a href="rentOut.jsp">出租申请?</a> </span></h2>		 
  	<div class="menu_sec" style="width: 1150px"> 
					<table >
						<tr>
						   <th>房屋照片</th>
						   <th>发布者姓名</th>
						   <th>发布时间</th>
						   <th>租金</th>
						   <th>设备</th>
						   <th>地点</th>
						   <th>面积</th>						   
						   <th>审核</th>
						   <th>通过</th>
						   <th>操作</th>
						 </tr>
						 <c:forEach var="entry" items="${listOut}"   varStatus="status">
                      <tr>
                           <td><img src="<%=path%>/Image/${entry.house_pictures}" width="150" height="80"></td>
                           <td>${entry.user.userName}</td>
                           <td>${entry.publish_time}</td>
                           <td>${entry.money}</td>
                           <td>${entry.equipment }</td>
                           <td>${entry.address}</td>
                           <td>${entry.area}</td>
                           <td>${entry.checked}</td>
                           
                     <c:choose>
					    <c:when test="${entry.checked}"><td>${entry.legal}</td>
					    </c:when>
						<c:otherwise>
					       <td><input type="radio" name=${entry.out_id} value="Y"onclick="disp_confirm()" />Y 
						   <input type="radio" name=${entry.out_id} value="N" onclick="disp_confirm()" />N</td>
					   </c:otherwise>
					</c:choose>
                                                 
                         <td><a href="deleteRentOut.action?outId=${entry.out_id}"><font color="#008080">删除</font></a></td>
                     </tr>
                </c:forEach>
                     <tr>
                <c:choose>
                 <c:when test="${page.hasPrePage }">
                         <th><a href="showRentOutData.action?currentPage=1">首页</a></th>
                         <th colspan="2"><a href="showRentOutData.action?currentPage=${page.currentPage-1}">上一页</a></th>
                         <th >当前页${page.currentPage}</th>
                   </c:when>
                   <c:otherwise>
                        <td>首页</td>
                        <td colspan="2">上一页</td>
                        <td >当前页${page.currentPage}</td>
                   </c:otherwise>
                </c:choose>
                
                  <c:choose>
                   <c:when test="${page.hasNextPage}">
                        <td><a href="showRentOutData.action?currentPage=${page.currentPage+1}">下一页</a></td>
                        <th colspan="2">总页数${page.totalPage}</th>
                        <th colspan="2" align="center"><a href="showRentOutData.action?currentPage=${page.totalPage}">尾页</a></th>
                   </c:when>
                   <c:otherwise>
                       <td>下一页</td>
                        <td colspan="2">总页数${page.totalPage}</td>
                       <td colspan="2" align="center">尾页</td>
                   </c:otherwise>
                  </c:choose>
                   </tr>	
			 </table>
				 </div> 
			 </div>
		 </div>
		 <div class="clearfix"></div>
</div>
<!-- end registration -->
<div class="footer-content">
	 <div class="container">
		 <div class="ftr-grids">
			 <div class="col-md-3 ftr-grid">
				 <h4>About Us</h4>
				 <ul>
					 <li><a href="#">Who We Are</a></li>
					 <li><a href="contact.html">Contact Us</a></li>
					 <li><a href="#">Our Sites</a></li>
					 <li><a href="#">In The News</a></li>
					 <li><a href="#">Team</a></li>
					 <li><a href="#">Carrers</a></li>					 
				 </ul>
			 </div>
			 <div class="col-md-3 ftr-grid">
				 <h4>Customer service</h4>
				 <ul>
					 <li><a href="#">FAQ</a></li>
					 <li><a href="#">Shipping</a></li>
					 <li><a href="#">Cancellation</a></li>
					 <li><a href="#">Returns</a></li>
					 <li><a href="#">Bulk Orders</a></li>
					 <li><a href="#">Buying Guides</a></li>					 
				 </ul>
			 </div>
			 <div class="col-md-3 ftr-grid">
				 <h4>Your account</h4>
				 <ul>
					 <li><a href="account.html">Your Account</a></li>
					 <li><a href="#">Personal Information</a></li>
					 <li><a href="#">Addresses</a></li>
					 <li><a href="#">Discount</a></li>
					 <li><a href="#">Track your order</a></li>					 					 
				 </ul>
			 </div>
			 <div class="col-md-3 ftr-grid">
				 <h4>Categories</h4>
				 <ul>
					 <li><a href="#">Furinture</a></li>
					 <li><a href="#">Bean Bags</a></li>
					 <li><a href="#">Decor</a></li>
					 <li><a href="#">Kichen & Dinning</a></li>
					 <li><a href="#"> Bed & Bath</a></li>
					 <li><a href="#">...More</a></li>					 
				 </ul>
			 </div>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<!---->
<div class="footer">
	 <div class="container">
		 <div class="copywrite">
			 <p>Copyright &copy; 2015.Company name All rights reserved--李常</p>
		 </div>			 
	 </div>
</div>
<!---->
</body>
</html>

