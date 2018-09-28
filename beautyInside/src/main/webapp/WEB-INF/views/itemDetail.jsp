<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
</head>
<body class="bg-light">
	<!-- 상단바 -->
	<%@include file="navbar.jsp" %>
	
	<!-- 제품 페이지 -->
	<div class="container mt-4">
		
		<!-- 버튼  -->
		<div class="row">
			<div class="btn btn-primary ml-2">제품 구입</div>
			<div class="btn btn-primary ml-2">찜 하기</div>
			<a href="/beauty/review/write/${detail.ITEM_ID}" class="btn btn-primary ml-2">리뷰 작성</a>
			<div class="btn btn-primary ml-2">목록 보기</div>
		</div>
		
		<!-- 제품 정보 -->
		<div class="row mt-3">
			<!-- 제품 이미지(좌측) -->
			<div class="col">
				<img src ="${detail.ITEM_IMAGE}">
			</div>	
			
			<!-- 제품 상세정보 -->
			<div class="col">
				제품명 : ${detail.ITEM_NAME}<br>
				브랜드 : ${detail.ITEM_BRAND}<br>
				가격 : ${detail.ITEM_PRICE}원<br>
				카테고리 : ${detail.ITEM_CATEGORY}<br>
			</div>
		</div>
		
		<!-- 리뷰 리스트 -->
		<div class="row mt-3">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>리뷰 번호</th>
						<th>리뷰 제목</th>
						<th>작성자</th>
						<th>좋아요 수</th>
					</tr>
				</thead>
				
				<tbody>
					
				<c:forEach var="review" items="${reviewList}">
					<tr>
						<td>${review.REVIEW_ID}</td>
						<td>
							<a href="/beauty/review/${review.REVIEW_ID}">${review.REVIEW_TITLE}</a>
						</td>
						<td>${review.MEM_ID}</td>
						<td>${review.REVIEW_LIKE}</td>
					</tr>
				</c:forEach>
				
				</tbody>
			</table>
		</div>
	</div>

	<!-- 하단 -->
	<%@include file="footer.jsp" %>
</body>
</html>