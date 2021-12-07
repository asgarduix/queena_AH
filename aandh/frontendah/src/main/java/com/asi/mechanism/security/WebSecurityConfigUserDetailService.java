package com.asi.mechanism.security;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.asi.huanan.service.SysAccountService;
import com.asi.huanan.service.dao.mybatis.model.SysAccount;
import com.asi.swissknife.Cache;
import com.asi.swissknife.CacheAccount;
import com.asi.swissknife.EncryptAES;

@Service
public class WebSecurityConfigUserDetailService implements UserDetailsService {

	private static Logger log = LogManager.getLogger(WebSecurityConfigUserDetailService.class);

	@Autowired
	private SysAccountService asiAccountService;

	/**
	 * 
	 */
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		try {
			// 如果暫存資料有存則使用暫存資料，此因為token機制會持續和資料庫溝通，故這邊改使用暫存
			// 概念上現應該針對refresh token的處理
			if (Cache.cacheAccountListGlobal.size() != 0) {
				log.debug(">>>token_authorization_with_cache<<<");

				// 確認有無帳號
				List<CacheAccount> tmpList = Cache.cacheAccountListGlobal.stream()
						.filter(bean -> userid.equals(bean.getUserId())).collect(Collectors.toList());

				if (tmpList != null && tmpList.size() == 1) {// 理論上僅一筆
					CacheAccount cacheAccount = tmpList.get(0);

					String useracccount = cacheAccount.getUserId();
					String password = null;

					// 初始帳號和密碼
					try {
						String userpwd = EncryptAES.decrypt(cacheAccount.getPassword());
						// TODO 可以直接使用特定演算法資料放到套件嗎?
						password = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userpwd);
					} catch (Exception e) {
						throw new UsernameNotFoundException("decode_passwd_have_exception");
					}

					// 設定User物件
					User user = new User();
					user.setName(useracccount);
					user.setPassword(password);

					// Authorization username and passwd with AuthenticationManager
					WebSecurityConfigUserPrincipal principalRes = new WebSecurityConfigUserPrincipal(user);
					return principalRes;
				} else {
					log.debug(">>>token_authorization_with_cache-fail:tmpList:" + tmpList + "，size:" + tmpList.size());
				}
			}

			// 和資料庫取得帳號資料
			log.debug(">>>token_authorization_with_database<<<");

			SysAccount sysAccount = new SysAccount();
			sysAccount.setUserId(userid);
			List<SysAccount> usermanageList = this.asiAccountService.queryBySysAccount(sysAccount);
//			log.debug("user_name:" + userid + ", " + "size:" + usermanageList.size());

			if (usermanageList == null || usermanageList.size() == 0) {
				throw new UsernameNotFoundException(userid);
			}

			SysAccount usermanage = usermanageList.get(0);// 可能有多筆資料，這邊取一筆即可
			String userAccount = usermanage.getUserId();
			String password = null;

			// 初始帳號和密碼
			try {
				String userpwd = EncryptAES.decrypt(usermanage.getPassword());
				// TODO 可以直接使用特定演算法資料放到套件嗎?
				password = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userpwd);
			} catch (Exception e) {
				throw new UsernameNotFoundException("decode_passwd_have_exception");
			}

			if (password == null) {
				throw new UsernameNotFoundException("decode_passwd_have_exception");
			}

			// 設定User物件
			User user = new User();
			user.setName(userAccount);
			user.setPassword(password);

			// Authorization username and passwd with AuthenticationManager
			WebSecurityConfigUserPrincipal principalRes = new WebSecurityConfigUserPrincipal(user);

			// 以上完成，將資料暫存
			List<CacheAccount> tmpList = usermanageList.stream()
					.map(bean -> new CacheAccount().setUserId(bean.getUserId()).setPassword(bean.getPassword()))
					.collect(Collectors.toList());
			Cache.cacheAccountListGlobal.addAll(tmpList);

			return principalRes;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new UsernameNotFoundException("WebSecurityConfigUserPrincipal@Spring_framework is null");
		}
	}

//	@Autowired
//	private UsermanageService usermanageService;
//
//	/**
//	 * 
//	 */
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		List<Usermanage> usermanageList = this.usermanageService.findByuseraccount(username);
//
//		if (usermanageList == null || usermanageList.size() == 0) {
//			throw new UsernameNotFoundException(username);
//		}
//
//		Usermanage usermanage = usermanageList.get(0);// 可能有多筆資料，這邊取一筆即可
//		String userAccount = usermanage.getUseraccount();
//		String password = null;
//
//		// 初始帳號和密碼
//		try {
//			String userpwd = EncryptAES.decrypt(usermanage.getUserpwd());
//			// TODO 可以直接使用特定演算法資料放到套件嗎?
//			password = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userpwd);
//		} catch (Exception e) {
//			throw new UsernameNotFoundException("decode_passwd_have_exception");
//		}
//
//		if (password == null) {
//			throw new UsernameNotFoundException("decode_passwd_have_exception");
//		}
//
//		// 設定User物件
//		User user = new User();
//		user.setName(userAccount);
//		user.setPassword(password);
//
//		// Authorization username and passwd with AuthenticationManager
//		WebSecurityConfigUserPrincipal principal = new WebSecurityConfigUserPrincipal(user);
//		return principal;
//	}

}
