/**
 * 
 */
package com.phn.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phn.dao.IUserDao;
import com.phn.model.AboutMe;
import com.phn.model.UserEntity;
import com.phn.service.IUserService;

/**
 * @author phn
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public boolean isExist(UserEntity user) {
		return userDao.isExist(user);
	}

	/* 
	 * 查询用户信息
	 */
	@Override
	public List<AboutMe> userInfo() {
		List<AboutMe> list = new ArrayList<AboutMe>();
		list = userDao.userInfo();
		return list;
	}
}
