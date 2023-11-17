package com.cotiviti.order.controller;

import com.cotiviti.order.dto.OrderDTO;
import com.cotiviti.order.dto.OrderDTOFromFront;
import com.cotiviti.order.entity.Order;
import com.cotiviti.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder(@RequestBody OrderDTOFromFront orderDTOFromFront){
        Order orderDTO = orderService.addOrder(orderDTOFromFront);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }
}
