<?php

//*****************************************************************
//Conexion Base de datos*******************************************
//*****************************************************************

// Parametros a configurar para la conexion de la base de datos
	$usuario = "root"; //es root en caso de no haber comprado algun hosting
	$password = ""; //contraseña del hosting
	$servidor = "localhost"; //localhost por lo del xampp
	$basededatos = "personal_information"; //nombre de la base de datos

	//Conectar con la base de daros
	$conexion = mysqli_connect($servidor, $usuario, "") or die ("Error con el servidor con la base de datos");
	//Si conexion cumple, va a conectar con la base de datos
	$bd = mysqli_select_db($conexion, $basededatos) or die ("Error conexion al conectarse a la base de datos");

	$erasePerson = $_GET['deletep'];

	$sql = "DELETE FROM datos
					WHERE Id = $erasePerson ";

	$result = mysqli_query($conexion,$sql);

	if (!$result) {
		echo "Hubo un error";
	}else{
		echo "Datos borrados correctamente";
	}
