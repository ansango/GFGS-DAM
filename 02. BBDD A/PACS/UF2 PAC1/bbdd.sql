/*Se crea la base de datos jardineria*/
CREATE DATABASE jardineria CHARACTER SET Latin1 COLLATE latin1_spanish_ci;
/*Se usa el comando USE para hacer uso de la base de datos*/
USE jardineria;
/*Primero se crean las tablas que no tienen claves foraneas */
CREATE TABLE oficinas (
	codigo_oficina integer PRIMARY KEY,
	ciudad varchar(25),
	pais varchar(25),
	region varchar(25),
	codigo_postal numeric(5),
	telefono numeric(9),
	linea_direccion1 varchar(120),
	linea_direccion2 varchar(120)
);

CREATE TABLE gamasproductos (
	
	gama varchar(25) PRIMARY KEY,	
	descripcion_texto varchar(120),	
	descripcion_html varchar (120),	
	imagen longblob

);

/*Despues vamos creando las tablas de tal forma que no cree una tabla que
tenga alguna clave foranea de una tabla que aun no se haya creado */
CREATE TABLE empleados (

	codigo_empleado	integer PRIMARY KEY,	
	nombre varchar(25),
	apellido1 varchar(25),
	apellido2 varchar(25),
	extension numeric(6),
	email varchar(25),
	codigo_oficina integer,
	codigo_jefe integer,
	puesto varchar(25),
	FOREIGN KEY (codigo_oficina) REFERENCES oficinas(codigo_oficina) ON DELETE CASCADE

);

CREATE TABLE productos (	
	
	codigo_producto integer PRIMARY KEY,
	nombre varchar(25),
	gama varchar(25),
	dimensiones varchar(25),
	proovedor numeric(6),
	descripcion varchar(25),
	canditad_stock numeric(6),
	precio_venta float(6,2),
	precio_proovedor float(6,2),
	FOREIGN KEY (gama) REFERENCES gamasproductos(gama) ON DELETE CASCADE
);

CREATE TABLE clientes (
	codigo_cliente integer PRIMARY KEY,
	nombre_cliente varchar(25),
	nombre_contacto varchar(25),
	apellido_contacto varchar(25),
	telefono  numeric(9),
	fax  numeric(9),
	linea_direccion1 varchar(120),
	linea_direccion2 varchar(120),
	ciudad varchar(25),
	pais varchar(25),
	region varchar(25),
	codigo_postal numeric(5),
	codigo_empleado_respventa integer,
	limite_credito  float(6,2),
	FOREIGN KEY (codigo_empleado_respventa) REFERENCES empleados (codigo_empleado) ON DELETE CASCADE
);

CREATE TABLE pagos (
	codigo_cliente integer,
	forma_pago varchar(1),
	id_transaccion integer,
	fecha_pago date,
	cantidad float(6,2),
	PRIMARY KEY (codigo_cliente,id_transaccion),
	FOREIGN KEY (codigo_cliente) REFERENCES clientes (codigo_cliente) ON DELETE CASCADE
);
CREATE TABLE pedidos(
	
	codigo_pedido integer	PRIMARY KEY,
	fecha_pedido date,
	fecha_esperada date,
	fecha_entrega date,
	estado varchar(1),
	comentarios varchar (120),
	codigo_cliente integer,
	FOREIGN KEY (codigo_cliente) REFERENCES clientes (codigo_cliente) ON DELETE CASCADE

);

CREATE TABLE detallepedidos(
	codigo_pedido integer,
	codigo_producto integer,
	cantidad float(6,2),
	precio_unidad float(6,2),
	numerolinea integer,
	PRIMARY KEY (codigo_pedido, codigo_producto),
	FOREIGN KEY (codigo_pedido) REFERENCES pedidos (codigo_pedido) ON DELETE CASCADE ON UPDATE CASCADE, 
	FOREIGN KEY (codigo_producto) REFERENCES productos (codigo_producto) ON DELETE CASCADE ON UPDATE CASCADE
);
