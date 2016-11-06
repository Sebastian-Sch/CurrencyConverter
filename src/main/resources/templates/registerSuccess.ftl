<#import "lib/layout.ftl" as layout>
<#import "lib/form.ftl" as form>

<@layout.master title="Currency Converter - convert from any currency to any currency">
	<div class="row alert alert-success">
		<p class="lead">Thank you for signing up.</p>
		<p>You have been signed up successfully.</p>
	</div>
	<div class="row jumbotron">
		<p class="lead">Sign in now:</p>
		<form action="/login" method="POST">
	        <div class="form-group">
	        	<@form.input path="loginForm.username"/>
	        </div>
	        <div class="form-group">
	        	<@form.input path="loginForm.password" type="password"/>
	        </div>
	  		<button type="submit" class="btn btn-success pull-right">Sign in</button>    
	    </form>	
	</div>
</@layout.master>