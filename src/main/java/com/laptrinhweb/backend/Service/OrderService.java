package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.Order;
import com.laptrinhweb.backend.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    public List<Order> createAllOrder (List<Order> orders) {
        return  orderRepository.saveAll(orders);
    }
    public Order findOrderById(int id) {
        return orderRepository.findById(id).orElseThrow();
    }
    public List<Order> findAll () {
        return orderRepository.findAll();
    }
    public void deleteOrder( int id){
        orderRepository.deleteById(id);
    }
}
