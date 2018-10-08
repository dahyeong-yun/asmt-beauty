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
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<title>:: Beauty Inside ::</title>

<title>:: Beauty Inside ::</title>
<style>
</style>
</head>
<body class="bg-light">
	<!-- 상단바 -->
	<%@include file="navbar.jsp" %>
	
	<!-- 전체 페이지 -->
	<div class="container mt-3">
		<div class="row">
		
			<!-- 검색 옵션 -->
			<div class="col-sm-6 col-md-4">
				<div class="card p-3">
					<form id="searchFilter">
						<h2>성별</h2>
 							<label for="male" class="btn btn-primary" onclick="searchFilter()">남자</label>
   							<input type="radio" name="GENDER_ID" id="male" autocomplete="off" value="남자">
 							
							<label for="female" class="btn btn-primary" onclick="searchFilter()">여자</label>
							<input type="radio" name="GENDER_ID" id="female" autocomplete="off" value="여자">
							
						<h2>연령대</h2>
							<label for="teenage" class="btn btn-primary">10대</label>
								<input type="checkbox" name="AGE_ID" autocomplete="off" value="1" id="teenage">
							
							<label for="twenty" class="btn btn-primary"><input type="checkbox" name="AGE_ID" autocomplete="off" value="2" id="twenty">20대</label>
							<label for="thirty" class="btn btn-primary"><input type="checkbox" name="AGE_ID" autocomplete="off" value="3" id="thirty">30대</label>
							<label for="forty" class="btn btn-primary"><input type="checkbox" name="AGE_ID" autocomplete="off" value="4" id="forty">40대</label>
							<label for="fifty" class="btn btn-primary"><input type="checkbox" name="AGE_ID" autocomplete="off" value="5" id="fifty">40대 이상</label>
							
						<h2>피부타입</h2>
							<label for="severely dry" class="btn btn-primary"><input type="checkbox" autocomplete="off" name="SKINTYPE_ID" value="1" id="severely dry">악건성</label>
							<label for="dry" class="btn btn-primary"><input type="checkbox" autocomplete="off" name="SKINTYPE_ID" value="2" id="dry">건성</label>
							<label for="normal" class="btn btn-primary"><input type="checkbox" autocomplete="off" name="SKINTYPE_ID" value="3" id="normal">중성</label>
							<label for="oily" class="btn btn-primary"><input type="checkbox" autocomplete="off" name="SKINTYPE_ID" value="4" id="oily">지성</label>
							<label for="severely oily" class="btn btn-primary"><input type="checkbox" autocomplete="off" name="SKINTYPE_ID" value="5" id="severely oily">악지성</label>
							<label for="combination" class="btn btn-primary"><input type="checkbox" autocomplete="off" name="SKINTYPE_ID" value="6" id="combination">복합성</label>
							
						<br>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>		

			<!-- 검색 결과  -->
			<div class="col-sm-6 col-md-8">
				<table>
					<c:forEach var="list" items="${searchResult}">
							<tr onclick="location.href='/beauty/item/${list.ITEM_ID}'">
								<td><img src="${list.ITEM_IMAGE}" style="max-width: 180px;height: auto"/></td>
								<td>${list.ITEM_BRAND} ${list.ITEM_NAME} ${list.ITEM_PRICE}원</td>
							</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	
	<!-- 하단 -->
	<%@include file="footer.jsp" %>
	
	<script type="text/javascript">
/* 		function filtering() {
			$.ajax({
				type : "get",
				url : "/beauty/item",
				data : {
					"GENDER_ID" : $("#GENDER_ID").val(),
					"AGE_ID" : $("#AGE_ID").val(),
					"SKINTYPE_ID" : $("#SKINTYPE_ID").val()
				},
				datatype : "text",
				success: function(data) {
					if(data==) {
					} else {
		
					}
				},
				error : function(request) {
					console.log("AJAX에러");
					alert("code : " + request.stauts + "\n"
							+ "message :" + request.responseText);
				}
			});
		} */
	</script>
</body>
</html>