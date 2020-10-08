<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<%
		/* 모든 세션 정보 설정 해제 */
		session.invalidate();
		response.sendRedirect("main.jsp");
	%>
</body>
</html>