-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-04-2019 a las 17:51:06
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.1.27

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

--
-- Volcado de datos para la tabla `noticia`
--

INSERT INTO `noticia` (`id`, `id_usuario`, `titulo`, `contenido`, `fecha_publicacion`, `puntos`, `url`, `visibilidad`, `host`) VALUES
(1, 1, 'probandotitulo', NULL, '2019-04-08 18:08:55', 4, 'www.probandotitulo.com/masrcasdeautos/adalksd/asdad', 1, 'www.probandotitulo.com'),
(2, 1, 'hola', '', '2019-04-09 05:23:15', 1, 'https://appsco.platzi.com/clases/', 1, 'appsco.platzi.com'),
(3, 1, 'probando 5', 'dgrgdgdfgdg', '2019-04-09 05:27:38', 1, 'https://appsco.platzi.com/clases/', 1, 'appsco.platzi.com'),
(4, 7, 'juasjuas', 'afsdfsdf', '2019-04-09 05:34:38', 1, '', 1, ''),
(5, 7, 'dasd', 'asdasd', '2019-04-09 05:37:57', 1, '', 1, ''),
(6, 10, 'sfsdfsdf', 'sfsfsdfsdf', '2019-04-09 06:02:44', 2, 'xcvcvxvxcv', 1, ''),
(7, 1, 'dfgdfg', '', '2019-04-09 13:01:28', 0, 'fgdfg', 1, ''),
(8, 1, 'dfgdfg', '', '2019-04-09 13:01:36', 0, '', 1, ''),
(9, 1, 'This is a wiki enlace', '', '2019-04-09 14:21:23', 0, 'https://www.wikipedia.org/', 1, 'wikipedia.org'),
(10, 1, 'This is a wiki enlace', '', '2019-04-09 14:23:31', 0, 'https://www.wikipedia.org/', 1, 'wikipedia.org'),
(11, 1, 'This is a wiki enlace', '', '2019-04-09 14:23:55', 0, 'https://www.wikipedia.org/', 1, 'wikipedia.org'),
(12, 1, 'This is a wiki enlace', '', '2019-04-09 14:36:22', 0, 'https://www.wikipedia.org/', 1, 'wikipedia.org'),
(13, 1, 'This is a wiki enlace', '', '2019-04-09 14:37:08', 0, 'https://www.wikipedia.org/', 1, 'wikipedia.org');

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
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre_usuario`, `contraseña`, `fecha_creacion`, `karma`, `acerca_de_mi`, `email`, `showdead`, `noprocast`, `visitas_maximas`, `min_away`, `retraso`) VALUES
(1, 'adri', '123', '2019-04-08 17:54:11', 0, 'un poco del acerca de mi es esto', 'adri@hot', 'no', 'no', 20, 180, 0),
(2, 'hola', 'gh', '2019-04-08 19:04:07', 0, NULL, NULL, 'no', 'no', 20, 180, 0),
(3, 'as', 'zx', '2019-04-08 19:58:53', 0, NULL, NULL, 'no', 'no', 20, 180, 0),
(4, 'pobre', '789', '2019-04-08 20:14:41', 0, NULL, NULL, 'no', 'no', 20, 180, 0),
(5, 'juan', '123', '2019-04-08 20:31:04', 0, NULL, NULL, 'no', 'no', 20, 180, 0),
(6, 'koli', '987', '2019-04-08 20:34:11', 0, NULL, NULL, 'no', 'no', 20, 180, 0),
(7, 'pekka', '1', '2019-04-08 20:46:17', 0, NULL, NULL, 'no', 'no', 20, 180, 0),
(8, 'pekkas', 'a', '2019-04-08 20:46:46', 0, NULL, NULL, 'no', 'no', 20, 180, 0),
(10, 'zx', '12', '2019-04-08 22:35:54', 0, NULL, NULL, 'no', 'no', 20, 180, 0),
(11, 'uanda', '456', '2019-04-09 00:17:59', 0, NULL, NULL, 'no', 'no', 20, 180, 0),
(12, 'foca', '123', '2019-04-09 12:54:52', 0, NULL, NULL, 'no', 'no', 20, 180, 0);

--
-- Índices para tablas volcadas
--

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
-- AUTO_INCREMENT de la tabla `noticia`
--
ALTER TABLE `noticia`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
