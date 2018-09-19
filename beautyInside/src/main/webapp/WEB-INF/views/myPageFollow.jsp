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
	
	<!-- 마이페이지 -->
	<div class="container">
		<div class="row">
			<!-- 마이페이지 좌측 메뉴 -->
			<div class="col-md-3">
				<div class="list-group">
					<a href="/beauty/member/info/${session.session_id}" class="list-group-item">개인 정보 수정</a>
					<a href="/beauty/member/orders/${session.session_id}" class="list-group-item">주문목록 / 배송조회</a>
					<a href="/beauty/member/reviews/${session.session_id}" class="list-group-item">내가 쓴 리뷰</a>
					<a href="/beauty/member/liked/${session.session_id}" class="list-group-item">좋아요 한 리뷰</a>
					<a href="/beauty/member/stored/${session.session_id}" class="list-group-item">제품 찜 목록</a>
					<a href="/beauty/member/follow/${session.session_id}" class="list-group-item active">팔로워 팔로잉</a>
				</div>
			</div>

			<!-- 마이페이지 우측 메뉴 -->
			<div class="col-md-9">
				<div class="container" >
					<div class="p-4 bg-white rounded shadow-sm">
						<div class="row">
							<!-- 팔로워 리스트(나를 팔로우 하고 있는 사람들) -->
							<div class="col">
							
							</div>
							
							<!-- 팔로잉 리스트(내가 팔로우 하고 있는 사람들) -->
							<div class="col">
							
							</div>
						</div>
					</div>
	
				</div>
			</div>
		
		</div>
	</div>
	
	<!-- 하단 -->
	<%@include file="footer.jsp" %>
	
	<script type="text/javascript">
	
	</script>
</body>
</html>