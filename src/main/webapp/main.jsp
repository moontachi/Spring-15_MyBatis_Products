<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
main.jsp<br><br>

<%
	String viewProduct = request.getContextPath() + "/list.prd";
	String viewOrder = request.getContextPath() + "/order.mall";
%>

<a href="<%=viewProduct%>">상품 목록 보기</a> <br><br><br>

<a href="<%=viewOrder%>">나의 주문 내역</a> <br><br><br>

session.getAttribute("loginInfo") : <%=session.getAttribute("loginInfo")%>