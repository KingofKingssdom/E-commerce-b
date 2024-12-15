package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.OrderItem;
import com.laptrinhweb.backend.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    private OrderItemService orderItemService;
    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping("/add")
    public OrderItem addOrderItem (@RequestBody OrderItem orderItem) {
        return  orderItemService.createOrderItem(orderItem);
    }
    @PostMapping("/addAll")
    public List<OrderItem> addAllOrderItem(@RequestBody List<OrderItem> orderItems) {
        return orderItemService.createOrderItemAll(orderItems);
    }
    @GetMapping("{id}")
    public ResponseEntity<OrderItem> getOrderItemById (@PathVariable int id) {
        OrderItem orderItem = orderItemService.findOrderItemById(id);
        return ResponseEntity.ok(orderItem);
    }

    @GetMapping("/getAll")
    public List<OrderItem> getAll () {
        return orderItemService.findAll();
    }
    @PutMapping("{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable int id, @RequestBody OrderItem orderItemDetails){
        OrderItem orderItem = orderItemService.findOrderItemById(id);
        orderItem.setQuantity(orderItemDetails.getQuantity());
        orderItem.setPrice(orderItemDetails.getPrice());
        orderItemService.createOrderItem(orderItem);
        return ResponseEntity.ok(orderItem);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteOrderItem (@PathVariable int id) {
        OrderItem orderItem = orderItemService.findOrderItemById(id);
        orderItemService.deleteOrderItem(orderItem);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
