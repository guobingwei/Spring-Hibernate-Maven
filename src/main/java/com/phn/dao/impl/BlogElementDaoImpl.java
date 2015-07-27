/**
 * 
 */
package com.phn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.phn.dao.IBaseDao;
import com.phn.dao.IBlogElementDao;
import com.phn.model.BlogElement;

/**
 * @author john
 */
@Repository("blogElementDao")
public class BlogElementDaoImpl implements IBlogElementDao {

	@Resource
	private IBaseDao baseDao;
	/* 
	 * 查询博客信息列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BlogElement> BlogElementList() {
		
		List<BlogElement> list = new ArrayList<BlogElement>();
		Session session = baseDao.getSession();
		String hql = "from BlogElement";
		Query query = session.createQuery(hql);
		list = query.list();
		return list;
	}

}
