package com.kirago.chapter10.jpa;

import com.kirago.chapter10.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerJPA extends JpaRepository<LoggerEntity,Long> {
}
