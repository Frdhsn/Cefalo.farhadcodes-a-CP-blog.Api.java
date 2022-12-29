package com.springapi.farhadcodesacpblog.security;

import org.springframework.security.core.Authentication;

public interface IAuthenticationHelper {
    Authentication getAuthentication();
}
