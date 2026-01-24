package com.HimanshuBagga.Projects.lovable_clone.DTO.subscription;

public record PlanLimitsResponse (
    String planName,
    Integer maxLimitPerDay,
    Integer maxProjects,
    Boolean unlimitedAi
){
}
