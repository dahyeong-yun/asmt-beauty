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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 상단바 -->
	<%@include file="navbar.jsp" %>
	
	<!-- 팁 -->
	<div class="container">
		<h2>TIP!</h2>
		<div class="row">
			<c:forEach var="tipList" items="${tipList}">
				<div class="col-md-4">
					<div class="card mb-4 shadow-sm" onclick="window.open('${tipList.TIP_URL}')">
						<img class="card-img-top" src="${tipList.TIP_THUMBNAIL}" data-holder-rendered="true" style="height: 225px; width: 100%; display: block;">
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<!-- 하단 -->
	<%@include file="footer.jsp" %>
</body>
</html>