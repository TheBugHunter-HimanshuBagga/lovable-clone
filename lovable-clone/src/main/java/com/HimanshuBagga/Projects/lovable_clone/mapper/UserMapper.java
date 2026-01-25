package com.HimanshuBagga.Projects.lovable_clone.mapper;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.SignUpRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.UserProfileResponse;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(SignUpRequest signUpRequest);

    UserProfileResponse toUserProfileResponse(User user);
}
