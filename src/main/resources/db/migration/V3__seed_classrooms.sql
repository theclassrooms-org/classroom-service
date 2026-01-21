-- =========================
-- SEED DATA FOR cls_classrooms
-- =========================
INSERT INTO public.cls_classrooms (
    id,
    name,
    description,
    type,
    status,
    instructor_id,
    class_code,
    end_time,
    created_at,
    updated_at
) VALUES
      (
          '11111111-1111-1111-1111-111111111111',
          'GraphQL for Beginners',
          'Introduction to GraphQL fundamentals',
          'PUBLIC',
          'ACTIVE',
          '11111111-1111-1111-1111-111111111111',
          NULL,
          NOW() + INTERVAL '30 days',
          NOW(),
          NOW()
      ),
      (
          uuid_generate_v4(),
          'Spring Boot Microservices',
          'Advanced microservices with Spring Boot and gRPC',
          'PRIVATE',
          'ACTIVE',
          '22222222-2222-2222-2222-222222222222',
          'SPRING-GRPC-01',
          NOW() + INTERVAL '60 days',
          NOW(),
          NOW()
      ),
      (
          uuid_generate_v4(),
          'Database Design Basics',
          'Learn relational database design and normalization',
          'PUBLIC',
          'CLOSED',
          '33333333-3333-3333-3333-333333333333',
          NULL,
          NOW() - INTERVAL '1 day',
          NOW() - INTERVAL '90 days',
          NOW() - INTERVAL '1 day'
      );
