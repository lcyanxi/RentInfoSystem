<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>租房管理系统</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary JavaScript plugins) -->
<script type='text/javascript' src="js/jquery-1.11.1.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />

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
  <script src="js/responsiveslides.min.js"></script>
<script>
    // You can also use "$(window).load(function() {"
    $(function () {
      // Slideshow 1
      $("#slider1").responsiveSlides({
         auto: true,
		 nav: true,
		 speed: 500,
		 namespace: "callbacks",
      });
    });
  </script>
  
</head>
<body>
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
					<li class="top_link"> <c:choose>  <c:when test="${session.username!=null}"><a href="logout.action">注销</a></c:when>
					                      <c:otherwise>注销</c:otherwise></c:choose></li>					
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
				<a href="cart.html"></a>	
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
			 <li><a class="color3" href="showRentInData.action">求租结果</a></li>	
			 <li><a class="color7" href="showRentOutData.action">出租结果</a></li>				
			 <li><a class="color5" href="userInfo.action">个人信息中心</a></li>	
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
<div class="content">
	 <div class="container">
		 <div class="slider">
				<ul class="rslides" id="slider1">
				  <li><img src="images/house1.jpg" alt=""></li>
				  <li><img src="images/house2.jpg" alt=""></li>
				  <li><img src="images/house3.jpg" alt=""></li>
				  <li><img src="images/house4.jpg" alt=""></li>
				  <li><img src="images/house5.jpg" alt=""></li>
				</ul>
		 </div>
	 </div>
</div>
<!---->
<div class="bottom_content">
	 <div class="container">
		 <div class="sofas">
			 <div class="col-md-6 sofa-grid">
				 <img src="images/house8.jpg" alt=""/>
				 <h3>求租列表</h3>
				 <h4><a href="showRentInData.action">求租列表</a></h4>
			 </div>
			 <div class="col-md-6 sofa-grid sofs">
				 <img src="images/house7.jpg" alt=""/>
				 <h3>出租列表</h3>
				 <h4><a href="showRentOutData.action">出租列表</a></h4>
			 </div>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<!---->
<div class="new">
	 <div class="container">
		 <h3>All THE LATEST RENTININFO</h3>
		 <div class="new-products">
		 <div class="new-items">
		 <c:forEach var="entry" items="${list}" varStatus="status">
                  <div class="item4">
				 <a href="products.html"><img src="images/s4.jpg" alt=""/></a>
				  <div class="item-info4">
					 <h4><a href="products.html">Dream Furniture Bed</a></h4>
					 <span>ID: SR5421</span>
					 <a href="single.html">Buy Now</a>
				 </div>		
			 </div>                                             
                </c:forEach>
			 </div>
		 </div>
		 <div class="clearfix"></div>	
	 </div>		 
</div>
<!---->
<div class="top-sellers">
	 <div class="container">
		 <h3>ALL THE LATEST RENTOUTINFO</h3>
		 <div class="seller-grids">
		 <c:forEach var="entry" items="${list}" varStatus="status">
                   <div class="col-md-3 seller-grid">
				 <a href="products.html"><img src="images/xu1.jpg" alt=""/></a>
				 <span>ID: ${entry.user.userId}</span>
				 <p>money:${entry.money}/左右</p>
				 <p>datatime:${entry.publish_time}</p>
				  <p>期望地点:${entry.address}</p>
				 <a href="deleteRentIn.action?id=${id}&inId=${entry.in_id}&username=${username}">删除</a>
			 </div>                                             
                </c:forEach>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<!---->

<!---->
<div class="footer-content">
	 <div class="container">
		 <div class="ftr-grids">
			 <div class="col-md-3 ftr-grid">
				 <h4>About Us</h4>
				 <ul>
					 <li><a href="#">Who We Are</a></li>
					 <li><a href="contact.html">Contact Us</a></li>				 
				 </ul>
			 </div>
			 <div class="col-md-3 ftr-grid">
				 <h4>Customer service</h4>
				 <ul>
					 <li><a href="#">FAQ</a></li>
					 <li><a href="#">Shipping</a></li>				 
				 </ul>
			 </div>
			 <div class="col-md-3 ftr-grid">
				 <h4>Your account</h4>
				 <ul>
					 <li><a href="account.html">Your Account</a></li>
					 <li><a href="#">Personal Information</a></li>
		         </ul>
			 </div>
			 <div class="col-md-3 ftr-grid">
				 <h4>Categories</h4>
				 <ul>
					 <li><a href="#">Furinture</a></li>
					 <li><a href="#">Bean Bags</a></li>				 
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
			 <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.777moban.com/">777模板</a></p>
		 </div>			 
	 </div>
</div>
<!---->
</body>
</html>