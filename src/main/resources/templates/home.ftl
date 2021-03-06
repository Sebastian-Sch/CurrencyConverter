<#import "lib/layout.ftl" as layout>

<@layout.master title="Currency Converter - convert from any currency to any currency">
	<div class="row jumbotron col-xs-12">
		<p class="lead">CurrencyConverter lets you convert amounts from any currency to any currency.</p>
		<a class="btn btn-success linkConvert" href="/convert">Start converting now</a>
	</div>
	<#if loggedInUser == false>	
		<div class="row jumbotron col-xs-12 alert">
			<p class="lead">Havent created an account yet? Sign up now.</p>
			<a class="btn btn-success linkRegister" href="/register">Sign up</a>
		</div>
		<div class="row jumbotron col-xs-12">
			<p class="lead">Already got your Account? Sign in now.</p>
			<a class="btn btn-success linkLogin" href="/login">Sign in</a>
		</div>
	</#if>
</@layout.master>