package com.kirago.chapter01.model;

/**
 * @ClassName Author
 * @Description TODO
 * @Author kirago
 * @Date 2018/11/8 19:24
 * @Version 1.0
 **/
public class Author {
	private Long id;
	private String realName;
	private String nickName;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealName() {
		return realName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}
}
