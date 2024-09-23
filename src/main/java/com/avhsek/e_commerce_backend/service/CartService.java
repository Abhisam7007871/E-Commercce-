package com.avhsek.e_commerce_backend.service;

import com.avhsek.e_commerce_backend.entity.Cart;
import com.avhsek.e_commerce_backend.entity.Product;
import com.avhsek.e_commerce_backend.entity.User;
import com.avhsek.e_commerce_backend.repository.CartRepository;
import com.avhsek.e_commerce_backend.repository.ProductRepository;
import com.avhsek.e_commerce_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Cart addToCart(Long userId, Long productId, int quantity){
        // Find the user, find the product, and add it to the user's cart
        User user = userRepository.findById(userId).orElseThrow(()->  new RuntimeException("User not found."));
        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found."));

        Cart cart = cartRepository.findByUser(user).orElse(new Cart(user));

        Cart.CartItem cartItem = new Cart.CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        cart.getCartItems().add(cartItem);
        return  cartRepository.save(cart);

    }

    public Cart getCart(Long userId){
        return cartRepository.findByUserId(userId);
    }


}
