--liquibase formatted sql

--changeset voodz:1
ALTER TABLE football.football_players ADD COLUMN notes TEXT;