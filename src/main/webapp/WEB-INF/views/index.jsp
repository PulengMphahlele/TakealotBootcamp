<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
   <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Morwamckay.com">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>takealot.com: Online Shopping | SA's Favourite Online Store</title>
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/custom2.css" rel="stylesheet' />">
    <link rel="Shortcut Icon" href="<c:url value='/static/icons/favicon.ico' />" type="image/x-icon">
    <link href="<c:url value='/static/css/awesome-fonts.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
  
  </head>
  <body>
  <!--Navbar-->
  <nav class="navbar navbar-white navbar-top" id="my-navbar">
	<div class="container" style="margin-right:50px; width: 1400px;">
		<div class="navbar-header">
						
			<a href="<c:url value='/index' />" class="navbar-brand"><img style="max-width: 160px; margin-top: -7px;" src="<c:url value='/static/img/Capture.PNG' />"></a>
		</div><!-- end navbar header-->
		<div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav navbar-nav">
			<li><a href="#contact">Help</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a>Hi!</a></li>
				<li><a href="<c:url value='/login' />">Login</a></li>
				<li><a href="<c:url value='/new' />">Register</a></li>
				<li> 
				<div class="dropdown">
					<button class="dropbtn"><a href="">My Account</a>
					<span class="caret"></span></button>
					<div class="dropdown-content">
						<a href="#features">My Account</a>
						<a href="#">Track Order</a>
						<a href="#feedback">Log Return</a>
						<a href="#gallery">Invoices</a>
						<a href="#feedback">Personal Details</a>
						<a href="#gallery">Digital Library</a>
					</div>
				</div>
				</li>
				<li>
				<div class="Wish_list">
					<button class="list" style="margin:10px; border:0px; color: White; background-color: red;">
					<a href="wishlist.htm" title="Wish List"></a>
					<span style="padding:10px;" class="glyphicon glyphicon-heart"></span>
					<span>0</span></button>
				</div>
				</li>
				<li>
				<div class="Cart">
					<button class="list" style="margin-top:10px; border:0px; color: White; background-color: green;">
					<a href="cart.htm" title="Cart"></a>
					<span style="padding:10px;" class="glyphicon glyphicon-shopping-cart"></span>
					<span>0</span></button>
				</div>
				</li>
			</ul>
			
		</div>
	</div><!-- End Container-->
  </nav><!-- End Navbar-->

  <!-- container-->
 
	<div class="container4">
		<div class="row"> <!-- End of 2nd row-->

			<div class="col-lg-3">
				<div class="dropdown1" style="margin-top:10px; margin-left:150px; margin-bottom:10px;">
					<button class="dropbtn1"><p>Shop by Department
					<span class="caret"></span></p></button>
					<div class="dropdown1-content">
						<a href="#">Liqour & Soft Drinks</a>
						<a href="#">Computers & Tablets</a>
						<a href="#">Cellphones & GPS</a>
						<a href="#">TV, Audio & Video</a>
						<a href="#">Cameras</a>
						<a href="#">Office & Stationary</a>
						<a href="#">Books</a>
						<a href="#">Gaming</a>
						<a href="#k">Movie & TV</a>
						<a href="#">Music</a>
						<a href="#">Home & Kitchen</a>
						<a href="#">DIY & Auto</a>
						<a href="#">Garden, Pool & Patio</a>
						<a href="#">Toys</a>
						<a href="#">Fashion</a>
						<a href="#">Sport</a>
						<a href="#">Camping & Outdoor</a>
						<a href="#">Digital Library</a>
						<a href="#">Baby & Toddler</a>
						<a href="#">Pets</a>
						<a href="#">Luggage & Travel</a>
						<a href="#">Vouchers</a>
						<a href="#" style="background-color:#72DB8E; color:white;font-size:18px;">DAILY DEALS</a>
						
					</div>
				</div>
			</div>
			<div class="col-lg-3">
				
					<form style="align:centre" class="form-inline" action="searchProgress1" method="post" >
						<div class="form-group " style="margin-top:10px; margin-left:-15px;">			
							<div class="col-lg-3">
							  <select class="form-control" id="day">
								<option value="all" selected="selected">Search All Departments</option>
								<option value="10">Baby &amp; Toddler</option>
								<option value="3">Books</option>
								<option value="14">Cameras</option>
								<option value="21">Camping &amp; Outdoors</option>
								<option value="16">Cellular &amp; GPS</option>
								<option value="13">Computers</option>
								<option value="25">Fashion</option>
								<option value="2">Gaming</option>
								<option value="23">Garden, Pool &amp; Patio</option>
								<option value="8">Health &amp; Beauty</option>
								<option value="12">Home &amp; Kitchen</option>
								<option value="19">Luggage &amp; Travel</option>
								<option value="1">Movies &amp; TV</option>
								<option value="5">Music</option>
								<option value="18">Office &amp; Stationery</option>
								<option value="17">Pets</option>
								<option value="11">Sport</option>
								<option value="15">TV, Audio &amp; Video</option>
								<option value="7">Toys</option>
							  </select>
							</div>
						</div>
					</form>
			</div>	
				<div class="col-lg-6 pull-right">
														
					<form style="align:centre" class="form-inline" action="searchProgress1" method="post" >
						<div class="form-group " style="margin-top:10px; margin-left:-80px;">
						
								<form class="navbar-form" role="search" >
									<div class="input-group">
										<input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term"  style="width:600px;">
										<div class="input-group-btn">
											<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
										</div>
									</div>
								</form>
						</div>
					</form>
				</div>
			
	</div>	<!-- End of 1st row-->
	<div class="row"> <!-- End of 2nd row-->
		<div class="col-lg-9 pull-right">
			<div class="btn-group col-lg-11"style="padding-left:0px; margin-right:50px;">
				<a href="" class="btn col-lg-3" style="background-color:#EAEAEA; border-right: 1px; ">New Arrivals</a>
				<a href="" class="btn col-lg-3" style="background-color:#EAEAEA;">Pre-Orders</a>
				<a href="" class="btn col-lg-3" style="background-color:#EAEAEA;">Clearance</a>
				<a href="" class="btn col-lg-3" style="background-color:#EAEAEA;">Daily Deals</a>
			</div>
		
		</div> 
	</div>  <!-- End of 2nd row-->
	</div><!-- End of container-->
	
	<div class="row">
		<div class="col-lg-4">
			
		</div>
		<div class="col-lg-5">
		<div class="container5">
		<section>
		 <div class="carousel slide fade" id="screenshot-carousel" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#screenshot-carousel" data-fade-to="0" class="active"></li>
				<li data-target="#screenshot-carousel" data-fade-to="1"></li>
				<li data-target="#screenshot-carousel" data-fade-to="2"></li>
			
			</ol>
			<div class="carousel-inner">
				
				<div class="item active">
                                    <img src="<c:url value='/static/img/winterdeal.png' />" alt="Text of the image"></img>
				</div>
				<div class="item">
					<img src="<c:url value='/static/img/winter2.png' />" alt="Text of the image"></img>
				</div>
				<div class="item">
					<img src="<c:url value='/static/img/laptop.png' />" alt="Text of the image"></img>
				</div>
			</div><!-- carouseln inner closed-->
			<a href="#screenshot-carousel" class="left carousel-control" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a href="#screenshot-carousel" class="right carousel-control" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div> <!-- Carousel close-->
		</section>
		</div>
		<div class="container6">
		<section>
		 <div class="carousel slide" id="screen-carousel" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#screen-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#screen-carousel" data-slide-to="1"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				
				<div class="item active" id="images">
					<img class="col-lg-3" src="<c:url value='/static/img/canon.gif' />" alt="canon" style="flout-left">
					<img class="col-lg-3" src="<c:url value='/static/img/kenwood.gif' />" alt="kenwood" style="flout-left">
					<img class="col-lg-3" src="<c:url value='/static/img/nike.gif' />" alt="nike" style="flout-right">
					<img class="col-lg-3" src="<c:url value='/static/img/samsung.gif' />" alt="sumsung"style="flout-right">
				</div>
				<div class="item">
					<img class="col-lg-3" src="<c:url value='/static/img/lenovo.gif' />" alt="lenovo"style="flout-left">
					<img class="col-lg-3" src="<c:url value='/static/img/lg.gif' />" alt="lg" style="flout-left">
					<img class="col-lg-3" src="<c:url value='/static/img/apple.gif' />" alt="apple" style="flout-right">
					<img class="col-lg-3" src="<c:url value='/static/img/nikon.jpg' />" alt="nikon"style="flout-right">
				</div>
				
			</div><!-- carouseln inner closed-->
			<a href="#screen-carousel" class="left carousel-control" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a href="#screen-carousel" class="right carousel-control" data-slide="next" >
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div> <!-- Carousel close-->
		</section>
		</div>
		</div>
		<div class="col-lg-3">
				<img class="col-lg-10" src="<c:url value='/static/images/side0.png' />" alt="Ad pic1" style="margin-top:20px;">
                                <img class="col-lg-10" src="<c:url value='/static/images/side1.png' />" alt="Ad pic2" style="margin-top:20px;">
				<img class="col-lg-10" src="<c:url value='/static/images/side2.png' />" alt="Ad pic3" style="margin-top:20px;">
				<img class="col-lg-10" src="<c:url value='/static/images/side4.png' />" alt="Ad pic4" style="margin-top:20px;">
				<img class="col-lg-10" src="<c:url value='/static/images/side5.png' />" alt="Ad pic5" style="margin-top:20px;">
				<img class="col-lg-10" src="<c:url value='/static/images/side3.png' />" alt="Ad pic6" style="margin-top:20px;">
		</div>
	
	</div>
	
