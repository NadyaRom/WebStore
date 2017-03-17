<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
body{
	background-image:url(resources/image/flw-177-gray.jpg);'
}
</style>
<sec:authorize access="isAuthenticated()">
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="/admin">admin</a>
	</sec:authorize>
	<form:form action="/logout" method="POST">
		<button type="submit" class="btn btn-danger">Logout</button>
	</form:form>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
<a href="/login">Login</a>
<a href="/registration">Registration</a>
</sec:authorize>
<h2 align="center">CHOOSE YOUR BRAND:</h2>
<div class="row">
		<c:forEach items ="${categories}" var = "category">
		<div class="col-md-6 col-xs-6"><h3 class="text-center"><a href="/categories/${category.id}">${category.name}</a></h3></div>
		</c:forEach>
	
</div>
