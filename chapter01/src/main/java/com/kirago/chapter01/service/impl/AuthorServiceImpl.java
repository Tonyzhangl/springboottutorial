package com.kirago.chapter01.service.impl;

import com.kirago.chapter01.dao.AuthorDao;
import com.kirago.chapter01.model.Author;
import com.kirago.chapter01.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName AuthorServiceImpl
 * @Description TODO
 * @Author kirago
 * @Date 2018/11/8 20:10
 * @Version 1.0
 **/
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	@Override
	public int add(Author author) {
		return this.authorDao.add(author);
	}

	@Override
	public int update(Author author) {
		return this.authorDao.update(author);
	}

	@Override
	public int delete(Long id) {
		return this.authorDao.delete(id);
	}

	@Override
	public Author findAuthor(Long id) {
		return this.authorDao.findAuthor(id);
	}

	@Override
	public List<Author> findAuthorList() {
		return this.authorDao.findAuthorList();
	}
}
