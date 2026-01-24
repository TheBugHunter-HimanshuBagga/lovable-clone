package com.HimanshuBagga.Projects.lovable_clone.Service;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.AuthResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.LoginRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.SignUpRequest;
import org.jspecify.annotations.Nullable;

public interface AuthService {

    AuthResponse signup(SignUpRequest request);

    AuthResponse login(LoginRequest request);


}
