<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin add</title>
</head>
<body>
<center>
		<h1>Welcome to Admin Add Page</h1>
<table>
		<form method="get" action="/admin/add">
			
			Pic : <input type="text" id="pic" name="pic"
				value="" />
			<br>
			<br>
			Name : <input type="text" id="name" name="name"
				value="" />
			<br>
			<br>
			Price : <input type="number" id="price" name="price"
				value="" />
			<br>
			<br>
			 Active : <input type="checkbox" id="active" name="active" value="true">Yes
			 		 <input type="checkbox" id="active" name="active" value="false">No
			 <br>
			 <br>
			 Category :  <input type="text" name="category" id="category"
				value="" />
			<br>
			<br>
			
			Free Delivery : <input type="checkbox" name="freedelivery" id="freedelivery" value="true">Yes
			 		 <input type="checkbox" id="freedelivery" name="freedelivery" value="false">No
			<br>
			<br>
				  <input type="submit"
				name="" />
		</form>
		</table>
	</center>
</body>
</html>