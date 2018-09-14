-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Set character set the client will use to send SQL statements to the server
--
SET NAMES 'utf8';

-- 
-- Set default database
--
USE SerTecCom;

--
-- Definition for table accesorios
--
DROP TABLE IF EXISTS accesorios;
CREATE TABLE accesorios (
  codigo INT(3) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) DEFAULT NULL,
  precio INT(5) DEFAULT NULL,
  modelo VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (codigo)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table cliente
--
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
  CodCliente INT(7) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(15) NOT NULL,
  apellido VARCHAR(15) NOT NULL,
  computadora INT(11) NOT NULL,
  PRIMARY KEY (CodCliente)
)
ENGINE = INNODB
AUTO_INCREMENT = 983029
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table dueño
--
DROP TABLE IF EXISTS dueño;
CREATE TABLE dueño (
  Codigo INT(11) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(40) NOT NULL,
  apellido VARCHAR(40) NOT NULL,
  usuario VARCHAR(20) NOT NULL,
  contraseña VARCHAR(20) NOT NULL,
  PRIMARY KEY (Codigo)
)
ENGINE = INNODB
AUTO_INCREMENT = 2
CHARACTER SET latin1
COLLATE latin1_swedish_ci;