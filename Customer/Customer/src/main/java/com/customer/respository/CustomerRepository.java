package com.customer.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
