
CREATE TABLE public.subject(
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    "courceId" UUID NOT NULL REFERENCES public.cource (id),
    "semesterId" UUID REFERENCES public.semester (id),
    "subjectName" character varying(255) NOT NULL,

    CONSTRAINT pkey_job_demands PRIMARY KEY (id)
);
