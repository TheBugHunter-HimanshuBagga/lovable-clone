package com.HimanshuBagga.Projects.lovable_clone.Controller;

import com.HimanshuBagga.Projects.lovable_clone.DTO.members.InviteMemberRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.members.MemberResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.members.updateMemberRole;
import com.HimanshuBagga.Projects.lovable_clone.Entity.ProjectMember;
import com.HimanshuBagga.Projects.lovable_clone.Service.ProjectMemberService;
import com.HimanshuBagga.Projects.lovable_clone.security.AuthUtil;
import jakarta.validation.Valid;
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
    private final AuthUtil authUtil;
    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId , @RequestBody @Valid InviteMemberRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(
            projectMemberService.inviteMember(projectId , request)
        );
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long projectId , @PathVariable Long memberId, @RequestBody @Valid updateMemberRole request){
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,memberId , request));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long projectId , @PathVariable Long memberId){
        projectMemberService.deleteMember(projectId,memberId);
        return ResponseEntity.noContent().build();
    }
}
