# classifieds
The fastest growing free local classifieds.

previusly create table classified
-- public.classified definition

-- Drop table

-- DROP TABLE public.classified;

CREATE TABLE public.classified (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	title varchar NOT NULL,
	description varchar NULL,
	created_at timestamptz NOT NULL DEFAULT now()
);
