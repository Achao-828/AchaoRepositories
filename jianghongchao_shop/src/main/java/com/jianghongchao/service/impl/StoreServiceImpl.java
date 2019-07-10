package com.jianghongchao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jianghongchao.dao.StoreDao;
import com.jianghongchao.entity.Store;
import com.jianghongchao.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Resource
	private StoreDao storeDao;
	
	@Override
	public List<Store> getStores(Store store,int page,int rows) {
		//启动分页
		PageHelper.startPage(page, rows);
		return storeDao.getStores(store);
	}

	@Override
	public int deleteStore(String[] ids) {
		return storeDao.deleteStore(ids);
	}

	@Override
	public Store getstore(int id) {
		return storeDao.getstore(id);
	}

	@Override
	public int insertStore(Store store) {
		return storeDao.insertStore(store);
	}
	
}
