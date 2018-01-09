<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>

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



<title>productList</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<h2 style="text-align: center; color:#4B0082;"><b>Product List</b></h2>
<br>
<table class="table table-hover" id="category" class="display" border="1" width="80" align="center">
<tr>
<th>Sr.No.</th>
<th>PID</th>
<th>Name</th>
<th>Supplier</th>
<th>Category</th>
<th>Price</th>
<th style="width:15%">Description</th>
<th>Image</th>
<th class="span2">Action</th>
</tr> 

<c:if test="${empty prodlist }">
	<tr>
		<td colspan="9" align="center">No Records Exists</td>
</c:if>

<c:forEach var="c" varStatus="st" items="${prodlist }" >
	<tr>
		<td><c:out value="${st.count }"></td></c:out>

		<td><c:out value="${c.id }"></c:out></td>

		<td><c:out value="${c.name }"></c:out></td>

		<td><c:out value="${c.supplier.supplierName }"></c:out></td>

		<td><c:out value="${c.category.name }"></c:out></td>

		<td><c:out value="${c.price }"></c:out></td>

		<td class="span2"><c:out value="${c.description }"></c:out></td>

		<td><img src="${pageContext.request.contextPath}/resources/images/${c.imgname}" height="50px" width="50px"></td>
		<%-- <td><img src="<c:url value="/resources/${c.imgname}"/>"height="50px" width="50px"></td> --%>
		<td><c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
		<a class="btn btn-info" role="button" style="color: red;" href="<c:url value="/admin/deleteProduct/${c.id }"></c:url>"><i class="fa fa-trash-o" aria-hidden="true" ></i>
		Delete</a>
		<a class="btn btn-info" role="button" style="color: green;" href="${contextRoot }/admin/updateProduct?id=<c:out value="${c.id }"></c:out>"><i class="fa fa-refresh" aria-hidden="true"></i>
		Update</a>
		</td>
	</tr>
</c:forEach>
</table>
</div>
<div>
 <%@include file="footer.jsp" %> 
</div>
</body>
</html>