CREATE TABLE public.semester(
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    "courceId" UUID NOT NULL REFERENCES public.cource (id),
    "semNo" character varying(255) NOT NULL,
    
    CONSTRAINT pkey_jobs PRIMARY KEY (id)
);



