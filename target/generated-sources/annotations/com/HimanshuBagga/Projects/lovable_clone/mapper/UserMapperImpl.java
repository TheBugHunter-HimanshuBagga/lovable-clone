package com.HimanshuBagga.Projects.lovable_clone.mapper;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.SignUpRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.UserProfileResponse;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-15T15:08:41+0530",
    comments = "version: 1.6.0, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(SignUpRequest signUpRequest) {
        if ( signUpRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( signUpRequest.username() );
        user.password( signUpRequest.password() );
        user.name( signUpRequest.name() );

        return user.build();
    }

    @Override
    public UserProfileResponse toUserProfileResponse(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String username = null;

        id = user.getId();
        name = user.getName();
        username = user.getUsername();

        UserProfileResponse userProfileResponse = new UserProfileResponse( id, name, username );

        return userProfileResponse;
    }
}
