DROP TABLE IF EXISTS money_transaction;

CREATE TABLE money_transaction (
    id BIGSERIAL PRIMARY KEY,
    sender_phone_number VARCHAR(255) NOT NULL,
    sender_email VARCHAR(255) NOT NULL,
    receiver_phone_number VARCHAR(255) NOT NULL,
    amount BIGINT NOT NULL,
    currency BIGINT NOT NULL,
    entity_id VARCHAR(255) NOT NULL
);
