package com.theclassrooms.classroomservice.service;

import com.theclassrooms.proto.classroom.GetClassroomRequest;
import com.theclassrooms.proto.classroom.GetClassroomResponse;

public interface ClassroomService {

    GetClassroomResponse getClassroom(GetClassroomRequest request);
}
