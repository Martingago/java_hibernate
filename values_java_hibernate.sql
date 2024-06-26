INSERT INTO marcas (id_marca, nombre, descripcion) VALUES
(1, 'ASUS', 'Productos de la marca ASUS'),
(2, 'Samsung', 'Productos de la marca Samsung'),
(3, 'Apple', 'Productos de la marca Apple'),
(4, 'Dell', 'Productos de la marca Dell'),
(5, 'HP', 'Productos de la marca HP'),
(6, 'Lenovo', 'Productos de la marca Lenovo'),
(7, 'Sony', 'Productos de la marca Sony'),
(8, 'LG', 'Productos de la marca LG'),
(9, 'Acer', 'Productos de la marca Acer'),
(10, 'Microsoft', 'Productos de la marca Microsoft'),
(11, 'Huawei', 'Productos de la marca Huawei'),
(12, 'Toshiba', 'Productos de la marca Toshiba'),
(13, 'Panasonic', 'Productos de la marca Panasonic'),
(14, 'Philips', 'Productos de la marca Philips'),
(15, 'Nokia', 'Productos de la marca Nokia');

INSERT INTO categorias (id_categoria, nombre, descripcion) VALUES
(1, 'Laptops', 'Dispositivos portátiles para trabajo y entretenimiento'),
(2, 'Smartphones', 'Teléfonos inteligentes con múltiples funcionalidades'),
(3, 'Tablets', 'Tablets para navegación y aplicaciones móviles'),
(4, 'Monitores', 'Pantallas y monitores de alta resolución'),
(5, 'Impresoras', 'Equipos de impresión y escaneo'),
(6, 'Computadoras', 'Equipos de escritorio y PCs para diversas tareas'),
(7, 'Televisores', 'Pantallas de televisión de alta definición'),
(8, 'Electrodomésticos', 'Aparatos eléctricos para el hogar'),
(9, 'Accesorios', 'Periféricos y accesorios para dispositivos electrónicos'),
(10, 'Software', 'Programas y aplicaciones informáticas'),
(11, 'Routers', 'Dispositivos para la conexión de redes'),
(12, 'Laptops', 'Portátiles para uso personal y profesional'),
(13, 'Cámaras', 'Equipos fotográficos y de video'),
(14, 'Audio', 'Sistemas y equipos de sonido'),
(15, 'Teléfonos', 'Dispositivos para comunicación telefónica');

INSERT INTO productos (id_producto, id_marca, id_categoria, nombre, descripcion, precio, stock) VALUES
(1, 1, 1, 'ASUS ZenBook', 'Ultrabook con pantalla táctil y alto rendimiento', 999.99, 50),
(2, 2, 2, 'Samsung Galaxy S21', 'Teléfono inteligente de alta gama con cámara avanzada', 799.99, 100),
(3, 3, 3, 'iPad Pro', 'Tablet con pantalla Retina y chip M1', 1099.99, 30),
(4, 4, 4, 'Dell UltraSharp', 'Monitor de alta resolución con tecnología IPS', 399.99, 75),
(5, 5, 5, 'HP LaserJet Pro', 'Impresora láser con capacidad de impresión rápida', 249.99, 40),
(6, 6, 6, 'Lenovo ThinkCentre', 'PC de escritorio con gran capacidad de almacenamiento', 649.99, 25),
(7, 7, 7, 'Sony Bravia', 'Televisor 4K con tecnología HDR', 899.99, 60),
(8, 8, 8, 'LG Smart Fridge', 'Refrigerador inteligente con pantalla táctil', 1299.99, 10),
(9, 9, 9, 'Acer Predator Mouse', 'Ratón gaming con iluminación RGB y alta precisión', 59.99, 150),
(10, 10, 10, 'Microsoft Office 365', 'Suite de productividad con aplicaciones de oficina', 99.99, 200),
(11, 11, 11, 'Huawei Router AX3', 'Router Wi-Fi 6 de alta velocidad', 129.99, 80),
(12, 12, 12, 'Toshiba Satellite', 'Laptop con buen rendimiento y durabilidad', 549.99, 35),
(13, 13, 13, 'Panasonic Lumix', 'Cámara digital con lente de alta calidad', 499.99, 20),
(14, 14, 14, 'Philips Soundbar', 'Barra de sonido con subwoofer inalámbrico', 199.99, 45),
(15, 15, 15, 'Nokia 3310', 'Teléfono móvil clásico con gran durabilidad', 49.99, 300);

INSERT INTO usuarios (id_usuario, username, user_password, email, date_creation, last_connection) VALUES
(1, 'alice', 'password1', 'alice@example.com', '2024-01-01 10:00:00', '2024-01-15 12:00:00'),
(2, 'bob', 'password2', 'bob@example.com', '2024-01-05 11:30:00', '2024-01-20 14:45:00'),
(3, 'charlie', 'password3', 'charlie@example.com', '2024-01-10 09:20:00', '2024-01-25 16:30:00'),
(4, 'david', 'password4', 'david@example.com', '2024-01-15 08:10:00', '2024-01-30 17:15:00'),
(5, 'eve', 'password5', 'eve@example.com', '2024-01-20 07:00:00', '2024-02-01 18:00:00'),
(6, 'frank', 'password6', 'frank@example.com', '2024-01-25 06:50:00', '2024-02-05 19:30:00'),
(7, 'grace', 'password7', 'grace@example.com', '2024-01-30 05:40:00', '2024-02-10 20:00:00'),
(8, 'heidi', 'password8', 'heidi@example.com', '2024-02-01 04:30:00', '2024-02-15 21:15:00'),
(9, 'ivan', 'password9', 'ivan@example.com', '2024-02-05 03:20:00', '2024-02-20 22:00:00'),
(10, 'judy', 'password10', 'judy@example.com', '2024-02-10 02:10:00', '2024-02-25 23:45:00');

INSERT INTO usuarios_direccion (id_direccion, id_usuario, direccion, numero, cod_postal, provincia, pais) VALUES
(1, 1, '123 Main St', '1A', 12345, 'Madrid', 'España'),
(2, 2, '456 Elm St', '2B', 23456, 'Barcelona', 'España'),
(3, 3, '789 Oak St', '3C', 34567, 'Valencia', 'España'),
(4, 4, '101 Maple St', '4D', 45678, 'Sevilla', 'España'),
(5, 5, '202 Pine St', '5E', 56789, 'Zaragoza', 'España'),
(6, 6, '303 Cedar St', '6F', 67890, 'Bilbao', 'España'),
(7, 7, '404 Birch St', '7G', 78901, 'Malaga', 'España'),
(8, 8, '505 Walnut St', '8H', 89012, 'Murcia', 'España'),
(9, 9, '606 Ash St', '9I', 90123, 'Palma', 'España'),
(10, 10, '707 Cherry St', '10J', 12301, 'Granada', 'España');




