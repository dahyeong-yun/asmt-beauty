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
</style>
</head>
<body class="bg-light">
	<!-- 상단바 -->
	<%@include file="navbar.jsp" %>
	
	<!-- 마이페이지 -->
	<div class="container mt-3">
		<div class="row">
			<!-- 마이페이지 좌측 메뉴 -->
			<div class="col-md-3">
				<div class="list-group">
					<a href="/beauty/member/info/${loginMember.MEM_ID}" class="list-group-item">개인 정보 수정</a>
					<a href="/beauty/member/orders/${loginMember.MEM_ID}" class="list-group-item">주문목록 / 배송조회</a>
					<a href="/beauty/member/reviews/${loginMember.MEM_ID}" class="list-group-item">내가 쓴 리뷰</a>
					<a href="/beauty/member/liked/${loginMember.MEM_ID}" class="list-group-item">좋아요 한 리뷰</a>
					<a href="/beauty/member/stored/${loginMember.MEM_ID}" class="list-group-item">제품 찜 목록</a>
					<a href="/beauty/member/follow/${loginMember.MEM_ID}" class="list-group-item active">팔로워 팔로잉</a>
				</div>
			</div>

			<!-- 마이페이지 우측 메뉴 -->
			<div class="col-md-9">
				<div class="container" >
					<div class="p-4 bg-white rounded shadow-sm">
						<div class="row">
						
							<!-- 팔로워 리스트(나를 팔로우 하고 있는 사람들) -->
							<div class="col">
								<p>팔로워 목록</p>
								<c:forEach var="follower" items="${followerList}">
									<p>${follower.MEM_NAME}</p>
								</c:forEach>
							</div>
							
							<!-- 팔로잉 리스트(내가 팔로우 하고 있는 사람들) -->
							<div class="col">
								<p><b>팔로잉 목록</b></p>
								<table class="table">
									<tr>
										<th>아이디</th>
										<th>이름</th>
										<th>버튼</th>
									</tr>
									<c:forEach var="following" items="${followingList}">
										<tr>
											<td><a href="/beauty/member/follow/${following.MEM_ID}">${following.MEM_ID}</a></td>
											<td>${following.MEM_NAME}<td>
											<td>
												<button type="button"class="btn btn-warning" id="button${following.MEM_ID}" onclick="javascript:memberUnfollow('button${following.MEM_ID}');">unfollow</button>
											</td>
										</tr>
									</c:forEach>
								</table>
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
	$( document ).ready(function() {
		memberUnfollow = function (name) {
			$("#"+name).on("click", function () {
				var len = name.length;
				var memId = name.slice(6,len);
				$.ajax({
					type : "DELETE",
					url : "/beauty/member/follow/"+memId,
					data : {
						"id" : memId
					},
					datatype : "text",
					success : function () {
						$("#"+name).attr("disabled", true);
					},
					error : function(request) {
						console.log("AJAX에러");
						alert("code : " + request.stauts + "\n"
								+ "message :" + request.responseText);
					}
				});
			})
		}
	})
			
	
	</script>
</body>
</html>