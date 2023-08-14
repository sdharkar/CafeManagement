package com.order.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.model.Order;
import com.order.management.repository.OrderRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@PostMapping
    public Order placeOrder(@RequestBody Order order) {
		try {
			logger.info("Order created successfully");
        return orderRepository.save(order);
		} catch(Exception e) {
			logger.error("Failed to create order",e);
		}
		return order;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
    	try {
    		logger.info("Order by id got successfully");
        return orderRepository.findById(id).orElse(null);
    	} catch(Exception e) {
    		logger.error("Failed to get menu items",e);
    	}
		return null;
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable String userId) {
    	try {
    		logger.info("Order by userId got successfully");
        return orderRepository.findByUserId(userId);
    	} catch(Exception e) {
    		logger.error("Failed to get order by userID",e);
    	}
		return null;
    }

    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable String id, @RequestBody String status) {
    	try {
    		logger.info("Order status updated successfully");
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    	} catch(Exception e) {
    		logger.error("Failed to update order status",e);
    	}
		return null;
    }

    @DeleteMapping("/{id}")
    public void cancelOrder(@PathVariable String id) {
    	try {
    		logger.info("Order deleted successfully");
        orderRepository.deleteById(id);
    	} catch(Exception e) {
    		logger.error("Failed to delete order",e);
    	}
    }
}
