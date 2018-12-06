<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물</title>
</head>
<body>
<h1>게시물2</h1>
<table border='1'>
<tr>
  <th>번호</th><th>내용</th><th>작성일</th><th>조회수</th>
</tr>
<c:forEach items="${list}" var="board">
<tr>
  <td>${board.no}</td>
  <td>${board.contents}</td>
  <td>${board.createdDate}</td>
  <td>${board.viewCount}</td>
</tr>
</c:forEach>
</table>
</body>
</html>









    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    