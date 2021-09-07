<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết trang hướng dẫn ngữ pháp</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap -->
<link href="Template/css/bootstrap.css" rel="stylesheet">
<link href="Template/css/bootstrap-responsive.css" rel="stylesheet">
<link href="Template/css/style.css" rel="stylesheet">


<script src="http://code.jquery.com/jquery.js"></script>
<script src="Template/js/bootstrap.min.js"></script>
</head>
<body>
	<!--HEADER ROW-->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- /HEADER ROW -->
	<div class="container">
		<!--PAGE TITLE-->

		<div class="row">
			<div class="span12">
				<div class="page-header">
					<h1>Ngữ pháp</h1>
				</div>
			</div>
		</div>

		<!-- /. PAGE TITLE-->
		<div class="row">


			<div class="span9">
				<c:forEach items="${detail}" var="detail">
					<div class="blog-post">
						<img src="ImageUpload/${detail.anh}">
						<h2>
							<b>${detail.tieuDe}</b>
						</h2>
						<c:set var="kq" value="${fn:replace(detail.noiDung,data,html)}" />
						<c:set var="kq1" value="${fn:replace(kq,data1,html1)}" />
						<c:set var="kq2" value="${fn:replace(kq1,data2,html2)}" />

						<c:out value="${kq2}" escapeXml="false" />
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<!--Footer
==========================-->
	<jsp:include page="footer.jsp"></jsp:include>

	<!--/.Footer-->

</body>
</html>