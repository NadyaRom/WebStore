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
				<form class="form-horizontal" action="/admin/product" method="POST">
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
  							<select class="form-control" name="categoryId">
  								<c:forEach items="${categories}" var="category">
  									<option value="${category.id}"> ${category.name}</option>
  								</c:forEach>
  							</select>
  						</div>	
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Producer</label>
  						<div class="col-sm-10">
  							<select class="form-control" name="producerId">
  								<c:forEach items="${producers}" var="producer">
  									<option value ="${producer.id}">${producer.name}</option>
  								</c:forEach>
  							</select>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Color</label>
  						<div class="col-sm-10">
  							<select class="form-control" name="colorId">
  								<c:forEach items="${colors}" var="color">
  									<option value="${color.id}">${color.name}</option>
  								</c:forEach>
  							</select>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Design</label>
  						<div class="col-sm-10">
  							<select class="form-control" name="designId">
  								<c:forEach items="${designs}" var="design">
  									<option value="${design.id}">${design.name}</option>
  								</c:forEach>
  							</select>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Material</label>
  						<div class="col-sm-10">
  							<select class="form-control" name="materialId">
  								<c:forEach items="${materials}" var="material">
  									<option value="${material.id}">${material.name}</option>
  								</c:forEach>
  							</select>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">Type</label>
  						<div class="col-sm-10">
  							<select class="form-control" name="typeId">
  								<c:forEach items="${types}" var="type">
  									<option value="${type.id}">${type.name}</option>
  								</c:forEach>
  							</select>
  						</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-1 control-label">PC</label>
  						<div class="col-sm-10">
  							<select class="form-control" name="psId">
  								<c:forEach items="${pss}" var="ps">
  									<option value="${ps.id}">${ps.name}</option>
  								</c:forEach>
  							</select>
  						</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-1 col-sm-10">
      						<button type="submit" class="btn btn-primary">Create</button>
    					</div>
  					</div>
  					
  					
  					</form>
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
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>