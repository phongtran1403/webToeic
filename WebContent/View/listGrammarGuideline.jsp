<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách ngữ pháp</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap -->
<link href="Template/css/bootstrap.css" rel="stylesheet">
<link href="Template/css/bootstrap-responsive.css" rel="stylesheet">
<link href="Template/css/style.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery.js"></script>
<script src="Template/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function search() {
		var xmlHttp;
		var searchn= document.myForm.searchn.value;
		
			var url = "SearchController?searchn="+searchn;
			if(window.XMLHttpRequest){
				xmlHttp= new XMLHttpRequest();
			}else{
				xmlHttp= new ActiveXOject("Microsoft.XMLHTTP");
			}
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState ==4 ){
					var data= xmlHttp.responseText;
					document.getElementById("searchResult").innerHTML = data;
					
				}
			}
			xmlHttp.open("POST",url,true);
			xmlHttp.send();
		
	}
</script>
</head>
<body>
	<!--HEADER ROW-->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- /HEADER ROW -->
	<div class="container">
		<div class="row">
			<div class="span6">
				<div>
					<form name="myForm">
						<input type="text" class="form-control" placeholder="Tìm kiếm"
							style="width: 500px" name="searchn"  onkeyup="search()">
					</form>
				</div>
			</div>
		</div>

		<div class="container" id="searchResult">
			<!--PAGE TITLE-->

			<div class="row">
				<div class="span12">
					<div class="page-header">
						<h1>Danh sách ngữ pháp</h1>
					</div>
				</div>
			</div>

			<!-- /. PAGE TITLE-->

			<div class="row">
				<c:forEach items="${listGrammar}" var="list">
					<div class="span6">
						<div class="media">
							<a href="#" class="pull-left"><img
								src="ImageUpload/${list.anh }" width="140px"
								class="media-object" alt='' /></a>
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
		</div>
		<!--Pagination-->
		<div class="row">
			<div class="pagination">
				<ul>
					<c:if test="${numberPage == 1}">
						<li><a href="#">Prev</a></li>
						<li><a href="ListGrammarGuidelineForward?pageid=1">1</a></li>
						<li><a href="ListGrammarGuidelineForward?pageid=2">2</a></li>
						<li><a
							href="ListGrammarGuidelineForward?pageid=${numberPage +1}">Next</a></li>
					</c:if>
					<c:if test="${numberPage >1 && numberPage <pageMax}">
						<li><a
							href="ListGrammarGuidelineForward?pageid=${numberPage -1}">Prev</a></li>
						<li><a href="ListGrammarGuidelineForward?pageid=1">1</a></li>
						<li><a href="ListGrammarGuidelineForward?pageid=2">2</a></li>
						<li><a
							href="ListGrammarGuidelineForward?pageid=${numberPage +1}">Next</a></li>
					</c:if>
					<c:if test="${numberPage == pageMax}">
						<li><a
							href="ListGrammarGuidelineForward?pageid=${numberPage -1}">Prev</a></li>
						<li><a href="ListGrammarGuidelineForward?pageid=1">1</a></li>
						<li><a href="ListGrammarGuidelineForward?pageid=2">2</a></li>
						<li><a href="#">Next</a></li>
					</c:if>

				</ul>
			</div>
		</div>
		<!--/.Pagination-->
	</div>

	<!--Footer
==========================-->
	<jsp:include page="footer.jsp"></jsp:include>

	<!--/.Footer-->

</body>
</html>