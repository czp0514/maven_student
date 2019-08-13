package com.bw.pojo;

public class StuCou {
	private int id;
	private int sid;
	private int cid;
	public StuCou() {
		super();
	}
	public StuCou(int id, int sid, int cid) {
		super();
		this.id = id;
		this.sid = sid;
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
}
