package com.hb.model.stu;

import java.sql.Date;

public class StuDto {
	private int sId;
	private String sName;
	private Date birth;
	private String phone;
	private String email;
	private String status;
	private int regclass;
	
	public StuDto() {
		// TODO Auto-generated constructor stub
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRegclass() {
		return regclass;
	}

	public void setRegclass(int regclass) {
		this.regclass = regclass;
	}
	
}
