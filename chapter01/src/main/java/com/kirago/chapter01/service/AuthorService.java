package com.kirago.chapter01.service;

import com.kirago.chapter01.model.Author;

import java.util.List;

/**
 * @ClassName AuthorService
 * @Description TODO
 * @Author kirago
 * @Date 2018/11/8 20:09
 * @Version 1.0
 **/
public interface AuthorService {
	int add(Author author);

	int update(Author author);

	int delete(Long id);

	Author findAuthor(Long id);

	List<Author> findAuthorList();
}
