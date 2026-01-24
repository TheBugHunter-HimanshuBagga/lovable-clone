package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.UserProfileResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.PlanLimitsResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.UsageTodayResponse;
import com.HimanshuBagga.Projects.lovable_clone.Service.UsageService;
import com.HimanshuBagga.Projects.lovable_clone.Service.UserService;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
