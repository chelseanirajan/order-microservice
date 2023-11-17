package com.cotiviti.order.service;

import com.cotiviti.order.dto.OrderDTO;
import com.cotiviti.order.dto.OrderDTOFromFront;
import com.cotiviti.order.entity.Order;

public interface OrderService {
    public Order addOrder(OrderDTOFromFront orderDTOFromFront);
}
