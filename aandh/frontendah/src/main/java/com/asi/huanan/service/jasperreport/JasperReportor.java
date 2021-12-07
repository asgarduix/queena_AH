package com.asi.huanan.service.jasperreport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class JasperReportor {
	
	private Log log = LogFactory.getLog(JasperReportor.class);
	
	/**
	 * 網頁顯示PDF檔
	 * @param response
	 * @param parameters
	 * @param datasource
	 * @param jrxmlPath
	 */
	public void createPdfStream(HttpServletResponse response, Map<String, Object> parameters, List<?> datasource, String jrxmlPath) {
		
		try {
			ServletOutputStream os = response.getOutputStream();
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datasource);
			JasperPrint print = JasperFillManager.fillReport(jasperReport,parameters,ds);
			JasperExportManager.exportReportToPdfStream(print,os);
		} catch (JRException e) {
			log.debug(e.toString());
		} catch (IOException e) {
			log.debug(e.toString());
		}
	}
	
	/**
	 * 產生PDF檔案
	 * @param targetPath
	 * @param parameters
	 * @param datasource
	 * @param jrxmlPath
	 * @return String
	 */
	public String createPdfFile(String targetPath,String fileName, List<?> sourceData, String jrxmlPath, Map<String, Object> parameters) {
		
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(sourceData);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, targetPath + "\\" + fileName + ".pdf");
		} catch (JRException e) {
			log.debug(e.toString());
		}
		return "Report successfully generated @path= " + targetPath;
	}
}
