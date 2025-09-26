DROP TABLE IF EXISTS directory;

CREATE TABLE directory (
    id BIGSERIAL PRIMARY KEY,
    entity_id VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL
);
