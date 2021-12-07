package com.asi.huanan.service.dao.mybatis.model.customerize;

public class MainInsuranceColumn {
	/**
	 * 險種大分類名稱
	 */
	private String instype;
	
	/**
	 * 大分類代號
	 */
	private String insid;
	
	/**
	 * 主副險代號  1:主險 0:副險
	 */
	private String insmain;
	
	/**
	 * 險種代號
	 */
	private String inscode;
	
	/**
	 * 欄位樣式1 1: 下拉 2: 輸入框 3: 顯示文字
	 */
	private String column1type;
	
	/**
	 * 欄位樣式1代號
	 */
	private String column1code;
	
	/**
	 * 欄位樣式2 1: 下拉 2: 輸入框
	 */
	private String column2type;
	
	/**
	 * 欄位樣式2代號
	 */
	private String column2code;
	
	/**
	 * 欄位樣式3 1: 下拉 2: 輸入框
	 */
	private String column3type;
	
	/**
	 * 欄位樣式3代號
	 */
	private String column3code;
	
	/**
	 * 欄位樣式4 1: 下拉 2: 輸入框
	 */
	private String column4type;
	
	/**
	 * 欄位樣式4代號
	 */
	private String column4code;
	
	/**
	 * 險種名稱
	 */
	private String consho;

	public String getInstype() {
		return instype;
	}

	public void setInstype(String instype) {
		this.instype = instype;
	}

	public String getInsid() {
		return insid;
	}

	public void setInsid(String insid) {
		this.insid = insid;
	}

	public String getInsmain() {
		return insmain;
	}

	public void setInsmain(String insmain) {
		this.insmain = insmain;
	}

	public String getInscode() {
		return inscode;
	}

	public void setInscode(String inscode) {
		this.inscode = inscode;
	}

	public String getColumn1type() {
		return column1type;
	}

	public void setColumn1type(String column1type) {
		this.column1type = column1type;
	}

	public String getColumn1code() {
		return column1code;
	}

	public void setColumn1code(String column1code) {
		this.column1code = column1code;
	}

	public String getColumn2type() {
		return column2type;
	}

	public void setColumn2type(String column2type) {
		this.column2type = column2type;
	}

	public String getColumn2code() {
		return column2code;
	}

	public void setColumn2code(String column2code) {
		this.column2code = column2code;
	}

	public String getColumn3type() {
		return column3type;
	}

	public void setColumn3type(String column3type) {
		this.column3type = column3type;
	}

	public String getColumn3code() {
		return column3code;
	}

	public void setColumn3code(String column3code) {
		this.column3code = column3code;
	}

	public String getColumn4type() {
		return column4type;
	}

	public void setColumn4type(String column4type) {
		this.column4type = column4type;
	}

	public String getColumn4code() {
		return column4code;
	}

	public void setColumn4code(String column4code) {
		this.column4code = column4code;
	}

	public String getConsho() {
		return consho;
	}

	public void setConsho(String consho) {
		this.consho = consho;
	}
	
}
