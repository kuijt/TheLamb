<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<p>
		<a href="/board/list">게시물 목록</a><br/>
		<a href="/board/listPage?num=1">게시물 목록 - 페이지1</a><br/>
	</p>

<!-- 내용추가 -->
</body>
</html>
