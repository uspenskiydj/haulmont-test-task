DROP PROCEDURE populate_db IF EXISTS;

CREATE PROCEDURE populate_db()
    MODIFIES SQL DATA
BEGIN
    ATOMIC
    DECLARE bank_id1, bank_id2, customer_id1, customer_id2, customer_id3, credit_id1, credit_id2,
        credit_id3, credit_proposal_id1, credit_proposal_id2 UUID;
    SET bank_id1 = UUID();
    SET bank_id2 = UUID();
    SET customer_id1 = UUID();
    SET customer_id2 = UUID();
    SET customer_id3 = UUID();
    SET credit_id1 = UUID();
    SET credit_id2 = UUID();
    SET credit_id3 = UUID();
    SET credit_proposal_id1 = UUID();
    SET credit_proposal_id2 = UUID();

    DELETE FROM payments;
    DELETE FROM credit_proposals;
    DELETE FROM credits;
    DELETE FROM customers;
    DELETE FROM banks;

    INSERT INTO banks (id)
    VALUES (bank_id1),
           (bank_id2);

    INSERT INTO customers (id, fio, phone_number, email, passport_number, bank_id)
    VALUES (customer_id1, 'Кузнецов Максим Романович', '892496599429', 'yf.bos@gmail.com', '968738651', bank_id1),
           (customer_id2, 'Архипов Матвей Альбертович', '892439700081', 'ds.gdr@gmail.com', '752010981', bank_id1),
           (customer_id3, 'Воронин Алексей Васильевич', '892434918433', 'sa.fds@gmail.com', '456656525', bank_id2);

    INSERT INTO credits (id, limit, interest_rate, bank_id)
    VALUES (credit_id1, 250000, 20, bank_id1),
           (credit_id2, 500000, 15.5, bank_id1),
           (credit_id3, 750000, 10.5, bank_id2);

    INSERT INTO credit_proposals (id, credit_amount, customer_id, credit_id)
    VALUES (credit_proposal_id1, 250000, customer_id2, credit_id2),
           (credit_proposal_id2, 544333, customer_id3, credit_id3);

    INSERT INTO payments (id, date, total_amount, amount_of_credit_body_repayment,
                          amount_of_interest_repayment, credit_proposal_id)
    VALUES (UUID(), '2021-05-25', 22623.6, 19394.44, 3229.17, credit_proposal_id1),
           (UUID(), '2021-06-25', 22623.6, 19644.95, 2978.66, credit_proposal_id1),
           (UUID(), '2021-07-25', 22623.6, 19898.7, 2724.91, credit_proposal_id1),
           (UUID(), '2021-08-25', 22623.6, 20155.72, 2467.88, credit_proposal_id1),
           (UUID(), '2021-09-25', 22623.6, 20416.07, 2207.54, credit_proposal_id1),
           (UUID(), '2021-10-25', 22623.6, 20679.77, 1943.83, credit_proposal_id1),
           (UUID(), '2021-11-25', 22623.6, 20946.89, 1676.72, credit_proposal_id1),
           (UUID(), '2021-12-25', 22623.6, 21217.45, 1406.15, credit_proposal_id1),
           (UUID(), '2022-01-25', 22623.6, 21491.51, 1132.09, credit_proposal_id1),
           (UUID(), '2022-02-25', 22623.6, 21769.11, 854.5, credit_proposal_id1),
           (UUID(), '2022-03-25', 22623.6, 22050.29, 573.31, credit_proposal_id1),
           (UUID(), '2022-04-25', 22623.6, 22335.11, 288.5, credit_proposal_id1),
           (UUID(), '2021-06-25', 50424.02, 41351.8, 9072.22, credit_proposal_id2),
           (UUID(), '2021-07-25', 50424.02, 42041, 8383.02, credit_proposal_id2),
           (UUID(), '2021-08-25', 50424.02, 42741.68, 7682.34, credit_proposal_id2),
           (UUID(), '2021-09-25', 50424.02, 43454.04, 6969.98, credit_proposal_id2),
           (UUID(), '2021-10-25', 50424.02, 44178.28, 6245.74, credit_proposal_id2),
           (UUID(), '2021-11-25', 50424.02, 44914.58, 5509.44, credit_proposal_id2),
           (UUID(), '2021-12-25', 50424.02, 45663.16, 4760.86, credit_proposal_id2),
           (UUID(), '2022-01-25', 50424.02, 46424.21, 3999.81, credit_proposal_id2),
           (UUID(), '2022-02-25', 50424.02, 47197.95, 3226.07, credit_proposal_id2),
           (UUID(), '2022-03-25', 50424.02, 47984.58, 2439.44, credit_proposal_id2),
           (UUID(), '2022-04-25', 50424.02, 48784.32, 1639.7, credit_proposal_id2),
           (UUID(), '2022-04-25', 50424.02, 49597.4, 826.62, credit_proposal_id2);
END;
/;
CALL populate_db();