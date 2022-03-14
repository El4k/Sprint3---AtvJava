<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url	value="/dashboard" var="link"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
<style> h2 {text-align: center;}  </style>
<style> label {
	display: block;
	float: left;
}

label, input {
	width:100px;
	margin: 3px 0;
}
input {
	width:150px;
}
	width:200px;
}</style>
</head>
<body>
	<h2>Register</h2><hr>
	<form action="${link}" method="post">
	<fieldset>
		<label for="Login">		<b>Login: 	</b></label><input type="text" name="login" id="Login"/><br>
		<label for="Password">	<b>Password:</b></label><input type="password" name="password" id="Password"/><br>
		<label for="Road">		<b>Road: 	</b></label><input type="text" name="road" id="Road"/><br>
		<label for="Number">	<b>Number: 	</b></label><input type="number" name="numberHouse" min="1" max="999999999" step="0" id="Number"/><br>
		<label for="City">		<b>City: 	</b></label><input type="text" name="city" id="City"/><br>
		<label for="State">		<b>State: 	</b></label><input type="text" name="state" placeholder="EX" pattern=[A-Za-z]{2} id="State"/><br>
		<label for="CEP">		<b>CEP: 	</b></label><input type="text" name="CEP" placeholder="12345678" pattern=[0-9]{8} id="CEP"/><br>
		<input type="hidden" name="action" value="RegistreService"/><br>
		<input type="submit" />
		</fieldset>
	</form>
	<a href="/sprint3/dashboard?action=LoginController"><input type="button" value="Back"></a>
</body>
</html>