package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.AuthResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.LoginRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.SignUpRequest;
import com.HimanshuBagga.Projects.lovable_clone.Service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignUpRequest request){
        return null;
    }
    @Override
    public AuthResponse login(LoginRequest request){
        return null;
    }
}
