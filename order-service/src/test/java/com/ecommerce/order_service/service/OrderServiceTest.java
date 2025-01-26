package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.APIResponse;
import com.ecommerce.order_service.dto.OrderDTO;
import com.ecommerce.order_service.entity.Order;
import com.ecommerce.order_service.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    private OrderRepository orderRepository;
    private OrderService orderService;

    @BeforeEach
    void init(){
        orderRepository = Mockito.mock(OrderRepository.class);
        orderService = new OrderService(orderRepository);
    }

    @Test
    void testCreateOrder(){
        OrderDTO orderDTO = new OrderDTO("Laptop", 2, 100000.0, "Client 1");

        Order savedOrder = new Order();
        savedOrder.setId(1L);
        savedOrder.setProductName("Laptop");
        savedOrder.setPrice(100000.0);
        savedOrder.setQuantity(2);
        savedOrder.setClientName("Client 1");
        savedOrder.setOrderDate(LocalDateTime.now());
        savedOrder.setDeliveryDate(LocalDateTime.now());
        savedOrder.setStatus("active");

        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        APIResponse response = orderService.createOrder(orderDTO);

        assertTrue(response.success());
        assertEquals("Order created successfully", response.message());
        assertNotNull(response.data());

        verify(orderRepository,times(1)).save(any(Order.class));
    }

    @Test
    void testGetAllOrders(){

    }

}
