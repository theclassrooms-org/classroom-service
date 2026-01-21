package com.theclassrooms.classroomservice.repository;

import com.theclassrooms.classroomservice.entity.ClassroomEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassroomRepository extends JpaRepository<@NonNull ClassroomEntity, @NonNull UUID> {
}
