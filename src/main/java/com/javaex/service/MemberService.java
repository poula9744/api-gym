package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.MemberDao;
import com.javaex.vo.MemberVo;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	//로그인
	public MemberVo exeLogin(MemberVo memberVo) {
		System.out.println("MemberService.exeLogin()");
		MemberVo authUser = memberDao.memberSelectByIdPw(memberVo);
		return authUser;
	}
	
}
