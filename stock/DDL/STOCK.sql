-- public.stock definition

-- Drop table

-- DROP TABLE public.stock;

CREATE TABLE public.stock (
	description varchar(255) NULL,
	"name" varchar(255) NULL,
	state bool NOT NULL,
	stock int4 NULL,
	id serial NOT NULL,
	CONSTRAINT stock_pk null
);