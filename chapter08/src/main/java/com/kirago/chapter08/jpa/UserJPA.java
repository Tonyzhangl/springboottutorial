package com.kirago.chapter08.jpa;

import com.kirago.chapter08.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/6 3:28 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface UserJPA extends JpaRepository<UserEntity,Long>, JpaSpecificationExecutor<UserEntity>, Serializable {
}
