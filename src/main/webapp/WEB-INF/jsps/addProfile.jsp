<%@ taglib uri="http://www.springframework.org/tags/form" prefix="duy"%>
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
  
  <script>
  		
  		function clearText(){
  			document.getElementById("emessage").innerHTML="";
  		}	
        //creating function in JavaScript!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  		function validateForm(){
        	var pname=window.document.customerForm.name.value;
        	if(pname.length==0){
        		document.getElementById("emessage").innerHTML="Sorry! name cannot be empty!";
        		window.document.customerForm.name.focus();
        		return;
        	}
        	
        	var pemail=window.document.customerForm.email.value;
        	if(pemail.length==0){
        		document.getElementById("emessage").innerHTML="Sorry! email cannot be empty!";
        		window.document.customerForm.email.focus();
        		return;
        	}
        	
        	var pmobile=window.document.customerForm.mobile.value;
        	if(pmobile.length==0){
        		document.getElementById("emessage").innerHTML="Sorry! mobile cannot be empty!";
        		window.document.customerForm.mobile.focus();
        		return;
        	}
        	//Now we have to submit form using JavaScript!!!!!!!!!!
        	document.customerForm.submit();
  		}
  </script>
  
</head>
<body>

<div class="container">
  <h2>Learning Spring 5.x MVC!!!!!!!!!!!!!!!!!!!!!!!</h2>
  <img src="${pageContext.request.contextPath}/images/1.jpg" style="height: 130px;">
  <form name="customerForm" action="${pageContext.request.contextPath}/add-profile" method="post">
  <br/>
       <span class="alert alert-danger" id="emessage">
      </span>
      <hr/>
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name" onkeydown="clearText();">
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" onkeydown="clearText()";>
      	
    </div>
    
    <hr/>
     <div class="form-group">
      <label for="gender">Gender:</label>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <label><input type="radio"  name="gender" checked value="Male">Male</label>
        &nbsp; &nbsp;
         <label><input type="radio" name="gender" value="Female">Female</label>
    </div>
       <hr/>
    
     <div class="form-group">
      <label for="Mobile">Mobile:</label>
      <input type="text" class="form-control" id="mobile" placeholder="Enter Mobile" name="mobile" onkeydown="clearText()">
    </div>
    
     <div class="form-group">
      <label for="city">City:</label>
      <select class="form-control" id="city"  name="city" style="width: 50%;">
        <c:forEach items="${cities}" var="pitem">
      			<option>${pitem}</option>
      	</c:forEach>
      </select>
    </div>
    
     <div class="form-group">
      <label for="photo">Photo:</label>
      <input type="text" class="form-control" id="photo"  name="photo">
    </div>
    
    
    <button type="button" class="btn btn-primary btn-lg" onclick="validateForm();">Submit!</button>
    <a href="${pageContext.request.contextPath}/">
        <button type="button" class="btn btn-warning btn-lg">Show Customers!</button>
        
        </a>
  </form>
</div>

</body>
</html>
