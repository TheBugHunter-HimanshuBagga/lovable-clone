package com.HimanshuBagga.Projects.lovable_clone.DTO.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
        @NotBlank
        String name
) {
}
