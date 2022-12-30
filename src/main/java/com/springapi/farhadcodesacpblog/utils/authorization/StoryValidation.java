package com.springapi.farhadcodesacpblog.utils.authorization;

import com.springapi.farhadcodesacpblog.entity.Story;
import com.springapi.farhadcodesacpblog.entity.Users;
import com.springapi.farhadcodesacpblog.exceptions.UnauthorizedException;
import com.springapi.farhadcodesacpblog.security.IAuthenticationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoryValidation {
    @Autowired
    private IAuthenticationHelper authenticationHelper;

    public boolean verify(Optional<Story> story){
        Authentication authentication = authenticationHelper.getAuthentication();

        if(!authentication.isAuthenticated()) return false;

        String currEmail = authentication.getName();
        Users author = story.get().getAuthorId();
        String authEmail = author.getEmail();

        return currEmail.equals(authEmail);
    }
    public String getCurrentAuthorName(){
        Authentication authentication = authenticationHelper.getAuthentication();
        if(!authentication.isAuthenticated()) throw new UnauthorizedException(authentication.getName()+" is not authenticated!");
        return authentication.getName();
    }
}
