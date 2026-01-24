package com.HimanshuBagga.Projects.lovable_clone.Controller;

import com.HimanshuBagga.Projects.lovable_clone.DTO.members.InviteMemberRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.members.MemberResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.members.updateMemberRole;
import com.HimanshuBagga.Projects.lovable_clone.Entity.ProjectMember;
import com.HimanshuBagga.Projects.lovable_clone.Service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // automatically creats constructors on our behaf
@RequestMapping("/api/project/{projectId}/members")
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId , userId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId , @RequestBody InviteMemberRequest request){
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(
            projectMemberService.inviteMember(projectId , userId , request)
        );
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long projectId , @PathVariable Long memberId, @RequestBody updateMemberRole request){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,userId,memberId , request));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long projectId , @PathVariable Long memberId){
        Long userId = 1L;
        projectMemberService.deleteMember(projectId,userId,memberId);
        return ResponseEntity.noContent().build();
    }
}
