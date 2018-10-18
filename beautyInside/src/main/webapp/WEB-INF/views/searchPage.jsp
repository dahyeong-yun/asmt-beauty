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
 							<label for="male" class="btn btn-primary">
   							<input type="radio" name="filterGENDER" id="male" autocomplete="off" value="1">남자</label>
 							
							<label for="female" class="btn btn-primary">
							<input type="radio" name="filterGENDER" id="female" autocomplete="off" value="2">여자</label>
							
						<h2>연령대</h2>
							<label for="teenage" class="btn btn-primary"><input type="checkbox" name="filterAGE" autocomplete="off" value="1" id="teenage">10대</label>
							<label for="twenty" class="btn btn-primary"><input type="checkbox" name="filterAGE" autocomplete="off" value="2" id="twenty">20대</label>
							<label for="thirty" class="btn btn-primary"><input type="checkbox" name="filterAGE" autocomplete="off" value="3" id="thirty">30대</label>
							<label for="forty" class="btn btn-primary"><input type="checkbox" name="filterAGE" autocomplete="off" value="4" id="forty">40대</label>
							<label for="fifty" class="btn btn-primary"><input type="checkbox" name="filterAGE" autocomplete="off" value="5" id="fifty">40대 이상</label>
							
						<h2>피부타입</h2>
							<label for="dry" class="btn btn-primary"><input type="checkbox" autocomplete="off" name="filterSKINTYPE" value="1" id="dry">건성</label>
							<label for="normal" class="btn btn-primary"><input type="checkbox" autocomplete="off" name="filterSKINTYPE" value="2" id="normal">중성</label>
							<label for="oily" class="btn btn-primary"><input type="checkbox" autocomplete="off" name="filterSKINTYPE" value="3" id="oily">지성</label>
							<label for="combination" class="btn btn-primary"><input type="checkbox" autocomplete="off" name="filterSKINTYPE" value="4" id="combination">복합성</label>
						<input type="hidden" value="${param.ITEM_CATEGORY}" name="ITEM_CATEGORY" id="ITEM_CATEGORY">
						<input type="hidden" value="${param.ITEM_NAME}" name="ITEM_NAME" id="ITEM_NAME">
						<br>
					</form>
				</div>
			</div>		

			<!-- 검색 결과  -->
			<div class="col-sm-6 col-md-8" id="itemlist">
				<table>
					<c:forEach var="list" items="${searchResult}">
							<tr onclick="location.href='/beauty/item/${list.ITEM_ID}'">
								<td><img src="${list.ITEM_IMAGE}" style="max-width: 180px;height: auto"/></td>
								<td>${list.ITEM_BRAND} ${list.ITEM_NAME} ${list.ITEM_CAPA } ${list.ITEM_PRICE}원</td>
							</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	
	<!-- 하단 -->
	<%@include file="footer.jsp" %>
	
	<script type="text/javascript">
 		$('input:checkbox').click(function() {
 			var obj = document.getElementById("ITEM_CATEGORY");
 			var n = document.getElementById("ITEM_NAME");
 			if(n.value.length<=0){
 				n.setAttribute("disabled","disabled");
 			}
 			if(obj.value=="") {
 				obj.setAttribute("disabled","disabled");
 			}
 			var f = $('#searchFilter').serialize();
			$.ajax({
				type : "get",
				url : "/beauty/item/filter.do",
				data : f,
				datatype : "json",
				contentType : "application/json; charset=utf-8",
				success: function(data) {
					console.log(data.filterResult);
					itemList(data.filterResult);
				},
				error : function(request) {
					console.log("AJAX에러");
					alert("code : " + request.stauts + "\n"
							+ "message :" + request.responseText);
				}
			});
		});
 		
 		function itemList(item){
 			html = '<table>';
 			for (var i = 0; i<item.length; i++){
	 			html += '<tr onclick="location.href=\'/beauty/item/'+item[i].ITEM_ID+'\'"><td><img src="'
	 			+item[i].ITEM_IMAGE+'" style="max-width: 180px;height: auto"/></td><td>'+item[i].ITEM_BRAND+' '
	 			+item[i].ITEM_NAME+' '+item[i].ITEM_CAPA+' '+item[i].ITEM_PRICE+'원</td></tr>'
	 		}
			html += '</table>'; 
			$('table').remove();
			$('#itemlist').append(html);
 		}
	</script>
</body>
</html>