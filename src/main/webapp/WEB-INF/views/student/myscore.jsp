<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../base.jsp" %>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="utf-8">
<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">
<link rel="stylesheet"
	href="<%=root %>/common/plugs/bootstrap-3.3.5/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=root %>/common/css/style.min.css" />
<link rel="stylesheet"
	href="<%=root %>/common/plugs/layer/skin/layer.css?rev=433a1dd8df8c4851be764e907f6d758a" />
<link rel="stylesheet"
	href="<%=root %>/common/plugs/bootstrap-table/dist/bootstrap-table.min.css">
<link rel="stylesheet"
	href="<%=root %>/common/plugs/bootstrap-datepicker/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="<%=root %>/common/main.css" />
<title>课程信息</title>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="ibox float-e-margins">
			<div class="ibox-content">
				<div class="page-header">
					<h3 class="text-center" id="flowTitle">我的选课信息查询</h3>
				</div>
				<form class="form-horizontal query-form" id="fee-form" method="post">
					<div class="form-group form-group-sm">
						<div class="input-tip">
							<label class="col-md-1 control-label">课程名称：</label>
							<div class="col-md-2 col-xs-2 col-sm-2">
	                    <input type="text" name="coursename" placeholder="请输入课程名称" class="form-control required" minlength="2" maxlength="40">
	                  </div>
						</div>
					</div>
					
					<div class="form-group">
						<div
							class="col-xs-24 col-sm-24 col-md-24 col-lg-24 text-center clearfix">
							<button type="button" class="btn btn-primary" id="btn-search"
								modal="enter">
								<span class="glyphicon glyphicon-search"></span><span>&nbsp;查询&nbsp;</span>
							</button>
							&nbsp;&nbsp;
							<button type="button" class="btn btn-white" modal="reset">
								<span class="glyphicon glyphicon-remove"></span><span>&nbsp;清除查询条件&nbsp;</span>
							</button>
							
						</div>
					
					</div>
				</form>
				</div>
			<P></P>
			<div class="ibox float-e-margins">
			 <input type="hidden" name="id" id="scoreId" />
				<div class="ibox-content">
					<table id="table_fee" data-toggle="table"
						data-pagination="false" data-ajax="dataLoad_1">
						<thead>
							<tr>
								<th data-field="classNo">课程编号</th>
								<th data-field="coursename">课程名称</th>
								<th data-field="teaname">教师</th>
								<th data-field="departname">院系</th>
								<th data-field="coursetime">上课时间</th>
								<th data-field="classAddress">上课地点</th>
								<th data-field="courseabout">课程简介</th>
								<th data-field="coursegrade">课程学分</th>
								<th data-field="classPeople">限选人数</th>
								<th data-field="currentPeople">当前人数</th>
								<th data-field="coursegrade">课程学分</th>
								<th data-switchable="true" data-formatter="handle_2"
									data-events="tableEvent_2">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			</div>
	</div>
	
	<!--确认操作模态框-->
	<div class="modal fade" id="sureModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">提示信息</h4>
				</div>
				<div class="modal-body">
					<p id="tipText"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="sureBtn">确定</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>







</body>
<script
	src="<%=root %>/common/plugs/layer/layer.js?rev=8962f047eeb03c06cf8200de1bf8ab99"></script>
<script src="<%=root %>/common/js/mock.js"></script>
<script
	src="<%=root %>/common/plugs/jquery-validation/dist/jquery.validate.min.js?rev=3b00d60f87e893caf2649eff0d48813a"></script>
<script
	src="<%=root %>/common/plugs/jquery-validation/dist/additional-methods.js?rev=6979ac84406e8c982e578736d368b3f8"></script>
<script
	src="<%=root %>/common/plugs/jquery-validation/dist/localization/messages_zh.js?rev=6979ac84406e8c982e578736d368b3f8"></script>
<script src="<%=root %>/common/js/LocalResizeIMG.js"></script>
<script src="<%=root %>/common/js/jquery.values.js?123123"></script>
<script
	src="<%=root %>/common/plugs/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
<script
	src="<%=root %>/common/plugs/bootstrap-datepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script
	src="<%=root %>/common/plugs/bootstrap-table/dist/bootstrap-table.min.js"></script>
<script
	src="<%=root %>/common/plugs/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="<%=root %>/common/URL.js"></script>

        <script src="<%=root %>/common/js/iframeCommon.js"></script>
        <script src="<%=root %>/common/js/student/myscore.js"></script>