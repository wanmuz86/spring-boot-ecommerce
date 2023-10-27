package com.example.ecommerce.entity;

import com.example.ecommerce.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderDescription;
    private Date date;
    private Double amount;
    private String address;
    private String payment;
    private OrderStatus orderStatus;
    private Double totalAmount;
    private Double discount;
    private UUID trackingId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<CartItem> cartItems;


}
