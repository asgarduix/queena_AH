package com.asi.huanan.service.dao.mybatis.model.customerize;

import java.util.Date;

public class InsBulidQueryTable {

	/**
	 * 保單號碼/強制證號
	 */
	private String polyn2;
	
	/**
	 * 批改申請單號
	 */
	private String applno;

	/**
	 * 批單號
	 */
	private String yendno;
	
	/**
	 * 被保險人名稱
	 */
	private String wname1;

	/**
	 * 要保人名稱
	 */
	private String getnam;

	/**
	 * 被保險人ID
	 */
	private String widnum;

	/**
	 * 要保人ID
	 */
	private String getidn;

	/**
	 * 車號
	 */
	private String wlicno;

	/**
	 * 起保日
	 */
	private Date windat;

	/**
	 * 到期日
	 */
	private Date wexdat;

	/**
	 * 批改種類
	 */
	private String yenpro;

	/**
	 * 建檔狀態
	 */
	private String status;

	/**
	 * 申請狀態說明
	 */
	private String stmsg;
	
	/**
	 * 建檔日
	 */
	private Date builddate;
	
	/**
	 * 建檔人員
	 */
	private String buildmem;
	
	/**
	 * 建檔人員
	 */
	private Date envdat;

	public String getPolyn2() {
		return polyn2;
	}

	public void setPolyn2(String polyn2) {
		this.polyn2 = polyn2;
	}

	public String getApplno() {
		return applno;
	}

	public void setApplno(String applno) {
		this.applno = applno;
	}

	public String getYendno() {
		return yendno;
	}

	public void setYendno(String yendno) {
		this.yendno = yendno;
	}

	public String getWname1() {
		return wname1;
	}

	public void setWname1(String wname1) {
		this.wname1 = wname1;
	}

	public String getGetnam() {
		return getnam;
	}

	public void setGetnam(String getnam) {
		this.getnam = getnam;
	}

	public String getWidnum() {
		return widnum;
	}

	public void setWidnum(String widnum) {
		this.widnum = widnum;
	}

	public String getGetidn() {
		return getidn;
	}

	public void setGetidn(String getidn) {
		this.getidn = getidn;
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

	public String getYenpro() {
		return yenpro;
	}

	public void setYenpro(String yenpro) {
		this.yenpro = yenpro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStmsg() {
		return stmsg;
	}

	public void setStmsg(String stmsg) {
		this.stmsg = stmsg;
	}

	public Date getBuilddate() {
		return builddate;
	}

	public void setBuilddate(Date builddate) {
		this.builddate = builddate;
	}

	public String getBuildmem() {
		return buildmem;
	}

	public void setBuildmem(String buildmem) {
		this.buildmem = buildmem;
	}

	public Date getEnvdat() {
		return envdat;
	}

	public void setEnvdat(Date envdat) {
		this.envdat = envdat;
	}
	
}
