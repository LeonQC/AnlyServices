DROP TABLE IF EXISTS URL;
CREATE TABLE URL(
                              ID BIGSERIAL PRIMARY KEY NOT NULL,
                              LONG_URL VARCHAR(256) NOT NULL,
                              SHORT_URL VARCHAR(20) NOT NULL
);