package com.jianghongchao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jianghongchao.entity.Store;

public interface StoreDao {
	public List<Store> getStores(Store store);
	public int deleteStore(String[] ids);
	public Store getstore(@Param("id")int id);
	public int insertStore(Store store);
}
