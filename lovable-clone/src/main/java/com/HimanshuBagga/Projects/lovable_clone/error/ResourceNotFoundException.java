package com.HimanshuBagga.Projects.lovable_clone.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PACKAGE)
public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    Long resourceId;
}
