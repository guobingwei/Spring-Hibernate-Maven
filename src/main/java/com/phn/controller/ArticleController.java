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
import static com.phn.common.Constants.SUCCEECODE;

import com.phn.model.Article;
import com.phn.service.IArticleService;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("article")
public class ArticleController {

	@Resource
	private IArticleService articleService;
	
	/**
	 * 首页文章列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/articleList", method = RequestMethod.GET)
	public List<Article> queryArticle(String articleId, String page) {
		
		List<Article> list = new ArrayList<Article>();
		int pageNum = 0;
		if(articleId == null) {
			if(page != null && !page.trim().equals("")) {
				pageNum = Integer.parseInt(page);
			}
			list = articleService.ArticleList(pageNum);
		} else {
			int id = Integer.parseInt(articleId);
			list = articleService.articleList(id, pageNum);
		}
		return list;
	} 
	/**
	 * 最新文章列表 - 按更新时间排序
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/latestArticleList", method = RequestMethod.GET)
	public Map<String, Object> latestArticleList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Article> list = new ArrayList<Article>(); 
		list = articleService.latestArticleList();
		map.put("latestArticleList", list);
		map.put("SUCCESSCODE", SUCCEECODE);
		return map;
	}
	/**
	 * 推荐文章 - 按点击率排序
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/recommentArticleList", method = RequestMethod.GET)
	public Map<String, Object> recommentArticleList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Article> list = new ArrayList<Article>(); 
		list = articleService.recommentArticleList();
		map.put("recommentArticleList", list);
		map.put("SUCCESSCODE", SUCCEECODE);
		return map;
	}
}
