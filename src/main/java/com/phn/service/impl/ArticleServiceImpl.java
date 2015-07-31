/**
 * 
 */
package com.phn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phn.dao.IArticleDao;
import com.phn.model.Article;
import com.phn.service.IArticleService;

/**
 * @author Administrator
 */
@Transactional
@Service("articleService")
public class ArticleServiceImpl implements IArticleService {

	/**
	 * 首页文章列表
	 */
	@Resource
	private IArticleDao articleDao;
	@Override
	public List<Article> ArticleList(int page) {
		
		return articleDao.ArticleList(page);
	}
	/**
	 * 服务层 - 最新文章列表
	 */
	@Override
	public List<Article> latestArticleList() {
		return articleDao.latestArticleList();
	}
	
	/**
	 * 服务层 - 推荐文章列表
	 */
	@Override
	public List<Article> recommentArticleList() {
		return articleDao.recommentArticleList();
	}
	/**
	 * 根据文章的id查询文章
	 */
	@Override
	public List<Article> articleList(int articleId, int pageNum) {
		return articleDao.articleList(articleId, pageNum);
	}

}
