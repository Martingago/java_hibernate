DROP TABLE IF EXISTS pedidos_productos;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS marcas;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS usuarios_direccion;
DROP TABLE IF EXISTS pedidos;
DROP TABLE  IF EXISTS usuarios;

CREATE TABLE IF NOT EXISTS usuarios(
id_usuario INT(20) AUTO_INCREMENT PRIMARY KEY,
username varchar(20) NOT NULL,
user_password varchar(200) NOT NULL,
email varchar(50) NOT NULL,
date_creation datetime NOT NULL,
last_connection datetime NOT NULL
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
ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pedidos(
id_pedido INT(20) PRIMARY KEY AUTO_INCREMENT,
fecha_pedido DATETIME NOT NULL,
fecha_entrega DATETIME,
id_usuario INT(20),
CONSTRAINT fk_id_usuario_pedidos FOREIGN KEY (id_usuario)
REFERENCES usuarios(id_usuario)
ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS marcas(
id_marca INT(20) PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(200) NOT NULL,
descripcion VARCHAR(2000)
);

CREATE TABLE IF NOT EXISTS categorias(
id_categoria INT(20) PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(200) NOT NULL,
descripcion VARCHAR(2000)
);


CREATE TABLE IF NOT EXISTS productos(
id_producto INT(20) PRIMARY KEY AUTO_INCREMENT,
id_marca INT(20),
id_categoria INT(20),
nombre VARCHAR(200) NOT NULL,
descripcion VARCHAR(2000) NOT NULL,
precio DOUBLE(9,2) NOT NULL,
stock INT(7) NOT NULL,

CONSTRAINT fk_id_marca_productos FOREIGN KEY (id_marca)
REFERENCES marcas(id_marca)
ON DELETE CASCADE,

CONSTRAINT fk_id_categoria_productos FOREIGN KEY (id_categoria)
REFERENCES categorias(id_categoria)
ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS pedidos_productos(
id_pedido int(20),
id_producto int(20),
cantidad int(5),
precio double(8,2),
subtotal double(8,2),

CONSTRAINT fk_id_pedido_pedidos_producto FOREIGN KEY (id_pedido)
REFERENCES pedidos(id_pedido)
ON DELETE CASCADE,

CONSTRAINT fk_id_producto_pedidos_producto FOREIGN KEY (id_producto)
REFERENCES productos(id_producto)
);



/**
CREATE TABLE IF NOT EXISTS usuarios_carrito(
identificador INT, 

CONSTRAINT fk_carrito FOREIGN KEY (identificador) 
REFERENCES usuarios(identificador)
);
**/

