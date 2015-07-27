/**
 * 
 */
package com.phn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phn.model.BlogElement;
import com.phn.service.IBlogElementService;
import static com.phn.common.Constants.SUCCEECODE;;

/**
 * @author john
 */
@Controller
@RequestMapping("blogElement")
public class BlogElementController {

	@Resource
	private IBlogElementService blogElementService;
	
	@RequestMapping(value="/blogElementList", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> blogElementList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlogElement> list = new ArrayList<BlogElement>();
		list = blogElementService.blogElementList();
		map.put("BlogElement", list);
		map.put("succeesscode", SUCCEECODE);
		return map;
	}
}
