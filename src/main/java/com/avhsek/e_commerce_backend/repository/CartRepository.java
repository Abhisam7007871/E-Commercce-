package com.avhsek.e_commerce_backend.repository;

import com.avhsek.e_commerce_backend.entity.Cart;
import com.avhsek.e_commerce_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
