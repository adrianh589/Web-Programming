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

      /*Variables*/
		$nombre=$_GET['nombre'];
		$apellido=$_GET['apellido'];
		$email=$_GET['email'];
		$tipoTarjeta=$_GET['tipoTarjeta'];
		$portadorTarjeta=$_GET['portadorTarjeta'];
		$numeroTarjeta=$_GET['numeroTarjeta'];
		$cvv2=$_GET['cvv2'];
		$fechaExp=$_GET['fechaExp'];
		$direccion=$_GET['direccion'];
		$ciudad=$_GET['ciudad'];
		$estado=$_GET['estado'];
		$zip=$_GET['zip'];
		$pais=$_GET['pais'];
		$telefono=$_GET['telefono'];
		$codigoSeguridad=$_GET['codigoSeguridad'];

	  //Query para insertar un dato en la tabla
      $insertData = "INSERT INTO datos VALUES (NULL,'$nombre','$apellido','$email','$tipoTarjeta','$portadorTarjeta','$numeroTarjeta','$cvv2','$fechaExp','$direccion','$ciudad','$estado','$zip','$pais','$telefono')";

      $ejecutar = mysqli_query($conexion,$insertData);

      if (!$ejecutar) {
      	echo "Hubo un error";
      }else{
				echo "Datos insertados correctamente";
      }
