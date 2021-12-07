package com.asi.mechanism;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.asi.mechanism.common.SysEnum;

@Component
public class SpringProperty {
	/**
	 * retrieve parameters of spring boot from property file
	 */

	private static Logger log = LogManager.getLogger(SpringProperty.class);
	public static String siteUrlDev;
	public static String sitePortDev;
	public static String siteUrlProd;
	public static String sitePortProd;
	public static String projectName;

	@Value("${environments.project.name}")
	public void setProjectName(String projectName) {
		SpringProperty.projectName = projectName;
	}

	@Value("${environments.prod.url}")
	public void setSiteUrlProd(String siteUrl) {
		SpringProperty.siteUrlProd = siteUrl;
	}

	@Value("${server.port}")
	public void setSitePortProd(String sitePort) {
		SpringProperty.sitePortProd = sitePort;
	}

	@Value("${environments.dev.url}")
	public void setSiteUrlDev(String siteUrl) {
		SpringProperty.siteUrlDev = siteUrl;
	}

	@Value("${server.port}")
	public void setSitePortDev(String sitePort) {
		SpringProperty.sitePortDev = sitePort;
	}

	public static String getProjectName() {
		return projectName;
	}

	public static String getSiteUrlProd() {
		return SpringProperty.siteUrlProd;
	}

	public static String getSitePortProd() {
		return SpringProperty.sitePortProd;
	}

	public static String getSiteUrlDev() {
		return SpringProperty.siteUrlDev;
	}

	public static String getSitePortDev() {
		return SpringProperty.sitePortDev;
	}

	/**
	 * 
	 */
	public SpringProperty() {

	}

	@PostConstruct
	public void init() {
		Class<? extends SpringProperty> clazz = this.getClass();

		List<String> props = Arrays.asList(clazz.getFields()).stream().map(filed -> {
			String name = filed.getName();
			String getMethod = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
			Object val = null;

			try {
				val = clazz.getMethod(getMethod).invoke(this);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				log.info(e.toString());
				Arrays.asList(e.getStackTrace()).stream().forEach(sub -> System.out.println(sub.toString()));
				return "name:" + "{have_exception}";
			}

			// 參數為字串資料，先轉字串即可
			return name + ":" + String.valueOf(val);
		}).collect(Collectors.toList());

		String propStr = props.stream().collect(Collectors.joining(", "));
		log.debug("initial_to_load_properties-" + propStr);
	}

	/**
	 * apis url(get*WithSuffix(...))
	 */
	public static String apiDomainlog;
	public static String apiDomaincallrest;
	public static String apiDomainrainwarning;
	public static String apiDomainwaterwarning;
	public static String apiDomainsystembatch;
	public static String apiDomainfrontend;
	public static String apiDomainsystemconfig;
	public static String apiDomaininformixapi;

	public static String getApiDomainlog() {
		return apiDomainlog;
	}

	@Value("${spring.api.domain.log}")
	public void setApiDomainlog(String apiDomainlog) {
		SpringProperty.apiDomainlog = apiDomainlog;
	}

	public static String getApiDomaincallrest() {
		return apiDomaincallrest;
	}

	@Value("${spring.api.domain.callrest}")
	public void setApiDomaincallrest(String apiDomaincallrest) {
		SpringProperty.apiDomaincallrest = apiDomaincallrest;
	}

	public static String getApiDomainrainwarning() {
		return apiDomainrainwarning;
	}

	@Value("${spring.api.domain.rainwarning}")
	public void setApiDomainrainwarning(String apiDomainrainwarning) {
		SpringProperty.apiDomainrainwarning = apiDomainrainwarning;
	}

	public static String getApiDomainwaterwarning() {
		return apiDomainwaterwarning;
	}

	@Value("${spring.api.domain.waterwarning}")
	public void setApiDomainwaterwarning(String apiDomainwaterwarning) {
		SpringProperty.apiDomainwaterwarning = apiDomainwaterwarning;
	}

	public static String getApiDomainsystembatch() {
		return apiDomainsystembatch;
	}

	@Value("${spring.api.domain.systembatch}")
	public void setApiDomainsystembatch(String apiDomainsystembatch) {
		SpringProperty.apiDomainsystembatch = apiDomainsystembatch;
	}

