<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Login Page - Ace Admin</title>

<meta name="description" content="User login page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />
<!-- Font Text -->
<link href="font-VN/font-awesome.min.css" rel="stylesheet">
<!-- ace styles -->
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />


</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">JSP
									SERVLET</span> <span class="white" id="id-text2"> WEBSITE</span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy; Phong Trần</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> Chọn file ảnh
										</h4>

										<div class="space-6"></div>
										<form method="POST" enctype="multipart/form-data"
											action="InsertImage?idAnh=<%=request.getParameter("idAnh")%>" >											
										 	<input type="file" name ="file" />
										 	<input type="submit" value="Thêm ảnh" /> 
										</form>


									</div>


								</div>
							</div>
						</div>

					</div>

					<div class="navbar-fixed-top align-right">
						<br /> &nbsp; <a id="btn-login-dark" href="#">Dark</a> &nbsp; <span
							class="blue">/</span> &nbsp; <a id="btn-login-blur" href="#">Blur</a>
						&nbsp; <span class="blue">/</span> &nbsp; <a id="btn-login-light"
							href="#">Light</a> &nbsp; &nbsp; &nbsp;
					</div>
				</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	
	<!-- /.main-container -->

	<!-- basic scripts -->
	<script type="text/javascript">
		function checkPass() {
			var pass = document.myForm.pass.value;
			var enterThePass = document.myForm.enterThePass.value;

			if (pass != enterThePass) {
				document.getElementById("checkPass").innerHTML = "Mật khẩu nhập lại chưa trùng khớp";

			} else {
				document.getElementById("checkPass").innerHTML = "";
			}
		}
	</script>

	<!--[if !IE]> -->
	<script src="assets/js/jquery-2.1.4.min.js"></script>

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			$(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			});
		});
		//you don't need this, just used for changing background
		jQuery(function($) {
			$('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');

				e.preventDefault();
			});
			$('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');

				e.preventDefault();
			});

		});
	</script>
</body>
</html>