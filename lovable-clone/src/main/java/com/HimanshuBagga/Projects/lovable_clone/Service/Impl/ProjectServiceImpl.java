package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.HimanshuBagga.Projects.lovable_clone.Entity.Project;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import com.HimanshuBagga.Projects.lovable_clone.Service.ProjectService;
import com.HimanshuBagga.Projects.lovable_clone.mapper.ProjectMapper;
import com.HimanshuBagga.Projects.lovable_clone.repository.ProjectRepository;
import com.HimanshuBagga.Projects.lovable_clone.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional // rolls back completely if not worked successfuly
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;
    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {

        return projectRepository.findAllAccessibleByUser(userId)
                .stream()
                .map(project -> projectMapper.toProjectSummaryResponse(project))
                .collect(Collectors.toList());

//        var project = projectRepository.findAllAccessibleByUser(userId);
//        return projectMapper.toListOfProjectSummaryResponse(project);

    }

    @Override
    public ProjectResponse getProjectById(Long id, Long userId) {
        Project project = projectRepository.findAccessibleProjectsById(id , userId).orElseThrow();
//        return modelMapper.map(project , ProjectResponse.class);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .build();
        project = projectRepository.save(project); // now project to projectResponse record dto
//       return modelMapper.map(project  , ProjectResponse.class);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request,Long userId) {

        Project project = projectRepository.findAccessibleProjectsById(id , userId).orElseThrow();
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("U are not allowed to update");
        }
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = projectRepository.findAccessibleProjectsById(id , userId).orElseThrow();
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("U are not allowed to delete");
        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }
}
