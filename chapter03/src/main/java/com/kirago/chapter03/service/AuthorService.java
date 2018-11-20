package com.kirago.chapter03.service;

import com.kirago.chapter03.dao.AuthorRepository;
import com.kirago.chapter03.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AuthorService
 * @Description TODO
 * @Author kirago
 * @Date 2018/11/13 18:07
 * @Version 1.0
 **/
@Service("jpa.authorService")
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> findAll() {
		return this.authorRepository.findAll();
	}

	public Author findAuthor(Long id) {
		return this.authorRepository.findAuthor(id);
	}
}
