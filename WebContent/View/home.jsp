<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
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

		<!--Carousel
  ==================================================-->

		<div id="myCarousel" class="carousel slide">
			<div class="carousel-inner">
				<c:forEach items="${listSlide }" var="list">
					<c:if test="${list.slideId ==1 }">
						<div class="active item">
							<div class="container">
								<div class="row">

									<div class="span6">

										<div class="carousel-caption">
											<h1>${list.ten }</h1>
											<p class="lead">${list.noiDung }</p>
											<button class="btn btn-white btn-info btn-bold"
												data-toggle="modal" data-target="#myModal">Múc</button>
										</div>
									</div>
									<div class="span6">
										<img src="Template/img/slide/${list.anh}">
									</div>

								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${list.slideId >1 }">
						<div class="item">
							<div class="container">
								<div class="row">
									<div class="span6">
										<c:if test="${list.slideId ==2 }">
											<div class="carousel-caption">
												<h1>${list.ten }</h1>
												<p class="lead">${list.noiDung }</p>
												<button class="btn btn-white btn-info btn-bold"
													data-toggle="modal" data-target="#myModal2">Múc</button>
											</div>
										</c:if>
										<c:if test="${list.slideId ==3 }">
											<div class="carousel-caption">
												<h1>${list.ten }</h1>
												<p class="lead">${list.noiDung }</p>
												<button class="btn btn-white btn-info btn-bold">
													Múc</button>
											</div>
										</c:if>
									</div>
									<div class="span6">
										<img src="Template/img/slide/${list.anh }" width="450px"
											height="450px">
									</div>

								</div>
							</div>

						</div>
					</c:if>
				</c:forEach>
			</div>
			<!-- Carousel nav -->
			<a class="carousel-control left " href="#myCarousel"
				data-slide="prev"><i class="icon-chevron-left"></i></a> <a
				class="carousel-control right" href="#myCarousel" data-slide="next"><i
				class="icon-chevron-right"></i></a>
			<!-- /.Carousel nav -->

		</div>
		<!-- /Carousel -->



		<!-- Feature 
  ==============================================-->


		<div class="row feature-box">
			<div class="span12 cnt-title">
				<h1>Một số trang web giúp bạn hiểu biết hơn về tiếng anh</h1>
				<span>Không chỉ là tấm gương - đó là con đường</span>
			</div>

			<div class="span4">
				<img src="Template/img/icon2.png">
				<h2>Nghe</h2>
				<p>Youtube là nền tảng mạng xã hội video trực tuyến, bạn có thể
					tìm thấy gì đó hay ho để nghe.</p>

				<a href="https://www.youtube.com/">FORWARD &rarr;</a>

			</div>

			<div class="span4">
				<img src="Template/img/icon2.png">
				<h2>Dịch</h2>
				<p>Tham khảo phần mềm dịch tiếng anh tại đây.</p>
				<a
					href="https://vikitranslator.com/blog/top-3-phan-mem-dich-tieng-anh-online-chinh-xac-nhat-hien-nay.html">FORWARD
					&rarr;</a>
			</div>

			<div class="span4">
				<img src="Template/img/team1.jpg" width="260px">
				<h2>Chọn khóa học</h2>
				<p>Cảm ơn đã tin tưởng và lựa chọn khóa học của chúng tôi. Bạn
					sẽ đạt được mong muốn tùy theo khóa học.</p>
				<a href="#">FORWARD &rarr;</a>
			</div>
		</div>


		<!-- /.Feature -->

		<div class="hr-divider"></div>

		<!-- Row View -->


	


	</div>


	


	<!--Footer
==========================-->
	<jsp:include page="footer.jsp"></jsp:include>

	<!--/.Footer-->

	<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">Lựa chọn phần bạn muốn học</h4>
				</div>
				<div class="modal-body">
					<div class="media">
						<a href="#" class="pull-left"><img src="image/luyen-nghe-tieng-anh-giao-tiep-co-ban-1_cb2c72de5a364af293f706653f61fff7_grande.jpg"
							width="50px" class="media-object" alt='' /></a>
						<div class="media-body">
							<h4>
								<a href="#">Hướng dẫn phần nghe</a>
							</h4>

						</div>
					</div>
					<div class="media">
						<a href="#" class="pull-left"><img
							src="image/76520.jpg"
							width="50px" class="media-object" alt='' /></a>
						<div class="media-body">
							<h4>
								<a href="#">Hướng dẫn phần đọc</a>
							</h4>



						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button onclick="consoleLog" class="btn btn-default"
						data-dismiss="modal" type="submit">Đóng</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal2 -->
	<div class="modal fade" id="myModal2" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">Lựa chọn phần bạn muốn học</h4>
				</div>
				<div class="modal-body">
					<div class="media">
						<a href="#" class="pull-left"><img src="image/word-image-768x512.jpeg"
							width="50px" class="media-object" alt='' /></a>
						<div class="media-body">
							<h4>
								<a href="#">Hướng dẫn phần từ vựng</a>
							</h4>

						</div>
					</div>
					<div class="media">
						<a href="#" class="pull-left"><img
							src="image/maxresdefault.jpg"
							width="50px" class="media-object" alt='' /></a>
						<div class="media-body">
							<h4>
								<a href="ListGrammarGuidelineForward?pageid=1">Hướng dẫn phần ngữ pháp</a>
							</h4>



						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button onclick="consoleLog" class="btn btn-default"
						data-dismiss="modal" type="submit">Đóng</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>