DROP TABLE payments IF EXISTS CASCADE;
DROP TABLE credit_proposals IF EXISTS CASCADE;
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
    id               UUID      PRIMARY KEY,
    limit            DECIMAL   NOT NULL,
    interest_rate    DECIMAL   NOT NULL
);

CREATE TABLE credit_proposals
(
    id               UUID      PRIMARY KEY,
    credit_amount    DECIMAL   NOT NULL,
    customer_id      UUID      NOT NULL,
    credit_id        UUID      NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers (id) ON DELETE CASCADE,
    FOREIGN KEY (credit_id) REFERENCES credits (id) ON DELETE CASCADE
);

CREATE TABLE payments
(
    id                UUID        PRIMARY KEY,
    date_time         TIMESTAMP   NOT NULL,
    total_amount      Decimal     NOT NULL,
    amount_of_credit_body_repayment   Decimal   NOT NULL,
    amount_of_interest_repayment      Decimal   NOT NULL,
    credit_proposal_id                UUID      NOT NULL,
    FOREIGN KEY (credit_proposal_id) REFERENCES credit_proposals (id) ON DELETE CASCADE
);