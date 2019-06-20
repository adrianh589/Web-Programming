<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>

    <?php
    $usuarioRecibido = $_POST['username'];
    $contraRecibida = $_POST['password'];

    ////////////////////////////////////////////////////////////////////////////////
    //Para metodos POST/////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    // Crear un flujo
    $opciones = array(
        'http'=>array(
        'method'=>"POST",
        'header'=>"Accept-language: en\r\n"
        )
    );

    $contexto = stream_context_create($opciones);

    // Abre el fichero usando las cabeceras HTTP establecidas arriba
    $fichero = file_get_contents('http://localhost:8080/proyectHNDB/api/usuarios/'.$usuarioRecibido.'/'.$contraRecibida, false, $contexto);


    //**************************************************** */
    //Si no hubo errores al consumir la api*****************
    //**************************************************** */
    if ($fichero) {
        echo "<h1>Bienvenido/a ". $usuarioRecibido ." </h1>";

        ////////////////////////////////////////////////////
        //Para metodo GET///////////////////////////////////
        ////////////////////////////////////////////////////
        $noticias = json_decode( file_get_contents('http://localhost:8080/proyectHNDB/api/noticias'), true ); 
?>

    <table class="table table-dark">
    <thead>
        <tr>
        <th scope="col">#</th>
        <th scope="col">Autor</th>
        <th scope="col">Titulo</th>
        <th scope="col">Contenido</th>
        <th scope="col">URL</th>
        </tr>
    </thead>
    <tbody>

<?php 

for ($i=0; $i < count($noticias); $i++) { 
echo '
        <tr>
            <th scope="row">'.$i.'</th>
            <td>'.$noticias[$i]['autor'].'</td>
            <td>'.$noticias[$i]['titulo'].'</td>
            <td>'.$noticias[$i]['contenido'].'</td>
            <td>'.$noticias[$i]['url'].'</td>
            </tr></td>
        </tr>
';
    }
?>

    </tbody>
    </table>

<?php
    } else {
        echo "<h1>El usuario ". $usuarioRecibido ." NO existe</h1>";
    }
    ?>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>


