package com.HimanshuBagga.Projects.lovable_clone.DTO.auth;


public record UserProfileResponse(
        Long id,
        String name,
        String username,
        String avatarUrl
) {
}
