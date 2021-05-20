DROP TABLE credits IF EXISTS;
DROP TABLE customers IF EXISTS;

CREATE TABLE customers
(
    id               UUID      PRIMARY KEY,
    fio              VARCHAR(255)   NOT NULL,
    phone_number     VARCHAR(255)   NOT NULL,
    email            VARCHAR(255)   NOT NULL,
    passport_number  VARCHAR(255)   NOT NULL
);

CREATE TABLE credits
(
    id               UUID    PRIMARY KEY,
    limit            DECIMAL   NOT NULL,
    interest_rate    DECIMAL   NOT NULL
);