	public static String getApiDomainFrontend() {
		return apiDomainfrontend;
	}

	@Value("${spring.api.domain.frontend}")
	public void setApiDomainwarningweb(String apiDomainfrontend) {
		SpringProperty.apiDomainfrontend = apiDomainfrontend;
	}

	public static String getApiDomainsystemconfig() {
		return apiDomainsystemconfig;
	}

	@Value("${spring.api.domain.systemconfig}")
	public void setApiDomainsystemconfig(String apiDomainsystemconfig) {
		SpringProperty.apiDomainsystemconfig = apiDomainsystemconfig;
	}
	
	public static String getApiDomaininformixapi() {
		return apiDomaininformixapi;
	}

	@Value("${spring.api.domain.informixapi}")
	public void setApiDomaininformixapi(String apiDomaininformixapi) {
		SpringProperty.apiDomaininformixapi = apiDomaininformixapi;
	}

	public static String getApiDomainsystemconfigWithSuffix() {
		return SysEnum.prefix4Restful1.context + apiDomainsystemconfig;
	}

	public static String getApiDomainsystembatchWithSuffix() {
		return SysEnum.prefix4Restful1.context + apiDomainsystembatch;
	}

	public static String getApiDomainlogWithSuffix() {
		return SysEnum.prefix4Restful1.context + apiDomainlog;
	}

	public static String getApiDomaincallrestWithSuffix() {
		return SysEnum.prefix4Restful1.context + apiDomaincallrest;
	}

	public static String getApiDomainrainwarningWithSuffix() {
		return SysEnum.prefix4Restful1.context + apiDomainrainwarning;
	}

	public static String getApiDomainwaterwarningWithSuffix() {
		return SysEnum.prefix4Restful1.context + apiDomainwaterwarning;
	}

	public static String getApiDomainFrontendWithSuffix() {
		return SysEnum.prefix4Restful1.context + apiDomainfrontend;
	}
	
	public static String getApiDomaininformixapiWithSuffix() {
		return SysEnum.prefix4Restful1.context + apiDomaininformixapi;
	}
	
	public static String activeStatus;
	
	@Value("${spring.profiles.active}")
	public void setActiveStatus(String activeStatus) {
		SpringProperty.activeStatus = activeStatus;
	}

	public static String getActiveStatus() {
		return activeStatus;
	}
	
	public static String uploadURL;

	@Value("${path.url}")
	public void setUploadURL(String uploadURL) {
		SpringProperty.uploadURL = uploadURL;
	}
	
	public static String getUploadURL() {
		return uploadURL;
	}
	
	/**
	 * mailServer
	 */
	
	public static String mailUsername;
	public static String mailPassword;
	public static String mailHost;
	public static int mailPort;
	public static String mailAuth;
	public static String mailStarttlsEnable;
	
	
	@Value("${mailServer.username}")
	public void setMailUsername(String mailUsername) {
		SpringProperty.mailUsername = mailUsername;
	}

	public static String getMailUsername() {
		return mailUsername;
	}
	
	@Value("${mailServer.password}")
	public void setMailPassword(String mailPassword) {
		SpringProperty.mailPassword = mailPassword;
	}

	public static String getMailPassword() {
		return mailPassword;
	}
	
	@Value("${mailServer.host}")
	public void setMailHost(String mailHost) {
		SpringProperty.mailHost = mailHost;
	}

	public static String getMailHost() {
		return mailHost;
	}
	
	@Value("${mailServer.port}")
	public void setMailPort(int mailPort) {
		SpringProperty.mailPort = mailPort;
	}

	public static int getMailPort() {
		return mailPort;
	}
	
	@Value("${mailServer.auth}")
	public void setMailAuth(String mailAuth) {
		SpringProperty.mailAuth = mailAuth;
	}

	public static String getMailAuth() {
		return mailAuth;
	}
	
	@Value("${mailServer.starttlsEnable}")
	public void setMailStarttlsEnable(String mailStarttlsEnable) {
		SpringProperty.mailStarttlsEnable = mailStarttlsEnable;
	}

	public static String getMailStarttlsEnable() {
		return mailStarttlsEnable;
	}

}
