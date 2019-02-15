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


	$sql = "SELECT * FROM datos";

	$result = mysqli_query($conexion,$sql);

	echo '<table class="table table-sm table-dark">
				<thead>
					<tr class="bg-danger">
						<th scope="col">#</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">Credit Card Type</th>
						<th scope="col">Card Holder</th>
						<th scope="col">Card Number</th>
						<th scope="col">CVV2</th>
						<th scope="col">Exp Date</th>
						<th scope="col">Street Adress</th>
						<th scope="col">City</th>
						<th scope="col">State</th>
						<th scope="col">ZIP</th>
						<th scope="col">Country</th>
						<th scope="col">Phone</th>
					</tr>
					<tbody>';
	//Array asociativo
	while ($row = mysqli_fetch_array($result)){
		echo '<tr>
      <th scope="row">'.$row[0].'</th>
      <td class="bg-primary">'.$row[1].'</td>
      <td>'.$row[2].'</td>
      <td class="bg-primary">'.$row[3].'</td>
			<td>'.$row[4].'</td>
      <td class="bg-primary">'.$row[5].'</td>
      <td>'.$row[6].'</td>
			<td class="bg-primary">'.$row[7].'</td>
      <td>'.$row[8].'</td>
      <td class="bg-primary">'.$row[9].'</td>
			<td>'.$row[10].'</td>
      <td class="bg-primary">'.$row[11].'</td>
      <td>'.$row[12].'</td>
			<td class="bg-primary">'.$row[13].'</td>
      <td>'.$row[14].'</td>
    </tr>';
	}
echo "</thead>
</tbody>
</able>";
