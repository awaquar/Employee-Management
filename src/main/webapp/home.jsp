<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
</head>
<body align=center>
	
	
	<form action="save" method=get>
		<table border=1 cellpadding=5 cellspacing=5>
		<tr>
			<td>Employee ID</td>
			<td><input type=text name=empId></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type=text name=name></td>
		</tr>
		<tr>
			<td>Day of Joining</td>
			<td><input type=date name=doj></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type=text name=salary></td>
		</tr>
		<tr>
			<td colspan=2><input type=submit value=Save></td>
		</tr>
		
		
		
		
		
		</table>
	
	</form>

<br><br>

<form action="saveorupdate" method=get>
		<table border=1 cellpadding=5 cellspacing=5>
		<tr>
			<td>Employee ID</td>
			<td><input type=text name=empId></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type=text name=name></td>
		</tr>
		<tr>
			<td>Day of Joining</td>
			<td><input type=date name=doj></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type=text name=salary></td>
		</tr>
		<tr>
			<td colspan=2><input type=submit value="Save Or Update"></td>
		</tr>

		</table>
	
	</form>

<br><br>

<form action="delete" method=get>
		<table border=1 cellpadding=5 cellspacing=5>
		<tr>
			<td>Employee ID</td>
			<td><input type=text name=empId></td>
		</tr>
		<tr>
			<td colspan=2><input type=submit value="Delete"></td>
		</tr>

		</table>
	
	</form>


<br><br>

<form action=showallemployees method=get>
	<input type=submit value="Show All Employees">
</form>

<br><br>
`	<form action="showemployee" method=get>
		<table border=1 cellpadding=5 cellspacing=5>
		<tr>
			<td>Employee ID</td>
			<td><input type=text name=empId></td>
		</tr>
		<tr>
			<td colspan=2><input type=submit value="Show Employee"></td>
		</tr>

		</table>
	
	</form>


</body>
</html>