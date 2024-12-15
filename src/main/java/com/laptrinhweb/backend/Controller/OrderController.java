package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.Order;
import com.laptrinhweb.backend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/add")
    public Order addOrder (@RequestBody Order order) {
        return orderService.createOrder(order);
    }
    @PostMapping("/addAll")
    public List<Order> addAllOrder(@RequestBody List<Order> orders){
        return orderService.createAllOrder(orders);
    }
    @GetMapping("/getAll")
    public List<Order> getAll() {
        return orderService.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById (@PathVariable int id) {
        Order order = orderService.findOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder (@PathVariable int id, @RequestBody Order orderDetails){
        Order order = orderService.findOrderById(id);
        order.setOrderDate(orderDetails.getOrderDate());
        order.setStatus(orderDetails.getStatus());
        order.setShippingAddress(orderDetails.getShippingAddress());
        order.setPayMethod(orderDetails.getPayMethod());
        order.setTotalAmount(orderDetails.getTotalAmount());
        orderService.createOrder(order);
        return ResponseEntity.ok(order);
    }
}
