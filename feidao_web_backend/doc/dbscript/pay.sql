# Execute sql in windows
# mysql> source 'E:\projects\git\feidao_web\feidao_web_backend\doc\dbscript\pay.sql';

# Execute mysql statements that have been written in a text file
# mysql -u yourusername -p yourpassword yourdatabase < text_file


CREATE TABLE Employee (
    id          INT NOT NULL AUTO_INCREMENT,
    firstName   VARCHAR(30),
    lastName   VARCHAR(30),
    telephone   VARCHAR(15),
    email      VARCHAR(30),
    created     TIMESTAMP DEFAULT NOW(),
    PRIMARY KEY (id)
);


