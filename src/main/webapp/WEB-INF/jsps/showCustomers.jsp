<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Learning Spring 5.x MVC!</h2>
  <img src="${pageContext.request.contextPath}/images/1.jpg" style="height: 130px;">
  
  <form action="${pageContext.request.contextPath}/save-review-profile" method="post">
  
  <p>User Profile Review Page</p>            
  <table class="table table-bordered">
    <tbody>
      <tr style="background-color: fuchsia;">
        <td>Name</td>
        <td>Email</td>
         <td>Mobile</td>
          <td>Gender</td>
           <td>City</td>
            <td>Photo</td>
      </tr>
      <c:forEach items="${customers}" var="customer">
       <tr>
        <td>${customer.name}</td>
         <td>${customer.email}</td>
        <td>${customer.mobile}</td>
         <td>${customer.gender}</td>
       <td>${customer.city}</td>
            <td><img src="${customer.photo}" style="height: 100px;"/>
             <a href="${pageContext.request.contextPath}/deleteCustomer?email=${customer.email}">
             <img src="${pageContext.request.contextPath}/images/delete.png"></a>
             /
             <a href="${pageContext.request.contextPath}/editCustomer?email=${customer.email}">
             <img src="${pageContext.request.contextPath}/images/edit.png"></a>
             
             
            </td>
      </tr>
      </c:forEach>
      
      
      
        <tr>
        <td>
        <a href="${pageContext.request.contextPath}/add-profile">
        <button type="button" class="btn btn-danger btn-lg">Back!</button>
        </a>
        </td>
        <td align="right"></td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
            <td>&nbsp;</td>
              <td>&nbsp;</td>
      </tr>
      
    </tbody>
  </table>
  </form>
</div>


</body>
</html>
