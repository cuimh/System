//新增区域费用方案
$("#addFee").click(function () {
	$("#feeBoxPanel").html("新增教室信息");
	$("#roomId").val("");
	$("#addFeeModal").val("");
        $("#addFeeModal").modal("show");
        $("#feeFieldset").removeAttr("disabled");
        
});

function getUserInfo(roomId){
	comn.ajax({
		url: "wyNLSc//info/classRoom/roomInfo.do",
		data:{
			roomId:roomId
		},
		success: function(res){
			console.log(res.data);
			$("#addFeeForm").values(res.data);
		}
	});
};

	
//添加费用方案
$("#saveFee1").click(function(){
	$("#addFeeForm").validate();
	if($("#addFeeForm").valid() == true){
		var roomId = $("#roomId").val() || roomId;
		var data = $("#addFeeForm").values();
		var _url,_message;
		 if (!roomId) {
	            _url = "wyNLSc//info/classRoom/add.do"; //新增
	            _message = "添加成功!";
	        } else {
	            _url = "wyNLSc//info/classRoom/Update.do";  //修改
	            _message = "修改成功!";
	        }
		comn.ajax({
			url:_url,
			data: $.extend(data,{roomId: roomId || $("#roomId").val()
		}),
		success: function (res){
			
			tip({content: res.message || _message});
			$("#addFeeModal").modal("hide");
			$("#table_fee").bootstrapTable("refresh", {url: "..."});
		}
		
		});
	}
});

var dataLoad_1;
dataLoad_1 = function(params){
	var p;
	p=params.data;
	/*console.log(interUrl.common.list);*/
	tableData(params,$.extend($("#fee-form").values(),p),"wyNLSc//info/classRoom/list.do");
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
    
        modify = "<li><a class='modify'>修改</a></li>";
        del = "<li><a class='del'>删除</a></li>";
   
    /*var see = "<li><a class='see'>查看</a></li>";*/

    return ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>操作", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>", modify,del,"</ul>", "</div>"].join("");
};



tableEvent_2 ={
"click .modify":function(e,a,item,index){
	$("#addFeeModal").modal("show");
	$("#feeBoxPanel").html("修改教室信息");
	 window.location.href = "#addFeeModal";
	 getUserInfo(item['id']);
	 $("#feeFieldset").removeAttr("disabled");
},
"click .del": function (e, a, item, index) {
    $("#sureModal").modal("show");
    $("#sureModal").find("#tipText").text("确认删除吗?");
    $("#sureBtn").unbind("click").click(function () {
        return comn.ajax({
            url: "wyNLSc//info/classRoom/deleteroom.do",
            data: {
                roomId: item['id']
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
