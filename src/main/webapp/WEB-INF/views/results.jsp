<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ranks</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css
"/>
<link rel="stylesheet" href="/style.css"/>
</head>
<body>

	<div class="container">

		<a href="/">Choose Again</a>

		<h1 class="display-4">Welcome to Golf Rankings</h1>

		<a href="/new/${season1 - 1}">See&nbsp;${season1 - 1}</a>
		
		<a href="/new/${season2 + 1}">See&nbsp;${season2 + 1}</a>

		<!-- ROW outer div -->
		<div class="row">

			<div class="table-responsive col-md">

				<table class="table" id="table">
					<tr>
						<th>Name</th>
						<th>${season1}&nbsp;Ranking</th>
					</tr>


					<c:forEach var="playa" items="${player1}">
						<c:if test="${playa.rank le 100}">
							<tr>

								<td>${playa.name}</td>
								<td>${playa.rank}</td>

							</tr>
						</c:if>
					</c:forEach>
				</table>

			</div>

			<div class="table-responsive col-md">
				<table class="table" id="table">
					<tr>
						<th>Name</th>
						<th>${season2}&nbsp;Ranking</th>
					</tr>


					<c:forEach var="playa" items="${player2}">
						<c:if test="${playa.rank le 100}">
							<tr>

								<td>${playa.name}</td>
								<td>${playa.rank}</td>

							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>


		</div>



	</div>

</body>
</html>