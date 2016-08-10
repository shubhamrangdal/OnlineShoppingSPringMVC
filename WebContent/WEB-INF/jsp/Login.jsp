<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>
<style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
<body>
<h3>Login Page</h3>
	<form:form method="POST"  commandName="login">    
	
		Username : 	
					<form:input path="username" />
					<form:errors path="username" cssStyle="error"/><br><br>
		Password :  
					<form:input path="password" type="password"/>
					<form:errors path="password" cssClass="error"/><br><br>
					<div style="color: red">${error }</div>
		<input type="submit" value="Login"/>	
	</form:form>
</body>
</html>