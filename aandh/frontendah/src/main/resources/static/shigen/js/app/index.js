/**
 * 
 */
$(function() {
	
	var token = localStorage.getItem("token");
	
//	$(".feature-list-bg").find("a").eq(0).html();
	var as = $(".feature-list-bg").find("a");
	
	for(var i = 0; i < as.length; i++){
		as.eq(i).attr("href", "./login");
	}
	
	as.eq(1).attr("href", "./PolicyChangeAppl" + "?" + "token=" + token);
});

$(document).ready(function () {
	var url = domain4Springboot(true) + "/sysgrant/fetchSysIndex";
	var userId = {"userId" : localStorage.getItem("account")};
	var result = ajaxGetTokenReady(url,userId,true);			
	var token = "?token=" + localStorage.getItem("token");
	
	var indexlist = result.data;
	//依indexSort排列Array元素
	indexlist.sort(function (a, b) {
		return a.indexSort - b.indexSort;
	});
	var $listdata = $("div.justify-content-center");
	var index = "";

	for(let i = 0; i < indexlist.length; i++){
		index += '<div class="col-xl-3 col-lg-3 col-sm-6 col-6"><a class="item-feature" href="' + indexlist[i].indexFuncUrl + token
				+ '"><img class="icon" src="' + indexlist[i].indexIconPath 
				+ '" alt=""><div class="title s5">' + indexlist[i].indexName + '</div></a></div>';
	};
	$listdata.append(index);
});