<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
String talks = (String)session.getAttribute("session_talk");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<title>お天気ボットくもぞう - トーク画面</title>
<!--&#91;if lt IE 9&#93;>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<!&#91;endif&#93;-->
</head>
<style>
<%@include file="./WEB-INF/css/style.css" %>
</style>
<body>
<form id="menu" method="POST" action="UserManagerServlet">
<input class="menu_icon" type="submit" name="submit" value="メニュー"/>
</form>
<h1>くもぞうの部屋</h1>
<div id="talk_box">
<%= talks != null ? talks : "" %>
</div>
<form id="user_input" method="POST" action="TalkServlet">
	<input type="text" name="talk" placeholder="くもぞうに訊きたいことを入力してください" />
	<input type="submit" name="submit" value="送信"/>
</form>
</body>
</html>