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

--
-- Definition for table tecnico
--
DROP TABLE IF EXISTS tecnico;
CREATE TABLE tecnico (
  CodTecnico INT(20) NOT NULL AUTO_INCREMENT,
  Nombre VARCHAR(40) NOT NULL,
  Apellido VARCHAR(40) NOT NULL,
  Usuario VARCHAR(40) NOT NULL,
  Contraseña VARCHAR(40) NOT NULL,
  PRIMARY KEY (CodTecnico)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table computadora
--
DROP TABLE IF EXISTS computadora;
CREATE TABLE computadora (
  codigo INT(3) NOT NULL AUTO_INCREMENT,
  marca VARCHAR(40) DEFAULT NULL,
  modelo VARCHAR(40) DEFAULT NULL,
  EstadoComputadora VARCHAR(40) DEFAULT NULL,
  CodCliente INT(7) DEFAULT NULL,
  PRIMARY KEY (codigo),
  INDEX CodCliente (CodCliente),
  CONSTRAINT computadora_ibfk_1 FOREIGN KEY (CodCliente)
    REFERENCES cliente(CodCliente) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table tienda
--
DROP TABLE IF EXISTS tienda;
CREATE TABLE tienda (
  codigoTienda INT(11) NOT NULL,
  codTecnico INT(11) DEFAULT NULL,
  codigoAccesorios INT(11) DEFAULT NULL,
  codigoDueño INT(11) DEFAULT NULL,
  PRIMARY KEY (codigoTienda),
  UNIQUE INDEX UK_tienda_codTecnico (codTecnico),
  UNIQUE INDEX UK_tienda_codigoAccesorios (codigoAccesorios),
  UNIQUE INDEX UK_tienda_codigoDueño (codigoDueño),
  CONSTRAINT FK_tienda_accesorios_codigo FOREIGN KEY (codigoAccesorios)
    REFERENCES accesorios(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_tienda_dueño_Codigo FOREIGN KEY (codigoDueño)
    REFERENCES dueño(Codigo) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_tienda_tecnico_CodTecnico FOREIGN KEY (codTecnico)
    REFERENCES tecnico(CodTecnico) ON DELETE NO ACTION ON UPDATE NO ACTION
)
ENGINE = INNODB
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

--
-- Definition for table reparacion
--
DROP TABLE IF EXISTS reparacion;
CREATE TABLE reparacion (
  codigo INT(3) NOT NULL AUTO_INCREMENT,
  problema VARCHAR(40) DEFAULT NULL,
  solucion VARCHAR(40) DEFAULT NULL,
  codigoComputadora INT(7) DEFAULT NULL,
  codigoTecnico INT(7) DEFAULT NULL,
  fechaIngreso DATE DEFAULT NULL,
  fechaSalida DATE DEFAULT NULL,
  PRIMARY KEY (codigo),
  INDEX codigoComputadora (codigoComputadora),
  INDEX codigoTecnico (codigoTecnico),
  CONSTRAINT reparacion_ibfk_1 FOREIGN KEY (codigoComputadora)
    REFERENCES computadora(codigo) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT reparacion_ibfk_2 FOREIGN KEY (codigoTecnico)
    REFERENCES tecnico(CodTecnico) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET latin1
COLLATE latin1_swedish_ci;

-- 
-- Dumping data for table accesorios
--

-- Table SerTecCom.accesorios does not contain any data (it is empty)

-- 
-- Dumping data for table cliente
--

-- Table SerTecCom.cliente does not contain any data (it is empty)

-- 
-- Dumping data for table dueño
--

-- Table SerTecCom.dueño does not contain any data (it is empty)

-- 
-- Dumping data for table tecnico
--

-- Table SerTecCom.tecnico does not contain any data (it is empty)

-- 
-- Dumping data for table computadora
--

-- Table SerTecCom.computadora does not contain any data (it is empty)

-- 
-- Dumping data for table tienda
--

-- Table SerTecCom.tienda does not contain any data (it is empty)

-- 
-- Dumping data for table reparacion
--

-- Table SerTecCom.reparacion does not contain any data (it is empty)

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;