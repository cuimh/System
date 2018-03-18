var swp, user;

swp = null;

user = null;

$(function(){
	//菜单点击
    J_iframe
    $(".J_menuItem").on('click',function(){
        var url = $(this).attr('href');
        $("#J_iframe").attr('src',url);
        return false;
    });
 /* $.ajax({
    url: "/user/session/get",
    type: "POST",
    dataType: "json",
    success: function(data, textStatus, jqXHR) {
      if (typeof data === "string") {
        data = JSON.parse(data);
      }
      if (data.code === 30000) {
        return location.href = "/page/index.html";
      } else {
        user = data.data;
        $("#uid").val(data.data.uid);
        return $("#userName").text(data.data.relname);
      }
    }
  });*/
  $(".J_tabExit").click(function() {
    return $("#logOut").modal("show");
  });
  $(".J_tabUpdPwd").click(function() {
	    return $("#updPosswordDiv").modal("show");
  });
  $("#exitSure").click(function() {
	return location.href = "/wyNLSc/loginOut.do";
  });
  $("#updPwd").click(function() {
	  var oriPassword=$('#oriPassword').val();//原密码
	  var password=$('#password').val();//新密码
	  var confirmPassword=$('#confirmPassword').val();//确认新密码
	  password=password.replace(/\s/gi,'');
	  confirmPassword=confirmPassword.replace(/\s/gi,'');
	  if(oriPassword.length<1 || confirmPassword.length<1){
		  toastr.error('原始密码、新密码都是必填项');
		  return;
	  }
	  
	  if(password.length<6 || password.length>15){
		  toastr.error('请输入6-15位密码');
		  return;
	  }
	  
	  var ret = /^[\w\d\_\-\.]*$/;
	  if(!ret.test(password)){
		  toastr.error("密码格式错误，请输入字母、数字、下划线、点、横杠");
	    return;
	  }
		
	  if(password!=confirmPassword){
		  toastr.error('两次密码输入不一致');
		  return;
	  }
	  
	  $.ajax({
		    url: "/wyNLSc/updatePwd.do",
		    
		    data: {
					oldPassword:oriPassword,
					newPassword:password
				},
		  
		    type: "POST",
		    dataType: "json",
		    success: function(data, textStatus, jqXHR) {
		      if (typeof data === "string") {
		    	  data = JSON.parse(data);
		      }
		      if (data.code === 10000) {
		    	  toastr.success('密码修改成功');
		    	  $("#updPosswordDiv").modal("hide");
		      }
		      if (data.code === 101) {
		    	  toastr.error('原密码输入错误');
		      }
		    }
	  });
  });
  $("#imageSwitch").on("shown.bs.modal", function() {
    swp = new Swiper('.swiper-container', {
      slidesPerView: 5,
      slidesPerGroup: 5,
      grabCursor: true,
      nextButton: '.swiper-button-next',
      prevButton: '.swiper-button-prev',
      updateOnImagesReady: true,
      keyboardControl: true,
      lazyLoading: true
    });
    return swp.slideTo(18, 1000);
  });
  return $(".swiper-wrapper").on("click", ".swiper-slide", function() {
    var _index;
    _index = $(this).index();
    return $("#imgBig")[0].src = $(this).children("img")[0].src;
  });
});


