<%@ taglib prefix="c" 
        uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
        <html> 
        <head> 
        <meta http-equiv="Content-Type" content="text/html; 
        charset=ISO-8859-1"> 
        <link rel="stylesheet" 
   href="https://stackpath.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> 
        <title>Products</title> 
        </head> 
        <body> 
           <section> 
              <div class="jumbotron"> 
                 <div class="container"> 
                    <h1>Products</h1> 
                    <p>All the available products in our store</p> 
                 </div> 
              </div> 
           </section> 
 
           <section class="container"> 
              <div class="row"> 
              <div class="card container-fluid">
              <c:forEach items="${products}" var="product">
                 <div class="col-ms-6 col-md-3" style="padding-bottom: 20px"> 
                
                    <div class="thumbnail">
                   <img src="<c:url value="/img/${product.productId}.jpg">
      </c:url>" alt="image"  style = "width:100%"/>
                       <div class="caption"> 
                          <h3>${product.name}</h3> 
                          <p>${product.description}</p> 
           <p>${product.unitPrice} USD</p> 
           <p>Available <b>${product.unitsInStock}</b> units in stock</p>
           <p>
           		<a href="<spring:url value="/product/?id=${product.productId}"/>" class="btn btn-primary">
           		<span class="glyphicon glyphicon-eye-open"></span> Details
           		</a>
           </p>
                       </div>
                       
                    </div> 
                 </div> 
                 
                 </c:forEach>
                 </div>
              </div> 
             
           </section> 
        </body> 
        </html> 