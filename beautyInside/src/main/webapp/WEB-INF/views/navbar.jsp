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
<body>
	<!-- 상단바 -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- 로고 -->
		<a class="navbar-brand" href="/beauty/">Logo</a>

		<!-- 메뉴 -->
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link" href="/beauty/item?ITEM_CATEGORY=&ITEM_NAME=">item</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/beauty/tip?MEM_ID=${loginMember.MEM_ID}">tips</a>
			</li>
		</ul>
				
		<!-- 검색창  -->

		<form class="form-inline mx-auto" action="/beauty/item" method="get" onsubmit="return send()">
			<select name="ITEM_CATEGORY" class="form-control" id="category">

				<option value="">카테고리</option>
				<option value="A">A</option>
				<option value="hair">헤어</option>
				<option value="skincare">스킨케어</option>
				<option value="cleansing">클렌징</option>
				<option value="perfume">향수</option>
				<option value="마스카라">마스카라</option>
			</select>
			<div class="form-group">
				<input type="text" class="form-control" id="search" placeholder="검색어를 입력하세요" name="ITEM_NAME" >
			</div>
			<input class="btn btn-success"type="submit" value="검색">
		</form>
		
		
		
		<c:choose>
			<c:when test="${not empty loginMember.MEM_ID}">
				
				<c:choose>
					<c:when test="${loginMember.MEM_ID eq 'admin'}">
						<a href="/beauty/adminPage/dashboard">관리자님 환영합니다.</a>
					</c:when>
					<c:otherwise>
						<!-- 장바구니 페이지로 넘어가기 -->
						<a href="/beauty/item/basketPage">장바구니</a>&nbsp;&nbsp;
						<a style="color:white;" href="/beauty/member/info/${loginMember.MEM_ID}">${loginMember.MEM_ID}
						<img src="/beauty/resources/img/defalutProfile.png" alt="..." width="35px" height="auto" class="rounded-circle">
						님 환영해요</a>
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
						<input type="text" class="form-control" id="MEM_ID" name="MEM_ID" aria-describedby="idHelp" placeholder="Enter id" required="required">
						<small id="idHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="MEM_PW">Password</label>
						<input type="password" class="form-control" id="MEM_PW" name="MEM_PW" placeholder="Password" required="required">
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


		<script> 
	function send() { 
		var cate = document.getElementById("category");
		var n = document.getElementById("search");
		if(n.value.length<=0){
			n.setAttribute("disabled","disabled");
		}
		if(cate.value=="") {
			cate.setAttribute("disabled","disabled");
		}
		return true;
	} 
</script> 
</body>
</html>