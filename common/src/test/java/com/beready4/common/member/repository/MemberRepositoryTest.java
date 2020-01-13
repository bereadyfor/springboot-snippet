package com.beready4.common.member.repository;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.beready4.common.member.model.Member;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	private Member createMember() {
		return memberRepository.save(
			Member.builder()
				.id("test")
				.name("test")
				.password("test")
				.loginUrl("test")
				.build()
		);
	}

	@Before
	public void setUpMember() {
		createMember();
	}

	@Test
	public void testCreateMember() {
		Member created = createMember();

		assertThat(created, notNullValue());
		assertThat(created.getNo(), is(greaterThanOrEqualTo(1L)));
	}

	@Test
	public void testGetMember() {
		List<Member> list = memberRepository.findAll();

		assertThat(list, notNullValue());
		assertThat(list.size(), is(greaterThanOrEqualTo(1)));

		Member get = memberRepository.findByNo(list.get(0).getNo());

		assertThat(get, notNullValue());
		assertThat(get.getNo(), is(list.get(0).getNo()));
		assertThat(get.getId(), is(list.get(0).getId()));
	}

	@Test
	public void testUpdateMember() {
		Member created = createMember();

		assertThat(created.getPassword(), is("test"));
		assertThat(created.getModifiedAt(), is(created.getCreatedAt()));

		created.setPassword("change");

		Member updated = memberRepository.save(created);

		assertThat(updated.getNo(), is(created.getNo()));
		assertThat(updated.getPassword(), is("change"));
	}

	@Test
	public void testDeleteMember() {
		long memberNo = createMember().getNo();

		assertThat(memberRepository.findByNo(memberNo), notNullValue());

		memberRepository.deleteById(memberNo);

		assertThat(memberRepository.findByNo(memberNo), nullValue());
	}
}