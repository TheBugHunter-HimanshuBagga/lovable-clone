package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.UserProfileResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.PlanLimitsResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.UsageTodayResponse;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import com.HimanshuBagga.Projects.lovable_clone.Service.UsageService;
import com.HimanshuBagga.Projects.lovable_clone.Service.UserService;
import com.HimanshuBagga.Projects.lovable_clone.error.ResourceNotFoundException;
import com.HimanshuBagga.Projects.lovable_clone.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(username).orElseThrow(
                ()   -> new ResourceNotFoundException("User Not found with id: " , 1L)
        );
    }
}
