<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 align="center">CHOOSE YOUR BRAND:</h2>
<div class="row">
		<c:forEach items ="${categories}" var = "category">
		<div class="col-md-6 col-xs-6"><h3 class="text-center"><a href="/categories/${category.id}">${category.name}</a></h3></div>
		</c:forEach>
	
</div>

<a href="/admin">admin</a>