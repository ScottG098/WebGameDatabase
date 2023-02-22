<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a new player</title>
</head>
<body>
<form action = "createNewPlayerServlet" method="post">
List Name: <input type ="text" name = "listName"><br />
Player Name: <input type ="text" name ="playerName"><br />

Available Items:<br />
<select name="allGamesToAdd" multiple size="6">
<c:forEach items="${requestScope.allGames}" var="currentGame">
	<option value = "${currentGame.id}">${currentGame.gameName}</option>
	</c:forEach>
	</select>
	<br />
<input type = "submit" value="Create List and add Games">
</form>
<a href = "index.html">Go add new games instead.</a>
</body>
</html>