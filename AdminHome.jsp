<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel = "stylesheet" type="text/css" href="loginStyle.css">
<title>Admin</title>
</head>
<body>
	<div class = "topnav">
            <a class = "active" href="#home">Home</a>
            <a class="active" href="#about">About</a>
            <a class="active" href="#contact us">Contact Us</a>
			<span style="float:right"><b>Welcome Admin</b></span><br>
			<a href="#logout" style="float:right">Log Out</a>        
           
	</div>
	<div id="head">
	<button class="button" formaction="#createSurvey"><span>Create Survey</span></button>
	<button class="button" formaction="#editadmin"><span>Edit Admin</span></button>
	</div>
	<center >
		<h1>Surveys</h1>
	</center>
	<section>
	<table>
		 <c:forEach var="survey" items="${listSurvey}">
                <tr>
                    <td><c:out value="${survey.sname}" /></td>
                    <td>
                        <a href="./edit?id=<c:out value='${survey.sid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="./delete?id=<c:out value='${survey.sid}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
	</table>
	</section>
</body>
</html>