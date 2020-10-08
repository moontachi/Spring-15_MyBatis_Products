<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>  

<script type="text/javascript">
	function insert(){
		location.href="insert.prd";
	}
	
	function goUpdate(num) {
		location.href="update.prd?num="+num;
	}
</script>


상품 리스트 화면 <br>    
ProductList.jsp <br>

<form action="list.prd" method="get">
	<select name="whatColumn">
		<option value="all">전체검색
		<option value="name">상품명
		<option value="contents">상품설명
	</select>
	<input type="text" name="keyword" value="오렌지">
	<input type="submit" value="검색">
</form>

<table border="1">
	<tr>
		<td colspan="6" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>	
	</tr>
	<tr>
		<th>상품번호</th>
		<th>상품명</th>
		<th>설명</th>
		<th>가격</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<c:forEach var="bean" items="${lists }" >
		<tr>
			<td>${bean.num }</td>
			<td>
				<a href="detail.prd?num=${bean.num }">${bean.name }</a>
			</td>
			<td>${bean.contents }</td>
			<td>${bean.price }</td>
			<td><a href="delete.prd?num=${bean.num }">삭제</a></td>
			<td><input type="button" value="수정" onclick="goUpdate('${bean.num }')"></td>																		
		</tr>
	</c:forEach>
	 
</table><br>

${pageInfo.pagingHtml }<br><br>






