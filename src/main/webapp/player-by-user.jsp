<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Players</title>
</head>
<body>
<form method = "post" action = "playerNavigationServlet">
<table>
<c:forEach items = "${requestScope.allPlayers}" var="currentPlayer">
<tr>
	<td><input type="radio" name="id" value="${currentPlayer.id}"></td>
	<td><h2>${currentPlayer.playerName}</h2></td></tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">
<input type="submit" value = "add" name = "doThisToList">
</form>
<a href="addPlayersForGameServlet">Add a player</a>
<a href="index.html">Add a new game</a>
</body>
</html>