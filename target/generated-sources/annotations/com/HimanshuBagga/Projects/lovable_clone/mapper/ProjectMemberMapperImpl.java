package com.HimanshuBagga.Projects.lovable_clone.mapper;

import com.HimanshuBagga.Projects.lovable_clone.DTO.members.MemberResponse;
import com.HimanshuBagga.Projects.lovable_clone.Entity.ProjectMember;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import com.HimanshuBagga.Projects.lovable_clone.enums.ProjectRole;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-15T12:11:46+0530",
    comments = "version: 1.6.0, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class ProjectMemberMapperImpl implements ProjectMemberMapper {

    @Override
    public MemberResponse toProjectMemberResponseFromOwner(User owner) {
        if ( owner == null ) {
            return null;
        }

        Long userId = null;
        String name = null;
        String username = null;

        userId = owner.getId();
        name = owner.getName();
        username = owner.getUsername();

        ProjectRole role = ProjectRole.OWNER;
        Instant invitedAt = null;
        String avatarUrl = null;

        MemberResponse memberResponse = new MemberResponse( userId, name, username, avatarUrl, role, invitedAt );

        return memberResponse;
    }

    @Override
    public MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember) {
        if ( projectMember == null ) {
            return null;
        }

        Long userId = null;
        String name = null;
        String username = null;
        ProjectRole role = null;
        Instant invitedAt = null;

        userId = projectMemberUserId( projectMember );
        name = projectMemberUserName( projectMember );
        username = projectMemberUserUsername( projectMember );
        role = projectMember.getRole();
        invitedAt = projectMember.getInvitedAt();

        String avatarUrl = null;

        MemberResponse memberResponse = new MemberResponse( userId, name, username, avatarUrl, role, invitedAt );

        return memberResponse;
    }

    @Override
    public MemberResponse toProjectMemberInvited(ProjectMember member) {
        if ( member == null ) {
            return null;
        }

        Long userId = null;
        String name = null;
        String username = null;
        ProjectRole role = null;
        Instant invitedAt = null;

        userId = projectMemberUserId( member );
        name = projectMemberUserName( member );
        username = projectMemberUserUsername( member );
        role = member.getRole();
        invitedAt = member.getInvitedAt();

        String avatarUrl = null;

        MemberResponse memberResponse = new MemberResponse( userId, name, username, avatarUrl, role, invitedAt );

        return memberResponse;
    }

    private Long projectMemberUserId(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    private String projectMemberUserName(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getName();
    }

    private String projectMemberUserUsername(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getUsername();
    }
}
