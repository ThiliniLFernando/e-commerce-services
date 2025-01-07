package com.ecommerce.order_service.dto;

public record APIResponse(
        String message,
        Object data,
        boolean success
) {
}
