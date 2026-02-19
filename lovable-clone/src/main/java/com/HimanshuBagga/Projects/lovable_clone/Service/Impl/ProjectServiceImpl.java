package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.HimanshuBagga.Projects.lovable_clone.Entity.Project;
import com.HimanshuBagga.Projects.lovable_clone.Entity.ProjectMember;
import com.HimanshuBagga.Projects.lovable_clone.Entity.ProjectMemberId;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import com.HimanshuBagga.Projects.lovable_clone.Service.ProjectService;
import com.HimanshuBagga.Projects.lovable_clone.enums.ProjectRole;
import com.HimanshuBagga.Projects.lovable_clone.error.ResourceNotFoundException;
import com.HimanshuBagga.Projects.lovable_clone.mapper.ProjectMapper;
import com.HimanshuBagga.Projects.lovable_clone.repository.ProjectMemberRepository;
import com.HimanshuBagga.Projects.lovable_clone.repository.ProjectRepository;
import com.HimanshuBagga.Projects.lovable_clone.repository.UserRepository;
import com.HimanshuBagga.Projects.lovable_clone.security.AuthUtil;
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
    private final ProjectMemberRepository projectMemberRepository;
    private final AuthUtil authUtil;
    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        return projectRepository.findAllAccessibleByUser(userId)
                .stream()
                .map(project -> projectMapper.toProjectSummaryResponse(project))
                .collect(Collectors.toList());

//        var project = projectRepository.findAllAccessibleByUser(userId);
//        return projectMapper.toListOfProjectSummaryResponse(project);

    }

    @Override
    public ProjectResponse getProjectById(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = projectRepository
                .findAccessibleProjectsById(id , userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project " , id)
        );
//        return modelMapper.map(project , ProjectResponse.class);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();

//        User owner = userRepository.findById(userId).orElseThrow( // it will make a db call
//                () -> new ResourceNotFoundException("User" , userId)
//        );

        User owner = userRepository.getReferenceById(userId); // no db call is done here

        Project project = Project.builder()
                .name(request.name())
//                .owner(owner)
                .isPublic(false)
                .build();

        project = projectRepository.save(project); // now db will create a project id for this project

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());//This exact user in this exact project”

        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .role(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);
//      return modelMapper.map(project  , ProjectResponse.class);

    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();

        Project project = projectRepository.findAccessibleProjectsById(id , userId).orElseThrow(
                () -> new ResourceNotFoundException("Project" , userId)
        );
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("U are not allowed to update");
//        }
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id) {
        Long userId = authUtil.getCurrentUserId();

        Project project = projectRepository.findAccessibleProjectsById(id , userId).orElseThrow(
                () -> new ResourceNotFoundException("Project" , userId)
        );
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("U are not allowed to delete");
//        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }
}
