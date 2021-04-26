DROP TYPE IF EXISTS e_status CASCADE;

CREATE TYPE e_status as ENUM (
    'PROCESSING', 'ERROR', 'COMPLETED'
    );

DROP TABLE IF EXISTS requests;

CREATE TABLE IF NOT EXISTS requests
(
    id bigserial PRIMARY KEY,
    route "char" NOT NULL,
    date_time timestamp(0) without time zone NOT NULL,
    status e_status NOT NULL DEFAULT 'PROCESSING'
);