package com.beready4.common.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beready4.common.member.model.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
