<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PSY MAIN</title>
<link rel="stylesheet" type="text/css" href="/css/w3.css">
<link rel="stylesheet" type="text/css" href="/css/user.css">
<script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">
$(document).ready(function(){
	$('#login').click(function(){
		$(location).attr('href', '/member/login.psy');
	});
	$('#logout').click(function(){
		$(location).attr('href', '/member/logoutProc.psy');
	});
	$('#join').click(function(){
		$(location).attr('href', '/member/join.psy');
	});
	$('#mList').click(function(){
		$(location).attr('href', '/member/memberList.psy');
	});
	$('#fboard').click(function(){
		$(location).attr('href', '/fboard/fileboard.psy');
	});
	$('#gboard').click(function(){
		$(location).attr('href', '/gboard/gboard.psy');
	});
});
</script>
</head>
<body>
	<div class="w3-content mxw650 w3-center">
		<h1 class="w3-pale-green w3-padding w3-card-4 w3-round-large">PSY MAIN</h1>
		<div class="w3-col">
<c:if test="${empty SID}">
			<div class="w3-btn w3-pale-blue w3-right w3-small" id="login">로그인</div>
			<div class="w3-btn w3-blue-gray w3-right w3-small" id="join">회원가입</div>
</c:if>
<c:if test="${not empty SID}">
			<div class="w3-btn w3-pale-red w3-right w3-small" id="logout">로그아웃</div>
			<div class="w3-btn w3-indigo w3-left w3-small" id="mList">회원리스트</div>
</c:if>
			<div class="w3-btn w3-aqua w3-left w3-small" id="fboard">게시판</div>
			<div class="w3-btn w3-pink w3-left w3-small" id="gboard">방명록</div>
		</div>
	</div>
</body>