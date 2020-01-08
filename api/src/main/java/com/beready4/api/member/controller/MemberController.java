package com.beready4.api.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beready4.api.member.controller.request.MemberRequest;
import com.beready4.api.member.service.MemberService;
import com.beready4.common.member.model.Member;

@RestController
@RequestMapping(value = "members")
public class MemberController {

	private final MemberService memberService;

	@Autowired
	MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("")
	public ResponseEntity<?> getMembers() {
		return ResponseEntity.ok(memberService.getMembers());
	}

	@PostMapping("")
	public ResponseEntity<Member> registerMember(@RequestBody MemberRequest memberRequest) {
		return ResponseEntity.ok(memberService.registerMember(memberRequest.toMember()));
	}
}
