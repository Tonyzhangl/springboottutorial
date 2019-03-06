package com.kirago.chapter06.jpa;

import com.kirago.chapter06.entity.Goodz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GoodJpa extends JpaRepository<Goodz,Long>, QuerydslPredicateExecutor<Goodz> {
}
