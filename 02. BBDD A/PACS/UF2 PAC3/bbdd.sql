-- 1. Emparejar correctamente, qué hace qué?:
--  ---------------		  
-- | 1 | 2 | 3 | 4 |
-- -----------------
-- | B | C | D | A |
--  ---------------

-- 2. Principales diferencias entre el comando TRUNCATE y el DELETE: marcar con x la columna del comando al que corresponda cada afirmación:
--  --------------------------------------------------------------------
-- |									|	TRUNCATE	|	DELETE		| 
--  ---------------------------------------------------------------------
-- | Borra toda la tabla y la recrea	|		X		|				|
-- ----------------------------------------------------------------------
-- | Elimina filas una a una  		  	|				|		X		|
-- ----------------------------------------------------------------------
-- | Es mas rapido					  	|     	X    	|        		|
-- ----------------------------------------------------------------------
-- | No se puede revocar o deshacer	  	|     	X    	|        		|
--  ---------------------------------------------------------------------

-- 3. Indicar el comando necesario para aumentar el salario de los jugadores de más de dos metros un 10 %.

UPDATE jugadores SET salario = salario * 1.10 WHERE altura > 2;

-- 4. Con el comando ALTER TABLE podemos añadir a la tabla jugadores la columna puntos_equipo para reflejar todos los puntos de su equipo. 
-- Una vez creado el campo, ¿cuál sería el comando para actualizar sus valores con los valores correctos en la tabla equipos?

ALTER TABLE jugadores ADD puntos_equipo INT;

UPDATE jugadores SET puntos_equipo = (SELECT puntos FROM equipos WHERE equipo = id_equipo);

-- 5. Escribir en el orden correcto cuáles serían los comandos necesarios para eliminar todos los datos de las tablas en la base liga.
--  Justificar la respuesta.

-- Con el comando truncate podemos borrar los datos de cada tabla, elijo truncate por que es mas rapido que delete aunque no permita deshacer los cambios.

TRUNCATE jugadores;
TRUNCATE equipos;
TRUNCATE partidos;

-- Con delete seria asi:

DELETE FROM jugadores;
DELETE FROM equipos;
DELETE FROM partidos;

-- 6. Escribir una sentencia que borre registros de equipos que no hayan jugado partidos.

DELETE FROM equipos WHERE id_equipo NOT IN (SELECT id_equipo FROM (SELECT id_equipo FROM equipos, partidos WHERE id_equipo = elocal OR id_equipo = evisitante) x);

-- 7. Indicar si es verdadero (V) o falso (F) cada uno de los requisitos de los que se especifican para que una vista creada sea actualizable.
-- ---------------------------------------------------------------------------------------------------------
-- | Correspondencia uno a uno entre las filas de la vista y las tablas subyacentes						| V |
-- ----------------------------------------------------------------------------------------------------------
-- | Combinacion de multiples tablas											  						| F |
-- ----------------------------------------------------------------------------------------------------------
-- | Existencia de clausulas GROUP BY, HAVING, DISTINCT, UNION o subconsultas en el predicado de SELECT	| V |
--  --------------------------------------------------------------------------------------------------------

-- 8. Escribir las sentencias necesarias para:
-- - Crear una vista con los campos nombre y equipo de los jugadores del CAI Zaragoza

CREATE VIEW cai_zaragoza AS SELECT jugadores.nombre AS nombre, equipos.nombre AS equipo FROM equipos, jugadores WHERE id_equipo = equipo AND equipos.nombre = 'CAI Zaragoza';

-- - Crear otra basada en la anterior con solo los nombres de jugadores del CAI Zaragoza

CREATE VIEW nombres_cai AS SELECT nombre FROM cai_zaragoza;

-- - ¿A través de esta última vista, se podría modificar los nombres de los jugadores poniéndolos en mayúscula? En caso afirmativo, escribir como sería la sentencia.

UPDATE nombres_cai SET nombre = UPPER(nombre);

-- 9. Crear dos vistas, una con los campos nombre, id_jugador, equipo y altura y otra con id_jugador, equipo y nombre, ambas basadas en la tabla jugador. 
-- ¿se podría Insertar un nuevo jugador a través de cualquiera de ellas? En caso afirmativo, escribir como serían las sentencias.

CREATE VIEW vista1 AS SELECT nombre, id_jugador, equipo, altura FROM jugadores;

INSERT INTO vista1 VALUES ('Fulanito', 16, 1, 1.78); 

CREATE VIEW vista2 AS SELECT id_jugador, equipo, nombre FROM jugadores;

INSERT INTO vista2 VALUES (17, 2, 'Menganito');

-- 10. Explicar qué es lo que haría la transacción siguiente:

-- START TRANSACTION
-- Iniciamos la transaccion y a continuacion escribimos todas las sentencias que va a contener.

-- USE ebanca;
-- Seleccionamos la base de datos ebanca.

-- UPDATE cuentas SET saldo=saldo+2000 WHERE cod_cuenta=3; 
-- Aumentamos en 2000 el saldo de la cuenta 3 de la tabla cuentas.

-- UPDATE cuentas SET saldo=saldo-2000 WHERE cod_cuenta=4; 
-- Reducimos en 2000 el saldo de la cuenta 4 de la tabla cuentas.

-- INSERT INTO MOVIMIENTOS VALUES(now(),2000,117,3,0); 
-- Insertamos una nueva fila en la tabla movimientos con la fecha y hora actual y los numeros 2000, 117, 3, 0.

-- INSERT INTO MOVIMIENTOS VALUES(now(),-2000,117,4,0); 
-- Insertamos otra fila en la tabla movimientos con la fecha y hora actual y los numeros -2000, 117, 4, 0.

-- COMMIT;
-- Finalizamos la transaccion para que ejecute en bloque todas las sentencias.

