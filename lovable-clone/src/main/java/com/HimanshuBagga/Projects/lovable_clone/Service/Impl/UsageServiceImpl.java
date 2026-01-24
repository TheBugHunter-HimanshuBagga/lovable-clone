package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.PlanLimitsResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.UsageTodayResponse;
import com.HimanshuBagga.Projects.lovable_clone.Service.UsageService;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
