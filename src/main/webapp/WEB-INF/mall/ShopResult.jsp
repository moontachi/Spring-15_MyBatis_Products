<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShopResult.jsp</title>
</head>
<body>
	<h1>ShopResult.jsp</h1>
	<a href="main.jsp">시작 페이지</a>
	<h2>주문 상세 내역</h2>
	<table border="1">
		<tr>
			<td colspan="2">
				고객 : ${sessionScope.loginInfo.name }
			</td>
			<td colspan="3">
				송장번호 : ${oid }
			</td>
		</tr>
		<tr>
			<td colspan="5">
				배송지 : ${sessionScope.loginInfo.address1 }&nbsp; ${sessionScope.loginInfo.address2 }
			</td>
		</tr> 
		<tr>
			<th>순번</th>
			<th>상품명(상품번호)</th>
			<th>수량</th>
			<th>단가</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${lists }" var="sinfo" varStatus="status">
			<tr>
				<td>${status.count }</td>			
				<td>${sinfo.pname }(${sinfo.pnum })</td>			
				<td>${sinfo.qty }</td>			
				<td>
					<fmt:formatNumber value="${sinfo.price }" pattern="###,###"/>
				</td>			
				<td>
					<fmt:formatNumber value="${sinfo.amount }" pattern="###,###"/>
				</td>			
			</tr>
		</c:forEach>
	</table>
</body>
</html>