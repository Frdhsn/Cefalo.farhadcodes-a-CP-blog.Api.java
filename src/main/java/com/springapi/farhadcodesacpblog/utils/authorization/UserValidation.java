package com.springapi.farhadcodesacpblog.utils.authorization;

import com.springapi.farhadcodesacpblog.entity.Users;
import com.springapi.farhadcodesacpblog.security.IAuthenticationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserValidation {
    @Autowired
    private IAuthenticationHelper authenticationHelper;

    public boolean verify(Users user){
        Authentication authentication = authenticationHelper.getAuthentication();

        if(!authentication.isAuthenticated())return false;
        String currEmail = authentication.getName();
        String authorEmail = user.getEmail();
        return currEmail.equals(authorEmail);
    }
}
