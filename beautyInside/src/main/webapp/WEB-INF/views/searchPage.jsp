<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

	<title>:: Beauty Inside ::</title>

<title>:: Beauty Inside ::</title>
<style>
</style>
</head>
<body class="bg-light">
	<!-- 상단바 -->
	<%@include file="navbar.jsp" %>
	
	<!-- 전체 페이지 -->
	<div class="container">
		<div class="row">
		
			<!-- 검색 옵션 -->
			<div class="col-sm-6 col-md-4">
				<form action="/action_page.php">
					<div class="form-check">
						<label class="form-check-label" for="radio1">
							<input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>Option 1
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label" for="radio2">
							<input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">Option 2
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label">
							<input type="radio" class="form-check-input" disabled>Option 3
						</label>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>		

			<!-- 검색 결과  -->
			<div class="col-sm-6 col-md-8">
			</div>
		</div>
	</div>
	
	<!-- 하단 -->
	<%@include file="footer.jsp" %>
	
	<script type="text/javascript">
	
	</script>
</body>
</html>