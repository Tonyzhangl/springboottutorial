package com.kirago.chapter01.dao;

import com.kirago.chapter01.model.Author;

import java.util.List;

/**
 * @ClassName AuthorDao
 * @Description TODO
 * @Author kirago
 * @Date 2018/11/8 19:28
 * @Version 1.0
 **/
public interface AuthorDao {
	int add(AuthorDao authorDao);
	int update(AuthorDao authorDao);
	int delete(Long id);
	Author findAuthor(Long id);
	List<Author> findAuthorList();
}
