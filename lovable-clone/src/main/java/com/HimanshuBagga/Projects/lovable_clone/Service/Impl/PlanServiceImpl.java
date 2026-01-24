package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.PlanResponse;
import com.HimanshuBagga.Projects.lovable_clone.Service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
