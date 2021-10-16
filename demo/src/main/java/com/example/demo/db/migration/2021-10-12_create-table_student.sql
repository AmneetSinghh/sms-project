CREATE TABLE public.student(
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    "courceId" UUID NOT NULL REFERENCES public.cource (id),
    "semesterId" UUID REFERENCES public.semester (id),
    "name" character varying(255) NOT NULL,
    "rollNo" character varying(255) NOT NULL,
    "gender" character varying(255) NOT NULL,

    CONSTRAINT pkey_job_warehouse_locations PRIMARY KEY (id)
);