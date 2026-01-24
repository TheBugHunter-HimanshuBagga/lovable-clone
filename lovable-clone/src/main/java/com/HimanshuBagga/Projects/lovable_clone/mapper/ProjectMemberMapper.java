package com.HimanshuBagga.Projects.lovable_clone.mapper;

import com.HimanshuBagga.Projects.lovable_clone.DTO.members.MemberResponse;
import com.HimanshuBagga.Projects.lovable_clone.Entity.ProjectMember;
import com.HimanshuBagga.Projects.lovable_clone.Entity.User;
import org.aspectj.apache.bcel.classfile.Constant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    @Mapping(target = "userId", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "avatarUrl", source = "avatarUrl")
    @Mapping(target = "role", constant = "OWNER")
    @Mapping(target = "invitedAt", ignore = true)
    MemberResponse toProjectMemberResponseFromOwner(User owner);
    @Mapping(target = "userId", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "avatarUrl", source = "avatarUrl")
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "invitedAt", ignore = true)
    MemberResponse toProjectMemberResponseFromMember(User user);
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "avatarUrl", source = "user.avatarUrl")
    @Mapping(target = "role", source = "role")
    @Mapping(target = "invitedAt", source = "invitedAt")
    MemberResponse toProjectMemberInvited(ProjectMember member);
}
