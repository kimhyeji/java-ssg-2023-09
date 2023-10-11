package com.khj.java.ssg.service;

import java.util.List;

import com.khj.java.ssg.dto.Article;
import com.khj.java.ssg.util.Util;

public class ExportService {
	public ArticleService articleService;
	public MemberService memberService;
	
	public ExportService() {
		articleService = new ArticleService();
		memberService = new MemberService();
	}

	public void makeHtml() {
		List<Article> articles = articleService.getArticles();
		
		for (Article article : articles ) {
			String writerName = memberService.getMemberNameById(article.memberId);
			
			String fileName = article.id + ".html";
			String html = "<meta charset=\"UTF-8\">";
			html += "<div>번호 : " + article.id + "</div>";
			html += "<div>날짜 : " + article.regDate + "</div>";
			html += "<div>작성자 : " + writerName + "</div>";
			html += "<div>제목 : " + article.title + "</div>";
			html += "<div>내용 : " + article.body + "</div>";
			
			if ( article.id > 1) {
				html += "<div><a href=\"" + (article.id - 1) + ".html" +"\">이전글</a></div>";
			}
			if ( article.id < articleService.getLastId() ) {
				html += "<div><a href=\"" + (article.id + 1) + ".html" +"\">다음글</a></div>";
			}
			// 임의. 데이터 삭제 시에는 적용 안됨.
			
			
			Util.writeFileContents("exportHtml/" + fileName, html);
		}
	}
}
