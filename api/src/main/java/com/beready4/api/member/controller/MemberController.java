package com.beready4.api.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("members")
public class MemberController {

	@GetMapping(path = "")
	public ResponseEntity<?> getMembers() {
		return ResponseEntity.ok().build();
	}
}
