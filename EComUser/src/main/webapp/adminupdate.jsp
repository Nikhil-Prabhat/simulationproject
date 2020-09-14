<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin update</title>
</head>
<body>

<center>
		<h1>Welcome to Admin Update Page</h1>

		<form method="get" action="/admin/edit">
			Id : <input type="number" id="id" name="id" value="" />
			<br>
			<br> 
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
	</center>
</body>
</html>