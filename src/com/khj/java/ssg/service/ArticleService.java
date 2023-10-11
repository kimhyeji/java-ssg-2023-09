package com.khj.java.ssg.service;

import java.util.List;

import com.khj.java.ssg.container.Container;
import com.khj.java.ssg.dao.ArticleDao;
import com.khj.java.ssg.dto.Article;

public class ArticleService {
	private ArticleDao articleDao;

	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int getLastId() {
		return articleDao.getLastId();
	}

	public int getNewId() {
		return articleDao.getNewId();
	}

	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}

	public int getArticleIndexById(int id) {
		return articleDao.getArticleIndexById(id);
	}

	public void add(Article article) {
		articleDao.add(article);
	}

	public void remove(int foundIndex) {
		articleDao.remove(foundIndex);
	}

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}
}
