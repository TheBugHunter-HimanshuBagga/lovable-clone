package com.HimanshuBagga.Projects.lovable_clone.DTO.members;

import com.HimanshuBagga.Projects.lovable_clone.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String name,
        String username,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
