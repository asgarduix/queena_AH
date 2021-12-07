package com.asi.huanan.service.dao.mybatis.model.customerize;

public class SubInsurance {
	/**
	 * 險種代號
	 */
	private String insMapping;
	/**
	 * 險種名稱
	 */
	private String consho;

	public String getInsMapping() {
		return insMapping;
	}

	public void setInsMapping(String insMapping) {
		this.insMapping = insMapping;
	}

	public String getConsho() {
		return consho;
	}

	public void setConsho(String consho) {
		this.consho = consho;
	}

}
