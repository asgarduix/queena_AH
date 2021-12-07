package com.asi.huanan.schedule.job;

import java.util.Arrays;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import com.asi.mechanism.Log2LogService;
import com.asi.swissknife.Cache;

public class Job4CleanCache implements Job {
	/**
	 * 主要邏輯處理
	 */
	public static String jobName = "JOB_MAIN_PROCESS";
	public static String cronDefine = "0/5 0 0/3 * * ?";// 整點每五分鐘
//	public static String cronDefine = "0/30 * * * * ?";// 整點每分鐘30秒
	private static Logger log = LogManager.getLogger(Job4CleanCache.class);

	/**
	 * 
	 */
	@Override
	public void execute(JobExecutionContext context) {
		log.debug("dpssystembatch-job1_" + cronDefine + "-" + new Date());

		try {
			Cache.jsonMap.clear();// 清除rest api的暫存資料
			Cache.cacheAccountListGlobal.clear();// 清除暫存帳戶資料
			log.debug("we will clean cacche of fetch rest api, succ");
		} catch (Exception e) {
			log.debug("we will clean cacche of fetch rest api, fail");
			StackTraceElement el = Thread.currentThread().getStackTrace()[1];
			String uniqueid = el.getClassName() + "-" + el.getMethodName() + "(...)";
			log.info(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(subEx -> log.debug(subEx));
			Log2LogService.logExcpt(uniqueid, e);
		}
	}

}