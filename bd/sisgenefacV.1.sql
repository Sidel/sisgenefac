-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 12-03-2017 a las 23:15:59
-- Versión del servidor: 5.5.20
-- Versión de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sisgenefac`
--
CREATE DATABASE `sisgenefac` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sisgenefac`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acceso`
--

CREATE TABLE IF NOT EXISTS `acceso` (
  `acc_id` int(2) NOT NULL AUTO_INCREMENT,
  `rol_id` int(11) DEFAULT NULL,
  `men_id` int(2) DEFAULT NULL,
  `acc_estado` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`acc_id`),
  KEY `fk_reference_1` (`men_id`),
  KEY `fk_reference_2` (`rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acceso_encuesta`
--

CREATE TABLE IF NOT EXISTS `acceso_encuesta` (
  `ace_id` int(11) NOT NULL AUTO_INCREMENT,
  `por_id` int(11) DEFAULT NULL,
  `usu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ace_id`),
  KEY `fk_reference_11` (`por_id`),
  KEY `fk_reference_46` (`usu_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=125 ;

--
-- Volcado de datos para la tabla `acceso_encuesta`
--

INSERT INTO `acceso_encuesta` (`ace_id`, `por_id`, `usu_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 1, 7),
(8, 1, 8),
(9, 1, 9),
(10, 1, 10),
(11, 1, 11),
(12, 1, 12),
(13, 1, 13),
(14, 1, 14),
(15, 1, 15),
(16, 1, 16),
(17, 1, 17),
(18, 1, 18),
(19, 1, 19),
(20, 1, 20),
(21, 1, 21),
(22, 1, 22),
(23, 1, 23),
(24, 1, 24),
(25, 1, 25),
(26, 1, 26),
(27, 1, 27),
(28, 1, 28),
(29, 1, 29),
(30, 1, 30),
(31, 1, 31),
(32, 1, 32),
(33, 1, 33),
(34, 1, 34),
(35, 1, 35),
(36, 1, 36),
(37, 1, 37),
(38, 1, 38),
(39, 1, 39),
(40, 1, 40),
(41, 1, 41),
(42, 1, 42),
(43, 1, 43),
(44, 1, 44),
(45, 1, 45),
(46, 1, 46),
(47, 1, 47),
(48, 1, 48),
(49, 1, 49),
(50, 1, 50),
(51, 1, 51),
(52, 1, 52),
(53, 1, 53),
(54, 1, 54),
(55, 1, 55),
(56, 1, 56),
(57, 1, 57),
(58, 1, 58),
(59, 1, 59),
(60, 1, 60),
(61, 1, 61),
(62, 1, 62),
(63, 1, 63),
(64, 1, 64),
(65, 1, 65),
(66, 1, 66),
(67, 1, 67),
(68, 1, 68),
(69, 1, 69),
(70, 1, 70),
(71, 1, 71),
(72, 1, 72),
(73, 1, 73),
(74, 1, 74),
(75, 1, 75),
(76, 1, 76),
(77, 1, 77),
(78, 1, 78),
(79, 1, 79),
(80, 1, 80),
(81, 1, 81),
(82, 1, 82),
(83, 1, 83),
(84, 1, 84),
(85, 1, 85),
(86, 1, 86),
(87, 1, 87),
(88, 1, 88),
(89, 1, 89),
(90, 1, 90),
(91, 1, 91),
(92, 1, 92),
(93, 1, 93),
(94, 1, 94),
(95, 1, 95),
(96, 1, 96),
(97, 1, 97),
(98, 1, 98),
(99, 1, 99),
(100, 1, 100),
(101, 1, 101),
(102, 1, 102),
(103, 1, 103),
(104, 1, 104),
(105, 1, 105),
(106, 1, 106),
(107, 1, 107),
(108, 1, 108),
(109, 1, 109),
(110, 1, 110),
(111, 1, 111),
(112, 1, 112),
(113, 1, 113),
(114, 1, 114),
(115, 1, 115),
(116, 1, 116),
(117, 1, 117),
(118, 1, 118),
(119, 1, 119),
(120, 1, 120),
(121, 1, 121),
(122, 1, 122),
(123, 1, 123),
(124, 1, 124);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE IF NOT EXISTS `asignatura` (
  `asi_id` int(11) NOT NULL AUTO_INCREMENT,
  `ple_id` int(2) DEFAULT NULL,
  `asi_codigo` varchar(10) NOT NULL,
  `asi_nombre` varchar(500) NOT NULL,
  `asi_ciclo_anio` varchar(4) NOT NULL,
  `asi_creditos` int(1) NOT NULL,
  `cat_regimen` int(5) DEFAULT NULL COMMENT 'S = Semestral A = Anual',
  `asi_estado` char(1) NOT NULL DEFAULT 'A',
  `tip_curso` char(3) DEFAULT NULL,
  PRIMARY KEY (`asi_id`),
  KEY `fk_reference_13` (`ple_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=106 ;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`asi_id`, `ple_id`, `asi_codigo`, `asi_nombre`, `asi_ciclo_anio`, `asi_creditos`, `cat_regimen`, `asi_estado`, `tip_curso`) VALUES
