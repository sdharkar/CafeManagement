package com.order.manage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.order.manage.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/cafe/orders")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		try {
			List<Order> orders = orderService.getAllOrders();
			return new ResponseEntity<>(orders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable String orderId) {
		try {
			Optional<Order> order = orderService.getOrderById(orderId);
			return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
					.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		try {
			System.out.println("Order created successfully");
			Order createdOrder = orderService.createOrder(order);
			return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Failed to create order");
		}
		return null;
	}

	@DeleteMapping("/{orderId}")
	public ResponseEntity<Object> deleteOrder(@PathVariable String orderId) {
		try {
			System.out.println("Order deleted successfully");
			orderService.deleteOrder(orderId);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			System.out.println("Failed to delete order");
		}
		return null;
	}

	@GetMapping("/user/{userName}")
	public ResponseEntity<List<Order>> getOrdersByUserName(@PathVariable String userName) {
		try {
			System.out.println("Order got by user name");
			List<Order> userOrders = orderService.getOrdersByUserName(userName);
			if (userOrders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(userOrders, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Failed to get order by user name");
		}
		return null;
	}

	@PutMapping("/{orderId}")
	public ResponseEntity<Order> updateOrder(@PathVariable String orderId, @RequestBody Order updatedOrder) {
		try {
			System.out.println("Order updated successfully");

			Optional<Order> existingOrder = orderService.getOrderById(orderId);
			if (existingOrder.isPresent()) {
				Order orderToUpdate = existingOrder.get();
				orderToUpdate.setUserName(updatedOrder.getUserName());
				orderToUpdate.setMenu(updatedOrder.getMenu());
				orderToUpdate.setTotalAmount(updatedOrder.getTotalAmount());
				orderToUpdate.setStatus(updatedOrder.getStatus());

				Order updated = orderService.updateOrder(orderToUpdate);
				return new ResponseEntity<>(updated, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.println("Failed to update order");
		}
		return null;
	}

}
