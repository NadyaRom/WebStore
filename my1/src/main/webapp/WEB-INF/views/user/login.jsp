<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-sm-12 col-xs-12">
		<form:form class="form-horizontal" action="/login" method="POST">
			<div class="form-group">
    			<label for="login" class="col-sm-4 control-label">Login</label>
    			<div class="col-sm-3">
      				<input class="form-control" name="login" id="login">
    			</div>
  			</div>
			<div class="form-group">
    			<label for="password" class="col-sm-4 control-label">Password</label>
    			<div class="col-sm-3">
      				<input class="form-control" name="password" id="password">
    			</div>
  			</div>
  			<div class="form-group">
  				<div class="checkbox">
        			<div class="col-sm-offset-4 col-sm-3">
          				<label><input type="checkbox"> Remember me</label>
          			</div>
       			 </div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-4 col-sm-3">
      				<button type="submit" class="btn btn-primary">Sign in</button>
    			</div>		
  			</div>
		</form:form>
	</div>
</div>