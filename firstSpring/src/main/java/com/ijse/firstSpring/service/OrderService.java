package com.ijse.firstSpring.service;

import com.ijse.firstSpring.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    Order createOrder(Order order);
    Order addProductToOrder(int orderId,int productId, int quantity);
    Order removeProductFromOrder(int orderId,int productID);

    Order updateOrderStatus(int orderId);

}
