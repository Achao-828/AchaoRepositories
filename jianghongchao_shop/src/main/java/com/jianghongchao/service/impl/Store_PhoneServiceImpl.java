package com.jianghongchao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jianghongchao.dao.Store_PhoneDao;
import com.jianghongchao.entity.Store_Phone;
import com.jianghongchao.service.Store_PhoneService;

@Service
public class Store_PhoneServiceImpl implements Store_PhoneService{
	
	@Resource
	private Store_PhoneDao store_PhoneDao;
	
	@Override
	public int delete(int ids) {
		return store_PhoneDao.delete(ids);
	}

	@Override
	public int insert(Store_Phone store_phone) {
		return store_PhoneDao.insert(store_phone);
	}
	
}
