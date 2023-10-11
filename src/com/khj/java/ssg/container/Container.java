package com.khj.java.ssg.container;

import com.khj.java.ssg.dao.ArticleDao;
import com.khj.java.ssg.dao.MemberDao;
import com.khj.java.ssg.service.ArticleService;
import com.khj.java.ssg.service.ExportService;
import com.khj.java.ssg.service.MemberService;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	public static ArticleService articleService;
	public static MemberService memberService;
	public static ExportService exportService;

	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		articleService = new ArticleService();
		memberService = new MemberService();
		exportService = new ExportService();
	}
	
	// 컨테이너는 바다 같은 저장소라고 생각하면 된다.
	// 한식을 먹으려면 한식집에 전화를 걸듯이
	// 여기 저기 객체를 생성할 필요 없이 어떤 모듈을 찾든 간에 이곳에서 찾으면 된다.
	// 스태틱 생성자는 프로그램이 시작될 때 단 한 번 실행 된다.
	// 일반 생성자처럼 new 할 때마다 실행될 필요가 없으므로
	// 스태틱 생성자로 만들어주면 된다.
}