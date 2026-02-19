package com.HimanshuBagga.Projects.lovable_clone.Controller;

import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectRequest;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.ProjectSummaryResponse;
import com.HimanshuBagga.Projects.lovable_clone.Service.ProjectService;
import com.HimanshuBagga.Projects.lovable_clone.security.AuthUtil;
import jakarta.validation.Valid;
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
    private final AuthUtil authUtil;

    @GetMapping// get the projects of the user
    public ResponseEntity<List<ProjectSummaryResponse>> getUserProjects(){
        return ResponseEntity.ok(projectService.getUserProjects());
    }

    @GetMapping("/{id}")// get the project by Id
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id){
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody @Valid ProjectRequest request){ // it will first check that the projectRequest coming from the user is valid or not , if valid we will go into the controller layer
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id , @RequestBody @Valid ProjectRequest request){
        return ResponseEntity.ok(projectService.updateProject(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        projectService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
