//禁用右键菜单
//document.oncontextmenu = function(){
//    event.returnValue = false;
//}
//禁用选取内容
document.onselectstart = function() {
	event.returnValue = false;
}
//禁用复制
document.oncopy = function() {
	event.returnValue = false;
}
//禁用键盘中的ctrl、alt、shift
//document.onkeydown = function(){
//    if( event.ctrlKey ){
//        return false;
//    }
//    if ( event.altKey ){
//        return false;
//    }
//    if ( event.shiftKey ){
//        return false;
//    }
//}
//生成验证码
var verifyCode = new GVerify("code");
//验证码判断
var b = true;
//注册事件
document.getElementById("register").onclick = function() {
	var res = verifyCode.validate(document.getElementById("code_input").value);
	if (res) {
		b = true;
	} else {
		alert("验证码错误");
		b = false;
	}
	if (b) {
		var username = document.getElementById("username").value.trim();
		var password = document.getElementById("pwd").value.trim();
		var password1 = document.getElementById("pwd1").value.trim();
		var email = document.getElementById("email").value.trim();
		if (username.length <= 0 || username.length < 6) {
			alert("您输入的用户名是空的&少于6位也不行哦!");
			return false;
		}
		if (password.length <= 0 || password.length < 6) {
			alert("您输入的密码是空的&少于6位也不行哦!");
			return false;
		}
		if (password != password1) {
			alert("您输入的两次密码不一样哦!");
			return false;
		}
		var checkResult = checkEmail(email);
		if (!checkResult) {
			return false;
		}
		var checkuser = antiInjection("username");
		var checkpwd = antiInjection("pwd");
		var checkmail = antiInjection("email");
		if (!checkuser || !checkpwd || !checkmail) {
			return false;
		}
		var obj = {
			username : username,
			password : password,
			email : email
		};
		postParams(obj);
	}
}
function postParams(obj) {
	$.ajax({
		type : "post",
		url : "/ManageSystem/user/register",
		data : obj,
		datatype : "josn",
		success : function(data) {
			if (data.code == 200) {
				alert(data.data.result);
			} else if (data.code == 400) {
				alert(data.message);
			} else {
				alert("异常错误!");
			}
		}
	});
}
/***
 * 验证邮箱
 */
function checkEmail(obj) {
	var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //正则表达式
	if (obj === "") { //输入不能为空
		alert("输入的email是空的!");
		return false;
	} else if (!reg.test(obj)) { //正则验证不通过，格式不对
		alert("输入的email格式不正确!");
		return false;
	} else {
		return true;
	}
}
/***
 * 防sql注入
 */
function antiInjection(id) {
	var oField = document.getElementById(id);
	re = /select|update|delete|exec|count|'|"|=|;|>|<|%/i;
	if (re.test(oField.value.trim())) {
		alert("请您不要输入特殊字符和SQL关键字！"); //注意中文乱码
		oField.value = "";
		oField.focus();
		return false;
	}
	return true;
}

