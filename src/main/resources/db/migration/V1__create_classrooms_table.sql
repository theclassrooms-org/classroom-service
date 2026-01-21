-- =========================================
-- V1__init_classroom_tables.sql
-- Schema: classroom
-- =========================================

-- Enable UUID generation
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- =========================
-- ENUMS
-- =========================

CREATE TYPE classroom_type AS ENUM (
    'PUBLIC',      -- Anyone can join
    'PRIVATE'      -- Need code to join
);

CREATE TYPE classroom_status AS ENUM (
    'ACTIVE',
    'CLOSED',
    'DELETED'
);

-- =========================
-- TABLE: classrooms
-- =========================

CREATE TABLE public.cls_classrooms (
   id              UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

   name            VARCHAR(255) NOT NULL,
   description     VARCHAR(500),

   type            classroom_type NOT NULL,
   status          classroom_status NOT NULL DEFAULT 'ACTIVE',

   instructor_id   UUID NOT NULL,
   class_code      VARCHAR(20),

   end_time        TIMESTAMP WITH TIME ZONE,

   created_at      TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
   updated_at      TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_classrooms_instructor
    ON public.cls_classrooms (instructor_id);

CREATE INDEX idx_classrooms_status
    ON public.cls_classrooms (status);

CREATE INDEX idx_classrooms_type
    ON public.cls_classrooms (type);

-- =========================
-- TABLE: members
-- =========================

CREATE TABLE public.cls_classroom_members (
    id              UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    classroom_id    UUID NOT NULL,
    student_id      UUID NOT NULL,

    joined_at       TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    blocked_at      TIMESTAMP WITH TIME ZONE,

    created_at      TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),

    CONSTRAINT uq_classroom_student UNIQUE (classroom_id, student_id),

    CONSTRAINT fk_member_classroom
        FOREIGN KEY (classroom_id)
            REFERENCES public.cls_classrooms (id)
            ON DELETE CASCADE
);

CREATE INDEX idx_members_classroom
    ON public.cls_classroom_members (classroom_id);

CREATE INDEX idx_members_student
    ON public.cls_classroom_members (student_id);

CREATE INDEX idx_members_blocked
    ON public.cls_classroom_members (blocked_at);
