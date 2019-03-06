package com.kirago.chapter07.jpa;

import com.kirago.chapter07.base.BaseRepository;
import com.kirago.chapter07.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/6 11:25 AM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Transactional
public interface UserJpa extends BaseRepository<UserEntity,Long> {

    @Query(value = "select * from k_user where t_age > ?1",nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    @Modifying
    @Query(value = "delete from k_user where t_name = ?1 and t_pwd = ?2",nativeQuery = true)
    public void deleteQuery(String name,String pwd);
}
