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
    @Mapping(target = "username", source = "username")
    @Mapping(target = "role", constant = "OWNER")
    @Mapping(target = "invitedAt", ignore = true)
    MemberResponse toProjectMemberResponseFromOwner(User owner);
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "role", source = "role")
    @Mapping(target = "invitedAt", source = "invitedAt")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "role", source = "role")
    @Mapping(target = "invitedAt", source = "invitedAt")
    MemberResponse toProjectMemberInvited(ProjectMember member);

}
