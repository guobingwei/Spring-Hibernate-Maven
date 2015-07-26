/**
 * 
 */
package com.phn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.phn.dao.IBlogElementDao;
import com.phn.model.BlogElement;

/**
 * @author john
 */
public class BlogDaoImpl implements IBlogElementDao {

	/* 
	 * 查询博客信息列表
	 */
	@Override
	public List<BlogElement> BlogElementList() {
		//
		List<Object> list = new ArrayList<Object>();
		//hsql = "select id from "
		return null;
	}

}
