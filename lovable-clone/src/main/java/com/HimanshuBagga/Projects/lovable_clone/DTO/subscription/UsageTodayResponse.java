package com.HimanshuBagga.Projects.lovable_clone.DTO.subscription;

public record UsageTodayResponse(
        Integer tokenUsed,
        Integer tokenLimit,
        Integer previewRunning,
        Integer previewLimit
) {
}
