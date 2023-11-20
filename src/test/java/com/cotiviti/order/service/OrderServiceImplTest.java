package com.cotiviti.order.service;

import com.cotiviti.order.dto.OrderDTO;
import com.cotiviti.order.dto.OrderDTOFromFront;
import com.cotiviti.order.dto.Restaurant;
import com.cotiviti.order.dto.UserDTO;
import com.cotiviti.order.entity.Order;
import com.cotiviti.order.mapper.OrderMapper;
import com.cotiviti.order.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class OrderServiceImplTest {
    @Mock
    OrderRepository orderRepository;
    @InjectMocks
    OrderServiceImpl orderService;
    @Mock
    RestTemplate restTemplate;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testAddOrder(){
        OrderDTOFromFront orderDetails = new OrderDTOFromFront();
        int newOrderId = 1;
        UserDTO userDTO = new UserDTO();
        Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemList(), orderDetails.getRestaurant(), userDTO);
        OrderDTO orderDTOExpected = OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);

        when(restTemplate.getForObject(anyString(), eq(UserDTO.class))).thenReturn(userDTO);
        when(orderRepository.save(orderToBeSaved)).thenReturn(orderToBeSaved);

        // Act

//        OrderDTO orderDTOActual = orderService.addOrder(orderDTOExpected);

        // Assert

        assertDoesNotThrow(() -> orderService.addOrder(orderDetails));
    }
}
