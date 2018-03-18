$(function () {
comn.ajax({
        url: 'wyNLSc//sys/menu/sysList.do',
        success: function (res) {
        	var data=res.data,i,j,k; 
        	console.log(data);
            var menuList='',result="<ul class='menuList'>";
            	for(i=0;i<data.length;i++){   
            		menuList+="<li><p class='menu-li' style='cursor:pointer'><input name='menu' class='ff' type='checkbox' value='"+data[i].id+"'>"+data[i].permisname+"</p><dl style='display:none'>";
            		
            		
            			var o=data[i];
            			//menuList+="<dd><input name='menu' class='ff' type='checkbox' value='"+data[i].id+"'>"+data[i].permisname;
            			
            			for(k=0;k<o.sysMenuList.length;k++){
            				menuList+="<p><input name='menu' class='meun-p' type='checkbox' value='"+o.sysMenuList[k].id+"'>"+o.sysMenuList[k].permisname+"</p>";
            			}
            			//menuList+="</dd>";
            		//}
            		menuList+="</dl></li>"
            	}
            	result+=menuList+'</ul>';
            	$("#menu").html(result);
            	$(".menu-li").click(function(){
            		$(this).next("dl").toggle();
            	})
            	
            	$(".meun-p").click(function(){
            		$(this).parents("dd").find("input.ff").prop("checked","checked");
            	})
            }
    });
});



//新增区域费用方案
$("#addFee").click(function () {
	$("#roleId").val("");
	$("#addFeeModal").val("");
        $("#addFeeModal").modal("show");
        $("#feeFieldset").removeAttr("disabled");
        
});


//$("#RoleId").getRole();
	
//添加费用方案
$("#saveFee1").click(function(){
	$("#addFeeForm").validate();
	if($("#addFeeForm").valid() == true){
		var roleId = $("#roleId").val() || roleId;
		var data = $("#addFeeForm").values();
		var _url,_message;
		 if (!roleId) {
	            _url = "wyNLSc//sys/role/addPosition.do"; //新增
	            _message = "添加成功!";
	        } else {
	            _url = "wyNLSc//sys/role/changeName.do";  //修改
	            _message = "修改成功!";
	        }
		comn.ajax({
			url:_url,
			data: $.extend(data,{roleId: roleId || $("#roleId").val()
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


//menus-wrapper
$('#Dialog_set_auth').on('click', '.save', function () {
    var roleId =  $('#Dialog_set_auth #role_name').attr('roleid');
    if(roleId == undefined){
        alert('no roleid found!');
        return;
    }
    var menus = [];
    $('#Dialog_set_auth .menus-wrapper input[type="checkbox"]:checked').each(function () {
        menus.push($(this).val());
    });
    

    if (menus.length == 0) {
        //alert('菜单权限和节点权限都要至少选一个');
    	tip({content: "菜单权限至少选一个!"});
    }
    comn.ajax({
        url: 'wyNLSc//sys/role/setauth.do',
        data: {
            roleId:roleId,
            menuStr: menus.join(','),
        },
        success: function (resp) {
            console.log(resp);
            if (resp && resp.code == 10000) {
                //alert('设置成功！');
                $('#Dialog_set_auth').modal('hide');
                $('#btn-search').trigger('click');  
                tip({content: "设置成功!"});

            } else {
                alert('系统繁忙，请重试。');
            }
        }
    });
});




function getRoleInfo(roleId){
	comn.ajax({
		url: "wyNLSc//sys/role/roleInfo.do",
		data:{
			roleId:roleId
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
	tableData(params,$.extend($("#fee-form").values(),p),"wyNLSc//sys/role/list.do");
};
$("#btn-search").click(function(){
	$("#table_fee").bootstrapTable('refresh', {url: '...'}); 
});





//获取参数
var args;

args = comn.getArgs();
var type = args['type'];
handle_2 = function (value, row, index) {
    var btnStatus = "<li><a class='setauth'>权限</a></li>"
    var modify = "", del = "";
    
        modify = "<li><a class='modify'>修改</a></li>";
        del = "<li><a class='del'>删除</a></li>";
   
    /*var see = "<li><a class='see'>查看</a></li>";*/

    return ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>操作", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>", modify, btnStatus, del,"</ul>", "</div>"].join("");
};



tableEvent_2 ={
"click .modify":function(e,a,item,index){
	$("#addFeeModal").modal("show");
	$("#feeBoxPanel").html("修改角色信息");
	 window.location.href = "#addFeeModal";
	 getRoleInfo(item['id']);
	 $("#feeFieldset").removeAttr("disabled");
},
"click .del": function (e, a, item, index) {
    $("#sureModal").modal("show");
    $("#sureModal").find("#tipText").text("确认删除吗?");
    $("#sureBtn").unbind("click").click(function () {
        return comn.ajax({
            url: "wyNLSc//sys/role/deletePosition.do",
            data: {
                roleId: item['id']
            },
            success: function (res) {
                $("#sureModal").modal("hide");
                tip({content: res.message || "删除成功!"});
                return $("#table_fee").bootstrapTable('refresh', {url: "..."});
            }
        });
    })
},
"click .setauth": function (a, val, item, d) {
   
    console.log(item);
    $("input[name='menu']").removeAttr("checked");

    var menuIds=[];
    if(item['menuIds']!=null&&item['menuIds']!=''){
        menuIds = item['menuIds'].split(',');
    }

    for(var i=0;i<menuIds.length;i++){
        $("input[name='menu'][value='"+menuIds[i]+"']").attr("checked","checked");
    }

    $('#Dialog_set_auth').modal('show');
    $('#Dialog_set_auth #role_name').html(item.rolename).attr('roleid', item.id);
},


};
