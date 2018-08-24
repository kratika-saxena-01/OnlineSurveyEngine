<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit the details of admin</title>
<link rel = "stylesheet" type="text/css" href="editadminstyle.css">
    </head>
    <body>
        <section>
            <div class="bgPulse">
                
                <div class = "topnav">
            <a class = "active" href="#home">Home</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
        </div>
        <h2>Admins</h2>
        <center>
        <div class = "edits">
        <a href="./new">Add  new admin</a>
        &nbsp;&nbsp;&nbsp;
    <a href="./list">view all admins</a>
	</div>
	</center>
	<div align ="center">
	 
            <form action="insert" method="post">
        
	<table border="1" cellpadding="15">
            
                <c:if test="${ab != null}">
                    <input type="hidden" name="id" value="<c:out value='${ab.aid}' />" />
                </c:if>   
                
                      
            <tr>
                <th>Admin Email</th>
                <td>
                    <input type="text" name="email" size="40"
                            
                        />
                </td>
            </tr>
            <tr>
                <th>Admin Password: </th>
                <td>
                    <input type="password" name="password" size="15"
                            
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
                </form>
            </tr>
        </table>
        </div>
        
        </section>

</body>
</html>