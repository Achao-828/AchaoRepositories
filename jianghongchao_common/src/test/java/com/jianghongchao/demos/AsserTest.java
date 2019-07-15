package com.jianghongchao.demos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jianghongchao.utils.AsserUtil;

/**
 * 断言测试类
 * @author 阿超
 *
 */
public class AsserTest {
	
	/* 1.测试是否为真 */
	@Test
	public void isTrue01() {
		try {
			Boolean condition = true;
			AsserUtil.isTrue(condition, "值不为真");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void isTrue02() {
		try {
			Boolean condition = false;
			AsserUtil.isTrue(condition, "值不为真");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 2.测试值是否为假 */
	@Test
	public void isFalse01() {
		try {
			boolean condition = true;
			AsserUtil.isFalse(condition, "值不为假");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void isFalse02() {
		try {
			boolean condition = false;
			AsserUtil.isFalse(condition, "值不为假");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 3.测试对象必须不为空 */
	@Test
	public void isNotNull01() {
		try {
			Object obj = new Object();
			AsserUtil.notNull(obj, "对象必须为空");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void isNotNull02() {
		try {
			Object obj = null;
			AsserUtil.notNull(obj, "对象必须为空");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 4.测试对象必须为空 */
	@Test
	public void isNull01() {
		try {
			Object obj = new Object();
			AsserUtil.isNull(obj, "对象不为空");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void isNull02() {
		try {
			Object obj = null;
			AsserUtil.isNull(obj, "对象不为空");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 5.断言集合不为空，没有元素也算空 */
	@Test
	public void isCollectionNotNull01() {
		try {
			Collection<String> collection = new ArrayList<String>();
			AsserUtil.notEmpty(collection, "集合不能为空");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void isCollectionNotNull02() {
		try {
			Collection<String> collection = new ArrayList<String>();
			collection.add("aaa");
			AsserUtil.notEmpty(collection, "集合不能为空");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 6.断言map集合不为空，没有元素也算空 */
	@Test
	public void isMapNotNull01() {
		try {
			Map<String, String> map = new HashMap<String, String>();
			AsserUtil.notEmpty(map, "map集合不能为空");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void isMapNotNull02() {
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("aaa", "aaa");
			AsserUtil.notEmpty(map, "map集合不能为空");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 7.断言字符串必须有值 */
	@Test
	public void isHasTest01() {
		try {
			String str = "aaa";
			AsserUtil.hasText(str, "字符串不为空而且必须有值");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void isHasTest02() {
		try {
			String str = "";
			AsserUtil.hasText(str, "字符串不为空而且必须有值");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 8.断言值必须大与0 */
	@Test
	public void isGreaterZhenZero01() {
		try {
			BigDecimal value = new BigDecimal(1);
			AsserUtil.greaterThanZero(value, "值必须大与0");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void isGreaterZhenZero02() {
		try {
			BigDecimal value = new BigDecimal(0);
			AsserUtil.greaterThanZero(value, "值必须大与0");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
