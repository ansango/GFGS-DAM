/* 1. Obtener los datos de todos los jugadores */

SELECT * FROM jugadores;

/* 2. Obtener los datos de los jugadores que se encuentran en el equipo 1 */

SELECT * FROM jugadores WHERE equipo = 1;


/* 3. Obtener datos de todos los jugadores que no están en los equipos 1, 2 o 3 */
SELECT * FROM jugadores WHERE equipo IN (1,2,3);


/* 4.   */
SELECT COUNT(DISTINCT ciudad) FROM equipos;


-- 5. 
SELECT * FROM partidos ORDER BY elocal, fecha;


-- 6. 
SELECT COUNT(resultado) from partidos WHERE 0 < (SUBSTRING_INDEX(resultado, '-', 1) - SUBSTRING_INDEX(resultado, '-', -1))


-- 7. 
SELECT * FROM `jugadores` WHERE nombre LIKE 'A%' AND NOMBRE RLIKE '.*[aeiou]+.*[aeiou]+.*'


-- 8.

SELECT P.* , E1.nombre EQUIPO_LOCAL, J1.nombre, E2.nombre EQUIPO_VISITANTE, J2.nombre
FROM partidos P
INNER JOIN equipos E1
ON P.elocal = E1.id_equipo 
INNER JOIN equipos E2
ON P.evisitante = E2.id_equipo
INNER JOIN jugadores J1
ON P.elocal = J1.equipo
INNER JOIN jugadores J2
ON P.evisitante = J2.equipo
WHERE P.fecha IN (SELECT MAX(fecha) FROM partidos)

--9.

SELECT E.*, J.* FROM equipos E, jugadores J 
WHERE J.equipo = E.id_equipo
AND J.id_jugador IN (SELECT id_capitan FROM jugadores WHERE equipo IN (
          SELECT P.evisitante
                    FROM partidos P
                    WHERE 0 > (SUBSTRING_INDEX(resultado, '-', 1) - SUBSTRING_INDEX(resultado, '-', -1))
                    HAVING COUNT(resultado) > 2))
AND E.id_equipo IN (SELECT P.evisitante
                    FROM partidos P
                    WHERE 0 > (SUBSTRING_INDEX(resultado, '-', 1) - SUBSTRING_INDEX(resultado, '-', -1))
                    HAVING COUNT(resultado) > 2
                   )

--10.

SELECT E.* FROM equipos E WHERE E.id_equipo NOT IN (SELECT P.elocal FROM partidos P)
