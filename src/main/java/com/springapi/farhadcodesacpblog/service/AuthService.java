package com.springapi.farhadcodesacpblog.service;

import com.springapi.farhadcodesacpblog.entity.Users;
import com.springapi.farhadcodesacpblog.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    public Users signUp(Users user)  {
        String pass= passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        return userRepository.save(user);
    }
    public Users Login(Users user) throws AccessDeniedException {

        String userEmail= user.getEmail();
        String userPassword= user.getPassword();
        Optional<Users> newUser=userRepository.findByEmail(userEmail);

        String hashPass=newUser.get().getPassword();
        if(passwordEncoder.matches(userPassword, hashPass)==false) throw  new AccessDeniedException(user.getEmail()+" and "+ user.getPassword()+" did not match");
        return newUser.get();
    }
}
