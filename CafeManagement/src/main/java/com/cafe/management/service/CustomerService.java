package com.cafe.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.management.Repository.CustomerRepo;
import com.cafe.management.model.Customer;

@Service
public interface CustomerService {
	
	 public List<Customer> getAllCustomers();

	    public Optional<Customer> getCustomerById(long id);

	    public List<Customer> getCustomerByName(String name);

	    public List<Customer> getCustomerByUsername(String username);

	    public String setCustomer(Customer customer);

	    public String updateCustomer(Customer customer);

	    public String deleteCustomer(long id);

}
