package com.theclassrooms.classroomservice.repository;

import com.theclassrooms.classroomservice.entity.ClassroomMemberEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassroomMemberRepository extends JpaRepository<@NonNull ClassroomMemberEntity, @NonNull UUID> {
}
