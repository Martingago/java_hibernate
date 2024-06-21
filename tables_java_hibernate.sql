  DROP TABLE  IF EXISTS usuarios;
  DROP TABLE IF EXISTS usuarios_direccion;
  

CREATE TABLE IF NOT EXISTS usuarios_direccion(
id_direccion INT(20) AUTO_INCREMENT PRIMARY KEY,
direccion varchar(200) NOT NULL,
numero varchar(3) NOT NULL,
cod_postal int(5) NOT NULL,
provincia varchar(40),
pais varchar(40)
);

CREATE TABLE IF NOT EXISTS usuarios(
id_usuario INT(20) AUTO_INCREMENT PRIMARY KEY,
id_direccion INT(20),
user_name varchar(20) NOT NULL,
user_password varchar(200) NOT NULL,
user_email varchar(50) NOT NULL,
user_date_creation datetime NOT NULL,
user_last_connection datetime NOT NULL,

CONSTRAINT fk_id_direccion FOREIGN KEY (id_direccion) 
REFERENCES usuarios_direccion(id_direccion)
);



/**
CREATE TABLE IF NOT EXISTS usuarios_carrito(
identificador INT, 

CONSTRAINT fk_carrito FOREIGN KEY (identificador) 
REFERENCES usuarios(identificador)
);
**/

