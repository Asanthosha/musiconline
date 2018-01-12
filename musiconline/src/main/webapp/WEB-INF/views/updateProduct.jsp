<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body
{
background-image: url("../resources/images/wall2.jpg");
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../resources/css-file/style.css">
<title>updateProduct</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<h2>Update Product Here...!!</h2>
<c:url value="/admin/productUpdate" var="pru"></c:url>
<form action="productUpdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="pid" value="${prod.id }" >
<br>
<label>Product Name</label>
<input type="text" name="pName" value="${prod.name }" required/>
<br><br>
<label>Product Price</label>
<input type="text" name="pPrice" value="${prod.price }" required/>
<br><br>
<label>Product Stock</label>
<input type="text" name="pStock" value="${prod.stock }" required/>
<br><br>
<label>Product Description</label>
<input type="text" name="pDescription" value="${prod.description}" required/>
<br><br>
<!-- ======================for category================================= -->
<label>Product Category</label>					
<select name="pCategory">
<option value="0">---Select Category-----</option>
<c:forEach items="${catList }" var="cate">
<option value="${cate.cid }">${cate.name }</option>
</c:forEach>
</select><br><br>
<!--=================== for supplier=============================== -->
<label>Product Supplier</label>					
<select name="pSupplier">
<option value="">----Select Supplier----</option>
<c:forEach items="${satList }" var="sate">
<option value="${sate.sid }">${sate.supplierName }</option>
</c:forEach>
</select>
<br><br>
<!--=================== for image================================ -->
<div class="fileinput fileinput-new" data-provides="fileinput">
<label>Image</label>
<input class="form-control" type="file" name="file" accept="resources/*">
</div>
		<br><br>					
<div class="wrapper">
    <button role="button" class="btn">Update</button>
    <button role="button" class="btn">Cancel</button>
 </div>  
 	
</form>
</div>
</body>
</html>