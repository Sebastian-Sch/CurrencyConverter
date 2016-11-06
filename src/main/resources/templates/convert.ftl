<#import "lib/layout.ftl" as layout>
<#import "lib/form.ftl" as form>

<@layout.master>
	<div class="container">
		<div class="row">
			<p class="lead">Convert Currencies:</p>
		</div>
		<#if conversionResult??>
			<div class="row">
				<p class="lead">Result:</p>
				<p>${conversionResult.targetAmount}</p>
			</div>
		</#if>
		<div class="row">
			<form action="/convert" method="POST" class="form-horizontal">
				<div class="form-group">
					<@form.input path="conversionForm.date" placeholder="dd/MM/YYYY"/>
					<@form.input path="conversionForm.sourceCurrencyIsocode"/>
					<@form.input path="conversionForm.amount" type="number" min="0" step="0.01"/>
					<@form.input path="conversionForm.targetCurrencyIsocode"/>
				</div>
				<button type="submit" class="btn btn-success pull-right">Convert</button>    
			</form>
		</div>
		<#if lastConversionResults?size gt 0>
			${lastConversionResults?size}
		</#if>
	</div>
</@layout.master>