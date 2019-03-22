-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 22-03-2019 a las 04:55:20
-- Versión del servidor: 5.7.21
-- Versión de PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `planilla`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

DROP TABLE IF EXISTS `concepto`;
CREATE TABLE IF NOT EXISTS `concepto` (
  `codigo_concepto` varchar(10) NOT NULL,
  `nombre_concepto` varchar(50) DEFAULT NULL,
  `efecto_concepto` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo_concepto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `concepto`
--

INSERT INTO `concepto` (`codigo_concepto`, `nombre_concepto`, `efecto_concepto`) VALUES
('1', 'IGSS', 'negativo'),
('2', 'ISR', 'negativo'),
('3', 'DESCUENTOS JUDICIALES', 'negativo'),
('4', 'COMISIONES', 'positivo'),
('5', 'BONIFICACIONES', 'positivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE IF NOT EXISTS `departamento` (
  `codigo_departamento` varchar(10) NOT NULL,
  `nombre_departamento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`codigo_departamento`, `nombre_departamento`) VALUES
('1', 'direccion general'),
('10', 'sala de ventas'),
('2', 'auxiliar administrativo'),
('3', 'administracion'),
('4', 'recursos humanos'),
('5', 'finanzas'),
('6', 'contabilidad'),
('7', 'publicidad'),
('8', 'mercadotecnia'),
('9', 'informatica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_nomina`
--

DROP TABLE IF EXISTS `detalle_nomina`;
CREATE TABLE IF NOT EXISTS `detalle_nomina` (
  `codigo_nomina` varchar(10) NOT NULL,
  `codigo_empleado` varchar(10) NOT NULL,
  `codigo_concepto` varchar(10) NOT NULL,
  `valor_nomina_detalle` float DEFAULT NULL,
  PRIMARY KEY (`codigo_nomina`,`codigo_empleado`,`codigo_concepto`),
  KEY `FK_empleadoencabezadonomina` (`codigo_empleado`),
  KEY `FK_conceptoencabezadonomina` (`codigo_concepto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `codigo_empleado` varchar(10) NOT NULL,
  `nombre_empleado` varchar(50) DEFAULT NULL,
  `sueldo_empleado` float DEFAULT NULL,
  `codigo_puesto` varchar(10) NOT NULL,
  `codigo_departamento` varchar(10) NOT NULL,
  PRIMARY KEY (`codigo_empleado`),
  KEY `FK_puestoempleado` (`codigo_puesto`),
  KEY `FK_departamentoempleado` (`codigo_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`codigo_empleado`, `nombre_empleado`, `sueldo_empleado`, `codigo_puesto`, `codigo_departamento`) VALUES
('1', 'carlos antonio laib contreras', 5000, '11', '9'),
('2', 'brian santizo', 2500, '12', '9'),
('3', 'jose lopez', 4000, '10', '8'),
('4', 'bryan mazariegos', 5000, '1', '2'),
('5', 'bryan aguirre', 7000, '10', '1'),
('6', 'ricardo perez', 6500, '12', '3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encabezado_nomina`
--

DROP TABLE IF EXISTS `encabezado_nomina`;
CREATE TABLE IF NOT EXISTS `encabezado_nomina` (
  `codigo_nomina` varchar(10) NOT NULL,
  `fecha_inicial_nomina` varchar(10) DEFAULT NULL,
  `fecha_final_nomina` varchar(10) DEFAULT NULL,
  `valor_nomina` float DEFAULT NULL,
  PRIMARY KEY (`codigo_nomina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puesto`
--

DROP TABLE IF EXISTS `puesto`;
CREATE TABLE IF NOT EXISTS `puesto` (
  `codigo_puesto` varchar(10) NOT NULL,
  `nombre_puesto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo_puesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `puesto`
--

INSERT INTO `puesto` (`codigo_puesto`, `nombre_puesto`) VALUES
('1', 'agente comercial'),
('10', 'director de area de proyectos'),
('11', 'director general'),
('12', 'tecnico'),
('13', 'programador'),
('14', 'tecnico de sistemas'),
('15', 'analista 1'),
('16', 'analista 2'),
('17', 'analista 3'),
('18', 'encargado general'),
('19', 'especialista 1'),
('2', 'auxiliar administrativo'),
('20', 'especialista 2'),
('21', 'enfermero'),
('3', 'auxiliar de planta'),
('4', 'agente de compras'),
('5', 'agente de ventas'),
('6', 'capataz'),
('7', 'cobrador'),
('8', 'encargado'),
('9', 'delegado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `codigo_usuario` varchar(10) NOT NULL,
  `nombre_usuario` varchar(50) DEFAULT NULL,
  `clave_usuario` varchar(20) DEFAULT NULL,
  `estado_usuario` varchar(20) DEFAULT NULL,
  `codigo_empleado` varchar(10) NOT NULL,
  PRIMARY KEY (`codigo_usuario`),
  KEY `FK_codigoempleado` (`codigo_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`codigo_usuario`, `nombre_usuario`, `clave_usuario`, `estado_usuario`, `codigo_empleado`) VALUES
('0', 'laib', '12345', 'activo', '1'),
('2', 'jose', '12345', 'activo', '3'),
('3', 'brian', '123', 'inactivo', '2'),
('4', 'bryan', '123456', 'activo', '4');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_nomina`
--
ALTER TABLE `detalle_nomina`
  ADD CONSTRAINT `FK_conceptoencabezadonomina` FOREIGN KEY (`codigo_concepto`) REFERENCES `concepto` (`codigo_concepto`),
  ADD CONSTRAINT `FK_empleadoencabezadonomina` FOREIGN KEY (`codigo_empleado`) REFERENCES `empleado` (`codigo_empleado`),
  ADD CONSTRAINT `FK_encabezadodetallenomina` FOREIGN KEY (`codigo_nomina`) REFERENCES `encabezado_nomina` (`codigo_nomina`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FK_departamentoempleado` FOREIGN KEY (`codigo_departamento`) REFERENCES `departamento` (`codigo_departamento`),
  ADD CONSTRAINT `FK_puestoempleado` FOREIGN KEY (`codigo_puesto`) REFERENCES `puesto` (`codigo_puesto`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK_codigoempleado` FOREIGN KEY (`codigo_empleado`) REFERENCES `empleado` (`codigo_empleado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
