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
				<p>${conversionResult.date?datetime}
					,${conversionResult.sourceAmount}
					,${conversionResult.sourceCurrencyIsocode}
					,${conversionResult.targetAmount}
					,${conversionResult.targetCurrencyIsocode}</p>
			</div>
		</#if>
		<div class="row">
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
		</#if>
	</div>
</@layout.master>