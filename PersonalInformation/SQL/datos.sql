-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-02-2019 a las 21:49:14
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `personal_information`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos`
--

CREATE TABLE `datos` (
  `Id` int(155) NOT NULL,
  `First_Name` varchar(155) COLLATE utf8_spanish_ci NOT NULL,
  `Last_Name` varchar(155) COLLATE utf8_spanish_ci NOT NULL,
  `Email` varchar(155) COLLATE utf8_spanish_ci NOT NULL,
  `Credit_Card_Type` varchar(155) COLLATE utf8_spanish_ci NOT NULL,
  `Card_Holder` varchar(155) COLLATE utf8_spanish_ci NOT NULL,
  `Card_Number` int(155) NOT NULL,
  `CVV2` int(155) NOT NULL,
  `Exp_Date` date NOT NULL,
  `Street_Adress` varchar(155) COLLATE utf8_spanish_ci NOT NULL,
  `City` varchar(155) COLLATE utf8_spanish_ci NOT NULL,
  `State` varchar(155) COLLATE utf8_spanish_ci NOT NULL,
  `ZIP` int(155) NOT NULL,
  `Country` varchar(155) COLLATE utf8_spanish_ci NOT NULL,
  `Phone` int(155) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `datos`
--

INSERT INTO `datos` (`Id`, `First_Name`, `Last_Name`, `Email`, `Credit_Card_Type`, `Card_Holder`, `Card_Number`, `CVV2`, `Exp_Date`, `Street_Adress`, `City`, `State`, `ZIP`, `Country`, `Phone`) VALUES
(1, 'Adrian', 'Hoyos', 'ahoyosmarqu@uniminuto.edu.co', 'Visa', 'Yo mismo', 4537, 879, '2019-02-27', 'Calle 160 A No 7-22', 'BogotÃ¡', 'Married', 57, 'CO', 2147483647);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `datos`
--
ALTER TABLE `datos`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `datos`
--
ALTER TABLE `datos`
  MODIFY `Id` int(155) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
