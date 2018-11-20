package com.kirago.chapter03.dao;

import com.kirago.chapter03.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName AuthorRepository
 * @Description TODO
 * @Author kirago
 * @Date 2018/11/13 17:48
 * @Version 1.0
 **/
public interface AuthorRepository extends JpaRepository<Author, Long> {
	List<Author> findAll();

	@Query("from Author where id = :id")
	Author findAuthor(@Param("id") Long id);
}
