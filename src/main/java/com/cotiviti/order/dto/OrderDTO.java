package com.cotiviti.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private long orderId;
    private List<FootItemDTO> foodItemList;
    private Restaurant restaurant;
    private UserDTO userDTO;
}
