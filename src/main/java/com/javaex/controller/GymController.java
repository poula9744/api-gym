package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GymService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.GeneralVo;
import com.javaex.vo.MemberVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class GymController {

	@Autowired
	private GymService gymService;

	// 일반회원권 등록
	@PostMapping("/api/general/register")
	public JsonResult registerMembership(@RequestBody GeneralVo generalVo, HttpServletRequest request) {
		System.out.println("GymController.registerMembership()");

		int no = JwtUtil.getNoFromHeader(request);
		System.out.println(generalVo);
		if (no != -1) {
			int result = gymService.exeRegisterMembership(generalVo);
			System.out.println(result);
			return JsonResult.success(result);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 일반회원권 만료일
	@GetMapping("/api/general")
	public JsonResult membershipOverDay(HttpServletRequest request) {
		System.out.println("GymController.registerMembership()");

		int no = JwtUtil.getNoFromHeader(request);
		if (no != -1) {
			String over = gymService.exeMemberOver(no);
			System.out.println(over);
			return JsonResult.success(over);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 일반회원 운동 시작
	@PutMapping("/api/general/start")
	public JsonResult entry(HttpServletRequest request) {
		System.out.println("GymController.entry()");

		int no = JwtUtil.getNoFromHeader(request);
		if (no != -1) {
			int count = gymService.exeEntry(no);
			System.out.println(count);
			return JsonResult.success(count);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 일반회원 운동 종료
	@PutMapping("/api/general/end")
	public JsonResult leave(HttpServletRequest request) {
		System.out.println("GymController.entry()");

		int no = JwtUtil.getNoFromHeader(request);
		if (no != -1) {
			int count = gymService.exeLeave(no);
			System.out.println(count);
			return JsonResult.success(count);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 일반회원 오운완
	@GetMapping("/api/general/end")
	public JsonResult trainingTime(HttpServletRequest request) {
		System.out.println("GymController.trainingTime()");

		int no = JwtUtil.getNoFromHeader(request);
		if (no != -1) {
			MemberVo trainingTime= gymService.exetrainingTime(no);
			System.out.println(trainingTime);
			return JsonResult.success(trainingTime);
		} else {
			// 토큰이 없거나(로그인상태 아님) 변조된 경우
			return JsonResult.fail("fail");
		}
	}

	
}
