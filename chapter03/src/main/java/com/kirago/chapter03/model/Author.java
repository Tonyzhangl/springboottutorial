package com.kirago.chapter03.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;

/**
 * @ClassName Author
 * @Description TODO
 * @Author kirago
 * @Date 2018/11/9 11:15
 * @Version 1.0
 **/
@Entity
@Table(name="t_author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "real_name")
	private String realName;

	@Column(name = "nick_name")
	private String nickName;

	public void setId(Long id) {
		this.id = id;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getId() {
		return id;
	}

	public String getRealName() {
		return realName;
	}

	public String getNickName() {
		return nickName;
	}
}
