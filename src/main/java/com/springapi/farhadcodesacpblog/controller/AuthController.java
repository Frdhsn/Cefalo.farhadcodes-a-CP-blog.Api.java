package com.springapi.farhadcodesacpblog.controller;

import com.springapi.farhadcodesacpblog.entity.Users;
import com.springapi.farhadcodesacpblog.security.handlers.AuthenticateManager;
import com.springapi.farhadcodesacpblog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticateManager authenticateManager;
    @PostMapping(path = "/signup")
    public ResponseEntity<?> signUp(@RequestBody Users users)  {
        Users newUser =authService.signUp(users);
        String token = authenticateManager.authenticate(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(token);
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> logIn(@RequestBody Users users) {
        Users newUser = authService.Login(users);
        String token = authenticateManager.authenticate(newUser);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
