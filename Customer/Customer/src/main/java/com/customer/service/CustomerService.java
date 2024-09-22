package com.customer.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.exception.ResourceNotFoundException;
import com.customer.respository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
	@Autowired
    private final CustomerRepository customerRepository;

   
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Create a new customer
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get customer by ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }

    // Update an existing customer
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer existingCustomer = getCustomerById(id);

        existingCustomer.setName(customerDetails.getName());
        existingCustomer.setEmail(customerDetails.getEmail());
        existingCustomer.setAddress(customerDetails.getAddress());
        existingCustomer.setContactNumber(customerDetails.getContactNumber());
        return customerRepository.save(existingCustomer);
    }

    // Delete a customer by ID
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
