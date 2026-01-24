package com.HimanshuBagga.Projects.lovable_clone.DTO.auth;

public record SignUpRequest(
        String email,
        String name,
        String password
) {
}