(1, 1, 'MH0410', 'MATEMATICA', '1A-1', 3, 1, 'N', 'O'),
(2, 1, 'MH0411', 'BIOFISICA MEDICA', '1A-1', 4, 1, 'N', 'O'),
(3, 1, 'MH0412', 'QUIMICA INTEGRADA', '1A-1', 5, 1, 'N', 'O'),
(4, 1, 'MH0413', 'BIOLOGIA CELULAR Y MOLECULAR', '1A-1', 5, 1, 'N', 'O'),
(5, 1, 'MH0414', 'CIENCIAS SOCIALES Y REALIDAD NACIONAL', '1A-1', 4, 1, 'N', 'O'),
(6, 1, 'MH0415', 'INTRODUCCION A LA ETICA', '1A-1', 3, 1, 'N', 'O'),
(7, 1, 'MH0416', 'EMBRIOLOGIA Y GENETICA', '1A-2', 4, 1, 'N', 'O'),
(8, 1, 'MH0417', 'ANATOMIA HUMANA', '1A-2', 10, 1, 'N', 'O'),
(9, 1, 'MH0418', 'HISTOLOGIA', '1A-2', 6, 1, 'N', 'O'),
(10, 1, 'MH0419', 'CONOCIMIENTO CIENTIFICO E INVESTIGACION', '1A-2', 3, 1, 'N', 'O'),
(11, 1, 'MH0420', 'BIOQUIMICA', '2A-3', 4, 1, 'N', 'O'),
(12, 1, 'MH0421', 'FISIOLOGIA', '2A-3', 9, 1, 'N', 'O'),
(13, 1, 'MH0422', 'ESTADISTICA MEDICA Y DEMOGRAFIA EN SALUD', '2A-3', 4, 1, 'N', 'O'),
(14, 1, 'MH0423', 'CIENCIAS DE LA CONDUCTA APLICADA A LA MEDICINA', '2A-3', 4, 1, 'N', 'O'),
(15, 1, 'MH0424', 'PATOLOGIA GENERAL', '2A-4', 8, 1, 'N', 'O'),
(16, 1, 'MH0425', 'PARASITOLOGIA MEDICA BASICA', '2A-4', 4, 1, 'N', 'O'),
(17, 1, 'MH0426', 'MICROBIOLOGIA MEDICA BASICA', '2A-4', 5, 1, 'N', 'O'),
(18, 1, 'MH0427', 'PROYECTOS DE INVESTIGACION', '2A-4', 3, 1, 'N', 'O'),
(19, 1, 'MH0430', 'FARMACOLOGIA', '3A-5', 7, 1, 'N', 'O'),
(20, 1, 'MH0431', 'SALUD COMUNITARIA', '3A-5', 4, 1, 'N', 'O'),
(21, 1, 'MH0432', 'SEXUALIDAD', '3A-5', 4, 1, 'N', 'O'),
(22, 1, 'MH0433', 'FISIOPATOLOGIA', '3A-5', 4, 1, 'N', 'O'),
(23, 1, 'MH0E01', 'HISTORIA DE LA MEDICINA', '3A-5', 3, 1, 'A', 'E'),
(24, 1, 'MH0434', 'INTRODUCCION A LA CLINICA', '3A-6', 15, 1, 'N', 'O'),
(25, 1, 'MH0435', 'LABORATORIO CLINICO', '3A-6', 4, 1, 'N', 'O'),
(26, 1, 'MH0436', 'DIAGNOSTICO POR IMAGENES', '3A-6', 3, 1, 'A', 'O'),
(27, 1, 'MH0437', 'BIOETICA', '3A-6', 4, 1, 'A', 'O'),
(28, 1, 'MH0440', 'MEDICINA INTERNA', '4A', 47, 1, 'N', 'O'),
(29, 1, 'MH0441', 'PATOLOGIA ESPECIAL', '4A', 5, 1, 'N', 'O'),
(30, 1, 'MH0450', 'SEMIOLOGIA PSIQUIATRICA Y PSIQUIATRIA', '5A', 8, 1, 'N', 'O'),
(31, 1, 'MH0451', 'CIRUGIA HUMANA', '5A', 0, 1, 'N', 'O'),
(32, 1, 'MH0452', 'EPIDEMIOLOGIA', '5A', 5, 1, 'N', 'O'),
(33, 1, 'MH0460', 'GERENCIA EN SALUD', '6A', 5, 1, 'N', 'O'),
(34, 1, 'MH0461', 'MEDICINA LEGAL', '6A', 0, 1, 'N', 'O'),
(35, 1, 'MH0462', 'GINECOLOGIA', '6A', 6, 1, 'N', 'O'),
(36, 1, 'MH0463', 'OBSTETRICIA', '6A', 8, 1, 'N', 'O'),
(37, 1, 'MH0464', 'PEDIATRIA', '6A', 16, 1, 'N', 'O'),
(38, 1, 'MH0465', 'ATENCION INTEGRAL EN COMUNIDAD', '6A', 5, 1, 'N', 'O'),
(39, 1, 'MH0469', 'INTERNADO', '7A', 52, 1, 'N', 'O'),
(40, 1, 'MH0470', 'INTERNADO EN MEDICINA', '7A', 0, 1, 'N', 'O'),
(41, 1, 'MH0471', 'INTERNADO EN CIRUGIA', '7A', 13, 1, 'N', 'O'),
(42, 1, 'MH0472', 'INTERNADO EN PEDIATRIA', '7A', 13, 1, 'N', 'O'),
(43, 1, 'MH0473', 'INTERNADO EN OBSTETRICIA Y GINECOLOGIA', '7A', 13, 1, 'N', 'O'),
(44, 1, 'MH0E01', 'HISTORIA DE LA MEDICINA', '', 3, 1, 'N', 'E'),
(45, 1, 'MH0E02', 'SEMINARIO DE ELABORACION DE TESIS I', '', 0, 1, 'N', 'E'),
(46, 1, 'MH0E03', 'SEMINARIO DE ELABORACION DE TESIS II', '', 10, 1, 'N', 'E'),
(47, 1, 'MH0E04', 'INGLES I', '', 3, 1, 'N', 'EX'),
(48, 1, 'MH0E05', 'INGLES II', '', 3, 1, 'A', 'EX'),
(49, 1, 'MH0E06', 'EMERGENCIAS Y DESASTRES', '', 2, 1, 'N', 'EX'),
(50, 1, 'MH0E07', 'INFORMATICA APLICADA A LA INVESTIGACION', '', 3, 1, 'N', 'EX'),
(51, 2, 'M15001M', 'QUIMICA INTEGRADA APLICADA A LA MEDICINA', '1', 5, 1, 'N', ''),
(52, 2, 'M15002M', 'BIOFISICA MEDICA', '1', 5, 1, 'N', ''),
(53, 2, 'M15003M', 'BIOLOGIA CELULAR Y MOLECULAR APLICADA A LA MEDICINA', '1', 5, 1, 'N', ''),
(54, 2, 'M15004M', 'METODOLOGIA DEL TRABAJO UNIVERSITARIO Y BUSQUEDA INFORMATIZADA', '1', 4, 1, 'A', ''),
(55, 2, 'M15005M', 'HISTORIA DE LA MEDICINA', '1', 3, 1, 'N', ''),
(56, 2, 'M15006M', 'INGLES MEDICO', '1', 3, 1, 'N', ''),
(57, 2, 'M15007M', 'GENETICA APLICADA A LA MEDICINA', '1', 3, 1, 'A', ''),
(58, 2, 'M15008M', 'ESTADISTICA Y DEMOGRAFIA EN SALUD', '1', 4, 1, 'N', ''),
(59, 2, 'M15009M', 'SOCIOLOGIA, ANTROPOLOGIA APLICADA A LA MEDICINA', '1', 4, 1, 'A', ''),
(60, 2, 'M15010M', 'BIOQUIMICA APLICADA A LA MEDICINA', '1', 6, 1, 'A', ''),
(61, 2, 'M15011M', 'ATENCION DE LA SALUD NIVEL I Y II  (I)', '1', 3, 1, 'A', ''),
(62, 2, 'M15012M', 'NUTRICION Y ESTILOS DE VIDA SALUDABLE', '1', 3, 1, 'N', ''),
(63, 2, 'M15013M', 'CONOCIMIENTO CIENTIFICO E INVESTIGACION', '1', 3, 1, 'N', ''),
(64, 2, 'M15014M', 'ANATOMIA HUMANA I', '2', 5, 1, 'N', ''),
(65, 2, 'M15015M', 'HISTOLOGIA Y EMBRIOLOGIA I', '2', 4, 1, 'N', ''),
(66, 2, 'M15016M', 'FISIOLOGIA HUMANA I', '2', 4, 1, 'N', ''),
(67, 2, 'M15017M', 'PROYECTOS DE INVESTIGACION', '2', 3, 1, 'N', ''),
(68, 2, 'M15018M', 'CIENCIAS DE LA CONDUCTA APLICADA A LA MEDICINA', '2', 4, 1, 'N', ''),
(69, 2, 'M15025M', 'MICROBIOLOGIA MEDICA BASICA', '2', 5, 1, 'N', ''),
(70, 2, 'M15019M', 'ETICA', '2', 5, 1, 'N', ''),
(71, 2, 'M15020M', 'ANATOMIA HUMANA II', '2', 5, 1, 'N', ''),
(72, 2, 'M15021M', 'HISTOLOGIA Y EMBRIOLOGIA II', '2', 3, 1, 'A', ''),
(73, 2, 'M15022M', 'FISIOLOGIA HUMANA II', '2', 5, 1, 'N', ''),
(74, 2, 'M15023M', 'PATOLOGIA GENERAL I', '2', 4, 1, 'N', ''),
(75, 2, 'M15024M', 'PARASITOLOGIA MEDICA BASICA', '2', 4, 1, 'N', ''),
(76, 2, 'M15026M', 'FARMACOLOGIA BASICA APLICADA A LA MEDICINA', '3', 7, 1, 'N', ''),
(77, 2, 'M15027M', 'PROYECTO DE TESIS I', '3', 2, 1, 'N', ''),
(78, 2, 'M15028M', 'FISIOPATOLOGIA', '3', 5, 1, 'N', ''),
(79, 2, 'M15029M', 'PATOLOGIA GENERAL II', '3', 4, 1, 'N', ''),
(80, 2, 'M15030M', 'INMUNOLOGIA GENERAL', '3', 3, 1, 'N', ''),
(81, 2, 'M15031M', 'INTRODUCCION A LA CLINICA', '3', 15, 1, 'N', ''),
(82, 2, 'M15032M', 'PROYECTO DE TESIS II', '3', 2, 1, 'N', ''),
(83, 2, 'M15033M', 'PATOLOGIA ESPECIAL', '3', 5, 1, 'N', ''),
(84, 2, 'M15034M', 'ATENCION DE LA SALUD NIVEL I Y II  (II)', '3', 4, 1, 'N', ''),
(85, 2, 'M15E01', 'INGLES MEDICO II', '3', 3, 1, 'N', ''),
(86, 2, 'M15E02', 'CULTURA ', '3', 3, 1, 'N', ''),
(87, 2, 'M15E03', 'ARTE', '3', 3, 1, 'N', ''),
(88, 2, 'M15E04', 'DEPORTE', '3', 2, 1, 'N', ''),
(89, 2, 'M15E05', 'DANZA', '3', 2, 1, 'N', ''),
(90, 2, 'M15035M', 'MEDICINA INTERNA', '4', 52, 1, 'N', ''),
(91, 2, 'M15036M', 'CIRUGIA', '5', 28, 1, 'N', ''),
(92, 2, 'M15037M', 'SEMIOLOGIA PSIQUIATRICA Y PSIQUIATRIA', '5', 8, 1, 'N', ''),
(93, 2, 'M15038M', 'GINECOLOGIA Y SEXUALIDAD', '5', 8, 1, 'N', ''),
(94, 2, 'M15039M', 'OBSTETRICIA', '5', 8, 1, 'N', ''),
(95, 2, 'M15040M', 'PEDIATRIA', '6', 16, 1, 'N', ''),
(96, 2, 'M15041M', 'MEDICINA LEGAL, VIOLENCIA Y CERTIFICADO DE DEFUNCION', '6', 4, 1, 'N', ''),
(97, 2, 'M15042M', 'GERIATRIA', '6', 3, 1, 'N', ''),
(98, 2, 'M15043M', 'EXTERNADO: COORDINA EL MARCO TEORICO CON LAS ASIGNATURAS DE EMERGENCIA Y DESASTRES, GERENCIA EN SALUD Y EPIDEMIOLOGIA.', '6', 18, 1, 'N', ''),
(99, 2, 'M15044M', 'EMERGENCIAS Y DESASTRES', '6', 3, 1, 'N', ''),
(100, 2, 'M15045M', 'GERENCIA EN SALUD', '6', 3, 1, 'N', ''),
(101, 2, 'M15046M', 'EPIDEMIOLOGIA', '6', 5, 1, 'N', ''),
(102, 2, 'M15047M', 'INTERNADO EN MEDICINA, INCORPORA ROTACION DE PSIQUIATRIA', '7', 13, 1, 'N', ''),
(103, 2, 'M15048M', 'INTERNADO EN CIRUGIA', '7', 13, 1, 'N', ''),
(104, 2, 'M15049M', 'INTERNADO EN PEDIATRIA', '7', 13, 1, 'N', ''),
(105, 2, 'M15050M', 'INTERNADO EN GINECO-OBSTETRICIA', '7', 13, 1, 'N', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cab_matricula`
--

CREATE TABLE IF NOT EXISTS `cab_matricula` (
  `cam_id` int(11) NOT NULL AUTO_INCREMENT,
  `est_id` int(11) DEFAULT NULL,
  `pea_id` int(11) DEFAULT NULL,
  `cat_regimen` int(5) NOT NULL COMMENT 'S = Semestral A = Anual',
  PRIMARY KEY (`cam_id`),
  KEY `fk_reference_16` (`est_id`),
  KEY `fk_reference_44` (`pea_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=125 ;

--
-- Volcado de datos para la tabla `cab_matricula`
--

INSERT INTO `cab_matricula` (`cam_id`, `est_id`, `pea_id`, `cat_regimen`) VALUES
(1, 1, 1, 1),
(2, 2, 1, 1),
(3, 3, 1, 1),
(4, 4, 1, 1),
(5, 5, 1, 1),
(6, 6, 1, 1),
(7, 7, 1, 1),
(8, 8, 1, 1),
(9, 9, 1, 1),
(10, 10, 1, 1),
(11, 11, 1, 1),
(12, 12, 1, 1),
(13, 13, 1, 1),
(14, 14, 1, 1),
(15, 15, 1, 1),
(16, 16, 1, 1),
(17, 17, 1, 1),
(18, 18, 1, 1),
(19, 19, 1, 1),
(20, 20, 1, 1),
(21, 21, 1, 1),
(22, 22, 1, 1),
(23, 23, 1, 1),
(24, 24, 1, 1),
(25, 25, 1, 1),
(26, 26, 1, 1),
(27, 27, 1, 1),
(28, 28, 1, 1),
(29, 29, 1, 1),
(30, 30, 1, 1),
(31, 31, 1, 1),
(32, 32, 1, 1),
(33, 33, 1, 1),
(34, 34, 1, 1),
(35, 35, 1, 1),
(36, 36, 1, 1),
(37, 37, 1, 1),
(38, 38, 1, 1),
(39, 39, 1, 1),
(40, 40, 1, 1),
(41, 41, 1, 1),
(42, 42, 1, 1),
(43, 43, 1, 1),
(44, 44, 1, 1),
(45, 45, 1, 1),
(46, 46, 1, 1),
(47, 47, 1, 1),
(48, 48, 1, 1),
(49, 49, 1, 1),
(50, 50, 1, 1),
(51, 51, 1, 1),
(52, 52, 1, 1),
(53, 53, 1, 1),
(54, 54, 1, 1),
(55, 55, 1, 1),
(56, 56, 1, 1),
(57, 57, 1, 1),
(58, 58, 1, 1),
(59, 59, 1, 1),
(60, 60, 1, 1),
(61, 61, 1, 1),
(62, 62, 1, 1),
(63, 63, 1, 1),
(64, 64, 1, 1),
(65, 65, 1, 1),
(66, 66, 1, 1),
(67, 67, 1, 1),
(68, 68, 1, 1),
(69, 69, 1, 1),
(70, 70, 1, 1),
(71, 71, 1, 1),
(72, 72, 1, 1),
(73, 73, 1, 1),
(74, 74, 1, 1),
(75, 75, 1, 1),
(76, 76, 1, 1),
(77, 77, 1, 1),
(78, 78, 1, 1),
(79, 79, 1, 1),
(80, 80, 1, 1),
(81, 81, 1, 1),
(82, 82, 1, 1),
(83, 83, 1, 1),
(84, 84, 1, 1),
(85, 85, 1, 1),
(86, 86, 1, 1),
(87, 87, 1, 1),
(88, 88, 1, 1),
(89, 89, 1, 1),
(90, 90, 1, 1),
(91, 91, 1, 1),
(92, 92, 1, 1),
(93, 93, 1, 1),
(94, 94, 1, 1),
(95, 95, 1, 1),
(96, 96, 1, 1),
(97, 97, 1, 1),
(98, 98, 1, 1),
(99, 99, 1, 1),
(100, 100, 1, 1),
(101, 101, 1, 1),
(102, 102, 1, 1),
(103, 103, 1, 1),
(104, 104, 1, 1),
(105, 105, 1, 1),
(106, 106, 1, 1),
(107, 107, 1, 1),
(108, 108, 1, 1),
(109, 109, 1, 1),
(110, 110, 1, 1),
(111, 111, 1, 1),
(112, 112, 1, 1),
(113, 113, 1, 1),
(114, 114, 1, 1),
(115, 115, 1, 1),
(116, 116, 1, 1),
(117, 117, 1, 1),
(118, 118, 1, 1),
(119, 119, 1, 1),
(120, 120, 1, 1),
(121, 121, 1, 1),
(122, 122, 1, 1),
(123, 123, 1, 1),
(124, 124, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cab_rpta`
--

CREATE TABLE IF NOT EXISTS `cab_rpta` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `est_id` int(11) DEFAULT NULL,
  `car_fecha` datetime NOT NULL,
  `car_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`car_id`),
  KEY `fk_reference_10` (`est_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `catalogo`
--

CREATE TABLE IF NOT EXISTS `catalogo` (
  `cat_id` int(8) NOT NULL AUTO_INCREMENT,
  `cat_grupo` int(8) NOT NULL,
  `cat_sub_grupo` int(5) DEFAULT NULL,
  `cat_nombre` varchar(50) NOT NULL,
  `cat_descripcion` varchar(200) NOT NULL,
  `cat_codigo` char(2) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Volcado de datos para la tabla `catalogo`
--

INSERT INTO `catalogo` (`cat_id`, `cat_grupo`, `cat_sub_grupo`, `cat_nombre`, `cat_descripcion`, `cat_codigo`) VALUES
(1, 0, 1, 'FACULTAD_ESCUELA_ACADEMICA', '', ''),
(2, 1, 1, 'MEDICINA', '', ''),
(3, 0, 2, 'REGIMEN_DET_MATRICULA', 'REGIMEN PARA UN PERIODO ACADEMICO', ''),
(4, 2, 1, 'VERANO', '', 'VE'),
(5, 2, 2, 'SEMESTRAL', '', 'SE'),
(6, 2, 3, 'ANUAL', '', 'AN'),
(7, 0, 3, 'CATEGORIA_PRO_SED_DEP', '', ''),
(8, 3, 1, 'ASOCIADO', '', 'AS'),
(9, 3, 2, 'AUXILIAR', '', 'AU'),
(10, 3, 3, 'JEFE DE PRACTICA', '', 'JP'),
(11, 3, 4, 'PRINCIPAL', '', 'PR'),
(12, 0, 4, 'REGIMEN_PRO_SED_DEP', '', ''),
(13, 4, 1, 'D.E.', 'DEDICACION EXCLUSIVA', ''),
(14, 4, 2, 'T.C.', 'TIEMPO COMPLETO', ''),
(15, 4, 3, 'T.P.', 'TIEMPO PARCIAL', ''),
(16, 0, 5, 'TIPO_DOCENTE_PRO_SED_DEP', '', NULL),
(17, 5, 1, 'RESPONSABLE', '', NULL),
(18, 5, 2, 'COLABORADOR', '', NULL),
(19, 0, 6, 'REGIMEN_ASIGNATURA', '', NULL),
(20, 6, 1, 'SEMESTRAL', '', NULL),
(21, 6, 2, 'ANUAL', '', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

CREATE TABLE IF NOT EXISTS `configuracion` (
  `con_id` int(1) NOT NULL AUTO_INCREMENT,
  `con_facultad` varchar(300) NOT NULL,
  `con_escuela` varchar(300) DEFAULT NULL,
  `con_ruta_logo` varchar(300) DEFAULT NULL,
  `con_user_admin` varchar(50) NOT NULL,
  `con_clave_admin` varchar(44) NOT NULL,
  PRIMARY KEY (`con_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuestionario`
--

CREATE TABLE IF NOT EXISTS `cuestionario` (
  `cue_id` int(11) NOT NULL AUTO_INCREMENT,
  `pre_id` int(11) DEFAULT NULL,
  `pos_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cue_id`),
  KEY `fk_reference_58` (`pos_id`),
  KEY `fk_reference_8` (`pre_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `cuestionario`
--

INSERT INTO `cuestionario` (`cue_id`, `pre_id`, `pos_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 2),
(6, 6, 2),
(7, 7, 2),
(8, 8, 2),
(9, 9, 3),
(10, 10, 3),
(11, 11, 3),
(12, 12, 3),
(13, 13, 4),
(14, 14, 4),
(15, 15, 4),
(16, 16, 4),
(17, 17, 5),
(18, 18, 5),
(19, 19, 5),
(20, 20, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `denominacion`
--

CREATE TABLE IF NOT EXISTS `denominacion` (
  `den_id` int(3) NOT NULL AUTO_INCREMENT,
  `por_id` int(11) DEFAULT NULL,
  `den_desde` double(4,2) NOT NULL,
  `den_hasta` double(4,2) NOT NULL,
  `den_nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`den_id`),
  KEY `fk_reference_53` (`por_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `denominacion`
--

INSERT INTO `denominacion` (`den_id`, `por_id`, `den_desde`, `den_hasta`, `den_nombre`) VALUES
(1, 1, 0.00, 3.99, 'DEFICIENTE'),
(2, 1, 4.00, 5.99, 'REGULAR'),
(3, 1, 6.00, 7.99, 'BUENO'),
(4, 1, 8.00, 8.99, 'MUY BUENO'),
(5, 1, 9.00, 10.00, 'EXCELENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento_academico`
--

CREATE TABLE IF NOT EXISTS `departamento_academico` (
  `dea_id` int(2) NOT NULL AUTO_INCREMENT,
  `dea_nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`dea_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `departamento_academico`
--

INSERT INTO `departamento_academico` (`dea_id`, `dea_nombre`) VALUES
(1, 'CIRUGIA'),
(2, 'CS. DINAMICAS'),
(3, 'CS. MORFOLOGICAS'),
(4, 'ENFERMERIA'),
(5, 'MED. PREVENTIVA'),
(6, 'MEDICINA HUM.'),
(7, 'MICROBIOL. MED.'),
(8, 'NUTRICION'),
(9, 'OBSTETRICIA '),
(10, 'OBSTETRICIA'),
(11, 'OBSTETRICIA y GINECO'),
(12, 'PATOLOGIA'),
(13, 'PEDIATRIA'),
(14, 'PSIQUIATRIA'),
(15, 'TECNOLOGIA MED.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `det_matricula`
--

CREATE TABLE IF NOT EXISTS `det_matricula` (
  `dem_id` int(11) NOT NULL AUTO_INCREMENT,
  `cam_id` int(11) NOT NULL,
  `gru_id` int(11) DEFAULT NULL,
  `dem_rep_plan_actual` int(1) DEFAULT NULL,
  PRIMARY KEY (`dem_id`),
  KEY `fk_reference_17` (`cam_id`),
  KEY `fk_reference_37` (`gru_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=149 ;

--
-- Volcado de datos para la tabla `det_matricula`
--

INSERT INTO `det_matricula` (`dem_id`, `cam_id`, `gru_id`, `dem_rep_plan_actual`) VALUES
(1, 1, 3, NULL),
(2, 2, 1, NULL),
(3, 2, 5, NULL),
(4, 123, 3, NULL),
(5, 124, 2, NULL),
(6, 2, 1, NULL),
(7, 2, 5, NULL),
(8, 2, 10, NULL),
(9, 5, 9, NULL),
(10, 6, 3, NULL),
(11, 7, 1, NULL),
(12, 7, 5, NULL),
(13, 8, 8, NULL),
(14, 9, 5, NULL),
(15, 10, 1, NULL),
(16, 10, 5, NULL),
(17, 11, 1, NULL),
(18, 11, 5, NULL),
(19, 12, 8, NULL),
(20, 13, 10, NULL),
(21, 14, 1, NULL),
(22, 14, 5, NULL),
(23, 14, 6, NULL),
(24, 15, 1, NULL),
(25, 15, 5, NULL),
(26, 16, 5, NULL),
(27, 17, 5, NULL),
(28, 18, 5, NULL),
(29, 19, 7, NULL),
(30, 20, 5, NULL),
(31, 20, 6, NULL),
(32, 21, 5, NULL),
(33, 22, 9, NULL),
(34, 23, 1, NULL),
(35, 24, 1, NULL),
(36, 24, 5, NULL),
(37, 25, 8, NULL),
(38, 26, 5, NULL),
(39, 27, 1, NULL),
(40, 27, 5, NULL),
(41, 27, 6, NULL),
(42, 28, 10, NULL),
(43, 29, 1, NULL),
(44, 29, 5, NULL),
(45, 30, 10, NULL),
(46, 31, 1, NULL),
(47, 31, 5, NULL),
(48, 32, 10, NULL),
(49, 33, 1, NULL),
(50, 33, 6, NULL),
(51, 34, 4, NULL),
(52, 35, 10, NULL),
(53, 36, 10, NULL),
(54, 37, 10, NULL),
(55, 38, 10, NULL),
(56, 39, 1, NULL),
(57, 39, 5, NULL),
(58, 40, 10, NULL),
(59, 41, 7, NULL),
(60, 42, 10, NULL),
(61, 43, 4, NULL),
(62, 44, 10, NULL),
(63, 45, 10, NULL),
(64, 46, 10, NULL),
(65, 47, 10, NULL),
(66, 48, 8, NULL),
(67, 49, 10, NULL),
(68, 50, 1, NULL),
(69, 51, 4, NULL),
(70, 52, 10, NULL),
(71, 53, 7, NULL),
(72, 54, 4, NULL),
(73, 55, 4, NULL),
(74, 56, 4, NULL),
(75, 57, 4, NULL),
(76, 58, 4, NULL),
(77, 59, 4, NULL),
(78, 60, 4, NULL),
(79, 61, 4, NULL),
(80, 62, 4, NULL),
(81, 63, 4, NULL),
(82, 64, 4, NULL),
(83, 65, 1, NULL),
(84, 65, 4, NULL),
(85, 66, 4, NULL),
(86, 67, 4, NULL),
(87, 68, 4, NULL),
(88, 69, 4, NULL),
(89, 70, 4, NULL),
(90, 71, 4, NULL),
(91, 72, 1, NULL),
(92, 73, 4, NULL),
(93, 74, 2, NULL),
(94, 75, 4, NULL),
(95, 76, 4, NULL),
(96, 77, 4, NULL),
(97, 78, 2, NULL),
(98, 78, 3, NULL),
(99, 79, 3, NULL),
(100, 80, 3, NULL),
(101, 81, 2, NULL),
(102, 82, 3, NULL),
(103, 83, 3, NULL),
(104, 84, 3, NULL),
(105, 85, 3, NULL),
(106, 86, 3, NULL),
(107, 87, 3, NULL),
(108, 88, 3, NULL),
(109, 89, 3, NULL),
(110, 90, 3, NULL),
(111, 91, 3, NULL),
(112, 92, 3, NULL),
(113, 93, 3, NULL),
(114, 94, 3, NULL),
(115, 95, 3, NULL),
(116, 96, 3, NULL),
(117, 97, 3, NULL),
(118, 98, 3, NULL),
(119, 99, 2, NULL),
(120, 99, 3, NULL),
(121, 100, 3, NULL),
(122, 101, 3, NULL),
(123, 102, 3, NULL),
(124, 103, 3, NULL),
(125, 104, 2, NULL),
(126, 104, 3, NULL),
(127, 105, 3, NULL),
(128, 106, 2, NULL),
(129, 106, 3, NULL),
(130, 107, 3, NULL),
(131, 108, 3, NULL),
(132, 109, 3, NULL),
(133, 110, 3, NULL),
(134, 111, 3, NULL),
(135, 112, 2, NULL),
(136, 112, 3, NULL),
(137, 113, 3, NULL),
(138, 114, 3, NULL),
(139, 115, 3, NULL),
(140, 116, 3, NULL),
(141, 117, 3, NULL),
(142, 118, 3, NULL),
(143, 119, 2, NULL),
(144, 119, 3, NULL),
(145, 120, 3, NULL),
(146, 121, 3, NULL),
(147, 122, 6, NULL),
(148, 123, 2, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `det_rpta`
--

CREATE TABLE IF NOT EXISTS `det_rpta` (
  `der_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` int(11) DEFAULT NULL,
  `dic_id` int(11) DEFAULT NULL,
  `cue_id` int(11) DEFAULT NULL,
  `der_valor_rpta` varchar(2) NOT NULL COMMENT 'Es el valor de respuesta (Sí o No) para una determinada pregunta de una Encuesta (es el mayor detalle de una Encuesta).',
  `der_acumulado_si` int(2) NOT NULL COMMENT 'Es el n° acumulado de preguntas respondidas afirmativamente (con Si). Cada registro para un mismo alumno y sobre un mismo profesor_curso_modalidad se autoincrementa (suma valores Si de anteriores det_rpta)',
  `der_acumulado_valor` double(3,2) DEFAULT NULL,
  PRIMARY KEY (`der_id`),
  KEY `fk_reference_48` (`car_id`),
  KEY `fk_reference_49` (`cue_id`),
  KEY `fk_reference_54` (`dic_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dictado`
--

CREATE TABLE IF NOT EXISTS `dictado` (
  `dic_id` int(11) NOT NULL AUTO_INCREMENT,
  `prosede_id` int(11) NOT NULL,
  `gru_id` int(11) NOT NULL,
  `moc_id` int(1) DEFAULT NULL,
  `see_id` int(11) DEFAULT NULL,
  `dic_fecha_realizada` datetime DEFAULT NULL,
  `cat_tipo_docente` int(5) NOT NULL,
  PRIMARY KEY (`dic_id`),
  KEY `fk_reference_28` (`prosede_id`),
  KEY `fk_reference_38` (`gru_id`),
  KEY `fk_reference_47` (`moc_id`),
  KEY `fk_reference_52` (`see_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `dictado`
--

INSERT INTO `dictado` (`dic_id`, `prosede_id`, `gru_id`, `moc_id`, `see_id`, `dic_fecha_realizada`, `cat_tipo_docente`) VALUES
(1, 3, 3, 1, 3, NULL, 1),
(2, 7, 1, 1, 1, NULL, 1),
(3, 2, 5, 1, 5, NULL, 1),
(4, 8, 2, 1, 2, NULL, 1),
(5, 9, 10, 1, 10, NULL, 1),
(6, 6, 9, 1, 9, NULL, 1),
(7, 1, 8, 1, 8, NULL, 1),
(8, 5, 6, 1, 6, NULL, 1),
(9, 4, 7, 1, 7, NULL, 1),
(10, 3, 4, 1, 4, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escala_likert`
--

CREATE TABLE IF NOT EXISTS `escala_likert` (
  `esl_id` int(5) NOT NULL AUTO_INCREMENT,
  `pos_id` int(11) DEFAULT NULL,
  `esl_cant_preg_si` int(2) NOT NULL,
  `esl_valor` double(3,2) NOT NULL,
  PRIMARY KEY (`esl_id`),
  KEY `fk_reference_42` (`pos_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `escala_likert`
--

INSERT INTO `escala_likert` (`esl_id`, `pos_id`, `esl_cant_preg_si`, `esl_valor`) VALUES
(1, 1, 1, 0.50),
(2, 1, 2, 1.00),
(3, 1, 3, 2.00),
(4, 1, 4, 3.00),
(5, 2, 1, 0.25),
(6, 2, 2, 0.50),
(7, 2, 3, 0.75),
(8, 2, 4, 1.00),
(9, 3, 1, 0.50),
(10, 3, 2, 0.50),
(11, 3, 3, 1.00),
(12, 3, 4, 2.50),
(13, 4, 1, 0.50),
(14, 4, 2, 1.00),
(15, 4, 3, 2.00),
(16, 4, 4, 2.50),
(17, 5, 1, 0.25),
(18, 5, 2, 0.50),
(19, 5, 3, 0.75),
(20, 5, 4, 1.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escuela_academica`
--

CREATE TABLE IF NOT EXISTS `escuela_academica` (
  `esa_id` int(2) NOT NULL AUTO_INCREMENT,
  `esa_escuela` varchar(200) NOT NULL,
  `cat_facultad` int(5) NOT NULL,
  PRIMARY KEY (`esa_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `escuela_academica`
--

INSERT INTO `escuela_academica` (`esa_id`, `esa_escuela`, `cat_facultad`) VALUES
(1, 'MEDICINA HUMANA', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE IF NOT EXISTS `estudiante` (
  `est_id` int(11) NOT NULL AUTO_INCREMENT,
  `esa_id` int(2) DEFAULT NULL,
  `est_nombres` varchar(50) NOT NULL,
  `est_appaterno` varchar(50) NOT NULL,
  `est_apmaterno` varchar(50) NOT NULL,
  `est_codigo_matricula` varchar(8) NOT NULL,
  `est_correo` varchar(100) DEFAULT NULL,
  `est_genero` char(1) DEFAULT NULL,
  `est_anio_ingreso` int(4) NOT NULL COMMENT 'Ej: 2004',
  `est_cod_plan` int(4) NOT NULL COMMENT 'Ej: 2015',
  `est_estado` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`est_id`),
  KEY `fk_reference_31` (`esa_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=125 ;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`est_id`, `esa_id`, `est_nombres`, `est_appaterno`, `est_apmaterno`, `est_codigo_matricula`, `est_correo`, `est_genero`, `est_anio_ingreso`, `est_cod_plan`, `est_estado`) VALUES
(1, 1, 'TRINIDAD', 'ESPIRITU', 'ESPINOZA', '701884', '701884@unmsm.edu.pe', 'F', 1970, 2015, 'A'),
(2, 1, 'JORGE ARTURO', 'MORALES', 'ORDINOLA', '880283', '880283@unmsm.edu.pe', 'M', 1988, 2015, 'A'),
(3, 1, 'LUIS ALBERTO', 'ALAYA', 'ROMERO', '05010188', '05010188@unmsm.edu.pe', 'M', 2005, 2015, 'A'),
(4, 1, 'RUBÉN MOISES', 'IZQUIERDO', 'CALIXTO', '08010224', '08010224@unmsm.edu.pe', 'M', 2008, 2004, 'A'),
(5, 1, 'CESAR ALBERTO', 'VERASTEGUI', 'ZAPATA', '10010234', '10010234@unmsm.edu.pe', 'M', 2010, 2004, 'A'),
(6, 1, 'CÉSAR AUGUSTO', 'REYES', 'SAAVEDRA', '11010074', '11010074@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(7, 1, 'ANDREE MARTIN', 'PARRA', 'MELGAREJO', '11010592', '11010592@unmsm.edu.pe', 'M', 2011, 2015, 'A'),
(8, 1, 'LUCELY ALISSON', 'CUBA', 'OLIVARES', '12010006', '12010006@unmsm.edu.pe', 'F', 2012, 2004, 'A'),
(9, 1, 'JOSEPH FELICIANO', 'JAVIER', 'SOTO', '12010013', '12010013@unmsm.edu.pe', 'M', 2012, 2015, 'A'),
(10, 1, 'JESÚS MIGUEL', 'CAYO', 'CARBAJAL', '12010212', '12010212@unmsm.edu.pe', 'M', 2012, 2015, 'A'),
(11, 1, 'MARCO DAVID', 'MEZA', 'SERPA', '12010234', '12010234@unmsm.edu.pe', 'M', 2012, 2015, 'A'),
(12, 1, 'JOSELIN VANESSA', 'OLORTEGUI', 'LEYVA', '12010235', '12010235@unmsm.edu.pe', 'F', 2012, 2004, 'A'),
(13, 1, 'YLSE JOANNA', 'OROPEZA', 'JIMENEZ', '12010238', '12010238@unmsm.edu.pe', 'F', 2012, 2004, 'A'),
(14, 1, 'DAVID JORDAN', 'PARRA', 'QUISPE', '12010240', '12010240@unmsm.edu.pe', 'M', 2012, 2015, 'A'),
(15, 1, 'RUBEN DARIO', 'PINEDO', 'NINA', '12010242', '12010242@unmsm.edu.pe', 'M', 2012, 2015, 'A'),
(16, 1, 'PIERRE ERICK', 'RODRIGUEZ', 'ALVARADO', '12010250', '12010250@unmsm.edu.pe', 'M', 2012, 2015, 'A'),
(17, 1, 'AARON YOAN', 'GARCIA', 'SOTO', '12010266', '12010266@unmsm.edu.pe', 'M', 2012, 2015, 'A'),
(18, 1, 'HENRY ANDRETTI', 'LEIVA', 'VILLENA', '12010303', '12010303@unmsm.edu.pe', 'M', 2012, 2015, 'A'),
(19, 1, 'CHRISTIAN EDUARDO', 'ALLCCAHUAMAN', 'ARONES', '13010002', '13010002@unmsm.edu.pe', 'M', 2013, 2004, 'A'),
(20, 1, 'JOSE CARLOS', 'CHICASACA', 'MAMANI', '13010014', '13010014@unmsm.edu.pe', 'M', 2013, 2015, 'A'),
(21, 1, 'CHRISTOPHER FRANK', 'DELGADO', 'VERA', '13010021', '13010021@unmsm.edu.pe', 'M', 2013, 2015, 'A'),
(22, 1, 'MICHAEL', 'GONZALES', 'PALOMINO', '13010025', '13010025@unmsm.edu.pe', 'M', 2013, 2004, 'A'),
(23, 1, 'JHERY', 'LIMAYMANTA', 'GONZALES', '13010030', '13010030@unmsm.edu.pe', 'F', 2013, 2015, 'A'),
(24, 1, 'ALEXANDER', 'SALINAS', 'CORNELIO', '13010050', '13010050@unmsm.edu.pe', 'M', 2013, 2015, 'A'),
(25, 1, 'HENRY ORLANDO', 'VEGA', 'MORAN', '13010057', '13010057@unmsm.edu.pe', 'M', 2013, 2004, 'A'),
(26, 1, 'WALTER FRANZPHIERRE', 'YANCE', 'VELARDE', '13010059', '13010059@unmsm.edu.pe', 'M', 2013, 2015, 'A'),
(27, 1, 'MARCELO JOSUÉ', 'JULIÁN', 'GRANADOS', '13010208', '13010208@unmsm.edu.pe', 'M', 2013, 2015, 'A'),
(28, 1, 'JUNIOR JULIO', 'CHOQUE', 'GÓMEZ', '13010219', '13010219@unmsm.edu.pe', 'M', 2013, 2004, 'A'),
(29, 1, 'JESUS RAÚL', 'CHIRINOS', 'QUISPE', '13010225', '13010225@unmsm.edu.pe', 'M', 2013, 2015, 'A'),
(30, 1, 'OMAR OSWALDO', 'CANALES', 'HUAPAYA', '13010228', '13010228@unmsm.edu.pe', 'M', 2013, 2004, 'A'),
(31, 1, 'CARLOS ARTURO', 'CHALLCO', 'DÁVILA', '13010372', '13010372@unmsm.edu.pe', 'M', 2013, 2015, 'A'),
(32, 1, 'WALTER JAVIER', 'DAMIAN', 'CRUZ', '13010375', '13010375@unmsm.edu.pe', 'M', 2013, 2004, 'A'),
(33, 1, 'LOURDES BETSI', 'LARA', 'VARGAS', '13010380', '13010380@unmsm.edu.pe', 'F', 2013, 2015, 'A'),
(34, 1, 'BRIGIDA MARISOL', 'TITO', 'GUTIERREZ', '13010412', '13010412@unmsm.edu.pe', 'F', 2013, 2015, 'A'),
(35, 1, 'JANETH TANIA', 'VALERIO', 'ROJAS', '13010415', '13010415@unmsm.edu.pe', 'F', 2013, 2004, 'A'),
(36, 1, 'ANDRÉS ALFREDO', 'PAUCAR', 'ROJAS', '13010428', '13010428@unmsm.edu.pe', 'M', 2013, 2004, 'A'),
(37, 1, 'CARMEN DEL PILAR', 'COCHACHI', 'GAMARRA', '14010010', '14010010@unmsm.edu.pe', 'F', 2014, 2004, 'A'),
(38, 1, 'GARY STEVES', 'GARRO', 'GARRO', '14010014', '14010014@unmsm.edu.pe', 'M', 2014, 2004, 'A'),
(39, 1, 'ARNOLD ERIBERTO', 'GUERRERO', 'CASARIEGO', '14010015', '14010015@unmsm.edu.pe', 'M', 2014, 2015, 'A'),
(40, 1, 'ELIZABETH ALEXANDRA', 'ORTEGA', 'ESPINOZA', '14010029', '14010029@unmsm.edu.pe', 'F', 2014, 2004, 'A'),
(41, 1, 'JOSÉ MANUEL', 'RAMOS', 'VELASQUEZ', '14010034', '14010034@unmsm.edu.pe', 'M', 2014, 2004, 'A'),
(42, 1, 'PEDRO OLINDO FERNANDO', 'SALINAS', 'TICONA', '14010036', '14010036@unmsm.edu.pe', 'M', 2014, 2004, 'A'),
(43, 1, 'NOEMI', 'DE LA CRUZ', 'GUTIERREZ', '14010184', '14010184@unmsm.edu.pe', 'F', 2014, 2015, 'A'),
(44, 1, 'CRISOLOGO', 'GUTIERREZ', 'JARA', '14010192', '14010192@unmsm.edu.pe', 'M', 2014, 2004, 'A'),
(45, 1, 'MÁRGARETH MARISÚ', 'SOTO', 'BECERRA', '14010211', '14010211@unmsm.edu.pe', 'F', 2014, 2004, 'A'),
(46, 1, 'LUISA BELEN', 'TORRES', 'LASTARR?A', '14010213', '14010213@unmsm.edu.pe', 'F', 2014, 2004, 'A'),
(47, 1, 'DEAN WESLY', 'CUEVA', 'CHÁVARRY', '14010223', '14010223@unmsm.edu.pe', 'M', 2014, 2004, 'A'),
(48, 1, 'EDGAR FERNANDO', 'HUANCAS', 'SÁNCHEZ', '14010232', '14010232@unmsm.edu.pe', 'M', 2014, 2004, 'A'),
(49, 1, 'LUIS MIGUEL', 'ROJAS', 'GALARZA', '14010244', '14010244@unmsm.edu.pe', 'M', 2014, 2004, 'A'),
(50, 1, 'MILAGROS VALERIA', 'TENA', 'VALLADOLID', '14010251', '14010251@unmsm.edu.pe', 'F', 2014, 2015, 'A'),
(51, 1, 'FERNANDO JOAN', 'CAMPOS', 'VIVANCO', '14010270', '14010270@unmsm.edu.pe', 'M', 2014, 2015, 'A'),
(52, 1, 'LINCOL', 'AZCUE', 'PUMA', '14010272', '14010272@unmsm.edu.pe', 'M', 2014, 2004, 'A'),
(53, 1, 'EVELYN SELHENE', 'JUAN DE DIOS', 'BLANCAS', '14010273', '14010273@unmsm.edu.pe', 'F', 2014, 2004, 'A'),
(54, 1, 'SMITH RONNEY', 'CANTO', 'RONDÓN', '15010011', '15010011@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(55, 1, 'JOEL ALEXANDER', 'CORONADO', 'QUISPE', '15010017', '15010017@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(56, 1, 'NICOLE MELANIE', 'CRESPO', 'RAYA', '15010019', '15010019@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(57, 1, 'LIZETH PAMELA', 'HUAYTALLA', 'NICOLÁS', '15010027', '15010027@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(58, 1, 'ERITA MARGARETH', 'LIMO', 'GARCIA', '15010030', '15010030@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(59, 1, 'MILAGROS MICHELLE', 'SOLÍS', 'RODRÍGUEZ', '15010048', '15010048@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(60, 1, 'GISELA EVELIN', 'VIDAL', 'QUISPE', '15010053', '15010053@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(61, 1, 'NICOLE INGRID', 'VILLAGARAY', 'PACHECO', '15010054', '15010054@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(62, 1, 'MANUEL JESÚS', 'AGUILAR', 'PALOMINO', '15010056', '15010056@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(63, 1, 'RENZO FERNANDO', 'ALARCON', 'ALCÁNTARA', '15010057', '15010057@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(64, 1, 'ERIK JAVIER', 'ASTONITAS', 'BELLO', '15010227', '15010227@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(65, 1, 'EVER ANTHONY', 'AYMITUMA', 'ACOSTA', '15010228', '15010228@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(66, 1, 'YAJAYRA LUZ', 'BASILIO', 'FLORES', '15010230', '15010230@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(67, 1, 'FRANK CARLO', 'GARCIA', 'ROJAS', '15010238', '15010238@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(68, 1, 'YULY JANETH', 'GUPIOC', 'ESPINOZA', '15010240', '15010240@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(69, 1, 'JUAN PABLO GIORDANO', 'MÉNDEZ', 'DÍAZ', '15010248', '15010248@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(70, 1, 'JUDSON JEANPIERRH', 'MERCADO', 'TAIPE', '15010250', '15010250@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(71, 1, 'JAVIER EDUARDO', 'SOLIS', 'SARMIENTO', '15010267', '15010267@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(72, 1, 'MARCO ARNOLD', 'VIDAL', 'CHAVEZ', '15010269', '15010269@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(73, 1, 'ANA ISABEL', 'VILCAHUAMÁN', 'JAVIER', '15010270', '15010270@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(74, 1, 'GRECIA PATRICIA', 'ARROYO', 'LARA', '15010272', '15010272@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(75, 1, 'BRANDO', 'CHUNGA', 'LARREATEGUI', '15010276', '15010276@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(76, 1, 'ALESSANDRA FIORELLA', 'OGOSI', 'MIGUEL', '15010283', '15010283@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(77, 1, 'CARLOS GIANFRANCO', 'SEGURA', 'LLACTAHUAMANI', '15010291', '15010291@unmsm.edu.pe', 'M', 2015, 2015, 'A'),
(78, 1, 'KARINA', 'SULCA', 'SERRANO', '15010307', '15010307@unmsm.edu.pe', 'F', 2015, 2015, 'A'),
(79, 1, 'JUAN CARLOS', 'AQUISE', 'LARICO', '16010036', '16010036@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(80, 1, 'JORDANO JESÚS', 'CASTRO', 'LEYVA', '16010041', '16010041@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(81, 1, 'MELISSA', 'ESQUIVEL', 'CHUMPITAZ', '16010045', '16010045@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(82, 1, 'ARES DARIAM', 'GAMARRA', 'SALAS', '16010048', '16010048@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(83, 1, 'ZULEMA ANGÉLICA', 'HUARI', 'GUERRA', '16010051', '16010051@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(84, 1, 'NANCY', 'MAC LEAN', 'BALBOA', '16010056', '16010056@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(85, 1, 'LUIS MIGUEL', 'MELGAREJO', 'JAVIER', '16010057', '16010057@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(86, 1, 'CESAR ALBERTO', 'PUJADA', 'ESPINOZA', '16010060', '16010060@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(87, 1, 'DIEGO ROGELIO', 'PURE', 'NAUPAY', '16010061', '16010061@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(88, 1, 'FRANSHINET LIBERLY', 'QUEZADA', 'CALDERÓN', '16010062', '16010062@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(89, 1, 'LUIS ANGEL', 'QUIÑONES', 'SAAVEDRA', '16010063', '16010063@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(90, 1, 'SHEYLA MARGARET', 'SUAREZ', 'FLORES', '16010071', '16010071@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(91, 1, 'LYZ FIORELLA', 'CCOYLLO', 'QUISPE', '16010080', '16010080@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(92, 1, 'GISSELA PAOLA', 'PORRAS', 'VALDIVIA', '16010086', '16010086@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(93, 1, 'LUIS FABIO', 'GONZALES', 'MORALES', '16010208', '16010208@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(94, 1, 'YATSEN', 'ALVARADO', 'HUARANCCA', '16010213', '16010213@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(95, 1, 'SANDRA ELIZABETH', 'ARROYO', 'RODAS', '16010216', '16010216@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(96, 1, 'ERWIN JUNIOR', 'CASTILLO', 'CASAVERDE', '16010220', '16010220@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(97, 1, 'JAIR BRYAN', 'CRISTOBAL', 'TERRAZO', '16010225', '16010225@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(98, 1, 'PERCY ANTONIO', 'DOMINGUEZ', 'CELADITA', '16010228', '16010228@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(99, 1, 'JULISSA EMPERATRIZ', 'EGUSQUIZA', 'LLANA', '16010230', '16010230@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(100, 1, 'JULIO CESAR', 'FIGUEROA', 'PALOMINO', '16010231', '16010231@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(101, 1, 'RICHARD WILLIAM', 'FLORES', 'AGURTO', '16010232', '16010232@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(102, 1, 'LUIS BENJI', 'MACHACA', 'BAEZ', '16010237', '16010237@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(103, 1, 'DIANA FIORELLA', 'MALDONADO', 'VILLACORTA', '16010238', '16010238@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(104, 1, 'HELEN', 'MATAMOROS', 'QUISPE', '16010239', '16010239@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(105, 1, 'JUAN CARLOS', 'MEGO', 'MENDOZA', '16010240', '16010240@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(106, 1, 'DAISY JENNIFER', 'PAULINO', 'ARIAS', '16010244', '16010244@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(107, 1, 'LUIS MARTIN', 'SALAS', 'GUZMAN', '16010252', '16010252@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(108, 1, 'JAVIER ABRAHAM', 'SALAZAR', 'BELLIDO', '16010253', '16010253@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(109, 1, 'SHARON SCARLET', 'SARMIENTO', 'DIAZ', '16010254', '16010254@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(110, 1, 'ROCÍO DE FÁTIMA', 'TORRES', 'UZURRIAGA', '16010258', '16010258@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(111, 1, 'SALVATORE FRANCO', 'VARGAS', 'TACUCHE', '16010259', '16010259@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(112, 1, 'GABRIELA JESUS', 'BAILON', 'DOMINGUEZ', '16010263', '16010263@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(113, 1, 'RONALD VICENTE', 'CONCHA', 'TAMO', '16010269', '16010269@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(114, 1, 'HILLARY PATRICIA', 'ELGUERA', 'HUAMAN', '16010270', '16010270@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(115, 1, 'JOSIMAR JUNIOR', 'PÉREZ', 'ARANGOITIA', '16010278', '16010278@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(116, 1, 'FRANCIS JACKELINE', 'QUISPE', 'VARGAS', '16010279', '16010279@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(117, 1, 'ELIÁNI ELIZABETH', 'ROBLES', 'TARAZONA', '16010280', '16010280@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(118, 1, 'DANIEL ALEXIS', 'SALAZAR', 'LÁZARO', '16010281', '16010281@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(119, 1, 'MANUEL JUNIOR IVAN', 'DIAZ', 'SALVATIERRA', '16010286', '16010286@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(120, 1, 'MILAGROS VIVIAN', 'FERNANDEZ', 'GAITAN', '16010287', '16010287@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(121, 1, 'JUAN DIEGO ALEXANDER', 'LEGUIA', 'DAVILA', '16010288', '16010288@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(122, 1, 'VALERIA', 'ZUMARAN', 'FLORES', '16010289', '16010289@unmsm.edu.pe', 'F', 2016, 2015, 'A'),
(123, 1, 'KEVIN JESÚS', 'CISNEROS', 'ROJAS', '16010296', '16010296@unmsm.edu.pe', 'M', 2016, 2015, 'A'),
(124, 1, 'BIANCA BETZY', 'EGUSQUIZA', 'TOMAS', '16010298', '16010298@unmsm.edu.pe', 'F', 2016, 2015, 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE IF NOT EXISTS `grupo` (
  `gru_id` int(11) NOT NULL AUTO_INCREMENT,
  `asi_id` int(11) NOT NULL,
  `gru_codigo` varchar(5) NOT NULL,
  `gru_numero` int(1) NOT NULL,
  PRIMARY KEY (`gru_id`),
  KEY `fk_reference_34` (`asi_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`gru_id`, `asi_id`, `gru_codigo`, `gru_numero`) VALUES
(1, 61, '1', 1),
(2, 60, '1', 1),
(3, 57, '1', 1),
(4, 72, '1', 1),
(5, 54, '1', 1),
(6, 59, '1', 1),
(7, 27, '1', 1),
(8, 26, '1', 1),
(9, 23, '1', 1),
(10, 48, '1', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `max_rpta_sec`
--

CREATE TABLE IF NOT EXISTS `max_rpta_sec` (
  `mrs_id` int(11) NOT NULL AUTO_INCREMENT,
  `por_id` int(11) DEFAULT NULL,
  `rep_id` int(11) DEFAULT NULL,
  `pos_id` int(11) DEFAULT NULL,
  `mrs_valor_max` double(3,2) NOT NULL COMMENT 'Para una determinada Seccion, es el puntaje máximo otorgado por el Encuestador para calificar a un Profesor en un momento del ciclo. Referido a un profesor en particular sobre una determinada encuesta.',
  `mrs_denominacion` varchar(30) NOT NULL,
  PRIMARY KEY (`mrs_id`),
  KEY `fk_reference_36` (`por_id`),
  KEY `fk_reference_43` (`pos_id`),
  KEY `fk_reference_51` (`rep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Para Reportes con DETALLE (por Curso y por Profesor).' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
  `men_id` int(2) NOT NULL AUTO_INCREMENT,
  `men_nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`men_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modalidad_clase`
--

CREATE TABLE IF NOT EXISTS `modalidad_clase` (
  `moc_id` int(1) NOT NULL AUTO_INCREMENT,
  `moc_tipo` char(1) NOT NULL COMMENT 'T = Teoría P = Práctica L = Laboratorio',
  `moc_descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`moc_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `modalidad_clase`
--

INSERT INTO `modalidad_clase` (`moc_id`, `moc_tipo`, `moc_descripcion`) VALUES
(1, 'T', 'TEORIA'),
(2, 'P', 'PRACTICA'),
(3, 'L', 'LABORATORIO'),
(4, 'S', 'SEMINARIO'),
(5, 'A', 'TALLER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opcion`
--

CREATE TABLE IF NOT EXISTS `opcion` (
  `opc_id` int(11) NOT NULL AUTO_INCREMENT,
  `opc_nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`opc_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `opcion`
--

INSERT INTO `opcion` (`opc_id`, `opc_nombre`) VALUES
(1, 'SI'),
(2, 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo_academico`
--

CREATE TABLE IF NOT EXISTS `periodo_academico` (
  `pea_id` int(11) NOT NULL AUTO_INCREMENT,
  `pea_nombre` varchar(100) NOT NULL,
  `pea_cod_semestre` int(5) NOT NULL COMMENT 'Ej: 20170',
  `pea_fdesde` datetime NOT NULL,
  `pea_fhasta` datetime NOT NULL,
  PRIMARY KEY (`pea_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `periodo_academico`
--

INSERT INTO `periodo_academico` (`pea_id`, `pea_nombre`, `pea_cod_semestre`, `pea_fdesde`, `pea_fhasta`) VALUES
(1, '2017-0', 20170, '2017-01-06 00:00:00', '2017-02-28 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan_estudio`
--

CREATE TABLE IF NOT EXISTS `plan_estudio` (
  `ple_id` int(2) NOT NULL AUTO_INCREMENT,
  `ple_nombre` varchar(200) NOT NULL,
  `ple_anio` int(4) NOT NULL,
  `ple_codigo` int(4) NOT NULL COMMENT 'Ej. 2017',
  `ple_sumilla` varchar(1000) DEFAULT NULL,
  `ple_competencias_generales` varchar(300) DEFAULT NULL,
  `ple_competencias_especificas` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ple_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `plan_estudio`
--

INSERT INTO `plan_estudio` (`ple_id`, `ple_nombre`, `ple_anio`, `ple_codigo`, `ple_sumilla`, `ple_competencias_generales`, `ple_competencias_especificas`) VALUES
(1, 'PLAN DE ESTUDIOS 2004', 2004, 2004, NULL, NULL, NULL),
(2, 'PLAN DE ESTUDIOS 2015', 2015, 2015, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `portada`
--

CREATE TABLE IF NOT EXISTS `portada` (
  `por_id` int(11) NOT NULL AUTO_INCREMENT,
  `por_codigo` varchar(50) NOT NULL,
  `por_nombre` varchar(300) NOT NULL,
  `por_descripcion` varchar(600) DEFAULT NULL,
  `por_finicio` datetime DEFAULT NULL,
  `por_ffin` datetime DEFAULT NULL,
  `por_observaciones` varchar(500) DEFAULT NULL,
  `por_ciclo_anio` varchar(4) DEFAULT NULL,
  `por_estado` char(1) NOT NULL DEFAULT 'A' COMMENT 'I = Inactiva A = Activa C = Cancelada (rechazada)',
  `por_fecha_creacion` datetime NOT NULL,
  PRIMARY KEY (`por_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `portada`
--

INSERT INTO `portada` (`por_id`, `por_codigo`, `por_nombre`, `por_descripcion`, `por_finicio`, `por_ffin`, `por_observaciones`, `por_ciclo_anio`, `por_estado`, `por_fecha_creacion`) VALUES
(1, 'EVA_DOC_20170', 'EVALUACIÓN ESTUDIANTIL DEL DESEMPEÑO DOCENTE', '', '2017-03-07 00:00:00', '2017-03-15 00:00:00', '', '2017', 'A', '2017-06-08 05:00:03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `portada_seccion`
--

CREATE TABLE IF NOT EXISTS `portada_seccion` (
  `pos_id` int(11) NOT NULL AUTO_INCREMENT,
  `por_id` int(11) DEFAULT NULL,
  `sec_id` int(11) DEFAULT NULL,
  `pos_valor_max` double(3,2) DEFAULT NULL COMMENT 'Cada registro es una fila de la tabla RESUMEN DE EVALUACION en "Tabla de Valores"(Web), por cada Seccion.',
  PRIMARY KEY (`pos_id`),
  KEY `fk_reference_56` (`por_id`),
  KEY `fk_reference_57` (`sec_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `portada_seccion`
--

INSERT INTO `portada_seccion` (`pos_id`, `por_id`, `sec_id`, `pos_valor_max`) VALUES
(1, 1, 1, 3.00),
(2, 1, 2, 1.00),
(3, 1, 3, 2.50),
(4, 1, 4, 2.50),
(5, 1, 5, 1.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE IF NOT EXISTS `pregunta` (
  `pre_id` int(11) NOT NULL AUTO_INCREMENT,
  `pre_enunciado` varchar(400) NOT NULL,
  `pre_numero` int(3) NOT NULL,
  `pre_comentario` varchar(300) DEFAULT NULL,
  `pre_tipo_rpta` char(2) NOT NULL DEFAULT 'LI' COMMENT 'LI = Likert (Escala)',
  PRIMARY KEY (`pre_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`pre_id`, `pre_enunciado`, `pre_numero`, `pre_comentario`, `pre_tipo_rpta`) VALUES
(1, 'Dominio del Tema', 1, 'Profesor con alta competencia profesional y técnica en el área que es convocado.', '?N'),
(2, 'Desarrollo actualizado de contenidos previstos', 2, 'El docente demuestra conocimiento actualizado y desarrolla los temas de la clase.', '?N'),
(3, 'Tiene claro objetivos a cumplir', 3, 'El alumno tiene claro los objetivos a cumplir del tema expuesto en clase lográndose de manera eficiente.', '?N'),
(4, 'Resuelve dudas', 4, 'El docente absuelve las interrogantes del tema expuesto, solicitados por los alumnos.', '?N'),
(5, 'Asiste día de programación', 1, 'El docente asiste a las actividades educativas, a la hora programada en el silabo.', '?N'),
(6, 'Verifica asistencia de los alumnos', 2, 'El docente tiene la lista oficial de los alumnos que asisten a clase.', '?N'),
(7, 'Inicio puntual', 3, 'El docente da inicio a su clase a la hora programada en elsilabo.', '?N'),
(8, 'Termina puntual', 4, 'El docente da término a su clase en la hora prevista.', '?N'),
(9, 'Identificación universitaria', 1, 'El docente formenta valores éticos y morales en el interactuar con los alumnos y propugna el respeto a la institución universitaria.', '?N'),
(10, 'Respeto al alumno', 2, 'El docente se comunica y escucha a los alumnos, mantiene una empatía permanente con el alumnado, se evidencia interés por el alumno.', '?N'),
(11, 'Demuestra valores éticos', 3, 'El docente demuestra honestidad, formación ética, moral y confianza en el alumno.', '?N'),
(12, 'Promueve valores en los estudiantes', 4, 'El docente desarrolla valores en los estudiantes, así como actitudes que favorezcan la reflexión y el juicio crítico ante los problemas médicos sociales de su comunidad.', '?N'),
(13, 'Utiliza técnicas educativas apropiadas y novedosas', 1, 'El docente aplica técnicas educativas apropiadas y novedosas con participación del alumno.', '?N'),
(14, 'Publica notas dentro de las 72 horas post examen', 2, 'El docente publica notas dentro de las 72 horas, de haber realizado el examen.', '?N'),
(15, 'Promueve participación del alumno', 3, 'El docente desarrolla técnicas con la participación del alumnado e incentiva la búsqueda de información.', '?N'),
(16, 'Logra cumplir objetivo del aprendizaje', 4, 'El docente logra los objetivos propuestos sobre el tema desarrollado, facilitando la adquisición de competencias.', '?N'),
(17, 'Respeta la programación de temas', 1, 'El docente dicta el tema correspondiente en la fecha programada en el silabo.', '?N'),
(18, 'Respeta el cronograma de programación', 2, 'El docente cumple con la programación de temas consignados en el cronograma.', '?N'),
(19, 'Respeta contenidos', 3, 'El docente desarrolla su tema propuesto.', '?N'),
(20, 'Respeta cumplimiento de las evaluaciones', 4, 'Las evaluaciones se toman en la fecha y horas asignadas.', '?N');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta_opcion`
--

CREATE TABLE IF NOT EXISTS `pregunta_opcion` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pre_id` int(11) DEFAULT NULL,
  `opc_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `fk_reference_19` (`pre_id`),
  KEY `fk_reference_20` (`opc_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

--
-- Volcado de datos para la tabla `pregunta_opcion`
--

INSERT INTO `pregunta_opcion` (`pro_id`, `pre_id`, `opc_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 1),
(4, 2, 2),
(5, 3, 1),
(6, 3, 2),
(7, 4, 1),
(8, 4, 2),
(9, 5, 1),
(10, 5, 2),
(11, 6, 1),
(12, 6, 2),
(13, 7, 1),
(14, 7, 2),
(15, 8, 1),
(16, 8, 2),
(17, 9, 1),
(18, 9, 2),
(19, 10, 1),
(20, 10, 2),
(21, 11, 1),
(22, 11, 2),
(23, 12, 1),
(24, 12, 2),
(25, 13, 1),
(26, 13, 2),
(27, 14, 1),
(28, 14, 2),
(29, 15, 1),
(30, 15, 2),
(31, 16, 1),
(32, 16, 2),
(33, 17, 1),
(34, 17, 2),
(35, 18, 1),
(36, 18, 2),
(37, 19, 1),
(38, 19, 2),
(39, 20, 1),
(40, 20, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pro_sed_dep`
--

CREATE TABLE IF NOT EXISTS `pro_sed_dep` (
  `prosede_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) NOT NULL,
  `dea_id` int(2) NOT NULL,
  `sed_id` int(3) NOT NULL,
  `prosede_ciclo_anio` varchar(4) DEFAULT NULL,
  `prosede_horas` int(2) DEFAULT NULL,
  `cat_categoria` int(5) NOT NULL COMMENT 'AS = Asociado, AU = Auxiliar, JP = Jefe de Práctica, PR = Principal',
  `cat_regimen` int(5) DEFAULT NULL COMMENT 'T.C. = Tiempo Completo, T.P. = Tiempo Parcial, D.E. = Dedicación Exclusiva',
  PRIMARY KEY (`prosede_id`),
  KEY `fk_reference_23` (`pro_id`),
  KEY `fk_reference_24` (`dea_id`),
  KEY `fk_reference_25` (`sed_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `pro_sed_dep`
--

INSERT INTO `pro_sed_dep` (`prosede_id`, `pro_id`, `dea_id`, `sed_id`, `prosede_ciclo_anio`, `prosede_horas`, `cat_categoria`, `cat_regimen`) VALUES
(1, 1, 6, 9, NULL, 20, 4, 3),
(2, 2, 14, 18, NULL, 40, 4, 2),
(3, 3, 3, 25, NULL, 40, 4, 2),
(4, 4, 14, 9, NULL, 20, 4, 3),
(5, 5, 5, 25, NULL, 20, 2, 3),
(6, 6, 5, 25, NULL, 40, 1, 2),
(7, 7, 5, 25, NULL, 20, 2, 3),
(8, 8, 2, 25, NULL, 20, 2, 3),
(9, 9, 2, 25, NULL, 20, 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE IF NOT EXISTS `profesor` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_nombres` varchar(50) NOT NULL,
  `pro_appaterno` varchar(50) NOT NULL,
  `pro_apmaterno` varchar(50) NOT NULL,
  `pro_codigo` varchar(8) NOT NULL,
  `pro_correo` varchar(100) DEFAULT NULL,
  `pro_genero` char(1) DEFAULT NULL,
  `pro_estado` char(1) NOT NULL DEFAULT 'A' COMMENT 'A = Activo I = Inactivo',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`pro_id`, `pro_nombres`, `pro_appaterno`, `pro_apmaterno`, `pro_codigo`, `pro_correo`, `pro_genero`, `pro_estado`) VALUES
(1, 'OSCAR EMILIO', 'MARTINEZ', 'LOZANO', '041815', '041815@unmsm.edu.pe', 'M', 'A'),
(2, 'HALLDER', 'MORI', 'RAMIREZ', '046477', '046477@unmsm.edu.pe', 'M', 'A'),
(3, 'BERRIOS JUAN JULIO', 'PAZ', 'CASTILLO', '052329', '052329@unmsm.edu.pe', 'M', 'A'),
(4, 'JUAN FRANCISCO', 'RIVERA', 'FEIJOO', '059234', '059234@unmsm.edu.pe', 'M', 'A'),
(5, 'JUAN PABLO', 'MURILLO', 'PEÑA', '078158', '078158@unmsm.edu.pe', 'M', 'A'),
(6, 'OSWALDO EDUARDO', 'SALAVERRY', 'GARCIA', '080964', '080964@unmsm.edu.pe', 'M', 'A'),
(7, 'GUSTAVO NESTOR', 'FRANCO', 'PAREDES', '092657', '092657@unmsm.edu.pe', 'M', 'A'),
(8, 'LUIS CLEVER', 'ARIAS', 'CAYCHO', '0A1433', '0A1433@unmsm.edu.pe', 'M', 'A'),
(9, 'DANIEL ANGEL', 'ANGULO', 'POBLETE', '0A1462', '0A1462@unmsm.edu.pe', 'M', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte`
--

CREATE TABLE IF NOT EXISTS `reporte` (
  `rep_id` int(11) NOT NULL AUTO_INCREMENT,
  `rep_nota_final` double(3,2) NOT NULL COMMENT 'Es la nota final de un profesor durante una encuesta.',
  `rep_denominacion` varchar(30) NOT NULL,
  `rep_fdesde` datetime NOT NULL,
  `rep_fhasta` datetime NOT NULL,
  `rep_fecha` datetime NOT NULL,
  `rep_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `rep_ciclo_anio` varchar(4) NOT NULL,
  `rep_modalidad` char(1) NOT NULL COMMENT 'RE : De la Tabla "Resultado", MRS : De la Tabla "Max_Rpta_Sec"',
  PRIMARY KEY (`rep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Ej.: Por profesor Nota Final = (Resultado 1 + Resultad' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultado`
--

CREATE TABLE IF NOT EXISTS `resultado` (
  `res_id` int(11) NOT NULL AUTO_INCREMENT,
  `por_id` int(11) DEFAULT NULL,
  `rep_id` int(11) DEFAULT NULL,
  `dic_id` int(11) DEFAULT NULL,
  `res_nota_parcial` double(3,2) NOT NULL COMMENT 'Es la nota parcial (ponderado de todas las secciones de una determinada encuesta) otorgada por un Encuestador (Estudiante) en una determinada fecha durante un ciclo académico durante una determinada Encuesta.',
  `res_denominacion` varchar(30) NOT NULL,
  PRIMARY KEY (`res_id`),
  KEY `fk_reference_39` (`por_id`),
  KEY `fk_reference_40` (`dic_id`),
  KEY `fk_reference_50` (`rep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Ej: \nPara un determinado Curso Grupo - Profesor (Para ' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `rol_id` int(11) NOT NULL AUTO_INCREMENT,
  `rol_codigo` char(3) NOT NULL COMMENT 'ADM = Administrador, EST = Estudiante, PRO = Profesor, DIR = Director, DEC = Decano',
  `rol_descripcion` varchar(30) NOT NULL,
  PRIMARY KEY (`rol_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`rol_id`, `rol_codigo`, `rol_descripcion`) VALUES
(1, 'ADM', 'ADMINISTRADOR'),
(2, 'DIR', 'DIRECTOR'),
(3, 'PRO', 'PROFESOR'),
(4, 'EST', 'ESTUDIANTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE IF NOT EXISTS `seccion` (
  `sec_id` int(11) NOT NULL AUTO_INCREMENT,
  `sec_nombre` varchar(200) NOT NULL,
  `sec_numero` int(3) NOT NULL,
  PRIMARY KEY (`sec_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `seccion`
--

INSERT INTO `seccion` (`sec_id`, `sec_nombre`, `sec_numero`) VALUES
(1, 'CONOCIMIENTO DE LA MATERIA', 1),
(2, 'ASISTENCIA Y PUNTUALIDAD', 2),
(3, 'ÉTICA', 3),
(4, 'CAPACIDAD DIDÁCTICA', 4),
(5, 'CUMPLIMIENTO DEL SILABO', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sede`
--

CREATE TABLE IF NOT EXISTS `sede` (
  `sed_id` int(3) NOT NULL AUTO_INCREMENT,
  `sed_codigo` varchar(6) DEFAULT NULL,
  `sed_nombre` varchar(300) NOT NULL,
  `sed_direccion` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`sed_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=38 ;

--
-- Volcado de datos para la tabla `sede`
--

INSERT INTO `sede` (`sed_id`, `sed_codigo`, `sed_nombre`, `sed_direccion`) VALUES
(1, '', 'CENTRO MEDICO NAVAL', ''),
(2, '', 'CLINICA UNIVERSITARIA', ''),
(4, '', 'EMERGENCIAS PEDIATRICAS', ''),
(5, '', 'HOSP. ARZOBISPO LOAYZA', ''),
(6, '', 'HOSP. CASIMIRO ULLOA', ''),
(7, '', 'HOSP. DANIEL A. CARRIÓN CALLAO', ''),
(8, '', 'HOSP. DOS DE MAYO', ''),
(9, '', 'HOSP. EDGARDO REBAGLIATTI', ''),
(10, '', 'HOSP. HERMILIO VALDIZAN', ''),
(11, '', 'HOSP. HIPOLITO UNANUE', ''),
(12, '', 'HOSP. LARCO HERRERA', ''),
(13, '', 'HOSP. POLICIA', ''),
(14, '', 'HOSP. SAN BARTOLOME', ''),
(15, '', 'HOSP. SAN JUAN  DE LURIGANCHO', ''),
(16, '', 'HOSP. SERGIO BERNALES', ''),
(17, '', 'HOSPITAL ALMENARA', ''),
(18, '', 'HOSPITAL DEL NIÑO', ''),
(19, '', 'HOSPITAL FAP', ''),
(20, '', 'HOSPITAL MILITAR', ''),
(21, '', 'HOSPITAL NAVAL', ''),
(22, '', 'INST. CIENC. NEUROLOGICAS', ''),
(23, '', 'INST. SALUD DEL NIÑO', ''),
(24, '', 'INST.MED.TROP.DANIEL A. CARRION', ''),
(25, '', 'LOCAL CENTRAL SAN FERNANDO', ''),
(26, '', 'LOCAL CENTRAL SAN FERNANDO (C.M.I Juan Pablo II-ves -MINSA)', ''),
(27, '', 'LOCAL CENTRAL SAN FERNANDO (C.M.I. Cesar Lopez Silva Villa Salvador)', ''),
(28, '', 'LOCAL CENTRAL SAN FERNANDO (Centro de Salud Magdalena)', ''),
(29, '', 'LOCAL CENTRAL SAN FERNANDO (Hosp. Cayetano Heredia - Rimac)', ''),
(30, '', 'LOCAL CENTRAL SAN FERNANDO (Hosp. Santa Rosa -Pueblo Libre)', ''),
(31, '', 'LOCAL CENTRAL SAN FERNANDO (Hosp.Emergencias Grau)', ''),
(32, '', 'LOCAL CENTRAL SAN FERNANDO (Hosp.Guillermo Almenara)', ''),
(33, '', 'LOCAL CENTRAL SAN FERNANDO (Hosp.Nac. Hipolito Unanue)', ''),
(34, '', 'LOCAL CENTRAL SAN FERNANDO (Hospital de Policia)', ''),
(35, '', 'LOCAL CENTRAL SAN FERNANDO (Inst.Nac. Salud del Ni?o)', ''),
(36, '', 'SEDE NUTRICION', ''),
(37, '', 'CLINICA. OFTALMO. SALUD', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion_asignatura`
--

CREATE TABLE IF NOT EXISTS `sesion_asignatura` (
  `sea_id` int(11) NOT NULL AUTO_INCREMENT,
  `asi_id` int(11) DEFAULT NULL,
  `sea_numero` int(2) NOT NULL,
  `sea_contenido` varchar(500) DEFAULT NULL,
  `sea_sumilla` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`sea_id`),
  KEY `fk_reference_55` (`asi_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `sesion_asignatura`
--

INSERT INTO `sesion_asignatura` (`sea_id`, `asi_id`, `sea_numero`, `sea_contenido`, `sea_sumilla`) VALUES
(1, 1, 1, 'CONTENIDO 1-1', 'SUMILLA 1-1'),
(2, 1, 2, 'CONTENIDO 1-2', 'SUMILLA 1-2'),
(3, 1, 3, 'CONTENIDO 1-3', 'SUMILLA 1-3'),
(4, 2, 1, 'CONTENIDO 2-1', 'SUMILLA 2-1'),
(5, 2, 2, 'CONTENIDO 2-2', 'SUMILLA 2-2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion_encuesta`
--

CREATE TABLE IF NOT EXISTS `sesion_encuesta` (
  `see_id` int(11) NOT NULL AUTO_INCREMENT,
  `asi_id` int(11) DEFAULT NULL,
  `see_numero` int(2) NOT NULL,
  `see_contenido` varchar(500) DEFAULT NULL,
  `see_sumilla` varchar(500) DEFAULT NULL,
  `see_fecha_programada` datetime DEFAULT NULL,
  PRIMARY KEY (`see_id`),
  KEY `fk_reference_26` (`asi_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `sesion_encuesta`
--

INSERT INTO `sesion_encuesta` (`see_id`, `asi_id`, `see_numero`, `see_contenido`, `see_sumilla`, `see_fecha_programada`) VALUES
(1, 61, 0, 'CONTENIDO DE ÚNICA SESIÓN POR ASIGNATURA 1', NULL, NULL),
(2, 60, 0, 'CONTENIDO DE ÚNICA SESIÓN POR ASIGNATURA 1', NULL, NULL),
(3, 57, 0, 'CONTENIDO DE ÚNICA SESIÓN POR ASIGNATURA 3', NULL, NULL),
(4, 72, 0, 'CONTENIDO DE ÚNICA SESIÓN POR ASIGNATURA 4', NULL, NULL),
(5, 54, 0, 'CONTENIDO DE ÚNICA SESIÓN POR ASIGNATURA 5', NULL, NULL),
(6, 59, 0, 'CONTENIDO DE ÚNICA SESIÓN POR ASIGNATURA 6', NULL, NULL),
(7, 27, 0, 'CONTENIDO DE ÚNICA SESIÓN POR ASIGNATURA 7', NULL, NULL),
(8, 26, 0, 'CONTENIDO DE ÚNICA SESIÓN POR ASIGNATURA 8', NULL, NULL),
(9, 23, 0, 'CONTENIDO DE ÚNICA SESIÓN POR ASIGNATURA 9', NULL, NULL),
(10, 48, 0, 'CONTENIDO DE ÚNICA SESIÓN POR ASIGNATURA 10', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `usu_id` int(11) NOT NULL AUTO_INCREMENT,
  `usu_usuario` varchar(50) NOT NULL,
  `usu_clave` varchar(44) NOT NULL,
  PRIMARY KEY (`usu_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=135 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usu_id`, `usu_usuario`, `usu_clave`) VALUES
(1, '701884', 'EET701884'),
(2, '880283', 'MOJ880283'),
(3, '05010188', 'ARL05010188'),
(4, '08010224', 'ICR08010224'),
(5, '10010234', 'VZC10010234'),
(6, '11010074', 'RSC11010074'),
(7, '11010592', 'PMA11010592'),
(8, '12010006', 'COL12010006'),
(9, '12010013', 'JSJ12010013'),
(10, '12010212', 'CCJ12010212'),
(11, '12010234', 'MSM12010234'),
(12, '12010235', 'OLJ12010235'),
(13, '12010238', 'OJY12010238'),
(14, '12010240', 'PQD12010240'),
(15, '12010242', 'PNR12010242'),
(16, '12010250', 'RAP12010250'),
(17, '12010266', 'GSA12010266'),
(18, '12010303', 'LVH12010303'),
(19, '13010002', 'AAC13010002'),
(20, '13010014', 'CMJ13010014'),
(21, '13010021', 'DVC13010021'),
(22, '13010025', 'GPM13010025'),
(23, '13010030', 'LGJ13010030'),
(24, '13010050', 'SCA13010050'),
(25, '13010057', 'VMH13010057'),
(26, '13010059', 'YVW13010059'),
(27, '13010208', 'JGM13010208'),
(28, '13010219', 'CGJ13010219'),
(29, '13010225', 'CQJ13010225'),
(30, '13010228', 'CHO13010228'),
(31, '13010372', 'CDC13010372'),
(32, '13010375', 'DCW13010375'),
(33, '13010380', 'LVL13010380'),
(34, '13010412', 'TGB13010412'),
(35, '13010415', 'VRJ13010415'),
(36, '13010428', 'PRA13010428'),
(37, '14010010', 'CGC14010010'),
(38, '14010014', 'GGG14010014'),
(39, '14010015', 'GCA14010015'),
(40, '14010029', 'OEE14010029'),
(41, '14010034', 'RVJ14010034'),
(42, '14010036', 'STP14010036'),
(43, '14010184', 'DGN14010184'),
(44, '14010192', 'GJC14010192'),
(45, '14010211', 'SBM14010211'),
(46, '14010213', 'TLL14010213'),
(47, '14010223', 'CCD14010223'),
(48, '14010232', 'HSE14010232'),
(49, '14010244', 'RGL14010244'),
(50, '14010251', 'TVM14010251'),
(51, '14010270', 'CVF14010270'),
(52, '14010272', 'APL14010272'),
(53, '14010273', 'JBE14010273'),
(54, '15010011', 'CRS15010011'),
(55, '15010017', 'CQJ15010017'),
(56, '15010019', 'CRN15010019'),
(57, '15010027', 'HNL15010027'),
(58, '15010030', 'LGE15010030'),
(59, '15010048', 'SRM15010048'),
(60, '15010053', 'VQG15010053'),
(61, '15010054', 'VPN15010054'),
(62, '15010056', 'APM15010056'),
(63, '15010057', 'AAR15010057'),
(64, '15010227', 'ABE15010227'),
(65, '15010228', 'AAE15010228'),
(66, '15010230', 'BFY15010230'),
(67, '15010238', 'GRF15010238'),
(68, '15010240', 'GEY15010240'),
(69, '15010248', 'MDJ15010248'),
(70, '15010250', 'MTJ15010250'),
(71, '15010267', 'SSJ15010267'),
(72, '15010269', 'VCM15010269'),
(73, '15010270', 'VJA15010270'),
(74, '15010272', 'ALG15010272'),
(75, '15010276', 'CLB15010276'),
(76, '15010283', 'OMA15010283'),
(77, '15010291', 'SLC15010291'),
(78, '15010307', 'SSK15010307'),
(79, '16010036', 'ALJ16010036'),
(80, '16010041', 'CLJ16010041'),
(81, '16010045', 'ECM16010045'),
(82, '16010048', 'GSA16010048'),
(83, '16010051', 'HGZ16010051'),
(84, '16010056', 'MBN16010056'),
(85, '16010057', 'MJL16010057'),
(86, '16010060', 'PEC16010060'),
(87, '16010061', 'PND16010061'),
(88, '16010062', 'QCF16010062'),
(89, '16010063', 'QSL16010063'),
(90, '16010071', 'SFS16010071'),
(91, '16010080', 'CQL16010080'),
(92, '16010086', 'PVG16010086'),
(93, '16010208', 'GML16010208'),
(94, '16010213', 'AHY16010213'),
(95, '16010216', 'ARS16010216'),
(96, '16010220', 'CCE16010220'),
(97, '16010225', 'CTJ16010225'),
(98, '16010228', 'DCP16010228'),
(99, '16010230', 'ELJ16010230'),
(100, '16010231', 'FPJ16010231'),
(101, '16010232', 'FAR16010232'),
(102, '16010237', 'MBL16010237'),
(103, '16010238', 'MVD16010238'),
(104, '16010239', 'MQH16010239'),
(105, '16010240', 'MMJ16010240'),
(106, '16010244', 'PAD16010244'),
(107, '16010252', 'SGL16010252'),
(108, '16010253', 'SBJ16010253'),
(109, '16010254', 'SDS16010254'),
(110, '16010258', 'TUR16010258'),
(111, '16010259', 'VTS16010259'),
(112, '16010263', 'BDG16010263'),
(113, '16010269', 'CTR16010269'),
(114, '16010270', 'EHH16010270'),
(115, '16010278', 'PAJ16010278'),
(116, '16010279', 'QVF16010279'),
(117, '16010280', 'RTE16010280'),
(118, '16010281', 'SLD16010281'),
(119, '16010286', 'DSM16010286'),
(120, '16010287', 'FGM16010287'),
(121, '16010288', 'LDJ16010288'),
(122, '16010289', 'ZFV16010289'),
(123, '16010296', 'CRK16010296'),
(124, '16010298', 'ETB16010298'),
(125, '041815', 'MLO041815'),
(126, '046477', 'MRH046477'),
(127, '052329', 'PCB052329'),
(128, '059234', 'RFJ059234'),
(129, '078158', 'MPJ078158'),
(130, '080964', 'SGO080964'),
(131, '092657', 'FPG092657'),
(132, '0A1433', 'ACL0A1433'),
(133, '0A1462', 'APD0A1462'),
(134, 'ADMIN', 'admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE IF NOT EXISTS `usuario_rol` (
  `usr_id` int(2) NOT NULL AUTO_INCREMENT,
  `usu_id` int(11) DEFAULT NULL,
  `rol_id` int(11) DEFAULT NULL,
  `est_id` int(11) DEFAULT NULL,
  `pro_id` int(11) DEFAULT NULL,
  `usr_estado` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`usr_id`),
  KEY `fk_reference_3` (`usu_id`),
  KEY `fk_reference_4` (`rol_id`),
  KEY `est_id` (`est_id`),
  KEY `pro_id` (`pro_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=136 ;

--
-- Volcado de datos para la tabla `usuario_rol`
--

INSERT INTO `usuario_rol` (`usr_id`, `usu_id`, `rol_id`, `est_id`, `pro_id`, `usr_estado`) VALUES
(1, 134, 1, NULL, NULL, 'A'),
(2, 1, 4, 1, NULL, 'A'),
(3, 2, 4, 2, NULL, 'A'),
(4, 3, 4, 3, NULL, 'A'),
(5, 4, 4, 4, NULL, 'A'),
(6, 5, 4, 5, NULL, 'A'),
(7, 6, 4, 6, NULL, 'A'),
(8, 7, 4, 7, NULL, 'A'),
(9, 8, 4, 8, NULL, 'A'),
(10, 9, 4, 9, NULL, 'A'),
(11, 10, 4, 10, NULL, 'A'),
(12, 11, 4, 11, NULL, 'A'),
(13, 12, 4, 12, NULL, 'A'),
(14, 13, 4, 13, NULL, 'A'),
(15, 14, 4, 14, NULL, 'A'),
(16, 15, 4, 15, NULL, 'A'),
(17, 16, 4, 16, NULL, 'A'),
(18, 17, 4, 17, NULL, 'A'),
(19, 18, 4, 18, NULL, 'A'),
(20, 19, 4, 19, NULL, 'A'),
(21, 20, 4, 20, NULL, 'A'),
(22, 21, 4, 21, NULL, 'A'),
(23, 22, 4, 22, NULL, 'A'),
(24, 23, 4, 23, NULL, 'A'),
(25, 24, 4, 24, NULL, 'A'),
(26, 25, 4, 25, NULL, 'A'),
(27, 26, 4, 26, NULL, 'A'),
(28, 27, 4, 27, NULL, 'A'),
(29, 28, 4, 28, NULL, 'A'),
(30, 29, 4, 29, NULL, 'A'),
(31, 30, 4, 30, NULL, 'A'),
(32, 31, 4, 31, NULL, 'A'),
(33, 32, 4, 32, NULL, 'A'),
(34, 33, 4, 33, NULL, 'A'),
(35, 34, 4, 34, NULL, 'A'),
(36, 35, 4, 35, NULL, 'A'),
(37, 36, 4, 36, NULL, 'A'),
(38, 37, 4, 37, NULL, 'A'),
(39, 38, 4, 38, NULL, 'A'),
(40, 39, 4, 39, NULL, 'A'),
(41, 40, 4, 40, NULL, 'A'),
(42, 41, 4, 41, NULL, 'A'),
(43, 42, 4, 42, NULL, 'A'),
(44, 43, 4, 43, NULL, 'A'),
(45, 44, 4, 44, NULL, 'A'),
(46, 45, 4, 45, NULL, 'A'),
(47, 46, 4, 46, NULL, 'A'),
(48, 47, 4, 47, NULL, 'A'),
(49, 48, 4, 48, NULL, 'A'),
(50, 49, 4, 49, NULL, 'A'),
(51, 50, 4, 50, NULL, 'A'),
(52, 51, 4, 51, NULL, 'A'),
(53, 52, 4, 52, NULL, 'A'),
(54, 53, 4, 53, NULL, 'A'),
(55, 54, 4, 54, NULL, 'A'),
(56, 55, 4, 55, NULL, 'A'),
(57, 56, 4, 56, NULL, 'A'),
(58, 57, 4, 57, NULL, 'A'),
(59, 58, 4, 58, NULL, 'A'),
(60, 59, 4, 59, NULL, 'A'),
(61, 60, 4, 60, NULL, 'A'),
(62, 61, 4, 61, NULL, 'A'),
(63, 62, 4, 62, NULL, 'A'),
(64, 63, 4, 63, NULL, 'A'),
(65, 64, 4, 64, NULL, 'A'),
(66, 65, 4, 65, NULL, 'A'),
(67, 66, 4, 66, NULL, 'A'),
(68, 67, 4, 67, NULL, 'A'),
(69, 68, 4, 68, NULL, 'A'),
(70, 69, 4, 69, NULL, 'A'),
(71, 70, 4, 70, NULL, 'A'),
(72, 71, 4, 71, NULL, 'A'),
(73, 72, 4, 72, NULL, 'A'),
(74, 73, 4, 73, NULL, 'A'),
(75, 74, 4, 74, NULL, 'A'),
(76, 75, 4, 75, NULL, 'A'),
(77, 76, 4, 76, NULL, 'A'),
(78, 77, 4, 77, NULL, 'A'),
(79, 78, 4, 78, NULL, 'A'),
(80, 79, 4, 79, NULL, 'A'),
(81, 80, 4, 80, NULL, 'A'),
(82, 81, 4, 81, NULL, 'A'),
(83, 82, 4, 82, NULL, 'A'),
(84, 83, 4, 83, NULL, 'A'),
(85, 84, 4, 84, NULL, 'A'),
(86, 85, 4, 85, NULL, 'A'),
(87, 86, 4, 86, NULL, 'A'),
(88, 87, 4, 87, NULL, 'A'),
(89, 88, 4, 88, NULL, 'A'),
(90, 89, 4, 89, NULL, 'A'),
(91, 90, 4, 90, NULL, 'A'),
(92, 91, 4, 91, NULL, 'A'),
(93, 92, 4, 92, NULL, 'A'),
(94, 93, 4, 93, NULL, 'A'),
(95, 94, 4, 94, NULL, 'A'),
(96, 95, 4, 95, NULL, 'A'),
(97, 96, 4, 96, NULL, 'A'),
(98, 97, 4, 97, NULL, 'A'),
(99, 98, 4, 98, NULL, 'A'),
(100, 99, 4, 99, NULL, 'A'),
(101, 100, 4, 100, NULL, 'A'),
(102, 101, 4, 101, NULL, 'A'),
(103, 102, 4, 102, NULL, 'A'),
(104, 103, 4, 103, NULL, 'A'),
(105, 104, 4, 104, NULL, 'A'),
(106, 105, 4, 105, NULL, 'A'),
(107, 106, 4, 106, NULL, 'A'),
(108, 107, 4, 107, NULL, 'A'),
(109, 108, 4, 108, NULL, 'A'),
(110, 109, 4, 109, NULL, 'A'),
(111, 110, 4, 110, NULL, 'A'),
(112, 111, 4, 111, NULL, 'A'),
(113, 112, 4, 112, NULL, 'A'),
(114, 113, 4, 113, NULL, 'A'),
(115, 114, 4, 114, NULL, 'A'),
(116, 115, 4, 115, NULL, 'A'),
(117, 116, 4, 116, NULL, 'A'),
(118, 117, 4, 117, NULL, 'A'),
(119, 118, 4, 118, NULL, 'A'),
(120, 119, 4, 119, NULL, 'A'),
(121, 120, 4, 120, NULL, 'A'),
(122, 121, 4, 121, NULL, 'A'),
(123, 122, 4, 122, NULL, 'A'),
(124, 123, 4, 123, NULL, 'A'),
(125, 124, 4, 124, NULL, 'A'),
(126, 125, 3, NULL, 1, 'A'),
(127, 126, 3, NULL, 2, 'A'),
(128, 127, 3, NULL, 3, 'A'),
(129, 128, 3, NULL, 4, 'A'),
(130, 129, 3, NULL, 5, 'A'),
(131, 130, 3, NULL, 6, 'A'),
(132, 131, 3, NULL, 7, 'A'),
(133, 132, 3, NULL, 8, 'A'),
(134, 133, 3, NULL, 9, 'A');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `acceso`
--
ALTER TABLE `acceso`
  ADD CONSTRAINT `fk_reference_1` FOREIGN KEY (`men_id`) REFERENCES `menu` (`men_id`),
  ADD CONSTRAINT `fk_reference_2` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`rol_id`);

--
-- Filtros para la tabla `acceso_encuesta`
--
ALTER TABLE `acceso_encuesta`
  ADD CONSTRAINT `fk_reference_11` FOREIGN KEY (`por_id`) REFERENCES `portada` (`por_id`),
  ADD CONSTRAINT `fk_reference_46` FOREIGN KEY (`usu_id`) REFERENCES `usuario` (`usu_id`);

--
-- Filtros para la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD CONSTRAINT `fk_reference_13` FOREIGN KEY (`ple_id`) REFERENCES `plan_estudio` (`ple_id`);

--
-- Filtros para la tabla `cab_matricula`
--
ALTER TABLE `cab_matricula`
  ADD CONSTRAINT `fk_reference_16` FOREIGN KEY (`est_id`) REFERENCES `estudiante` (`est_id`),
  ADD CONSTRAINT `fk_reference_44` FOREIGN KEY (`pea_id`) REFERENCES `periodo_academico` (`pea_id`);

--
-- Filtros para la tabla `cab_rpta`
--
ALTER TABLE `cab_rpta`
  ADD CONSTRAINT `fk_reference_10` FOREIGN KEY (`est_id`) REFERENCES `estudiante` (`est_id`);

--
-- Filtros para la tabla `cuestionario`
--
ALTER TABLE `cuestionario`
  ADD CONSTRAINT `fk_reference_58` FOREIGN KEY (`pos_id`) REFERENCES `portada_seccion` (`pos_id`),
  ADD CONSTRAINT `fk_reference_8` FOREIGN KEY (`pre_id`) REFERENCES `pregunta` (`pre_id`);

--
-- Filtros para la tabla `denominacion`
--
ALTER TABLE `denominacion`
  ADD CONSTRAINT `fk_reference_53` FOREIGN KEY (`por_id`) REFERENCES `portada` (`por_id`);

--
-- Filtros para la tabla `det_matricula`
--
ALTER TABLE `det_matricula`
  ADD CONSTRAINT `fk_reference_17` FOREIGN KEY (`cam_id`) REFERENCES `cab_matricula` (`cam_id`),
  ADD CONSTRAINT `fk_reference_37` FOREIGN KEY (`gru_id`) REFERENCES `grupo` (`gru_id`);

--
-- Filtros para la tabla `det_rpta`
--
ALTER TABLE `det_rpta`
  ADD CONSTRAINT `fk_reference_48` FOREIGN KEY (`car_id`) REFERENCES `cab_rpta` (`car_id`),
  ADD CONSTRAINT `fk_reference_49` FOREIGN KEY (`cue_id`) REFERENCES `cuestionario` (`cue_id`),
  ADD CONSTRAINT `fk_reference_54` FOREIGN KEY (`dic_id`) REFERENCES `dictado` (`dic_id`);

--
-- Filtros para la tabla `dictado`
--
ALTER TABLE `dictado`
  ADD CONSTRAINT `fk_reference_28` FOREIGN KEY (`prosede_id`) REFERENCES `pro_sed_dep` (`prosede_id`),
  ADD CONSTRAINT `fk_reference_38` FOREIGN KEY (`gru_id`) REFERENCES `grupo` (`gru_id`),
  ADD CONSTRAINT `fk_reference_47` FOREIGN KEY (`moc_id`) REFERENCES `modalidad_clase` (`moc_id`),
  ADD CONSTRAINT `fk_reference_52` FOREIGN KEY (`see_id`) REFERENCES `sesion_encuesta` (`see_id`);

--
-- Filtros para la tabla `escala_likert`
--
ALTER TABLE `escala_likert`
  ADD CONSTRAINT `fk_reference_42` FOREIGN KEY (`pos_id`) REFERENCES `portada_seccion` (`pos_id`);

--
-- Filtros para la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD CONSTRAINT `fk_reference_31` FOREIGN KEY (`esa_id`) REFERENCES `escuela_academica` (`esa_id`);

--
-- Filtros para la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD CONSTRAINT `fk_reference_34` FOREIGN KEY (`asi_id`) REFERENCES `asignatura` (`asi_id`);

--
-- Filtros para la tabla `max_rpta_sec`
--
ALTER TABLE `max_rpta_sec`
  ADD CONSTRAINT `fk_reference_36` FOREIGN KEY (`por_id`) REFERENCES `portada` (`por_id`),
  ADD CONSTRAINT `fk_reference_43` FOREIGN KEY (`pos_id`) REFERENCES `portada_seccion` (`pos_id`),
  ADD CONSTRAINT `fk_reference_51` FOREIGN KEY (`rep_id`) REFERENCES `reporte` (`rep_id`);

--
-- Filtros para la tabla `portada_seccion`
--
ALTER TABLE `portada_seccion`
  ADD CONSTRAINT `fk_reference_56` FOREIGN KEY (`por_id`) REFERENCES `portada` (`por_id`),
  ADD CONSTRAINT `fk_reference_57` FOREIGN KEY (`sec_id`) REFERENCES `seccion` (`sec_id`);

--
-- Filtros para la tabla `pregunta_opcion`
--
ALTER TABLE `pregunta_opcion`
  ADD CONSTRAINT `fk_reference_19` FOREIGN KEY (`pre_id`) REFERENCES `pregunta` (`pre_id`),
  ADD CONSTRAINT `fk_reference_20` FOREIGN KEY (`opc_id`) REFERENCES `opcion` (`opc_id`);

--
-- Filtros para la tabla `pro_sed_dep`
--
ALTER TABLE `pro_sed_dep`
  ADD CONSTRAINT `fk_reference_23` FOREIGN KEY (`pro_id`) REFERENCES `profesor` (`pro_id`),
  ADD CONSTRAINT `fk_reference_24` FOREIGN KEY (`dea_id`) REFERENCES `departamento_academico` (`dea_id`),
  ADD CONSTRAINT `fk_reference_25` FOREIGN KEY (`sed_id`) REFERENCES `sede` (`sed_id`);

--
-- Filtros para la tabla `resultado`
--
ALTER TABLE `resultado`
  ADD CONSTRAINT `fk_reference_39` FOREIGN KEY (`por_id`) REFERENCES `portada` (`por_id`),
  ADD CONSTRAINT `fk_reference_40` FOREIGN KEY (`dic_id`) REFERENCES `dictado` (`dic_id`),
  ADD CONSTRAINT `fk_reference_50` FOREIGN KEY (`rep_id`) REFERENCES `reporte` (`rep_id`);

--
-- Filtros para la tabla `sesion_asignatura`
--
ALTER TABLE `sesion_asignatura`
  ADD CONSTRAINT `fk_reference_55` FOREIGN KEY (`asi_id`) REFERENCES `asignatura` (`asi_id`);

--
-- Filtros para la tabla `sesion_encuesta`
--
ALTER TABLE `sesion_encuesta`
  ADD CONSTRAINT `fk_reference_26` FOREIGN KEY (`asi_id`) REFERENCES `asignatura` (`asi_id`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `fk_reference_3` FOREIGN KEY (`usu_id`) REFERENCES `usuario` (`usu_id`),
  ADD CONSTRAINT `fk_reference_4` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`rol_id`),
  ADD CONSTRAINT `usuario_rol_ibfk_1` FOREIGN KEY (`est_id`) REFERENCES `estudiante` (`est_id`),
  ADD CONSTRAINT `usuario_rol_ibfk_2` FOREIGN KEY (`pro_id`) REFERENCES `profesor` (`pro_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
