/*
 * Copyright (c) 2000-2016 Asgard System, Inc. 
 * Taipei, Taiwan. All rights reserved. 
 * 
 * This software is the confidential and proprietary information of  
 * Asgard System, Inc. ("Confidential Information").  You shall not 
 * disclose such Confidential Information and shall use it only in 
 * accordance with the terms of the license agreement you entered into 
 * with Asgard. 
 * 
 */
package com.asi.mechanism.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.asi.huanan.service.SysAccountService;
import com.asi.huanan.service.SysFunctionRoleService;
import com.asi.huanan.service.SysFunctionUiButtonService;
import com.asi.huanan.service.SysFunctionUiFieldService;
import com.asi.huanan.service.SysIndexRoleService;
import com.asi.huanan.service.SysIndexService;
import com.asi.huanan.service.SysMenuRoleService;
import com.asi.huanan.service.SysMenuService;
import com.asi.huanan.service.SysRoleMapService;
import com.asi.huanan.service.SysRoleService;
import com.asi.huanan.service.connector.MyBatisConnector;
import com.asi.huanan.service.dao.mybatis.model.SysAccount;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionRole;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionUiButton;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionUiField;
import com.asi.huanan.service.dao.mybatis.model.SysIndex;
import com.asi.huanan.service.dao.mybatis.model.SysIndexRole;
import com.asi.huanan.service.dao.mybatis.model.SysMenu;
import com.asi.huanan.service.dao.mybatis.model.SysMenuRole;
import com.asi.huanan.service.dao.mybatis.model.SysRole;
import com.asi.huanan.service.dao.mybatis.model.SysRoleMap;
import com.asi.json.model.root.JsonBean;
import com.asi.mechanism.common.SysEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * ???????????????
 * 
 */
@Lazy
@RequestMapping("sysgrant")
@RestController
@Api(value = "Employee Management System")
public class SysGrantController {
	
	private static Logger log = LogManager.getLogger(SysGrantController.class);

