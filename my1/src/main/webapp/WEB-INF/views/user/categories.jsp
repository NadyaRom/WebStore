<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>${category.name}</h1>
<div class="row">
	<c:forEach items="${products}" var="product">
	<div class="col-md-3 col-xs-3">
<ul>
	<li><a href = "/categories/${category.id}/products/${product.id}">${product.name}</a></li>
	<li>${product.price}</li>
	<li>${product.type.name}</li>
	<li>${product.color.name}</li>
	<li>${product.material.name}</li>	
</ul>
	</div>
	</c:forEach>
</div>
	