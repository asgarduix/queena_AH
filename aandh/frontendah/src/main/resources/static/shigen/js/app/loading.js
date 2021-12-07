/**
 * 
 */
$(function() { 

	setTimeout(function() {
		var funcs = document.URL.split("/");
		var nowfunc = funcs[funcs.length - 1];
		if ("loading" == nowfunc) {
			var t = localStorage.getItem("token");
			var r = localStorage.getItem("refreshToken");
			var a = localStorage.getItem("account");
			logout();// clean cache
			localStorage.setItem("token", t);
			localStorage.setItem("refreshToken", r);
			localStorage.setItem("account", a);
			localStorage.setItem("loginTime", new Date().getTime());
			
			var url1 = domain4Springboot(true) + "/settingApi/fetchSetting";
			var userId1 = {"userId" : localStorage.getItem("account")};
			var result1 = ajaxGetTokenReady(url1,userId1,true);			
			var pageBg = result1.data["pageBg"];
			localStorage.setItem("pageBg", pageBg);
			
			// jump to index
			location.href = "./index" + "?" + "token=" + localStorage.getItem("token");
		}
		
	}, 1300);
})


