package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.members.InviteMemberRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.members.MemberResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.members.updateMemberRole;
import com.HimanshuBagga.Projects.lovable_clone.Entity.Project;
import com.HimanshuBagga.Projects.lovable_clone.Entity.ProjectMember;
import com.HimanshuBagga.Projects.lovable_clone.Entity.ProjectMemberId;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import com.HimanshuBagga.Projects.lovable_clone.Service.ProjectMemberService;
import com.HimanshuBagga.Projects.lovable_clone.error.ResourceNotFoundException;
import com.HimanshuBagga.Projects.lovable_clone.mapper.ProjectMemberMapper;
import com.HimanshuBagga.Projects.lovable_clone.repository.ProjectMemberRepository;
import com.HimanshuBagga.Projects.lovable_clone.repository.ProjectRepository;
import com.HimanshuBagga.Projects.lovable_clone.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {
    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {

        Project project = projectRepository.findAccessibleProjectsById(projectId , userId).orElseThrow(
                () -> new ResourceNotFoundException("Project not found with id : " , projectId)
        ); // i got the project

        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, Long userId, InviteMemberRequest request) {
        Project project = projectRepository.findAccessibleProjectsById(projectId , userId).orElseThrow(
                () -> new ResourceNotFoundException("Project not found with id : " , projectId)
        );

//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("You are not allowed");
//        }

        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if(invitee.getId().equals(userId)){
            throw new RuntimeException("Cannot Invite Person");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,invitee.getId());

        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("User already a member ");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .role(request.role())
                .invitedAt(Instant.now())
                .build();
        projectMemberRepository.save(member);
        return projectMemberMapper.toProjectMemberInvited(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long userId, Long memberId, updateMemberRole request) {
        Project project = projectRepository.findAccessibleProjectsById(projectId,userId).orElseThrow();
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("Not Allowed");
//        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId , memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();
        projectMember.setRole(request.role());
        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toProjectMemberInvited(projectMember);
    }

    @Override
    public void deleteMember(Long projectId, Long userId, Long memberId) {
        Project project = projectRepository.findAccessibleProjectsById(projectId , userId).orElseThrow();
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("Not Allowed");
//        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId , memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Not Found");
        }
        projectMemberRepository.deleteById(projectMemberId);
    }
}
