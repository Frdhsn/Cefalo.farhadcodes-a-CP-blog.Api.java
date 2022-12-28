package com.springapi.farhadcodesacpblog.controller;

import com.springapi.farhadcodesacpblog.entity.User;
import com.springapi.farhadcodesacpblog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping(path="/signup")
    public ResponseEntity<?> signUp(@RequestBody User users)  {
        User newUser =authService.signUp(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> signIn(@RequestBody User users) {
        User newUser = authService.Login(users);
        return ResponseEntity.status(HttpStatus.OK).body(newUser);
    }
}
