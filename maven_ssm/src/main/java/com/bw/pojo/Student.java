package com.bw.pojo;
/**学生表*/

import java.util.Date;
import java.util.List;

public class Student {
	private int sid;
	private String sname;
	private int sex;
	private String hobby;
	private Date birthday;
	private int gid;
	private Grade grade;
	private List<Course> course;
	public Student() {
		super();
	}
	

	public Student(int sid, String sname, int sex, String hobby, Date birthday, int gid, Grade grade,
			List<Course> course) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.hobby = hobby;
		this.birthday = birthday;
		this.gid = gid;
		this.grade = grade;
		this.course = course;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	
}
