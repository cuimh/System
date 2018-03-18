//新增区域费用方案
$("#addFee").click(function () {
	$("#courseId").val("");
	$("#addFeeModal").val("");
        $("#addFeeModal").modal("show");
        $("#feeFieldset").removeAttr("disabled");
        
});

var dataLoad_1;
dataLoad_1 = function(params){
	var p;
	p=params.data;
	/*console.log(interUrl.common.list);*/
	tableData(params,$.extend($("#fee-form").values(),p),"wyNLSc//info/course/list.do");
};
$("#btn-search").click(function(){
	$("#table_fee").bootstrapTable('refresh', {url: '...'}); 
});

//获取参数
var args;

args = comn.getArgs();
var type = args['type'];
handle_2 = function (value, row, index) {
    var modify = "", del = "";
    
        modify = "<li><a class='modify'>选修</a></li>";
       /* del = "<li><a class='del'>退选</a></li>";*/
   
    /*var see = "<li><a class='see'>查看</a></li>";*/

    return ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>操作", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>", modify,"</ul>", "</div>"].join("");
};

tableEvent_2 ={
"click .modify":function(e,a,item,index){
	//$("#addFeeModal").modal("show");
	console.log(item)
	 window.location.href = "#addFeeModal";
	 $("#sureModal").modal("show");
	    $("#sureModal").find("#tipText").text("确认选吗?");
	    $("#sureBtn").unbind("click").click(function (){
	        return comn.ajax({
	            url: "wyNLSc//info/score/add.do",
	            data: {
	            	courseid: item['courseid']
	            },
	            success: function (res) {
	                $("#sureModal").modal("hide");
	                tip({content: res.message || "选择成功!"});
	                return $("#table_fee").bootstrapTable('refresh', {url: "..."});
	            }
	        });
	    })
	 $("#feeFieldset").removeAttr("disabled");
},
"click .del": function (e, a, item, index) {
    $("#sureModal").modal("show");
    $("#sureModal").find("#tipText").text("确认退选吗?");
    $("#sureBtn").unbind("click").click(function (){
        return comn.ajax({
            url: "wyNLSc//info/course/deletescore.do",
            data: {
                courseId: item['courseid']
            },
            success: function (res) {
                $("#sureModal").modal("hide");
                tip({content: res.message || "删除成功!"});
                return $("#table_fee").bootstrapTable('refresh', {url: "..."});
            }
        });
    })
},




};
