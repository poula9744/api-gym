package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MemberVo;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;

	//로그인
	public MemberVo memberSelectByIdPw(MemberVo memberVo) {
		System.out.println("MemberDao.memberSelectByIdPw()");
		MemberVo authUser = sqlSession.selectOne("member.selectByIdPw", memberVo);
		return authUser;
	}

	// 회원가입
	public int join(MemberVo memberVo) {
		System.out.println("MemberDao.userModify()");
		int count = sqlSession.update("member.join", memberVo);
		System.out.println(count);
		return count;
	}

	// id 중복체크
	public int check(String id) {
		System.out.println("MemberDao.userModify()");
		int count = sqlSession.selectOne("member.idCheck", id);
		System.out.println(count);
		return count;
	}

}
