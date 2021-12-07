package com.asi.huanan.service.dao.mybatis.model.customerize;

import java.util.Date;

public class InsEndorseQueryTable {

	/**
	 * 申請單號
	 */
	private String applno;
	
	/**
	 * 保單號碼/強制證號
	 */
	private String polyn2;
	
	/**
	 * 被保險人名稱
	 */
	private String wname1;

	/**
	 * 被保險人ID
	 */
	private String widnum;
	
	/**
	 * 要保險人名稱
	 */
	private String getnam;
	
	/**
	 * 要保險人ID
	 */
	private String getidn;

	/**
	 * 車號
	 */
	private String wlicno;
	
	/**
	 * 保險起日
	 */
	private Date windat;
	
	/**
	 * 保險迄日
	 */
	private Date wexdat;

	/**
	 * 保源
	 */
	private String inssrc;

	/**
	 * 經手人
	 */
	private String solin1;

	/**
	 * 洽攬人
	 */
	private String bkcod1;
	
	/**
	 * 批單張數
	 */
	private String prttim;
	
	/**
	 * 狀態
	 */
	private String yenpro;
	
	

	public String getApplno() {
		return applno;
	}

	public void setApplno(String applno) {
		this.applno = applno;
	}

	public String getPolyn2() {
		return polyn2;
	}

	public void setPolyn2(String polyn2) {
		this.polyn2 = polyn2;
	}

	public String getWname1() {
		return wname1;
	}

	public void setWname1(String wname1) {
		this.wname1 = wname1;
	}

	public String getWidnum() {
		return widnum;
	}

	public void setWidnum(String widnum) {
		this.widnum = widnum;
	}

	public String getWlicno() {
		return wlicno;
	}

	public void setWlicno(String wlicno) {
		this.wlicno = wlicno;
	}

	public Date getWindat() {
		return windat;
	}

	public void setWindat(Date windat) {
		this.windat = windat;
	}

	public Date getWexdat() {
		return wexdat;
	}

	public void setWexdat(Date wexdat) {
		this.wexdat = wexdat;
	}

	public String getInssrc() {
		return inssrc;
	}

	public void setInssrc(String inssrc) {
		this.inssrc = inssrc;
	}

	public String getSolin1() {
		return solin1;
	}

	public void setSolin1(String solin1) {
		this.solin1 = solin1;
	}

	public String getBkcod1() {
		return bkcod1;
	}

	public void setBkcod1(String bkcod1) {
		this.bkcod1 = bkcod1;
	}

	public String getPrttim() {
		return prttim;
	}

	public void setPrttim(String prttim) {
		this.prttim = prttim;
	}

	public String getYenpro() {
		return yenpro;
	}

	public void setYenpro(String yenpro) {
		this.yenpro = yenpro;
	}

	public String getGetnam() {
		return getnam;
	}

	public void setGetnam(String getnam) {
		this.getnam = getnam;
	}

	public String getGetidn() {
		return getidn;
	}

	public void setGetidn(String getidn) {
		this.getidn = getidn;
	}

}
