<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>메인페이지</title>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/default.css">
	<style type="text/css">
		/* The Modal (background) */
		.modal-fat {
			display: none;
			/* Hidden by default */
			position: fixed;
			/* Stay in place */
			z-index: 1;
			/* Sit on top */
			left: 0;
			top: 0;
			width: 100%;
			/* Full width */
			height: 100%;
			/* Full height */
			/* Enable scroll if needed */
			background-color: rgb(0, 0, 0);
			/* Fallback color */
			background-color: rgba(0, 0, 0, 0.4);
			/* Black w/ opacity */

		}

		/* Modal Content/Box */
		.modal-content-fat {
			background-color: #2f3235;
			border-color: aqua;
			border-radius: 20px;
			margin: 15% auto;
			/* 15% from the top and centered */
			padding: 20px;
			border: 2px double aqua;
			color: white;
			font-family: fantasy;
			width: 50%;
			/* Could be more or less, depending on screen size */
		}		

		/* The Close Button */
		.close {
			color: #aaa;
			float: right;
			font-size: 28px;
			font-weight: bold;
		}

		.close:hover,
		.close:focus {
			color: black;
			text-decoration: none;
			cursor: pointer;
		}
	</style>
</head>

<body style="background-image: url('resources/images/night.jpg'); background-size: cover;">
	<c:if test="${LOGIN == null}">
		<br><input type="button" class="btn btn-secondary" onclick="location.href='login.do'" value="로그인">
	</c:if>
	<c:if test="${LOGIN!=null}">
		<font color=white>${LOGIN.userid}님 환영합니다</font><br>
		<input type="button" class="btn btn-secondary" onclick="location.href='logout.do'" value="로그아웃">
	</c:if>
	<input type="button" class="btn btn-secondary" onclick="location.href='list.do'" value="게시물 목록보기">
	<input type="button" class="btn btn-secondary" onclick="location.href='write.do'" value="게시물 작성">
	<input type="button" class="btn btn-secondary" onclick="location.href='index.jsp'" value="시작페이지로 돌아가기">

	<!-- Trigger/Open The Modal -->
	<button id="myBtn" class="btn btn-secondary">공지사항 보기</button>

	<!-- The Modal -->
	<div id="myModal" class="modal-fat">
		<div class="modal-content-fat" align="center">
			<span class="close">&times;</span>
			<h1 align="center">
				<font style="font-family: sans-serif;">공지사항</font>
			</h1>
			<a href="list.do" align="center">
				<img src="resources/images/a5.png" style="border-radius: 20px;" width="50%" height="240px" align="middle"><br>
				<h3>게시판으로 가기</h3>
			</a>
			<input type="button" class="closeTodayBtn btn btn-secondary" width="80%" value="오늘 하루 안보기">
			<input type="button" class="resetBtn btn btn-secondary" width="80%" value="리셋">
		</div>
	</div>
	<hr>
</body>

<script src="resources/js/popup.js"></script>

</html>