package com.bw.pojo;

import java.util.Date;

public class Hospital {
	private int id;
	private String hospital_name;
	private String name;
	private String tel;
	private Date datea;
	private String content;
	private int tid;
	private Type type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDatea() {
		return datea;
	}

	public void setDatea(Date datea) {
		this.datea = datea;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Hospital() {
		super();
	}

	public Hospital(int id, String hospital_name, String name, String tel, Date datea, String content, int tid) {
		super();
		this.id = id;
		this.hospital_name = hospital_name;
		this.name = name;
		this.tel = tel;
		this.datea = datea;
		this.content = content;
		this.tid = tid;
	}

}
