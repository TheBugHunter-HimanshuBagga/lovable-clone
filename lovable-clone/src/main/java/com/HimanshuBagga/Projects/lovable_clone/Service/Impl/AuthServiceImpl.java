package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.AuthResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.LoginRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.SignUpRequest;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import com.HimanshuBagga.Projects.lovable_clone.Service.AuthService;
import com.HimanshuBagga.Projects.lovable_clone.error.BadRequestException;
import com.HimanshuBagga.Projects.lovable_clone.mapper.UserMapper;
import com.HimanshuBagga.Projects.lovable_clone.repository.UserRepository;
import com.HimanshuBagga.Projects.lovable_clone.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private final AuthUtil authUtil; // this will be injected since i have used @Component annotation there
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthResponse signup(SignUpRequest request){
        // signup flow -> if User exists throw exception-> if not create sign up
        userRepository.findByUsername(request.username()).ifPresent(
                user -> {
                    throw new BadRequestException("User already exists with username: " + request.username());
                });
        User user = userMapper.toEntity(request);// signUpRequest Convert into User entity
        user.setPassword(passwordEncoder.encode(request.password())); // the password now will be stored in the form of #$@!%^@##$#@% not a string
        user = userRepository.save(user); // save the user

        String token = authUtil.generateAccessToken(user); // generate a token

        return new AuthResponse(token , userMapper.toUserProfileResponse(user));
    }
    @Override
    public AuthResponse login(LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.username() , request.password()) // principle->username and credentials->password
        );
        User user = (User) authentication.getPrincipal(); // since this getPrinciple returns an object but considered as a user

        String token = authUtil.generateAccessToken(user);

        return new AuthResponse(token , userMapper.toUserProfileResponse(user));
        // AuthResponse -> object needed to be sent back after login

    }
}
