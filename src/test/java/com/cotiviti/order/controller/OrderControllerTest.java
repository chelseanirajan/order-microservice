package com.cotiviti.order.controller;

import com.cotiviti.order.dto.*;
import com.cotiviti.order.entity.Order;
import com.cotiviti.order.service.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class OrderControllerTest {

    @InjectMocks
    OrderController orderController;

    @Mock
    OrderServiceImpl orderService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testAddOrder(){

        Order order = new Order();
        OrderDTOFromFront orderDTOFromFront = new OrderDTOFromFront();
        List<FootItemDTO> footItemDTOList = Arrays.asList(
                new FootItemDTO(1, "fry chicken", "testy",33, 1, false, 23 ),
        new FootItemDTO(1, "fry chicken", "testy",33, 1, false, 23 )
        );
        Restaurant restaurant = new Restaurant(1, "Restaurant 1", "rest", "Texas", "Ronoke");
        UserDTO user = new UserDTO(1, "Nirajan", "nirajan@123", "roanoke", "texas");
        orderDTOFromFront.setRestaurant(restaurant);
        orderDTOFromFront.setFoodItemList(footItemDTOList);
        orderDTOFromFront.setUserId(1);
        order.setOrderId(123);
        order.setFootItemList(footItemDTOList);
        order.setRestaurant(restaurant);
        order.setUserDTO(user);

        when(orderService.addOrder(orderDTOFromFront)).thenReturn(order);

        ResponseEntity<Order> response = orderController.addOrder(orderDTOFromFront);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(order, response.getBody());

        verify(orderService, times(1)).addOrder(orderDTOFromFront);
    }
}
