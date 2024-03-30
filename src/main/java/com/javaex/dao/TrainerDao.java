package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.TrainerVo;

@Repository
public class TrainerDao {

	@Autowired
	private SqlSession sqlSession;

	//로그인
	public TrainerVo trainerSelectByIdPw(TrainerVo trainerVo) {
		System.out.println("TrainerDao.memberSelectByIdPw()");
		TrainerVo authUser = sqlSession.selectOne("trainer.selectByIdPw", trainerVo);
		return authUser;
	}

	// 회원가입
	public int join(TrainerVo trainerVo) {
		System.out.println("TrainerDao.userModify()");
		int count = sqlSession.update("trainer.join", trainerVo);
		System.out.println(count);
		return count;
	}

	// id 중복체크
	public int check(String id) {
		System.out.println("TrainerDao.userModify()");
		int count = sqlSession.selectOne("trainer.idCheck", id);
		System.out.println(count);
		return count;
	}
}
