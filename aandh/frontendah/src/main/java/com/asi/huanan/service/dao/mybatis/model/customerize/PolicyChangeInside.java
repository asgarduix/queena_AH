package com.asi.huanan.service.dao.mybatis.model.customerize;

import java.util.Date;

public class PolicyChangeInside {
	
	/**
	 * 批單號碼
	 */
	private String yendno;
    
	/**
	 * 申請日
	 */
    private Date crtdat;

    /**
     * 申請人員
     */
    private String oprnum;

    /**
     * 批改種類
     */
    private String yenpro;
    
    /**
     * 批改原因
     */
    private String reason;

    /**
     * 批單生效日
     */
    private Date envdat;
    
    /**
     * 批單列印日
     */
    private Date prtdat;

    /**
     * 批單列印次數
     */
    private String yretim;

    /**
     * 付款方式
     */
    private String rpayCond;

    /**
     * 自動銷帳註
     */
    private String autpro;
    
    /**
	 * 洗錢列印註
	 */
    private String monchk;

    /**
     * 保險期間(起)
     */
    private Date windat;

    /**
     * 保險期間(迄)
     */
    private Date wexdat;
    
    /**
     * 新承保月份
     */
    private Short wmonth; 
    
    /**
     * 電子保單註
     */
    private String epomak;

    /**
     * 收件經辦人
     */
    private String accopr;

    /**
     * 核保人員一
     */
    private String chkopr1;
    
    /**
     * 核保人員二
     */
    private String chkopr2;
    
    /**
     * 核保人員三
     */
    private String chkopr3;
    
    /**
     * (被)姓名
     */
    private String wnamei;

    /**
     * (被)身份別
     */
    private String wnammk;
    
    /**
     * (被)ID/統編
     */
    private String widnum;
    
    /**
     * (被)代表人
     */
    private String spnrnam1;
    
    /**
     * (被)國籍(批改後國籍註)
     */
    private String wnatmk;
    
    /**
     * 被保險人國別代碼
     */
    private String cntcod;
    
    /**
     * 被保險人國別名稱
     */
    private String cntnam;
    
    /**
     * (被)生日
     */
    private Date wbidat;
    
    /**
     * (被)性別註
     */
    private String wmksex;
    
    /**
     * (被)婚姻註
     */
    private String wmarri;
    
    /**
     * 新通訊郵遞區號
     */
    private String wadren;
    
    /**
     * (被)通訊地址
     */
    private String wmaila;
    
    /**
     * 戶籍郵遞區號
     */
    private String zipcod;
    
    /**
     * (被)戶籍地址
     */
    private String waddre;
    
    /**
     * (被)住宅電話
     */
    private String wteln2;
    
    /**
     * (被)公司電話
     */
    private String wteln1;
    
    /**
     * (被)行動電話
     */
    private String wteln3;
    
    /**
     * (被)E-MAIL
     */
    private String email;
    
    /**
     * (被)行職業代號
     */
    private String jobno;
    
    /**
     * 要/被保險人關係
     */
    private String reltin;
    
    /**
     * 要保人與被保險人關係說明
     */
    private String reltindes;
    
    /**
     * (要)姓名
     */
    private String getnam;
    
    /**
     * (要)ID/統編
     */
    private String getidn;
    
    /**
     * (要)代表人
     */
    private String spnrnam2;
    
    /**
     * (要)國籍
     */
    private String getnat;
    
    /**
     * 要保人國別代碼
     */
    private String getcntc;
    
    /**
     * 要保人國別名稱
     */
    private String getcntn;
    
    /**
     * (要)生日
     */
    private Date getbri;
    
    /**
     * (要)性別註
     */
    private String getsex;
    
    /**
     * 要保人通訊郵遞區號
     */
    private String getano;
    
    /**
     * (要)通訊地址
     */
    private String getadd;
    
    /**
     * 要保人電話
     */
    private String gettel;

    /**
     * (要)行職業代號
     */
    private String getjob;
    
    /**
     * 保源代號
     */
    private String inssrc;
    
    /**
     * 實駐代號
     */
    private String saldep;
    
    /**
     * 專案代號
     */
    private String projec;
    
    /**
     * 行銷活動代碼
     */
    private String campcd;
    
    /**
     * 經手人一
     */
    private String solin1;
    
    /**
     * 經手人二
     */
    private String solin2;
    
    /**
     * 通路聯絡人代號
     */
    private String salcod;
    
    /**
     * 通路聯絡人姓名
     */
    private String salnam;
    
    /**
     * 洽攬人代號一
     */
    private String bkcod1;
    
    /**
     * 通路業務員1登錄證號
     */
    private String pidnum;
    
    /**
     * 通路業務員1名稱
     */
    private String pnamei;
    
    /**
     * 洽攬人代號二
     */
    private String bkcod2;
    
    /**
     * 通路業務員2登錄證號
     */
    private String pidnum2;
    
    /**
     * 通路業務員2名稱
     */
    private String pnamei2;
    
    /**
     * 受理編號
     */
    private String acceptno;
    
    /**
     * 申請編號
     */
    private String applno;
    
