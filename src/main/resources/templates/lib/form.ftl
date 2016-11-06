<#import "/spring.ftl" as spring/>

<#macro select path options>
	<label class="col-xs-2 control-label" for="${path}">${path?keep_after_last(".")?capitalize}</label>
	<@spring.bind "${path}"/>
	
	<div class="col-xs-10${spring.status.error?then(" has-error","")}">
   		<@spring.formSingleSelect path="${path}"  options=options attributes="class=\"form-control\""/><span class="help-block"><@spring.showErrors separator="'" classOrStyle="has-error"/></span>
   	</div>
</#macro>

<#macro input path placeholder="" type="text" min="" step="">
	<label class="col-xs-2 control-label" for="${path}">${path?keep_after_last(".")?capitalize}</label>
	<@spring.bind "${path}"/>
	
	<div class="col-xs-10${spring.status.error?then(" has-error","")}">
   		<@spring.formInput path="${path}" fieldType="${type}" attributes="class=\"form-control\" ${placeholder?has_content?then( ' placeholder=\"${placeholder}\"','')} ${min?has_content?then( ' min=\"${min}\"','')} ${step?has_content?then( ' step=\"${step}\"','')}"/><span class="help-block"><@spring.showErrors separator="'" classOrStyle="has-error"/></span>
   	</div>
</#macro>
