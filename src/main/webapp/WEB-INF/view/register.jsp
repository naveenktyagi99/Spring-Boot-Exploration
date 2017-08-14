<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <style type="text/css">
 
            body {font-family:Arial, Sans-Serif;}
 
            #container {width:300px; margin:0 auto;}
 
            /* Nicely lines up the labels. */
            form label {display:inline-block; width:140px;}
 
            /* You could add a class to all the input boxes instead, if you like. That would be safer, and more backwards-compatible */
            form input[type="text"],
            form input[type="password"],
            form input[type="email"] {width:160px;}
 
            form .line {clear:both;}
            form .line.submit {text-align:right;}
 
        </style>
        <title>User Registration</title>
    </head>
    <body>
        <div id="container">
            <s:form action="userRegistration" commandName="user" method="POST">
                <h1>User Registration</h1>
               
                <div class="line"><label for="firstName">First Name: </label><s:input type="text" path= "firstName" /></div>
                <div class="line"><label for="middleName">Middle Name: </label><s:input type="text" path="middleName" /></div>
                <div class="line"><label for="lastName">Last Name: </label><s:input type="text" path="lastName" /></div>
                <div class="line"><label for="email">Email: </label><s:input type="text" path="email" id="email" /></div>
                <div class="line"><label for="userName">User Name: </label><s:input type="text" path="username" id="username" /></div>
                <div class="line"><label for="password">Password: </label><s:input type="password" path="password" id="username" /></div>
                <div class="line"><label for="dob">Date of Birth *: </label><s:input  type="text"  path="dob" id="dob" /></div>
                <div class="line"><label for="tel">Mobile: </label><s:input type="text" path="contact"  id="contact" /></div>
                <div class="line submit"><input type="submit" value="Submit" /></div>
 
                <p>Note: Please make sure your details are correct before submitting form and that all fields marked with * are completed!.</p>
            </s:form>
        </div>
    </body>
</html>