package com.asi.huanan.controller.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.asi.huanan.service.SysUserPersonalService;
import com.asi.huanan.service.dao.mybatis.model.SysUserPersonal;
import com.asi.json.model.root.JsonBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Lazy
@CrossOrigin(origins = "http:localhost:10121", maxAge = 3600)
@RequestMapping("settingApi")
@RestController
@Api(value = "Employee Management System")
public class SettingController {

	private static Logger log = LogManager.getLogger(SettingController.class);

	@Autowired
	SysUserPersonalService sysUserPersonalService;

	@ApiOperation(value = "查詢使用者個人設定", response = JsonBean.class, tags = { "settingApi" }, notes = "查詢使用者個人設定")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully insert data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/fetchSetting")
	@ResponseBody
	public ResponseEntity<?> settingControllerQuery(String userId) {

		JsonBean jsonBean = new JsonBean();
		Map<String, String> result = new HashMap<String, String>();
		List<SysUserPersonal> sysUserPersonalList = null;

		try {
			sysUserPersonalList = sysUserPersonalService.queryByUserId(userId);
			SysUserPersonal first = sysUserPersonalList.get(0);
			String pageBg = first.getPageBg();
			result.put("userId", userId);
			result.put("pageBg", pageBg);

			jsonBean.setData(result);
			jsonBean.setStatus("200");
			jsonBean.setMessage(this.backPublicErrorMsg("200").getMessage());

		} catch (Exception e) {
			log.debug(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
			jsonBean.setData("");
			jsonBean.setStatus("400");
			jsonBean.setMessage(this.backPublicErrorMsg("400").getMessage());
			return new ResponseEntity<>(new HashMap<String, String>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(jsonBean, HttpStatus.OK);
	}

	@ApiOperation(value = "更新個人設定", response = JsonBean.class, tags = { "settingApi" }, notes = "更新個人設定")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping(value = "/updateSetting")
	@ResponseBody
	public ResponseEntity<?> settingControllerUpdate(@RequestParam(name = "userId", required = true) String userId,
			@RequestParam(name = "pageBg", required = true) String pageBg) {

		JsonBean jsonBean = new JsonBean();

		try {
			SysUserPersonal sysUserPersonal = new SysUserPersonal();
			sysUserPersonal.setUserId(userId);
			sysUserPersonal.setPageBg(pageBg);
			int count = sysUserPersonalService.updatePageBg(sysUserPersonal, userId);

			jsonBean.setData(count);
			jsonBean.setStatus("200");
			jsonBean.setMessage(this.backPublicErrorMsg("200").getMessage());

		} catch (Exception e) {
			log.debug(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
			jsonBean.setData("");
			jsonBean.setStatus("400");
			jsonBean.setMessage(this.backPublicErrorMsg("400").getMessage());
			return new ResponseEntity<>(jsonBean, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(jsonBean, HttpStatus.OK);
	}

	/**
	 * 公用錯誤訊息
	 * 
	 * @return
	 */
	public JsonBean backPublicErrorMsg(String status) {
		JsonBean jsonBean = new JsonBean();
		try {
			jsonBean.setData("");
			jsonBean.setStatus(status);
			switch (status) {
			case "200":
				jsonBean.setMessage("回傳成功");
				break;
			case "400":
				jsonBean.setMessage("參數錯誤");
				break;
			case "401":
				jsonBean.setMessage("需要登入");
				break;
			case "403":
				jsonBean.setMessage("沒有權限");
				break;
			case "409":
				jsonBean.setMessage("連線錯誤");
				break;
			default:
				jsonBean.setMessage("");
				break;
			}

		} catch (Exception e) {
			log.debug(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
		}

		return jsonBean;
	}
}
