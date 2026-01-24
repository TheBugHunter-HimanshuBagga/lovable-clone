package com.HimanshuBagga.Projects.lovable_clone.Controller;


import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.AuthResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.LoginRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.SignUpRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.UserProfileResponse;
import com.HimanshuBagga.Projects.lovable_clone.Service.AuthService;
import com.HimanshuBagga.Projects.lovable_clone.Service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
public class AuthController {

    AuthService authService;
    UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
