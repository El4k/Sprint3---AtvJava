<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<style> h1 {text-align: center;}  </style>
<style> img {text-align: center;}  </style>
<script>
function funcao1() {
	alert("The number of the house can't be negative or equal 0.");
}
</script>
</head>
<body>
	<h1>ERROR</h1><hr>
	<div align="center">
	<img src="https://cdn.dribbble.com/users/3512533/screenshots/14168126/media/63e6f331db917433989b7f09f663e8e1.jpg">
	<input type="button" onclick="funcao1()" value="ERROR on Insert Number" />
	<h2></h2>
	</div>
</body>
</html>