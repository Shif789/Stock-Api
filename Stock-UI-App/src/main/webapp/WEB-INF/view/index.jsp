<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body style="text-align: center;">
	<h1 style="color:red ;">Stock UI Landing Page</h1>
	<h3>Get Stock Price</h3>

	<form action="./getTotalCost" method="get">
		<table align="center">
			<tr>
				<td>Company Name:</td>
				<td><input name="companyName" type="text" /></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><input name="quantity" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Get Cost" /></td>
			</tr>
		</table>
	</form>
</body>
</html>