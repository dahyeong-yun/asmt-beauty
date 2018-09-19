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
	<style>
		/* Make the image fully responsive */
		.carousel-inner img {
			width: 100%;
			height: 100%;
		}
		
		a {
			text-decoration: none;
		}
	</style>
</head>
<body class="bg-light">
	<!-- 상단바 -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
		<!-- 로고 -->
		<a class="navbar-brand" href="/beauty/">Logo</a>

		<!-- 메뉴 -->
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link" href="/beauty/search/">item</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/beauty/item/tipList?MEM_ID=${sessionScope.session_id}">tips!</a>
			</li>
		</ul>
		
		<!-- 검색창  -->
		<form class="form-inline">
		</form>
		
		<c:choose>
			<c:when test="${not empty loginMember.MEM_ID}">
				<c:choose>
					<c:when test="${loginMember.MEM_ID eq 'admin'}">
						<a href="admin">관리자님 환영합니다.</a>
					</c:when>
					<c:otherwise>
						<a href="/beauty/member/info/${loginMember.MEM_ID}">${loginMember.MEM_ID}</a>
						님 환영해요
					</c:otherwise>
				</c:choose>
					<button class="btn btn-outline-danger" onclick="location.href='/beauty/member/logout'">Logout</button>
			</c:when>
			
			<c:otherwise>
				<div style="float: right;">
					<button class="btn btn-outline-primary" data-toggle="modal" data-target="#loginModal">Login</button> 
					<button class="btn btn-outline-success" onclick="location.href='/beauty/member/signUp'">Sign Up</button>
				</div>
			</c:otherwise>
		</c:choose>
	</nav>
	
	<!-- 로그인 modal -->
	<div class="modal" id="loginModal">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<!-- header -->
				<div class="modal-header">
					<h4 class="modal-title">로그인</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				
				<!-- body -->
				<div class="modal-body">
					<form class="form" action="/beauty/member/login" method="post">
					<div class="form-group">
						<label for="id">아이디</label>
						<input type="text" class="form-control" id="MEM_ID" name="MEM_ID" aria-describedby="idHelp" placeholder="Enter id">
						<small id="idHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="MEM_PW">Password</label>
						<input type="password" class="form-control" id="MEM_PW" name="MEM_PW" placeholder="Password">
					</div>
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check me out</label>
					</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
				
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	
	
</body>
</html>