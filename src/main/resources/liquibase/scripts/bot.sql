-- liquibase formatted sql

-- changeset popova:1
CREATE TABLE notification_task(id BIGSERIAL PRIMARY KEY,chat_id BIGINT,notification TEXT,date_time TIMESTAMP);