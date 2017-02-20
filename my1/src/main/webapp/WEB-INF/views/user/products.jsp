<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="row">
 <h1>${product.name}</h1>
<ul>
 	<li>${product.name}</li>
 	<li>${product.price}</li>
 	<li>${product.category.name}</li>
 	<li>${product.phoneCompatibility.name}</li>
 	<li>${product.type.name}</li>
	<li>${product.color.name}</li>
	<li>${product.material.name}</li>
	<li>${product.design.name}</li> 
 	<li>${product.producer.name}</li>
 </ul>
</div>
 