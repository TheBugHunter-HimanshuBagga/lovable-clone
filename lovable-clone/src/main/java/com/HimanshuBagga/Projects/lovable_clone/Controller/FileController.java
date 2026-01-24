package com.HimanshuBagga.Projects.lovable_clone.Controller;

import com.HimanshuBagga.Projects.lovable_clone.DTO.project.FileContentResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.FileNode;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.FileTreeResponse;
import com.HimanshuBagga.Projects.lovable_clone.Service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project/{projectId}/files")
public class FileController {
    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId){
        Long UserId = 1L;
        return ResponseEntity.ok(fileService.getFileTree(projectId , UserId));
    }

    @GetMapping("/*path")
    public ResponseEntity<FileContentResponse> getFile(@PathVariable Long projectId , @PathVariable String path){
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileContent(projectId ,path,userId ));
    }

}
