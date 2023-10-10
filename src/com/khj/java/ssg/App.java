package com.khj.java.ssg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.khj.java.ssg.controller.ArticleController;
import com.khj.java.ssg.controller.MemberController;
import com.khj.java.ssg.dto.Article;
import com.khj.java.ssg.dto.Member;
import com.khj.java.ssg.util.Util;

public class App {
	private List<Article> articles;
	private List<Member> members;

	public App() {
		articles = new ArrayList();
		members = new ArrayList();
	}

	public void start() {
		System.out.println("== 프로그램 시작 == ");

		makeTestData();

		Scanner sc = new Scanner(System.in);
		
		MemberController memberController = new MemberController(sc, members);
		ArticleController articleController = new ArticleController(sc, articles);

		while (true) {
			System.out.printf("명령어) ");
			String command = sc.nextLine();

			command = command.trim();

			if (command.length() == 0) {
				continue;
			}

			if (command.equals("system exit")) {
				break;
			} else if (command.equals("member join")) {
				memberController.doJoin();
			} else if (command.equals("article write")) {
				articleController.doWrite();
			} else if (command.equals("article list")) {
				articleController.showList();
			} else if (command.startsWith("article detail ")) {
				articleController.showDetail(command);
			} else if (command.startsWith("article modify ")) {
				articleController.doModify(command);
			} else if (command.startsWith("article delete ")) {
				articleController.doDelete(command);
			} else {
				System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", command);
			}
		}

		sc.close();
		System.out.println("== 프로그램 끝 == ");
	}

	private void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다.");
		articles.add(new Article(1, Util.getNowDateStr(), "제목1", "내용1", 10));
		articles.add(new Article(2, Util.getNowDateStr(), "제목2", "내용2", 20));
		articles.add(new Article(3, Util.getNowDateStr(), "제목3", "내용3", 30));
	}
}
