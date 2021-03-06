<#macro master title="Currency Converter">
	<html>
		<head>
			<title>${title}</title>
			<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
			<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>	   	
		</head>
		<body>
			<div class="container">
				<div class="row">
					<#if loggedInUser>
						<p class="pull-right">Welcome, ${currentUser.firstname}&nbsp;${currentUser.lastname}.&nbsp;<a href="/logout">sign out</a></p>
					</#if>	  
				</div>
				<#nested>
			</div>
		</body>	
	</html>
</#macro>