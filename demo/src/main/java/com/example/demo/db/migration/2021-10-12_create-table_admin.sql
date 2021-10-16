CREATE TABLE public.admin(
    id UUID NOT NULL DEFAULT uuid_generate_v4(),
    "name" character varying(255) NOT NULL,
    "password" character varying(255) NOT NULL,

    CONSTRAINT pkey_job_onboarding_locations PRIMARY KEY (id)
);