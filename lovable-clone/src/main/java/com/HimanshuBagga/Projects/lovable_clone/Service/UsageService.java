package com.HimanshuBagga.Projects.lovable_clone.Service;

import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.PlanLimitsResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {

    UsageTodayResponse getTodayUsageOfUser(Long userId);
    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
