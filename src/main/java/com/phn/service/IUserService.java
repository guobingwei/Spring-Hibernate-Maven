/**
 * 
 */
package com.phn.service;

import java.util.List;

import com.phn.model.AboutMe;
import com.phn.model.UserEntity;

/**
 * @author phn
 */
public interface IUserService {
	public boolean isExist(UserEntity user);
	public List<AboutMe> userInfo();
}
