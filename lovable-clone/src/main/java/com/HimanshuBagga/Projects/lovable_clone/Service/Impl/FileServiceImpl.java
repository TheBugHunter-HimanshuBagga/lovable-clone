package com.HimanshuBagga.Projects.lovable_clone.Service.Impl;

import com.HimanshuBagga.Projects.lovable_clone.DTO.project.FileContentResponse;
import com.HimanshuBagga.Projects.lovable_clone.DTO.project.FileNode;
import com.HimanshuBagga.Projects.lovable_clone.Service.FileService;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
