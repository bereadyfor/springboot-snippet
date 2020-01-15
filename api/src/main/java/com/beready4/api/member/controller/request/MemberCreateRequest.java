package com.beready4.api.member.controller.request;

import javax.validation.constraints.NotEmpty;

import com.beready4.common.member.model.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateRequest {

	@NotEmpty
	private String id;

	@NotEmpty
	private String password;

	@NotEmpty
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
