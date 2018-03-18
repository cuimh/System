//新增区域费用方案
$("#addFee").click(function () {
	$("#feeBoxPanel").html("新增用户信息");
	$("#userId").val("");
	$("#addFeeModal").val("");
        $("#addFeeModal").modal("show");
        $("#feeFieldset").removeAttr("disabled");
        
});


$("#RoleId").getRole();
	
//添加费用方案
$("#saveFee1").click(function(){
	$("#addFeeForm").validate();
	if($("#addFeeForm").valid() == true){
		var userId = $("#userId").val() || userId;
		var data = $("#addFeeForm").values();
		var _url,_message;
		 if (!userId) {
	            _url = "wyNLSc//sys/user/add.do"; //新增
	            _message = "添加成功!";
	        } else {
	            _url = "wyNLSc//sys/user/Update.do";  //修改
	            _message = "修改成功!";
	        }
		comn.ajax({
			url:_url,
			data: $.extend(data,{userId: userId || $("#userId").val()
		}),
		success: function (res){
			alert(1);
			tip({content: res.message || _message});
			$("#addFeeModal").modal("hide");
			$("#table_fee").bootstrapTable("refresh", {url: "..."});
		}
		
		});
	}
});
function getUserInfo(userId){
	comn.ajax({
		url: "wyNLSc//sys/user/userInfo.do",
		data:{
			userId:userId
		},
		success: function(res){
			console.log(res.data);
			$("#addFeeForm").values(res.data);
		}
	});
};
var dataLoad_1;
dataLoad_1 = function(params){
	var p;
	p=params.data;
	/*console.log(interUrl.common.list);*/
	tableData(params,$.extend($("#fee-form").values(),p),"wyNLSc//sys/user/list.do");
};
$("#btn-search").click(function(){
	$("#table_fee").bootstrapTable('refresh', {url: '...'}); 
});

statusa = function (value, row, index) {
    if (typeof value === "string") {
        value = parseInt(value);
    }
    return (value === 0 && "已停用") || (value === 1 && "已启用") || null;

};



//获取参数
var args;

args = comn.getArgs();
var type = args['type'];
handle_2 = function (value, row, index) {
    var btnStatus = (row["flag"] == "1") ? "<li><a class='stop'>停用</a></li>" : "<li><a class='stop'>启用</a></li>";
    var modify = "", del = "";
    
        modify = "<li><a class='modify'>修改</a></li>";
        del = "<li><a class='del'>删除</a></li>";
   
    /*var see = "<li><a class='see'>查看</a></li>";*/

    return ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>操作", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>", modify, btnStatus, del,"</ul>", "</div>"].join("");
};



tableEvent_2 ={
"click .modify":function(e,a,item,index){
	$("#addFeeModal").modal("show");
	$("#feeBoxPanel").html("修改用户信息");
	 window.location.href = "#addFeeModal";
	 getUserInfo(item['id']);
	 $("#feeFieldset").removeAttr("disabled");
},
"click .del": function (e, a, item, index) {
    $("#sureModal").modal("show");
    $("#sureModal").find("#tipText").text("确认删除吗?");
    $("#sureBtn").unbind("click").click(function () {
        return comn.ajax({
            url: "wyNLSc//sys/user/deleteStaff.do",
            data: {
                userId: item['id']
            },
            success: function (res) {
                $("#sureModal").modal("hide");
                tip({content: res.message || "删除成功!"});
                return $("#table_fee").bootstrapTable('refresh', {url: "..."});
            }
        });
    })
},

"click .stop":function(e, a, item, index) {
    comn.ajax({
        url: "wyNLSc//sys/user/changeFlag.do",
        data: {
        	 id: item['id'],
            flag: (item['flag'] == 0 ? 1 : 0),
        },
        success: function (res) {
        	console.log(res.data)
            $("#sureModal").modal("hide");
            tip({content: (item['flag'] == 0 ? "启用" : "停用") + "成功!"});
            return $("#table_fee").bootstrapTable('refresh', {url: "..."});
        }
    });
},
/*"click .see": function (e, a, item, index) {
	$("#addFeeModal").modal("show");
	$("#feeBoxPanel").html("查看费用信息");
	 window.location.href = "#addFeeModal";
	 getFeeInfo(item['feeId']);
    //查看禁用表单
   $("#feeFieldset").attr("disabled", "disabled");
}*/
};
