
CREATE TABLE Users (
   id UUID PRIMARY KEY,
   username VARCHAR(255),
   email_address VARCHAR(255),
   password VARCHAR(255)
);

CREATE TABLE Merchant (
  id UUID PRIMARY KEY,
  merchant_name VARCHAR(255),
  merchant_location VARCHAR(255),
  open BOOLEAN
);

CREATE TABLE Product (
     id UUID PRIMARY KEY,
     product_name VARCHAR(255),
     price DECIMAL,
     merchant_id UUID,
     FOREIGN KEY (merchant_id) REFERENCES Merchant(id)
);

CREATE TABLE Order (
   id UUID PRIMARY KEY,
   order_time TIMESTAMP,
   destination_address VARCHAR(255),
   user_id UUID,
   completed BOOLEAN,
   FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE Order_Detail (
  id UUID PRIMARY KEY,
  order_id UUID,
  product_id UUID,
  quantity INTEGER,
  total_price DECIMAL,
  FOREIGN KEY (order_id) REFERENCES Order(id),
  FOREIGN KEY (product_id) REFERENCES Product(id)
);

INSERT INTO Users (id, username, email_address, password)
VALUES ('123e4567-e89b-12d3-a456-556642440000', 'user1', 'user1@example.com', 'password123');

SELECT * FROM Users;

INSERT INTO Merchant (id, merchant_name, merchant_location, open)
VALUES ('223e4567-e89b-12d3-a456-556642440001', 'Merchant1', 'Location1', true);

SELECT * FROM Merchant;

INSERT INTO Product (id, product_name, price, merchant_id)
VALUES ('323e4567-e89b-12d3-a456-556642440002', 'Product1', 10.50, '223e4567-e89b-12d3-a456-556642440001');

SELECT * FROM Product;

INSERT INTO Order (id, order_time, destination_address, user_id, completed)
VALUES ('423e4567-e89b-12d3-a456-556642440003', '2024-04-20 12:00:00', 'Address1', '123e4567-e89b-12d3-a456-556642440000', false);

SELECT * FROM Order;

INSERT INTO Order_Detail (id, order_id, product_id, quantity, total_price)
VALUES ('523e4567-e89b-12d3-a456-556642440004', '423e4567-e89b-12d3-a456-556642440003', '323e4567-e89b-12d3-a456-556642440002', 2, 21.00);

SELECT * FROM Order_Detail;
