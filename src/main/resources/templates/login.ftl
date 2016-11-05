<#import "lib/layout.ftl" as layout>

<@layout.master title="Currency Converter - Login">
	Please register:
	<a href="/register">register here</a>
	Or convert:
	<a href="/convert">convert here</a>
	
	
    <form action="/login" method="POST">
        <div>
        	<label for="username">User Name</label>
        	<input type="text" name="username" value="user"/> 
        </div>
        <div>
        	<label for="password">Password</label>
        	<input type="password" name="password" value="password"/> 
        </div>
        <div>
        	<input type="submit" value="Sign In"/>
        </div>
    </form>	
</@layout.master>