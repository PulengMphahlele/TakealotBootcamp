<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Morwamckay.com">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Register-TAKEALOT</title>
     <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/custom.css" rel="stylesheet' />">
    <link rel="Shortcut Icon" href="<c:url value='/static/icons/favicon.ico' />" type="image/x-icon">
    <link href="<c:url value='/static/css/awesome-fonts.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>

  </head>
  
  
  <body data-spy="scroll" data-target="#my-navbar">
  <!--Navbar-->
  <nav class="navbar navbar-white navbar-top" id="my-navbar">
	<div class="container">
		<div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                    </button>

                    <a href="<c:url value='/index' />" class="navbar-brand"><img style="max-width: 160px; margin-top: -7px;" src="<c:url value='/static/img/Capture.PNG' />"></a>
		</div><!-- end navbar header-->
		<div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav navbar-nav">
			<li><a href="#contact">Help</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a>Hi!</a>
				<li><a href="<c:url value='/login' />">Login</a></li>
				<li><a href="<c:url value='/new' />">Register</a></li>
				<li> 
				<div class="dropdown" title="Account">
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
  

	<div class="container1">
		<div class="dropdown1" style="margin-top:10px; margin-left:230px; margin-bottom:10px;">
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
					<a href="#" style="background-color:#72DB8E; color:white; font:bold; font-size:18px;">DAILY DEALS</a>
					
				</div>
		</div>
	
	</div><!-- End of container-->
	
	<!-- form container-->
<div class="container">
     <div class="row">
			<div style="padding-top:40px;" class="col-lg-3">
				<div class ="container2">
                                    <image class="center-block " src="<c:url value='/static/icons/delivery-icon.png' />" width="48" />
					<div class="call-to-action" style="text-align:center">Enjoy <span class="emphasis">free delivery</span><br/>
					worth R60 on your first <br/> order</div>
					<div class="terms-and-conditions" style="text-align:center"><a href="http://www.takealot.com/about/free-delivery-on-your-first-order" target="_blank">T&amp;Cs apply</a></div>
				</div>
				<div class ="container3">
					<p ><strong>Safe Shopping at Takealot</strong></p>
					<p>Rest assured your transaction is safe.</p>
					<span id="siteseal"><script async type="text/javascript" src="https://seal.godaddy.com/getSeal?sealID=lIXaUCxWLw82GGzts7WRPoMYg3YckhnWQpeicMnsG7mPgolPwcUUpLkrXxtq"></script></span>
					<br/>
					<br/>
					<p>This technology safeguards your personal information and guarantees privacy.</p>

				</div>
			</div>
			<div class="col-lg-9">
				<div class="panel-heading">
					<div class="panel-title text-left">
						<h1 class="title"> Register </a></h1>
						<hr />
					</div>
				</div> 
				<div class="main-login main-center" >
				
                                    <form:form method="POST" modelAttribute="user">
                                            <form:input type="hidden" path="userID" id="userID"/>
                                            <table>
                                                <tr>
                                                        <td><label for="firstName">First Name: </label> </td>
                                                        <td><form:input path="firstName" id="firstName"/></td>
                                                        <td><form:errors path="firstName" cssClass="error"/></td>
                                                </tr>

                                                <tr>
                                                        <td><label for="lastName">Last Name: </label> </td>
                                                        <td><form:input path="lastName" id="lastName"/></td>
                                                        <td><form:errors path="lastName" cssClass="error"/></td>
                                                </tr>

                                                <tr>
                                                        <td><label for="emailAddress">Email: </label> </td>
                                                        <td><form:input path="emailAddress" id="emailAddress"/></td>
                                                        <td><form:errors path="emailAddress" cssClass="error"/></td>
                                                </tr>

                                                <tr>
                                                        <td><label for="password">Password: </label> </td>
                                                        <td><form:input type="password" path="password" id="password"/></td>
                                                        <td><form:errors path="password" cssClass="error"/></td>
                                                </tr>

                                               

                                                 <tr>
                                                        <td><label for="phone">Mobile Number: </label> </td>
                                                        <td><form:input path="phone" id="phone"/></td>
                                                        <td><form:errors path="phone" cssClass="error"/></td>
                                                </tr>
                                                 <tr>
                                                        <td><label for="gender">Gender: </label> </td>
                                                        <td><form:input path="gender" id="gender"/></td>
                                                        <td><form:errors path="gender" cssClass="error"/></td>
                                                </tr>
                                                <tr>
                                                        <td><label for="birthdate">Date of Birth: </label> </td>
                                                        <td><form:input path="birthdate" id="birthdate"/></td>
                                                        <td><form:errors path="birthdate" cssClass="error"/></td>
                                                </tr>

                                                <tr>
                                                        <td colspan="3">
                                                                <c:choose>
                                                                        <c:when test="${edit}">
                                                                                <input type="submit" value="Update"/>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                                <input type="submit" value="Register"/>
                                                                        </c:otherwise>
                                                                </c:choose>
                                                        </td>
                                                </tr>
                                            </table>
                                    </form:form>
				</div> 
			</div>
	</div> 
</div>  
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<c:url value='/static/js/ajaxJquery.js' />"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/static/js/scripts.js' />"></script>
  </body>
</html>


	
	
	
	
	
	