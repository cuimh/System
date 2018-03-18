<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
        <title>Fullscreen Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="<%=root %>/assets/css/reset.css">
        <link rel="stylesheet" href="<%=root %>/assets/css/supersized.css">
        <link rel="stylesheet" href="<%=root %>/assets/css/style1.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    <!-- <script>if(window.top !== window.self){ window.top.location = window.location;}</script> -->
</head>

<body>

   <div class="page-container">
            <h1>Login</h1>
            <form action="<%=root %>/login.do" method="post">
                <input type="text" name="name" class="username" placeholder="username">
                <input type="password" name="pwd" class="password" placeholder="password">
                <button type="submit">Sign me in</button>
                <div class="error"><span>+</span></div>
                <p><div class="connect" align="center">${tip}</div></p>
            </form>
        </div>

    <!-- Javascript -->
        <script src="<%=root %>/assets/js/jquery-1.8.2.min.js"></script>
        <script src="<%=root %>/assets/js/supersized.3.2.7.min.js"></script>
        <script src="<%=root %>/assets/js/supersized-init.js"></script>
        <script src="<%=root %>/assets/js/scripts.js"></script>

    
    

</body>

</html>
