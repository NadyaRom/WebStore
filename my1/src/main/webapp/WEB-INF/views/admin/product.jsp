<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
		.filter .control-label{
		text-align: left;
	}
	.filter span{
		display: block;


</style>
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
	<div class="col-md-2 col-xs-12">
	<form:form class="form-horizontal filter" action="/admin/product" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search,  minPrice, maxPrice, categoryIds, typeIds, designIds, materialIds, psIds, producerIds"/>
				<div class="form-group">
					<div class="col-sm-12">
						<form:input type="text" class="form-control" path="search"
							placeholder="Search" />
					</div>
				</div>
					<div class="form-group">
					<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="minPrice" placeholder="Min price"/>
	    			</div>
	    			<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="maxPrice" placeholder="Max price"/>
	    			</div>
				</div>
					<div class="form-group">
						<label class="control-label col-sm-12">Categories</label>
						<div class="col-sm-12">
							<form:checkboxes items="${categories}" path="categoryIds"
								itemLabel="name" itemValue="id" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-12">Types</label>
						<div class="col-sm-12">
							<form:checkboxes items="${types}" path="typeIds" itemLabel="name"
								itemValue="id" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-12">Colors</label>
						<div class="col-sm-12">
							<form:checkboxes items="${colors}" path="colorIds"
								itemLabel="name" itemValue="id" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-12">Designs</label>
						<div class="col-sm-12">
							<form:checkboxes items="${designs}" path="designIds"
								itemLabel="name" itemValue="id" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-12">Materials</label>
						<div class="col-sm-12">
							<form:checkboxes items="${materials}" path="materialIds"
								itemLabel="name" itemValue="id" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-12">Phone Compatibility</label>
						<div class="col-sm-12">
							<form:checkboxes items="${pss}" path="psIds" itemLabel="name"
								itemValue="id" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-12">Producers</label>
						<div class="col-sm-12">
							<form:checkboxes items="${producers}" path="producerIds"
								itemLabel="name" itemValue="id" />
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Ok</button>
			</form:form>
	</div>
	<div class="col-md-8 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/product" method="POST" modelAttribute="product" enctype="multipart/form-data">
					<custom:hiddenInputs excludeParams="name, category, type, color, design, material, phoneCompatibility,product, producer"/>
				<form:hidden value="${category.id}" path="category"/>
				<div class="form-group">
    					<label class="col-sm-10 col-sm-offset-2 control-label" 
    						for="name" style="color:red;text-align:left;"><form:errors path="name"/></label>
  					</div>
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="name" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label class="col-sm-10 col-sm-offset-2 control-label" for="price" style="color:red;text-align:left;"><form:errors path="price"/></label>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-2 control-label">Price</label>
  						<div class="col-sm-10">
  							<form:input  class="form-control"  path="price" id="price"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-2 control-label">Category</label>
  						<div class="col-sm-10">
  							<form:select class="form-control" path="category" id="category" items="${categories}" itemValue="id" itemLabel="name"/>
  						</div>	
  					</div>
  					<div class="form-group">
  						<label class="col-sm-2 control-label">Producer</label>
  						<div class="col-sm-10">
  							 <form:select class="form-control" path="producer" id="producer" items="${producers}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-2 control-label">Color</label>
  						<div class="col-sm-10">
  						 <form:select class="form-control" path="color" id="color" items="${colors}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-2 control-label">Design</label>
  						<div class="col-sm-10">
  						<form:select class="form-control" path="design" id="design" items="${designs}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-2 control-label">Material</label>
  						<div class="col-sm-10">
  						  <form:select class="form-control" path="material" id="material" items="${materials}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-2 control-label">Type</label>
  						<div class="col-sm-10">
  							<form:select class="form-control" path="type" id="type" items="${types}" itemValue="id" itemLabel="name"/>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-2 control-label">PC</label>
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
  </div>
		<div class="row">
			<div class="col-md-1 col-xs-1"><h6>Product name</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Price</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Category</h6></div>
			<div class="col-md-1 col-xs-1"><h6>PC</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Type</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Color</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Design</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Material</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Producer</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Update</h6></div>
			<div class="col-md-1 col-xs-1"><h6>Delete</h6></div>	
		</div>
			<c:forEach items="${page.content}" var="product">
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
					<div class="col-md-1 col-xs-1"><a class="btn btn-warning" href="/admin/product/update/${product.id}<custom:allParams/>">update</a></div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-danger" href="/admin/product/delete/${product.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">		
		<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Product asc" paramValue="name" />
								<custom:sort innerHtml="Product desc" paramValue="name,desc" />
							
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
				</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>