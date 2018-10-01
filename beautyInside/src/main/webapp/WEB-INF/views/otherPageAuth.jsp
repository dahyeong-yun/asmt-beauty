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
<!-- 이미 팔로우 하고 있을 경우, 글 리스트로 바로 이동 -->

	<!-- 상단바 -->
	<%@include file="navbar.jsp" %>
	
	<!-- 마이페이지 -->
	<div class="container mt-3">
		<div class="row">
			<!-- 마이페이지 좌측 메뉴 -->
			<div class="col-md-3">
				<div class="list-group">
					<a href="/beauty/member/reviews/${otherMemberID}" class="list-group-item">${otherMemberID}가 쓴 리뷰</a>
					<a href="/beauty/member/follow/${otherMemberID}" class="list-group-item active">팔로워 팔로잉</a>
				</div>
			</div>

			<!-- 마이페이지 우측 메뉴 -->
			<div class="col-md-9">
				<div class="p-4 bg-white rounded shadow-sm">
					<div class="container" >
						<p>팔로우 한 회원의 정보만 볼 수 있습니다</p>
							<button class="btn btn-primary" onclick="location.href = '/beauty/member/doFollow/${otherMemberID}'">팔로우 하기</button>
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