-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-04-2016 a las 10:39:00
-- Versión del servidor: 5.6.25
-- Versión de PHP: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sis_distribuidos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `function`
--

CREATE TABLE IF NOT EXISTS `function` (
  `id_function` int(11) NOT NULL,
  `schedule` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `function`
--

INSERT INTO `function` (`id_function`, `schedule`) VALUES
(1, '5:00PM - 8:00PM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movie`
--

CREATE TABLE IF NOT EXISTS `movie` (
  `id_movie` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `movie`
--

INSERT INTO `movie` (`id_movie`, `name`, `description`) VALUES
(1, 'Deadpool The Movie', 'A film about hulk and shit');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room`
--

CREATE TABLE IF NOT EXISTS `room` (
  `id_room` int(11) NOT NULL DEFAULT '0',
  `mat_column` int(11) NOT NULL,
  `mat_row` int(11) NOT NULL,
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `room`
--

INSERT INTO `room` (`id_room`, `mat_column`, `mat_row`, `value`) VALUES
(1, 0, 0, 0),
(1, 0, 1, 0),
(1, 0, 2, 0),
(1, 0, 3, 0),
(1, 0, 4, 0),
(1, 0, 5, 0),
(1, 0, 6, 0),
(1, 0, 7, 0),
(1, 0, 8, 0),
(1, 0, 9, 0),
(1, 1, 0, 0),
(1, 1, 1, 0),
(1, 1, 2, 0),
(1, 1, 3, 0),
(1, 1, 4, 0),
(1, 1, 5, 0),
(1, 1, 6, 0),
(1, 1, 7, 0),
(1, 1, 8, 0),
(1, 1, 9, 0),
(1, 2, 0, 0),
(1, 2, 1, 0),
(1, 2, 2, 0),
(1, 2, 3, 0),
(1, 2, 4, 0),
(1, 2, 5, 0),
(1, 2, 6, 0),
(1, 2, 7, 0),
(1, 2, 8, 0),
(1, 2, 9, 0),
(1, 3, 0, 0),
(1, 3, 1, 0),
(1, 3, 2, 0),
(1, 3, 3, 0),
(1, 3, 4, 0),
(1, 3, 5, 0),
(1, 3, 6, 0),
(1, 3, 7, 0),
(1, 3, 8, 0),
(1, 3, 9, 0),
(1, 4, 0, 0),
(1, 4, 1, 0),
(1, 4, 2, 0),
(1, 4, 3, 0),
(1, 4, 4, 0),
(1, 4, 5, 0),
(1, 4, 6, 0),
(1, 4, 7, 0),
(1, 4, 8, 0),
(1, 4, 9, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `function`
--
ALTER TABLE `function`
  ADD PRIMARY KEY (`id_function`);

--
-- Indices de la tabla `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id_movie`);

--
-- Indices de la tabla `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id_room`,`mat_column`,`mat_row`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `function`
--
ALTER TABLE `function`
  MODIFY `id_function` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `movie`
--
ALTER TABLE `movie`
  MODIFY `id_movie` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
