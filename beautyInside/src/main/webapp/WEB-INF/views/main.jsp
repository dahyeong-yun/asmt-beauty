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
<body>
	<!-- 상단바 -->
	<%@include file="navbar.jsp" %>

	<!-- 광고 제품 리스트(carousel) -->
	<div class="container bg-white mt-3">
		<div id="demo" class="carousel slide" data-ride="carousel">
			<!-- indicators -->
			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1" ></li>
				<li data-target="#demo" data-slide-to="2" ></li>
			</ul>
			<!-- 광고 목록 -->

			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="<c:url value="/resources/img/1.PNG" />" style="max-height: 350px;" alt="first" width="1100" height="250" />
					<div class="carousel-caption">
						<h3 style="color: black;">5만원 이상 구매시, 6천원 즉.시.할.인.</h3>
						<p style="color: black;">선선해지는 날씨, 마음도 기분도 프레쉬하게</p>
					</div>
				</div>
				
				<div class="carousel-item">
					<img src="<c:url value="/resources/img/2.PNG" />" style="max-height: 350px;" alt="first" width="1100" height="250" />
					<div class="carousel-caption">
						<h3>밀착페이스 미친매트립</h3>
						<p>파데유목민, 톤팡질팡 주목</p>
					</div>
				</div>
				
				<div class="carousel-item">
					<img src="<c:url value="/resources/img/3.PNG" />" style="max-height: 350px;" alt="first" width="1100" height="250" />
					<div class="carousel-caption">
						<h3>역대급 주름케어 최대 25% 할인</h3>
						<p>모두가 아는 갓띵템 유세린</p>
					</div>
				</div>
			</div>
			
			<!-- left - right -->
			<a class="carousel-control-prev" href="#demo" data-silde="prev">
				<span class="carousel-control-prev-icon"></span>
			</a>
			<a class="carousel-control-next" href="#demo" data-silde="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</div>
	</div>

	<!-- 추천 화장품 목록(carousel) -->
	<div class="container my-4">
		<h2 class="font-weight-bold">추천 제품 리스트</h2>
		<div class="row">
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="<c:url value="/resources/img/1.png" />" alt="item">
					<div class="card-body">
						<p class="card-title">제품 브랜드</p>
						<h4 class="card-text">제품 명</h4>
						<button type="button" class="btn btn-outline-info btn-sm mt-1 float-right">이 제품이 왜 추천 됐나요?</button>
					</div>
				</div>			
			</div>
			
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="<c:url value="/resources/img/1.png" />" alt="item">
					<div class="card-body">
						<p class="card-title">제품 브랜드</p>
						<h4 class="card-text">제품 명</h4>
						<button type="button" class="btn btn-outline-info btn-sm">이 제품이 왜 추천 됐나요?</button>
					</div>
				</div>			
			</div>
			
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="<c:url value="/resources/img/1.png" />" alt="item">
					<div class="card-body">
						<p class="card-title">제품 브랜드</p>
						<h4 class="card-text">제품 명</h4>
						<button type="button" class="btn btn-outline-info btn-sm">이 제품이 왜 추천 됐나요?</button>
					</div>
				</div>			
			</div>
			
			<div class="col">
				<div class="card">
					<img class="card-img-top" src="<c:url value="/resources/img/1.png" />" alt="item">
					<div class="card-body">
						<p class="card-title">제품 브랜드</p>
						<h4 class="card-text">제품 명</h4>
						<button type="button" class="btn btn-outline-info btn-sm">이 제품이 왜 추천 됐나요?</button>
					</div>
				</div>			
			</div>
		
		</div>
		

	</div>
	
	<!-- 검색창 -->
	<div class="container my-4">
		<h2 class="font-weight-bold">제품 검색하기</h2>
		<form class="form-inline text-center" action="/beauty/item" method="get">
			<select name="ITEM_CATEGORY" class="form-control">
				<option value="">카테고리</option>
				<option value="A">A</option>
				<option value="립스틱">립스틱</option>
				<option value="hair">헤어</option>
				<option value="skincare">스킨케어</option>
				<option value="cleansing">클렌징</option>
				<option value="perfume">향수</option>
				<option value="마스카라">마스카라</option>
			</select>
			<div class="form-group">
				<input type="text" class="form-control" id="search" placeholder="검색어를 입력하세요" name="ITEM_NAME">
			</div>
			<input class="btn btn-success"type="submit" value="검색">
		</form>
	</div>
	
	<!-- 하단 -->
	<%@include file="footer.jsp" %>
</body>
</html>