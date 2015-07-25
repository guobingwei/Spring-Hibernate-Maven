/**
 * 
 */
package com.phn.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phn.model.AboutMe;
import com.phn.model.UserEntity;
import com.phn.service.IUserService;

import static com.phn.common.Constants.SUCCEECODE;;

/**
 * @author phn
 */
@Controller
@RequestMapping("/user")
public class UserController{
	@Resource
	private IUserService userService;
	
	@ResponseBody
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Map<String,Object> login( UserEntity user){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(user.toString());
		boolean loginResult = userService.isExist(user);
		map.put("loginResult", loginResult);
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public List<AboutMe> userInfo() {
		List<AboutMe> list = new ArrayList<AboutMe>();
		list = userService.userInfo();
		return list;
	}
}
