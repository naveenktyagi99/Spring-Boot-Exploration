<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>User Login </title>
    </head>
   <body>
        <div id="container">
            <s:form action="/authenticate" commandName="user">
                <h1>User Login</h1>
               
                <div class="line"><label for="tel">Username: </label><s:input type="text" path="username"  id="username" /></div>
                <div class="line"><label for="tel">Password: </label><s:input type="password" path="password"  id="username" /></div>
                <div class="line submit"><input type="submit" value="Submit" /></div>
 
            </s:form>
        </div>
    </body>
</html>