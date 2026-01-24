package com.HimanshuBagga.Projects.lovable_clone.DTO.subscription;

import java.time.Instant;

public record SubscriptionResponse(
    PlanResponse plan,
    String status,
    Instant periodEnd,
    Long tokenUsedThisCycle
) {
}
