package com.HimanshuBagga.Projects.lovable_clone.Service;

import com.HimanshuBagga.Projects.lovable_clone.DTO.members.InviteMemberRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.members.MemberResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.members.updateMemberRole;

import java.util.List;

public interface ProjectMemberService {

    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId , InviteMemberRequest request);


    MemberResponse updateMemberRole(Long projectId, Long memberId, updateMemberRole request);

    void deleteMember(Long projectId,Long memberId);

}
