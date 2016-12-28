<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Start: 02_inc.jsp -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cake Event</title>
<link href="css/02_inc.css" type="text/css" rel="stylesheet" media="all">
<link href="https://fonts.googleapis.com/css?family=Arima+Madurai|Fredericka+the+Great" rel="stylesheet">
</head>

<body>
<div align="center">
<jsp:useBean id="ed" scope="session" class="bean.EDbean" />
<h3>Modell - Übersicht :</h3>
<jsp:getProperty name="ed" property="modelsOverview" />
<br/>
<form action="Controller" method="post">
<h3>Hinzufügen eines neues Modell :</h3>
<jsp:getProperty name="ed" property="modelAddView" />
<input type="hidden" name="action" value="14_addModel">
<button type="submit" class="add" value="add"> Add </button>
</form>
</div>
</body>
<!-- End: 02_inc.jsp -->
