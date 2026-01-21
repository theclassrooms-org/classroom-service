package com.theclassrooms.classroomservice.grpc;

import com.theclassrooms.classroomservice.service.ClassroomService;
import com.theclassrooms.proto.classroom.ClassroomServiceGrpc;
import com.theclassrooms.proto.classroom.GetClassroomRequest;
import com.theclassrooms.proto.classroom.GetClassroomResponse;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class ClassroomGrpcService extends ClassroomServiceGrpc.ClassroomServiceImplBase {

    private final ClassroomService classroomService;

    @Override
    public void getClassroom(GetClassroomRequest request, StreamObserver<GetClassroomResponse> responseObserver) {
        GetClassroomResponse response = classroomService.getClassroom(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
