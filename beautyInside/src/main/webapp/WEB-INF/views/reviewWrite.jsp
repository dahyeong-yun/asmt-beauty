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
			<div class="btn btn-primary ml-2" onclick="reviewCheck()">리뷰 등록</div>
			<div class="btn btn-primary ml-2" onclick="history.go(-1);">목록 가기</div>
		</div>
		
		<!-- 리뷰 작성 -->
		<div class="row mt-3">
			<form class="form" action="/beauty/review/write/${itemRelatedThisReview.ITEM_ID}" method="post" id="review">
				<div class="form-group">
					<label for="REVIEW_TITLE">리뷰 제목</label>
					<input type="text" class="form-control" id="REVIEW_TITLE" name="REVIEW_TITLE" />
				</div>
				
				<div class="form-group">
					<label for="REVIEW_CONTENT">리뷰 내용</label>
					<textarea class="form-control" rows="5" id="REVIEW_CONTENT" name="REVIEW_CONTENT"></textarea>
				</div>
				<input type="hidden" class="form-control" id="LOGIN_MEM_ID" name="MEM_ID" value="${loginMember.MEM_ID}" />
				<input type="hidden" class="form-control" name="REVIEW_LIKE" value="0" />
				<input type="hidden" class="form-control" name="REVIEW_GRADE" value="0" />
			</form>
		</div>
	</div>
	
	<script>
		function reviewCheck() {
			if($("#LOGIN_MEM_ID").val() == "") {
				alert("로그인 한 사용자만 리뷰를 작성할 수 있습니다.");
			} else {
				$("#review").submit();
			}
		}
		
	</script>
	
	<!-- 하단 -->
	<%@include file="footer.jsp" %>
</body>
</html>