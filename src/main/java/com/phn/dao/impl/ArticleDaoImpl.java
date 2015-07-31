/**
 * 
 */
package com.phn.dao.impl;

import java.util.List;




import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.phn.dao.IArticleDao;
import com.phn.dao.IBaseDao;
import com.phn.model.Article;

import static com.phn.common.Constants.PAGESIZE;

/**
 * @author Administrator
 */
@Repository("articleDao")
public class ArticleDaoImpl implements IArticleDao {

	/* 
	 * 首页文章列表 -- 加入分页参数
	 */
	@Resource
	public IBaseDao baseDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> ArticleList(int page) {
		List<Article> list = null;
		Session session = baseDao.getSession();
		String hql = "from Article";
		Query query = session.createQuery(hql);
		query.setFirstResult(page);
		query.setMaxResults(PAGESIZE);
		list = query.list();
		return list;
	}

	/* 
	 * 最新文章列表查询 - 根据时间排序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> latestArticleList() {
		List<Article> list = null;
		Session session = baseDao.getSession();
		String hql = "from Article as a order by a.PublishDate desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(PAGESIZE);
		list = query.list();
		return list;
	}

	/**
	 * 推荐文章 - 按点击率排序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> recommentArticleList() {
		List<Article> list = null;
		Session session = baseDao.getSession();
		String hql = "from Article as a order by a.ReadCount desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(PAGESIZE);
		list = query.list();
		return list;
	}

	/**
	 * 根据文章的id来查询 - 文章详情
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> articleList(int articleId, int page) {
		List<Article> list = null;
		Session session = baseDao.getSession();
		String hql = "from Article as a where ArticleId = :articleId";
		Query query = session.createQuery(hql);
		query.setInteger("articleId", articleId);
		query.setFirstResult(page);
		query.setMaxResults(PAGESIZE);
		list = query.list();
		return list;
	}
}
