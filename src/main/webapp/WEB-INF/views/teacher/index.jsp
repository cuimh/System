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
<title>教师信息</title>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="ibox float-e-margins">
			<div class="ibox-content">
				<div class="page-header">
					<h3 class="text-center" id="flowTitle">教师查询</h3>
				</div>
				<form class="form-horizontal query-form" id="fee-form" method="post">
					<div class="form-group form-group-sm">
						<div class="input-tip">
							<label class="col-md-1 control-label">教师编号：</label>
							<div class="col-md-2 col-xs-2 col-sm-2">
	                    <input type="text" name="teaNo" placeholder="请输入教师编号" class="form-control required" minlength="2" maxlength="40">
	                  </div>
						
					
						
							<label class="col-md-1 control-label">教师名称：</label>
							<div class="col-md-2 col-xs-2 col-sm-2">
	                    <input type="text" name="tername" placeholder="请输入教师名称" class="form-control required" minlength="2" maxlength="40">
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
							<button type="button" class="btn btn-primary pull-right"
								id="addFee" modal="enter">
								<span class="glyphicon btn-primary"></span><span>&nbsp;新增教师信息&nbsp;</span>
							</button>
						</div>
					
					</div>
				</form>
				</div>
			<P></P>
			<div class="ibox float-e-margins">
			 <input type="hidden" name="id" id="id" />
				<div class="ibox-content">
					<table id="table_fee" data-toggle="table"
						data-pagination="false" data-ajax="dataLoad_1">
						<thead>
							<tr>
								
								<th data-field="teaNo">教师编号</th>
								<th data-field="tername">教师姓名</th>
								<th data-field="sex" data-formatter="statusa">性别</th>
								<th data-field="departname">所属院系</th>
								<th data-field="note">简介</th>
								<th data-switchable="true" data-formatter="handle_2"
									data-events="tableEvent_2">操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
			</div>
	</div>
	<!--添加费用方案 -->
            <div id="addFeeModal" tabindex="-1" role="dialog" aria-hidden="true" class="modal fade">
                <div class="modal-dialog modal-lg" style = "width:1200px;">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button data-dismiss="modal" aria-hidden="true" type="button" class="close">&times;</button>
                            <h4 class="modal-title" id="feeBoxPanel">新增教师信息</h4>
                            
                        </div>
	<form id="addFeeForm" class="form-horizontal" method="post">
	 	<fieldset id="feeFieldset">
	
        <input type="hidden" name="id" id="teaId" />
		<div class="modal-body">
			<div class="form-group form-group-sm">
				<div class="input-tip">
					<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label"><span class="text-danger">*&nbsp;</span>教师编号：</label>
					<div class="col-xs-3  col-sm-3 col-md-3 col-lg-3">
						<input type="text" name="teaNo" placeholder="请输入教师编号"
							class="form-control required">
					</div>
				</div>
				</div>
				<div class="form-group form-group-sm">
				<div class="input-tip">
					<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label"><span class="text-danger">*&nbsp;</span>名称：</label>
					<div class="col-xs-3  col-sm-3 col-md-3 col-lg-3">
						<input type="text" name="tername" placeholder="请输入名称"
							class="form-control required">
					</div>
				</div>
				
				</div>
			<div class="form-group form-group-sm">
				<div class="input-tip">
                            <label class="control-label col-md-2 col-xs-2 col-sm-2"><span class="text-danger">*&nbsp;</span>性别：</label>
                            <div class="col-md-2 col-xs-2 xol-sm-2">
                                <input type="hidden" name="sex" value=""/>
                                <select name="sex" class="form-control role-list required" id="sexId">
                                    <option value="">请选择</option>
                                    <option value="1">男</option>
                                    <option value="2">女</option>
                                </select>
                            </div>
                        </div>
			</div>
			<div class="form-group form-group-sm">
				<div class="input-tip">
                            <label class="control-label col-md-2 col-xs-2 col-sm-2"><span class="text-danger">*&nbsp;</span>院系：</label>
                            <div class="col-md-2 col-xs-2 xol-sm-2">
                                <input type="hidden" name="departname" value=""/>
                                <select name="departid" class="form-control role-list required" id="departId">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </div>
			</div>
			<div class="form-group form-group-sm">
				
				<div class="input-tip">
					<label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">简介：</label>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
					<div class="input-group">
                                <textarea name="note" cols="40" rows="10" class="form-control" maxlength="50">暂无描述</textarea>
					</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="saveFee1" type="button" class="btn btn-info">保存</button>
				<button data-dismiss="modal" type="button" class="btn btn-default">关闭</button>
			</div>
		</div>
		</fieldset>
	</form>
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
        <script src="<%=root %>/common/js/teacher/index.js"></script>