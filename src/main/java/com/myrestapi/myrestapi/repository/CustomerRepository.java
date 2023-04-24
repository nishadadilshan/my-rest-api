package com.myrestapi.myrestapi.repository;

import com.myrestapi.myrestapi.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{}
