package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.TrainerDao;
import com.javaex.vo.TrainerVo;

@Service
public class TrainerService {

	@Autowired
	private TrainerDao trainerDao;

	// 로그인
	public TrainerVo exeLogin(TrainerVo trainerVo) {
		System.out.println("TrainerService.exeLogin()");
		TrainerVo authUser = trainerDao.trainerSelectByIdPw(trainerVo);
		return authUser;
	}

	// 회원가입용
	public int exeJoin(TrainerVo trainerVo) {
		System.out.println("TrainerService.exeJoin()");
		int count = trainerDao.join(trainerVo);
		return count;
	}

	// id 중복체크용
	public int exeCheck(String id) {
		System.out.println("TrainerService.exeCheck()");
		int count = trainerDao.check(id);
		return count;
	}
}
