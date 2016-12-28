<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Start: 03_rezepteTableau.jsp -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Cake Event</title>
	<link href="css/03_inc.css" type="text/css" rel="stylesheet" media="all">	
    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai|Fredericka+the+Great" rel="stylesheet">
</head>

<body>
<jsp:useBean id="ed" scope="session" class="bean.EDbean" />

<div align="center">
<h3>Modell: <jsp:getProperty name="ed" property="modelName" /></h3>




<form action="Controller" method="post">
<jsp:getProperty name="ed" property="rezepteTableau" /><br/>
<button type="submit" class="solve" value="solve">solve</button> 
</form>
</div>
</body>
<!-- End: 03_rezepteTableau.jsp -->