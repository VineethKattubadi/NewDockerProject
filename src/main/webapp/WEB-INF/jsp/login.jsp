<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
	<form action="authenticate" method="post">
	<table width="50%" align="center" bgcolor="Lightblue">
	<tr>
		<td>Username</td>td>
		<td><input type=text name="uname"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type=password name="pword"></td>
		</tr>
		<tr>
			<td><input type=submit name="Login"></td>
			<td><input type=reset name="Cancel"></td>
		</tr>
	

	</table>
	</form>

</body>
</html>