
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
<script src="/webstore/resources/js/controllers.js"></script>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; 
      charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<!-- https://stackpath.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css -->
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
			<div class="pull-right" style="padding-right:50px"> 
            
            <a href="<c:url value="/logout" />">Logout</a>            
         </div>
		</div>
	
	
         </section>
	<section class="container" ng-app="cartApp">
		<div class="row">
		<div class="col-md-5"> 
         <img src="<c:url value="/img/${product.productId}.jpg">
         </c:url>" alt="image"  style = "width:inherit%"/> 
      </div> 
			<div class="col-xs-4">
				<div class="thumbnail">

					<div class="caption">
						<h3>${product.name}</h3>
						<p>${product.description}</p>
						<p>
							<strong>Item Code : </strong><span class="label label-success">${product.productId}
							</span>
						</p>
						<p>
							<strong>manufacturer</strong> : ${product.manufacturar}
						</p>
						<p>
							<strong>category</strong> : ${product.category}
						</p>
						<p>
							<strong>Availble units in stock </strong> :
							${product.unitsInStock}
						</p>
						<h4>${product.unitPrice}USD</h4>
						<p ng-controller="cartCtrl">
						 <a href="<spring:url value="/products" />" class="btn btn-primary btn-large"> <span
								class="glyphicon-hand-left glyphicon"> </span> Back to Products
							</a>
							<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')"> <span
								class="glyphicon-shopping-cart glyphicon"> </span> Order Now
							</a>
							<a href="<spring:url value="/cart" />" class="btn btn-default">  <span class="glyphicon-hand-right glyphicon"></span> View Cart </a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
