-- 1) Crea la base de datos coches y todas las tablas que aparecen en el modelo E-R.

-- Crear Base de Datos:
CREATE DATABASE coches;

-- Para que use por defecto nuestra base de datos (puede haber otras instaladas):
USE coches;

-- Creamos las tablas
CREATE TABLE MARCA (
	cifm VARCHAR(10) NOT NULL, 
	nombre VARCHAR(45), 
	ciudad VARCHAR(45), 
	PRIMARY KEY (cifm));

CREATE TABLE COCHE(
	codcoche VARCHAR(10) NOT NULL, 
	nombre VARCHAR(45), 
	modelo VARCHAR(20), 
	PRIMARY KEY (codcoche));

CREATE TABLE CONCESIONARIO(
	cifc VARCHAR(10)  NOT NULL, 
	nombre VARCHAR(45), 
	ciudad VARCHAR(45), 
	PRIMARY KEY (cifc));

CREATE TABLE CLIENTE(
	dni VARCHAR(10)  NOT NULL, 
	nombre VARCHAR(45), 
	apellidos VARCHAR(150), 
	ciudad VARCHAR(45), 
	PRIMARY KEY (dni));

CREATE TABLE DISTRIBUCION(
	cifc VARCHAR(10)  NOT NULL, 
	codcoche VARCHAR(10)  NOT NULL, 
	cantidad INT,
	PRIMARY KEY (cifc, codcoche),
	FOREIGN KEY(cifc) references  CONCESIONARIO(cifc)
	on delete cascade on update cascade,
	FOREIGN KEY(codcoche) references  COCHE(codcoche)
	on delete cascade on update cascade); 

CREATE TABLE VENTA(
	cifc VARCHAR(10)  NOT NULL, 
	dni VARCHAR(10)  NOT NULL, 
	codcoche VARCHAR(10)  NOT NULL, 
	color VARCHAR (20),
	PRIMARY KEY (cifc, dni, codcoche),
	FOREIGN KEY(cifc) references  CONCESIONARIO(cifc)
	on delete cascade on update cascade,
	FOREIGN KEY(dni) references  CLIENTE(dni)
	on delete cascade on update cascade,
	FOREIGN KEY(codcoche) references  COCHE(codcoche)
	on delete cascade on update cascade); 

CREATE TABLE MARCO(
	cifm VARCHAR(10)  NOT NULL, 
	codcoche VARCHAR(10)  NOT NULL,
	PRIMARY KEY (cifm, codcoche),
	FOREIGN KEY(cifm) references  MARCA(cifm)
	on delete cascade on update cascade,
	FOREIGN KEY(codcoche) references  COCHE(codcoche)
	on delete cascade on update cascade); 

-- 2) Indica las sentencias correspondientes para rellenar las tablas con los datos que aparecen en la imagen.
Insert into coches.MARCA values ('0001','Seat','Sevilla');
Insert into coches.MARCA values ('0002','Renault','Barcelona');
Insert into coches.MARCA values ('0003','Audi','Bilbao');
Insert into coches.MARCA values ('0004','BMV','Valencia');
Insert into coches.MARCA values ('0005','Opel','Malaga');
Insert into coches.MARCA values ('0006','Citroen','Salamanca');

Insert into coches.COCHE values ('0001','Ibiza','Gtx');
Insert into coches.COCHE values ('0002','Ibiza','Gti');
Insert into coches.COCHE values ('0003','Ibiza','Gtd');
Insert into coches.COCHE values ('0004','Toledo','Gtd');
Insert into coches.COCHE values ('0005','Cordoba','Gti');
Insert into coches.COCHE values ('0006','Megane','1.6');
Insert into coches.COCHE values ('0007','Megane','Gti');
Insert into coches.COCHE values ('0008','Laguna','Gtd');
Insert into coches.COCHE values ('0009','Laguna','Td');
Insert into coches.COCHE values ('0010','Zx','16V');
Insert into coches.COCHE values ('0011','Zx','Td');
Insert into coches.COCHE values ('0012','Xantia','Gtd');
Insert into coches.COCHE values ('0014','A4','1.8');
Insert into coches.COCHE values ('0013','A4','2.8');
Insert into coches.COCHE values ('0015','Astra','Caravan');
Insert into coches.COCHE values ('0016','Astra','Gti');
Insert into coches.COCHE values ('0017','Corsa','1.4');
Insert into coches.COCHE values ('0018','300','316i');
Insert into coches.COCHE values ('0019','500','525i');
Insert into coches.COCHE values ('0020','700','750i');

Insert into coches.CONCESIONARIO values ('0001','Tienda1','Madrid');
Insert into coches.CONCESIONARIO values ('0002','Tienda2','Barcelona');
Insert into coches.CONCESIONARIO values ('0003','Tienda3','Valencia');
Insert into coches.CONCESIONARIO values ('0004','Tienda 4','Madrid');
Insert into coches.CONCESIONARIO values ('0005','Tienda5','Bilbao');

Insert into coches.CLIENTE values ('0001','Juan','Garrido Fernandez', 'Madrid');
Insert into coches.CLIENTE values ('0002','Lola','Perez Garcia', 'Sevilla');
Insert into coches.CLIENTE values ('0003','Ana','Cuco Morales', 'Barcelona');
Insert into coches.CLIENTE values ('0004','Juan','Martinez Gonzalez', 'Valencia');
Insert into coches.CLIENTE values ('0005','Pepe','Garcia Garcia', 'Valencia');
Insert into coches.CLIENTE values ('0006','Carmen','Castro Roa', 'Barcelona');

