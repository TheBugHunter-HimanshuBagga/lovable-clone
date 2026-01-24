package com.HimanshuBagga.Projects.lovable_clone.Service;

import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.CheckoutResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.Checkoutrequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.PortalResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public interface SubscriptionService {

    SubscriptionResponse getCurrentSubscriptions(Long userId);


    CheckoutResponse createCheckoutSessionUrl(Checkoutrequest request, Long userId);


    PortalResponse openCustomerPortal(Long userId);


}
