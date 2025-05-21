package com.tarecette.api.services;

import com.tarecette.api.dto.LoginRequest;

public interface UserDetailsService {
    LoginRequest loadUserByUsername(String email);
}
