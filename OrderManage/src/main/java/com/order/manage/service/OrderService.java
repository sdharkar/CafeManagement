package com.order.manage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.order.manage.model.Order;
import com.order.manage.repository.OrderRepository;



public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }
	

    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByUserId(String userName) {
        return orderRepository.findByUserId(userName);
    }

    public Order updateOrderStatus(String id, String status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }

    public void cancelOrder(String id) {
        orderRepository.deleteById(id);
    }
}
