
/*1. Obtener los datos de todos los jugadores.*/
USE liga;
SELECT * FROM jugadores;


/*2. Obtener los datos de los jugadores que se encuentren en el equipo 1.*/
Select * FROM jugadores WHERE equipo=1;


/*3. Obtener datos de todos los jugadores menos los de los equipos uno, dos y tres.*/
SELECT * FROM jugadores WHERE equipo>3;


/*4. Obtener el número de ciudades en las que hay equipos.*/
SELECT count(distinct ciudad) FROM  equipos;


/*5. Listado de partidos ordenado por equipo, local y fecha.*/
SELECT * FROM partidos ORDER BY elocal, fecha; 


/*6. Número de partidos ganados por equipos locales.*/
SELECT COUNT(resultado) FROM partidos WHERE 
	cast(substring_index(resultado, '-', 1) AS UNSIGNED )  > 
	cast(substring_index(resultado, '-', -1) AS UNSIGNED) ;

	
/*7. Nombres de jugadores que empiecen por “A” y tengan al menos 2 vocales.*/
SELECT nombre FROM jugadores WHERE nombre REGEXP '^A.[aeiouAEIOU].[aeiouAEIOU].';


/*8. Datos del último partido, incluyendo el nombre de los equipos y jugadores.*/
SELECT jugadores.nombre, jugadores.apellido, equipos.id_equipo, equipos.nombre, partidos.*
	FROM jugadores Inner Join equipos Inner Join partidos
    ON  partidos.fecha = (SELECT MAX(fecha) FROM partidos) 
    AND jugadores.equipo = partidos.elocal 
    AND equipos.id_equipo = partidos.elocal
UNION 
SELECT jugadores.nombre, jugadores.apellido, equipos.id_equipo, equipos.nombre, partidos.*
	FROM jugadores Inner Join equipos Inner Join partidos
    ON  partidos.fecha = (SELECT MAX(fecha) FROM partidos) 
    AND jugadores.equipo = partidos.evisitante 
    AND equipos.id_equipo = partidos.evisitante;
    
    
/*9. Datos del equipo y del capitán para equipos que hayan ganado más de 2 partidos
como visitantes.*/
SELECT DISTINCT partidos.evisitante, equipos.nombre ,jugadores.id_capitan
FROM partidos inner join equipos inner join jugadores
ON partidos.evisitante IN (SELECT partidos.evisitante FROM partidos WHERE 
	(cast(substring_index(resultado, '-', 1) AS UNSIGNED )  < 
	cast(substring_index(resultado, '-', -1) AS UNSIGNED)) group by partidos.evisitante having count(partidos.evisitante)>2 ) 
    AND equipos.id_equipo = partidos.evisitante
    AND jugadores.equipo = equipos.id_equipo;
    
    
/*10. Realizar una consulta para mostrar los equipos que no han jugado ningún partido
como locales*/
SELECT * FROM equipos WHERE id_equipo NOT IN (SELECT elocal FROM partidos);
