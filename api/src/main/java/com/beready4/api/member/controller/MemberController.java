package com.beready4.api.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beready4.api.member.controller.request.MemberCreateRequest;
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

	@GetMapping
	public ResponseEntity<?> getMembers() {
		return ResponseEntity.ok(memberService.getMembers());
	}

	@GetMapping("{no}")
	public ResponseEntity<?> getMember(@PathVariable long no) {
		return ResponseEntity.ok(memberService.getMember(no));
	}
	
	@PostMapping
	public ResponseEntity<Member> createMember(@RequestBody MemberCreateRequest memberCreateRequest) {
		return ResponseEntity.ok(memberService.createMember(memberCreateRequest.toMember()));
	}

	@PutMapping("{no}")
	public ResponseEntity<Member> updateMember(@PathVariable long no, @RequestBody MemberCreateRequest memberCreateRequest) {
		return ResponseEntity.ok(memberService.updateMember(no, memberCreateRequest.toMember()));
	}

	@DeleteMapping("{no}")
	public ResponseEntity<Member> deleteMember(@PathVariable long no) {
		memberService.deleteMember(no);
		return ResponseEntity.ok().build();
	}
}
