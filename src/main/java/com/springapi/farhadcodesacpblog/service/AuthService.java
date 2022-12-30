package com.springapi.farhadcodesacpblog.service;

import com.springapi.farhadcodesacpblog.entity.Users;
import com.springapi.farhadcodesacpblog.exceptions.BadRequestException;
import com.springapi.farhadcodesacpblog.exceptions.NotFoundException;
import com.springapi.farhadcodesacpblog.exceptions.UnauthorizedException;
import com.springapi.farhadcodesacpblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    public Users signUp(Users user)  {
        String email = user.getEmail();
        Optional<Users> fetchedUser = userRepository.findByEmail(email);

        if(fetchedUser.isPresent()) throw new BadRequestException(email+" already exists");

        String pass= passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        return userRepository.save(user);
    }
    public Users Login(Users user) {

        String userEmail= user.getEmail();
        String userPassword= user.getPassword();
        Optional<Users> newUser=userRepository.findByEmail(userEmail);

        if(newUser.isEmpty()) throw new NotFoundException(Users.class,"Email",userEmail);

        String hashPass=newUser.get().getPassword();
        assert passwordEncoder.matches(userPassword, hashPass);
        if(!passwordEncoder.matches(userPassword, hashPass)) throw  new UnauthorizedException(user.getEmail()+" and "+ user.getPassword()+" did not match");
        return newUser.get();
    }
}
