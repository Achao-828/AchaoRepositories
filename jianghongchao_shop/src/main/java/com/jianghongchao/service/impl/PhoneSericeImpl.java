package com.jianghongchao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jianghongchao.dao.PhoneDao;
import com.jianghongchao.entity.Phone;
import com.jianghongchao.service.PhoneSerice;

@Service
public class PhoneSericeImpl implements PhoneSerice {
	
	@Resource
	private PhoneDao phoneDao;
	
	@Override
	public List<Phone> getPhones() {
		return phoneDao.getPhones();
	}

}
