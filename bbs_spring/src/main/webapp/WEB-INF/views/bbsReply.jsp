<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>댓글 입력</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/default.css">
<script type="text/javascript">
	$('#submit').on('click', function() {
		if ($('#br_sabun').val() == null) {
			alert("필수입력값입니다.");
			$('#br_sabun').focus();
			return false;
		}
		if ($('#br_writer').val() == null) {
			alert("필수입력값입니다.");
			$('#br_writer').focus();
			return false;
		}
		if ($('#br_content').val() == null) {
			alert("필수입력값입니다.");
			$('#br_content').focus();
			return false;
		}
		$('#replyForm').submit();
	});
</script>
</head>

<body>
	<table class="table table-dark table-striped table-responsive"
		width="700" border='0' cellspacing="0">
		<tr>
			<td colspan=4></td>
		</tr>
		<tr height='30' align="center">
			<td width=300 colspan=4>댓글 데이타 내용 표시</td>
		</tr>
		<c:forEach var="rvo" items="${rlist}">
			<tr onMouseOver="style.background='#00FFFF'"
				onMouseOut="style.background='' ">
				<td width=100>${rvo.rrn}</td>
				<td width=100>${rvo.br_writer}</td>
				<td width=300>${rvo.br_content}</td>
				<c:if test="${null ne sessionScope.userid}">
					<td width=150><input type="button" class="btn btn-secondary"
						value="삭제"
						onClick="location.href='reply_del.do?idx=${rvo.br_num}&bidx=${rvo.br_sabun}'">
						<input type="button" class="btn btn-secondary" value="수정"
						onClick="location.href='reply_preEdit.do?idx=${rvo.br_num}&bidx=${rvo.br_sabun}'">
					</td>
				</c:if>
			</tr>
		</c:forEach>
		<form id="replyForm" method="get" action="reply.do">
			<tr>
				<td width=300 colspan=4 align="center">댓글 쓰기</td>
			</tr>								
			<input type="hidden" name="br_sabun" value="${vo.b_sabun}" class="form-control" id="br_sabun">
			<div class="form-group">
				<c:choose>
				<c:when test="${sessionScope.userid != null}">
				<tr>
				  <th><label for="br_writer">작성자:</label>
					</th>
					<td colspan=3>
					  <input type="text" name="br_Fwriter" value="${sessionScope.userid}" class="form-control" id="br_writer">
					 </td>
					<tr>
						<div class="form-group">
						<th><label for="br_content">내용:</label></th>
						<td colspan=3>
						  <textarea name="br_content"	class="form-control" id="br_content" rows="3">Content</textarea>
						</td>
					</div>
					</tr>
					<tr>
					  <td colspan=4>
					    <input type="submit" id="submit" class="btn btn-secondary btn-block" value="댓글입력">
					  </td>
					</tr>
				</c:when>
				<c:otherwise>
				<tr>
					<td colspan=4>
					  <input type="button" class="btn btn-secondary btn-block" value="로그인이 필요한 서비스입니다" disabled>
					</td>
				</tr>
				</c:otherwise>
					</c:choose>
				</div>
			</tr>
			<tr>
			</tr>
		</form>
	</table>
</body>

</html>