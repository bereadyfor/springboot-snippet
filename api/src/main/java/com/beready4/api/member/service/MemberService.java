package com.beready4.api.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beready4.common.member.model.Member;
import com.beready4.common.member.repository.MemberRepository;

@Service
public class MemberService {

	private final MemberRepository memberRepository;

	@Autowired
	MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Member registerMember(Member member) {
		return memberRepository.save(member);
	}
}
