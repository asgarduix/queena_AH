/**
 * 此js為common.js分出來的，因為須對應特定系統流程使用的(此專案中特定使用的js)，且dependency common.js
 */
$(function() {
	/* ajax jquery include html */
	loadBackground();
	$(".ajax-aside-nav").load("../../shigen/layout/ajax-aside-nav.html");
	$(".ajax-section-main").load("../../shigen/layout/ajax-section-main.html");

	recycleDo(0);
	recycleProgressFunc(checkLoginTimeAndAuth, 1 * 60 / 3 * 1000, false);// 每半鐘檢查登入時間，如果超過50分鐘，使用refresh token重新取得access token
	//recycleProgressFunc(checkToken, 10 * 60 * 1000, false);// 每10分鐘重新確認token
	// fetchPreviousPageJson();
	cleanPrevInInit();
});

// ...
var isuix = false;// uix模式切換
var previouskey = "_prev";
// prevJson = null;
// prevJosnArray = [];

function logout(){
	localStorage.clear();
	sessionStorage.clear();
}

/**
 * 
 * @returns
 */
function cleanPrev() {
	sessionStorage.removeItem(previouskey);
}


function loadBackground() { 
	var pageBgLocal = localStorage.getItem("pageBg") || "candy";
	pageBgLocal = `../../shigen/css/type-${pageBgLocal}.css`;
	document.getElementById("active-stylesheet").setAttribute('href', pageBgLocal);
}


/**
 * 
 * @returns
 */
function cleanPrevInInit() {
	var url = location.href;
	var temp = url.replace("http://", "");
	var uArray = temp.split("/");

	var funcNm = uArray[uArray.length - 1];

	if (funcNm == "login" || funcNm == "loading" || funcNm == "index") {
		cleanPrev();
	}
}

/**
 * 取得locationHrefKeepData(...)所保留的資料
 * 
 * @returns
 */
function locationHrefKeepDataFetch() {
	var sto = sessionStorage.getItem(previouskey);

	if (checkIsNullSpace(sto) == true) {
		console.log("no prev data");
		return;
	}

	var stojson = JSON.parse(sto);
	console.log("data:" + sto);
	var ks = Object.keys(stojson);

	if (ks.legnth == 0) {
		console.log("no prev data size is 0");
		return;
	}

	if (ks.length > 1) {
		console.log("no prev data size is bigger then 1");
		sessionStorage.removeItem(previouskey);// 取走即刪除資料
		return stojson[ks[0]];// TODO 待處理多筆的
	}

	// size == 1
	sessionStorage.removeItem(previouskey);// 取走即刪除資料
	return stojson[ks[0]];
}

/*
 * 
 */
function locationHref(url) {
	if (isuix == false) {
		location.href = url + "?" + "token=" + fetchToken();
	} else {
		location.href = url + ".html";
	}
};

/**
 * 蒐集html內標籤資料(標籤內必須存在name屬性，無則略過該資料)
 * 
 * @returns
 */
function sortOutAllFiled() {
	var res = {};

	// 處理輸入框
	var fields = $("html")
			.find(
					"input[type='email'],input[type='hidden'],input[type='number'],input[type='tel'],input[type='text'],input[type='time'],input[type='url'],input[type='date'],input[type='month'],input[type='week'],select,textarea");

	for (var i = 0; i < fields.length; i++) {
		// console.log(ins.eq(i)[0].outerHTML);
		var o = fields.eq(i);
		var nm = o.attr("name");

		if (checkIsNullSpace(nm) == true) {
			continue;
		}

		res[nm + ""] = o.val() + "";
	}

	// 處理radio button
	var fields2 = $("html").find("input[type='radio']:checked,input[type='checkbox']:checked");

	for (var i = 0; i < fields2.length; i++) {
		// console.log(ins.eq(i)[0].outerHTML);
		var o = fields2.eq(i);
		var nm = o.attr("name");

		if (checkIsNullSpace(nm) == true) {
			continue;
		}

		res[nm + ""] = o.val() + "";
	}

	return res;
}

