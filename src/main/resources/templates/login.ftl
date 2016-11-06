<#import "lib/layout.ftl" as layout>
<#import "lib/form.ftl" as form>


<@layout.master title="Login - Currency Converter">
	<div class="row">
		<p class="lead">Please sign in:</p>
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
	<div class="row alert alert-success">
		<p class="lead">No Account yet? Please sign up:</p>
		<a class="btn btn-success" href="/register">register here</a>
	</div>
</@layout.master>