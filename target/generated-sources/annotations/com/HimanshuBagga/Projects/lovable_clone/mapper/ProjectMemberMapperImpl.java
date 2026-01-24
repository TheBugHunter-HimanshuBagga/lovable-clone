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
    date = "2026-01-08T23:39:15+0530",
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
        String email = null;
        String avatarUrl = null;

        userId = owner.getId();
        name = owner.getName();
        email = owner.getEmail();
        avatarUrl = owner.getAvatarUrl();

        ProjectRole role = ProjectRole.OWNER;
        Instant invitedAt = null;

        MemberResponse memberResponse = new MemberResponse( userId, name, email, avatarUrl, role, invitedAt );

        return memberResponse;
    }

    @Override
    public MemberResponse toProjectMemberResponseFromMember(User user) {
        if ( user == null ) {
            return null;
        }

        Long userId = null;
        String name = null;
        String email = null;
        String avatarUrl = null;

        userId = user.getId();
        name = user.getName();
        email = user.getEmail();
        avatarUrl = user.getAvatarUrl();

        ProjectRole role = null;
        Instant invitedAt = null;

        MemberResponse memberResponse = new MemberResponse( userId, name, email, avatarUrl, role, invitedAt );

        return memberResponse;
    }

    @Override
    public MemberResponse toProjectMemberInvited(ProjectMember member) {
        if ( member == null ) {
            return null;
        }

        Long userId = null;
        String name = null;
        String email = null;
        String avatarUrl = null;
        ProjectRole role = null;
        Instant invitedAt = null;

        userId = memberUserId( member );
        name = memberUserName( member );
        email = memberUserEmail( member );
        avatarUrl = memberUserAvatarUrl( member );
        role = member.getRole();
        invitedAt = member.getInvitedAt();

        MemberResponse memberResponse = new MemberResponse( userId, name, email, avatarUrl, role, invitedAt );

        return memberResponse;
    }

    private Long memberUserId(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    private String memberUserName(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getName();
    }

    private String memberUserEmail(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getEmail();
    }

    private String memberUserAvatarUrl(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getAvatarUrl();
    }
}
