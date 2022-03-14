<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url	value="/dashboard" var="link"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<style> h2 {text-align: center;}  </style>
<style> label {display: block;float: left;}label, input {width:100px;margin: 3px 0;}input {width:100px;}width:200px;}</style>
</head>
<body>
	<h2>Insert Product</h2><hr>
	<form action="${link}" method="post">
		<fieldset>
		<label for="Name">			<b>Name: 		</b></label> <input type="text" name="name" id="Name"/><br>
		<label for="Description">	<b>Description: </b></label> <input type="text" name="description" id="Description"/><br>
		<label for="Price">			<b>Price: 		</b></label> <input type="text" name="price" placeholder="000.00" pattern="[0-9]{0,5}.[0-9]{2}" id="Price"/><br>
		<input type="hidden" name="action" value="ProductService"/>
		<input type="submit" />
		</fieldset>
	</form>
	<br><label for="html"><b>Total Value: </b></label>${userLogged.valueBuy}
	<br><hr>
	<a href="/sprint3/dashboard?action=UserService"><input type="button" value="Back"></a>
</body>
</html>