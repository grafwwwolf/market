CREATE TABLE products
    (
    id bigserial PRIMARY KEY,
    title VARCHAR(255),
    cost NUMERIC(6, 2)
    );

INSERT INTO products (title, cost) VALUES
    ('black leather jacket', 3600.00),
    ('White leather jacket', 3600.00),
    ('black leather bandana', 540.00),
    ('White leather bandana', 540.00),
    ('black jeans', 2200.00),
    ('White jeans', 2200.00),
    ('black leather gloves', 1050.00),
    ('White leather gloves', 1050.00),
    ('T-shirt with print AC/DC', 700.00),
    ('T-shirt with print MANOWAR', 700.00),
    ('T-shirt with print ARIA', 700.00),
    ('T-shirt with print METALLICA', 700.00),
    ('T-shirt with print SCORPIONS', 700.00),
    ('T-shirt with print Queen', 700.00),
    ('T-shirt with print W.A.S.P.', 700.00),
    ('Sunglasses', 600.00),
    ('black motorcycle boots', 4300.00),
    ('White motorcycle boots', 4300.00),
    ('black leather vest', 2300.00),
    ('White leather vest', 2300.00);