ALTER TABLE `usuarios`
	CHANGE COLUMN `contraseña` `contraseña` VARCHAR(250) NOT NULL DEFAULT '0' AFTER `telefono`;
