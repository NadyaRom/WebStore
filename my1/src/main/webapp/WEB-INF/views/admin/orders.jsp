<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/category">Category</a>></li>
					<li><a href="/admin/type">Type</a></li>
					<li><a href="/admin/color">Сolor</a></li>
					<li><a href="/admin/design">Design</a></li>
					<li><a href="/admin/material">Material</a></li>
					<li><a href="/admin/phoneCompatibility">PhoneCompatibility</a></li>
					<li><a href="/admin/producer">Producer</a></li>
					<li><a href="/admin/product">Product</a></li>
					<li><a href=/admin/users>Users</a></li>
					<li class="active"><a href="/admin/orders">Orders</a><span
						class="sr-only">(current)</span></li>
				</ul>
			</div>
		</div>
	</nav>
	</div>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-4 col-xs-4"><h3>Order name</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Update</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Delete</h3></div>
		</div>	
			<c:forEach items="${orders}" var="order">
				<div class="row">
					<div class="col-md-4 col-xs-4">${order.name}</div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-warning" href="/admin/order/update/${order.id}">update</a></div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-danger" href="/admin/order/delete/${order.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>