/**
 * 
 * @param funcUrl
 * @param tmpkey
 *            此function會自動產生key，大多時候放空值或null即可
 * @param tmpjson
 *            可自行帶入JSON格式資料，帶入須自訂變數或方法。null或空字串:自動蒐集畫面input等輸入框資料
 * @returns
 */
function locationHrefKeepData(funcUrl, tmpkey, tmpjson) {
	if (isuix == true) {
		location.href = funcUrl + ".html";
		return;
	}

	var data = null;

	if (checkIsNullSpace(tmpjson) == true) {
		data = sortOutAllFiled();
	} else {
		data = tmpjson;
	}

	// 設定儲存的資料
	var k = tmpkey;

	if (checkIsNullSpace(k) == true) {
		var t = fetchToken();
		k = t.substring(t.length - 10, t.length);
	}

	var sto = {};
	sto[k] = data;

	sessionStorage.setItem(previouskey, JSON.stringify(sto));
	locationHref(funcUrl);
};

/**
 * window.open
 * @param funcUrl
 * @param tmpkey
 * 				此function會自動產生key，大多時候放空值或null即可
 * @param tmpjson
 * 				可自行帶入JSON格式資料，帶入須自訂變數或方法。null或空字串:自動蒐集畫面input等輸入框資料
 * @param height
 * @param width
 * @returns
 */
function locationHrefWindowKeepData(funcUrl, tmpkey, tmpjson, height, width) {
	var config = 'height='+height+',width='+width;
	if (isuix == true) {
		window.open(funcUrl + ".html", funcUrl, config=config);
		return;
	}

	var data = null;

	if (checkIsNullSpace(tmpjson) == true) {
		data = sortOutAllFiled();
	} else {
		data = tmpjson;
	}

	// 設定儲存的資料
	var k = tmpkey;

	if (checkIsNullSpace(k) == true) {
		var t = fetchToken();
		k = t.substring(t.length - 10, t.length);
	}

	var sto = {};
	sto[k] = data;

	sessionStorage.setItem(previouskey, JSON.stringify(sto));
	window.open(funcUrl + ".html?"+'token='+ fetchToken(), funcUrl, config=config);
};

/**
 * 
 */
var checkToken = function() {
	var url = location.href;
	var temp = url.replace("http://", "");
	var uArray = temp.split("/");

	if (uArray[uArray.length - 1] == "login") {
		return;
	}

	var res = ajaxPost(domain4Springboot(true) + "/authorization/checktoken", {
		"token" : localStorage.getItem("token")
	}, null);

	if (res == null || res.status != "000") {
		location.href = "./login";
		localStorage.removeItem("token");
	} else {
		confirm();
		console.log("token is expired! donothing");
	}
}

/**
 * 確認登入時間，如超過將重新認證或重新登入
 */
var checkLoginTimeAndAuth = function() {
	//如果沒有login時間，則代表沒有登入過，返回即可
	if(checkIsNullSpace(localStorage.getItem("loginTime") == true)){
		console.log("pls login");
		return;
	}
	
	//檢查時間
	//如超過50分鐘，使用refresh token重新取得access token，並重新設定localStorage的access token和登入時間
	var lt = localStorage.getItem("loginTime");
	//lt = new Number(lt) + new Number(2 * 60 * 1000);//2m，僅供測試
	lt = new Number(lt) + new Number(50 * 60 * 1000);//50m
	
	var nt= new Date().getTime();
	
	if(new Number(lt) > new Number(nt)){
		//login ing，donothing
		console.log("access token in period");
		return;
	}
	
	//使用refresh token重新取得access token
	var res = ajaxPost(domain4Springboot(true) + "/authorization/authen/refresh", {
		"refreshToken" : localStorage.getItem("refreshToken")
	}, null);
	
	if (res != null && res.status == "000" && res.data.token != null) {
		console.log("old token expired");
		console.log("new token will setup to localStorage");
		//console.log("old token expired:" + localStorage.getItem("token"));
		//console.log("new token will setup to localStorage:" + res.data.token);
		localStorage.setItem("token", res.data.token);
		localStorage.setItem("loginTime", new Date().getTime());
	} else {
		//TODO refreshToken失效(預設為24小後失效)，重新登入
		console.log("refresh token is expired! pls re login");
		
		showLoginDialog();
	
//		if (window.confirm("登入超過24小時，請重新登入")) {
//			location.href = "./login";
//		}
	}
}

