package com.order.management.controller;

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

import com.order.management.model.Order;
import com.order.management.repository.OrderRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable String userId) {
        return orderRepository.findByUserId(userId);
    }

    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable String id, @RequestBody String status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void cancelOrder(@PathVariable String id) {
        orderRepository.deleteById(id);
    }
}
