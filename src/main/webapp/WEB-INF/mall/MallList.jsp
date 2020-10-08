<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MallList.jsp</title>
</head>
<body>
	<h1>MallList.jsp</h1>
	
	<h2>주문내역</h2>
	<table border="1">
		<tr>
			<th colspan="5">주문자 정보 : ${sessionScope.loginInfo.name }(${sessionScope.loginInfo.id })</th>
		</tr>
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>주문 수량</td>
			<td>단가</td>
			<td>금액</td>
		</tr>
		
		<c:forEach var="lists" items="${shoplists }">
		<tr>
			<td>${lists.pnum }</td>
			<td>${lists.pname }</td>
			<td>${lists.qty }</td>
			<td>${lists.price }</td>
			<td>${lists.amount }</td>
		</tr>
		</c:forEach>
		
		
		<tr>
			<td colspan="3">
				<a href="calculate.mall">
					결재하기
				</a>&nbsp;&nbsp;
				<a href="list.prd">  
					추가 주문
				</a>
			</td> 
			<td colspan="2">
				총금액 :${totalAmount }
			</td>
		</tr>
	
	
	</table>
	
	


</body>
</html>