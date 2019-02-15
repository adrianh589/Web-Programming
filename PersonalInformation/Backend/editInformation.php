<?php
//*****************************************************************
//Conexion Base de datos*******************************************
//*****************************************************************

	// Parametros a configurar para la conexion de la base de datos
	$usuario = "root"; //es root en caso de no haber comprado algun hosting
	$password = ""; //contraseña del hosting
	$servidor = "localhost"; //localhost por lo del xampp
	$basededatos = "personal_information"; //nombre de la base de datos

	//Variable para indicar el campo a cambiar
	$modifySelect= $_GET['modifySelect'];
	$modifyField="'".$_GET['modifyField']."'";
	$ID=$_GET['ID'];

	//Conectar con la base de daros
	$conexion = mysqli_connect($servidor, $usuario, "") or die ("Error con el servidor con la base de datos");
	//Si conexion cumple, va a conectar con la base de datos
	$bd = mysqli_select_db($conexion, $basededatos) or die ("Error conexion al conectarse a la base de datos");

	$sql = "UPDATE `datos`
    			SET $modifySelect = $modifyField
					WHERE `datos`.`id` = $ID ";

	$result = mysqli_query($conexion,$sql);

	if (!$result) {
		echo "hubo un error";
	}else{

	}
