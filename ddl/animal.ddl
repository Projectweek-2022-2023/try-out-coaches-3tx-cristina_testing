CREATE SCHEMA cristina_test;

CREATE SEQUENCE cristina_test.animal_id_seq;

CREATE TABLE cristina_test.animal
(   id integer NOT NULL DEFAULT nextval('cristina_test.animal_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    type character varying COLLATE pg_catalog."default",
    food integer,
    CONSTRAINT animal_pkey PRIMARY KEY (id, name)
);

INSERT INTO cristina_test.animal ("name","type","food") values ('Blub','vis',5);
INSERT INTO cristina_test.animal ("name","type","food") values ('Mia','kat',7);




