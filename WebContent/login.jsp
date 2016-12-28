<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Cake Event</title>
	<link href="css/login.css" type="text/css" rel="stylesheet" media="all">	
    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai|Fredericka+the+Great" rel="stylesheet">
	</head>

	<body>
		<div id="container">
			<form action="Controller">
				<div class="login">Anmelden</div>
				<div class="username-text">Nutzer:</div>
				<div class="password-text">Passwort:</div>
				<div class="username-field">
					<input type="text" class="username" name="nutzer" value=" " />
				</div>
				<div class="password-field">
					<input type="password" name="password" value="" />
				</div>
				<!--<input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">Remember me</label>  -->
				<!-- <div class="forgot-usr-pwd">Forgot <a href="#">username</a> or <a href="#">password</a>?</div> -->
				<!-- <input type="submit" name="submit" value="GO" /> -->		
				<button type="submit" class="submit" value="submit">Anmelden</button>
                <button type="reset" class="reset" value="reset">Reset</button>
                
                <ul>
                  <li id="gast"><a href="Controller">Als Gast besucht</a></li>
                  <li id="zurueck"><a href="index.jsp">Zurück zur Homepage </a></li>                 
                </ul>
			</form>
		</div>
	</body>
</html>

