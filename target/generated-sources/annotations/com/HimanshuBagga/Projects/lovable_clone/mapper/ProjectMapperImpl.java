package com.HimanshuBagga.Projects.lovable_clone.mapper;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.UserProfileResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.HimanshuBagga.Projects.lovable_clone.Entity.Project;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-24T15:23:45+0530",
    comments = "version: 1.6.0, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectResponse toProjectResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Instant createdAt = null;
        Instant updatedAt = null;
        UserProfileResponse owner = null;

        id = project.getId();
        name = project.getName();
        createdAt = project.getCreatedAt();
        updatedAt = project.getUpdatedAt();
        owner = userToUserProfileResponse( project.getOwner() );

        ProjectResponse projectResponse = new ProjectResponse( id, name, createdAt, updatedAt, owner );

        return projectResponse;
    }

    @Override
    public ProjectSummaryResponse toProjectSummaryResponse(Project project) {
        if ( project == null ) {
            return null;
        }

        String projectName = null;
        Long id = null;
        Instant createdAt = null;
        Instant updatedAt = null;

        projectName = project.getName();
        id = project.getId();
        createdAt = project.getCreatedAt();
        updatedAt = project.getUpdatedAt();

        ProjectSummaryResponse projectSummaryResponse = new ProjectSummaryResponse( id, projectName, createdAt, updatedAt );

        return projectSummaryResponse;
    }

    protected UserProfileResponse userToUserProfileResponse(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;
        String avatarUrl = null;

        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        avatarUrl = user.getAvatarUrl();

        UserProfileResponse userProfileResponse = new UserProfileResponse( id, name, email, avatarUrl );

        return userProfileResponse;
    }
}
