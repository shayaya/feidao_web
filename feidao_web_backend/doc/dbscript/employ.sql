# mysql
CREATE TABLE Employee
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    firstName   VARCHAR(30),
    lastName   VARCHAR(30),
    telephone   VARCHAR(15),
    email      VARCHAR(30),
    created     TIMESTAMP DEFAULT NOW()
);


