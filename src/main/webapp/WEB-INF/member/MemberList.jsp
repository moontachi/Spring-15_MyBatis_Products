<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>     
<script type="text/javascript">
	function insert(){
		location.href="registerForm.me";	//MemberRegisterController.java에서 요청처리
	}
</script>
회원 리스트 화면 <br>
member\MemberList.jsp<br><br>

<form action="list.me" method="get">
	<select name="whatColumn">
		<option value="all">전체검색
		<option value="name">이름
		<option value="gender">성별
	</select>
	<input type="text" name="keyword" value="여">
	<input type="submit" value="검색">
</form>

<table border="1">
	<tr>
		<td colspan="9" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>	
	</tr>
	<tr>
		<th>ID</th>
		<th>이름</th>
		<th>비번</th>
		<th>성별</th>
		<th>취미</th>
		<th>주소</th>
		<th>포인트</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<c:forEach var="bean" items="${lists }" >
		<tr>
			<td>${bean.id }</td>
			<td>${bean.name }</td>
			<td>${bean.password }</td>
			<td>${bean.gender }</td>
			<td>${bean.hobby }</td>
			<td>${bean.address1 } ${bean.address2 }</td>
			<td>${bean.mpoint }</td>
			<td><a href="delete.me?id=${bean.id}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
			<td>수정</td>																		
		</tr>
	</c:forEach>
	 
</table><br>

${pageInfo.pagingHtml }<br><br>