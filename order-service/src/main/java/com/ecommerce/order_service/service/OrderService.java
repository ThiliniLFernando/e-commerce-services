package com.ecommerce.order_service.service;

import com.ecommerce.order_service.constants.OrderStatus;
import com.ecommerce.order_service.dto.APIResponse;
import com.ecommerce.order_service.dto.OrderDTO;
import com.ecommerce.order_service.entity.Order;
import com.ecommerce.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public APIResponse createOrder(OrderDTO orderDTO){
        Order order = new Order();
        order.setProductName(orderDTO.productName());
        order.setQuantity(orderDTO.quantity());
        order.setPrice(orderDTO.price());
        order.setClientName(orderDTO.clientName());

        order.setOrderDate(LocalDateTime.now());
        order.setDeliveryDate(LocalDateTime.now());
        order.setStatus(OrderStatus.active.name());

        order = orderRepository.save(order);

        return new APIResponse("Order created successfully", order, true);
    }

    public APIResponse getAllOrders() {
        Optional<List<Order>> orders = orderRepository.findAllByStatus(OrderStatus.active.name());
        return new APIResponse("Orders fetched successfully", orders, true);
    }

    public APIResponse getAllOrders(Pageable pageable){
        Page<Order> orders =orderRepository.findAllByStatus(pageable, OrderStatus.active.name());
        return new APIResponse("Orders fetched successfully", orders, true);
    }

}
