<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <jsp:include page="/WEB-INF/templates/head.jsp" />
        <title>Alta de Usuario</title>
    </head>

    <body>
        <header>
            <jsp:include page="/WEB-INF/templates/header.jsp" />
        </header>

       <main class="container">
    <div class="row justify-content-center">
    
    	<div class="col-9">
        <div class="text-center mb-4">
          <h1 class="h3 mb-3 fw-normal">Alta de Usuario</h1>
        </div>

        <form class="form-signup needs-validation" novalidate>
          <!-- Sección de Información Personal -->
          <section>
            <h2 class="h4">Información Personal</h2>

            <!-- Input de Nickname -->
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="nickname-input" placeholder=" " required>
              <label for="nickname-input">Nickname *</label>
              <div class="invalid-feedback">
                Elije otro nickname
              </div>
            </div>

            <div class="row">
              <div class="col">
                <!-- Input de Nombre -->
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="nombre-input" placeholder=" " required>
                  <label for="nombre-input">Nombre *</label>
                  <div class="invalid-feedback">
                    Nombre es un atributo requerido
                  </div>
                </div>
              </div>
              <div class="col">
                <!-- Input de Apellido -->
                <div class="form-floating mb-3">
                  <input type="text" class="form-control" id="apellido-input" placeholder=" " required>
                  <label for="apellido-input">Apellido *</label>
                  <div class="invalid-feedback">
                    Apellido es un atributo requerido
                  </div>
                </div>
              </div>
            </div>
          </section>

          <!-- Sección de Contraseña -->
          <section>
            <h2 class="h4">Contraseña</h2>

            <div class="row">

              <div class="col">
                <!-- Input de Contraseña -->
                <div class="form-floating mb-3 ">
                  <input type="password" class="form-control" id="password-input" placeholder=" " required>
                  <label for="password-input">Contraseña *</label>
                  <div class="invalid-feedback">
                    Contraseña es un atributo requerido
                  </div>
                </div>
              </div>

              <div class="col">
                <!-- Input de Confirmar Contraseña -->
                <div class="form-floating mb-3 ">
                  <input type="password" class="form-control" id="confirm-password-input" placeholder=" ">
                  <label for="confirm-password-input">Confirmar Contraseña *</label>
                  <div class="invalid-feedback">
                    Las contraseñas no coinciden
                  </div>
                </div>
              </div>

            </div>

          </section>

          <!-- Sección de Correo Electrónico -->
          <section>
            <h2 class="h4">Correo Electrónico</h2>

            <!-- Input de Correo Electrónico -->
            <div class="form-floating mb-3">
              <input type="email" class="form-control" id="email-input" placeholder=" " required>
              <label for="email-input">Correo Electrónico *</label>
              <div class="invalid-feedback">
                Correo Electrónico es un atributo requerido
              </div>
            </div>
          </section>

          <!-- Sección de Tipo de Usuario -->
          <section>
            <h2 class="h4">Tipo de Usuario</h2>

            <!-- Radio buttons para el tipo de usuario -->
            <div class="form-check">
              <input class="form-check-input" type="radio" name="tipo-usuario" id="empresa-radio" value="empresa"
                onchange="mostrarCamposEspeciales()" required>
              <label class="form-check-label" for="empresa-radio">Empresa</label>
            </div>

            <div class="form-check">
              <input class="form-check-input" type="radio" name="tipo-usuario" id="postulante-radio" value="postulante"
                onchange="mostrarCamposEspeciales()" required>
              <label class="form-check-label" for="postulante-radio">Postulante</label>
              <div class="invalid-feedback">
                Debe seleccionar un tipo de usuario
              </div>
            </div>
          </section>

          <!-- Campos adicionales para Empresa -->
          <div id="campos-empresa" style="display: none">
            <section>
              <h2 class="h4">Información de la Empresa</h2>

              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="descripcion-empresa-input" placeholder=" ">
                <label for="descripcion-empresa-input">Descripción de la Empresa *</label>
                <div class="invalid-feedback">
                  Descripción de la Empresa es un atributo requerido
                </div>
              </div>

              <div class="form-floating mb-3">
                <input type="url" class="form-control" id="sitio-web-input" placeholder=" ">
                <label for="sitio-web-input">Sitio Web de la Empresa</label>
              </div>
            </section>
          </div>

          <!-- Campos adicionales para Postulante -->
          <div id="campos-postulante" style="display: none">
            <section>
              <h2 class="h4">Información del Postulante</h2>

              <div class="form-floating mb-3">
                <input type="date" class="form-control" id="fecha-nacimiento-input" required>
                <label for="fecha-nacimiento-input">Fecha de Nacimiento *</label>
                <div class="invalid-feedback">
                  Fecha de Nacimiento es un atributo requerido
                </div>
              </div>

              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="nacionalidad-input" placeholder=" ">
                <label for="nacionalidad-input">Nacionalidad *</label>
                <div class="invalid-feedback">
                  Nacionalidad es un atributo requerido
                </div>
              </div>
            </section>
          </div>

          <!-- Sección de Imagen de Perfil -->
          <section>
            <h2 class="h4">Imagen de Perfil</h2>

            <div class="form-group mb-3">
              <label for="image-input">Subir una imagen *</label>
              <input type="file" class="form-control" id="image-input" accept="image/*">
            </div>
          </section>

          <!-- Botón de Registro -->
          <button class="w-100 btn btn-lg btn-primary mt-3" type="submit">
            Registrarse
          </button>

          <div class="link-secondary text-center">
            <!-- mensaje para iniciar sesión en vez de darse de alta -->
            <a href="<%= request.getContextPath() %>/iniciarsesion" class="btn btn-link">Iniciar Sesión</a>
          </div>
        </form>
      </div>
      
    </div>
  </main>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
    
    <script src="<%= request.getContextPath() %>/js/altaUsuario.js"></script>
    

</body>
</html>