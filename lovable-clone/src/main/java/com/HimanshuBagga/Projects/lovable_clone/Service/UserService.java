package com.HimanshuBagga.Projects.lovable_clone.Service;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;

public interface UserService {

    UserProfileResponse getProfile(Long userId);

}
