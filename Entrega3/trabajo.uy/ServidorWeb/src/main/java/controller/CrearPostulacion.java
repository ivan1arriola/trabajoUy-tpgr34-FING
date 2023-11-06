package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

import interfaces.ILogica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import javabeans.OfertaLaboralBean;
import javabeans.UsuarioBean;
import logica.servidor.ExceptionUsuarioNoEncontrado_Exception;
import logica.servidor.OfertaLaboralNoEncontrada_Exception;
import utils.FabricaWeb;



@WebServlet("/crearpostulacion")
public class CrearPostulacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILogica logica;
    public CrearPostulacion() {
        logica = FabricaWeb.getLogica();
    }


	protected void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FabricaWeb.getKeywordsLoader().cargarKeywords(request, response);

		HttpSession session = request.getSession(false);
		String nickname = (String) session.getAttribute("nickname");
		UsuarioBean usuario = logica.obtenerDatosUsuario(nickname);

		String nombreOferta = request.getParameter("id");
		OfertaLaboralBean oferta = null;
		try {
			oferta = logica.obtenerDatosOfertaLaboral(nombreOferta);
			if (oferta.getImagen() != null) {
				request.setAttribute("imagenOferta", oferta.getImagen());
			}
		} catch (OfertaLaboralNoEncontrada_Exception e) {

			throw new RuntimeException(e);
		}


		String postulante = usuario.getNombre() + " " + usuario.getApellido();

		request.setAttribute("postulante", postulante);
		request.setAttribute("oferta", nombreOferta);


		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/crearPostulacion/crearPostulacion.jsp");
        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String cvAbrev = request.getParameter("cvAbreviado");
		String motiv = request.getParameter("motivacion");
		HttpSession session = request.getSession(false);
		String nickname = (String) session.getAttribute("nickname");
		String nombreOferta = request.getParameter("nombreOferta");
		String videoYouTube = request.getParameter("videoYouTube");

			logica.altaPostulacion(nombreOferta, nickname,  cvAbrev,  motiv, "", LocalDate.now(), videoYouTube);
			response.sendRedirect(request.getContextPath() + "/ofertaslaborales");
		} catch (ExceptionUsuarioNoEncontrado_Exception | OfertaLaboralNoEncontrada_Exception e) {
			throw new RuntimeException(e);
		}

	}

}