/**
 * 
 * @param count
 * @returns
 */
function recycleDo(count) {
	if (count == 5) {
		console.log("+setting_menu+header_bar_break");
		return;
	}

	setTimeout(function() {
		console.log("+setting_menu+header_bar");
		settingUi();
		return recycleDo(++count);
	}, 1000);
}

/**
 * 設定表單和session main bar
 * 
 * @returns
 */
function settingUi() {
	// 加入token至top bar連結中
	var as = $("a[class='top_item']");

	for (var i = 0; i < as.length; i++) {
		if (as.eq(i).attr("href").indexOf(".html") == -1) {
			continue;
		}

		var newHref = as.eq(i).attr("href").replace(".html", "");
		as.eq(i).attr("href", newHref + "?" + "token=" + fetchToken());
	}

	// 設定menu bar
	var token = localStorage.getItem("token") + "";

	var as = $("#_menu_side").find("a[href]");

	for (var j = 0; j < as.length; j++) {

		var ao = as.eq(j);
		var h = ao.attr("href");
		// console.log(h);

		// 排除多token的狀況
		if (h.indexOf("token=") > 0) {
			continue;
		}

		var newh = h.replace(".html", "")
		ao.attr("href", "" + newh + ("?" + "token=" + token));
//		ao.attr("href", "#");
		// console.log(ao.html());
	}

	// 設定index link
	$("#_menu_side_up").find("a").attr("href", "index?" + "token=" + localStorage.getItem("token"));
}

/**
 * 儲存送審意見
 * @param data
 * @param checkfrom
 * @returns
 */
function saveCheckInfo(data, checkfrom) {
	var applno = $('#applnoAf').val();
	if (checkIsNullSpace(applno)) {
		applno = $('#applnoAx').val();
	}
	if (checkIsNullSpace(applno)) {
		styleAlert("尚未產生申請單號");
		return;
	}
	var opinionF = $('#textarea03').val();
	var opinionX = $('#textarea07').val();
	var checkTextParam = {
			"applno":applno,
			"opinionF":opinionF,
			"opinionX":opinionX,
			"action":data.innerText,
			"checkfrom":checkfrom
	};
	var checkText = ajaxPostTokenReady("../../insEndorseBuildCreateInsideApi/checkInfo", checkTextParam, false);
	styleAlert(checkText['data']);
	
	checkInfoHistory(applno, checkfrom);
}

/**
 * 顯示歷史訊息
 * @param applno
 * @param checkfrom
 * @returns
 */
function checkInfoHistory(applno, checkfrom) {
	var checkInfoParam = {
			"applno" : applno
	}
	var checkInfoHistory = ajaxPostTokenReady("../../insEndorseBuildCreateInsideApi/checkInfoHistory", checkInfoParam, false);
	console.log(checkInfoHistory);
	$('#textarea04').val(checkInfoHistory['data']['checkInfoHistoryF']);
	$('#textarea08').val(checkInfoHistory['data']['checkInfoHistoryX']);
}

/*
 * 車種列表
 */
