package com.asi.mechanism.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.asi.json.model.root.JsonBean;
import com.asi.mechanism.Log2LogService;
import com.asi.mechanism.common.SysEnum;
import com.asi.mechanism.security.jwtref.JwtResponse;
import com.asi.mechanism.security.jwtref.JwtTokenUtil;
import com.asi.swissknife.Asiutil;
import com.asi.swissknife.Cache;
import com.asi.swissknife.CacheAccount;

@Lazy
@RequestMapping("authorization")
@RestController
public class JwtAuthorizationController {

	private static Logger log = LogManager.getLogger(JwtAuthorizationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/**
	 * authentication token(JWT) to user client
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/authen", method = RequestMethod.POST, consumes = { "application/x-www-form-urlencoded" })
	@ResponseBody
	public ResponseEntity<?> authen(@RequestParam(value = "username", required = false) String userId,
			@RequestParam(value = "password", required = false) String password) {
		try {
			Date start = new Date();

			try {
				Thread.sleep(2000L);// delay request for security
				Authentication res = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
			} catch (Exception authEx) {
				log.debug(authEx.getMessage());
				StackTraceElement el = Thread.currentThread().getStackTrace()[1];
				String uniqueid = el.getClassName() + "-" + el.getMethodName() + "(...)";
				Log2LogService.logExcpt(uniqueid, authEx);
				return new ResponseEntity<>(new JsonBean(), HttpStatus.UNAUTHORIZED);
			}

//			if (res.isAuthenticated() == true) {
//				log.debug("Authenticated a token : ok");
//			} else {
//				throw new Exception("isAuthenticated is false!");
//			}

			try {
				// ???????????????????????????????????????????????????????????????????????????????????????refreshtoken
				UserDetails userDetails = userDetailsService.loadUserByUsername(userId);

//				List<AsiAccount> UsermanageList = asiAccountService.queryAll();
//				
//				for (AsiAccount Usermanage : UsermanageList) {
//					if (username.equals(Usermanage.getUserid())) {
////					if (Usermanage.getEnable().equals("2")) {
////						return new ResponseEntity<>(new JsonBean(), HttpStatus.INTERNAL_SERVER_ERROR);
////					}
//					}
//				}

				String token = jwtTokenUtil.generateToken(userDetails);
				String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails);

				// ???????????????????????????
				List<CacheAccount> cacheAccList = Cache.cacheAccountListGlobal.stream()
						.filter(acc -> userId.equals(acc.getUserId())).collect(Collectors.toList());

				// refresh token????????????????????????????????????????????????????????????
				if (cacheAccList.size() == 1) {
					cacheAccList.get(0).setRefreshToken(refreshToken);
				}

//				log.debug("user_token:" + token);
//				return ResponseEntity.ok(new JwtResponse(token));
				JsonBean jsonBean = new JsonBean();
				jsonBean.setData(new JwtResponse(token, refreshToken));
				return new ResponseEntity<>(jsonBean, HttpStatus.OK);
			} catch (Exception authEx) {
				log.debug(authEx.getMessage());
				StackTraceElement el = Thread.currentThread().getStackTrace()[1];
				String uniqueid = el.getClassName() + "-" + el.getMethodName() + "(...)";
				Log2LogService.logExcpt(uniqueid, authEx);
				return new ResponseEntity<>(new JsonBean(), HttpStatus.UNAUTHORIZED);
			} finally {
				Date end = new Date();
				Asiutil util = new Asiutil();
				String startstr = util.processDateToString(start, "yyyyMMddHHmmssS");
				String endstr = util.processDateToString(end, "yyyyMMddHHmmssS");
				log.debug("login-user_id:" + userId + " start_time:" + startstr + "-end_time:" + endstr);
			}
		} catch (Exception e) {
			StackTraceElement el = Thread.currentThread().getStackTrace()[1];
			String uniqueid = el.getClassName() + "-" + el.getMethodName() + "(...)";
			Log2LogService.logExcpt(uniqueid, e);
			return new ResponseEntity<>(new JsonBean(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * check current token on client
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping("/checktoken")
	@ResponseBody
	public ResponseEntity<?> checkToken(@RequestParam(name = "token", required = true) String token) {
		JsonBean jsonBean = new JsonBean();
		try {
			/**
			 * XXX JWT???????????????????????????????????????????????????????????????????????????????????????Spring boot??????????????????...
			 * 
			 * ??????????????????component scan???????????????????????????
			 */
			String username = jwtTokenUtil.getUsernameFromToken(token);
			log.debug("usename:" + username + " " + "decrypt token success");
			jsonBean.setStatus(SysEnum.statusSuccess.code);
			jsonBean.setMessage("token_availabled");
		} catch (Exception e) {
			jsonBean.setMessage(e.toString());
			StackTraceElement el = Thread.currentThread().getStackTrace()[1];
			String uniqueid = el.getClassName() + "-" + el.getMethodName() + "(...)";
			Log2LogService.logExcpt(uniqueid, e);
			return new ResponseEntity<>(new JsonBean(), HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(jsonBean, HttpStatus.OK);
	}

	/**
	 * authentication token(JWT) to user client
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/authen/refresh", method = RequestMethod.POST, consumes = {
			"application/x-www-form-urlencoded" })
	@ResponseBody
	public ResponseEntity<?> refreshAuthen(
			@RequestParam(value = "refreshToken", required = false) String refreshToken) {
		try {
			Date start = new Date();

			try {
				Thread.sleep(2000L);// delay request for security

				// ??????refreshtoken????????????
				try {
					boolean expired = jwtTokenUtil.validateTimeOfTokenAfterNow4RefreshToken(refreshToken);
					log.debug("refresh token is expired!");
				} catch (Exception e) {
					StackTraceElement el = Thread.currentThread().getStackTrace()[1];
					String uniqueid = el.getClassName() + "-" + el.getMethodName() + "(...)";
					JsonBean jsonBean = new JsonBean();
					jsonBean.setStatus(SysEnum.statusError.context);
					jsonBean.setMessage("refresh token is expired");
					return new ResponseEntity<>(jsonBean, HttpStatus.UNAUTHORIZED);
				}

				// ??????refreshToken???????????????????????????
				List<CacheAccount> cacheAccList = Cache.cacheAccountListGlobal.stream()
						.filter(acc -> refreshToken.equals(acc.getRefreshToken())).collect(Collectors.toList());

				// ??????????????????
				if (cacheAccList == null || cacheAccList.size() != 1) {
					log.debug("retrieve userid with refreshtoken have serious error, we cant find data!");
					StackTraceElement el = Thread.currentThread().getStackTrace()[1];
					String uniqueid = el.getClassName() + "-" + el.getMethodName() + "(...)";
					return new ResponseEntity<>(new JsonBean(), HttpStatus.UNAUTHORIZED);
				}

				// ?????????token
				String userId = cacheAccList.get(0).getUserId();
				UserDetails userDetails = userDetailsService.loadUserByUsername(userId);

				String token = jwtTokenUtil.generateToken(userDetails);

				// ?????????token?????????cache???
				Cache.cacheAccountListGlobal.stream().filter(acc -> refreshToken.equals(acc.getRefreshToken()))
						.forEach(acc -> acc.setAccessToken(token));

				JsonBean jsonBean = new JsonBean();
				jsonBean.setData(new JwtResponse(token, refreshToken));
				return new ResponseEntity<>(jsonBean, HttpStatus.OK);
			} catch (Exception authEx) {
				log.debug(authEx.getMessage());
				StackTraceElement el = Thread.currentThread().getStackTrace()[1];
				String uniqueid = el.getClassName() + "-" + el.getMethodName() + "(...)";
				Log2LogService.logExcpt(uniqueid, authEx);
				return new ResponseEntity<>(new JsonBean(), HttpStatus.UNAUTHORIZED);
			} finally {
				Date end = new Date();
				Asiutil util = new Asiutil();
				String startstr = util.processDateToString(start, "yyyyMMddHHmmssS");
				String endstr = util.processDateToString(end, "yyyyMMddHHmmssS");
				log.debug("refreshToken:" + refreshToken + " start_time:" + startstr + "-end_time:" + endstr);
			}
		} catch (Exception e) {
			StackTraceElement el = Thread.currentThread().getStackTrace()[1];
			String uniqueid = el.getClassName() + "-" + el.getMethodName() + "(...)";
			Log2LogService.logExcpt(uniqueid, e);
			return new ResponseEntity<>(new JsonBean(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
