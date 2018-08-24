<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Login</title>
        <link rel = "stylesheet" type="text/css" href="loginStyle.css">
    </head>
    <body>
        <section>
           
                
                <div class = "topnav">
            <a class = "active" href="#home">Home</a>
            <a href="#news">News</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
        </div>
                <div class = "loginBox">
                    <img src = "user.png" class="user">
                    <h2>Log In Here</h2>
                    <form action = "Login" method = "post">
                        <p>Email</p>
                        <input type="text" name="email" placeholder="Enter Email">
                        <p>Password</p>
                        <input type="password" name="pass" placeholder=".......">
                        <input type="submit" value="Sign In">
                        <a href = "#">Forget Password</a>
                    </form>
                </div>
                   
        </section>        
    </body>
</html>