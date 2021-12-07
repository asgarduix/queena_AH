package com.asi.mechanism;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.asi.mechanism.common.LogBean;
import com.asi.mechanism.common.LogJson;
import com.asi.mechanism.common.SysEnum;
import com.asi.swissknife.Asiutil;
import com.google.gson.Gson;

public class Log2LogService {
	/**
	 * 
	 */
	private static Logger log = LogManager.getLogger(Log2LogService.class);

	/**
	 * for controller send log to log service
	 * 
	 * @param e
	 */
	public static void logExcpt(String uniqueid, Exception e) {
		// 預防傳送至log service失敗，儲存在pod環境(設定系統環境，可使用mnt將log儲存出來)
		log.info(e.toString());
		Arrays.asList(e.getStackTrace()).stream().forEach(subEx -> log.debug(subEx));
		List<String> logList = Arrays.asList(e.getStackTrace()).stream().map(subex -> subex.toString())
				.collect(Collectors.toList());
		LogJson jsonLog = new LogJson();
		jsonLog.setLogs(logList);

		LogBean beanLog = new LogBean();
		beanLog.setUniqueid(uniqueid);
		beanLog.setCause(e.toString());
		beanLog.setJsonLog(jsonLog);

		log2LogSerType2(SpringProperty.getApiDomainlogWithSuffix() + "/dpslog/logList", beanLog);
	}

	/**
	 * log to log service，因供共用簡單使用，故此共用程式將參數寫死在method實作中
	 * 
	 * @param uniqueid
	 * @param log
	 */
	public static void log2LogSerType2(String logSerUrl, LogBean beanLog) {
		try {
			Gson gson = new Gson();
			String logContext = gson.toJson(beanLog.getJsonLog());
			Asiutil commonAsi = new Asiutil();
			String time = commonAsi.processDateToString(new Date(), "yyyyMMddHHmmssS");

			// TOOD 待參數化

			Map<String, String> conditionMap = new HashMap<>();
			conditionMap.put("uniqueid", beanLog.getUniqueid());
			conditionMap.put("cause", beanLog.getCause());
			conditionMap.put("logContext", logContext);
			conditionMap.put("time", time);

			commonAsi.fetchPostMethdRestful(logSerUrl, null, conditionMap, SysEnum.encodeUtf8.context);
		} catch (Exception e) {
			log.info(e.toString() + "-" + "fail access to log service");
		}
	}
}
