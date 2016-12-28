<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Start: 00_inc.jsp -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cake Event</title>
<link href="css/00_inc.css" type="text/css" rel="stylesheet" media="all">
<link href="https://fonts.googleapis.com/css?family=Arima+Madurai|Fredericka+the+Great" rel="stylesheet">
</head>

<body>
<jsp:useBean id="ed" scope="session" class="bean.EDbean" />
<table width="100%" border="0">
<tr valign="middle">
<th align="left">
Datum : <jsp:getProperty name="ed" property="datum" /><br/> 
Nutzer : <jsp:getProperty name="ed" property="nutzer" />
<form action="Controller" method="post">
	<input type="hidden" name="action" value="00_Abmelden" />
	<button type="submit" class="abmelden" value="abmelden"> Abmelden </button>
</form>
</th>
<!--th><h2>Cake Event</h2></th>  -->
<!--th align="right">
<img src="logo.gif" align="top">
</th>  -->
</tr>
</table>
<h2>Cake Event</h2>  
</body>
<!-- End: 00_inc.jsp -->
