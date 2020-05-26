<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>

<head>
	<title>Save Visit</title>

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
		<h3>Save Visit</h3>
	
		<form:form action="saveVisit" modelAttribute="visit" method="POST">

				<form:hidden path="id" />
			
			<table>
				<tbody>
				<tr>
					<label>Available patient Id:</label>
							<form:select path="patId" required="required"> 
							<option/> 
    							<c:forEach items="${patients}" var="tempPatient">
       								<form:option value="${tempPatient.id}">
       								${tempPatient.id}</form:option>
   					 			</c:forEach>
   					 			</form:select>
					</tr>

					<tr>
						<label>Available doctor Id:</label>
						<form:select path="docId" required="required">
			    			<option/>
    							<c:forEach items="${doctors}" var="tempDoctor">
        						<form:option value="${tempDoctor.id}">
        						${tempDoctor.id}</form:option>
   				 				</c:forEach>
   				 			</form:select>
					</tr>
					
					<tr>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
					
					
					
				</tbody>				
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/hospital/vislist">Back to List</a>
		</p>
	
	</div>

</body>

</html>


