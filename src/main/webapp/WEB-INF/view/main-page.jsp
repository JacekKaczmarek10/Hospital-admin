<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<style>
div.absolute {
  position: absolute;
  top: 800px;
  right: 1000px;
  width: 400px;
  height: 100px;
}

</style>
</head>






<body style="background-color:powderblue;">

<h1>Hospital Page</h1>
<p>Welcome</p>


<input type="button" value="Patient Page"
				   onclick="window.location.href='patlist'; return false;"
				   class="add-button"
			/>
			
<input type="button" value="Doctor Page"
				   onclick="window.location.href='doclist'; return false;"
				   class="add-button"
			/>

<input type="button" value="Visits Page"
				   onclick="window.location.href='vislist'; return false;"
				   class="add-button"
			/>
<hr>


<img src="https://images.pexels.com/photos/127873/pexels-photo-127873.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
height=50% width=50%>

<hr>

<div style='float:left; width:30%'>
<h2>Contact information</h2>
<p>email: hospitalofpoznan@gmail.com</p>
<p>phone number: +48 601 456 987</p>
</div>

<div style='float:left; width:40%; margin-left:30px'>
<h2>Address information</h2>
<p>Poland, Posen</p>
<p>ul.Marcinkowskiego 59</p>
<p>60-461</p>
</div>








</body>
</html>