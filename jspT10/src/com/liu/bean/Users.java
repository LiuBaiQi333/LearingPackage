package com.liu.bean;

public class Users {

	private int uid;
	private String uname;
	private String upass;
	private int uage;
	public Users() {
		super();
	}
	public Users(int uid, String uname, String upass, int uage) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.uage = uage;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}

}
