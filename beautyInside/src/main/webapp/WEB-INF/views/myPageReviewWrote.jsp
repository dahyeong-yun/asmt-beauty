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
					<a href="/beauty/member/info/${loginMember.MEM_ID}" class="list-group-item">개인 정보 수정</a>
					<a href="/beauty/member/orders/${loginMember.MEM_ID}" class="list-group-item">주문목록 / 배송조회</a>
					<a href="/beauty/member/reviews/${loginMember.MEM_ID}" class="list-group-item active">내가 쓴 리뷰</a>
					<a href="/beauty/member/liked/${loginMember.MEM_ID}" class="list-group-item">좋아요 한 리뷰</a>
					<a href="/beauty/member/stored/${loginMember.MEM_ID}" class="list-group-item">제품 찜 목록</a>
					<a href="/beauty/member/follow/${loginMember.MEM_ID}" class="list-group-item">팔로워 팔로잉</a>
				</div>
			</div>

			<!-- 본문 -->
			<div class="col-md-9">
				<div class="container" >
					<table class="table table-striped table-bordered table-hover table-condensed">
						<tr>
							<th>리뷰번호</th>
							<th>리뷰제목</th>
							<th>좋아요 수</th>
						</tr>
						<c:forEach var="reviewLists" items="${reviewLists}">
						<tr>
							<td>${reviewLists.REVIEW_ID}</td>
							<td><a href="/beauty/review/${reviewLists.REVIEW_ID}">${reviewLists.REVIEW_TITLE}</a></td>
							<td>${reviewLists.REVIEW_LIKE}</td>
						</tr>
						</c:forEach>
					</table>
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