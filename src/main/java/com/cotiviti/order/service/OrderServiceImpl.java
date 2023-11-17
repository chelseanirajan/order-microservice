package com.cotiviti.order.service;

import com.cotiviti.order.dto.OrderDTO;
import com.cotiviti.order.dto.OrderDTOFromFront;
import com.cotiviti.order.dto.UserDTO;
import com.cotiviti.order.entity.Order;
import com.cotiviti.order.mapper.OrderMapper;
import com.cotiviti.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Order addOrder(OrderDTOFromFront orderDTOFromFront) {
//        int orderId = sequenceGenerator.generationNextOrderId();
        long orderId = System.currentTimeMillis();
        UserDTO user = getUserDetails(orderDTOFromFront.getUserId());
        Order order = new Order(orderId, orderDTOFromFront.getFoodItemList(), orderDTOFromFront.getRestaurant(), user);
        Order save = orderRepository.save(order);
        return save;

    }

    private UserDTO getUserDetails(int userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/getById/"+userId, UserDTO.class);
    }
}
