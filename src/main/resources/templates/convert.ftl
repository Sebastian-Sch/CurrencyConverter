<#import "lib/layout.ftl" as layout>
<#import "lib/form.ftl" as form>

<@layout.master title="Currency Converter - convert from any currency to any currency">
	<div class="row">
		<p class="lead">Convert Currencies:</p>
	</div>
	<#if conversionResult??>
		<div class="row alert alert-success">
			<p class="lead">Result:</p>
			<p>${conversionResult.date?datetime}
				,${conversionResult.sourceAmount}
				,${conversionResult.sourceCurrencyIsocode}
				,${conversionResult.targetAmount}
				,${conversionResult.targetCurrencyIsocode}</p>
		</div>
	</#if>
	<#if errorMessage??>
		<div class="row alert alert-danger">
			<p class="lead">An error occured:</p>
			<p>${errorMessage}</p>
		</div>
	</#if>
	
	<div class="row">
		<p class="lead">New conversion:</p>		
		<form action="/convert" method="POST" class="form-horizontal">
			<div class="form-group">
				<@form.input path="conversionForm.date" placeholder="dd/MM/YYYY"/>
				<@form.select path="conversionForm.sourceCurrencyIsocode" options=currencies />
				<@form.input path="conversionForm.amount" type="number" min="0" step="0.01"/>
				<@form.select path="conversionForm.targetCurrencyIsocode" options=currencies />
			</div>
			<button type="submit" class="btn btn-success pull-right">Convert</button>    
		</form>
	</div>
	<#if lastConversionResults?size gt 0>
		<div class="row">
			<p class="lead">Your latest results:</p>
			<ul class="list-group">
			<#list lastConversionResults as row>
				<li class="list-group-item">
					${row.date?datetime}
					,${row.sourceAmount}
					,${row.sourceCurrencyIsocode}
					,${row.targetAmount}
					,${row.targetCurrencyIsocode}
				</li>
			</#list>
			</ul>
		</div>
	</#if>
</@layout.master>