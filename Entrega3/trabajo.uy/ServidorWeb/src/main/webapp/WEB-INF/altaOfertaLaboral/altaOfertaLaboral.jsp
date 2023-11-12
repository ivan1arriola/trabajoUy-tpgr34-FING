<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page import="javabeans.CantTipoPublicacionBean"%>

<%

		Set<String> keys = (Set<String>) request.getAttribute("keys");

		Set<String> tipoPublicaciones = (Set<String>) request.getAttribute("tipoPublicaciones");
		
		Set<String> paquetes = (Set<String>) request.getAttribute("paquetes");
%>

    <!DOCTYPE html>
    <html>

    <head>
        <jsp:include page="/WEB-INF/templates/head.jsp" />
        <title>Alta Oferta Laboral</title>
    </head>

    <body>
        <header>
            <jsp:include page="/WEB-INF/templates/header.jsp" />
        </header>

        <main class="container-fluid d-flex">
            <div class="container col-3">
            	<jsp:include page="/WEB-INF/templates/sidebar.jsp" />

            </div>

            <div class="container col-9">
            
             <div class="container container col-9">
      <div class="mx-5">
        <h2 class="mb-4">Publicar Oferta Laboral</h2>

        
		<form class="form-signin needs-validation" novalidate  action="AltaOfertaLaboral" method="POST" enctype="multipart/form-data">

          <div class="col-12 row mb-2">
            <div class="col-4">
              <label for="nombre" class="form-label">Nombre</label>
            </div>
            <div class="col-8">
	             <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" required/>
	             <div class="invalid-feedback">
	             No puede ser vacio
            </div>
            </div>
          </div>

          <div class="col-12 row mb-2">
            <div class="col-4">
              <label for="descripcion" class="form-label">Descripción</label>
            </div>
            <div class="col-8">
              <textarea class="form-control" id="descripcion" name="descripcion" placeholder="Descripción" rows="5" required></textarea>
            <div class="invalid-feedback">
              No puede ser vacio
            </div>
            </div>
          </div>

          <div class="col-12 row mb-2">
            <div class="col-4">
              <label class="form-label">Horas</label>
            </div>
            <div class="col-8">
              <div class="d-flex">
                <div class="me-2">
                  <label for="horaInicio">Hora de Comienzo:</label>
                  <input type="time" id="horaInicio" name="horaInicio" required/>
                  <div class="invalid-feedback">
              No puede ser vacio
            </div>
                </div>
                <div>
                  <label for="horaFinal">Hora de Final:</label>
                  <input type="time" id="horaFinal" name="horaFinal" required />
                  <div class="invalid-feedback">
              No puede ser vacio
            </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-12 row mb-2">
            <div class="col-4">
              <label for="remuneracion" class="form-label">Remuneracion</label>
            </div>
            <div class="col-8">
              <input type="number" class="form-control" id="remuneracion" name="remuneracion" required placeholder="Remuneracion" min=0 />
            	<div class="invalid-feedback">
              No puede ser vacio y debe ser mayor a 0
            </div>
            </div>
          </div>

          <div class="col-12 row mb-2">
            <div class="col-4">
              <label for="listadoDepartamentos" class="form-label">Departamento</label>
            </div>
            <div class="col-8">
              <select class="form-control custom-select-validation" id="listadoDepartamentos" name="departamento" required>
                <option value="Artigas" selected>Artigas</option>
                <option value="Canelones">Canelones</option>
                <option value="Cerro Largo">Cerro Largo</option>
                <option value="Colonia">Colonia</option>
                <option value="Durazno">Durazno</option>
                <option value="Flores">Flores</option>
                <option value="Florida">Florida</option>
                <option value="Lavalleja">Lavalleja</option>
                <option value="Maldonado">Maldonado</option>
                <option value="Montevideo">Montevideo</option>
                <option value="Paysandú">Paysandú</option>
                <option value="Río Negro">Río Negro</option>
                <option value="Rivera">Rivera</option>
                <option value="Rocha">Rocha</option>
                <option value="Salto">Salto</option>
                <option value="San José">San José</option>
                <option value="Soriano">Soriano</option>
                <option value="Tacuarembó">Tacuarembó</option>
                <option value="Treinta y Tres">Treinta y Tres</option>
              </select>
          	</div>
          </div>

          <div class="col-12 row mb-2">
            <div class="col-4">
              <label for="ciudad" class="form-label mt-1">Ciudad</label>
            </div>
            <div class="col-8">
              <input type="text" class="form-control mt-1" id="ciudad" name="ciudad" placeholder="Ciudad" required />
              <div class="invalid-feedback">
              No puede ser vacio
            </div>
            </div>
          </div>



          <div class="col-12 row mb-2">
            <div class="col-4">
              <label for="listadoPaq" class="form-label">Pago</label>
            </div>
            <div class="col-8">
              <select class="form-control custom-select-validation" id="listadoPagos" name="formaPago" required>
                <option value="1" selected>Pagar Sin Paquete</option>
              
              <%
                if (paquetes != null && !paquetes.isEmpty()){  
                  	for(String paquete : paquetes ){
                %>
                <option value="<%= paquete %>">
                  <%= paquete %>
                </option>
                <%	}
               } %>
              
              </select>
            </div>
          </div>
          
          
          
          <div class="col-12 row mb-2">
            <div class="col-4">
              <label for="listadoOfert" class="form-label">Listado de Tipo de Oferta</label>
            </div>
            <div class="col-8" id="LOG" >
              <select class="form-control custom-select-validation" id="listadoOfertasGeneral" name="tipoOferta" required>
                <%
                
				for(String tipo : tipoPublicaciones ){
                %>
                <option value="<%= tipo %>">
                  <%= tipo %>
                </option>
                <%	}
					%>
              </select>
              <div class="invalid-feedback">
                Selecciona un elemento de la lista
              </div>
            </div>
            <div class="col-8" id="LOP">
              <select class="form-control custom-select-validation" id="listadoOfertasParticular" name="tipoOfertaPart" required>
              </select>
              <div class="invalid-feedback">
                Selecciona un elemento de la lista
              </div>
            </div>
          </div>

          <div class="col-12 row mb-2">
			    <div class="col-4">
			        <label for="listadoKeywords" class="form-label">Keywords</label>
			    </div>
			    <div class="col-8">
			        <div id="keywordSelect" class="form-check form-check-inline">
			            <% if (keys != null && !keys.isEmpty()) {
			                for (String key : keys) { %>
			                <div>
                        <label class="form-check-label" for="keyword_<%= key %>"><%= key %></label>
                        <input type="checkbox" name="keywords[]" value="<%= key %>" class="form-check-input" id="keyword_<%= key %>">
			                </div>
			                <% }
			            } %>
			        </div>
			    </div>
			</div>
			
		  <!-- Sección de Imagen de Perfil -->
          <section>
              <h2 class="h4">Imagen de Perfil</h2>

              <div class="form-group mb-3 " id="div-image-input">
                  <label for="image-input">Subir una imagen de la Oferta Laboral (max 250 KB)</label>
                  <input type="file" class="form-control" id="image-input" name="imagen" accept=".jpg" />
                  <div class="invalid-feedback" id="image-invalid-feedback">
                      La imagen no debe superar el tamaño máximo permitido de 250 KB.
                  </div>
              </div>
          </section>
		  
		    <div class="col-12 row mb-2">
		        <!-- Agrega un identificador único al botón para poder referenciarlo desde JavaScript -->
		        <button id="btnAceptar" class="btn btn-primary">Aceptar</button>
		    </div>
         
        </form>
      </div>
    </div>
    
    

            

                

            </div>
        </main>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
         <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	
            
            <!-- Otros scripts aqui -->
            
   	
   	<script src="<%= request.getContextPath() %>/js/altaOfertaLaboral.js"></script>

    		  <script>
			  $(document).ready(function() {
				$("#LOP").hide();
			    // Agregar un evento de cambio al campo select
			    $("#listadoPagos").change(function() {
			      // Obtener el valor seleccionado
			      var selectedValue = $(this).val();
			      
			      // Mostrar u ocultar el elemento según la selección
			      if (selectedValue === "1") {
			    	  $("#LOP").hide();
			        $("#LOG").show();
			      } else {
			    	$("#LOG").hide();
			    	$.ajax({
			            url: '<%= request.getContextPath() %>/ajaxaltaofertalaboral',  // Especifica la URL del servidor aquí
			            type: 'GET',
			            data: { selectedValue: selectedValue },
			            success: function(conjunto) {
			            	console.log(conjunto);
			                // Llenar el segundo listado con las opciones del conjunto
			                var listadoOfertasParticular = $("#listadoOfertasParticular");
			                listadoOfertasParticular.empty(); // Limpiar las opciones actuales

			                // Agregar las nuevas opciones al segundo listado
			                for (var i = 0; i < conjunto.length; i++) {
			                	listadoOfertasParticular.append($('<option>', {
			                        value: conjunto[i],
			                        text: conjunto[i]
			                    }));
			                }
			            },
			            error: function() {
			                console.log('Error al obtener conjunto vinculado');
			            }
			        });
			        $("#LOP").show();
			      }
			    });
			  });
			</script>
            
    </body>

    </html>