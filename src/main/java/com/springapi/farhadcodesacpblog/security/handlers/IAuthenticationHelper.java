package com.springapi.farhadcodesacpblog.security.handlers;

import org.springframework.security.core.Authentication;

public interface IAuthenticationHelper {
    Authentication getAuthentication();
}
