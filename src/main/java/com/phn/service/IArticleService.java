/**
 * 
 */
package com.phn.service;

import java.util.List;

import com.phn.model.Article;

/**
 * @author Administrator
 */
public interface IArticleService {

	public List<Article> ArticleList(int page) ;
	public List<Article> latestArticleList();
	public List<Article> recommentArticleList();
	
	/**
	 * @param articleId
	 * @param pageNum
	 * @return
	 */
	public List<Article> articleList(int articleId, int pageNum);
}
