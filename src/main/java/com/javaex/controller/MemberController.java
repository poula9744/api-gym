package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.MemberService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.MemberVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 로그인
	@PostMapping("/api/member/login")
	public JsonResult login(@RequestBody MemberVo memberVo, HttpServletResponse response) {
		System.out.println("MemberController.login()");

		MemberVo authUser = memberService.exeLogin(memberVo);
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
	@PostMapping("/api/member/join")
	public int join(@RequestBody MemberVo memberVo) {
		System.out.println("MemberController.join()");
		int count = memberService.exeJoin(memberVo);
		return count;
	}

	
	// 아이디 중복체크
	@PutMapping("/api/member/join")
	public int idCheck(@RequestBody MemberVo memberVo) {
		System.out.println("MemberController.idCheck()");
		System.out.println(memberVo);
		String id = memberVo.getId();
		System.out.println(id);
		int count = memberService.exeCheck(id);
		return count;
	}
	
}
