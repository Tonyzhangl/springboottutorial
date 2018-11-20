package com.kirago.chapter04.repository;

import com.kirago.chapter04.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName CustomerRepository
 * @Description TODO
 * @Author kirago
 * @Date 2018/11/20 9:52
 * @Version 1.0
 **/
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
}
