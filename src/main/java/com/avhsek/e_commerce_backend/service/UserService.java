package com.avhsek.e_commerce_backend.service;

import com.avhsek.e_commerce_backend.entity.User;
import com.avhsek.e_commerce_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        // Hash password, set role, and save the user
        user.setRole(User.Role.CUSTOMER);
        return userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found."));
    }


}
