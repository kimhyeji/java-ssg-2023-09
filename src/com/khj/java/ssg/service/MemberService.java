package com.khj.java.ssg.service;

import com.khj.java.ssg.dao.MemberDao;
import com.khj.java.ssg.dto.Member;

public class MemberService {
	public MemberDao memberDao;

	public MemberService() {
		memberDao = new MemberDao();
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

	public int getNewId() {
		return memberDao.getNewId();
	}

	public boolean isJoinableLoginId(String loginId) {
		return memberDao.isJoinableLoginId(loginId);
	}

	public void add(Member member) {
		memberDao.add(member);
	}

}
