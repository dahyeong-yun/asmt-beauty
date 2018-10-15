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
					<a href="/beauty/member/orders/${loginMember.MEM_ID}" class="list-group-item active">주문목록 / 배송조회</a>
					<a href="/beauty/member/reviews/${loginMember.MEM_ID}" class="list-group-item">내가 쓴 리뷰</a>
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
								<th>주문일(결제번호)</th>
								<th>상품/옵션정보</th>
								<th>결제금액</th>
								<th>상태</th>
							</tr>
							<c:forEach var="myPageItemOrder" items="${myPageItemOrder}">
							<tr>
								<td>
								${myPageItemOrder.PAY_DATE}<br>
								${myPageItemOrder.PAY_NUM}
								</td>
								<td>
								<img src="${myPageItemOrder.ITEM_IMAGE}" style="width: 50px; height: 50px;"><br>
								${myPageItemOrder.ITEM_NAME}
								</td>
								<td>${myPageItemOrder.ITEM_PRICE} 원</td>
								<td>
								<button type="button" class="btn btn-primary" style="width: 150px;">배송조회</button>
								
								
								<button class="btn btn btn-danger" data-toggle="modal" data-target="#orderCancel">주문취소모달</button><br><br>
							</tr>
							
							<!-- 주문취소 modal -->
							<div class="modal" id="orderCancel">
								<div class="modal-dialog">
									<div class="modal-content">
										
										<!-- header -->
										<div class="modal-header">
											<h4 class="modal-title">주문취소</h4>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
										
										<!-- body -->
										<div class="modal-body">
											<form class="form mt-4" action="/beauty/member/orders/${myPageItemOrder.PAY_ID}" method="POST">
												취소사유<br>
												<select name="ITEM_CATEGORY" class="form-control" id="reasonForCancel">
													<option value="expensivePrice">비싼가격</option>
													<option value="lateDelivery">지연배송</option>
													<option value="mistake">주문실수</option>
													<option value="etc">기타 사유</option>
												</select>
												<input type="hidden" name="_method" value="delete" />
												<button type="submit" class="btn btn-danger" style="float: right;">주문취소</button>
											</form>
										</div>
										
										<!-- footer -->
										<div class="modal-footer"></div>
									</div>
								</div>
							</div>
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