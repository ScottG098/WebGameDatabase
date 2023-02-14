<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Game Listing</title>
</head>
<body>
<form action= "editGameServlet" method="post">
Game: <input type ="text" name = "gameName" value= "${itemToEdit.gameName}">
Number Of Players: <input type = "number" name = "numOfPlayers" value= "${itemToEdit.numOfPlayers}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Game">
</form>
</body>
</html>