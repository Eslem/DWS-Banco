-- Volcando estructura para tabla banco.administradores
CREATE TABLE `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(250) NOT NULL,
  `sucursal` int(11) DEFAULT NULL COMMENT 'idsucursal',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.administradores: ~2 rows (aproximadamente)
INSERT INTO `empleados` (`id`, `nombre`, `apellidos`, `dni`, `direccion`, `telefono`, `email`, `password`, `sucursal`) VALUES
	(1, 'Administrador1', 'Ministro Admin', '47777777P', 'C/ Desconocida 1 -10', 969999999, 'algo@gmail.com', 'BpAundR1yF3mcxaoWsl9Ijuwi9KmrsLd', 5),
	(2, 'Administrador2', 'Ministra Admin', '48888888s', 'C/ Falsa 1- 23', 968888888, 'cosa@gmail.com', 'BpAundR1yF3mcxaoWsl9Ijuwi9KmrsLd', 2),
	(3, 'Gilgamesh', 'Rey de Reyes', '28765439z', 'C/ Falsa 1- 23', 961475632, 'a@s.d', 'BpAundR1yF3mcxaoWsl9Ijuwi9KmrsLd', 1);


-- Volcando estructura para tabla banco.cuentas
CREATE TABLE `cuentas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saldo` decimal(15,2) DEFAULT '0.00',
  `idsucursal` int(10) unsigned,
  `tipo` enum('Ahorro','Corriente') NOT NULL DEFAULT 'Corriente',
  `cliente` int(9) NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.cuentas: ~3 rows (aproximadamente)
INSERT INTO `cuentas` (`id`, `saldo`, `idsucursal`, `tipo`, `cliente`, `fecha`) VALUES
	(1, 123.00, 11, 'Corriente', 1, '2014-12-04'),
	(2, 47585.00, 52, 'Ahorro', 2, '2014-01-04');


-- Volcando estructura para tabla banco.entidadesbancarias
CREATE TABLE `entidadesbancarias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `codigo` varchar(50) DEFAULT NULL,
  `fecha` date DEFAULT NULL, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.entidadesbancarias: ~0 rows (aproximadamente)
INSERT INTO `entidadesbancarias` (`id`, `nombre`, `codigo`, `fecha`) VALUES
	(1, 'Entidad1', '11', '2011-08-08'),
	(2, 'Entidad2', '12', '2013-05-04');


-- Volcando estructura para tabla banco.movimientos
CREATE TABLE `movimientos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50),
  `idcuenta` int(11) COMMENT 'idcuenta',
  `concepto` varchar(50),
  `cantidad` varchar(50),
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.movimientos: ~0 rows (aproximadamente)
INSERT INTO `movimientos` (`id`, `tipo`, `idcuenta`,  `concepto`, `cantidad`, `fecha`) VALUES
	(1, 'Debe', 1,  'Factura luz', '250', '2014-12-04'),
	(2, 'Haber', 3, 'Error factura luz', '0.55', '2013-05-04');





-- Volcando estructura para tabla banco.sucursalesbancarias
CREATE TABLE `sucursalesbancarias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `poblacion` varchar(50) NOT NULL,
  `cp` int(5) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `entidad` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `entidad` (`entidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.sucursalesbancarias: ~0 rows (aproximadamente)
INSERT INTO `sucursalesbancarias` (`id`, `nombre`, `poblacion`, `cp`, `telefono`, `entidad`, `fecha`) VALUES
	(1, 'Sucursal1', 'Manises', 46940, 961111111, 1, '2014-12-04'),
	(2, 'Sucursal2', 'Quart', 46939, 961222222, 2, '2014-12-04');



-- Volcando estructura para tabla banco.usuarios
CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `password` varchar(250) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.usuarios: ~0 rows (aproximadamente)
INSERT INTO `clientes` (`id`, `nombre`, `apellidos`, `dni`, `direccion`, `telefono`, `password`, `email`) VALUES
	(1, 'Usuario1', 'Snow', '47777777P', 'Unknown', 965555555, 'asdfg', 'a@g.ccom'),
	(2, 'Usuario2', 'Lannister', '41111111M', 'Casterly Rock', 964444444, 'asdfg', 'o@g.com');
