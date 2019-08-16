<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>게시물 목록</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.bno}</td>
					<td>
						<a href="/board/view?bno=${list.bno}">${list.title}</a>
						</td>
					<td>${list.content}</td>
					<td>${list.writer}</td>
					<td><fmt:formatDate value="${list.regDate}"
							pattern="yyyy-MM-dd" /></td>
					<td>${list.viewCnt}</td>
				</tr>
			</c:forEach>
		</tbody>
				
	</table>

<a href="/board/write">게시물 작성</a>
<a href="/">Home 으로</a>

</body>
</html>