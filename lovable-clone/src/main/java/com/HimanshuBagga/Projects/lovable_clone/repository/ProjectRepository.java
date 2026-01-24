package com.HimanshuBagga.Projects.lovable_clone.repository;

import com.HimanshuBagga.Projects.lovable_clone.Entity.Project;
import com.HimanshuBagga.Projects.lovable_clone.Entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // this interface extends jpa repo and jpa repo is implemented by simpleJpaRepository

    @Query("""
            SELECT p FROM Project p
            WHERE p.deletedAt IS NULL
            ORDER BY p.updatedAt DESC
            """)
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

    @Query("""
            Select p FROM Project p
            WHERE p.id = :projectId
                AND p.deletedAt IS NULL
            """)
    Optional<Project> findAccessibleProjectsById(@Param("projectId") Long projectId,
                                                 @Param("userId") Long userId);

    Optional<Object> findById(ProjectMemberId projectMemberId);

}
