package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.TrainerService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.TrainerVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class TrainerController {

	@Autowired
	private TrainerService trainerService;

	// 로그인
	@PostMapping("/api/trainer/login")
	public JsonResult login(@RequestBody TrainerVo trainerVo, HttpServletResponse response) {
		System.out.println("TrainerController.login()");

		TrainerVo authUser = trainerService.exeLogin(trainerVo);
		System.out.println(authUser);

		if (authUser != null) {
			// 토큰 발급 헤더에 실어 보낸다
			JwtUtil.createTokenAndSetHeader(response, "" + authUser.getNo());
			return JsonResult.success(authUser);
		} else {
			return JsonResult.fail("로그인 실패");
		}
	}

	// 회원가입
		@PostMapping("/api/trainer/join")
		public int join(@RequestBody TrainerVo trainerVo) {
			System.out.println("TrainerController.join()");
			int count = trainerService.exeJoin(trainerVo);
			return count;
		}

		
		// 아이디 중복체크
		@PutMapping("/api/trainer/join") //get으로 하면 안되는데 왤까요?
		public int idCheck(@RequestBody TrainerVo trainerVo) {
			System.out.println("TrainerController.idCheck()");
			String id = trainerVo.getId();
			System.out.println(id);
			int count = trainerService.exeCheck(id);
			return count;
		}
}
