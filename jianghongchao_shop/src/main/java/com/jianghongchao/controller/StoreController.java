package com.jianghongchao.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.jianghongchao.entity.Phone;
import com.jianghongchao.entity.Store;
import com.jianghongchao.entity.Store_Phone;
import com.jianghongchao.service.PhoneSerice;
import com.jianghongchao.service.StoreService;
import com.jianghongchao.service.Store_PhoneService;
/**
 * 
 * @author 阿超
 *
 */
@Controller
public class StoreController {
	
	@Resource
	private StoreService storeService;
	@Resource
	private Store_PhoneService store_PhoneService;
	@Resource
	private PhoneSerice phoneSerice;
	
	@RequestMapping("getstore")
	public ModelAndView getStores(Store store,@RequestParam(required=false,defaultValue="1")int page,@RequestParam(required=false,defaultValue="3")int rows) {
		ModelAndView mv = new ModelAndView();
		List<Store> stores = storeService.getStores(store, page, rows);
		PageInfo<Store> pageInfo = new PageInfo<Store>(stores);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("store", store);
		mv.addObject("page", page);
		mv.addObject("rows", rows);
		mv.setViewName("list");
		return mv;
	}
	
	@RequestMapping("delete")
	public String deleteStore(String ids) {
		//1.删除中间表
		String[] split = ids.split(",");
		int delete = 0;
		for (String ss : split) {
			delete = store_PhoneService.delete(Integer.parseInt(ss));
		}
		//2.删除产品表
		int deleteStore = storeService.deleteStore(split);
		return "redirect:getstore";
	}
	
	@RequestMapping("xiang")
	public ModelAndView chakan(int id){
		ModelAndView mv = new ModelAndView();
		List<Phone> phones = phoneSerice.getPhones();
		Store getstore = storeService.getstore(id);
		List<Phone> phones2 = getstore.getPhones();
		for (Phone phone1 : phones2) {
			for (Phone phone2 : phones) {
				String pname = phone2.getPname();
				if(phone1.getPname().equals(pname)) {
					phone2.setPname("+"+phone2.getPname());
				}
			}
		}
		mv.addObject("phones", phones);
		mv.addObject("store", getstore);
		mv.setViewName("cha");
		return mv;
	}
	
	@RequestMapping("add1")
	public @ResponseBody List<Phone> add1(){
		List<Phone> phones = phoneSerice.getPhones();
		return phones;
	}
	
	@RequestMapping("add")
	public String addstore(Store store,String[] ids) {
		//1.新增商店表
		int insertStore = storeService.insertStore(store);
		//拿到子查询的sid
		Integer sid = store.getSid();
		//2.新增中间表
		int insert = 0;
		for (String ss : ids) {
			Store_Phone store_Phone = new Store_Phone(sid,Integer.parseInt(ss));
			insert = store_PhoneService.insert(store_Phone);
		}
		if(insertStore > 0 && insert > 0) {
			return "redirect:getstore";
		}else {
			return "add";
		}
	}
	
	/**
	 * 处理页面来的Date类型数据
	 * @param request
	 * @param binder
	 */
	@InitBinder
	public void initBinder(HttpServletRequest request,WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
}
