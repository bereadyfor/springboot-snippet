package com.beready4.api.member.service;

import java.util.List;

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

	public Member createMember(Member member) {
		return memberRepository.save(member);
	}

	public List<Member> getMembers() {
		return memberRepository.findAll();
	}

	public Member getMember(long no) {
		return memberRepository.findByNo(no);
	}

	public Member updateMember(long no, Member newMember) {
		Member member = getMember(no);

		if (member == null) {
			return null;
		}

		member.setId(newMember.getId());
		member.setName(newMember.getName());
		member.setPassword(newMember.getPassword());
		member.setLoginUrl(newMember.getLoginUrl());

		return memberRepository.save(member);
	}

	public void deleteMember(long no) {
		memberRepository.deleteById(no);
	}
}
