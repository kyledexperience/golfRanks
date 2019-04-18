<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css
"/>
<link rel="stylesheet" href="style.css"/>
</head>
<body>

	<div class="container">

		<div class="form-group">
			<form action="/result">
				<label>YEAR</label> <select name="year" multiple
					class="form-control">
					<option>2018</option>
					<option selected>2017</option>
					<option>2016</option>
					<option>2015</option>
				</select>
				<button class="btn btn-dark" type="submit">GO</button>
			</form>

		</div>





	</div>

</body>
</html>