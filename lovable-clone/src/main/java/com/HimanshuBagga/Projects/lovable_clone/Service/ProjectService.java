package com.HimanshuBagga.Projects.lovable_clone.Service;

import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getProjectById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id,ProjectRequest request ,Long userId);

    void softDelete(Long id, Long userId);

}
