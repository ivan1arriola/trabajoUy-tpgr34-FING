package controller;

import interfaces.ILogica;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.FabricaWeb;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/modificarusuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

 
    public static LocalDate convertirCadenaAFecha(String fechaEnCadena) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(fechaEnCadena, formatter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        
        String fechanacimiento = request.getParameter("fechanacimiento");
        String nacionalidad = request.getParameter("nacionalidad");
        String descripcion = request.getParameter("descripcion");
        String link = request.getParameter("link");

        ILogica logica = FabricaWeb.getLogica();
        
        try {
	        if(fechanacimiento != null && descripcion == null) {
	        	// es postulante
	        	LocalDate fecha = convertirCadenaAFecha(fechanacimiento);
	        	logica.ingresarDatosEditadosPostulanteImg(nickname, nombre, apellido, correo, password, null, fecha, nacionalidad);
	        } else if(fechanacimiento == null && descripcion != null) {
                logica.ingresarDatosEditadosEmpresaURLImg(nickname, nombre, apellido, correo, password, link, null, descripcion);
	        }
	        response.sendRedirect(request.getContextPath() + "/consultarusuario?u=" + nickname);
        } catch (Exception e) {
        	String mensajeError = "Ocurrió un error al actualizar los datos del usuario";
            request.setAttribute("mensajeError", mensajeError);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/errorPage.jsp");
            dispatcher.forward(request, response);
        }

        
        
		
	}

}
