package com.khj.java.ssg.controller;

import java.util.Scanner;

import com.khj.java.ssg.dto.Member;
import com.khj.java.ssg.service.ExportService;
import com.khj.java.ssg.service.MemberService;
import com.khj.java.ssg.util.Util;

public class ExportController extends Controller {
	private Scanner sc;
	private String command;
	private String actionMethodName;
	private ExportService exportService;

	public ExportController(Scanner sc) {
		this.sc = sc;
		exportService = new ExportService();
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "html":
			doHtml();
			break;
		default:
			System.out.println("존재하지 않는 명령어 입니다.");
			break;
		}
	}

	private void doHtml() {
		System.out.println("html 생성을 시작합니다.");
		exportService.makeHtml();
	}
	
	public void makeTestData() {
		
	}

}