function prepareCarType() {
	var param = {};
	res = ajaxPostTokenReady("../../commonController/queryDropDownDataList", param, false);
	var str = '';
	var carTypeList = res['data'];
	for (var i = 0; i < carTypeList.length; i++) {
		var value = carTypeList[i].mappingValue;
		if ("string" == typeof value) {
			str += '<option value="' + carTypeList[i].mappingValue.trim() + '">' + carTypeList[i].displayName + '</option>';
		}else {
			str += '<option value="' + carTypeList[i].mappingValue + '">' + carTypeList[i].displayName + '</option>';
		}
	}
	$('#input183').html(str);
	$('#input65').html(str);
}

// 取得批單申請的批文生效日期
function prepareOldEnvDate(applno) {
	var envDateMap = ajaxPostTokenReady("../../insEndorseBuildCreateInsideApi/preparedenvDate", {"applno" : applno}, false);
	var envdateF = formatDateYYYYMMDD(envDateMap['data']['envdatF']);
	var envdateX = formatDateYYYYMMDD(envDateMap['data']['envdatX']);
	prepareChangelog(applno, 'appl', envdateF, envdateX);
}

/*
 * 檔案上傳暫存資料
 */
function uploadFileTemp() {
	var file = $('#file01')[0].files[0];
	if (files.length == 0) {
		if (!checkIsNullSpace(file)) {
			files.push(file);
			base64Array.push($('#base64String').val());
			fileNameArray.push($('#base64FileName').val());
		}else {
			styleAlert("請選擇檔案");
			return false;
		}
	}else {
		if (!checkIsNullSpace(file)) {
			for (var i = 0; i < files.length; i++) {
				if (file.name == files[i].name && file.size == files[i].size) {
					styleAlert('待上傳列表中已有相同檔案');
					return false;
				}
			}
			files.push(file);
			base64Array.push($('#base64String').val());
			fileNameArray.push($('#base64FileName').val());
		}else {
			styleAlert("請選擇檔案");
			return false;
		}
	}
	sessionStorage.setItem("tempFiles", files);
	showFileList(files);
	
}

// 顯示檔案列表
function showFileList(files) {
	console.log(files);
	var str = '';
	for (var i = 0; i < files.length; i++) {
		var names = files[i].name.split('.');
		str += '<tr><td>';
		str += '<button class="button" onclick="delFileData(' + i + ')">刪除</button>';
		str += '<button class="button">檢視</button>';
		str += '</td>';
		str += '<td>' + names[0] + '</td>';
		str += '<td>' + names[1] + '</td>';
		str += '</tr>';
	}
	$('#fileDataAf').html(str);
	$('#fileDataAx').html(str);
	$('#dataInfoAf').show();
	$('#dataInfoAx').show();
}

//轉為base64
function getBase64(file) {
	var reader = new FileReader(file);
	reader.onload = function (e) {
		console.log(e.target.result);
		$('#base64String').val(e.target.result);
		$('#base64FileName').val(file.name);
	};
	reader.onerror = function (error) {
		console.log('Error: ', error);
	};
	reader.readAsDataURL(file);
}

// 刪除列表
function delFileData(num) {
	files.splice(num, 1);
	showFileList(files);
}

function preview(num) {
	console.log('第' + num + '筆資料')
}


function preview(applno, name, type) {
	var url = "&applno=" + applno
			+ "&name=" + name
			+ "&type=" + type
	window.open("http://localhost:10121/insEndorseBuildCreateInsideApi/preview?useUnicode=true&amp;characterEncoding=UTF-8"+url);
}

/**
 * 資料上傳(建檔內頁)
 * @returns
 */
function uploadFile(applno, files) {
	// 取得既有申請單號
//	if (checkIsNullSpace(applno)) {
//		styleAlert("請先取得申請單號");
//		return false;
//	}
	var res = null;
	var param = {
		"applno" : applno,
		"base64Array" : JSON.stringify(base64Array),
		"fileNameArray" : JSON.stringify(fileNameArray)
	}
	res = ajaxPostTokenReady("../../commonController/fileUplaod", param, false);
	var map = res['data'];
	var str = '';
	var fileNames = Object.keys(map);
	var results = Object.values(map);
	for (var i = 0; i < fileNames.length; i++) {
		str += fileNames[i] + ' : ' + results[i] + '</br>';
	}
	if (!checkIsNullSpace(map)) {
		styleAlert(str);
	}
}

