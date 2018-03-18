<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>公选课管理系统</title>
    <link rel="shortcut icon" href="<%=root %>/media/image/favicon.ico" /> 
   <link rel="stylesheet" href="<%=root %>/common/plugs/bootstrap-3.3.5/css/bootstrap.min.css?rev=5d5357cb3704e1f43a1f5bfed2aebf42"/>
    <link rel="stylesheet" href="<%=root %>/common/css/font-awesome.min.css?rev=0831cba6a670e405168b84aa20798347"/>
    <link rel="stylesheet" href="<%=root %>/common/css/animate.min.css?rev=5d2583e9396158551367d33fd389e70f"/>
    <link rel="stylesheet" href="<%=root %>/common/plugs/layer/skin/layer.css?rev=433a1dd8df8c4851be764e907f6d758a"/>
    <link rel="stylesheet" href="<%=root %>/common/css/style.min.css?rev=281bbc400e391bfa932fefae04fbcfb7"/>
    <script src="<%=root %>/common/js/jquery.metisMenu.js?rev=596f5abcac8359e9cb8046b69278e5ff"></script>
    <script src="<%=root %>/common/js/jquery.slimscroll.min.js?rev=db59b66b91ac5999f3502d2fd88c37da"></script>
    <script src="<%=root %>/common/plugs/layer/layer.js?rev=8962f047eeb03c06cf8200de1bf8ab99"></script>
<%--     <script src="<%=root %>/common/js/hplus.min.js?rev=d74acbcab81cfd5e0038d946f040682e"></script>
 --%>    <script src="<%=root %>/common/js/tabs.js?rev=1447835708801"></script>
    <script src="<%=root %>/common/js/pace.min.js?rev=138fe1152c26f969c65fcd5c1cdc749e"></script>
    <link rel="stylesheet" href="<%=root %>/common/main.css?rev=1447835708801"/>
</head>
<body class="fixed-sidebar full-height-layout gray-bg">
  <div id="wrapper">
    <nav role="navigation" class="navbar-default navbar-static-side">
      <div class="nav-close"><i class="fa fa-times-circle"></i></div>
      <div class="sidebar-collapse">
        <ul id="side-menu" class="nav">
                    <li class="nav-header">
                        <div class="dropdown profile-element text-center">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <!-- <i class="fa fa-area-chart"></i> -->
                                        <strong class="page-title">管理系统</strong>
                                    </span>
                                </span>
                            </a>
                        </div>
                    </li>
                    <!-- <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">wy</span>
                    </li> -->
                    <%-- <li class="start active ">
                        <a class="J_menuItem" href="<%=root %>/list.do">
                            <i class="icon-home"></i>
                            <span class="title">主页</span>
                        </a>
                    </li> --%>
                    <c:forEach items="${user.menus}" var="allMenu">
                    	<li class="start active ">
                    		<c:if test="${allMenu.pid == 0}">
	                    		<a class="J_menuItem" href="#">
		                            <span class="title"><i class="fa fa-barcode"></i>${allMenu.permisname}</span>
		                            <span class="arrow"></span>
		                        </a>
	                        </c:if>
	                        <ul class="sub-menu">
	                        	<c:forEach items="${user.menus}" var="menu">
	                        		<c:if test="${allMenu.id == menu.pid && menu.pid != 0}">
		                        		<li style="list-style:none">
			                                <a class="J_menuItem" href="<%=root %>${menu.path}"><i class="fa fa-barcode"></i>${menu.permisname}</a>
			                            </li>
		                            </c:if>
	                            </c:forEach>
	                        </ul>
                    	</li>
                    </c:forEach>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
      <div class="row border-bottom">
        <nav class="navbar navbar-static-top">
          <div class="navbar-header hide"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary"><i class="fa fa-bars"></i></a></div>
          <div style="height: 50px; line-height: 50px;" class="row text-right">
            <div class="col-md-4 col-md-offset-8"> 
              <div class="row">
                    <div class="col-md-20 col-md-offset-20"> 
                            <span>你好,${user.relname}</span><span>|</span>
                            <span id="updPwdSpan" style="margin-right:20px;">
                            <a id="J_tabUpdPwd" class="roll-nav roll-right J_tabUpdPwd" href="javascript:;">
                           	     修改个人信息<span>|</span>
                            </a>
                            </span>
                    </div>
                    </div>
                    </div>
                 </nav>
            </div>
            <div class="row content-tabs bg-ff">
				<button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i></button>
				<nav class="page-tabs J_menuTabs">
					<div class="page-tabs-content"><a data-id="./Modal/main/index/index.html" class="active J_menuTab">首页</a></div>
				</nav>
				<button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i></button>
				<div class="btn-group roll-nav roll-right">
					<button data-toggle="dropdown" class="dropdown J_tabClose">

						关闭操作<span class="caret"></span>
					</button>
					<ul role="menu" class="dropdown-menu dropdown-menu-right">
						<li class="J_tabShowActive"><a>定位当前选项卡</a></li>
						<li class="divider">
							<li class="J_tabCloseAll"> <a>关闭全部选项卡</a></li>
						</li>
						<li class="J_tabCloseOther"> <a>关闭其它选项卡</a></li>
					</ul>
				</div>
				<a class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out">退出</i></a>
			</div>
        <div class="row J_mainContent" id="content-main">
                <iframe id="J_iframe" width="100%" height="100%" frameborder="0" src=""></iframe>
            </div>
    </div>
    <!--右侧部分结束-->
    <div id="dialogTip" tabindex="-1" role="dialog" aria-hidden="true" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button data-dismiss="modal" aria-hidden="true" type="button" class="close">&times;</button>
          <h4 class="modal-title">提示</h4>
        </div>
        <div class="modal-body">
          <h3 data-name="content">操作成功!</h3>
        </div>
      </div>
    </div>
  </div>
  <div id="logOut" tabindex="-1" role="dialog" aria-hidden="true" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button data-dismiss="modal" aria-hidden="true" type="button" class="close">&times;</button>
          <h4 class="modal-title">退出当前系统</h4>
        </div>
        <div class="modal-body">
          <h4>确定退出当前系统？</h4>
        </div>
        <div class="modal-footer">
          <button id="exitSure" class="btn btn-info">确定</button>
          <button data-dismiss="modal" class="btn btn-default">取消</button>
        </div>
      </div>
    </div>
  </div>
  <div id="updPosswordDiv" tabindex="-1" role="dialog" aria-hidden="true" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button data-dismiss="modal" aria-hidden="true" type="button" class="close">&times;</button>
          <h4 class="modal-title" id="myModalLabel">修改密码</h4>
        </div>
        <div class="modal-body" align="center">
               <input type="hidden"  id="uid" value="" name="uid">
                                                    原密码：&nbsp;&nbsp;&nbsp;<input type="password" name="oldPassword" id="oriPassword"></br></br>
                                                    新密码：&nbsp;&nbsp;&nbsp;<input type="password" name="newPassword" id="password"></br></br>
                                                确认密码：<input type="password" name="confirmPassword" id="confirmPassword">
        </div>
        <div class="modal-footer">
          <button id="updPwd" style="width: 60px;height: 35px;">确定</button>
          <button data-dismiss="modal" class="btn btn-default">取消</button>
        </div>
      </div>
    </div>
  </div>

<script src="<%=root %>/common/main.js"></script>
</body>
</html>