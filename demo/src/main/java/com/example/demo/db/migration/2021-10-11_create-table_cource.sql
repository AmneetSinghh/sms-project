CREATE TABLE public.cource(
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    "courseName" character varying(255),
    CONSTRAINT pkey_companies PRIMARY KEY (id)
);

