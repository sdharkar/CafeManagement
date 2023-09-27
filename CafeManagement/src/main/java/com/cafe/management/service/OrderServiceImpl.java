package com.cafe.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.management.Repository.MenuRepo;
import com.cafe.management.Repository.OrderRepo;
import com.cafe.management.model.Menu;
import com.cafe.management.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private MenuRepo menuRepo;

    @Override
    public List<Order> getAllOrder() {

        return this.orderRepo.findAll();
    }

    @Override
    public List<Order> getOrderByUsername(String username) {

        return this.orderRepo.findByUsername(username);
    }

    @Override
    public Optional<Order> getOrderByOrderId(long orderId) {

        return this.orderRepo.findById(orderId);
    }

    @Override
    public String setOrder(Order order) {

        List<Menu> products = order.getProduct();

        for (Menu m : products) {
            Menu product = menuRepo.findByMenuName(m.getMenuName());
            product.setMenuQuantity(product.getMenuQuantity() - m.getMenuQuantity());
            menuRepo.save(product);
        }

        this.orderRepo.save(order);
        return "Order Details Added Successfully!";
    }

    @Override
    public String updateOrder(Order order) {

        System.out.println(order);

        this.orderRepo.save(order);
        return "Order Details Updated Successfully!";
    }

    @Override
    public String deleteOrder(long orderId) {

        this.orderRepo.deleteById(orderId);
        return "Order Details Deleted Successfully!";
    }

}

