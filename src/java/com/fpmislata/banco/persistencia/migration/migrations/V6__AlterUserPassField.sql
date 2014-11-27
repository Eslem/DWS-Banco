ALTER TABLE `usuarios`
	CHANGE COLUMN `contraseña` `pass` VARCHAR(250) NOT NULL DEFAULT '0' AFTER `telefono`;
ALTER TABLE `administradores`
	CHANGE COLUMN `contraseña` `pass` VARCHAR(250) NOT NULL DEFAULT '0' AFTER `email`;