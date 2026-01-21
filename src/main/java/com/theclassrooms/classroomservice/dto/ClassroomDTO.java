package com.theclassrooms.classroomservice.dto;

import com.theclassrooms.classroomservice.enums.ClassroomStatus;
import com.theclassrooms.classroomservice.enums.ClassroomType;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
public class ClassroomDTO {
    private UUID id;
    private String name;
    private String description;
    private ClassroomType type;
    private ClassroomStatus status;
    private UUID instructorId;
    private String classCode;
    private OffsetDateTime endTime;
}
