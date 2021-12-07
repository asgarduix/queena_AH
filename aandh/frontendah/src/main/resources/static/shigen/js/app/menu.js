/**
 * 
 */
function saveStatus() {
	// 掃過menu將menu狀態轉進json資料
	var $data = $("div.list_layer");
	var alist = $("div.list_layer").find("li[style='display: list-item;']").find("a");
	var idArray = [];

	for (var i = 0; i < alist.length; i++) {
		var id = alist.eq(i).attr("id");

		if (idArray.indexOf(id) == -1) {
			idArray.push(id);
		}
	}

	// 取得紀錄的狀態資料
	var tmp = sessionStorage.getItem(menuActNm);
	var result = null;

	if ((tmp == null || tmp == undefined || tmp == "undefined" || tmp == "") == false) {
		result = JSON.parse(tmp);
	} else {
		console.log("no data! this is serious error, we will not keep data for menu");
		return true;
	}

	// 將最新狀態紀錄到資料中
	for (var i = 0; i < result.data.length; i++) {
		var menuId = result.data[i].menuId;

		var bol = false;

		for (var j = 0; j < idArray.length; j++) {
			if (menuId == idArray[j].replace("menu_id_", "")) {
				bol = true;
				break;
			}
		}

		// 設定狀態
		if (bol == true) {
			result.data[i].act = true;
		} else {
			result.data[i].act = false;
		}
	}

	sessionStorage.setItem(menuActNm, JSON.stringify(result));
//	console.log(sessionStorage.getItem(menuActNm));
//	return false;
}

menuActNm = "_menu_active_data";

$(document).ready(
		function() {
			// 試著找出已紀錄使用者操作過後的的menu紀錄
			var tmp = sessionStorage.getItem(menuActNm);
			var result = null;

			if ((tmp == null || tmp == undefined || tmp == "undefined" || tmp == "") == false) {
				// alert("1");
				result = JSON.parse(tmp);
			} else {
				// alert("2");
				// 沒有找到使用者操作過的menu紀錄
				// if (checkIsNullSpace(result) == true) {
				var url = domain4Springboot(true) + "/sysgrant/fetchSysMenu";
				var userId = {
					"userId" : localStorage.getItem("account")
				};

				result = ajaxGetTokenReady(url, userId, true);

				// 加上紀錄屬性
				for (var i = 0; i < result.data.length; i++) {
					result.data[i].act = false;
				}

				sessionStorage.setItem(menuActNm, JSON.stringify(result));
			}

			var menulist = result.data;
			var $data = $("div.list_layer");
			var menuData = "";

			// 依indexSort小到大排列Array元素
			menulist.sort(function(a, b) {
				return a.indexSort - b.indexSort;
			});

			var menuJson = {};
			var upperId;
			// 將menu依upper層分組
			for (let i = 0; i < menulist.length; i++) {

				upperId = (menulist[i].menuUpperId == null) ? menulist[i].menuId : menulist[i].menuUpperId;

				if (menuJson[upperId] == null) {
					menuJson[upperId] = [];
				}
				menuJson[upperId].push(menulist[i]);
			}

			// 組合menu頁面
			for ( var id in menuJson) {
				if (menuJson[id].length == 1) {
					// 沒有下層的upper層menu
					menuData += ('<ul><li><a href="' + menuJson[id][0].menuFuncUrl
							+ '" onclick=\"saveStatus();\" id=\"menu_id_' + id
							+ '\"><div class="item_title"><img src="' + menuJson[id][0].menuIconUrl + '"><span>'
							+ menuJson[id][0].menuName + '</span></div></a></li></ul>');
				} else {
					// 有下層的upper層menu
					for (let i = 0; i < menuJson[id].length; i++) {
						if (i == 0) {
							menuData += ('<ul><li><div class="item_title" onclick=\"saveStatus();\" id=\"' + "menu_id_"
									+ id + '\"><img src="' + menuJson[id][i].menuIconUrl + '"><span>'
									+ menuJson[id][i].menuName + '</span></div></li>');
						} else if (i == 1) { // 下層第一個menu
							menuData += ('<li class="off"><ul><li><a href="' + menuJson[id][i].menuFuncUrl
									+ '" onclick=\"saveStatus();\" id=\"menu_id_' + id + '\"><div>'
									+ menuJson[id][i].menuName + '</div></a></li>');
						} else {
							menuData += ('<li><a href="' + menuJson[id][i].menuFuncUrl
									+ '" onclick=\"saveStatus();\" id=\"menu_id_' + id + '\"><div>'
									+ menuJson[id][i].menuName + '</div></a></li>');
						}

						if (i == (menuJson[id].length - 1)) {
							menuData += ('</ul></li></ul>');
						}
					}
				}
			}

			$data.append(menuData);
			// console.log($data.html());

			// 上述畫面產生完成，先綁釘事件
			/* 無限層選單：列表收合 */
			$(".list_layer .item_title").click(function() {
				// $(this).parent().next().slideDown(10);

				var o = $(this);
				var s = o.parent().next().attr("style");

				// f-else作開關
				if (checkIsNullSpace(s) == true) {
					o.parent().next().attr("style", "display: list-item;");
				} else {
					o.parent().next().removeAttr("style");
				}
			});

			// 上述畫面產生完成，將畫面「使用者操作過後的的menu紀錄」依照menu發動一次「開啟或關閉」
			// 抓取紀錄資料中的act為true的資料，新增style='display: list-item'
			var record = result.data;

			// for (var i = 0; i < record.length; i++) {
			// console.log(record[i].menuId + "-" + record[i].act);
			// }

			for (var i = 0; i < record.length; i++) {
				if (record[i].act == true) {
					var sp = record[i].menuId.length - 3
					var code = (record[i].menuId + "").substring(sp) + "";
					
					if(code == "000"){
						//母項目找子項目直接發動
						$("#menu_id_" + record[i].menuId).next().attr("style", "display: list-item;");
					}else{
						// 子項目才用parent發動
						$("#menu_id_" + record[i].menuId).parent().next().attr("style", "display: list-item;");
					}
				}
			}

			/* 左側選單：關閉 */
			$(".nav-bt-left").click(function() {
				$("aside").animate({
					left : "-200px"
				}, 500);
				$("section").animate({
					paddingLeft : "20px",
				}, 500);
				$(this).hide();
				$(".nav-bt-right").show();
				$(".main-box").removeClass("mbnoshow");
				$(".content").removeClass("mbnoshow");
			});

			/* 左側選單：開啟 */
			$(".nav-bt-right").click(function() {
				$("aside").animate({
					left : "0"
				}, 500);
				$("section").animate({
					paddingLeft : "220px",
				}, 500);
				$(this).hide();
				$(".nav-bt-left").show();
				$(".main-box").addClass("mbnoshow");
				$(".content").addClass("mbnoshow");
			});

		});