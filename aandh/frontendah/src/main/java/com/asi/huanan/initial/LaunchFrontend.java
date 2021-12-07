package com.asi.huanan.initial;

import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.asi.mechanism.SpringProperty;
import com.asi.mechanism.security.jwtref.JwtRequestFilter;

@SpringBootApplication
@ComponentScan({ "com.asi.huanan.controller" + "," + "com.asi.huanan.controller.api" + ","
		+ "com.asi.huanan.controller.api.common" + "," + "com.asi.huanan.schedule" + "," + "com.asi.huanan.schedule.job"
		+ "," + "com.asi.huanan.service" + "," + "com.asi.huanan.service" + "," + "com.asi.huanan.service.connector"
		+ "," + "com.asi.huanan.service.dao" + "," + "com.asi.huanan.service.dao.mybatis.mapper" + ","
		+ "com.asi.huanan.service.dao.mybatis.model" + "," + "com.asi.huanan.service.repository" + ","
		+ "com.asi.mechanism" + "," + "com.asi.mechanism.controller" + "," + "com.asi.mechanism.security" + ","
		+ "com.asi.mechanism.security.acc" + "," + "com.asi.mechanism.security.jwtref" + ","
		+ "com.asi.mechanism.handler" })
public class LaunchFrontend extends SpringBootServletInitializer {

	/**
	 * allocate this class to spring boot
	 */
	private static Class<LaunchFrontend> controller = LaunchFrontend.class;

	/**
	 * override method in SpringBootServletInitializer
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(controller);
	}

	/**
	 * Spring main method to execute for initial
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(LaunchFrontend.class, args);

		// 設定共用的專案中Filter變數
		JwtRequestFilter.projectName = SpringProperty.getProjectName();
		JwtRequestFilter.setReserve4Regex(List.of(("/" + SpringProperty.getProjectName() + "/loading"),
				("/" + SpringProperty.getProjectName() + "/index")));
		JwtRequestFilter.setReserve4Regex(
				List.of("^(/" + SpringProperty.getProjectName() + "([A-Za-z]*))((/.+)+)", "/asisysapi/" + ".+"));
		// TODO 蒐集Controller的anootation，再放到這個設定中?
		// "^(/([A-Za-z]*))((/.+)+)"));// TODO 設定錯誤，會將所有資源也鎖住

		// print params of application.yaml
//		System.out.println("=====");
//		List<String> nmList = Arrays.asList(SpringProperty.class.getDeclaredFields()).stream().map(s -> s.getName())
//				.collect(Collectors.toList());
//		nmList.stream().forEach(nm -> {
//			try {
//				System.out.println(nm + ":" + SpringProperty.class.getDeclaredField(nm).get(nm));
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchFieldException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SecurityException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
//		System.out.println("=====");
	}
}
