package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.Order;
import com.user.repository.MenuRepository;
import com.user.repository.OrderRepository;
import com.user.repository.UserRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	

	 public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }
	 
	 public Order createOrder(Order order) {
	        return orderRepository.save(order);
	    }

}
