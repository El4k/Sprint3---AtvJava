<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,br.com.compass.pb.sprint3.atv1.model.User"%>
<%@ page import="java.util.List,br.com.compass.pb.sprint3.atv1.action.service.LoginService"%>
<%@ page import="java.util.List,br.com.compass.pb.sprint3.atv1.action.controller.RegistreController"%>
<c:url value="/dashboard" var="link" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style> h2 {text-align: center;}  </style>
<style> label {display: block; float: left;}label, input {width:100px;margin: 3px 0;}input {width:150px;}width:200px;}</style>
</head>
<body>
	<h2>Login</h2><hr>
	<div align="center"><c:if test="${condition == true}"> <script>window.alert("User and/or Password are wrong!")</script> </c:if></div>
	<form action="${link}" method="post">
	<fieldset>
		<label for="Login">		<b>Login: 		</b></label><input type="text" name="login" id="Login"/><br>
		<label for="Password">	<b>Password: 	</b></label><input type="password" name="password" id="Password"/><br>
		<input type="hidden" name="action" value="LoginService" /> 
		<input type="Submit" />
		</fieldset>
	</form>
	<hr> Don't have an Account?
	<a href="dashboard?action=RegistreController"><input type="button" value="Register"></a>
</body>
</html>