<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <style>
        body{
    margin: 0;
    padding: 0;
    background-color: rgb(201,233,246);
    font-family: 'Playfair Display', serif;
}
.loginBox{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    width: 350px;
    height: 650px;
    box-sizing: border-box;
    background: rgba(0,0,0,.5);
    padding: 80px 40px;
}
.user{
    width: 100px;
    height: 100px;
    overflow: hidden;
    position: absolute;
    top: calc(-100px/2);
    left: calc(50% - 50px);
}
.loginBox h2{
	font-size: 40px;
    margin: 0;
    padding: 0 0 20px;
    color: rgba(0,0,0,.5);
    text-align: center;
}
.loginBox p{
    margin: 0;
    padding: 0;
    font-weight: bold;
    color: #fff;
}
.loginBox input{
    width: 100%;
    margin-bottom: 20px;
}
.loginBox input[type="password"],.loginBox input[type="email"]{
    border: none;
    border-bottom: 1px solid #fff;
    background: transparent;
    outline: none;
    height: 40px;
    color: #fff;
    font-size: 16px;
}
::placeholder{
    color: rgba(255,255,255,.5);
}
.loginBox input[type="submit"]{
    border: none;
    outline: none;
    height: 40px;
    color: #fff;
    font-size: 16px;
    background: rgba(0,0,0,.5);
    cursor: pointer;
    border-radius: 20px;
    
}
.loginBox a{
    font-size: 14px;
    color: #fff;
    font-weight: bold;
    text-decoration: none;
    text-align: center;
    
}
section{
    position: absolute;
    width: 100%;
    height: 100%;
    overflow: hidden;
}
.bgPulse{
    width: 100%;
    height: 100%;
}
.topnav{
    background: rgba(0,0,0,.5);
    overflow: hidden;
}
.topnav a{
    float: right;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
}
.topnav a:hover{
    background: rgba(0,0,0,.8);
    color: grey;
}
.rightInfo{
	float: right;
	color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
}



.surveys a{
	float: right;
	padding: 10px;
	text-decoration: none;
	font-size: 20px;
	color: rgba(0,0,0,0.5);
	font-weight: bold;
}

.surveys table {
	padding-left: 20px;
	
}

#head {
	padding: 10px;
}
.pulse{
    width: 100%;
    height: 100%;
}
.pulse span{
    position: absolute;
    width: 60px;
    height: 60px;
    background: #fff;
}
.pulse span:nth-child(3n+1){
    border: 5px solid #fff;
    background: transparent;
}
.pulse span:nth-child(1){
    top: 10% ;
    left: 20%;
    animation: animate 10s linear infinite;
}
.pulse span:nth-child(2){
    top: 85% ;
    left: 10%;
    animation: animate 15s linear infinite;
}
.pulse span:nth-child(3){
    top: 20% ;
    left: 90%;
    animation: animate 8s linear infinite;
}
.pulse span:nth-child(4){
    top: 50% ;
    left: 60%;
    animation: animate 10s linear infinite;
}
.pulse span:nth-child(5){
    top: 40% ;
    left: 30%;
    animation: animate 6s linear infinite;
}
.pulse span:nth-child(6){
    top: 30% ;
    left: 75%;
    animation: animate 18s linear infinite;
}
.pulse span:nth-child(7){
    top: 90% ;
    left: 90%;
    animation: animate 14s linear infinite;
}
.pulse span:nth-child(8){
    top: 40% ;
    left: 10%;
    animation: animate 5s linear infinite;
}
.pulse span:nth-child(9){
    top: 80% ;
    left: 70%;
    animation: animate 8s linear infinite;
}
.pulse span:nth-child(10){
    top: 50% ;
    left: 50%;
    animation: animate 6s linear infinite;
}
@keyframes animate{
    0%{
        transform: scale(0) translateY(0) rotate(0deg);
        opacity: 1;
    }
    100%{
        transform: scale(1) translateY(-100px) rotate(360deg);
        opacity: 0;
    }
}


        </style>
        
    </head>
    <body>
    <section>
    <div class="pulse">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
    </section>
        <section>
            <div class="bgPulse">
                
                <div class = "topnav">
            <a class = "active" href="login.jsp">login</a>
            <h2>
            Online Survey Engine
            </h2>
            
             </div>
                <div class = "loginBox">
                    <h2>Register Here</h2>
                    <form action = "login.jsp" method = "post">
                        <p>First Name</p>
                        <input type="text" name="ufname" placeholder="Enter user first name" required>
  
                        <p>Last Name</p>
                        <input type="text" name="ulname" placeholder="Enter user last name" required>
                         <p>Email</p>
                        <input type="email" name="uemail" placeholder="Enter Email" required>
                        <p>Password</p>
                        <input type="password" name="upass" placeholder="......." required>
                        <p>DOB</p>
                        <input type="date" name="udob" placeholder="enter date of birth" required>
                        
                         <table>
                         <tr>
                        <td>  <p>Gender</p></td>
                         <td>  <p>Male</p> <input type="radio" name="ugender" value="male"> </td>
                          <td><p>Female</p> <input type="radio" name="ugender" value="female"></td></tr></table>
                         <p>City</p>
                        <input type="text" name="ucity" placeholder="Enter city" required>
                        <input type="submit" value="Sign Up">
                        
                    </form>
                </div>
            </div>            
        </section>        
    </body>
</html>