-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2019 a las 18:03:57
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.1.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hackerbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `id` int(45) NOT NULL,
  `id_noticia` int(45) NOT NULL,
  `id_usuario` int(45) NOT NULL,
  `contenido` text COLLATE utf8_spanish_ci NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios_comentario`
--

CREATE TABLE `comentarios_comentario` (
  `id` int(45) NOT NULL,
  `id_usuario` int(45) NOT NULL,
  `id_comentario` int(45) NOT NULL,
  `id_noticia` int(45) NOT NULL,
  `contenido` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticia`
--

CREATE TABLE `noticia` (
  `id` int(255) NOT NULL,
  `id_usuario` int(255) NOT NULL,
  `titulo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `contenido` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_publicacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `puntos` int(255) NOT NULL DEFAULT '0',
  `url` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `visibilidad` tinyint(1) NOT NULL DEFAULT '1',
  `host` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(255) NOT NULL,
  `nombre_usuario` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `contraseña` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `karma` int(255) NOT NULL DEFAULT '0',
  `acerca_de_mi` text COLLATE utf8_spanish_ci,
  `email` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `showdead` varchar(45) COLLATE utf8_spanish_ci NOT NULL DEFAULT 'no',
  `noprocast` varchar(45) COLLATE utf8_spanish_ci NOT NULL DEFAULT 'no',
  `visitas_maximas` int(255) NOT NULL DEFAULT '20',
  `min_away` int(255) NOT NULL DEFAULT '180',
  `retraso` int(255) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comentarios_comentario`
--
ALTER TABLE `comentarios_comentario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_usuario` (`nombre_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `id` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `comentarios_comentario`
--
ALTER TABLE `comentarios_comentario`
  MODIFY `id` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `noticia`
--
ALTER TABLE `noticia`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
