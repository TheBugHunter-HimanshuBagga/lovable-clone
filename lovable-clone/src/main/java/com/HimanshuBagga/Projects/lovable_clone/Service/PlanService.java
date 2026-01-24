package com.HimanshuBagga.Projects.lovable_clone.Service;

import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.PlanResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
