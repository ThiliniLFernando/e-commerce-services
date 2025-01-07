package com.ecommerce.order_service.dto;

public record OrderDTO(
        String productName,
        Integer quantity,
        Double price,
        String clientName
) {
}
