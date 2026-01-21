package com.theclassrooms.classroomservice.resolver;

import com.theclassrooms.classroomservice.dto.ClassroomDTO;
import com.theclassrooms.classroomservice.enums.ClassroomStatus;
import com.theclassrooms.classroomservice.enums.ClassroomType;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class ClassroomQueryResolver {

    private final List<ClassroomDTO> classrooms;

    public ClassroomQueryResolver() {
        this.classrooms = List.of(
                ClassroomDTO.builder()
                        .id(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                        .name("Spring Boot Fundamentals")
                        .description("Learn Spring Boot from scratch")
                        .type(ClassroomType.PUBLIC)
                        .status(ClassroomStatus.ACTIVE)
                        .instructorId(UUID.fromString("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa"))
                        .classCode("SPRING-101")
                        .build(),
                ClassroomDTO.builder()
                        .id(UUID.fromString("21111111-1111-1111-1111-111111111112"))
                        .name("Java Fundamentals")
                        .description("Learn Java")
                        .type(ClassroomType.PRIVATE)
                        .status(ClassroomStatus.ACTIVE)
                        .instructorId(UUID.fromString("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa"))
                        .classCode("JAVA-202")
                        .build()
        );
    }

    @QueryMapping
    public ClassroomDTO getClassroomById(UUID id) {
        return classrooms.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst().orElse(null);
    }

    @QueryMapping
    public List<ClassroomDTO> getClassroomsByInstructor(UUID instructorId) {
        return classrooms.stream()
                .filter(c -> instructorId.equals(c.getInstructorId()))
                .toList();
    }

    @QueryMapping
    public List<ClassroomDTO> getAllClassrooms() {
        return classrooms;
    }
}
