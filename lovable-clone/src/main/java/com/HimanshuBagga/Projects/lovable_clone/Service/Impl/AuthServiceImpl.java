package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.AuthResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.LoginRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.SignUpRequest;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import com.HimanshuBagga.Projects.lovable_clone.Service.AuthService;
import com.HimanshuBagga.Projects.lovable_clone.error.BadRequestException;
import com.HimanshuBagga.Projects.lovable_clone.mapper.UserMapper;
import com.HimanshuBagga.Projects.lovable_clone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/*
JWT stateless tokens
 */
@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public AuthResponse signup(SignUpRequest request){
        // signup flow -> if User exists throw exception-> if not create sign up
        userRepository.findByUsername(request.username()).ifPresent(
                user -> {
                    throw new BadRequestException("User already exists with username: " + request.username());
                });
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password())); // the password now will be stored in the form of #$@!%^@##$#@% not a string
        user = userRepository.save(user);
        return new AuthResponse("dummy" , userMapper.toUserProfileResponse(user));
    }
    @Override
    public AuthResponse login(LoginRequest request){
        return null;
    }
}
