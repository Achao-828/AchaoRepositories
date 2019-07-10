package com.jianghongchao.entity;

public class Store_Phone {
	private Integer id;
	private Integer sid;
	private Integer pid;
	public Store_Phone() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Store_Phone(Integer sid, Integer pid) {
		super();
		this.sid = sid;
		this.pid = pid;
	}
	
}
