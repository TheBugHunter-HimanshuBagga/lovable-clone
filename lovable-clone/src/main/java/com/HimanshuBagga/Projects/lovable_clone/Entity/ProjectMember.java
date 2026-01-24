package com.HimanshuBagga.Projects.lovable_clone.Entity;

import com.HimanshuBagga.Projects.lovable_clone.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "project_members")
public class ProjectMember {
    @EmbeddedId // we need to pass 2 param , from this we can define composite id
            // composite key means primary key is made up of more than one column
    ProjectMemberId id;
    @ManyToOne
    @MapsId("projectId") // It maps to a field inside the embeddedId
    Project project;
    @ManyToOne
    @MapsId("UserId") // join table + additional fields
    User user;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectRole role;

    Instant invitedAt;
    Instant acceptedAt;

}
