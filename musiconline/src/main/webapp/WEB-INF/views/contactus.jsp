<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%-- <%@include file="header.jsp" %> --%>
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
<link rel="stylesheet" type="text/css" href="resources/css-file/external.css">
<title>Contact Us</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container" style="color: black;">
<h1>Contact Form</h1>
<div class="col-md-12">
	<div class="row">
		<form name="frm1" method="post">
		<div class="col-lg-12">
                                <div class="form-part">
                                    <ul>
                                       <br><br>
                                            <div class="form-group shaddow">
                                                <div class="input-group">
                                                <label>Name</label>
                                                     <input type="text" class="form-control no-radius" name="fname" required="required"/>
                                                </div>
                                            </div>
                                       <br>                                      
                                            <div class="form-group">
                                                <div class="input-group shaddow">
                                                <label>Email</label>
                                                    <input type="text" required="required" name="femail"  aria-describedby="inputGroupSuccess1Status" class="form-control no-radius"/>
                                                </div>
                                            </div>
                                        <br>
                                            <div class="form-group">
                                                <div class="input-group shaddow">
                                                <label>Mobile No.</label>
                                                   <input type="text" class="form-control no-radius" aria-describedby="inputGroupSuccess1Status"  name="fphone" required="required"/>
                                                </div>
                                            </div>
                                      <br>
                                       <label>Message</label>
                                            <textarea rows="4" class="form-control no-radius shaddow"></textarea>
                                         <br>
                                            <button role="button" class="btn btn-primary">Submit</button>
    										<button role="button" class="btn btn-primary">Cancel</button>
                                          </ul>
                                </div>
                                </div>
                            </form>
	</div></div>
</div>
<br>
<br>
<div>
 <%@include file="footer.jsp" %> 
</div>
</body>
</html>