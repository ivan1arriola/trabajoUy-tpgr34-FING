package main.test;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import excepciones.ErrorAgregarUsuario;
import excepciones.ExcepcionKeywordVacia;
import excepciones.ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa;
import excepciones.ExceptionCiudadInvalida;
import excepciones.ExceptionCostoPaqueteNoNegativo;
import excepciones.ExceptionDescuentoInvalido;
import excepciones.ExceptionDuracionNegativa;
import excepciones.ExceptionEmpresaInvalida;
import excepciones.ExceptionExpoNegativa;
import excepciones.ExceptionFechaInvalida;
import excepciones.ExceptionPaqueteNoVigente;
import excepciones.ExceptionRemuneracionOfertaLaboralNegativa;
import excepciones.ExceptionUsuarioNoEncontrado;
import excepciones.ExceptionUsuarioSeSigueASiMismo;
import excepciones.ExceptionValidezNegativa;
import excepciones.ExisteOrdenFinalDePostulantes;
import excepciones.FinalizarOfertaNoVencida;
import excepciones.OfertaLaboralNoEncontrada;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import logica.Fabrica;
import logica.clases.Empresa;
import logica.clases.InfoCompra;
import logica.clases.InfoCompraOferta;
import logica.clases.Keyword;
import logica.clases.OfertaLaboral;
import logica.clases.OfertaPaquete;
import logica.clases.Paquete;
import logica.clases.Postulacion;
import logica.clases.Postulante;
import logica.clases.TipoOferta;
import logica.controladores.CtrlCargaDeDatos;
import logica.datatypes.DTCantTO;
import logica.datatypes.DTHora;
import logica.datatypes.DTHorario;
import logica.datatypes.DTOfertaExtendidoConKeywordsPostulante;
import logica.datatypes.DTUsuario;
import logica.enumerados.DepUY;
import logica.enumerados.EstadoOL;
import logica.interfaces.ICtrlOferta;
import logica.interfaces.ICtrlUsuario;
import logica.manejadores.KeywordHandler;
import logica.manejadores.OfertaLaboralHandler;
import logica.manejadores.PaqueteHandler;
import logica.manejadores.TipoOfertaHandler;
import logica.manejadores.UsuarioHandler;


