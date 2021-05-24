DROP PROCEDURE populate_db IF EXISTS;

CREATE PROCEDURE populate_db()
    MODIFIES SQL DATA
BEGIN
    ATOMIC
    DECLARE customer_id1, customer_id2, customer_id3, credit_id1, credit_id2, credit_id3,
        credit_proposal_id1, credit_proposal_id2, credit_proposal_id3 UUID;
    SET customer_id1 = UUID();
    SET customer_id2 = UUID();
    SET customer_id3 = UUID();
    SET credit_id1 = UUID();
    SET credit_id2 = UUID();
    SET credit_id3 = UUID();
    SET credit_proposal_id1 = UUID();
    SET credit_proposal_id2 = UUID();
    SET credit_proposal_id3 = UUID();

    DELETE FROM payments;
    DELETE FROM credit_proposals;
    DELETE FROM credits;
    DELETE FROM customers;

    INSERT INTO customers (id, fio, phone_number, email, passport_number)
    VALUES (customer_id1, 'fio1', 'phone1', 'email1', 'pas1'),
           (customer_id2, 'fio2', 'phone2', 'email2', 'pas2'),
           (customer_id3, 'fio3', 'phone3', 'email3', 'pas3');

    INSERT INTO credits (id, limit, interest_rate)
    VALUES (credit_id1, 100.5, 10.5),
           (credit_id2, 200.5, 20.5),
           (credit_id3, 300.5, 30.5);

    INSERT INTO credit_proposals (id, credit_amount, customer_id, credit_id)
    VALUES (credit_proposal_id1, 50.5, customer_id1, credit_id1),
           (credit_proposal_id2, 150.5, customer_id2, credit_id2),
           (credit_proposal_id3, 250.5, customer_id3, credit_id3);

    INSERT INTO payments (id, date_time, total_amount, amount_of_credit_body_repayment,
                          amount_of_interest_repayment, credit_proposal_id)
    VALUES (UUID(), '2020-01-30 10:00:00', 100.5, 90.3, 10.2, credit_proposal_id1),
           (UUID(), '2020-01-30 13:00:00', 200.5, 180.3, 20.2, credit_proposal_id2),
           (UUID(), '2020-01-31 14:00:00', 300.5, 270.3, 30.2, credit_proposal_id3);
END;
/;
CALL populate_db();