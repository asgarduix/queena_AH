package com.asi.huanan.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asi.json.model.Checktoken;
import com.asi.mechanism.SpringProperty;
import com.asi.mechanism.common.SysEnum;
import com.asi.swissknife.Asiutil;

@Lazy
//@RequestMapping("//")
@RequestMapping("frontendah")
@Controller
public class FrontendController {

	private static Logger log = LogManager.getLogger(FrontendController.class);

	/**
	 * @RequestMapping context in value，be same with method name and return value of
	 *                 var
	 * @param var1
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		log.info("go_to_login!");
		return "public/login";
	}

	/**
	 * 
	 * XXX
	 * 考慮看看要不要每次都檢核token?(annotation可以設定@RequestMapping("/{directUrl}/{token}")?)
	 * 
	 * @param directUrl
	 * @return
	 */
	@RequestMapping("/{directUrl}")
	public String directUrl(@PathVariable(value = "directUrl", required = true) String directUrl) {
		return "public/" + directUrl;
	}

	/**
	 * @RequestMapping context in value，be same with method name and return value of
	 *                 var
	 * @param var1
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dpsfrontend", method = RequestMethod.POST, consumes = {
			"application/x-www-form-urlencoded" })
//	@RequestMapping("/dpsfrontend")
	public String dpsfrontend(@RequestParam(name = "token", required = true) String token) {
		log.debug("go_to_dayu!");
		log.debug("token!:" + token);
		return "public/dpsfrontend";
	}

	/**
	 * @RequestMapping context in value，be same with method name and return value of
	 *                 var
	 * @param var1
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loading", method = RequestMethod.POST, consumes = { "application/x-www-form-urlencoded" })
//	@RequestMapping("/dpsfrontend")
	public String loading(@RequestParam(name = "token", required = true) String token) {
		try {
			// 使用token檢核，自己呼叫自己的api
			Asiutil util = new Asiutil();
			Map<String, String> conditionMap = Arrays.asList(new String[][] { { "token", token } }).stream()
					.collect(Collectors.toMap(s -> s[0], s -> s[1]));

			Checktoken res = util.fetchPostMethdRestfulEncodeParam(
					SpringProperty.getApiDomainFrontendWithSuffix() + "/authorization/checktoken", null, conditionMap,
					null, Checktoken.class);

			if (SysEnum.statusSuccess.code.equals(res.getStatus()) == false) {
				log.debug(">>>fail request to checktoken, pls check to your token<<<");
				return "public/login";
			}

			log.debug("token!:" + token);
		} catch (Exception e) {
			log.debug(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
			return "public/login";
		}
		return "public/loading";
	}

	/**
	 * @RequestMapping context in value，be same with method name and return value of
	 *                 var
	 * @param var1
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index2() {
		try {
			log.debug("go_to_dayu!");
		} catch (Exception e) {
			log.debug(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
			return "public/login";
		}
		return "public/index";
	}

}
