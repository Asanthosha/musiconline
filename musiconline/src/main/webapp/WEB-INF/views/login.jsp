<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<style>
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

<link rel="stylesheet" type="text/css" href="resources/css-file/login.css">
<title>Login</title>

</head>
<body>
<%@include file="header.jsp" %>
<h2 style="text-align: center;"><b>Please Login</b></h2>
<div class="login-page">
<form action="perform_login" class="form-signin" method="post">
  <div class="imgcontainer">
    <img src="resources/images/userIcon.png" alt="Avatar" class="avatar">
  </div>

  <div class="container" style="color: black;">
    <!-- <label><b>Username</b></label> -->
    <input type="text" placeholder="Email" name="username" required/>

    <!-- <label><b>Password</b></label> -->
    <input type="password" placeholder="Password" name="password" required/>
        
    <button type="submit">Login</button>
    <input type="checkbox" checked="checked"> Remember me
    <p class="message">Not registered? <a href="register">Create an account</a></p>
  </div>
  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
</form>
</div>
<div>
<%@include file= "footer.jsp" %>
</div>	
</body>
</html>