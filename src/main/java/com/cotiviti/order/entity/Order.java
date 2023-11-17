package com.cotiviti.order.entity;

import com.cotiviti.order.dto.FootItemDTO;
import com.cotiviti.order.dto.Restaurant;
import com.cotiviti.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Order {
    private long orderId;
    private List<FootItemDTO> footItemList;
    private Restaurant restaurant;
    private UserDTO userDTO;

}
