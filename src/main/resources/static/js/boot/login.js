$(function(){
	$("#login_btm").click(function(){
		var login_data={"userName":$("[name=userName]").val(),"password":$("[name=password]").val()};
		var url=getRootPath+"/login"
	})
})