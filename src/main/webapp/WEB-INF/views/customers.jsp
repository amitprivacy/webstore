<%@ taglib prefix="c" 
        uri="http://java.sun.com/jsp/jstl/core"%> 
 
        <html> 
        <head> 
        <meta http-equiv="Content-Type" content="text/html; 
        charset=ISO-8859-1"> 
        <link rel="stylesheet" 
   href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"> 
        <title>Products</title> 
        </head> 
        <body> 
           <section> 
              <div class="jumbotron"> 
                 <div class="container"> 
                    <h1>Customers</h1> 
                    <p>All the available customers in our store</p> 
                 </div> 
              </div> 
           </section> 
 
           <section class="container"> 
              <div class="row"> 
              <c:forEach items="${customers}" var="customers">
                 <div class="col-sm-6 col-md-3" style="padding-bottom: 15px"> 
                    <div class="thumbnail"> 
                       <div class="caption"> 
                          <h3>Cust Id: ${customers.customerId}</h3> 
                          <p><b>Name:</b> ${customers.name}</p> 
           <p><b>Location:</b> ${customers.address}</p> 
           <p>Total <b>${customers.noOfOrdersMade}</b> Made as of now.</p> 
                       </div> 
                    </div> 
                 </div> 
                 </c:forEach>
              </div> 
           </section> 
        </body> 
        </html> 