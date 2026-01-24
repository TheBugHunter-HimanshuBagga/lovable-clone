package com.HimanshuBagga.Projects.lovable_clone.DTO.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpRequest(
        @Email
        @NotBlank
        String username,
        @Size(min = 1 , max = 20)
        String name,
        @Size(min = 6 , max = 20)
        String password
) {
}
