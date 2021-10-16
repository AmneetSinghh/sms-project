CREATE TABLE public.marks(
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    "courceId" UUID NOT NULL REFERENCES public.cource (id),
    "semesterId" UUID REFERENCES public.semester (id),
    "studentId" UUID REFERENCES public.student (id),
    "subjectId" UUID REFERENCES public.subject (id),
    "marks" int NOT NULl,
    
    CONSTRAINT pkey_requirements PRIMARY KEY (id)
);
