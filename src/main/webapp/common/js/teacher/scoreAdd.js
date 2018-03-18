

var dataLoad_1;
dataLoad_1 = function(params){
	var p;
	p=params.data;
	/*console.log(interUrl.common.list);*/
	tableData(params,$.extend($("#fee-form").values(),p),"wyNLSc//info/score/list.do");
};
$("#btn-search").click(function(){
	$("#table_fee").bootstrapTable('refresh', {url: '...'}); 
});
function getScoreInfo(scoreId){
	comn.ajax({
		url: "wyNLSc//info/score/Score.do",
		data:{
			scoreId:scoreId
		},
		success: function(res){
			console.log(res.data);
			$("#addFeeForm").values(res.data);
		}
	});
};
//获取参数
var args;

args = comn.getArgs();
var type = args['type'];
handle_2 = function (value, row, index) {
    var modify = "", del = "";
    
        modify = "<li><a class='modify'>加分</a></li>";
    return ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>操作", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>", modify,"</ul>", "</div>"].join("");
};

$("#saveFee1").click(function(){
	$("#addFeeForm").validate();
	if($("#addFeeForm").valid() == true){
		var scoreId = $("#scoreId").val() || scoreId;
		var data = $("#addFeeForm").values();
		var _url,_message;
		
	            _url = "wyNLSc//info/score/Update.do";  //修改
	            _message = "操作成功!";
	        
		comn.ajax({
			url:_url,
			data: $.extend(data,{scoreId: scoreId || $("#scoreId").val()
		}),
		success: function (res){
			
			tip({content: res.message || _message});
			$("#addFeeModal").modal("hide");
			$("#table_fee").bootstrapTable("refresh", {url: "..."});
		}
		
		});
	}
});
tableEvent_2 ={
"click .modify":function(e,a,item,index){
	$("#addFeeModal").modal("show");
	 window.location.href = "#addFeeModal";
	 console.log(item);
	 getScoreInfo(item['id']);
	 $("#feeFieldset").removeAttr("disabled");
}




};
