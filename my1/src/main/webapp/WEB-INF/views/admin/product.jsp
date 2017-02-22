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
					<li><a href="/admin/type"> Type</a></li>
					<li><a href="/admin/color">Сolor</a></li>
					<li><a href="/admin/design">Design</a></li>
					<li><a href="/admin/material">Material</a></li>
					<li><a href="/admin/phoneCompatibility">PhoneCompatibility</a></li>
					<li><a href="/admin/producer">Producer</a></li>
					<li class="active"><a href="/admin/product">Product</a><span
						class="sr-only">(current)</span></li>
					<li><a href=/admin/users>Users</a></li>
					<li><a href=/admin/orders>Orders</a></li>
				</ul>
			</div>
		</div>
	</nav>
	</div>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/product" method="POST" modelAttribute="product">
					<div class="form-group">
    					<label for="name" class="col-sm-1 control-label">Name</label>
    					<div class="col-sm-10">
      						<input type="text" class="form-control" name="name" id="name">
    					</div>
    				</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Price</label>
  						<div class="col-sm-10">
  							<input type="text" class="form-control"  name="price" id="price">
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Category</label>
  						<div class="col-sm-10">
  							<form:select class="form-control" path="category" id="category" items="${categories}" itemValue="id" itemLabel="name"/>
  						</div>	
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Producer</label>
  						<div class="col-sm-10">
  							 <form:select class="form-control" path="producer" id="producer" items="${producers}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Color</label>
  						<div class="col-sm-10">
  						 <form:select class="form-control" path="color" id="color" items="${colors}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Design</label>
  						<div class="col-sm-10">
  						<form:select class="form-control" path="design" id="design" items="${designs}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Material</label>
  						<div class="col-sm-10">
  						  <form:select class="form-control" path="material" id="material" items="${materials}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Type</label>
  						<div class="col-sm-10">
  							<form:select class="form-control" path="type" id="type" items="${types}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">PC</label>
  						<div class="col-sm-10">
  							<form:select class="form-control" path="phoneCompatibility" id="phoneCompatibility" items="${pss}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-1 col-sm-10">
      						<button type="submit" class="btn btn-primary">Create</button>
    					</div>
  					</div>
  					
  					
  					</form:form>
  </div>
		<div class="row">
			<div class="col-md-1 col-xs-1"><h6>Product name</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Price</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Category</h6></div>
			<div class="col-md-1 col-xs-1"><h6>PhoneCompatibility</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Type</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Color</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Design</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Material</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Producer</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Update</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Delete</h6></div>
			
			
			
		</div>
			<c:forEach items="${products}" var="product">
				<div class="row">
					<div class="col-md-1 col-xs-1">${product.name}</div>
					<div class="col-md-1 col-xs-1">${product.price}</div>
					<div class="col-md-1 col-xs-1">${product.category.name}</div>
					<div class="col-md-1 col-xs-1">${product.phoneCompatibility.name}</div>			
					<div class="col-md-1 col-xs-1">${product.type.name}</div>
					<div class="col-md-1 col-xs-1">${product.color.name}</div>
					<div class="col-md-1 col-xs-1">${product.design.name}</div>
					<div class="col-md-1 col-xs-1">${product.material.name}</div>
					<div class="col-md-1 col-xs-1">${product.producer.name}</div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-warning" href="/admin/product/update/${product.id}">update</a></div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-danger" href="/admin/product/delete/${product.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>