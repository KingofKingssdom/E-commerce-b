package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.OrderItem;
import com.laptrinhweb.backend.Repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private OrderItemRepository orderItemRepository;
    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
    public List<OrderItem> createOrderItemAll (List<OrderItem> orderItems){
        List<OrderItem> orderItemList = orderItemRepository.saveAll(orderItems);
        return orderItemList;
    }
    public OrderItem findOrderItemById( int id) {
        return orderItemRepository.findById(id).orElseThrow();
    }
    public List<OrderItem> findAll (){
        return orderItemRepository.findAll();
    }
    public void deleteOrderItem (OrderItem orderItem) {
        orderItemRepository.delete(orderItem);
    }
}
