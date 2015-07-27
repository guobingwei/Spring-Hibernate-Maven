/**
 * 
 */
package com.phn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phn.dao.IBlogElementDao;
import com.phn.model.BlogElement;
import com.phn.service.IBlogElementService;

/**
 * @author john
 */
@Transactional
@Service("blogElementService")
public class BlogElementServiceImpl implements IBlogElementService {

	@Resource
	private IBlogElementDao blogElementDao;
	
	/**
	 * blog界面元素信息查询
	 */
	@Override
	public List<BlogElement> blogElementList() {
		return blogElementDao.BlogElementList();
	}

}
