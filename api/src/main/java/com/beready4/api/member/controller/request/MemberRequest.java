package com.beready4.api.member.controller.request;

import com.beready4.common.member.model.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequest {

	private String id;
	private String password;
	private String name;
	private String loginUrl;

	public Member toMember() {
		return Member.builder()
			.id(id)
			.password(password)
			.name(name)
			.loginUrl(loginUrl)
			.build();
	}
}
