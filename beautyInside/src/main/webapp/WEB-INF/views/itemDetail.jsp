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
	
	<!-- 제품 페이지 -->
	<div class="container mt-4">
		
		<!-- 버튼  -->
		<div class="row">
			<div class="card">
			<div class="btn btn-primary ml-2" onclick="itemPayment({'ITEM_ID':'${detail.ITEM_ID}','ITEM_NAME':'${detail.ITEM_NAME}','ITEM_IMAGE':'${detail.ITEM_IMAGE}','ITEM_PRICE':'${detail.ITEM_PRICE}','MEM_ID':'${loginMember.MEM_ID}'})">제품 구입</div>
			<button class="btn btn-primary ml-2" onclick="itemStore(${detail.ITEM_ID})">찜 하기</button>
			
			<input type="hidden" id="LOGIN_MEM_ID" value="${loginMember.MEM_ID}"/>
			
			<span class="btn btn-primary ml-2" onclick='reviewCheck(${detail.ITEM_ID})'>리뷰 작성</span>
			<div class="btn btn-primary ml-2" onclick="history.back()">목록 보기</div>
			</div>
		</div>
		
		<!-- 제품 정보 -->
		<div class="row mt-3">
			<!-- 제품 이미지(좌측) -->
			<div class="col">
				<img src ="${detail.ITEM_IMAGE}">
			</div>	
			
			<!-- 제품 상세정보 -->
			<div class="col">
				제품명 : ${detail.ITEM_NAME}<br>
				브랜드 : ${detail.ITEM_BRAND}<br>
				가격 : ${detail.ITEM_PRICE}원<br>
				카테고리 : ${detail.ITEM_CATEGORY}<br>
			</div>
		</div>
		
		<!-- 리뷰 리스트 -->
		<div class="row mt-3">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>리뷰 번호</th>
						<th>리뷰 제목</th>
						<th>작성자</th>
						<th>좋아요 수</th>
					</tr>
				</thead>
				
				<tbody>
					
				<c:forEach var="review" items="${reviewList}">
					<tr>
						<td>${review.REVIEW_ID}</td>
						<td>
							<a href="/beauty/review/${review.REVIEW_ID}">${review.REVIEW_TITLE}</a>
						</td>
						<td><a href="/beauty/member/follow/${review.MEM_ID}">${review.MEM_ID}</a></td>
						<td>${review.REVIEW_LIKE}</td>
					</tr>
				</c:forEach>
				
				</tbody>
			</table>
		</div>
	</div>
	
	<script type="text/javascript">		
	function itemPayment(params) {
		if($("#LOGIN_MEM_ID").val() == "") {
				alert("로그인한 사용자만 구매할 수 있습니다.") 
		} else {
			var form = document.createElement("form");
			form.setAttribute("method", "post");
			form.setAttribute("action", "/beauty/item/payment");
			for(var key in params) {
				var hiddenField = document.createElement("input");
				hiddenField.setAttribute("type", "hidden");
				hiddenField.setAttribute("name",key);
				hiddenField.setAttribute("value", params[key]);
				form.appendChild(hiddenField);
			}
			document.body.appendChild(form);
			form.submit();

		}
	}
		
	// 아이템 찜 기능
	function itemStore(ITEM_ID) {
		 if($("#LOGIN_MEM_ID").val() == "") {
			alert("로그인한 사용자만 찜 할 수 있습니다.") 
		 } else {
			 $.ajax({
					type : "post",
					url : "/beauty/item/stored/"+ITEM_ID,
					data : {
						"MEM_ID" : $("#LOGIN_MEM_ID").val()
					},
					datatype : "text",
					success: function(data) {
						if(data==1) {
							alert("찜 목록에 등록 되었습니다!");
						} else {
							alert("찜 목록에 등록할 수 없습니다.");
						}
					},
					error : function(request) {
						console.log("AJAX 에러");
						alert("code : " + request.stauts + "\n"
								+ "message :" + request.responseText);
					}
				});
		 }
		
	}
	function reviewCheck(ITEM_ID) {
			if($("#LOGIN_MEM_ID").val() == "") {
				alert("로그인 한 사용자만 리뷰를 작성할 수 있습니다.");
			} else {
				location.href="/beauty/review/write/"+ITEM_ID
			}
		}
		
	</script>

	<!-- 하단 -->
	<%@include file="footer.jsp" %>
</body>
</html>