package com.HimanshuBagga.Projects.lovable_clone.enums;

import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public enum SubscriptionStatus {
    ACTIVE , TRAILING , CANCELLED , PAST_DUE , INCOMPLETE;

    public @Nullable SubscriptionResponse plansAvailable() {
        return null;
    }
}
