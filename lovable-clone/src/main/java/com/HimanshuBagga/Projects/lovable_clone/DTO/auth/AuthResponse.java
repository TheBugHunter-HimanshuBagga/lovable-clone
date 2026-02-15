package com.HimanshuBagga.Projects.lovable_clone.DTO.auth;

public record AuthResponse(
        String token,
        UserProfileResponse response
) {
}