	@Autowired
	private SysAccountService sysAccountService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysIndexRoleService sysIndexRoleService;
	@Autowired
	private SysMenuRoleService sysMenuRoleService;
	@Autowired
	private SysIndexService sysIndexService;
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private SysFunctionRoleService sysFunctionRoleService;
	@Autowired
	private SysFunctionUiButtonService sysFunctionUiButtonService;
	@Autowired
	private SysFunctionUiFieldService sysFunctionUiFieldService;
	@Autowired
	private MyBatisConnector mybatis;
	@Autowired
	private SysRoleMapService sysRoleMapService;
	
	
	/**
	 * 
	 * ???????????????????????????
	 * 
	 * @param paramTestList
	 */
	@ApiOperation(value = "????????????????????????????????????", response = JsonBean.class, tags = { "sysgrant" }, notes = "????????????????????????????????????")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully insert data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/fetchSysFuuction")
	@ResponseBody
	public ResponseEntity<?> fetchSysFuuction(String userId) {
		log.info("???????????? -??????????????????????????????  >>> fetchSysFuuction");
				
		//
		Map<String, FunctionRes> result = new HashMap<>();			
		JsonBean jsonBean = new JsonBean();
		
		//
		try {
			
			SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();

			try {	
							
				//1.????????????????????????	
				String resUserId = null;
				
				if(StringUtils.isNotBlank(userId)) {	
					
					SysAccount model = new SysAccount();
					model.setUserId(userId.trim());	
					List<SysAccount> account = sysAccountService.queryBySysAccount(model, sqlSession);	
					
					if(1 == account.size()) {
						resUserId = account.get(0).getUserId();
					}																
				}
							
							
				//2.????????????
				List<String> resFkUserRole = new ArrayList<>();
				
				if(StringUtils.isNotBlank(resUserId)) {

					SysRoleMap model = new SysRoleMap();
					model.setFkUserId(resUserId.trim());	
					List<SysRoleMap> roleMap = sysRoleMapService.queryBySysRoleMap(model, sqlSession);
					
					resFkUserRole = roleMap.stream().map(bean -> String.valueOf(bean.getFkUserRole())).distinct().collect(Collectors.toList());						
				}
															
							
				//3.???????????????
				List<String> resUserRole = new ArrayList<>();
				
				if(CollectionUtils.isNotEmpty(resFkUserRole)) {
									
					List<SysRole> roleList = new ArrayList<>();
							
					for(String fkUserRole : resFkUserRole) {					
						SysRole model = new SysRole();
						model.setUserRole(fkUserRole.trim());					
						List<SysRole> role = sysRoleService.queryBySysRole(model);	
						roleList.addAll(role);		
					}
														
					resUserRole = roleList.stream().map(bean -> String.valueOf(bean.getUserRole())).distinct().collect(Collectors.toList());					
				}

								
				//4.???????????????
				List<SysFunctionRole> resFunctionRole = new ArrayList<>();	
				
				if(CollectionUtils.isNotEmpty(resUserRole)) {			
																
					for(String userRole : resUserRole) {					
						SysFunctionRole model = new SysFunctionRole();
						model.setUserRole(userRole.trim());		
						List<SysFunctionRole> res = sysFunctionRoleService.queryBySysFunctionRole(model);		
						resFunctionRole.addAll(res);
					}									
				}
				
							
				//5
				Map<String, List<String>> mapB = new HashMap<>();
				Map<String, List<String>> mapF= new HashMap<>();
				if(CollectionUtils.isNotEmpty(resFunctionRole)) {
															
					if(1 == resFunctionRole.size()) {	
						//5.1????????????
						mapB = this.putMapOne(resFunctionRole, "button");	
						mapF = this.putMapOne(resFunctionRole, "field");	
					}else {	
						//5.2??????	
						mapB = this.putMaps(resFunctionRole, "button");	
						mapF = this.putMaps(resFunctionRole, "field");	
					}														
				}
						
				
				//6
				Iterator<Entry<String, List<String>>> iteB = mapB.entrySet().iterator();	
				Iterator<Entry<String, List<String>>> iteF = mapF.entrySet().iterator();
				while (iteB.hasNext()) {
					
					//6.1
					Entry<String, List<String>> oB = iteB.next();	
					Entry<String, List<String>> oF = iteF.next();	
					String key = oB.getKey();
					List<String> valueB = oB.getValue();
					List<String> valueF = oF.getValue();
																				
					//6.2								
					List<SysFunctionUiButton> buttons = new ArrayList<>();
							
					for(String b : valueB) {
						
						SysFunctionUiButton model = new SysFunctionUiButton();
						model.setFunctionUiButtonId(new BigDecimal(b.trim()));				
						List<SysFunctionUiButton> res = sysFunctionUiButtonService.queryBySysFunctionUiButton(model);	
						buttons.addAll(res);						
					}
					
					//6.3							
					List<SysFunctionUiField> fields = new ArrayList<>();
					
					for(String f : valueF) {
						
						SysFunctionUiField model = new SysFunctionUiField();
						model.setFunctionUiFieldId(new BigDecimal(f.trim()));		
						List<SysFunctionUiField> res = sysFunctionUiFieldService.queryBySysFunctionUiField(model);	
						fields.addAll(res);
					}							
																															
					//6.4????????????
					FunctionRes res = new FunctionRes();
					res.setButton(buttons);
					res.setField(fields);
					result.put(key, res);														
				}
				
			} catch (Exception e) {
				throw e;
			} finally {
				sqlSession.close();
			}

			//7
			jsonBean.setStatus(SysEnum.statusSuccess.context);
			jsonBean.setData(result);
			
		} catch (Exception e) {
			
			jsonBean.setStatus(SysEnum.statusError.context);
			jsonBean.setData(0);

			log.debug(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
			return new ResponseEntity<>(new ArrayList<String>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonBean, HttpStatus.OK);
	}
	
	//
	private Map<String, List<String>> putMaps(List<SysFunctionRole> inputs, String check) {
		log.info("???????????? -??????????????????????????????  >>> putMaps");
		
		Map<String, List<String>> result = new HashMap<>();

		//1.?????????????????????List???	
		List<String> sameMenuIds  = new ArrayList<>();						
		for(int i=1; i < inputs.size(); i++) {
																				
			if(inputs.get(i-1).getMenuId().equals(inputs.get(i).getMenuId())) {														
				sameMenuIds.add(inputs.get(i-1).getMenuId().toString());															
			}	
		}
		
		//2.List?????????????????????
		List<String> sameOther = new ArrayList<>();
		
		for(SysFunctionRole input : inputs) {
			for(String sameId : sameMenuIds) {
				
				//?????????????????????
				if(input.getMenuId().toString().equals(sameId.toString())) {
													
					String key  = input.getMenuId().toString();
					
					if("button" == check && null != input.getFunctionUiButtonId()) {	
						sameOther.add(input.getFunctionUiButtonId().toString()); 
					}
					 
					if("field" == check && null != input.getFunctionUiFieldId()) {
						sameOther.add(input.getFunctionUiFieldId().toString()); 
					}
					 					
					result.put(key, sameOther);
					
				}else {
													
					String key  = input.getMenuId().toString();
					
					List<String> others = new ArrayList<>();
					
					if("button" == check && null != input.getFunctionUiButtonId()) {
						others.add(input.getFunctionUiButtonId().toString());  
					}
					
					if("field" == check && null != input.getFunctionUiFieldId()) {
						others.add(input.getFunctionUiFieldId().toString());
					}
					
					result.put(key, others);								
				}
			}																
		}		
		return result;
	}

	//
	private Map<String, List<String>> putMapOne(List<SysFunctionRole> inputs, String check) {
		log.info("???????????? -??????????????????????????????  >>> putMapOne");
		
		Map<String, List<String>> result = new HashMap<>();

		for(SysFunctionRole input : inputs) {
			
			String key  = input.getMenuId().toString();
			
			List<String> others = new ArrayList<>();
			
			if("button" == check && null != input.getFunctionUiButtonId()) {
				others.add(input.getFunctionUiButtonId().toString()); 
			}
			
			if("field" == check && null != input.getFunctionUiFieldId()) {				
				others.add(input.getFunctionUiFieldId().toString());		  
			}
			 					
			result.put(key, others);			
		}	
		return result;
	}

	
//	/**
//	 * 
//	 * ???????????????????????????
//	 * 
//	 * @param paramTestList
//	 */
//	@ApiOperation(value = "????????????????????????????????????", response = JsonBean.class, tags = { "sysgrant" }, notes = "????????????????????????????????????")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully insert data"),
//			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
//	@GetMapping("/fetchSysFuuction")
//	@ResponseBody
//	public ResponseEntity<?> fetchSysFuuction(String userId) {
//		JsonBean jsonBean = new JsonBean();
//		Map<String, FunctionRes> resMap = new HashMap<>();
//
//		// ??????????????????menu????????????????????????
//		// ???????????????????????????
//		// ???????????????JSON??????,???????????????
//		try {
//			SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
//
//			try {
//				String roleNm = this.findRoleWithUserId(userId, sqlSession);
//				log.debug("acc_name:" + userId + "???role_name:" + roleNm);
//
//				SysFunctionRole sysFunctionRole = new SysFunctionRole();
//				sysFunctionRole.setUserRole(roleNm);
//				List<SysFunctionRole> funcRoleList = sysFunctionRoleService.queryBySysFunctionRole(sysFunctionRole,
//						sqlSession);
//
//				// ===???????????????menu id?????????_start===
//				funcRoleList = funcRoleList.stream().filter(role -> role.getMenuId() != null)
//						.collect(Collectors.toList());
//
//				// ??????menu??????button???filedid
//				List<String> menuSet = funcRoleList.stream().map(bean -> String.valueOf(bean.getMenuId())).distinct()
//						.collect(Collectors.toList());
//
//				List<SysFunctionRole> funcRoleListFin = funcRoleList.stream().collect(Collectors.toList());// close????????????????????????
//
//				// ??????menu(??????)???function????????????
//				Map<String, List<SysFunctionRole>> map = new HashMap<>();
//
//				menuSet.stream().forEach(menuId -> {
//					List<SysFunctionRole> list = funcRoleListFin.stream()
//							.filter(role -> menuId.equals(String.valueOf(role.getMenuId())))
//							.collect(Collectors.toList());
//					map.put(menuId, list);
//				});
//
//				Iterator<Entry<String, List<SysFunctionRole>>> ite = map.entrySet().iterator();
//
//				// ??????menu??????button???filedid
//				while (ite.hasNext()) {
//					Entry<String, List<SysFunctionRole>> o = ite.next();
//
//					// ?????????
//					String key = o.getKey();
//					List<SysFunctionRole> list = o.getValue();
//
//					// ??????????????????butto_id???filed_id????????????????????????
//					List<SysFunctionRole> roleList = list.stream()
//							.filter(role -> role.getFunctionUiButtonId() != null || role.getFunctionUiFieldId() != null)
//							.collect(Collectors.toList());
//
//					if (roleList.size() == 0) {
//						throw new Exception(
//								"sys_function_role??????????????????????????????sys_function_role.function_ui_button_id???sys_function_role.function_ui_field_id????????????");
//					}
//
//					// ??????sys_funciton_role???sys_button_ui_button??????
//					List<SysFunctionUiButton> resButtonList = new ArrayList<>();// ?????????list???????????????????????????null
//
//					try {
//						List<SysFunctionUiButton> buttonList = roleList.stream().map(role -> {
//							SysFunctionUiButton button = new SysFunctionUiButton();
//							button.setFunctionUiButtonId(role.getFunctionUiButtonId());
//							return button;
//						}).collect(Collectors.toList());
//
//						resButtonList = sysFunctionUiButtonService.queryBySysIndex4MultiButtonId(buttonList,
//								sqlSession);
//					} catch (Exception e) {
//						log.debug(e.toString());
//						Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
//						log.debug("??????sys_funciton_role???sys_button_ui_button????????????????????????");
//					}
//
//					// ??????sys_funciton_role???sys_button_ui_field??????
//					List<SysFunctionUiField> resFieldList = new ArrayList<>();// ?????????list???????????????????????????null
//
//					try {
//						List<SysFunctionUiField> fieldList = roleList.stream().map(role -> {
//							SysFunctionUiField field = new SysFunctionUiField();
//							field.setFunctionUiFieldId(role.getFunctionUiFieldId());
//							return field;
//						}).collect(Collectors.toList());
//
//						resFieldList = sysFunctionUiFieldService.queryByFieldIdList(fieldList, sqlSession);
//					} catch (Exception e) {
//						log.debug(e.toString());
//						Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
//						log.debug("??????sys_funciton_role???sys_button_ui_field????????????????????????");
//					}
//
//					// ????????????
//					FunctionRes res = new FunctionRes();
//					res.setButton(resButtonList);
//					res.setField(resFieldList);
//					resMap.put(key, res);
//				}
//
//				// ===???????????????menu id?????????_end===
//			} catch (Exception e) {
//				throw e;
//			} finally {
//				sqlSession.close();
//			}
//
//			jsonBean.setStatus(SysEnum.statusSuccess.context);
//			jsonBean.setData(resMap);
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

	/**
	 * 
	 * @author leo_lee
	 *
	 */
	public class FunctionRes {
		List<SysFunctionUiButton> button;
		List<SysFunctionUiField> field;

		public List<SysFunctionUiButton> getButton() {
			return button;
		}

		public void setButton(List<SysFunctionUiButton> button) {
			this.button = button;
		}

		public List<SysFunctionUiField> getField() {
			return field;
		}

		public void setField(List<SysFunctionUiField> field) {
			this.field = field;
		}

	}
	
	/**
	 * 
	 * ???????????????????????????
	 * 
	 * @param paramTestList
	 */
	@ApiOperation(value = "?????????????????????????????????", response = JsonBean.class, tags = { "sysgrant" }, notes = "???????????????????????????")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully insert data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/fetchSysIndex")
	@ResponseBody
	public ResponseEntity<?> fetchSysIndex(String userId) {		
		log.info("???????????? -??????????????????????????????_Index  >>> fetchSysIndex");
		
		JsonBean jsonBean = new JsonBean();

		try {
					
			SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();							
			List<? extends Object> resList = new ArrayList<>();

			try {
							
				//1.????????????????????????	
				String resUserId = null;
				
				if(StringUtils.isNotBlank(userId)) {	
										
					SysAccount model = new SysAccount();
					model.setUserId(userId.trim());		
					List<SysAccount> account = sysAccountService.queryBySysAccount(model, sqlSession);	
					
					if(1 == account.size()) {
						resUserId = account.get(0).getUserId();
					}																
				}
							
							
				//2.????????????
				List<String> resFkUserRole = new ArrayList<>();
				
				if(StringUtils.isNotBlank(resUserId)) {
															
					SysRoleMap model = new SysRoleMap();
					model.setFkUserId(resUserId.trim());	
					List<SysRoleMap> roleMap = sysRoleMapService.queryBySysRoleMap(model, sqlSession);	
					
					resFkUserRole = roleMap.stream().map(bean -> String.valueOf(bean.getFkUserRole())).distinct().collect(Collectors.toList());						
				}
				
				
				//3.???????????????	
				List<String> resIndexId = new ArrayList<>();

				if(CollectionUtils.isNotEmpty(resFkUserRole)) {
										
					List<SysIndexRole> insdxRole = new ArrayList<>();		
							
					for(String fkUserRole : resFkUserRole) {			
						
						SysIndexRole model = new SysIndexRole();
						model.setUserRole(fkUserRole.trim());
						List<SysIndexRole> res = sysIndexRoleService.queryBySysIndexRole(model);			
						insdxRole.addAll(res);
					}
										
					resIndexId = insdxRole.stream().map(bean -> String.valueOf(bean.getIndexId())).distinct().collect(Collectors.toList());														
				}

							
				//4.???????????????
				if(CollectionUtils.isNotEmpty(resIndexId)) {		
										
					List<SysIndex> resultList = new ArrayList<>();		
					
					for(String indexId : resIndexId) {		
						
						SysIndex model = new SysIndex();
						model.setIndexId(new BigDecimal(indexId.trim()));
						List<SysIndex> res = sysIndexService.queryBySysIndex(model);	
						resultList.addAll(res);			
					}						
					
					resList = resultList;
				}	
								
			} catch (Exception e) {
				throw e;
			} finally {
				sqlSession.close();
			}

			jsonBean.setStatus(SysEnum.statusSuccess.context);
			jsonBean.setData(resList);
			
		} catch (Exception e) {
			
			jsonBean.setStatus(SysEnum.statusError.context);
			jsonBean.setData(0);

			log.debug(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
			return new ResponseEntity<>(new ArrayList<String>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonBean, HttpStatus.OK);
	}
	
//	/**
//	 * 
//	 * ???????????????????????????
//	 * 
//	 * @param paramTestList
//	 */
//	@ApiOperation(value = "?????????????????????????????????", response = JsonBean.class, tags = { "sysgrant" }, notes = "???????????????????????????")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully insert data"),
//			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
//	@GetMapping("/fetchSysIndex")
//	@ResponseBody
//	public ResponseEntity<?> fetchSysIndex(String userId) {
//		JsonBean jsonBean = new JsonBean();
//
//		// ??????????????????menu????????????????????????
//		// ???????????????????????????
//		// ???????????????JSON??????,???????????????
//		try {
//			SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
//			List<? extends Object> resList = new ArrayList<>();
//
//			try {
//				String roleNm = this.findRoleWithUserId(userId, sqlSession);
//
//				// ??????index role??????
//				SysIndexRole sysIndexRole = new SysIndexRole();
//				sysIndexRole.setUserRole(roleNm);
//
//				List<SysIndexRole> sysIndexRoleList = sysIndexRoleService.queryBySysIndexRole(sysIndexRole, sqlSession);
//
//				if (sysIndexRoleList == null || sysIndexRoleList.size() == 0) {
//					throw new Exception("data list of filter data is null or no data:" + "sys_index_role");
//				}
//
//				List<SysIndex> sysIndexList = sysIndexRoleList.stream().map(role -> {
//					SysIndex sysIndex = new SysIndex();
//					sysIndex.setIndexId(role.getIndexId());
//					return sysIndex;
//				}).collect(Collectors.toList());
//
//				resList = sysIndexService.queryBySysIndex4MultiIndexId(sysIndexList, sqlSession);
//			} catch (Exception e) {
//				throw e;
//			} finally {
//				sqlSession.close();
//			}
//
//			jsonBean.setStatus(SysEnum.statusSuccess.context);
//			jsonBean.setData(resList);
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

	/**
	 * 
	 * ???????????????????????????
	 * 
	 * @param paramTestList
	 */
	@ApiOperation(value = "???????????????????????????", response = JsonBean.class, tags = { "sysgrant" }, notes = "???????????????????????????")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully insert data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/fetchSysMenu")
	@ResponseBody
	public ResponseEntity<?> fetchSysMenu(String userId) {
		JsonBean jsonBean = new JsonBean();

		// ??????????????????menu????????????????????????
		// ???????????????????????????
		// ???????????????JSON??????,???????????????
		try {
			SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();

			try {
				String roleNm = this.findRoleWithUserId(userId, sqlSession);

				// ??????menu???index????????????
				SysMenuRole sysMenuRole = new SysMenuRole();
				sysMenuRole.setUserRole(roleNm);
				List<SysMenuRole> sysMenuRoleList = sysMenuRoleService.queryBySysMenuRole(sysMenuRole, sqlSession);

				// ????????????
				List<SysMenu> sysMenuList = sysMenuService.queryAll(sqlSession);

				// ????????????????????????????????????????????????????????????
				List<? extends Object> newMenuList = this.findSameFiledDataAListByBList(
						new Bean4Compare().setName("sys_menu").setFieldNm("menu_id").setBeanList(sysMenuList),
						new Bean4Compare().setName("sys_menu_role").setFieldNm("menu_id").setBeanList(sysMenuRoleList));

				// ????????????(????????????????????????)
				Comparator<SysMenu> comparator = new Comparator<SysMenu>() {
					@Override
					public int compare(SysMenu o1, SysMenu o2) {
						return o1.getIndexSort().subtract(o2.getIndexSort()).intValue();
					}

				};

				newMenuList = newMenuList.stream().map(bean -> (SysMenu) bean).sorted(comparator)
						.map(bean -> (Object) bean).collect(Collectors.toList());

				jsonBean.setStatus(SysEnum.statusSuccess.context);
				jsonBean.setData(newMenuList);
			} catch (Exception e) {
				throw e;
			} finally {
				sqlSession.close();
			}
		} catch (Exception e) {
			jsonBean.setStatus(SysEnum.statusError.context);
			jsonBean.setData(0);

			log.debug(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
			return new ResponseEntity<>(new ArrayList<String>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(jsonBean, HttpStatus.OK);
	}

	/**
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 * 
	 */
	public String findRoleWithUserId(String userId, SqlSession sqlSession) throws Exception {
		SysAccount sysAccount = new SysAccount();
		sysAccount.setUserId(userId);

		// ?????????????????????
		List<SysAccount> accList = sysAccountService.queryBySysAccount(sysAccount, sqlSession);

		if (accList == null || accList.size() != 1) {
			throw new Exception("data of sys_account have serious error");
		}

		String roleNm = accList.get(0).getUserRole();

		SysRole sysRole = new SysRole();
		sysRole.setUserRole(roleNm);
		List<SysRole> roleList = sysRoleService.queryBySysRole(sysRole);

		if (roleList == null || roleList.size() == 0) {
			throw new Exception("user role[" + userId + "] data is not exist sys_role");
		}

		return roleNm;
	}

	/**
	 * ????????????
	 * 
	 * ??????????????????????????????????????????????????????????????????????????????????????????
	 * 
	 * @return
	 * @throws Exception
	 * 
	 */
	public List<? extends Object> findSameFiledDataAListByBList(Bean4Compare adata, Bean4Compare filterData)
			throws Exception {
		if (adata.getFieldNm() == null || filterData.getFieldNm() == null) {
			throw new Exception("filed name of adata of bdata is null");
		}

		if (adata.getBeanList() == null || adata.getBeanList().size() == 0) {
			log.debug("data list of adata is null or no data:" + adata.getName());
			return new ArrayList<>();
		}

		if (filterData.getBeanList() == null || filterData.getBeanList().size() == 0) {
			log.debug("data list of filter data is null or no data:" + filterData.getName());
			return new ArrayList<>();
		}

		log.debug("a size:" + adata.getBeanList().size());
		log.debug("filter size:" + filterData.getBeanList().size());

		List<String> filterDataFiledVarList = filterData.getBeanList().stream().map(bean -> {
			try {
				String filedNm = this.delExpAnd1stStrUppercaseType4(filterData.getFieldNm(), "_");
				return this.getFiledValFromObj(bean, filedNm);
			} catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException
					| InvocationTargetException e) {
				Arrays.asList(e.getStackTrace()).stream().forEach(sub -> log.debug(sub.toString()));
				return null;
			}
		}).filter(res -> res != null).map(res -> String.valueOf(res)).collect(Collectors.toList());

		if (filterDataFiledVarList.size() == 0) {
			log.debug("no data" + "-" + adata.getName());
		}

		return adata.getBeanList().stream().filter(bean -> {
			String bFildeVar = null;
			try {
				String filedNm = this.delExpAnd1stStrUppercaseType4(filterData.getFieldNm(), "_");
				bFildeVar = this.getFiledValFromObj(bean, filedNm);
			} catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException
					| InvocationTargetException e) {
				Arrays.asList(e.getStackTrace()).stream().forEach(sub -> log.debug(sub.toString()));
			}

			if (bFildeVar == null) {
				return false;
			}

			String bFiledVarTmp = bFildeVar;
			return filterDataFiledVarList.stream().anyMatch(aFiledVar -> aFiledVar.equals(bFiledVarTmp));
		}).collect(Collectors.toList());
	}

	/**
	 * ?????????????????????????????????????????????????????????(??????!???????????????????????????????????????)
	 * 
	 * @param obj
	 * @param methodNm
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public String getFiledValFromObj(Object obj, String filedNm) throws IllegalAccessException,
			IllegalArgumentException, NoSuchMethodException, SecurityException, InvocationTargetException {
		String methodNm = this.appendStr2Head("get", filedNm);

		// XXX ??????Filed?????????????????????...??????????????????getMethod?????????
		Class<? extends Object> aIns = obj.getClass();
		Object insIdObj = aIns.getMethod(methodNm).invoke(obj);

		String insIdStr = null;

		if (insIdObj != null) {
			insIdStr = String.valueOf(insIdObj);
		}

		return insIdStr;
	}

	/**
	 * 
	 * @author leo_lee
	 *
	 */
	public class Bean4Compare {
		private String name;// ??????log??????
		private String fieldNm;
		private List<? extends Object> beanList;

		public String getName() {
			return name;
		}

		public Bean4Compare setName(String name) {
			this.name = name;
			return this;
		}

		public String getFieldNm() {
			return fieldNm;
		}

		public Bean4Compare setFieldNm(String fieldNm) {
			this.fieldNm = fieldNm;
			return this;
		}

		public List<? extends Object> getBeanList() {
			return beanList;
		}

		public Bean4Compare setBeanList(List<? extends Object> beanList) {
			this.beanList = beanList;
			return this;
		}

	}

	/**
	 * ??????????????????????????????,???????????????????????????????????????,???:abc???get=>getAbc abc???edf=>edfAbc
	 */
	public String appendStr2Head(String head, String str) {
		return head + this.firstToUppercase(str);
	}

	/**
	 * ????????????????????????"_",??????"_"?????????????????????????????????(????????????????????????????????????,??????"_"????????????????????????,???:Ab_CD=>abCd)
	 */
	public String delExpAnd1stStrUppercaseType4(String str, String exp) {
		String res = Arrays.asList(str.split(exp)).stream().map(ss -> this.firstToUppercase(ss.toLowerCase()))
				.collect(Collectors.joining());
		return this.firstToLowcase(res.toString());
	}

	/**
	 * ??????????????????????????????????????????????????????
	 */
	public String firstToUppercase(String s) {
		StringBuffer b = new StringBuffer();
		b.append(s.substring(0, 1).toUpperCase());
		b.append(s.substring(1));
		return b.toString();
	}

	/**
	 * ??????????????????????????????????????????????????????
	 */
	public String firstToLowcase(String s) {
		StringBuffer b = new StringBuffer();
		b.append(s.substring(0, 1).toLowerCase());
		b.append(s.substring(1));
		return b.toString();
	}

	/**
	 * 
	 * @param bList
	 * @return
	 */
	public String genSubMenuDataArray(List<SysMenu> bList) {
		StringBuffer sb = new StringBuffer();

		for (SysMenu b2bIndexMenu : bList) {
			sb.append(this.genSubMenuData(b2bIndexMenu) + ",");
		}

		return null;
	}

	/**
	 * @return
	 * 
	 */
	public String genSubMenuData(SysMenu menu) {
		StringBuffer sb = new StringBuffer();

		Map<String, String> caseMap = new HashMap<>();

		caseMap.put("SUB_MENU_NM", menu.getMenuName());
		caseMap.put("SUB_MENU_HREF", menu.getMenuFuncUrl());
		caseMap.put("SUB_MENU_IMG", menu.getMenuIconUrl());

		if (caseMap.get("SUB_MENU_NM") != null && !"".equals(caseMap.get("SUB_MENU_NM"))) {
			// TODO ??????gson????????????????????????????????????
			// sb.append(JSONTransUtil.combineMapToJSONStr(caseMap));
		}

		return sb.toString();
	}

//	/**
//	 * 
//	 * @author leo_lee
//	 *
//	 */
//	public class GrantRes {
//		private Map<String, List<? extends Object>> data;
//
//		public Map<String, List<? extends Object>> getData() {
//			return data;
//		}
//
//		public void setData(Map<String, List<? extends Object>> data) {
//			this.data = data;
//		}
//	}

//	/**
//	 * 
//	 * @author leo_lee
//	 *
//	 */
//	public class SysGrant {
//		private List<SysIndex> indexList;
//		private List<SysMenu> menuList;
//
//		public List<SysIndex> getIndexList() {
//			return indexList;
//		}
//
//		public void setIndexList(List<SysIndex> indexList) {
//			this.indexList = indexList;
//		}fe
//
//		public List<SysMenu> getMenuList() {
//			return menuList;
//		}
//
//		public void setMenuList(List<SysMenu> menuList) {
//			this.menuList = menuList;
//		}
//
//	}

//	/**
//	 * 
//	 * @author leo_lee
//	 *
//	 */
//	public class SysGrant2 {
//		private List<? extends Object> indexList;
//		private List<? extends Object> menuList;
//
//		public List<? extends Object> getIndexList() {
//			return indexList;
//		}
//
//		public void setIndexList(List<? extends Object> indexList) {
//			this.indexList = indexList;
//		}
//
//		public List<? extends Object> getMenuList() {
//			return menuList;
//		}
//
//		public void setMenuList(List<? extends Object> menuList) {
//			this.menuList = menuList;
//		}
//
//	}
}