Insert into coches.DISTRIBUCION values ('0001','0001',3);
Insert into coches.DISTRIBUCION values ('0001','0005',7);
Insert into coches.DISTRIBUCION values ('0001','0006',7);
Insert into coches.DISTRIBUCION values ('0002','0006',5);
Insert into coches.DISTRIBUCION values ('0002','0008',10);
Insert into coches.DISTRIBUCION values ('0002','0009',10);
Insert into coches.DISTRIBUCION values ('0003','0010',5);
Insert into coches.DISTRIBUCION values ('0003','0011',3);
Insert into coches.DISTRIBUCION values ('0003','0012',5);
Insert into coches.DISTRIBUCION values ('0004','0013',10);
Insert into coches.DISTRIBUCION values ('0004','0014',5);
Insert into coches.DISTRIBUCION values ('0005','0015',10);
Insert into coches.DISTRIBUCION values ('0005','0016',20);
Insert into coches.DISTRIBUCION values ('0005','0017',8);

Insert into coches.VENTA values ('0001','0001','0001', 'Blanco');
Insert into coches.VENTA values ('0001','0002','0005', 'Rojo');
Insert into coches.VENTA values ('0002','0003','0008', 'Verde');
Insert into coches.VENTA values ('0002','0001','0006', 'Rojo');
Insert into coches.VENTA values ('0003','0004','0005', 'Azul');
Insert into coches.VENTA values ('0004','0005','0014', 'Verde');

Insert into coches.MARCO values ('0001','0001');
Insert into coches.MARCO values ('0001','0002');
Insert into coches.MARCO values ('0001','0003');
Insert into coches.MARCO values ('0001','0004');
Insert into coches.MARCO values ('0001','0005');
Insert into coches.MARCO values ('0002','0006');
Insert into coches.MARCO values ('0002','0007');
Insert into coches.MARCO values ('0002','0008');
Insert into coches.MARCO values ('0002','0009');
Insert into coches.MARCO values ('0003','0010');
Insert into coches.MARCO values ('0003','0011');
Insert into coches.MARCO values ('0003','0012');
Insert into coches.MARCO values ('0004','0013');
Insert into coches.MARCO values ('0004','0014');
Insert into coches.MARCO values ('0005','0015');
Insert into coches.MARCO values ('0005','0016');
Insert into coches.MARCO values ('0005','0017');
Insert into coches.MARCO values ('0006','0018');
Insert into coches.MARCO values ('0006','0019');
Insert into coches.MARCO values ('0006','0020');

-- 3) Borra los tres últimos registros de la tabla coches y la tabla distribución

DELETE FROM DISTRIBUCION
ORDER BY cifc DESC LIMIT 3; 

DELETE FROM COCHE ORDER BY codcoche DESC LIMIT 3; 

-- 4) Crea un índice en la tabla MARCA llamado icifm, del campo cifm 
-- y otro en la tabla coches llamado itodos, de todos los campos

CREATE INDEX icifm ON MARCA (cifm);
CREATE INDEX itodos ON COCHE (codcoche, nombre, modelo);

-- 5) Añade a la tabla MARCA un nuevo campo llamado país y otro a la tabla coche llamado valoración.

ALTER TABLE marca ADD pais VARCHAR(45);
ALTER TABLE coche ADD valoracion INT;

-- 6) Obtén todos los campos de todos los clientes de ‘Madrid’

SELECT * FROM CLIENTE 
WHERE ciudad = 'Madrid';

-- 7) Obtener los nombres de todas las marcas de coches ordenadas alfabeticamente. 

SELECT nombre 
FROM MARCA 
ORDER BY nombre ASC;

-- 8) Obtener el cifc de todos los concesionarios cuyo atributo cantidad en la 
-- tabla de distribución es mayor que 18. 

select distinct cifc, SUM(cantidad) as Q 
from distribucion 
group by cifc 
having Q>18;

-- 9) Obtener cif de todos los concesionarios cuyo atributo cantidad en la tabla de distribucion, 
-- está comprendido entre 10 y 18 ambos inclunsive.

select distinct cifc 
from distribucion 
group by cifc 
having SUM(cantidad) 
BETWEEN 10 and 18

-- 10) Obtener el cifc de todos los concesionarios que han adquirido mas de 10 coches o menos de 5.

select distinct cifc 
from distribucion 
group by cifc 
having SUM(cantidad) 
BETWEEN 5 and 10;

-- 11) Obtener todas las parejas de cifm de marcas y dni de clientes que sean de la misma ciudad. 

SELECT M.cifm, C.dni 
FROM MARCA M, Cliente C
Where M.ciudad = C.ciudad;  

-- 12) Obtener todas las parejas de dni de clientes y cifm de marcas que no sean de misma ciudad

SELECT M.cifm, C.dni 
FROM MARCA M, Cliente C
Where M.ciudad != C.ciudad;  

-- 13) Obtener los codcoche suministrados por algún concesionario de ‘Barcelona’. 

SELECT D.codcoche 
FROM CONCESIONARIO C
INNER JOIN DISTRIBUCION D 
ON (C.cifc = D.cifc)
WHERE C.ciudad LIKE 'Barcelona';

-- 14) Obtener codcoche de aquellos coches vendidos a clientes de ‘Madrid’. 

SELECT V.codcoche
FROM VENTA V 
INNER JOIN CLIENTE C 
ON (V.dni = C.dni)
WHERE C.ciudad LIKE 'Madrid';

-- 15) Obtener codcoche de los coches que han sido adquiridos por un cliente ‘Madrid’ 
-- en un concesionario de ‘Madrid’.  

SELECT V.codcoche
FROM CLIENTE Cl 
INNER JOIN VENTA V 
ON (Cl.dni = V.dni)
JOIN CONCESIONARIO Co
ON (V.cifc = Co.cifc)
WHERE Cl.ciudad LIKE 'Madrid'
AND Co.ciudad LIKE 'Madrid';
