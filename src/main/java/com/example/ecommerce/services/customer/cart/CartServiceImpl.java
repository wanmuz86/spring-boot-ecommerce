package com.example.ecommerce.services.customer.cart;

import com.example.ecommerce.dto.AddProductInCartDto;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.enums.OrderStatus;
import com.example.ecommerce.repository.CartItemsRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private OrderRepository orderRepository;
    private CartItemsRepository cartItemsRepository;

    private UserRepository userRepository;

    private ProductRepository productRepository;

    public ResponseEntity<?>  addProductToCart(AddProductInCartDto addProductInCartDto){
        Order activeOrder = orderRepository.findByUserIdAndStatus(addProductInCartDto.getUserId(), OrderStatus.Pending);
        Optional<CartItem> optionalCartItems  =cartItemsRepository.findByProductIdAndOrderIdAndUserId(
                addProductInCartDto.getProductId(), activeOrder.getId(), addProductInCartDto.getUserId()
        );
        if (optionalCartItems.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        else {
            Optional<Product> optionalProduct = productRepository.findById(addProductInCartDto.getProductId());
            Optional<User> optionalUser = userRepository.findById(addProductInCartDto.getUserId());

            if (optionalProduct.isPresent() && optionalUser.isPresent()){
                CartItem cart = new CartItem();
                cart.setProduct(optionalProduct.get());
                cart.setPrice(optionalProduct.get().getPrice());
                cart.setQuantity(1L);
                cart.setUser(optionalUser.get());
                cart.setOrder(activeOrder);

                CartItem

            }


        }

    }

}
