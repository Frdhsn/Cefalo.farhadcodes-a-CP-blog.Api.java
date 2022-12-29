package com.springapi.farhadcodesacpblog.controller;

import com.springapi.farhadcodesacpblog.entity.Users;
import com.springapi.farhadcodesacpblog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping(path="/users/signup")
    public ResponseEntity<?> signUp(@RequestBody Users users)  {
        Users newUser =authService.signUp(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping(path="/users/login")
    public ResponseEntity<?> logIn(@RequestBody Users users) {
        Users newUser = null;
        try {
            newUser = authService.Login(users);
        } catch (AccessDeniedException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(newUser);
    }
}