    /**
     * 建檔日
     */
    private String builddate;
    
    /**
     * 批單要保號碼
     */
    private String buildno;
    
    /**
     * 建檔人員
     */
    private String buildmem;
    
    /**
     * (要)股權結構複雜
     */
    private String comstk2;
    
    /**
     * (被)非透明公司型態
     */
    private String comtyp1;
    
    /**
     * (要)非透明公司型態
     */
    private String comtyp2;
    
    /**
     * 拖吊註
     */
    private String movmak;

	public String getYendno() {
		return yendno;
	}

	public void setYendno(String yendno) {
		this.yendno = yendno;
	}

	public Date getCrtdat() {
		return crtdat;
	}

	public void setCrtdat(Date crtdat) {
		this.crtdat = crtdat;
	}

	public String getOprnum() {
		return oprnum;
	}

	public void setOprnum(String oprnum) {
		this.oprnum = oprnum;
	}

	public String getYenpro() {
		return yenpro;
	}

	public void setYenpro(String yenpro) {
		this.yenpro = yenpro;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getEnvdat() {
		return envdat;
	}

	public void setEnvdat(Date envdat) {
		this.envdat = envdat;
	}
	
	public Date getPrtdat() {
		return prtdat;
	}

	public void setPrtdat(Date prtdat) {
		this.prtdat = prtdat;
	}

	public String getYretim() {
		return yretim;
	}

	public void setYretim(String yretim) {
		this.yretim = yretim;
	}

	public String getRpayCond() {
		return rpayCond;
	}

	public void setRpayCond(String rpayCond) {
		this.rpayCond = rpayCond;
	}

	public String getAutpro() {
		return autpro;
	}

	public void setAutpro(String autpro) {
		this.autpro = autpro;
	}

	public String getMonchk() {
		return monchk;
	}

	public void setMonchk(String monchk) {
		this.monchk = monchk;
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
	
	public Short getWmonth() {
		return wmonth;
	}

	public void setWmonth(Short wmonth) {
		this.wmonth = wmonth;
	}

	public String getEpomak() {
		return epomak;
	}

	public void setEpomak(String epomak) {
		this.epomak = epomak;
	}

	public String getAccopr() {
		return accopr;
	}

	public void setAccopr(String accopr) {
		this.accopr = accopr;
	}

	public String getChkopr1() {
		return chkopr1;
	}

	public void setChkopr1(String chkopr1) {
		this.chkopr1 = chkopr1;
	}

	public String getChkopr2() {
		return chkopr2;
	}

	public void setChkopr2(String chkopr2) {
		this.chkopr2 = chkopr2;
	}

	public String getChkopr3() {
		return chkopr3;
	}

	public void setChkopr3(String chkopr3) {
		this.chkopr3 = chkopr3;
	}

	public String getWnamei() {
		return wnamei;
	}

	public void setWnamei(String wnamei) {
		this.wnamei = wnamei;
	}

	public String getWnammk() {
		return wnammk;
	}

	public void setWnammk(String wnammk) {
		this.wnammk = wnammk;
	}

	public String getWidnum() {
		return widnum;
	}

	public void setWidnum(String widnum) {
		this.widnum = widnum;
	}

	public String getSpnrnam1() {
		return spnrnam1;
	}

	public void setSpnrnam1(String spnrnam1) {
		this.spnrnam1 = spnrnam1;
	}

	public String getWnatmk() {
		return wnatmk;
	}

	public void setWnatmk(String wnatmk) {
		this.wnatmk = wnatmk;
	}
	
	public String getCntcod() {
		return cntcod;
	}

	public void setCntcod(String cntcod) {
		this.cntcod = cntcod;
	}

	public String getCntnam() {
		return cntnam;
	}

	public void setCntnam(String cntnam) {
		this.cntnam = cntnam;
	}

	public Date getWbidat() {
		return wbidat;
	}

	public void setWbidat(Date wbidat) {
		this.wbidat = wbidat;
	}

	public String getWmksex() {
		return wmksex;
	}

	public void setWmksex(String wmksex) {
		this.wmksex = wmksex;
	}

	public String getWmarri() {
		return wmarri;
	}

	public void setWmarri(String wmarri) {
		this.wmarri = wmarri;
	}
	
	public String getWadren() {
		return wadren;
	}

	public void setWadren(String wadren) {
		this.wadren = wadren;
	}

	public String getWmaila() {
		return wmaila;
	}

	public void setWmaila(String wmaila) {
		this.wmaila = wmaila;
	}

	public String getZipcod() {
		return zipcod;
	}

	public void setZipcod(String zipcod) {
		this.zipcod = zipcod;
	}

	public String getWaddre() {
		return waddre;
	}

	public void setWaddre(String waddre) {
		this.waddre = waddre;
	}

	public String getWteln2() {
		return wteln2;
	}

	public void setWteln2(String wteln2) {
		this.wteln2 = wteln2;
	}

	public String getWteln1() {
		return wteln1;
	}

	public void setWteln1(String wteln1) {
		this.wteln1 = wteln1;
	}

	public String getWteln3() {
		return wteln3;
	}

	public void setWteln3(String wteln3) {
		this.wteln3 = wteln3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobno() {
		return jobno;
	}

	public void setJobno(String jobno) {
		this.jobno = jobno;
	}

	public String getReltin() {
		return reltin;
	}

	public void setReltin(String reltin) {
		this.reltin = reltin;
	}

	public String getReltindes() {
		return reltindes;
	}

	public void setReltindes(String reltindes) {
		this.reltindes = reltindes;
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

	public String getSpnrnam2() {
		return spnrnam2;
	}

	public void setSpnrnam2(String spnrnam2) {
		this.spnrnam2 = spnrnam2;
	}

	public String getGetnat() {
		return getnat;
	}

	public void setGetnat(String getnat) {
		this.getnat = getnat;
	}

	public String getGetcntc() {
		return getcntc;
	}

	public void setGetcntc(String getcntc) {
		this.getcntc = getcntc;
	}

	public String getGetcntn() {
		return getcntn;
	}

	public void setGetcntn(String getcntn) {
		this.getcntn = getcntn;
	}

	public Date getGetbri() {
		return getbri;
	}

	public void setGetbri(Date getbri) {
		this.getbri = getbri;
	}

	public String getGetsex() {
		return getsex;
	}

	public void setGetsex(String getsex) {
		this.getsex = getsex;
	}

	public String getGetano() {
		return getano;
	}

	public void setGetano(String getano) {
		this.getano = getano;
	}

	public String getGetadd() {
		return getadd;
	}

	public void setGetadd(String getadd) {
		this.getadd = getadd;
	}

	public String getGettel() {
		return gettel;
	}

	public void setGettel(String gettel) {
		this.gettel = gettel;
	}

	public String getInssrc() {
		return inssrc;
	}

	public void setInssrc(String inssrc) {
		this.inssrc = inssrc;
	}

	public String getSaldep() {
		return saldep;
	}

	public void setSaldep(String saldep) {
		this.saldep = saldep;
	}

	public String getProjec() {
		return projec;
	}

	public void setProjec(String projec) {
		this.projec = projec;
	}

	public String getCampcd() {
		return campcd;
	}

	public void setCampcd(String campcd) {
		this.campcd = campcd;
	}

	public String getSolin1() {
		return solin1;
	}

	public void setSolin1(String solin1) {
		this.solin1 = solin1;
	}

	public String getSolin2() {
		return solin2;
	}

	public void setSolin2(String solin2) {
		this.solin2 = solin2;
	}

	public String getSalcod() {
		return salcod;
	}

	public void setSalcod(String salcod) {
		this.salcod = salcod;
	}

	public String getSalnam() {
		return salnam;
	}

	public void setSalnam(String salnam) {
		this.salnam = salnam;
	}

	public String getBkcod1() {
		return bkcod1;
	}

	public void setBkcod1(String bkcod1) {
		this.bkcod1 = bkcod1;
	}

	public String getPidnum() {
		return pidnum;
	}

	public void setPidnum(String pidnum) {
		this.pidnum = pidnum;
	}

	public String getPnamei() {
		return pnamei;
	}

	public void setPnamei(String pnamei) {
		this.pnamei = pnamei;
	}

	public String getBkcod2() {
		return bkcod2;
	}

	public void setBkcod2(String bkcod2) {
		this.bkcod2 = bkcod2;
	}

	public String getPidnum2() {
		return pidnum2;
	}

	public void setPidnum2(String pidnum2) {
		this.pidnum2 = pidnum2;
	}

	public String getPnamei2() {
		return pnamei2;
	}

	public void setPnamei2(String pnamei2) {
		this.pnamei2 = pnamei2;
	}

	public String getAcceptno() {
		return acceptno;
	}

	public void setAcceptno(String acceptno) {
		this.acceptno = acceptno;
	}

	public String getApplno() {
		return applno;
	}

	public void setApplno(String applno) {
		this.applno = applno;
	}

	public String getBuilddate() {
		return builddate;
	}

	public void setBuilddate(String builddate) {
		this.builddate = builddate;
	}

	public String getBuildmem() {
		return buildmem;
	}

	public void setBuildmem(String buildmem) {
		this.buildmem = buildmem;
	}

	public String getBuildno() {
		return buildno;
	}

	public void setBuildno(String buildno) {
		this.buildno = buildno;
	}

	public String getGetjob() {
		return getjob;
	}

	public void setGetjob(String getjob) {
		this.getjob = getjob;
	}

	public String getComstk2() {
		return comstk2;
	}

	public void setComstk2(String comstk2) {
		this.comstk2 = comstk2;
	}

	public String getComtyp1() {
		return comtyp1;
	}

	public void setComtyp1(String comtyp1) {
		this.comtyp1 = comtyp1;
	}

	public String getComtyp2() {
		return comtyp2;
	}

	public void setComtyp2(String comtyp2) {
		this.comtyp2 = comtyp2;
	}

	public String getMovmak() {
		return movmak;
	}

	public void setMovmak(String movmak) {
		this.movmak = movmak;
	}

}