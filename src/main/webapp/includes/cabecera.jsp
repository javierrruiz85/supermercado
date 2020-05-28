<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- fontawesome 5 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/estilos.css">
    
    <!-- datatables -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">



    <title> ${param.title} | Ejercicios</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-light fixed-top bg-info">
        <!-- logo -->
        <a class="navbar-brand" href="index.jsp">
            <i class="fab fa-fort-awesome-alt"></i>
        </a>

        <!-- icono para desplegar menu en moviles -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <!-- lista enlaces -->
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item ${ ( 'inicio' eq param.pagina ) ? 'active' : '' } ">
              <a class="nav-link" href="index.jsp">Inicio</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle ${ ( 'alumnos' eq param.pagina ) ? 'active' : '' } " href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Alumnos</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                <a class="dropdown-item" href="ver-tabla-alumnos">Ver alumnos en tabla</a>
                    <a class="dropdown-item" href="alumno-crear">Crear alumnos</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle ${ ( 'productos' eq param.pagina ) ? 'active' : '' } " href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Productos</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="productos">Tabla productos</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle ${ ( 'curriculum' eq param.pagina ) ? 'active' : '' } " href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Curriculum</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="formulario.jsp">Formulario CV</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle ${ ( 'ejemplos' eq param.pagina ) ? 'active' : '' } " href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ejemplos</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="getYpost.jsp">Ejemplos Get y Post</a>
                </div>
            </li>
            
          </ul>
        
        </div>
      </nav>
      
      <main role="main" class="container">