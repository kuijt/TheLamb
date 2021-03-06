<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>게시물 보기</title>
</head>
<body>
	
	<form method="post">
		
		<div>
			<input type="hidden" name="bno" value="${view.bno}" />
		</div>
		
		<div>
			<label>제목</label> <input type="text" name="title" value="${view.title }" />
		</div>
		
		<div>
			<label>작성자</label> <input type="text" name="writer" value="${view.writer}" readonly="readonly"/>
		</div>
		
		<div>
			<label>작성날짜</label>
			<!-- <fmt:formatDate value="${view.regDate}" pattern="yyyy-MM-dd" /> -->
			 <input type="text" name="regDate" 
								value='<fmt:formatDate value="${view.regDate}" pattern="yyyy-MM-dd"/>' readonly="readonly" /> 
		</div>
		
		<div>
			<label>내용</label> 
			<textarea rows="5" cols="50" name="content" >${view.content}</textarea>
		</div>
		
		<div>
			<button type="submit"> 수정 </button>
		</div>

	</form>

</body>
</html>