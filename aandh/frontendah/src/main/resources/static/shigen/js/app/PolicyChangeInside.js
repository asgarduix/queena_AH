function add() {

	var param = {
		"ad01" : $("#add01").val(),
		"ad02" : $("#add02").val(),
		"ad03" : $("#add03").val(),
		"ad04" : $("#add04").val()
	};
	alert(JSON.stringify(param));

	var res = ajaxPost("../../frontendapi/insertAppHoliday", param, localStorage.getItem("token"));

	if (res == null) {
		alert("insert fail!");
		return;
	} else {
		alert("insert succ!");
		location.href = "./PolicyChangeAppl" + "?" + "token=" + localStorage.getItem("token");
	}
}