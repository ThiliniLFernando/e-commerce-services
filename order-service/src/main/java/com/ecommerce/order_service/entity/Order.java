package com.ecommerce.order_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "product_order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private int quantity;

    private double price;

    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;

    private String clientName;

    private String status;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", clientName='" + clientName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
