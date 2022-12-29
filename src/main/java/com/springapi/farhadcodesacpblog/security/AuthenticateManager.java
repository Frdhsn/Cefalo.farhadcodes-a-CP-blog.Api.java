package com.springapi.farhadcodesacpblog.security;

import com.springapi.farhadcodesacpblog.entity.Users;
import com.springapi.farhadcodesacpblog.security.utils.JwtRequestFilter;
import com.springapi.farhadcodesacpblog.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticateManager {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceHandler userDetails;

    public String authenticate(Users users){
        final UserDetails _userDetails= userDetails.loadUserByUsername(users.getEmail());
        final String token= jwtUtil.generateToken(_userDetails);
        return token;

    }
}
