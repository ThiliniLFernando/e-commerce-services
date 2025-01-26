package com.ecommerce.order_service.controller;

import com.ecommerce.order_service.dto.APIResponse;
import com.ecommerce.order_service.dto.OrderDTO;
import com.ecommerce.order_service.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("")
    public ResponseEntity<APIResponse> createOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(orderService.createOrder(orderDTO), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<APIResponse> getAllOrders(Pageable pageable) {
        return new ResponseEntity<>(orderService.getAllOrders(pageable), HttpStatus.OK);
    }

}
