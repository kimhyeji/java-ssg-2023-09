package com.khj.java.ssg;

import java.util.Scanner;

import com.khj.java.ssg.container.Container;
import com.khj.java.ssg.controller.ArticleController;
import com.khj.java.ssg.controller.Controller;
import com.khj.java.ssg.controller.ExportController;
import com.khj.java.ssg.controller.MemberController;

public class App {
	public void start() {
		System.out.println("== 프로그램 시작 == ");

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		ExportController exportController = new ExportController(sc);

		articleController.makeTestData();
		memberController.makeTestData();
		exportController.makeTestData();

		while (true) {
			System.out.printf("명령어) ");
			String command = sc.nextLine();

			command = command.trim();

			if (command.length() == 0) {
				continue;
			}

			if (command.equals("system exit")) {
				break;
			}

			String[] commandBits = command.split(" "); // article detail / member join

			if (commandBits.length == 1) {
				System.out.println("존재하지 않는 명령어 입니다.");
				continue;
			}

			String controllerName = commandBits[0]; // member / article
			String actionMethodName = commandBits[1]; // detail / join

			Controller controller = null;

			if (controllerName.equals("article")) {
				controller = articleController;
			} else if (controllerName.equals("member")) {
				controller = memberController;
			} else if (controllerName.equals("export")) {
				controller = exportController;
			} else {
				System.out.println("존재하지 않는 명령어 입니다.");
				continue;
			}

			controller.doAction(command, actionMethodName);
		}

		sc.close();
		System.out.println("== 프로그램 끝 == ");
	}
}