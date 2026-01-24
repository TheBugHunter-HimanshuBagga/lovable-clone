package com.HimanshuBagga.Projects.lovable_clone.mapper;

import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.HimanshuBagga.Projects.lovable_clone.Entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project); // convert project object to toProjectResponse


    @Mapping(source = "name", target = "projectName")
        //    @Mapping(target = "createdAt" , dateFormat = "YYYY-MM-DD")
    ProjectSummaryResponse toProjectSummaryResponse(Project project); // entity to dto
//    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> project);



}
