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
	
	<!-- 리뷰 페이지 -->
	<div class="container mt-4">
		
		<!-- 버튼  -->
		<div class="row">
			<div class="btn btn-primary ml-2">제품 구입</div>
			<div class="btn btn-primary ml-2">찜 하기</div>
			<div class="btn btn-primary ml-2">리뷰 추천</div>
			<div class="btn btn-primary ml-2">목록 가기</div>
		</div>
		
		<!-- 리뷰 정보 -->
		<div class="row mt-3">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>리뷰 제목</th>
						<th>리뷰 내용</th>
						<th>작성자</th>
						<th>좋아요 수</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>${reviewDetail.REVIEW_TITLE}</td>
						<td>${reviewDetail.REVIEW_CONTENT}</td>
						<td>${reviewDetail.MEM_ID}</td>
						<td>${reviewDetail.REVIEW_LIKE}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- 하단 -->
	<%@include file="footer.jsp" %>
</body>
</html>