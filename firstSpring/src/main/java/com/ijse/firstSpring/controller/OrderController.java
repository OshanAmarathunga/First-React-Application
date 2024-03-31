package com.ijse.firstSpring.controller;

import com.ijse.firstSpring.dto.AddProductDto;
import com.ijse.firstSpring.entity.Order;
import com.ijse.firstSpring.service.OrderService;
import jakarta.persistence.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private  OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrders(){
       List<Order> allOrders=orderService.getAllOrders();
       return allOrders==null?ResponseEntity.status(404).body(null):ResponseEntity.status(201).body(allOrders);
    }

    @GetMapping("/orders/{id}")
    public  ResponseEntity<Order> getOrderById(@PathVariable int id){
        Order getOrder=orderService.getOrderById(id);
        return getOrder==null?ResponseEntity.status(404).body(null):ResponseEntity.status(200).body(getOrder);
    }

    @PostMapping("/order")
    public Order createOrder(){
        Order order=new Order();
        order.setOrderDateTime(LocalDateTime.now());
        order.setTotalPrice(0.0);
        order.setOrderProducts(null);

        return orderService.createOrder(order);
    }

    @PostMapping("/order/{orderId}/addProducts")
    public Order addProducttoOrder(@PathVariable int orderId, @RequestBody AddProductDto dto){
        return orderService.addProductToOrder(orderId,dto.getProductId(),dto.getQuantity());
    }

    @DeleteMapping("orders/{orderId}/product/{productId}")
    public Order removeProductFromOrder(@PathVariable int orderId,@PathVariable int productId){
        return orderService.removeProductFromOrder(orderId,productId);
    }



}