$(function() {
	//content 效果
	$('#centered').hide();
	$('#centered').fadeIn(3000);
	//选择修改密码
	$('body').on('click', '#update-pwd', function() {
		$('.register-box').hide();
		$('.retrieve-box').hide();
		$('.update-box').fadeIn(3000);
		$('.btns input').hide();
		$('#update').show();
		$('#retrieve-pwd').show();
	});
	//选择找回密码
	$('body').on('click', '#retrieve-pwd', function() {
		$('.register-box').hide();
		$('.update-box').hide();
		$('.retrieve-box').fadeIn(3000);
		$('.btns input').hide();
		$('#retrieve').show();
		$('#update-pwd').show();
	});

	//选择下载
	$('body').on('click', '.download', function() {
		$('#content > div').hide();
		$('.download-page').show();
	});
	//下载
	$('body').on('click', '#login-bat', function() {
		window.open("/ManageSystem/assets/files/wlk.zip");
	});
	$('body').on('click', '#client-download', function() {
		alert("提取码:94k6");
		window.open("https://pan.baidu.com/share/init?surl=gf0WV8v");
	});

	//选择赞助
	$('body').on('click', '.sponsor', function() {
		$('#content > div').hide();
		$('.sponsor-page').show();
	});
	//咨询
	$('body').on('click', '#customer', function() {
		window.open("https://jq.qq.com/?_wv=1027&k=5yvHrz8");
	});
	//选择设置
	$('body').on('click', '.setting', function() {
		$('#content > div').hide();
		$('.setting-page').show();
	});
	//选择声明
	$('body').on('click', '.statement', function() {
		$('#content > div').hide();
		$('.statement-page').show();
	});

	//修改密码
	$('body').on('click', '#update', function() {
		var updateUsername = document.getElementById("update-username").value.trim();
		var updateOldPwd = document.getElementById("update-old-pwd").value.trim();
		var updatePassword = document.getElementById("update-password").value.trim();
		var updatePassword1 = document.getElementById("update-password1").value.trim();
		if (updateUsername.length <= 0 || updateUsername.length < 6) {
			alert("您输入的用户名是空的&少于6位也不行哦!");
			return false;
		}
		if (updateOldPwd.length <= 0 || updateOldPwd.length < 6) {
			alert("您输入的旧密码是空的&少于6位也不行哦!");
			return false;
		}
		if (updatePassword.length <= 0 || updatePassword.length < 6) {
			alert("您输入的新密码是空的&少于6位也不行哦!");
			return false;
		}
		if (updatePassword != updatePassword1) {
			alert("您输入的两次密码不一样哦!");
			return false;
		}
		var checkuser = antiInjection("update-username");
		var checkoldpwd = antiInjection("update-old-pwd");
		var checknewpwd = antiInjection("update-password");
		if (!checkuser || !checkoldpwd || !checknewpwd) {
			return false;
		}
		var obj = {
			username : updateUsername,
			oldPwd : updateOldPwd,
			newPwd : updatePassword
		};
		$.ajax({
			type : "post",
			url : "/ManageSystem/user/updatePwd",
			data : obj,
			datatype : "josn",
			success : function(data) {
				if (data.code == 200) {
					alert(data.data.result);
				} else if (data.code == 400) {
					alert(data.message);
				} else {
					alert("异常错误!");
				}
			}
		});
	});

	//修改密码
	$('body').on('click', '#retrieve', function() {
		var retrieveUsername = document.getElementById("retrieve-username").value.trim();
		var retrieveEmail = document.getElementById("retrieve-email").value.trim();
		var retrievePassword = document.getElementById("retrieve-password").value.trim();
		var retrievePassword1 = document.getElementById("retrieve-password1").value.trim();
		if (retrieveUsername.length <= 0 || retrieveUsername.length < 6) {
			alert("您输入的用户名是空的&少于6位也不行哦!");
			return false;
		}
		var checkResult = checkEmail(retrieveEmail);
		if (!checkResult) {
			return false;
		}
		if (retrievePassword.length <= 0 || retrievePassword.length < 6) {
			alert("您输入的新密码是空的&少于6位也不行哦!");
			return false;
		}
		if (retrievePassword != retrievePassword1) {
			alert("您输入的两次密码不一样哦!");
			return false;
		}
		var checkuser = antiInjection("retrieve-username");
		var checkemail = antiInjection("retrieve-email");
		var checkpwd = antiInjection("retrieve-password");
		if (!checkuser || !checkemail || !checkpwd) {
			return false;
		}
		var obj = {
			username : retrieveUsername,
			email : retrieveEmail,
			newPwd : retrievePassword
		};
		$.ajax({
			type : "post",
			url : "/ManageSystem/user/retrievePwd",
			data : obj,
			datatype : "josn",
			success : function(data) {
				if (data.code == 200) {
					alert(data.data.result);
				} else if (data.code == 400) {
					alert(data.message);
				} else {
					alert("异常错误!");
				}
			}
		});
	});
});