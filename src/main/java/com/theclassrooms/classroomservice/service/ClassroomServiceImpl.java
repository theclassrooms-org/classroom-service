package com.theclassrooms.classroomservice.service;

import com.theclassrooms.classroomservice.entity.ClassroomEntity;
import com.theclassrooms.classroomservice.mapper.ClassroomMapper;
import com.theclassrooms.classroomservice.repository.ClassroomRepository;
import com.theclassrooms.proto.classroom.GetClassroomRequest;
import com.theclassrooms.proto.classroom.GetClassroomResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final ClassroomMapper classroomMapper;

    @Override
    public GetClassroomResponse getClassroom(GetClassroomRequest request) {
        ClassroomEntity classroomEntity = classroomRepository.findById(UUID.fromString(request.getId()))
                .orElseThrow();
        return classroomMapper.fromEntity(classroomEntity);
    }
}
