--liquibase formatted sql

--changeset voodz:1
CREATE SCHEMA IF NOT EXISTS football;

--changeset voodz:2
CREATE TABLE IF NOT EXISTS football.football_clubs
(
    club_id       BIGSERIAL PRIMARY KEY,
    club_name     TEXT UNIQUE NOT NULL,
    creation_date DATE,
    stadium_name  TEXT,
    uefa_rating   NUMERIC(8, 3)
);

--changeset voodz:3
CREATE TABLE IF NOT EXISTS football.football_players
(
    player_id    BIGSERIAL PRIMARY KEY,
    first_name   TEXT NOT NULL,
    last_name    TEXT NOT NULL,
    birth_date   DATE,
    club_name    TEXT REFERENCES football.football_clubs (club_name)
                          ON UPDATE CASCADE
                          ON DELETE SET NULL,
    height       NUMERIC(3, 2),
    market_value BIGINT
);