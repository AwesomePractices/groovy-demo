create database if not exists weather_info;
use weather_info;

drop table if exists weather;

create table weather (
    city varchar(100) not null,
    temperature integer not null
);

INSERT INTO weather_info.weather (city, temperature) VALUES ('Austin', 48);
INSERT INTO weather_info.weather (city, temperature) VALUES ('Baton Rouge', 57);
INSERT INTO weather_info.weather (city, temperature) VALUES ('Jackson', 50);
INSERT INTO weather_info.weather (city, temperature) VALUES ('Montgomery', 53);
INSERT INTO weather_info.weather (city, temperature) VALUES ('Phoenix', 67);
INSERT INTO weather_info.weather (city, temperature) VALUES ('Sacramento', 66);
INSERT INTO weather_info.weather (city, temperature) VALUES ('Santa Fe', 27);
INSERT INTO weather_info.weather (city, temperature) VALUES ('Tallahassee', 59);


