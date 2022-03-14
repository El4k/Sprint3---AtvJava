<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.compass.pb.sprint3.atv1.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
<style> h2 {text-align: center;}  </style>
</head>
<body>
	<h2>User Panel</h2><hr><br>
	<div align="justify">
	<label for="html"><b>Logged User: </b></label>${userLogged.login}
	<br><br><hr>
	<c:if test="${not empty user}"><label for="html"><b>Data: </b></label><br><br> ${userLogged}</c:if>
	<br><br>
	<a href="/sprint3/dashboard?action=UpdateController"><input type="button" value="Edit"></a>
	<a href="/sprint3/dashboard?action=RemoveService"><input type="button" value="Remove"></a>
	<hr>
	<a href="/sprint3/dashboard?action=ProductController"><input type="button" value="Insert Product"></a>
	<a href="/sprint3/dashboard?action=MailController"><input type="button" value="Print Fee and Deadline"></a>
	<br><br><br><br>
	<a href="/sprint3/dashboard?action=LogoutService"><input type="button" value="Exit"></a>
	</div>
</body>
</html>