DROP TABLE IF EXISTS usuarios_direccion;
DROP TABLE  IF EXISTS usuarios;
 
 CREATE TABLE IF NOT EXISTS usuarios(
id_usuario INT(20) AUTO_INCREMENT PRIMARY KEY,
user_name varchar(20) NOT NULL,
user_password varchar(200) NOT NULL,
user_email varchar(50) NOT NULL,
user_date_creation datetime NOT NULL,
user_last_connection datetime NOT NULL
); 

CREATE TABLE IF NOT EXISTS usuarios_direccion(
id_direccion INT(20) AUTO_INCREMENT PRIMARY KEY,
id_usuario INT(20),
direccion varchar(200) NOT NULL,
numero varchar(3) NOT NULL,
cod_postal int(5) NOT NULL,
provincia varchar(40),
pais varchar(40),

CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) 
REFERENCES usuarios(id_usuario)
);





/**
CREATE TABLE IF NOT EXISTS usuarios_carrito(
identificador INT, 

CONSTRAINT fk_carrito FOREIGN KEY (identificador) 
REFERENCES usuarios(identificador)
);
**/

