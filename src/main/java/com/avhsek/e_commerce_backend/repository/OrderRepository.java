package com.avhsek.e_commerce_backend.repository;

import com.avhsek.e_commerce_backend.entity.Order;
import com.avhsek.e_commerce_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
