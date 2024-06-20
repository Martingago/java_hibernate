DROP TABLE  IF EXISTS usuarios;

CREATE TABLE IF NOT EXISTS usuarios(
identificador INT(20) AUTO_INCREMENT PRIMARY KEY,
user_name varchar(20) NOT NULL,
user_password varchar(50) NOT NULL,
user_email varchar(50) NOT NULL,
user_date_creation date NOT NULL,
user_last_connection date NOT NULL

);