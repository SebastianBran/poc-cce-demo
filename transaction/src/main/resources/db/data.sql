INSERT INTO money_transaction (sender_phone_number, sender_email, receiver_phone_number, amount, currency, entity_id)
VALUES
    ('987654321', 'test@gmail.com', '912345678', 150, 1001, '123'), -- PEN
    ('998877665', 'test@gmail.com', '976543210', 2500, 1002, '123'), -- USD
    ('912345678', 'test@gmail.com', '987654321', 500, 1001, '123'),
    ('976543210', 'test@gmail.com', '998877665', 10000, 1003, '123'), -- EUR
    ('934567890', 'test@gmail.com', '956789012', 750, 1001, '123');