</div>  <!-- End of row-->

	<a href="#" style="text-align:center; margin-top:10px;"><p>Switch to Mobile</p></a>
	 <!-- Jumbotron-->
  
  <div class="jumbotron" style="margin-top:10px; margin-bottom:0px; background-color:#F5F5F5; padding-bottom:10px; ">
	<div class="container">
	
		<div class="col-lg-2" style="margin-left:10px; color:black;">
			   
			   <p><strong>Shop</strong></p>
								
				<a href="">Daily Deals</a><br/>
				<a href="">App Only Deals</a><br/>
				<a href="">Our Hottest Products</a><br/>
				<a href="">Gift Vouchers</a><br/>
								
		</div>
		<div class="col-lg-2">
			<p><strong>Help</strong></p>
								
				<a href="">Contact Us</a><br/>
				<a href="">FAQ</a><br/>
				<a href="">Shipping & Delivery</a><br/>
				<a href="">Exchange & Returns</a><br/>
				<a href="">Bank Details</a><br/>
				<a href="">Directions to Warehouse</a><br/>
		</div>
		<div class="col-lg-2">
			<p><strong>Account</strong></p>
								
				<a href="">My Account</a><br/>
				<a href="">Trace Order</a><br/>
				<a href="">Exchange & Returns</a><br/>
				<a href="">Personal Details</a><br/>
				<a href="">Invoices</a><br/>
				<a href="">Digital Library</a><br/>
		</div>
		<div class="col-lg-2">
			<p><strong>Company</strong></p>
								
				<a href="">About Us</a><br/>
				<a href="">Careers</a><br/>
				<a href="">Sell on Takealot</a><br/>
				<a href="">Press & News</a><br/>
				<a href="">Competitions</a><br/>
				<a href="">Terms & Conditions</a><br/>
		</div>
		
		<div class="col-lg-3 pull-right">
			<p><strong>Download Our Apps</strong></p>
				<a href=""><img src="<c:url value='/static/images/f-appstore.png' />" alt="App Store" style="width: 100px; height: 25px; display: inline-block;margin-right: 5px;"></a>
				<a href=""><img src="<c:url value='/static/images/f-playstore.png' />" alt="Google Play" style="width: 100px; height: 25px; display: inline-block;margin-right: 5px;"></a>
			<br/><br/>
			<p><strong>Follow Us</strong></p>	
				<a href=""><img src="<c:url value='/static/img/facebook.png' />" alt="Facebook" style="width: 25px; height: 25px; display: inline-block;margin-right: 5px;"></a>
				<a href=""><img src="<c:url value='/static/img/twitter.png' />" alt="Twitter" style="width: 25px; height: 25px; display: inline-block;margin-right: 5px;"></a>
				<a href=""><img src="<c:url value='/static/img/gplus.png' />" alt="Google+" style="width: 25px; height: 25px; display: inline-block;margin-right: 5px;"></a>
				<a href=""><img src="<c:url value='/static/img/instagram.png' />" alt="Insta" style="width: 25px; height: 25px; display: inline-block;margin-right: 5px;"></a>
			
			
		</div>
	</div><!-- End of container-->
	<div class ="container">

		<ul class="breadcrumb" style="padding-top:20px;background-color:#F5F5F5; margin-top:20px; border-top: 1px solid gray; border-radius:0px;">
			<li><a href="#">Home</a></li>
			<li><a href="#">Garden.Pool & Patio</a></li>
			<li><a href="#">Camping & Outdoors</a></li>
			<li><a href="#">Office & Stationary</a></li>
			<li><a href="#">Luggage & travel</a></li>
			<li><a href="#">Camping & Outdoors</a></li>
			<li><a href="#">Health & Beauty</a></li>
			<li><a href="#">Pets</a></li>
			<li><a href="#">Sports</a></li>
			<li><a href="#">Home & Kitchen</a></li>
			<li><a href="#">Baby & toddler</a></li>
			<li><a href="#">Computers</a></li>
			<li><a href="#">Cameras</a></li>
			<li><a href="#">TV,Audio & Video</a></li>
			<li><a href="#">Cellular & GPS</a></li>
			<li><a href="#">Movies &TV </a></li>
			<li><a href="#">Gaming</a></li>
			<li><a href="#">Books</a></li>
			<li><a href="#">Music</a></li>
			<li><a href="#">Toys</a></li>
			<li><a href="#">Fashion</a></li>
       </ul>
	   
	</div>	
  
  </div><!-- End of Jumbotron-->
  	<!-- Footer-->
	
	<footer>
		
		<div class="jumbotron" Style="margin-top:0px; margin-left:0px; margin-right:0px;  background-color: #0B79BF; min-height: 80px">
			<div class="container">
			    <img src="<c:url value='/static/img/footer1.jpg' />" alt="Visa MasterCard" style="width: 150px; height: 30px; display: inline-block;margin-right: 5px;">
                            <img src="<c:url value='/static/img/footer2.jpg' />" alt="American Express" style="width: 80px; height: 30px; display: inline-block;margin-right: 5px;">
                            <img src="<c:url value='/static/img/footer3.jpg' />" alt="Diners Club Int" style="width: 80px; height: 30px; display: inline-block;margin-right: 5px;">
                            <img src="<c:url value='/static/img/footer4.png' />" alt="PayFast" style="width: 80px; height: 30px; display: inline-block;margin-right: 5px;">
                            <img src="<c:url value='/static/img/footer5.png' />" alt="i-PAY" style="width: 80px; height: 30px; display: inline-block;margin-right: 5px;">
                            <img src="<c:url value='/static/img/footer6.jpg' />" alt="eBucks" style="width: 80px; height: 30px; display: inline-block;margin-right: 5px;">
                            <img src="<c:url value='/static/img/footer7.jpg' />" alt="mobicred" style="width: 80px; height: 30px; display: inline-block;margin-right: 5px;">
                            <img src="<c:url value='/static/img/footer8.png' />" alt="Discovery Miles" style="width: 80px; height: 30px; display: inline-block;margin-right: 5px;">
			</div>
		</div> <!-- end jumbotron -->
	</footer>
	
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<c:url value='/static/js/ajaxJquery.js' />"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
  </body>
</html>

	