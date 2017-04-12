
function login() {
	var login = document.getElementById("yq_login")
	login.style.display = "inline"
}

function register() {
	var register = document.getElementById("yq_register")
	register.style.display = "inline"
}

function back(){
	window.location.reload();
}

window.onload=function() {
	window.setInterval("realSysTime()" , 1000);
}

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function realSysTime() {
	var now = new Date();
	var day = now.getDay();
	var arr_week = new Array("星期日", "星期一","星期二" ,"星期三" ,"星期四" ,"星期五" ,"星期六");
	var week = arr_week[day];

	var time1 = now.Format("hh : mm : ss");
	var time2 = now.Format("yyyy年MM月dd日")+week;

	var clock1 = document.getElementById("yq_time1");
	clock1.innerHTML =  time1;
	var clock2 = document.getElementById("yq_time2");
	clock2.innerHTML =  time2;
}

function register_check() {
	var login = document.getElementById('yq_register');
	var name = yq_register_form.username.value;
	var pw = yq_register_form.password.value;
	var pw2 = yq_register_form.password2.value;
	var e_mail = yq_register_form.Email.value;
	var sex = yq_register_form.sex.value;

	var reg_pw = new RegExp("^[A-Za-z0-9]+$")
	var reg_email = new RegExp("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+")
	
	if (name=="") {
    	alert("用户名不能为空");
    	yq_register_form.username.focus();
    	yq_register_form.username.select();
    	return false;
	}else if(pw==""){
		alert("密码不能为空");
		yq_register_form.password.focus();
		yq_register_form.password.select();
		return false;
	}else if(pw.length<6){
		alert("密码长度少于6位");
		yq_register_form.password.focus();
		yq_register_form.password.select();
		return false;
	}else if(!reg_pw.test(pw)){
		alert("密码错误字符");
		yq_register_form.password.value="";
		yq_register_form.password.focus();
		yq_register_form.password.select();
		return false;
	}else if(pw2==""){
		alert("请重复密码");
		yq_register_form.password2.focus();
		yq_register_form.password2.select();
		return false;
	}else if(pw!=pw2){
		alert("密码不一致");
		yq_register_form.password2.value="";
		yq_register_form.password2.focus();
		yq_register_form.password2.select();
		return false;
	}else if (!reg_email.test(e_mail)) {
		alert("邮箱格式不对");
		yq_register_form.Email.focus();
		yq_register_form.Email.select();
		return false;
	}


	login.style.display = "none";

    return true;
}

function check() {
	var login = document.getElementById('yq_login');
	var name = yq_form.username.value
	var pw = yq_form.password.value
	var pw2 = yq_form.password2.value
	var e_mail = yq_form.email.value
	var sex = yq_form.sex.value

	var reg_pw = new RegExp("^[A-Za-z0-9]+$")
	var reg_email = new RegExp("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+")
	
	if (name=="") {
    	alert("用户名不能为空");
    	yq_form.username.focus();
    	yq_form.username.select();
    	return false;
	}else if(pw==""){
		alert("密码不能为空");
		yq_form.password.focus();
		yq_form.password.select();
		return false;
	}else if(pw.length<6){
		alert("密码长度少于6位");
		yq_form.password.focus();
		yq_form.password.select();
		return false;
	}else if(!reg_pw.test(pw)){
		alert("密码错误字符");
		yq_form.password.focus();
		yq_form.password.select();
		return false;
	}else if(pw!=pw2){
		alert("密码不一致");
		yq_form.password2.focus();
		yq_form.password2.select();
		return false;
	}else if (!reg_email.test(e_mail)) {
		alert("邮箱格式不对");
		yq_form.Email.focus();
		yq_form.Email.select();
		return false;
	}


	login.style.display = "none";

	alert("登录成功");
    return true;
}