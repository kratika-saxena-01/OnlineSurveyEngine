<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Create Survey</title>
    <link rel = "stylesheet" type="text/css" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
</head>
<body>
    <section>
    <div class="bgPulse">
                
        <div class = "topnav">
        <a class = "active" href="#home">Home</a>
        <a href="#news">News</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
        </div>
		
		<center>
		<h2> CREATE SURVEY </h2>
		
		<form method="post" action="CreateSurveys">
		SURVEY NAME: <input type="text" name="survey_name" value="" style="padding: 12px 20px; width:50%"/></br></br>
		<input type="submit" value="Create survey">		
		</form>
		<br><br>
		<form method = "post" action = "AddQuestion">
			<input type = "submit" value = "ADD QUESTION">
		</form>
		</center>
		
		<!-- The Modal -->
		<div id="myModal" class="modal">
		
		  	<!-- Modal content -->
		    <div class="modal-content">
		    <div class="modal-header">
		    <span class="close">[x]</span>
		    <h2 style="color:white;">ADD QUESTION HERE</h2>
		    </div>
		  	<div class="form">
		     <form class="login-form">
		      <input style="height:40px; margin-left:23%; width:50%;" type="text" placeholder="Type question statement"/></br></br>
		      Select the type of question : <input type="radio" name="r1" value="Text" checked> Text
		      								<input type="radio" name="r1" value="Radio"> Single Choice
		      								<input type="radio" name="r1" value="Checkbox"> Multiple Choice</br></br>
		      <textarea style="height:80px; margin-left:23%; width:50%;" placeholder="In case of options, type each option on new line"/></textarea></br></br>
		      <a href="#" target="_blank" id="button2">Save Question</a>
		      </form>
		  	</div>
		  </div>  
		</div>
		<script>
				// Get the modal
				var modal = document.getElementById('myModal');
				
				// Get the button that opens the modal
				var btn= document.getElementById("btn");
				
				
				// Get the <span> element that closes the modal
				var span = document.getElementsByClassName("close")[0];
				
				// When the user clicks the button, open the modal
				btn.onclick = function() {
				    modal.style.display = "block";
				}
				
				// When the user clicks on <span> (x), close the modal
				span.onclick = function() {
				    modal.style.display = "none";
				}
				
				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
				    if (event.target == modal) {
				        modal.style.display = "none";
				    }
				}
				
				</script>
		
    </div>            
    </section>        
</body>
</html>