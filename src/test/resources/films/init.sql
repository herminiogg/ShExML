-- This file is used to populate the database with data for testing purposes
CREATE TABLE films (
    id int,
    name varchar(48),
    year int,
    country varchar(48),
    director varchar(48)
);

INSERT INTO films (id, name, year, country, director) VALUES
    (8, 'Tenet', 2020, 'UK', 'Christopher Nolan'),
    (9, 'Batman Begins', 2005, 'USA', 'Christopher Nolan');

