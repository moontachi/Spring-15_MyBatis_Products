<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShopList.jsp</title>
</head>
<body>
	<h1>ShopList.jsp</h1>
	<a href="logout.jsp">로그아웃</a>
	<h2>주문 내역</h2>
	<table border="1">
		<tr>
			<td colspan="3">
				주문자 정보 : ${sessionScope.loginInfo.name }(${sessionScope.loginInfo.id })
			</td>
		</tr>
		<tr>
			<th>주문 번호</th>
			<th>주문 일자</th>
			<th>상세보기</th>
		</tr>
		
		<c:forEach var="lists" items="${lists}">
			<tr>
				<td>${lists.oid }</td>			
				<td>${lists.orderdate }</td>		
				<td>
					<a href="detailView.mall?oid=${lists.oid }">
						상세보기
					</a>
				</td>			
			</tr>
		</c:forEach>
	</table>
</body>
</html>