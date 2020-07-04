package com.liu.bean;

public class Cars {

	private int cid; 
	private int gid;   
	private String gname; 
	private float gprice; 
	private String gimg;
	private int gnum;
	private int uid;
	public Cars() {
		super();
	}
	public Cars(int cid, int gid, String gname, float gprice, String gimg, int gnum, int uid) {
		super();
		this.cid = cid;
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
		this.gimg = gimg;
		this.gnum = gnum;
		this.uid = uid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public float getGprice() {
		return gprice;
	}
	public void setGprice(float gprice) {
		this.gprice = gprice;
	}
	public String getGimg() {
		return gimg;
	}
	public void setGimg(String gimg) {
		this.gimg = gimg;
	}
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
