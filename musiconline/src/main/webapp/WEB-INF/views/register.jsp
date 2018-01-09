<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f"  uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<style>
.err
{
color:red;
}
.bdr
{
border:1px solid black;
}
.err_bdr
{
border:1px solid red;
}
body
{
background-image: url("resources/images/wall2.jpg");
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, intial-scale=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="resources/css-file/external.css">

<title>Registration</title>
<!--==========Script for name validation ,name should be character=============  -->
<script type="text/javascript">

function f1() 
{  
   var x=document.getElementById('name').value;  
   if(!x.match(/^[A-Za-z\s]+$/))
	{
	   alert("Please Enter Only Characters");
	  
	   return false;
	  }
 return true;
}
</script>
</head>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<body>
<div class="container" style="color: black;">
    <h1>Register Here</h1>
	<div class="col-lg-12">
	<div class="row">				<!-- row=all elements comes in row -->
			<f:form modelAttribute="user" action="saveregister" method="post" onsubmit="return f1()">	<!--modelAttribute=after submit registration form,calls user model class  -->
																				<!--post=for hidden purpose  -->
					<div class="col-lg-12">
						<br>
							<!-- ======================================================= -->
							<div class="form-group">					<!--form-group=all elements comes in group -->					
							<f:errors path="name" cssClass="err"/><br>
								<label>Name</label>
								<br>
								<f:input path="name" id="name" placeholder="Enter Name Here.." class="form-control"/>
													
							</div>
							<!-- =============================================== -->
							<div class="form-group">
							<f:errors path="password" cssClass="err"/><br>
								<label>Password</label>
								<br>
								<f:input path="password" type="password" id="pass" placeholder="Enter Password Here.." class="form-control"/>
							</div>
							<!--===================================================  -->
							<div class="form-group">
							<f:errors path="password" cssClass="err"/><br>
								<label>Confirm Password</label>
								<br>
								<f:input path="confirm_password" type="password" id="confirmpass" placeholder="Confirm Password Here.." class="form-control"/>
							</div>
							<!-- ================================================ -->
							<div class="form-group">
							<f:errors path="address" cssClass="err"/><br>
								<label>Address</label>
								<br>
								<f:input path="address" placeholder="Enter Address Here.." class="form-control"/>
							</div>
							<!-- ================================================== -->
							<div class="form-group">
							<f:errors path="email" cssClass="err"/><br>
								<label>Email</label>
								<br>
								<f:input path="email" placeholder="Enter Email Here.." class="form-control"/>
							</div>
							<!-- ===================================================== -->
							<div class="form-group">
							<f:errors path="phone" cssClass="err"/><br>
								<label>Phone NO.</label>
								<br>
								<f:input path="phone" placeholder="Enter Mobile no. Here.." class="form-control"/>
							</div>		
							<!--============================================================  -->	
							<br>
							<button role="button" class="btn btn-primary" onclick="return Validate()">Submit</button>
   							<button role="button" class="btn btn-primary">Cancel</button>
   					</div>
			</f:form> 
		</div>
	</div>
	</div>
	<br>
	<br>
	<!-- =======================script for confirm password============================= -->
	<script type="text/javascript">
    	function Validate() 
    	{
        	var password = document.getElementById("pass").value;
        	var confirmPassword = document.getElementById("confirmpass").value;
        	if (password != confirmPassword) 
        	{
            	alert("Passwords do not match.");
            	return false;
       		}
        	return true;
    	}
	</script>
	<div>
 		<%@include file="footer.jsp" %> 
	</div>
</body>
</html>