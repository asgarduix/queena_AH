package com.asi.mechanism.security;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asi.huanan.controller.FrontendController;
import com.asi.huanan.service.SysAccountService;
import com.asi.huanan.service.SysRoleService;
import com.asi.huanan.service.dao.mybatis.model.SysAccount;
import com.asi.huanan.service.dao.mybatis.model.SysRole;

@Component
public class LDAPAuthenticationSuccessHandler {

	private static Logger log = LogManager.getLogger(LDAPAuthenticationSuccessHandler.class);

	@Autowired
	private SysAccountService sysAccountService;
	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public void onAuthenticationSuccess(String userName, String password) throws Exception {
		SysAccount sysAccount = new SysAccount();
		sysAccount.setUserName(userName);

		List<SysAccount> accountList = sysAccountService.queryBySysAccount(sysAccount);
		if (accountList != null && accountList.size() > 0) {
			log.debug("帳號已存在：" + userName);
			return;
		}

		this.insertDefaultAccountData(userName, password);
		log.debug("帳號已新增：" + userName);
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @throws Exception
	 */
	public void insertDefaultAccountData(String userName, String password) throws Exception {

		Date entrydate = new Date();
		SysAccount sysAccount = new SysAccount();
		sysAccount.setUserId(userName);
		sysAccount.setUserName(userName);
		// sysAccount.setPassword(password);
		// sysAccount.setCrtDate(entrydate);
		sysAccount.setUserRole(this.getDefaultRole());
		// sysAccount.setAreaid(areaid);
		// sysAccount.setCrtUserid(userName);
		// sysAccount.setDeptid(deptid);
		// sysAccount.setEnableMark(enableMark);
		// sysAccount.setEntryDate(entrydate);
		// sysAccount.setEntryUserid(userName);
		// sysAccount.setError(error);
		// sysAccount.setMail(mail);
		// sysAccount.setStatus(status);
		sysAccountService.insert(sysAccount);
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getDefaultRole() throws Exception {

		SysRole sysRole = new SysRole();
		sysRole.setDefRoleFlg("Y");
		List<SysRole> roleList = sysRoleService.queryBySysRole(sysRole);
		// 資料庫應只有1筆
		if (roleList == null || roleList.size() == 0) {
			throw new Exception("資料庫未設定預設Role");
		}

		String userRole = roleList.get(0).getUserRole();

		return userRole;
	}

}
