<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
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
					<li class="active"><a href="/admin/category<custom:allParams/>">Category</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/type">Type</a></li>
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
	<div class="col-md-3 col-xs-12">
		<form:form class="form-inline" action="/admin/category" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search"/>
			<div class="form-group">
				<form:input path="search" class="form-control" placeholder="Search"/>
			</div>
			<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
			<form:form class="form-horizontal" action="/admin/category" method="POST" modelAttribute="category">
								<custom:hiddenInputs excludeParams="name"/>
			<div class="form-group">
    					<label class="col-sm-10 col-sm-offset-2 control-label" for="name" style="color:red;text-align:left;"><form:errors path="name"/></label>
  					</div>
					<div class="form-group">
    					<label for="name" class="col-sm-1 control-label">Name</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="name" id="name"/>
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
			<div class="col-md-4 col-xs-4"><h3>Category name</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Update</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Delete</h3></div>
		</div>	
			<c:forEach items="${page.content}" var="category">
				<div class="row">
					<div class="col-md-4 col-xs-4">${category.name}</div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-warning" href="/admin/category/update/${category.id}<custom:allParams/>">update</a></div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-danger" href="/admin/category/delete/${category.id}<custom:allParams/>">delete</a></div>
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
								<custom:sort innerHtml="Name asc" paramValue="name" />
								<custom:sort innerHtml="Name desc" paramValue="name,desc" />
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