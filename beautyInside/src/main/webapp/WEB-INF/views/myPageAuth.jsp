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
					<a href="/beauty/member/info/${sessionScop.session_id}" class="list-group-item active">개인 정보 수정</a>
					<a href="/beauty/member/orders/${sessionScop.session_id}" class="list-group-item">주문목록 / 배송조회</a>
					<a href="/beauty/member/reviews/${sessionScop.session_id}" class="list-group-item">내가 쓴 리뷰</a>
					<a href="/beauty/member/liked/${sessionScop.session_id}" class="list-group-item">좋아요 한 리뷰</a>
					<a href="/beauty/member/stored/${sessionScop.session_id}" class="list-group-item">제품 찜 목록</a>
					<a href="/beauty/member/follow/${sessionScop.session_id}" class="list-group-item">팔로워 팔로잉</a>
				</div>
			</div>

			<!-- 마이페이지 우측 메뉴 -->
			<div class="col-md-9">
				<div class="p-4 bg-white rounded shadow-sm">
					<div class="container" >
						
						<form action="/beauty/member/info/auth/${session.session_id}" method="post" class="form-inline" style="text-align:center; margin: auto; max-width:350px; max-height:350px;">
						<p>비밀번호를 다시 한번 입력해 주세요</p>
							<div class="form-group">
								<input class="form-control" type="password" name="MEM_PW" placeholder="비밀번호를 입력하세요 " />
							</div>
							<input class="btn btn-primary" type="submit" value="확인" />
						</form>
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