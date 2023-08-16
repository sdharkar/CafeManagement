package com.order.manage.controller;

import java.util.List;

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

import com.order.manage.model.Order;
import com.order.manage.repository.OrderRepository;

@RestController
@CrossOrigin
@RequestMapping("/cafe/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PostMapping
    public Order placeOrder(@RequestBody Order order) {
		try {
			System.out.println("Order created successfully");
        return orderRepository.save(order);
		} catch(Exception e) {
			System.out.println("Failed to create order");
		}
		return order;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
    	try {
    		System.out.println("Order by id got successfully");
        return orderRepository.findById(id).orElse(null);
    	} catch(Exception e) {
    		System.out.println("Failed to get menu items");
    	}
		return null;
    }

    @GetMapping("/user/{username}")
    public List<Order> getOrdersByUserName(@PathVariable String userName) {
    	try {
    		System.out.println("Order by userId got successfully");
        return orderRepository.findByUserId(userName);
    	} catch(Exception e) {
    		System.out.println("Failed to get order by userID");
    	}
		return null;
    }

    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable String id, @RequestBody String status) {
    	try {
    		System.out.println("Order status updated successfully");
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    	} catch(Exception e) {
    		System.out.println("Failed to update order status");
    	}
		return null;
    }

    @DeleteMapping("/{id}")
    public void cancelOrder(@PathVariable String id) {
    	try {
    		System.out.println("Order deleted successfully");
        orderRepository.deleteById(id);
    	} catch(Exception e) {
    		System.out.println("Failed to delete order");
    	}
    }

}
