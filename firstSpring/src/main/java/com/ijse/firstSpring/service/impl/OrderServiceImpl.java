package com.ijse.firstSpring.service.impl;

import com.ijse.firstSpring.entity.Order;
import com.ijse.firstSpring.entity.Product;
import com.ijse.firstSpring.repository.OrderRepository;
import com.ijse.firstSpring.repository.ProductRepository;
import com.ijse.firstSpring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addProductToOrder(int orderId, int productId, int quantity) {
        Order order=orderRepository.findById(orderId).orElse(null);
        if(order==null){
            return null;
        }

        Product product=productRepository.findById(productId).orElse(null);
        if(product==null){
            return null;
        }
        order.getOrderProducts().add(product);
        order.setTotalPrice(order.getTotalPrice()+product.getPrice()*quantity);
        return orderRepository.save(order);
    }
}
