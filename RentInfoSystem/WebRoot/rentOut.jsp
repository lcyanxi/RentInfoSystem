<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<a href="cart.html">
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
			 <li><a class="color4" href="showRentInData.action">求租结果</a></li>	
			 <li><a class="color7" href="showRentOutData.action">出租结果</a></li>			
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
		  <li class="active">出租申请</li>
		 </ol>
	 <div class="registration">
		 <div class="registration_left">
			 <h2>想要出租房屋吗? <span> 那就把你的房屋信息留下吧</span></h2>
			  <h3> <c:if test="${result!=null }"><a href="showRentOutData.action"> ${result}现在去看看吧</a></c:if> </h3>
			 <!-- [if IE] 
				< link rel='stylesheet' type='text/css' href='ie.css'/>  
			 [endif] -->  
			  
			 <!-- [if lt IE 7]>  
				< link rel='stylesheet' type='text/css' href='ie6.css'/>  
			 <! [endif] -->  
			 <script>
				(function() {
			
				// Create input element for testing
				var inputs = document.createElement('input');
				
				// Create the supports object
				var supports = {};
				
				supports.autofocus   = 'autofocus' in inputs;
				supports.required    = 'required' in inputs;
				supports.placeholder = 'placeholder' in inputs;
			
				// Fallback for autofocus attribute
				if(!supports.autofocus) {
					
				}
				
				// Fallback for required attribute
				if(!supports.required) {
					
				}
			
				// Fallback for placeholder attribute
				if(!supports.placeholder) {
					
				}
				
				// Change text inside send button on submit
				var send = document.getElementById('register-submit');
				if(send) {
					send.onclick = function () {
						this.innerHTML = '...Sending';
					}
				}
			
			 })();
			 </script>
			 <div class="registration_form">
			 <!-- Form -->
				<form id="registration_form" action="rentOut.action" method="post" namespace="/" enctype="multipart/form-data">
					<div>
						<label>
						<input type="radio" name="rentOut.rent_in_type" id="rentTpye" value="整租" checked>整租
			            <input type="radio" name="rentOut.rent_in_type" id="rentTpye" value="合租" />合租						
						</label>
					</div>
					<div>
						<label>
							<input placeholder="标题" type="text" name="rentOut.title" tabindex="4" required>
						</label>
					</div>
					<div>
						<label>
							<input placeholder="租金" type="text" name="rentOut.money" tabindex="4" required>
						</label>
					</div>						
					<div>
						<label>
							<input placeholder="面积" type="text" name="rentOut.area" tabindex="4" required>
						</label>
					</div>	
					<div>
						<label>
							<input placeholder="地点" type="text" name="rentOut.address" tabindex="4" required>
						</label>
					</div>		
						<div>
						<label>
							<input  type="checkbox" name="rentOut.equipment" value="空调" checked />空调
			                <input  type="checkbox" name="rentOut.equipment" value="厨房"  />厨房
			               <input   type="checkbox" name="rentOut.equipment" value="电视"  />电视
			               <input  type="checkbox" name="rentOut.equipment" value="卫生间"  />卫生间
			               <input  type="checkbox" name="rentOut.equipment" value="宽带" />宽带
			               <input  type="checkbox" name="rentOut.equipment" value="阳台"  />阳台
						</label>
					</div>		
						<div>
						<label>
							<input placeholder="额外说明:" type="text" name="rentOut.detail" tabindex="3" required>
						</label>
					</div>	
					<div>
						<label>
							房屋照片:<input placeholder="房屋照片:" type="file" name="upload" tabindex="3" required>
						</label>
					</div>			
					<div>
						<input type="submit" value="提交申请表" id="register-submit">
					</div>
					<div class="sky-form">
						<label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>i agree to mobilya.com &nbsp;<a class="terms" href="#"> terms of service</a> </label>
					</div>
				</form>
				<!-- /Form -->
			 </div>
		 </div>
		
		 <div class="clearfix"></div>
	 </div>
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
					 <li><a href="#">> Furinture</a></li>
					 <li><a href="#">> Bean Bags</a></li>
					 <li><a href="#">> Decor</a></li>
					 <li><a href="#">> Kichen & Dinning</a></li>
					 <li><a href="#">> Bed & Bath</a></li>
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

