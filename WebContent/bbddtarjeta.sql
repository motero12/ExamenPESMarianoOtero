-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.24 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para banco
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banco`;


-- Volcando estructura para tabla banco.tarjetacredito
CREATE TABLE IF NOT EXISTS `tarjetacredito` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `numeroTarjeta` varchar(50) NOT NULL DEFAULT '0',
  `cupoMaximo` int(11) NOT NULL DEFAULT '0',
  `cupoDisponible` int(11) NOT NULL DEFAULT '0',
  `tipoTarjeta` varchar(10) NOT NULL DEFAULT '0',
  `numeroComprobacion` int(11) NOT NULL DEFAULT '0',
  `contrasenha` smallint(6) NOT NULL DEFAULT '0',
  `Bloqueada` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `numeroTarjeta` (`numeroTarjeta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Tarjetas de Crédito del banco';

-- Volcando datos para la tabla banco.tarjetacredito: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tarjetacredito` DISABLE KEYS */;
INSERT INTO `tarjetacredito` (`id`, `numeroTarjeta`, `cupoMaximo`, `cupoDisponible`, `tipoTarjeta`, `numeroComprobacion`, `contrasenha`, `Bloqueada`) VALUES
	(1, '111122223333', 10000, 800, 'Visa', 1234567, 0, 0),
	(2, '222333444555', 2000, 3800, 'MasterCard', 1234567, 0, 0);
/*!40000 ALTER TABLE `tarjetacredito` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
