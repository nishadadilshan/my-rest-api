package com.myrestapi.myrestapi.repository;

import com.myrestapi.myrestapi.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
//    @Query("SELECT t FROM Customer t WHERE t.email=:email")
//    List<Customer> findByEmail(String email);

}


