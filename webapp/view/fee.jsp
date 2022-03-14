<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Values</title>
<style> h2 {text-align: center;}  </style>
<style> label { display: block; float: left; } label, input { width:80px; margin: 0px 0; } input { width:200px; } width:200px; }</style>
</head>
<body>
<h2>Values of Fee and Prize</h2><hr><br>
<c:if test="${not empty userLogged}">
<fieldset>
<label for="html"><b>Fee: </b></label>${userLogged.valueFee}<br><br>
<label for="html"><b>Deadline: </b></label>${userLogged.deadline}
</fieldset>
	<br><br>
	<a href="/sprint3/dashboard?action=FeeController"><input type="button" value="See in Json Archive"></a>

</c:if>

</body>
</html>