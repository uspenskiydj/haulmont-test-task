DELETE FROM payments;
DELETE FROM credit_proposals;
DELETE FROM credits;
DELETE FROM customers;
DELETE FROM banks;

INSERT INTO banks (id)
VALUES ('0d347392-b14f-4ac0-9ba8-21e25dc1eb5f'),
       ('6e2dffa7-01a8-44a7-a6bb-bae04dd58e88');

INSERT INTO customers (id, fio, phone_number, email, passport_number, bank_id)
VALUES ('0101ba8b-39c1-4043-8bde-6155ef55a159', 'fio1', 'phone1', 'email1', 'pas1', '0d347392-b14f-4ac0-9ba8-21e25dc1eb5f'),
       ('9a651751-1320-4888-af38-6ef79483e283', 'fio2', 'phone2', 'email2', 'pas2', '0d347392-b14f-4ac0-9ba8-21e25dc1eb5f'),
       ('f896611b-7d98-4dd2-b88a-105f2f19111f', 'fio3', 'phone3', 'email3', 'pas3', '6e2dffa7-01a8-44a7-a6bb-bae04dd58e88');

INSERT INTO credits (id, limit, interest_rate, bank_id)
VALUES ('0101ba8b-39c1-4043-8bde-6155ef55a159', 100.5, 10.5, '0d347392-b14f-4ac0-9ba8-21e25dc1eb5f'),
       ('9a651751-1320-4888-af38-6ef79483e283', 200.5, 20.5, '0d347392-b14f-4ac0-9ba8-21e25dc1eb5f'),
       ('f896611b-7d98-4dd2-b88a-105f2f19111f', 300.5, 30.5, '6e2dffa7-01a8-44a7-a6bb-bae04dd58e88');

INSERT INTO credit_proposals (id, credit_amount, customer_id, credit_id)
VALUES ('10a069b7-d7b8-4688-a823-504da911e05e', 50.5, '0101ba8b-39c1-4043-8bde-6155ef55a159', '0101ba8b-39c1-4043-8bde-6155ef55a159'),
       ('83918b97-5172-433b-ae6e-047571002730', 150.5, '9a651751-1320-4888-af38-6ef79483e283', '9a651751-1320-4888-af38-6ef79483e283'),
       ('f98a967a-00e4-4632-b776-bd66d75cea70', 250.5, 'f896611b-7d98-4dd2-b88a-105f2f19111f', 'f896611b-7d98-4dd2-b88a-105f2f19111f');

INSERT INTO payments (id, date, total_amount, amount_of_credit_body_repayment,
                      amount_of_interest_repayment, credit_proposal_id)
VALUES ('02135a2c-ef9b-4fa8-a1d2-dd6cdaa845cc', '2021-01-25', 100.5, 90.3, 10.2, '10a069b7-d7b8-4688-a823-504da911e05e'),
       ('6aac9ed1-436e-4e85-902b-510a8b63822c', '2021-02-25', 200.5, 180.3, 20.2, '83918b97-5172-433b-ae6e-047571002730'),
       ('ae7dc11b-f0f5-4377-afb4-cf2ba376d48d', '2021-03-25', 300.5, 270.3, 30.2, 'f98a967a-00e4-4632-b776-bd66d75cea70');
