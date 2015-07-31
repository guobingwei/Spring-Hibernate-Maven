/**
 * 
 */
package com.phn.dao;

import java.util.List;

import com.phn.model.Article;

/**
 * @author Administrator
 */
public interface IArticleDao {

	public List<Article> ArticleList(int page);
	public List<Article> latestArticleList();
	public List<Article> recommentArticleList();
	public List<Article> articleList(int articleId, int page);
}
