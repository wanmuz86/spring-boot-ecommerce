package com.example.ecommerce.repository;

import com.example.ecommerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemsRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByProductIdAndOrderIdAndUserId(Long productId, Long orderId, Long userId);
}
