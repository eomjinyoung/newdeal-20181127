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
<h1>게시물 상세정보</h1>

<form action="update" method="post">
<table border='1'>
<tr>
  <th>번호</th>
  <td><input type="text" name="no" readonly 
      value="${board.no}"></td>
</tr>
<tr>
  <th>내용</th>
  <td><textarea name="contents" 
      rows="5" cols="50">${board.contents}</textarea></td>
</tr>
<tr>
  <th>작성일</th>
  <td><input type="text" readonly
      value="${board.createdDate}"></td>
</tr>
<tr>
  <th>조회수</th>
  <td><input type="text" readonly
      value="${board.viewCount}"></td>
</tr>
<tr>
  <th>작성자</th>
  <td><input type="text" readonly
      value="${board.writerNo}"></td>
</tr>
<tr>
  <th>수업</th>
  <td><input type="text" readonly
      value="${board.lessonNo}"></td>
</tr>
<tr>
  <th></th>
  <td>
    <button>변경</button>
    <button type="button" onclick="remove();">삭제</button></td>
</tr>
</table>
</form>

<script>
function remove() {
  location.href = "delete?no=${board.no}"
}
</script>
</body>
</html>









    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    