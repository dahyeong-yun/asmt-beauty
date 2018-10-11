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
<script>
	/* 체크박스 전체선택, 전체해제 */
	function checkAll(){
	      if( $("#th_checkAll").is(':checked') ){
	        $("input[name=checkRow]").prop("checked", true);
	      }else{
	        $("input[name=checkRow]").prop("checked", false);
	      }
	}
</script>
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
					<a href="/beauty/member/reviews/${loginMember.MEM_ID}" class="list-group-item">내가 쓴 리뷰</a>
					<a href="/beauty/member/liked/${loginMember.MEM_ID}" class="list-group-item">좋아요 한 리뷰</a>
					<a href="/beauty/member/stored/${loginMember.MEM_ID}" class="list-group-item active">제품 찜 목록</a>
					<a href="/beauty/member/follow/${loginMember.MEM_ID}" class="list-group-item">팔로워 팔로잉</a>
				</div>
			</div>

			<!-- 본문 -->
			<div class="col-md-9">
				<div class="container" >
				
					<h3>찜한 상품</h3><div style="text-align: right;">찜한 상품 내역이 제공됩니다. </div>
					
						<table class="table table-striped table-bordered table-hover table-condensed">
							<tr>
								<td><input type="checkbox" name="checkAll" id="th_checkAll" onclick="checkAll();" value=""></td>
								<td><button type="button" class="btn btn-danger">선택상품 삭제</button></td>
								<td colspan="4">
									<select class="form-control" id="#">
										<option>최근 등록순</option>
										<option>낮은 가격순</option>
										<option>높은 가격순</option>
										<option>리뷰 많은순</option>
									</select>
								</td>
							</tr>
							<c:forEach var="memberStoredList" items="${memberStoredList}">
							<tr>
								<td><input type="checkbox" name="checkRow" value=""></td>
								<td><img src="${memberStoredList.ITEM_IMAGE}" style="width: 50px; height: 50px;"></td>
								<td>
									${memberStoredList.ITEM_NAME}<br>
									${memberStoredList.ITEM_PRICE}<br>
								</td>
								<td>
									<button type="button" class="btn btn-success" style="width: 150px;">장바구니에 담기</button><br>
									<button type="button" class="btn btn-primary" style="width: 150px; ">구매하기</button>
								</td>
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