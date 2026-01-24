package com.HimanshuBagga.Projects.lovable_clone.Controller;

import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.HimanshuBagga.Projects.lovable_clone.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping// get the projects of the user
    public ResponseEntity<List<ProjectSummaryResponse>> getUserProjects(){
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }

    @GetMapping("/{id}")// get the project by Id
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id){
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getProjectById(id , userId));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest request){
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request ,   userId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id , @RequestBody ProjectRequest request){
        Long userId = 1L;
        return ResponseEntity.ok(projectService.updateProject(id, request, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        Long userId = 1L;
        projectService.softDelete(id , userId);
        return ResponseEntity.noContent().build();
    }
}
