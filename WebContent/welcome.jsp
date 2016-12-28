<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Cake Event</title>
	<link rel="stylesheet" href="css/welcome.css" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai|Fredericka+the+Great" rel="stylesheet">
	</head>

	<body>
	<jsp:useBean id="ed" scope="session" class="bean.EDbean" />
		<div id="container">
			<div class="welcome">
				<div class="welcome-user"> Hallo <jsp:getProperty name="ed" property="nutzer" /> ! </div>
				<ul>
                <li class="icon" id="cake"><a href="02_selectModel.jsp">Bearbeiten Sie eingnes CakeEvent</a></li>
                <li class="icon" id="donut"><a href=" ">Passwortänderung</a></li>
                </ul>	
			</div>
		</div>	
	</body>
	
</html>