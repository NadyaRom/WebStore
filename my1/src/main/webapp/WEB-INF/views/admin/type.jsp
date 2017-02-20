<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
					<li><a href="/admin/category">Category</a></li>
					<li class="active"><a href="/admin/type">Type</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/color">Сolor</a></li>
					<li><a href="/admin/design">Design</a></li>
					<li><a href="/admin/material">Material</a></li>
					<li><a href="/admin/phoneCompatibility">PhoneCompatibility</a></li>
					<li><a href="/admin/producer">Producer</a></li>
					<li><a href="/admin/product">Product</a></li>
					<li><a href=/admin/users>Users</a></li>
					<li><a href=/admin/orders>Orders</a></li>
				</ul>
			</div>
		</div>
	</nav>
	</div>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/type" method="POST" modelAttribute="type">
					<div class="form-group">
    					<label for="name" class="col-sm-1 control-label">Name</label>
    					<div class="col-sm-10">
      						<form:input  class="form-control" path="name" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-1 col-sm-10">
      						<button type="submit" class="btn btn-primary">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-4"><h3>Type name</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Update</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Delete</h3></div>
		</div>	
			<c:forEach items="${types}" var="type">
				<div class="row">
					<div class="col-md-4 col-xs-4">${type.name}</div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-warning" href="/admin/type/update/${type.id}">update</a></div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-danger" href="/admin/type/delete/${type.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>
