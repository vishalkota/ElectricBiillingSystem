package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.exception.ResourceNotFoundException;
import com.customer.respository.CustomerRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("api/customers")
public class CustomerController {
	
	@Autowired
    private CustomerRepository customerRepository;
 
    //get all Customers
    @GetMapping("/viewcustomerlist")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    //create customer
    @PostMapping("/post")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    //get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomeByid(@PathVariable long id){
        Customer customer =customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not exits by id"+id));
        return ResponseEntity.ok(customer);
    }
 
    //update Customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customerDetails){
 
        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not exits by id"+id));
 
        updateCustomer.setName(customerDetails.getName());
        updateCustomer.setEmail(customerDetails.getEmail());
        updateCustomer.setAddress(customerDetails.getAddress());
        updateCustomer.setContactNumber(customerDetails.getContactNumber());
 
        customerRepository.save(updateCustomer);
 
        return ResponseEntity.ok(updateCustomer);
 
    }
    //Delete Customer by id
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCutomer(@PathVariable long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not exits with id"+id));
 
        customerRepository.delete(customer);
 
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    

}
