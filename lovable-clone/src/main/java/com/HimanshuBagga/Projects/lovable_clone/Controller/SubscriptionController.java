package com.HimanshuBagga.Projects.lovable_clone.Controller;

import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.*;
import com.HimanshuBagga.Projects.lovable_clone.Service.PlanService;
import com.HimanshuBagga.Projects.lovable_clone.Service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // automatically creats constructors on our behaf
@RequestMapping("/api")
public class SubscriptionController {
    private final SubscriptionService subscriptionService; // its constructor is generated automatically using entities
    private final PlanService planService;

    @GetMapping("/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans(){
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.getCurrentSubscriptions(userId));
    }

    @PostMapping("/stripe/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(@RequestBody Checkoutrequest request){
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(request , userId));
    }

    @PostMapping("/stripe/portal")
    public ResponseEntity<PortalResponse> openCustoomerPortal(){
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
    }
}
