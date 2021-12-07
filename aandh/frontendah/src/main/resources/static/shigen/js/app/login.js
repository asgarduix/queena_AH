/**
 * 
 */
function doLogin(issubmit) {
	if (checkIsNullSpace($("#account").val()) || checkIsNullSpace($("#pass").val())) {
		styleAlert("請輸入正確的帳號密碼，帳號和密碼為空資料");
		return false;
	}

	// 呼叫帳號檢核服務，取得Token資料
	var varUsr = $("#account").val();
	var varPasswd = $("#pass").val();
	var k = null;
	var r = null;

	var domain = document.URL.split("/")[2];
	// var domain = "localhost";
	// console.log(domain);

	$.ajax({
		url : "http://" + domain + "/authorization/authen?" + jQuery.param({
			username : varUsr,
			password : varPasswd
		}),
		contentType : "application/x-www-form-urlencoded",
		async : false,
		method : "POST",
		complete : function(jqXHR, data) {
			switch (jqXHR.status) {
			case 200:
//				console.log(jqXHR);
				k = jqXHR.responseJSON.data.token;
				r = jqXHR.responseJSON.data.refreshToken;

				console.log(k);

				if (checkIsNullSpace(k) == true) {
					styleAlert("請輸入正確的帳號密碼");
					console.log("領取金鑰時發生錯誤");
					return false;
				}

				console.log(k);
				localStorage.setItem("token", k);
				localStorage.setItem("refreshToken", r);
				localStorage.setItem("account", varUsr);
				
				if(issubmit == true){
					$("#token").val(k);
					$("#action_form").submit();
				}else{
					return true;
				}
				// window.location = "./dpsfrontend";
				break;
			case 400:
				console.log("auth fail");
				break;
			case 401:
				styleAlert("請輸入正確的帳號密碼");
				console.log("auth fail");
				break;
			case 403:
				styleAlert("請輸入正確的帳號密碼");
				console.log("auth fail");
				break;
			case 500:
				console.log("登入時發生嚴重錯誤");
				break;
			default:
				styleAlert("登入時發生嚴重錯誤");
			}

		}
	});
}