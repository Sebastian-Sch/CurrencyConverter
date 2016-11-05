<#import "lib/layout.ftl" as layout>

<@layout.master>
	Convert your stuff.
	
	<script>
		$.ajax( { 
			url : "/conversionFactor/EUR",
		 	success : function( data ){
		 		alert( "currency [" + data.isocode + "], factor [" + data.factor + "]"); 
			}
		});		
	</script>
</@layout.master>