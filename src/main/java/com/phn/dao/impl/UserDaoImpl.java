/**
 * 
 */
package com.phn.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.phn.dao.IBaseDao;
import com.phn.dao.IUserDao;
import com.phn.model.AboutMe;
import com.phn.model.UserEntity;

/**
 * @author phn
 */

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	// extends BaseDaoImpl<UserEntity, Integer>
	@Resource
	public IBaseDao baseDao;
	@Override
	public boolean isExist(UserEntity user) {
		Session session = baseDao.getSession();
		String hql = "from UserEntity where username =? and password = ?";
		Query query = session.createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		if (query.list().size() >= 1) {
			return true;
		}
		return false;
	}

	/* 
	 * 查询登录用户信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AboutMe> userInfo() {
		List<AboutMe> list = null;
		Session session = baseDao.getSession();
		String hql = "from AboutMe";
		Query query = session.createQuery(hql);
		list = query.list();
		return list;
	}


}
