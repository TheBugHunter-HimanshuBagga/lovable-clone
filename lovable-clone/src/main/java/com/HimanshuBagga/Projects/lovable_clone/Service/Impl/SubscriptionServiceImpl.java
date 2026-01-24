package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.CheckoutResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.Checkoutrequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.PortalResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.SubscriptionResponse;
import com.HimanshuBagga.Projects.lovable_clone.Service.SubscriptionService;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscriptions(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(Checkoutrequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
