DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS clients;
CREATE TABLE clients
(
    id              BIGINT PRIMARY KEY NOT NULL,
    region_code     INTEGER,
    settlement      VARCHAR(50),
    street          VARCHAR(50),
    house_number    INTEGER,
    building_number INTEGER,
    room_number     INTEGER,
    name            VARCHAR(50),
    phone_number    INTEGER,
    tin             INTEGER
);
CREATE TABLE orders
(
    id BIGINT PRIMARY KEY NOT NULL,
    date DATE,
    details VARCHAR(100),
    amount INTEGER,
    client_id BIGINT,
FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE
)