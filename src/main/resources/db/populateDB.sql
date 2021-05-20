DELETE FROM credits;
DELETE FROM customers;

INSERT INTO customers (id, fio, phone_number, email, passport_number)
VALUES (UUID(), 'fio1', 'phone1', 'email1', 'pas1'),
       (UUID(), 'fio2', 'phone2', 'email2', 'pas2'),
       (UUID(), 'fio3', 'phone3', 'email3', 'pas3');

INSERT INTO credits (id, limit, interest_rate)
VALUES (UUID(), 100.5, 10.5),
       (UUID(), 200.5, 20.5),
       (UUID(), 300.5, 30.5);