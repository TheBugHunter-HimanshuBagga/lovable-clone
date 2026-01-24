package com.HimanshuBagga.Projects.lovable_clone.Entity;

import com.HimanshuBagga.Projects.lovable_clone.enums.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {

    Long id;

    User user;

    Plan plan;

    SubscriptionStatus status;

    String StripeCustomerId;

    String StripeSubscriptionId;

    Instant currentPeriodStart;
    Instant currentPeriodEnd;
    Boolean cancelAtPeriodEnd;

    Instant createdAt;

    Instant updatedAt;
}