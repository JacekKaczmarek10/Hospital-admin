<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Visit List</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Visit List</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Visit"
				   onclick="window.location.href='visadd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Visit Id</th>
					<th>Doctor Id</th>
					<th>Patient Id</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempVisit" items="${visits}">
				
					<c:url var="updateLink" value="visupdate">
						<c:param name="visitId" value="${tempVisit.id}" />
					</c:url>		

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="deleteVisit">
						<c:param name="visitId" value="${tempVisit.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempVisit.id} </td>
						<td> ${tempVisit.docId} </td>
						<td> ${tempVisit.patId} </td>
						
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this visit?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
			
			<hr>
			
			<input type="button" value="Go to home page"
				   onclick="window.location.href='home'; return false;"
				   class="add-button"
			/>
				
		</div>
	
	</div>
	

</body>

</html>



