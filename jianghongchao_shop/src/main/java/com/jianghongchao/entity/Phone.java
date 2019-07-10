package com.jianghongchao.entity;

import java.util.List;

public class Phone {
	private Integer pid;
	private String pname;
	private List<Store> stores;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public List<Store> getStores() {
		return stores;
	}
	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	public Phone() {
		super();
	}
	
}
