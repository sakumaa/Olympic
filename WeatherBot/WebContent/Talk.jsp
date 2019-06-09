<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>くもぞうの部屋</h1>
<div id="talk_box">
	<div class="talk kumozou">
		<div class="icon"><img src="./images/kumozou_icon.jpg" alt="くもぞう" title="くもぞう" /></div>
		<div class="text">こんにちは！<br>今日の東京都の天気は晴れ。<br>最高気温は20℃、最低気温は15℃だよ。</div>
	</div>
	<div class="talk user">
		<div class="icon"><img src="/images/default_icon.jpg" alt="あなた" title="あなた" /></div>
		<div class="text">明日の天気を教えて。</div>
	</div>
</div>
<form id="user_input" method="POST" action="TalkServlet">
	<input type="text" name="talk" placeholder="くもぞうに訊きたいことを入力してください" />
	<input type="submit" name="submit" value="送信"/>
</form>
</body>
</html>