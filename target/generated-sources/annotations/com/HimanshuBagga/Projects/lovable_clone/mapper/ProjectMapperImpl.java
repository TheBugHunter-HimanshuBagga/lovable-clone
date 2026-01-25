package com.HimanshuBagga.Projects.lovable_clone.mapper;

import com.HimanshuBagga.Projects.lovable_clone.DTO.auth.UserProfileResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.HimanshuBagga.Projects.lovable_clone.Entity.Project;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-25T11:15:04+0530",
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

        id = project.getId();
        name = project.getName();
        createdAt = project.getCreatedAt();
        updatedAt = project.getUpdatedAt();

        UserProfileResponse owner = null;

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

    @Override
    public List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> project) {
        if ( project == null ) {
            return null;
        }

        List<ProjectSummaryResponse> list = new ArrayList<ProjectSummaryResponse>( project.size() );
        for ( Project project1 : project ) {
            list.add( toProjectSummaryResponse( project1 ) );
        }

        return list;
    }
}
