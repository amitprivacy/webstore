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
              <div class="jumbotron jumbotron-fluid"> 
                 <div class="container"> 
                    <h1>Products</h1> 
                    <p>All the available products in our store</p> 
                    <div class="pull-right" style="padding-right:50px"> 
            
            <a href="<c:url value="/logout" />">Logout</a>            
         </div>
                 </div> 
              </div> 
           </section> 
 
           <section class="container"> 
              <div class="row"> 
        
      <!--   <div class="col-sm-4 py-2">
            <div class="card card-body h-100">
                Card. I'm just a simple card-block.
            </div>
        </div>  -->
              
              <c:forEach items="${products}" var="product">
              
                 <div class="card card-body h-80" style="padding-bottom: 20px;"> 
                <div class="col-sm-4 py-2">
                    <div class="thumbnail">
                   <img src="<c:url value="/img/${product.productId}.jpg">
      </c:url>" alt="image"  style = "width:inherit; height: inherit;"/>
                       <div class="caption"> 
                          <h3>${product.name}</h3> 
                          <p>${product.description}</p> 
           <p>${product.unitPrice} USD</p> 
           <p>Available <b>${product.unitsInStock}</b> units in stock</p>
           <p>
           		<a href="<spring:url value="/product/?id=${product.productId}"/>" class="btn btn-primary" style="width: 100%">
           		<span class="glyphicon glyphicon-eye-open"></span> Details
           		</a>
           </p>
                       </div>
                       
                    </div> 
                 </div> 
              </div>   
            
                 </c:forEach>
                 </div>
              
             
           </section> 
        </body> 
        </html> 