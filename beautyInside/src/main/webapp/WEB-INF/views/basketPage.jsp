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
		/* Make the image fully responsive */
		.carousel-inner img {
			width: 100%;
			height: 100%;
		}
	</style>
</head>
<body>
	<!-- 상단바 -->
	<%@include file="navbar.jsp" %>
	<div class="container" >
	<br><h3>장바구니</h3>
	<div style="text-align:right;">
	01장바구니 > 02 주문/결제 > 03주문완료
	</div>
		<table class="table table-striped table-bordered table-hover table-condensed">
			<tr>
				<td>
					<ul>
						<li>가격, 옵션등 상품정보가 변경된 경우 주문이 불가할 수 있습니다.</li>
						<li>자세한 사항은 고객센터를 이용해 문의해주세요.</li>
					</ul>
				</td>
			<tr>
		</table>
		<table class="table table-striped table-bordered table-hover table-condensed">
			<tr>
				<td>장바구니 번호+체크박스(체크시 전체 장바구니 상품 체크됨)<label><input type="checkbox" value="">전체주문</label></td>
				<td>제품명</td>
				<td>수량</td>
				<td>상품 금액</td>
				<td>배송비</td>
				<td>주문금액</td>
			</tr>
			<tr>
				<td>123123+체크박스(체크시 개별 상품 체크)<label><input type="checkbox" value="">개별주문</label></td>
				<td>스킨푸드 제품이름</td>
				<td>1개</td>
				<td>12000</td>
				<td>2500</td>
				<td>17500(상품금액 + 배송비)</td>
			</tr>
			<tr>
				<td colspan="6">최종금액(체크한 상품에 대한 전체 금액) 17500 + 주문  / 삭제 버튼<button class="btn btn-primary">주문</button><button class="btn btn-danger">삭제</button></td>
			</tr>
		</table>
		<!-- 하단 -->
		<%@include file="footer.jsp" %>
	</div>
	
</body>
</html>