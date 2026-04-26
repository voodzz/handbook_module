CREATE TABLE IF NOT EXISTS football.football_clubs (
	club_id BIGSERIAL PRIMARY KEY,
	club_name TEXT UNIQUE NOT NULL,
	creation_date DATE,
	stadium_name TEXT,
	uefa_rating NUMERIC(8, 3)
);

CREATE TABLE IF NOT EXISTS football.football_players(
	player_id BIGSERIAL PRIMARY KEY,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	birth_date DATE,
	club_name TEXT REFERENCES football.football_clubs(club_name)
		ON UPDATE CASCADE
		ON DELETE SET NULL,
	height NUMERIC(3, 2),
	market_value BIGINT
);

INSERT INTO football.football_clubs (club_name, creation_date, stadium_name, uefa_rating)
VALUES 
('Real Madrid', '1902-03-06', 'Santiago Bernabéu', 123.000),
('Manchester City', '1880-04-16', 'Etihad Stadium', 148.000),
('Bayern Munich', '1900-02-27', 'Allianz Arena', 108.000);

INSERT INTO football.football_players (first_name, last_name, birth_date, club_name, height, market_value)
VALUES 
('Jude', 'Bellingham', '2003-06-29', 'Real Madrid', 1.86, 180000000),
('Erling', 'Haaland', '2000-07-21', 'Manchester City', 1.95, 180000000),
('Joshua', 'Kimmich', '1995-02-08', 'Bayern Munich', 1.77, 50000000);

SELECT * FROM football.football_clubs;

SELECT * FROM football.football_players;