ALTER TABLE `administradores`
	CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT FIRST;
ALTER TABLE `administradores`
	CHANGE COLUMN `apellido` `apellidos` VARCHAR(50) NULL DEFAULT NULL AFTER `nombre`;