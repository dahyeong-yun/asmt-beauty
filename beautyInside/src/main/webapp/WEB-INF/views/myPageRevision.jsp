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
						<form class="form mt-4" action="/beauty/member/revision/${loginMember.MEM_ID }" method="post">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="MEM_ID">아이디</label>
									<input type="text" class="form-control" id="MEM_ID" name="MEM_ID" value="${loginMember.MEM_ID}" readonly="readonly">
								</div>
								<div class="form-group col-md-6">
									<label for="MEM_PW">비밀번호</label>
									<input type="password" class="form-control" id="MEM_PW" name="MEM_PW" placeholder="비밀번호를 입력하세요">
								</div>
							</div>
						
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="MEM_NAME">이름</label>
								<input type="text"
									class="form-control" id="MEM_NAME" name="MEM_NAME" value="${loginMember.MEM_NAME}" readonly="readonly">
								</div>
								<div class="form-group col-md-6">
									<label for="MEM_EMAIL">이메일</label>
									<input type="email" class="form-control" id="MEM_EMAIL" name="MEM_EMAIL" placeholder="변경할 이메일을 입력하세요">
								</div>
							</div>
						
							<div class="form-row mt-4">
								<div class="form-group col-md-6">
									<p>성별</p>
									<div class="btn-group" data-toggle="buttons">
									
										<!-- if문 -->
										<label class="btn btn-secondary">
											<input type="radio" name="GENDER_ID" value="1" /> 남자
										</label>
										<label class="btn btn-secondary active">
											<input type="radio" name="GENDER_ID" value="2" /> 여자
										</label>
										
										
									</div>
								</div>
								
								<div class="form-group col-md-6">
									<p>피부타입</p>
									<div class="btn-group" data-toggle="buttons">
									
										<!-- if 문 -->
										<label class="btn btn-secondary active">
											<input type="radio" name="SKINTYPE_ID" value="1" /> 지성
										</label>
										<label class="btn btn-secondary">
											<input type="radio" name="SKINTYPE_ID" value="2" /> 건성
										</label>
										<label class="btn btn-secondary">
											<input type="radio" name="SKINTYPE_ID" value="3" /> 복합성
										</label>
										
										
									</div>
								</div>
								
							</div>
							<button type="reset" class="btn btn-danger">다시쓰기</button>
							<button type="submit" class="btn btn-primary">변경하기</button>
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