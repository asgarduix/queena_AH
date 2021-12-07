package com.asi.huanan.controller.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asi.mechanism.security.jwtref.JwtTokenUtil;

import io.swagger.annotations.Api;

@Lazy
@CrossOrigin(origins = "http://localhost:10121", maxAge = 3600)
@RequestMapping("frontendahapi")
@RestController
@Api(value = "Employee Management System")
public class FrontendApisController {
	/**
	 * TODO 單檔CRUD自動產生?
	 * 
	 */

	private static Logger log = LogManager.getLogger(FrontendApisController.class);

//	@Autowired
//	private LocationmanageService locationmanageService;
//
//	@Autowired
//	private ImagemanageService imagemanageService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

//	@Autowired
//	private AppHolidayService appHolidayService;

//	/**
//	 * 
//	 * APP_HOLIDAY 新增
//	 * 
//	 * @param paramTestList
//	 */
//	@ApiOperation(value = "刪除假日檔資料", response = JsonBean.class, tags = {
//			"appHoliday_crud" }, notes = "假日檔單檔維護<br>(可開發程式碼產生器)")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully insert data"),
//			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
//	@DeleteMapping("/deleteAppHoliday")
//	@ResponseBody
//	public ResponseEntity<?> deleteAppHoliday(@RequestParam(name = "uuid", required = true) String uuid) {
//		JsonBean jsonBean = new JsonBean();
//		int succVal = 0;
//
//		try {
//			succVal = appHolidayService.deleteByKey(uuid);
//
//			jsonBean.setStatus(SysEnum.statusSuccess.context);
//			jsonBean.setMessage("success value : " + succVal);
//			jsonBean.setData(succVal);
//		} catch (Exception e) {
//			jsonBean.setStatus(SysEnum.statusError.context);
//			jsonBean.setData(0);
//
//			log.debug(e.toString());
//			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
//			return new ResponseEntity<>(new ArrayList<String>(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		return new ResponseEntity<>(jsonBean, HttpStatus.OK);
//	}
//
//	/**
//	 * 
//	 * APP_HOLIDAY 新增
//	 * 
//	 * @param paramTestList
//	 */
//	@ApiOperation(value = "修改假日檔資料", response = JsonBean.class, tags = {
//			"appHoliday_crud" }, notes = "假日檔單檔維護<br>(可開發程式碼產生器)")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully insert data"),
//			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
//	@PostMapping("/updateAppHoliday")
//	@ResponseBody
//	public ResponseEntity<?> updateAppHoliday(@RequestParam(name = "uuid", required = true) String uuid,
//			@RequestParam(name = "holiday", required = true) String holiday,
//			@RequestParam(name = "memo", required = true) String memo,
//			@RequestParam(name = "status", required = true) String status,
//			@RequestParam(name = "entryUserid", required = true) String entryUserid) {
//		JsonBean jsonBean = new JsonBean();
//		int succVal = 0;
//		Asiutil util = new Asiutil();
//
//		try {
//			log.debug(">>>update_start!");
//
//			AppHoliday appHoliday = new AppHoliday();
//			appHoliday.setUuid(uuid);
//			List<AppHoliday> appHoliday4Update = appHolidayService.queryByAppHoliday(appHoliday);
//
//			if (appHoliday4Update == null || appHoliday4Update.size() != 1) {
//				jsonBean.setStatus(SysEnum.statusError.context);
//				jsonBean.setMessage("uuid value in table too many, pls ask to your manager!");
//				return new ResponseEntity<>(jsonBean, HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//
//			appHoliday.setUuid(uuid);
//			log.debug(">>>holiday:" + holiday);
//			appHoliday.setHoliday(util.processStringToDate("yyyy-MM-dd", holiday));
//			appHoliday.setMemo(memo);
//			appHoliday.setStatus(status);
//			appHoliday.setCrtDate(util.processDateToString(new Date(), "yyyyMMddHHmmss"));
//			appHoliday.setCrtUserid(new Date());
//			appHoliday.setEntryUserid(entryUserid);
//			appHoliday.setEntryDate(new Date());
//
//			succVal = appHolidayService.update(appHoliday);
//
//			jsonBean.setStatus(SysEnum.statusSuccess.context);
//			jsonBean.setMessage("success value : " + succVal);
//			jsonBean.setData(succVal);
//
//			log.debug(">>>update_end!");
//
//		} catch (Exception e) {
//			jsonBean.setStatus(SysEnum.statusError.context);
//			jsonBean.setData(0);
//
//			log.debug(e.toString());
//			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
//			return new ResponseEntity<>(new ArrayList<String>(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		return new ResponseEntity<>(jsonBean, HttpStatus.OK);
//	}
//
//	/**
//	 * 
//	 * APP_HOLIDAY 新增
//	 * 
//	 * @param paramTestList
//	 */
//	@ApiOperation(value = "新增假日檔資料", response = JsonBean.class, tags = {
//			"appHoliday_crud" }, notes = "假日檔單檔維護<br>(可開發程式碼產生器)")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully insert data"),
//			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
//	@PostMapping("/insertAppHoliday")
//	@ResponseBody
//	public ResponseEntity<?> insertAppHoliday(@RequestParam(name = "ad01", required = true) String ad01,
//			@RequestParam(name = "ad02", required = true) String ad02,
//			@RequestParam(name = "ad03", required = true) String ad03,
//			@RequestParam(name = "ad04", required = true) String ad04) {
//
//		JsonBean jsonBean = new JsonBean();
//		int succVal = 0;
//		Asiutil util = new Asiutil();
//
//		try {
//			AppHoliday appHoliday = new AppHoliday();
//			appHoliday.setUuid(ad01);
//			appHoliday.setCrtDate(ad02);
//			appHoliday.setMemo(ad03);
//			appHoliday.setEntryUserid(ad04);
//			appHoliday.setCrtDate(util.processDateToString(new Date(), "yyyyMMddHHmmss"));
//			succVal = appHolidayService.insert(appHoliday);
//
//			jsonBean.setStatus(SysEnum.statusSuccess.context);
//			jsonBean.setMessage("success value : " + succVal);
//			jsonBean.setData(succVal);
//		} catch (Exception e) {
//			jsonBean.setStatus(SysEnum.statusError.context);
//			jsonBean.setData(0);
//
//			log.debug(e.toString());
//			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
//			return new ResponseEntity<>(new ArrayList<String>(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		return new ResponseEntity<>(jsonBean, HttpStatus.OK);
//	}
//
//	/**
//	 * APP_HOLIDAY 查詢
//	 * 
//	 * @param paramTestList
//	 */
//	@ApiOperation(value = "查詢假日檔資料", response = JsonBean.class, tags = {
//			"appHoliday_crud" }, notes = "假日檔單檔維護<br>(可開發程式碼產生器)")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
//			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
//	@GetMapping("/queryAppHoliday")
//	@ResponseBody
//	public ResponseEntity<?> queryAppHoliday(@RequestParam(name = "uuid", required = false) String uuid) {
//		List<AppHoliday> resList = new ArrayList<>();
//
//		try {
//			if (uuid != null) {
//				AppHoliday appHoliday = new AppHoliday();
//				appHoliday.setUuid(uuid);
//				resList = appHolidayService.queryByAppHoliday(appHoliday);
//			} else {
//				resList = appHolidayService.queryAll();
//			}
//
//			// jsonBean.setStatus(SysEnum.ok.value);
//		} catch (Exception e) {
//			log.debug(e.toString());
//			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
//		}
//
//		return new ResponseEntity<>(resList, HttpStatus.OK);
//	}
//
//	/**
//	 * query row data from uuid
//	 * 
//	 * @param uuid
//	 * @return
//	 */
//	@GetMapping("/fetchDataById")
//	@ResponseBody
//	public ResponseEntity<?> fetchDataById(@RequestParam(name = "uuid", required = true) String uuid) {
//		JsonBean bean = new JsonBean();
//
//		try {
//			AppHoliday appHoliday = new AppHoliday();
//			appHoliday.setUuid(uuid);
//
//			List<AppHoliday> appHolidayList = appHolidayService.queryByAppHoliday(appHoliday);
//
//			if (appHolidayList == null || appHolidayList.size() != 1) {
//				bean.setStatus(SysEnum.statusSuccess.context);
//				bean.setData(appHolidayList);
//
//				if (appHolidayList.size() == 1) {
//					bean.setMessage("query data is null, maybe uuid is not exist in table");
//				} else {
//					bean.setMessage("query data is too many, pls check data");
//				}
//			} else {
//				bean.setStatus(SysEnum.statusSuccess.context);
//				bean.setData(appHolidayList);
//			}
//		} catch (Exception e) {
//			log.debug(e.toString());
//			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
//		}
//
//		return new ResponseEntity<>(bean, HttpStatus.OK);
//	}
//
//	/**
//	 * 
//	 * @return
//	 */
//	@GetMapping("/fetchData4Table")
//	@ResponseBody
//	public ResponseEntity<?> fetchData4Table() {
////		List<String[]> a = new ArrayList<>();
////		int s = 1000000;//spend 17s
//		int s = 60000;// 應該要在1s左右
//
//		String[][] a = new String[s][5];
//
//		for (int i = 0; i < s; i++) {
//			a[i] = new String[] { String.valueOf(i + 1), (i + 1) + " " + "Oli Bob", "12", "red", "22/05/1982", "", "",
//					"", "" };
//		}
//
////		String[][] a = new String[][] { { "1", "Oli Bob", "12", "red", "" },
////				{ "2", "Mary May", "1", "blue", "14/05/1982" },
////				{ "3", "Christine Lobowski", "42", "green", "22/05/1982" },
////				{ "4", "Brendon Philips", "125", "orange", "01/08/1980" },
////				{ "5", "Margret Marmajuke", "16", "yellow", "31/01/1999" } };
//
//		List<Data2> resList = Arrays.asList(a).stream().map(aa -> {
//			Data2 data = new Data2();
//			data.setF1(aa[0]);
//			data.setF1(aa[0]);
//			data.setF2(aa[1]);
//			data.setF3(aa[2]);
//			data.setF4(aa[3]);
//			data.setF5(aa[4]);
//			data.setF6(aa[5]);
//			data.setF7(aa[6]);
//			data.setF8(aa[7]);
//			data.setF9(aa[8]);
//			return data;
//		}).collect(Collectors.toList());
//
//		return new ResponseEntity<>(resList, HttpStatus.OK);
//	}
//
//	public class Data2 {
//		private String f1;
//		private String f2;
//		private String f3;
//		private String f4;
//		private String f5;
//		private String f6;
//		private String f7;
//		private String f8;
//		private String f9;
//
//		public String getF1() {
//			return f1;
//		}
//
//		public void setF1(String f1) {
//			this.f1 = f1;
//		}
//
//		public String getF2() {
//			return f2;
//		}
//
//		public void setF2(String f2) {
//			this.f2 = f2;
//		}
//
//		public String getF3() {
//			return f3;
//		}
//
//		public void setF3(String f3) {
//			this.f3 = f3;
//		}
//
//		public String getF4() {
//			return f4;
//		}
//
//		public void setF4(String f4) {
//			this.f4 = f4;
//		}
//
//		public String getF5() {
//			return f5;
//		}
//
//		public void setF5(String f5) {
//			this.f5 = f5;
//		}
//
//		public String getF6() {
//			return f6;
//		}
//
//		public void setF6(String f6) {
//			this.f6 = f6;
//		}
//
//		public String getF7() {
//			return f7;
//		}
//
//		public void setF7(String f7) {
//			this.f7 = f7;
//		}
//
//		public String getF8() {
//			return f8;
//		}
//
//		public void setF8(String f8) {
//			this.f8 = f8;
//		}
//
//		public String getF9() {
//			return f9;
//		}
//
//		public void setF9(String f9) {
//			this.f9 = f9;
//		}
//
//	}
//
//	/**
//	 * 
//	 * @author comic
//	 *
//	 */
//	public class Data {
//		private String id;
//		private String name;
//		private String age;
//		private String col;
//		private String dob;
//
//		public String getId() {
//			return id;
//		}
//
//		public void setId(String id) {
//			this.id = id;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public String getAge() {
//			return age;
//		}
//
//		public void setAge(String age) {
//			this.age = age;
//		}
//
//		public String getCol() {
//			return col;
//		}
//
//		public void setCol(String col) {
//			this.col = col;
//		}
//
//		public String getDob() {
//			return dob;
//		}
//
//		public void setDob(String dob) {
//			this.dob = dob;
//		}
//
//	}
//
//	/**
//	 * sample 0
//	 * 
//	 * @return
//	 */
//	@ApiOperation(value = "holiday table of wwu app", response = List.class)
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
//			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
//	@GetMapping(value = "/foo")
//	@ResponseBody
//	public ResponseEntity<?> foo(
////			@ApiParam(value = "param for holiday table of wwu app", required = true) @PathVariable(value = "id", required = false) @RequestParam(name = "param", required = false) String param
//	) {
////		System.out.println("param:" + param);
////		RestRespObj resp = new RestRespObj();
////		Bean bean = new Bean();
//		JsonBean resp = new JsonBean();
//
//		// TODO 測試URL呼叫...交易類的?
//		// TODO Spring Cloud
//
//		try {
//			List<AppHoliday> list = appHolidayService.queryAll();
////			List<String> list = Arrays.asList(new String[] { "D1_LIST", "D2_LIST" });
//			System.out.println("size@controller:" + list.size());
//
//			// set data to resp obj
//			resp.setStatus(SysEnum.statusSuccess.context);
//			resp.setMessage(SysEnum.statusSuccess.code);
//			resp.setData(list);
//			return new ResponseEntity<>(resp, HttpStatus.OK);// 請視Http Status Code的定義，因應不同程式狀況，例: 500、401等狀況
//		} catch (Exception e) {
//			Arrays.asList(e.getStackTrace()).stream().forEach(ex -> System.out.println(ex.toString()));
//			resp.setStatus(SysEnum.statusError.context);
//			resp.setMessage(SysEnum.statusError.context);
//			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);// 請視Http Status Code的定義，因應不同程式狀況，例:
//																				// 500、401等狀況
//		}
//	}
//
//	/**
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/foo2")
//	@ResponseBody
//	public ResponseEntity<?> foo2() {
//		// 測試DAO
//
//		Asiutil util = new Asiutil();
//		Object o = null;
//		try {
//			Map<String, String> conditionMap = Arrays.asList(new String[][] { { "token",
//					"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTU3OTIzNTM2MiwiZXhwIjoxNTc5MjM4OTYyfQ.cCOlbphGJ7hBODI4gPKXTLNtdPwRiniptTKiEOd_BcZ_5qwxFght6qS0tuHLM5l6a6Yxuukd9W4f5NnPnk6U3A" } })
//					.stream().collect(Collectors.toMap(s -> s[0], s -> s[1]));
//
//			Checktoken res = util.fetchPostMethdRestfulEncodeParam(
//					SpringProperty.getApiDomainFrontendWithSuffix() + "/authorization/checktoken", null, conditionMap,
//					null, Checktoken.class);
//
//			System.out.println("=====");
//			System.out.println(res.getStatus());
//
//			o = res;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return new ResponseEntity<>(o, HttpStatus.OK);
//	}

}
