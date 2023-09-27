package com.cafe.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cafe.management.model.Order;

@Service
public interface OrderService {
	
	public List<Order> getAllOrder();

    public List<Order> getOrderByUsername(String username);

    public Optional<Order> getOrderByOrderId(long orderId);

    public String setOrder(Order order);

    public String updateOrder(Order order);

    public String deleteOrder(long orderId);

}
