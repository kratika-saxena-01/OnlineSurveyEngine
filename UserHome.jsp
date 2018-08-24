<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title></title>
		<link rel = "stylesheet" type="text/css" href="UserHomeStyle.css">
		<link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet">
	</head>
	<body>
		<div class = "topnav">
            <a class = "active" href="#home">Home</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <div class = "rightInfo">Welcome User&nbsp;&nbsp; <input type="submit" name="logout" value = "logout"></div>
    	</div>
    	<div class = "surveys">
    		<h2>Surveys</h2>
    		<a href = "#" style = "float: right; padding: 10px; font-size: 25px; color: rgba(0,0,0,0.5);">Take New Survey</a><br><br><br><br>
    		<table>
    			<c:forEach var="survey" items="${listSurveys}">
                <tr>
                    <td><c:out value="${survey.sname}" /></td>
                    <!-- 
                    <td>
                        <a href="/showResponse?id=<c:out value='${survey.sid}' />">Show Response</a>                     
                    </td>
                     -->
                </tr>
            </c:forEach>
    		</table>
    	</div>
    	
    	
	</body>
</html>