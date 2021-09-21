DROP DATABASE IF EXISTS guessinggame;
CREATE DATABASE guessinggame;
USE guessinggame;
CREATE TABLE Game (
	gameID int NOT NULL AUTO_INCREMENT,
    state tinyint,
    answer int,
	PRIMARY KEY(gameID)
);
CREATE TABLE Round (
	roundID int NOT NULL AUTO_INCREMENT,
    gameID int,
    dtGuess DATETIME,
    exactGuesses int,
    partialGuesses int,
    PRIMARY KEY(roundID),
	FOREIGN KEY(gameID) REFERENCES Game(gameID),
    CHECK(((exactGuesses + partialGuesses) <= 4) AND ((exactGuesses + partialGuesses) >= 0))
);