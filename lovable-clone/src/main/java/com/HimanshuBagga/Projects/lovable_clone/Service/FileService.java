package com.HimanshuBagga.Projects.lovable_clone.Service;

import com.HimanshuBagga.Projects.lovable_clone.DTO.project.FileContentResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.FileNode;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.FileTreeResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {


    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);


}
