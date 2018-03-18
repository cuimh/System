var cardType, comn, initEvent, interUrl, managementType, queryParams, relationship, customerType,resultStatus, tip;
comn = {};

tip = null;

(function() {
  tip = function(o) {
    var base;
    return typeof (base = window.parent.comn).tip === "function" ? base.tip(o) : void 0;
  };
  return comn = {
		    user: window.parent.user,
		    cache: window.parent.cache,
		    table: {
		      "undefinedText": "--",
		      "classes": "table-striped table-hover table",
		      "pagination": true,
		      "sidePagination": "server",
		      "queryParams": "queryParams",
		      "paginationFirstText": "第一页",
		      "paginationPreText": "上一页",
		      "paginationNextText": "下一页",
		      "paginationLastText": "最后一页",
		      "clickToSelect": true,
		      "height": "500"
		    },
		    toUrl: function(o) {
		      var base;
		      if (o.url.indexOf(".html") > -1) {
		        return typeof (base = window.parent).toUrl === "function" ? base.toUrl(o.url) : void 0;
		      }
		    },
		    addTab: function(o) {
		      if (o.href) {
		        return window.parent.menuItemClick.call(o);
		      }
		    },
        closeTab: function(){
          window.parent.closeTab();
        },
		    ajax: function(o) {
		      var _this, mask;
		      mask = layer.load();
		      _this = this;
		      if (o.url) {
		        return $.ajax({
		          url: interUrl.basic + o.url,
		          type: o.type || "POST",
		          dataType: "json",
		          async: o.async || true,
		          data: o.data || {},
		          complete: function(jqXHR, textStatus) {
		            return layer.close(mask);
		          },
		          success: function(data) {
		            if (data.code === 20000) {
		              return tip({
		                content: data.message || "<code>" + o.url + "</code><br /> 接口异常！！！"
		              });
		            } else if (data.code === 30000) {
		              return window.parent.location.href = "../../../index.html";
		            } else {
		              if (typeof data === "string") {
		                data = JSON.parse(data);
		              }
		              return typeof o.success === "function" ? o.success(data) : void 0;
		            }
		          },
		          error: function(jqXHR, textStatus, errorThrown) {
		            return typeof o.error === "function" ? o.error(textStatus) : void 0;
		          }
		        });
		      }
		    },
		    getArgs: function() {
		      var args, i, item, items, name, qs, value;
		      qs = (location.search.length > 0 ? location.search.substring(1) : "");
		      items = (qs.length ? qs.split("&") : []);
		      args = {};
		      i = 0;
		      while (i < items.length) {
		        item = items[i].split("=");
		        name = decodeURIComponent(item[0]);
		        value = decodeURIComponent(item[1]);
		        if (name.length) {
		          args[name] = value;
		        }
		        i++;
		      }
		      return args;
		    }
		  };
  
})();

initEvent = function() {
  return $("body").on("click", ".btn[modal='reset']", function() {
    var ref;
    return (ref = $(this).parents("form")[0]) != null ? ref.reset() : void 0;
  });
};

$.fn.nameValues = function() {
  var arg;
  arg = arguments[0];
  return $(this).find("[data-name]").each(function(index, item) {
    var key, keySwitch, value;
    key = $(this).data("name");
    keySwitch = $(this).data("formatter");
    if (keySwitch) {
      value = window[keySwitch](arg[key]) || "";
    }
    if (key) {
      return $(item).html(value || arg[key] || "");
    }
  });
};
$.fn.dataValues1 = function() {
	  var arg;
	  arg = arguments[0];
	  return $(this).find("[data-name]").each(function(index, item) {
	    var key, keySwitch, value;
	    key = $(this).data("name");
	    keySwitch = $(this).data("formatter");
	    if (keySwitch) {
	      value = window[keySwitch](arg[key]) || "";
	    }
	    if (key) {
	      return $(item).val(value || arg[key] || "");
	    }
	  });
	};

$.fn.getRole = function() {
	comn.ajax({
		 url: "wyNLSc//sys/role/list.do",
	    success: (function(_this) {
	      return function(res) {
	        var j, len, o, ref, str;
	        str = "";
	        var defaultValue = $(_this).attr('defaultValue');
	        ref = res.data;
	        for (j = 0, len = ref.length; j < len; j++) {
	          o = ref[j];
	          str += "<option value='" + o.id + "' "+(defaultValue==o.id?"selected":"")+">" + o.rolename + "</option>";
	        }
	        return $(_this).append(str);
	      };
	    })(this)
	  });
	  return this;
},


$.fn.getMajor = function(departid, value) {
    if (departid) {
    	
      comn.ajax({
        url: "wyNLSc//info/major/MajorList.do",
        data: {
        	departid: departid
        },
        success: (function(_this) {
  	      return function(res) {
  	        var j, len, o, ref, str;
  	        str = "<option value=''>请选择</option>";
  	        var defaultValue = $(_this).attr('defaultValue');
  	        ref = res.data;
  	      $("#majorId").find("option").each(function(){
  	    	$(this).remove();
  	    	});
  	        for (j = 0, len = ref.length; j < len; j++) {
  	          o = ref[j];
  	          str += "<option value='" + o.id + "' "+(defaultValue==o.id?"selected":"")+">" + o.majorname + "</option>";
  	        }
  	        return $(_this).append(str);
  	      };
  	    })(this)
  	  });
  	  return this;
  }},

  $.fn.getTea = function(departid, value) {
	    if (departid) {
	      comn.ajax({
	        url: "wyNLSc//info/tea/TeaList.do",
	        data: {
	        	departId: departid
	        },
	        success: (function(_this) {
	  	      return function(res) {
	  	        var j, len, o, ref, str;
	  	      str = "<option value=''>请选择</option>";
	  	        var defaultValue = $(_this).attr('defaultValue');
	  	        ref = res.data;
	  	      $("#teaId").find("option").each(function(){
	    	    	$(this).remove();
	    	    	});
	  	        for (j = 0, len = ref.length; j < len; j++) {
	  	          o = ref[j];
	  	          str += "<option value='" + o.id + "' "+(defaultValue==o.id?"selected":"")+">" + o.tername + "</option>";
	  	        }
	  	        return $(_this).append(str);
	  	      };
	  	    })(this)
	  	  });
	  	  return this;
	  }},


