package com.theclassrooms.classroomservice.mapper;

import com.theclassrooms.classroomservice.entity.ClassroomEntity;
import com.theclassrooms.proto.classroom.GetClassroomResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {

    GetClassroomResponse fromEntity(ClassroomEntity classroomEntity);
}
