
var dataLoad_1;
dataLoad_1 = function(params){
	var p;
	p=params.data;
	/*console.log(interUrl.common.list);*/
	tableData(params,$.extend($("#fee-form").values(),p),"wyNLSc//info/score/listMyScore.do");
};
$("#btn-search").click(function(){
	$("#table_fee").bootstrapTable('refresh', {url: '...'}); 
});

//获取参数
var args;

args = comn.getArgs();
var type = args['type'];
handle_2 = function (value, row, index) {
    var del = (row["flag"] == "1") ? "" : "<li><a class='del'>退选</a></li>";


    return ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>操作", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>", del,"</ul>", "</div>"].join("");
};

tableEvent_2 ={

"click .del": function (e, a, item, index) {
    $("#sureModal").modal("show");
    $("#sureModal").find("#tipText").text("确认退选吗?");
    $("#sureBtn").unbind("click").click(function (){
        return comn.ajax({
            url: "wyNLSc//info/score/deletescore.do",
            data: {
                scoreId: item['id']
            },
            success: function (res) {
                $("#sureModal").modal("hide");
                tip({content: res.message || "退选成功!"});
                return $("#table_fee").bootstrapTable('refresh', {url: "..."});
            }
        });
    })
},




};
