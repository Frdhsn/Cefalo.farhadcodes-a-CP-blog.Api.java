/*
package com.springapi.farhadcodesacpblog.handlers;

import com.springapi.farhadcodesacpblog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class Validator {
    @Autowired
    private IAuthenticationHandler _auth;
    public boolean isValid(User newUser){
        Authentication authentication = _auth.getAuthentication();
        if(!authentication.isAuthenticated()) return false;
        String CurrentUserEmail= authentication.getName();
        String authorEMail=newUser.getEmail();
        return CurrentUserEmail.equals(authorEMail);
    }
}
*/
