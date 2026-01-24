package com.HimanshuBagga.Projects.lovable_clone.DTO.members;

import com.HimanshuBagga.Projects.lovable_clone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record updateMemberRole(
        @NotNull
        ProjectRole role
) {
}
