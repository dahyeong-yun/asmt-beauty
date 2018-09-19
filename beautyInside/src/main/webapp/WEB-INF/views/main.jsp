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
	</style>
</head>
<body class="bg-light">
	<!-- 상단바 -->
	<%@include file="navbar.jsp" %>

	<!-- 추천 화장품(carousel) -->
	<div class="jumbotron">
		<div class="container">
			<h2 class="font-weight-bold">추천 제품 리스트</h2>
			<div id="demo" class="carousel slide" data-ride="carousel">
				<!-- indicators -->
				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<li data-target="#demo" data-slide-to="1" ></li>
					<li data-target="#demo" data-slide-to="2" ></li>
				</ul>
				
				<!-- slide show -->
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="<c:url value="/resources/img/1.png" />" style="max-height: 250px;width:auto" alt="first" width="1100" height="250" />
						<div class="container">
							<h3>제품명</h3>
							 <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
						</div>
					</div>
					
					<div class="carousel-item">
						<img src="<c:url value="/resources/img/2.png" />" style="max-height: 250px;width:auto" alt="first" width="1100" height="250" />
						<div class="container">
							<h3>제품명</h3>
							 <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
						</div>
						
					</div>
					
					<div class="carousel-item">
						<img src="<c:url value="/resources/img/3.png" />" style="max-height: 250px;width:auto" alt="first" width="1100" height="250" />
						<div class="container">
							<h3>제품명</h3>
							 <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
						</div>
					</div>
				</div>
				
				<!-- left - right -->
				<a class="carousel-control-prev" href="#demo" data-silde="prev">
					<span class="carousel-control-prev-icon"></span>
				</a>
				<a class="carousel-control-next" href="#demo" data-silde="prev">
					<span class="carousel-control-next-icon"></span>
				</a>
			</div>
		</div>
	</div>
	
	<!-- 검색창 -->
	<div class="container mt-3">
		<h2 class="font-weight-bold">제품 검색하기</h2>
		<form class="form-inline mx-auto" action="searchItem" method="get">
			<select name="itemCategory" class="form-control">
				<option value="default">카테고리</option>
				<option value="hair">헤어</option>
				<option value="skincare">스킨케어</option>
				<option value="cleansing">클렌징</option>
				<option value="perfume">향수</option>
			</select>
			<div class="form-group">
				<input type="text" class="form-control" id="search" placeholder="검색어를 입력하세요" name="search">
			</div>
			<input class="btn btn-success"type="submit" value="검색">
		</form>
	</div>
	
	<!-- 하단 -->
	<%@include file="footer.jsp" %>
</body>
</html>