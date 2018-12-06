<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<c:if test="${loginUser != null}">
${loginUser.name}
<a href='/auth/logout'>로그아웃</a>
</c:if>
<c:if test="${loginUser == null}">
<a href='/auth/login'>로그인</a>
</c:if> 
</div>
    