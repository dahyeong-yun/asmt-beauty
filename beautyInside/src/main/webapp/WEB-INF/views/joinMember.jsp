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
<body>
	<!-- 상단바 -->
	<%@include file="navbar.jsp" %>
	
	<!-- 회원가입 양식 -->
	<div class="jumbotron">
		<div class="container">
		
			<form class="form" action="">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="MEM_ID">아이디</label>
						<input type="text"
							class="form-control" id="MEM_ID" name="MEM_ID" placeholder="아이디를 입력하세요">
					</div>
					<div class="form-group col-md-6">
						<label for="MEM_PW">비밀번호</label>
						<input type="password" class="form-control" id="MEM_PW" name="MEM_PW" placeholder="Password">
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputAddress">삭제 예정</label>
					<input type="text"
						class="form-control" id="inputAddress" placeholder="1234 Main St">
				</div>
				
				<div class="form-group">
					<label for="inputAddress2">삭제 예정</label>
					<input type="text"
						class="form-control" id="inputAddress2"
						placeholder="Apartment, studio, or floor">
				</div>
				
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputCity">City</label>
						<input type="text"
							class="form-control" id="inputCity">
					</div>
					
					<div class="form-group col-md-4">
						<label for="inputState">State</label>
						<select id="inputState"
							class="form-control">
							<option selected>Choose...</option>
							<option>...</option>
						</select>
					</div>
					
					<div class="form-group col-md-2">
						<label for="inputZip">Zip</label>
						<input type="text" class="form-control" id="inputZip">
					</div>
				</div>
				
				<div class="form-group">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="gridCheck">
						<label class="form-check-label" for="gridCheck"> Check me out </label>
					</div>
				</div>
				
				<button type="submit" class="btn btn-primary">가입하기</button>
			</form>
			
		</div>
	</div>
	
	<!-- 하단 -->
	<%@include file="footer.jsp" %>
	
	<script type="text/javascript">
	
	</script>
</body>
</html>