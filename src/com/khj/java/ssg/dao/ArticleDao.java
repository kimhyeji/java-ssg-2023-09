package com.khj.java.ssg.dao;

import java.util.ArrayList;
import java.util.List;

import com.khj.java.ssg.dto.Article;

public class ArticleDao extends Dao {
	public List<Article> articles;

	public ArticleDao() {
		articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
		lastId = article.id;
	}

	public int getArticleIndexById(int id) {
		int i = 0;

		for (Article article : articles) {
			if (article.id == id) {
				return i;
			}

			i++;
		}

		return -1;
	}

	public Article getArticleById(int id) {
		int index = getArticleIndexById(id);

		if (index != -1) {
			return articles.get(index);
		}

		return null;
	}

	public void remove(int foundIndex) {
		articles.remove(foundIndex);
	}

	public List<Article> getArticles() {
		return articles;
	}
}
