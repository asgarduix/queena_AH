package com.asi.mechanism.security;

import java.util.Arrays;
import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.asi.huanan.controller.FrontendController;

@Component
public class LDAPAuthentication {

	private static Logger log = LogManager.getLogger(LDAPAuthentication.class);

	@Autowired
	LDAPAuthenticationSuccessHandler lDAPAuthenticationSuccessHandler;

	@Value("${ldap.urls}")
	private String ldapUrls;
	@Value("${ldap.base.dn}")
	private String ldapBaseDn;
	@Value("${ldap.factory}")
	private String ldapFactory;

	/*
	 * private String ldapUrls = "ldap://192.168.5.209:389/"; private String
	 * ldapBaseDn = "ou=Users_Java,dc=asgard,dc=test,dc=com"; private String
	 * ldapFactory = "com.sun.jndi.ldap.LdapCtxFactory";
	 */

	/**
	 * 
	 * @param userName
	 * @param password
	 */
	public String ldapConnect(String username, String password) {

		LdapContext ctx = null;
		Control[] connCtls = null;

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, ldapFactory);
		env.put(Context.PROVIDER_URL, ldapUrls + ldapBaseDn);
		env.put(Context.SECURITY_PRINCIPAL, username);
		env.put(Context.SECURITY_CREDENTIALS, password);

		try {
			ctx = new InitialLdapContext(env, connCtls);

			lDAPAuthenticationSuccessHandler.onAuthenticationSuccess(username, password);

			log.debug("認證成功");
			log.debug("LdapContext：" + ctx);
			return "認證成功";
		} catch (AuthenticationException e) {
			log.debug("認證失敗!");
			log.debug(e.toString());
			return "認證失敗!";
		} catch (javax.naming.CommunicationException e) {
			log.debug("AD連線失敗!");
			log.debug(e.toString());
			return "AD連線失敗!";
		} catch (Exception e) {
			log.debug("認證異常!");
			log.debug(e.toString());
			Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
			return "認證異常!";
		} finally {
			if (null != ctx) {
				try {
					ctx.close();
					ctx = null;
				} catch (NamingException e) {
					log.debug(e.toString());
					Arrays.asList(e.getStackTrace()).stream().forEach(sube -> log.debug(sube.toString()));
				}
			}
		}
	}
}
