package com.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.Order;
import com.user.service.OrderService;


@RestController
@CrossOrigin
@RequestMapping("/cafe/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;


	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		try {
			List<Order> orders = orderService.getAllOrders();
			return new ResponseEntity<>(orders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
	    try {
	        System.out.println("Order creation started");
	        Order createdOrder = orderService.createOrder(order);
	        URI orderURI = URI.create("/orders/" + createdOrder.getId());
	        System.out.println("Order created successfully");
	        return ResponseEntity.created(orderURI).body(createdOrder);
	    } catch (Exception e) {
	        System.err.println("Failed to create order");
	        e.printStackTrace(); // Print the exception details for debugging
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}


}
