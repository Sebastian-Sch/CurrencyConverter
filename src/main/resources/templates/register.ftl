<#import "lib/layout.ftl" as layout>
<#import "lib/form.ftl" as form>

<@layout.master>
	<div class="container">
		<div class="row">
			<p class="lead">Please provide information:</p>
		</div>
		<div class="row">
			<form action="/register" method="POST" class="form-horizontal">
				<div class="form-group">
					<@form.input path="userForm.username"/>
					<@form.input type="password" path="userForm.password"/>
				</div>
				<div class="form-group">
					<@form.input path="userForm.firstname"/>
					<@form.input path="userForm.lastname"/>
					<@form.input path="userForm.dateOfBirth" type="date" placeholder="dd/MM/YYYY"/>
				</div>
				<div class="form-group">
					<@form.input type="email" path="userForm.email"/>
				</div>
				<div class="form-group">
					<@form.input path="userForm.address.street"/>
					<@form.input path="userForm.address.zip"/>
					<@form.select path="userForm.address.country" options=countries />
				</div>
		  		<button type="submit" class="btn btn-success pull-right">Sign in</button>    
		  	</form>
		</div>
	</div>
</@layout.master>
