<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kết quả tìm kiếm</title>
</head>
<body>
		<div class="row">
			<div class="span12">
				<div class="page-header">
					<h1>Danh sách ngữ pháp</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${listGrammar}" var="list">
				<div class="span6">
					<div class="media">
						<a href="#" class="pull-left"><img
							src="ImageUpload/${list.anh }" width="140px" class="media-object"
							alt='' /></a>
						<div class="media-body">
							<h4 class="media-heading">${list.tieuDe}</h4>
							<p></p>
							<form
								action="ListGrammarGuidelineForward?id=${list.idHuongDanNguPhap}"
								method="post">
								<button type="submit">
									<b>Đọc</b>
								</button>
							</form>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
</body>
</html>