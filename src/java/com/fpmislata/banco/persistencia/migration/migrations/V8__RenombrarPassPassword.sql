ALTER TABLE `usuarios`
	CHANGE COLUMN `pass` `password` VARCHAR(250) NOT NULL DEFAULT '0' AFTER `telefono`;
ALTER TABLE `administradores`
	CHANGE COLUMN `pass` `password` VARCHAR(250) NOT NULL DEFAULT '0' AFTER `email`;