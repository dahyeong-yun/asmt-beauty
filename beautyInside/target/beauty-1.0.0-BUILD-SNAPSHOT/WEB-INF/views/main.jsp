<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#secondTable {
			width: 900px;
			height: 50px;
			border: 1px solid black;
			margin: auto;
		}
	</style>
</head>
<body>
	<h1>메인 페이지</h1>
	<hr>
	<a href="./">LOGO</a>
	<c:choose>
		<c:when test="${not empty sessionScope.session_id }">
			<c:choose>

				<c:when test="${sessionScope.session_id eq 'admin'}">
					<div style="float: right;">관리자님 환영합니다.</div>
				</c:when>
				<c:otherwise>
					<div style="float: right;">
						<a href="myPage">${sessionScope.session_id }</a> 님 환영해요
					</div>
				</c:otherwise>
			</c:choose>
			<br>
			<div style="float: right;">
				<input type="button" value="로그아웃" onclick="location.href='./logout'">
			</div>
		</c:when>
		<c:otherwise>
			<div style="float: right;">
				<a href="loginPage">Login</a>&emsp;&emsp;/&emsp;&emsp; 
				<a href="signUp">Sign Up</a>
			</div>
		</c:otherwise>
	</c:choose>

	<br>
	<br>

	<table id="firstTable">
		<tr>
			<td><img src="1.jpg"><br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				이미지설명~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
				<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
			</td>
		</tr>
	</table>
	<br>
	<form action="searchItem" method="get">
		<input type="hidden" name="MEM_ID" value="${sessionScope.session_id }">
		<table id="secondTable">
			<tr>
				<td>
					<select name="ITEM_CATEGORY">
						<option value="hair">헤어</option>
						<option value="skincare">스킨케어</option>
						<option value="cleansing">클렌징</option>
						<option value="perfume">향수</option>
					</select>
				</td>
				<td>
					<input type="text" placeholder="검색어 입력" name="ITEM_NAME">
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>