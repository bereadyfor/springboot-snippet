package com.beready4.common.member.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Member {

	@Id
	private String id;
	private String password;
	private String name;
	private String loginUrl;

	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}