function isEndmk(applno) {
	var param = {
			"applno" : applno
	}
	res = ajaxPostTokenReady("../../commonController/queryEndmkStatusByApplno", param, false);
	return res['data'];
}
























//董監事名單表格
//表格行模板
var rowNum = 0;
function addDirRow(e) {
	// 找出現有行數
	var dirCount = $('#directorTableX').find('tr').length;
	// 記錄新增行數
	if (rowNum == 0) {
		rowNum = dirCount
	}
	var templete = $('<tr id="row_' + rowNum + '"></tr>');
	templete = templete.append(addRowTempleteX.replace(/_0/g, '_' + rowNum));
	// 找到最後一條存在的行,在其後拼接一行
	for(var i = dirCount-1; i >= 0; i--){
		var dirRowId = $('#directorTableX').find('tr')[i].id;
		if($('#' + dirRowId).length>0){ 
			$('#' + dirRowId).after(templete);
			break;
		}
	}
	// 計數加一
	rowNum++
}

//刪除行
function delDirRow(e) {
	// 記錄新增行數
	var rowCount = $('#directorTableX').find('tr').length;
	if (rowCount > 1) {
		console.log(e);
		console.log(e.id);
		$('#' + e.id).parents('tr').remove();
		rowCount--;
	}else {
		styleAlert("不可刪除最後一行");
		return;
	}
}

//表格行模板 強制
var rowNumF = 0;
function addDirRowF(e) {
	// 找出現有行數
	var dirCountF = $('#directorTableF').find('tr').length;
	// 記錄新增行數
	if (rowNumF == 0) {
		rowNumF = dirCountF
	}
	var templeteF = $('<tr id="rowF_' + rowNumF + '"></tr>');
	templeteF = templeteF.append(addRowTempleteF.replace(/_0/g, '_' + rowNumF));
	// 找到最後一條存在的行,在其後拼接一行
	for(var i = dirCountF-1; i >= 0; i--){
		var dirRowIdF = $('#directorTableF').find('tr')[i].id;
		if($('#' + dirRowIdF).length>0){ 
			$('#' + dirRowIdF).after(templeteF);
			break;
		}
	}
	// 計數加一
	rowNumF++
}

//--
//刪除行  強制
function delDirRowF(e) {
	// 記錄新增行數
	var rowCount = $('#directorTableF').find('tr').length;
	if (rowCount > 1) {
//		console.log(e);
//		console.log(e.id);
		$('#' + e.id).parents('tr').remove();
		rowCount--;
	}else {
		styleAlert("不可刪除最後一行");
		return;
	}
}


//傷害險被保險人名冊及受益人
//表格行模板
var addInsRowTemp = '';
var addBenInsRowTemp = '';

function addInsRow() {
	// 記錄新增行數
	var areaInsCount = document.getElementsByClassName('insured').length;
	// 記錄實際表格行數
	var insRowCount = document.getElementsByClassName('insured').length;
	var templete = $('<div class="row-group insured" id="insRow_' + areaInsCount + '"></div>');
	templete = templete.append(addInsRowTemp.replace(/Row0/g, 'Row' + areaInsCount)
			.replace(/Name_0/g, 'Name_' + areaInsCount)
			.replace(/Id_0/g, 'Id_' + areaInsCount)
			.replace(/Bd_0/g, 'Bd_' + areaInsCount));
	// 找到最後一條存在的行,在其後拼接一行
	var flag = false;
	for(var i = areaInsCount-1; i >= 0; i--){
		if($('#insRow_' + i).length > 0){ 
			$('#insRow_' + i).after(templete);
			break;
		}
	}
	// 計數加一
	areaInsCount++ ; 
	insRowCount++ ;
}

