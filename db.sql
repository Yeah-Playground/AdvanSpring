CREATE TABLE product IF NOT EXISTS (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    name varchar NOT NULL,
    price integer DEFAULT -1,
    stock integer DEFAULT -1
);
