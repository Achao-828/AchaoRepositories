package com.jianghongchao.dao;

import org.apache.ibatis.annotations.Param;

import com.jianghongchao.entity.Store_Phone;

public interface Store_PhoneDao {
	public int delete(@Param("ids")int ids); 
	public int insert(Store_Phone store_phone);
}