function addBenRow(data) {
	// 取得tr的id
	var trId = $(data).parents('tr')[0].id;
	// 取得table的tr數量
	var trNum = $(data).parents('tbody').children('tr').length;
	//建立新的tr
	var templete = $('<tr id="' + trId.substring(0, trId.length-1) + trNum + '"></tr>');
	// 取得上一個td的html
	addBenInsRowTemp = $('#'+trId).html();
	// 設定動態正則
	var replace = '_' + (trNum-1);
	var re = new RegExp(replace, 'g');
	templete = templete.append(addBenInsRowTemp.replace(re, '_' + trNum));
	
	// 找到最後一條存在的行,在其後拼接一行
	var flag = false;
	for(var i = trNum-1; i >= 0; i--){
		if($('#' + trId).length>0){ 
			$('#' + trId).after(templete);
			break;
		}
	}
	// 清空資料
	var selects = $('#' + trId.substring(0, trId.length-1) + trNum).find('select');
	selects.val(0);
	var inputs = $('#' + trId.substring(0, trId.length-1) + trNum).find('input');
	inputs.val('');
	// 清空上一行的按鈕
	var trs = $('#' + trId.substring(0, trId.length-1) + (trNum - 1)).find('td')[0];
	trs.innerHTML = '';
}

//傷害被保險人名冊HTML
function insHtml(set1, list1) {
	var insHtmlStr = '';
	
	for (var i = 0; i < set1.length; i++) {
		insHtmlStr += '<div class="row-group insured" id="insRow_' + i +'">';
		insHtmlStr += '<div class="row">';
		insHtmlStr += '<div class="col-12 col-border">';
		insHtmlStr += '<h4>被保險人</h4><button class="button" id="insured_new_btn" onclick="addInsRow();return false;">新增被保人</button>';
		insHtmlStr += '</div>';
		insHtmlStr += '<div class="input-title col-1 col-border">被保險人姓名</div>';
		insHtmlStr += '<div class="col-2 col-border">';
		insHtmlStr += '<input id="insName_' + i +'" type="text" value="' + set1[i].namein + '" placeholder="" required>';
		insHtmlStr += '</div>';
		insHtmlStr += '<div class="input-title col-1 col-border">身份證字號</div>';
		insHtmlStr += '<div class="col-2 col-border">';
		insHtmlStr += '<input id="insId_' + i +'" type="text" value="' + set1[i].idnumber + '" placeholder="" required>';
		insHtmlStr += '</div>';
		insHtmlStr += '<div class="input-title col-1 col-border">生日</div>';
		insHtmlStr += '<div class="col-5 col-border">';
		insHtmlStr += '<input class="mingo data_time" id="insBd_' + i +'" type="text" value="' + formatDateYYYMMDD2(set1[i].birdat) + '" placeholder="" required>';
		insHtmlStr += '</div>';
		insHtmlStr += '</div>';
		insHtmlStr += '<div class="row">';
		insHtmlStr += '<div class="col-12">';
		insHtmlStr += '<div class="x_scroll css_table">';
		insHtmlStr += '<div class="scroll_table">';
		insHtmlStr += '<h4>受益人</h4>';
		insHtmlStr += '<table>';
		insHtmlStr += '<thead><tr><th>功能</th>';
		insHtmlStr += '<th>受益人與被保險人關係</th><th>受益人順位或比例</th><th>受益人姓名</th><th>關係說明</th><th>受益人聯絡地址</th><th>受益人電話</th>';
		insHtmlStr += '</tr></thead>';
		insHtmlStr += '<tbody  id="benBody_' + i +'">';
		for (var j = 0; j < list1[i].length; j++) {
			insHtmlStr += '<tr id="benRow' + i +'_' + j +'">';
			if (j == list1[i].length-1) {
				insHtmlStr += '<td><button class="button" id="beneficiary_btn" onclick="addBenRow(this);return false;">新增受益人</button></td>';
			}else {
				insHtmlStr += '<td></td>';
			}
			insHtmlStr += '<td><select id="selectInsRow' + i +'A_' + j +'" class="select_box">';
			if (list1[i][j].benrel == 0) {
				insHtmlStr += '<option value="0" selected>1.法定繼承人</option><option value="1">2.其他</option>';
			}else {
				insHtmlStr += '<option value="0">1.法定繼承人</option><option value="1" selected>2.其他</option>';
			}
			insHtmlStr += '</select></td>';
			insHtmlStr += '<td><select id="selectInsRow' + i +'B_' + j +'" class="select_box">';
			if (list1[i][j].ordtype == 0) {
				insHtmlStr += '<option value="0" selected>順位一</option><option value="1">輸入比例</option>';
			}else {
				insHtmlStr += '<option value="0">順位一</option><option value="1" selected>輸入比例</option>';
			}
			insHtmlStr += '</select>';
			insHtmlStr += '<input id="inputInsRow' + i +'A_' + j +'" type="text" value="' + list1[i][j].ordseq + '" placeholder="" required></td>';
			insHtmlStr += '<td><input id="inputInsRow' + i +'B_' + j +'" type="text" value="' + list1[i][j].bennam + '" placeholder="" required></td>';
//			insHtmlStr += '<td>' + list1[i][j].bennam + '</td>';
			insHtmlStr += '<td><input id="inputInsRow' + i +'C_' + j +'" type="text" value="' + list1[i][j].benreldes + '" placeholder="" required></td>';
			insHtmlStr += '<td><input id="inputInsRow' + i +'D_' + j +'" type="text" value="' + list1[i][j].benaddress + '" placeholder="" required></td>';
			insHtmlStr += '<td><input id="inputInsRow' + i +'E_' + j +'" type="text" value="' + list1[i][j].benphone + '" placeholder="" required></td>';
			insHtmlStr += '</tr>';
		}
		insHtmlStr += '</tbody></table></div></div></div></div></div>';
	}
	return insHtmlStr;
}

