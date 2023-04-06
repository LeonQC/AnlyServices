DROP TABLE IF EXISTS RANDOM1;
CREATE TABLE RANDOM1(
                    ID BIGSERIAL PRIMARY KEY NOT NULL,
                    LONG_URL VARCHAR(256) NOT NULL,
                    SHORT_URL VARCHAR(20) NOT NULL
);
CREATE UNIQUE INDEX SHORT_URL_INDEX_RD1 on RANDOM1(SHORT_URL);
CREATE UNIQUE INDEX LONG_URL_INDEX_RD1 on RANDOM1(LONG_URL);

DROP TABLE IF EXISTS RANDOM2;
CREATE TABLE RANDOM2(
                        ID BIGSERIAL PRIMARY KEY NOT NULL,
                        LONG_URL VARCHAR(256) NOT NULL,
                        SHORT_URL VARCHAR(20) NOT NULL
);
CREATE UNIQUE INDEX SHORT_URL_INDEX_RD2 on RANDOM2(SHORT_URL);
CREATE UNIQUE INDEX LONG_URL_INDEX_RD2 on RANDOM2(LONG_URL);

DROP TABLE IF EXISTS BASE62;
CREATE TABLE BASE62(
                        ID BIGSERIAL PRIMARY KEY NOT NULL,
                        LONG_URL VARCHAR(256) NOT NULL
);
CREATE UNIQUE INDEX LONG_URL_INDEX_BS on RANDOM2(LONG_URL);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
                         id SERIAL PRIMARY KEY NOT NULL,
                         username VARCHAR(45) NOT NULL,
                         password VARCHAR(45) NOT NULL,
                         enabled BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities (
                               id SERIAL PRIMARY KEY NOT NULL,
                               username VARCHAR(45) NOT NULL,
                               authority VARCHAR(45) NOT NULL
);

INSERT INTO users (username, password, enabled) VALUES ('angus', '123456', '1');
INSERT INTO authorities (username, authority) VALUES ('angus', 'admin');

