<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/base.jsp" %>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>Metronic | Extra - 404 Page Option 3</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="<%=root %>/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="<%=root %>/assets/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="<%=root %>/assets/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="<%=root %>/assets/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="<%=root %>/assets/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="<%=root %>/assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="<%=root %>/assets/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="<%=root %>/assets/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES -->

	<link href="<%=root %>/assets/css/error.css" rel="stylesheet" type="text/css"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="<%=root %>/assets/img/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-404-3">

	<div class="page-inner">

		<img src="<%=root %>/assets/img/earth.jpg" alt="">

	</div>

	<div class="container error-404">

		<h1>404</h1>

		<h2>Houston, we have a problem.</h2>

		<p>

			Actually, the page you are looking for does not exist. 

		</p>

		<p>

			<a href="index.html">Return home</a>

			<br>

		</p>

	</div>

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="<%=root %>/assets/js/jquery-1.8.3.min.js" type="text/javascript"></script>   

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->  

	<script src="<%=root %>/assets/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="<%=root %>/assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="assets/js/excanvas.js"></script>

	<script src="assets/js/respond.js"></script>  

	<![endif]-->   

	<script src="<%=root %>/assets/js/breakpoints.js" type="text/javascript"></script>  

	<!-- IMPORTANT! jquery.slimscroll.min.js depends on jquery-ui-1.10.1.custom.min.js --> 

	<script src="<%=root %>/assets/js/jquery.uniform.min.js" type="text/javascript" ></script> 

	<!-- END CORE PLUGINS -->

	<script src="<%=root %>/assets/js/app.js"></script>  

	<script>

		jQuery(document).ready(function() {    

		   App.init();

		});

	</script>

	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>