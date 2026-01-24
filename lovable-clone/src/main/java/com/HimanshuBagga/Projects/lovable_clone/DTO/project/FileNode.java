package com.HimanshuBagga.Projects.lovable_clone.DTO.project;

import java.time.Instant;

public record FileNode(
        String path,
        Instant modified,
        Long size,
        String type
) {
}