$.fn.getDepart = function() {
	comn.ajax({
		 url: "wyNLSc//info/depart/DepartList.do",
	    success: (function(_this) {
	      return function(res) {
	        var j, len, o, ref, str;
	        str = "";
	        var defaultValue = $(_this).attr('defaultValue');
	        ref = res.data;
	        for (j = 0, len = ref.length; j < len; j++) {
	          o = ref[j];
	          str += "<option value='" + o.departid + "' "+(defaultValue==o.departid?"selected":"")+">" + o.departname + "</option>";
	        }
	        return $(_this).append(str);
	      };
	    })(this)
	  });
	  return this;
},
$.fn.getAddres = function() {
	comn.ajax({
		 url: "wyNLSc//info/classRoom/roomList.do",
	    success: (function(_this) {
	      return function(res) {
	        var j, len, o, ref, str;
	        str = "";
	        var defaultValue = $(_this).attr('defaultValue');
	        ref = res.data;
	        for (j = 0, len = ref.length; j < len; j++) {
	          o = ref[j];
	          str += "<option value='" + o.id + "' "+(defaultValue==o.id?"selected":"")+">" + o.classNo + "</option>";
	        }
	        return $(_this).append(str);
	      };
	    })(this)
	  });
	  return this;
},

/*$.fn.getRuleList = function() {
  comn.ajax({
    url: interUrl.common.ruleList,
    data: {},
    success: (function(_this) {
      return function(res) {
        var j, len, o, ref, str;
        o = res.data;
        str = "<option value=''>--请选择--</option>";
        ref = res.data;
        for (j = 0, len = ref.length; j < len; j++) {
          o = ref[j];
          str += "<option value='" + o.id + "'>" + o.name + "</option>";
        }
        return $(_this).html(str);
      };
    })(this)
  });
  return this;
};*/

/*interUrl = {
  mockList: "",
  basic: "/",
  common: {
    login: "login",
    orgsList: "organization/brachCompany"
  },
 
 
  gpsManage:{
	  	saveInstallStrategy:"gpsManage/installStrategy/save",
	  	getInstallStrategyList:"gpsManage/installStrategy/list",
	  	getInstallStrategy:"gpsManage/installStrategy/get",
	  	deleteInstallStrategy:"gpsManage/installStrategy/delete",
	  	copyInstallStrategy:"gpsManage/installStrategy/copy"
}
};*/

$(function() {
  $("body").on("click", "a", function(e) {
    var ref;
    if (((ref = $(this).href) != null ? ref.index(".html") : void 0) > -1) {
      e.preventDefault();
      return comn.toUrl({
        "url": $(this).href
      });
    }
  });
  
  try{
	  
	  $(".date").datetimepicker({
	        format: "yyyy-mm-dd",
	        pickerPosition: "bottom-right",
	        language: "zh-CN",
	        minView: 2,
	        todayHighlight: true,
	        autoclose: true,
	        todayBtn: true,
	        show: true
	      });
  }catch(e){};
  initEvent();
  $(".modal").on("show.bs.modal", function() {
    if ($(this).find("form").length) {
      return $(this).find("form")[0].reset();
    }
  });
  return $("#btn-search").click(function() {
    return $("#table").bootstrapTable('refresh', {url: '...'});
  });
});



$.validator.setDefaults({
  highlight: function(e) {
    return $(e).closest(".input-tip").removeClass("has-success").addClass("has-error");
  },
  success: function(e, r) {
    return $(r).closest(".input-tip").removeClass("has-error").addClass("has-success");
  },
  errorPlacement: function(e, r) {
    if (e.text()) {
      return layer.tips(e.text(), r, {
        tips: [1, "#000"]
      });
    }
  }
});

queryParams = function(params) {
  return {
    search: params.search,
    page: (params.limit + params.offset) / params.limit,
    pageSize: params.limit
  };
};

resultStatus = function(value, row, index) {
  return (value === 1 && "未处理") || (value === 2 && "关闭") || (value === 3 && "退回") || (value === 4 && "发起征信") || "";
};


jQuery.validator.addMethod("telephone", function(value,element){  
	  return this.optional(element) || /^[[\d]{3,4}-]?[\d]{7,8}$/.test(value);  
});
jQuery.validator.addMethod("mobile", function(value, element) {
	    return this.optional(element) || /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value);
});
jQuery.validator.addMethod("phoneMix", function(value, element) {
	    return this.optional(element) || /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value) || /^[[\d]{3,4}-]?[\d]{7,8}$/.test(value);
});
tableData = function(params, data, url, callback) {
  var p;
  p = params.data;
  if (url) {
    return comn.ajax({
      url: url,
      data: $.extend(data, p),
      success: function(res) {
        params.success({
          'total': res.totalItem,
          'rows': res.data
        });
        params.complete();
        return typeof callback === "function" ? callback(res) : void 0;
      }
    });
  }
};
