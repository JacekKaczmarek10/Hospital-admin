<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Doctor</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-element-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Hospital Page</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Doctor</h3>
	
		<form:form action="saveDoctor" modelAttribute="doctor" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"  maxlength="12" required="required"/></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName"  maxlength="12" required="required"/></td>
					</tr>
					
				
					
					<tr>
					<td><Label>Specialty</Label></td>
       				<td>
       				<form:select path="specialty" required="required">  
        			<form:option value="psychologist" label="psychologist"/>  
        			<form:option value="psychiatrist" label="psychiatrist"/>  
        			<form:option value="orthopaedist" label="orthopaedist"/>  
        			<form:option value="dentist" label="dentist"/> 
        			</form:select>  
        			</td> 
       				</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" maxlength="25" required="required"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/hospital/doclist">Back to List</a>
		</p>
	
	</div>

</body>

</html>










