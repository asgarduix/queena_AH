package com.asi.huanan.model;

public class Usermanage {
	/**
	 * 
	 */

	private String id;
	private String useraccount;
	private String userpwd;
	private String createdate;
	private String createusr;
	private String moddate;
	private String modusr;
	private String type;
	private String username;
	private String userunit;
	private String userphone;
	private String useremail;
	private String enable;
	private String region;

	public Usermanage(String id, String useraccount, String userpwd, String type) {
		this.id = id;
		this.useraccount = useraccount;
		this.userpwd = userpwd;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getCreateusr() {
		return createusr;
	}

	public void setCreateusr(String createusr) {
		this.createusr = createusr;
	}

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}

	public String getModusr() {
		return modusr;
	}

	public void setModusr(String modusr) {
		this.modusr = modusr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserunit() {
		return userunit;
	}

	public void setUserunit(String userunit) {
		this.userunit = userunit;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}