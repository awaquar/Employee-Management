<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>


<script type="text/javascript">
function exportToExcel(tableID, filename = ''){
    var downloadurl;
    var dataFileType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTMLData = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'export_excel_data.xls';
    
    // Create download link element
    downloadurl = document.createElement("a");
    
    document.body.appendChild(downloadurl);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['\ufeff', tableHTMLData], {
            type: dataFileType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
    }else{
        // Create a link to the file
        downloadurl.href = 'data:' + dataFileType + ', ' + tableHTMLData;
    
        // Setting the file name
        downloadurl.download = filename;
        
        //triggering the function
        downloadurl.click();
    }
}

</script>


</head>
<body>
	

	<table border=1 cellspacing=3 cellpading=5 id="employeetable">
	<tr>
		<th>Employee ID</th>
		<th>Name</th>
		<th>Date of Joining</th>
		<th>Salary</th>
	</tr>
	
	<c:forEach items="${employees}" var="employee">
		<tr>
		<td>${employee.empId}</td>
		<td>${employee.name}</td>
		<td>${employee.doj}</td>
		<td>${employee.salary}</td>
		</tr>	
	</c:forEach>
	
	</table>
	
	<button onclick="exportToExcel('employeetable','Employee-Table')">Export to Excel</button>

</body>
</html>