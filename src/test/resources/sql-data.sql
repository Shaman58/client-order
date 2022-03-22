INSERT INTO clients(id, name, region_code, settlement, street, house_number, building_number, room_number, phone_number,
                    tin)
VALUES (1, 'person1', 1, 'settlement1', 'street1', 1, 1, 1, 111111, 123456789),
       (2, 'person2', 2, 'settlement2', 'street2', 2, 2, 2, 222222, 987654321),
       (3, 'person3', 3, 'settlement3', 'street3', 3, 3, 3, 333333, 123454321);
INSERT INTO orders(id, date, details, amount, client_id)
VALUES (1, '2022-01-01', 'details1', 10000, 1),
       (2, '2022-01-02', 'details2', 20000, 1),
       (3, '2022-01-03', 'details3', 30000, 1),
       (4, '2022-01-04', 'details4', 40000, 2),
       (5, '2022-01-05', 'details5', 50000, 3);