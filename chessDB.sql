CREATE DATABASE IF NOT EXISTS Chess;

USE Chess;

DROP TABLE IF EXISTS chess_Pieces;

CREATE TABLE chess_Pieces(
	id int(10) NOT NULL AUTO_INCREMENT,
    name varchar(60) NOT NULL,
    quantity varchar(60),
    price DECIMAL(19,2),
    PRIMARY key(id)
    );