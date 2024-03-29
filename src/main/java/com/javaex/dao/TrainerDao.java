package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.TrainerVo;

@Repository
public class TrainerDao {

	@Autowired
	private SqlSession sqlSession;
	
	public TrainerVo trainerSelectByIdPw(TrainerVo trainerVo) {
		System.out.println("TrainerDao.memberSelectByIdPw()");
		TrainerVo authUser = sqlSession.selectOne("trainer.selectByIdPw", trainerVo);
		return authUser;
	}
}
