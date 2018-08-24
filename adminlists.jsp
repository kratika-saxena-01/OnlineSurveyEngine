<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
        <div class = "edits">
        <a href="./new">Add new admin</a>
        &nbsp;&nbsp;&nbsp;
    <a href="./list">view all admins</a>
	</div>
	</center>
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Admins</h2></caption>
            <tr>
                <th>Admin ID</th>
                <th>Admin email</th>
            </tr>
            <c:forEach var="ab" items="${adminlist}">
                <tr>
                    <td><c:out value="${ab.aid}" /></td>
                    <td><c:out value="${ab.aemail}" /></td>
                    <td>
                        <a href="./edit?id=<c:out value='${adminbean.aid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="./delete?id=<c:out value='${adminbean.aid}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
	

</body>
</html>