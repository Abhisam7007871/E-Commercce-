package com.avhsek.e_commerce_backend.service;

import com.avhsek.e_commerce_backend.entity.Cart;
import com.avhsek.e_commerce_backend.entity.Order;
import com.avhsek.e_commerce_backend.entity.OrderItem;
import com.avhsek.e_commerce_backend.entity.User;
import com.avhsek.e_commerce_backend.repository.CartRepository;
import com.avhsek.e_commerce_backend.repository.OrderRepository;
import com.avhsek.e_commerce_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public Order placeOrder(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        Cart cart = cartRepository.findByUser(user).orElseThrow(() -> new RuntimeException("Cart not found"));

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        // Move items from cart to order
        for(Cart.CartItem cartItem: cart.getCartItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            order.getOrderItems().add(orderItem);

        }

        //clear the cart
        cart.getCartItems().clear();

        return orderRepository.save(order);

    }


}
