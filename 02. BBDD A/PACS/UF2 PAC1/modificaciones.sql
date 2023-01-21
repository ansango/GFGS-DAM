/* Primero usamos la bbdd para poder hacer las consultas*/
USE jardineria;

/*Modifica la tabla producto añadiendo un campo de texto llamado detalle*/
ALTER TABLE productos ADD COLUMN detalle varchar(30);

/*Elimina el campo detalle*/ 
ALTER TABLE productos DROP COLUMN detalle;

/*Renombra tabla oficias por oficina*/
RENAME TABLE oficinas TO oficina;

/*Borra tabla oficina,
para ello primero eliminamos la referencia de la clave foranea en la tabla empleados
usando su nombre de indice*/
ALTER TABLE empleados DROP FOREIGN KEY empleados_ibfk_1;
/*ya despues si podemos eliminar la tabla oficina*/
DROP TABLE oficina;

/*Borrar toda la base datos*/
DROP DATABASE jardineria;


