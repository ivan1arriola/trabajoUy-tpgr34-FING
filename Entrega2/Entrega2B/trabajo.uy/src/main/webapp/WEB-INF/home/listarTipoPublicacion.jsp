<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sin-bordes">
            <div class="row">
              <div class="col-md-6">
                <div class="card mb-3">
                  <div class="card-body">
                    <h5 class="card-title">Premium</h5>
                    <p class="card-text">Obtén máxima visibilidad</p>
                    <a href="<%= request.getContextPath() %>/consultartipopublicacion?tp=Premium" class="card-link">Leer más</a>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="card mb-3">
                  <div class="card-body">
                    <h5 class="card-title">Destacada</h5>
                    <p class="card-text">Destaca tu anuncio</p>
                    <a href="<%= request.getContextPath() %>/consultartipopublicacion?tp=Destacada" class="card-link">Leer más</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="card mb-3">
                  <div class="card-body">
                    <h5 class="card-title">Estándar</h5>
                    <p class="card-text">Mejora la posición de tu anuncio</p>
                    <a href="<%= request.getContextPath() %>/consultartipopublicacion?tp=Estandar" class="card-link">Leer más</a>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="card mb-3">
                  <div class="card-body">
                    <h5 class="card-title">Básica</h5>
                    <p class="card-text">
                      Publica de forma sencilla en la lista de ofertas
                    </p>
                    <a href="<%= request.getContextPath() %>/consultartipopublicacion?tp=Basica" class="card-link">Leer más</a>
                  </div>
                </div>
              </div>
            </div>
          </div>