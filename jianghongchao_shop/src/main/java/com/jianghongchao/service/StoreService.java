package com.jianghongchao.service;

import java.util.List;

import com.jianghongchao.entity.Store;

public interface StoreService {
	public List<Store> getStores(Store store,int page,int rows);
	public int deleteStore(String[] ids);
	public Store getstore(int id);
	public int insertStore(Store store);
}
