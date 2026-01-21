package com.theclassrooms.classroomservice.mapper;

import com.google.protobuf.util.Timestamps;
import com.google.protobuf.Timestamp;
import com.theclassrooms.classroomservice.entity.ClassroomEntity;
import com.theclassrooms.proto.classroom.Classroom;
import com.theclassrooms.proto.classroom.ClassroomStatus;
import com.theclassrooms.proto.classroom.ClassroomType;
import com.theclassrooms.proto.classroom.GetClassroomResponse;
import org.mapstruct.*;

import java.time.OffsetDateTime;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ClassroomMapper {

    @ValueMappings({
            @ValueMapping(source = "PUBLIC", target = "PUBLIC"),
            @ValueMapping(source = "PRIVATE", target = "PRIVATE"),
            @ValueMapping(source = MappingConstants.ANY_REMAINING,
                    target = "CLASSROOM_TYPE_UNSPECIFIED")
    })
    com.theclassrooms.proto.classroom.ClassroomType map(ClassroomType type);

    @ValueMappings({
            @ValueMapping(source = "ACTIVE", target = "ACTIVE"),
            @ValueMapping(source = "CLOSED",
                    target = "CLASSROOM_STATUS_UNSPECIFIED"),
            @ValueMapping(source = "DELETED",
                    target = "CLASSROOM_STATUS_UNSPECIFIED")
    })
    com.theclassrooms.proto.classroom.ClassroomStatus map(ClassroomStatus status);

    Classroom toClassroom(ClassroomEntity e);

    default GetClassroomResponse fromEntity(ClassroomEntity e) {
        if (e == null) {
            return null;
        }
        GetClassroomResponse.Builder builder =
                GetClassroomResponse.newBuilder().setClassroom(toClassroom(e));
        return builder.build();
    }

    default Timestamp map(OffsetDateTime time) {
        if (time == null) {
            return null;
        }
        return Timestamps.fromMillis(time.toInstant().toEpochMilli());
    }
}
