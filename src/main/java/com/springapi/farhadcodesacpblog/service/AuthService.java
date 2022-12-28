package com.springapi.farhadcodesacpblog.service;

import com.springapi.farhadcodesacpblog.entity.User;
import com.springapi.farhadcodesacpblog.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    public User signUp(User user)  {

        String email=user.getEmail();
        Optional<User> existUser=userRepository.findByEmail(email);

        return userRepository.save(user);

    }

    public User Login(User user)   {

        String userEmail= user.getEmail();
        String userPassword= user.getPassword();
        Optional<User> newUser=userRepository.findByEmail(userEmail);

        String hashPass=newUser.get().getPassword();

        return newUser.get();
    }
}
