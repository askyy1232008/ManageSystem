var verifyCode = new GVerify("code");
var b = true;
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
		var email = document.getElementById("email").value.trim();
		if (username.length <= 0 || username.length < 6) {
			alert("您输入的用户名是空的&少于6位也不行哦!");
			return false;
		}
		if (password.length <= 0 || username.length < 6) {
			alert("您输入的密码是空的&少于6位也不行哦!");
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
			if(data.code == 200){
				alert(data.data.result);
			}else if(data.code == 400){
				alert(data.message);
			}else{
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