// 董監事名單HTML(任意)
function directorHtml(data) {
	var dirHtml = '';
	for (var i = 0; i < data.length; i++) {
		dirHtml += '<tr id="rowX_' + i +'">';
		dirHtml += '<td><button class="button addNewRow_btn addDirRow" id="addDirX_' + i +'" onclick="addDirRow(this);return false;">新增</button>';
		dirHtml += '<button class="button delRow_btn delDirRow" id="delDirX_' + i +'" onclick="delDirRow(this);return false;">刪除</button></td>';
		dirHtml += '<td><select class="select_box" id="selectDirXA_' + i +'" style="width: 100%;">';
		if (data[i].getmk == '1') {
			dirHtml += '<option value="0">要/被保人註記</option><option value="1" selected>1.要保人</option><option value="2">2.被保險人</option></select></td>';
		}else {
			dirHtml += '<option value="0">要/被保人註記</option><option value="1" selected>1.要保人</option><option value="2" selected>2.被保險人</option></select></td>';
		}
		dirHtml += '<td><input id="inputDirX_' + i + '" type="text" value="' + data[i].dirnam + '" placeholder="" required></td>';
//		dirHtml += '<td>' + data[i].dirnam + '</td>';
		dirHtml += '<td><select class="select_box" id="selectDirXB_' + i +'" style="width: 100%;">';
		if (data[i].blterr == '0') {
			dirHtml += '<option value="0" selected>N</option><option value="1">Y</option></select></td>';
		}else {
			dirHtml += '<option value="0" selected>N</option><option value="1" selected>Y</option></select></td>';
		}
		dirHtml += '<td><select class="select_box" id="selectDirCX_' + i +'" style="width: 100%;">';
		if (data[i].blpoli == '0') {
			dirHtml += '<option value="0" selected>N</option><option value="1">Y</option></select></td>';
		}else {
			dirHtml += '<option value="0" selected>N</option><option value="1" selected>Y</option></select></td>';
		}
		dirHtml += '<td><select class="select_box" id="selectDirDX_' + i +'" style="width: 100%;">';
		if (data[i].blgrup == '0') {
			dirHtml += '<option value="0" selected>N</option><option value="1">Y</option></select></td>';
		}else {
			dirHtml += '<option value="0" selected>N</option><option value="1" selected>Y</option></select></td>';
		}
	}
	return dirHtml;
}
// 董監事名單HTML(強制)
function directorFHtml(data) {
	var dirHtml = '';
	for (var i = 0; i < data.length; i++) {
		dirHtml += '<tr id="rowF_' + i +'">';
		dirHtml += '<td><button class="button addNewRow_btn addDirRow" id="addDirF_' + i +'" onclick="addDirRowF(this);return false;">新增</button>';
		dirHtml += '<button class="button delRow_btn delDirRow" id="delDirF_' + i +'" onclick="delDirRowF(this);return false;">刪除</button></td>';
		dirHtml += '<td><select class="select_box" id="selectDirFA_' + i +'" style="width: 100%;">';
		if (data[i].getmk == '1') {
			dirHtml += '<option value="0">要/被保人註記</option><option value="1" selected>1.要保人</option><option value="2">2.被保險人</option></select></td>';
		}else {
			dirHtml += '<option value="0">要/被保人註記</option><option value="1" selected>1.要保人</option><option value="2" selected>2.被保險人</option></select></td>';
		}
		dirHtml += '<td><input id="inputDirF_' + i + '" type="text" value="' + data[i].dirnam + '" placeholder="" required></td>';
//		dirHtml += '<td>' + data[i].dirnam + '</td>';
		dirHtml += '<td><select class="select_box" id="selectDirFB_' + i +'" style="width: 100%;">';
		if (data[i].blterr == '0') {
			dirHtml += '<option value="0" selected>N</option><option value="1">Y</option></select></td>';
		}else {
			dirHtml += '<option value="0" selected>N</option><option value="1" selected>Y</option></select></td>';
		}
		dirHtml += '<td><select class="select_box" id="selectDirFC_' + i +'" style="width: 100%;">';
		if (data[i].blpoli == '0') {
			dirHtml += '<option value="0" selected>N</option><option value="1">Y</option></select></td>';
		}else {
			dirHtml += '<option value="0" selected>N</option><option value="1" selected>Y</option></select></td>';
		}
		dirHtml += '<td><select class="select_box" id="selectDirFD_' + i +'" style="width: 100%;">';
		if (data[i].blgrup == '0') {
			dirHtml += '<option value="0" selected>N</option><option value="1">Y</option></select></td>';
		}else {
			dirHtml += '<option value="0" selected>N</option><option value="1" selected>Y</option></select></td>';
		}
	}
	return dirHtml;
}


// 取得內頁頁籤顯示id
function showIisideList(typeCode) {
	var param = {
			"typeCode" : typeCode
	}
	var res = ajaxPostTokenReady("../../commonController/queryShowBlock", param, false);
	return res['data'];
}


// 隱藏所有內頁List
function hideList() {
	var divs = $('#nav-tabContent div[id]');
	var arr = [];
	for (var i = 0; i < divs.length; i++) {
		var str = divs[i].id.substring(0,7);
		if ('content' == str) {
			$('#' + divs[i].id).hide();
			$('#' + divs[i].id).prev().hide();
			arr.push(divs[i].id);
		}
	}
	return arr;
}

// 重置日期js
function resetDateButton() {
	$(".mingo").datepicker({
		changeYear: true,
		changeMonth: true,
		dateFormat: "Rmmdd",
		showButtonPanel:false
	});
	$(".datepicker").datepicker({
		changeYear: true,
		changeMonth: true,
		dateFormat: "yy/mm/dd",
		showButtonPanel:false
	});
}
