<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>    
 
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>ProuductDetailView.jsp</title>
</head>
<body>
	<h1>ProuductDetailView</h1>
	<h2 align="center">상품 상세 화면</h2>
	<table border="1">
		<tr>
			<td rowspan="6">
				<img src="<%=request.getContextPath() %>/resources/${product.image}" width="100px" height="100px">
			</td>
			<td>상품명</td>
			<td>${product.name }</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${product.price }</td>
		</tr>
		<tr>
			<td>재고수량</td>
			<td>${product.stock }</td>
		</tr>
		<tr>
			<td>설명</td>
			<td>${product.contents }</td>
		</tr>
		<tr>
			<td>주문수량</td>
			<td>
				<!-- add.mall -> CartAddController  -->
				<form action="add.mall" method="post">
					<input type="hidden" name="num" value="${product.num }">
					<input type="text" name="orderqty" value="1"/>
					<input type="submit" value="주문"/>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="list.prd">
					상품 리스트
				</a>
			</td>
		</tr>
	
	</table>
</body>
</html>