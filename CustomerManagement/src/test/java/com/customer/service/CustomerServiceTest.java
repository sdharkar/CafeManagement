package com.customer.service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    CustomerServiceImpl customerService = mock(CustomerServiceImpl.class);
    
    @InjectMocks
    CustomerRepository customerRepository;

//    @Test
//	@Order(1)
//	public void test_getAllCustomer() {
//
//		List<Customer> costomer=new ArrayList<Customer>();
//
//		customer.add(new Customer());
//		customer.add(new Customer());
//
//		when(customerRepository.findAll()).thenReturn(customer);  //mocking statement
//		assertEquals(2,customerService.getAllCustomer().size());
//		}
//    
    
    
}