public class TestGeneral11 {
	@Test
	public void Test1() {
		Fabrica fabri = Fabrica.getInstance();
        ICtrlUsuario ICU = fabri.getICtrlUsuario();
        ICtrlOferta ICO = fabri.getICtrlOferta();
        CtrlCargaDeDatos ICC = fabri.getICtrlCargaDeDatos();
        // obtener handeler
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TrabajoUy");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Set the EntityManager for the handlers
        KeywordHandler.setBaseDatos(entityManager);
        KeywordHandler keywordHandler = KeywordHandler.getInstance();
        OfertaLaboralHandler.setBaseDatos(entityManager);
        PaqueteHandler.setBaseDatos(entityManager);
        TipoOfertaHandler.setBaseDatos(entityManager);
        UsuarioHandler.setBaseDatos(entityManager);
        // ============================================
        System.out.println("################## Test 11 ##################");
        // ============================================
        // 88888888888888888888888888888888888888888888888888888888888888888888888
        String imagen ="hola";
        // -------------------------------------------
        float randomFloat = 10.0f;
        // -------------------------------------------
        LocalDate currentDate = LocalDate.now(); // Get the current date
        LocalDate SixDaysAgo = currentDate.minusDays(6); 
        LocalDate SevenDaysAgo = currentDate.minusDays(7); 
        // -------------------------------------------
        Paquete NuevoPaq = null;
		try {
			NuevoPaq = new  Paquete(
				    "Manwqeuete", 
				    "cremosa como nunca", 
				    900, 
				    SixDaysAgo, 
				    randomFloat, 
				    imagen.getBytes()
				);
		} catch (ExceptionValidezNegativa | ExceptionDescuentoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        Empresa empresaNueva = new Empresa(
				    "Hidraqwerqweroocs", 
				    "Fierro-motors", 
				    "Le_bron-james", 
				    "El@correo.com", 
				    "1231254", 
				    "hola".getBytes(), 
				    "mejores biciclertas y motos", 
				    "www.motos.com"
				);
        
        // ===============================
        // lista de keywords
        List<Keyword> myList = new ArrayList<>();
        Map<String,  Keyword> nuevaKeyword = KeywordHandler.obtener();
        String keywordToObtain = "Trabajo nocturno";
        Keyword utopicKeyword = nuevaKeyword.get(keywordToObtain);
        String keywordToObtain1 = "full time";
        Keyword utopicKeyword1 = nuevaKeyword.get(keywordToObtain1);
        myList.add(utopicKeyword);
        myList.add(utopicKeyword1);
        // -------------------------------------------
        TipoOferta tipoofertaNuevo = null;
		try {
			tipoofertaNuevo = new TipoOferta(
				    "dentro Paquete manteca", 
				    SevenDaysAgo, 
				    randomFloat, 
				    300, 
				    300, 
				    "es la sorpresa dentro manteca"
				);
		} catch (ExceptionCostoPaqueteNoNegativo | ExceptionDuracionNegativa | ExceptionExpoNegativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// ======================================================================
		// paquete ---> oferta paquete ---> TipoOferta
		OfertaPaquete OfertaPaqueteNueva = null;
		try {
			OfertaPaqueteNueva = new OfertaPaquete(tipoofertaNuevo, 44);
		} catch (ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ======================================================================
        float randomFloat1 = 100.0f;
        // -------------------------------------------
        DepUY dep111 = DepUY.Montevideo;
        // -------------------------------------------
        LocalDate currentDate11 = LocalDate.now(); // Get the current date
        LocalDate threeDaysAgo = currentDate11.minusDays(3); // Subtract 3 days
        LocalDate twoDaysAgo = currentDate11.minusDays(2); // Subtract 3 days
        // -------------------------------------------
        EstadoOL nunevoestado = EstadoOL.Confirmada;
        // -------------------------------------------
        DTHora hora12 = new DTHora(8,  0);
        DTHora hora22 = new DTHora(1,  0);
        DTHorario horario2 = new DTHorario(hora12,  hora22);
        // -------------------------------------------
        String imagen1 ="hola";
        // crear oferta laboral
        OfertaLaboral OfertaLabolra = null;
		try {
			OfertaLabolra = new OfertaLaboral(
					true, 
			        empresaNueva, 
			        myList, 
			        tipoofertaNuevo, 
			        "Panawfewefawfwafes", 
			        "muy esponjosos", 
			        "panquequeLandia", 
			        dep111, 
			        horario2, 
			        randomFloat1, 
			        threeDaysAgo, 
			        nunevoestado, 
			        imagen1.getBytes(), 
			        NuevoPaq);
		} catch (ExceptionRemuneracionOfertaLaboralNegativa | ExceptionPaqueteNoVigente
				| ExceptionCostoPaqueteNoNegativo | ExceptionDescuentoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // 88888888888888888888888888888888888888888888888888888888888888888888888
//		try {
//			ICO.DevolverOrdenFinal(OfertaLabolra.getNombre());
//		} catch (ExceptionUsuarioNoEncontrado e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			ICO.HayOrdenFinal(OfertaLabolra.getNombre());
//		} catch (ExceptionUsuarioNoEncontrado e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			ICO.establecerPosiciones(OfertaLabolra.getNombre(), nickList);
//		} catch (ExceptionUsuarioNoEncontrado | OfertaLaboralNoEncontrada | ExisteOrdenFinalDePostulantes e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			ICO.listarPaquetesNoVencidos(empresaNueva.getNickname());
//		} catch (ExceptionEmpresaInvalida | ExceptionUsuarioNoEncontrado e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		// ============================================
        entityManager.close();
        entityManagerFactory.close();
	}
}
