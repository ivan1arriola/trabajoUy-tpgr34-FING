package utils;

import java.time.LocalDate;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import enumeration.Departamento;
import enumeration.EstadoOfertaLaboral;
import enumeration.TipoUsuario;
import interfaces.ILogica;
import javabeans.CantTipoPublicacionBean;
import javabeans.OfertaLaboralBean;
import javabeans.PaqueteBean;
import javabeans.PostulacionBean;
import javabeans.UsuarioBean;
import main.java.excepciones.ExcepcionKeywordVacia;
import main.java.excepciones.ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa;
import main.java.excepciones.ExceptionCompraPaqueteConValorNegativo;
import main.java.excepciones.ExceptionRemuneracionOfertaLaboralNegativa;
import main.java.excepciones.ExceptionUsuarioCorreoRepetido;
import main.java.excepciones.ExceptionUsuarioNickRepetido;
import main.java.excepciones.ExceptionUsuarioNickYCorreoRepetidos;
import main.java.excepciones.ExceptionValidezNegativa;
import main.java.logica.Fabrica;
import main.java.logica.datatypes.DTCantTO;
import main.java.logica.datatypes.DTEmpresa;
import main.java.logica.datatypes.DTHorario;
import main.java.logica.datatypes.DTOfertaExtendido;
import main.java.logica.datatypes.DTOfertaExtendidoConKeywordsPostulante;
import main.java.logica.datatypes.DTOfertaExtendidoConKeywordsTit;
import main.java.logica.datatypes.DTOfertaExtendidoSinPConK;
import main.java.logica.datatypes.DTPaquete;
import main.java.logica.datatypes.DTPostulacion;
import main.java.logica.datatypes.DTPostulante;
import main.java.logica.datatypes.DTUsuario;
import main.java.logica.enumerados.DepUY;
import main.java.logica.enumerados.EstadoOL;
import main.java.logica.interfaces.ICtrlOferta;
import main.java.logica.interfaces.ICtrlUsuario;

public class Logica implements ILogica {
	
	ICtrlOferta ctrlOferta;
	ICtrlUsuario ctrlUsuario;
	
	public Logica(){
		Fabrica fabrica = Fabrica.getInstance();
		ctrlOferta = fabrica.getICtrlOferta();
		ctrlUsuario = fabrica.getICtrlUsuario();
	}

	@Override
	public void cargarDatos() {
		try {
			Fabrica.getInstance().getICtrlCargaDeDatos().cargarDatos();
		} catch (ExcepcionKeywordVacia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionValidezNegativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean validarCredenciales(String identificador, String contraseña) {
		return ctrlUsuario.validarCredenciales(identificador, contraseña);
	}

	@Override
	public UsuarioBean obtenerDatosUsuario(String nickname) {
	    UsuarioBean usuario = new UsuarioBean();
	    try {
	        DTUsuario dtUsuario = Fabrica.getInstance().getICtrlUsuario().obtenerDatosUsuario(nickname);
	        usuario.setNickname(dtUsuario.getNickname());
	        usuario.setNombre(dtUsuario.getNombre());
	        usuario.setApellido(dtUsuario.getApellido());
	        usuario.setContrasenia(dtUsuario.getcontrasenia());
	        usuario.setCorreoElectronico(dtUsuario.getcorreoElectronico());
	        
	       
	        byte[] imagenBytes = dtUsuario.getImagen();
			String imagenString;
			if(imagenBytes != null) {
				imagenString = Base64.getEncoder().encodeToString(imagenBytes);
				imagenString = "data:image/png;base64," + imagenString;
				usuario.setImagen(imagenString);
			} else {
				usuario.setImagen(null);
			}
			
			
	        if(dtUsuario instanceof DTEmpresa) {
	        	DTEmpresa empresa = (DTEmpresa) dtUsuario;
	        	usuario.setDescripcion(empresa.getDescripcion());
	        	usuario.setUrl(empresa.getUrl());
	        	usuario.setTipo(TipoUsuario.Empresa);
	        } else {
	        	DTPostulante postulante = (DTPostulante) dtUsuario;
	        	usuario.setFechaNac(postulante.getFechaNac());
	        	usuario.setNacionalidad(postulante.getNacionalidad());
	        	usuario.setTipo(TipoUsuario.Postulante);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        usuario.setError("Se produjo un error al obtener los datos del usuario");
	    }
	    return usuario;
	}

	


	@Override
	public void modificarDatosUsuario(String nickname, UsuarioBean usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<UsuarioBean> listarUsuarios() {
    	 Set<String> nicknames = listarNicknamesUsuario();
         Set<UsuarioBean> usuarios = new HashSet<UsuarioBean>();
         for(String usuario : nicknames) {
         	usuarios.add(obtenerDatosUsuario(usuario));
         } 	
		return usuarios;
    	
    }

	@Override
	public Set<String> listarNicknamesUsuario() {
		return ctrlUsuario.listarNicknamesUsuarios();

	}

	@Override
	public Set<String> listarKeywords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> listarPaquetesDeEmpresa(String nickname) {
		return ctrlOferta.listarComprasPaquete(nickname);
	}
	


	@Override
	public Set<String> listarTipoDePublicaciones() {
		return ctrlOferta.listarTipoDePublicaciones();
	}

	@Override
	public void altaEmpresa(String nick, String contraseña, String nombre, String apellido, String mail, String desc, String URL) {
        Fabrica.getInstance().getICtrlUsuario().altaEmpresaURLyImagen(nick, contraseña, nombre, apellido, mail, desc, URL, null);
    }
	

	@Override
	public void altaPostulante(String nick, String contraseña, String nombre, String apellido, String mail, LocalDate fecha_nac, String nacionalidad) throws ExceptionUsuarioNickYCorreoRepetidos, ExceptionUsuarioNickRepetido, ExceptionUsuarioCorreoRepetido {
        Fabrica.getInstance().getICtrlUsuario().altaPostulante(nick, contraseña, nombre, apellido, mail, fecha_nac, nacionalidad);
    }

	@Override
	public void altaOfertaLaboral(String nickname_e, String tipo, String nombre, String descripcion, DTHorario horario,
			float remun, String ciu, Departamento dep, LocalDate fechaA, Set<String> keys, EstadoOfertaLaboral estado, String img,
			String paquete) {
		try {
			DepUY departamento = DepUY.values()[Departamento.valueOf(dep.toString()).ordinal()];
			EstadoOL estadoOL = EstadoOL.valueOf(estado.toString());
			ctrlOferta.altaOfertaLaboral(nickname_e, tipo, nombre, descripcion, horario, remun, ciu, departamento, fechaA, keys, estadoOL, null, paquete);
		} catch (ExceptionRemuneracionOfertaLaboralNegativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void compraPaquetes(String nickname, String paquete, LocalDate now, int valor) {
		try {
			ctrlOferta.compraPaquetes(nickname, paquete, now, valor);
		} catch (ExceptionCompraPaqueteConValorNegativo
				| ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public PaqueteBean obtenerDatosPaquete(String paquete) {
		DTPaquete dtPaquete = ctrlOferta.obtenerDatosPaquete(paquete);
		PaqueteBean paqueteBean = new PaqueteBean();
		paqueteBean.setCosto(dtPaquete.getCosto());
		paqueteBean.setDescripcion(dtPaquete.getDescripcion());
		paqueteBean.setDescuento(dtPaquete.getDescuento());
		paqueteBean.setFechaAlta(dtPaquete.getFechaAlta());
		
		byte[] imagenBytes = dtPaquete.getImagen();

		// Convierte la imagen en un string base64
		String imagenString = Base64.getEncoder().encodeToString(imagenBytes);

		// Agrega el encabezado de la imagen
		imagenString = "data:image/png;base64," + imagenString;
		
		paqueteBean.setImagen(imagenString);
		paqueteBean.setNombre(dtPaquete.getNombre());
		paqueteBean.setValidez(dtPaquete.getValidez());
		
		Set<CantTipoPublicacionBean> cantidades = new HashSet<CantTipoPublicacionBean>();
		
		Set<DTCantTO> dtCantidades = dtPaquete.getTiposDePub();
		
		for( DTCantTO cant : dtCantidades) {
			CantTipoPublicacionBean cantidadBean = new CantTipoPublicacionBean();
			
			cantidadBean.setCantidad(cant.getCantidad());
			cantidadBean.setNombre(cant.getNombre());
			
			cantidades.add(cantidadBean);
		}
		
		paqueteBean.setTiposDePub(cantidades);

		return paqueteBean;
	}

	@Override
	public Set<String> listarOfertasConfirmadasDeEmpresa(String nicknameParametro) {
		return ctrlOferta.listarOfertasLaboralesConfirmadas(nicknameParametro);
	}

	@Override
	public OfertaLaboralBean obtenerDatosOfertaLaboral(String nombreOferta) {
		OfertaLaboralBean ofertaLaboral = new OfertaLaboralBean();
		DTOfertaExtendido dtOferta = ctrlOferta.obtenerOfertaLaboral(nombreOferta);
		
		ofertaLaboral.setNombre(dtOferta.getNombre());
        ofertaLaboral.setDescripcion(dtOferta.getDescripcion());
        ofertaLaboral.setCiudad(dtOferta.getCiudad());
        ofertaLaboral.setCosto(dtOferta.getCosto());
        ofertaLaboral.setDepartamento(dtOferta.getDepartamento());
        ofertaLaboral.setFechaDeAlta(dtOferta.getFechaDeAlta());
        ofertaLaboral.setHorario(dtOferta.getHorario());
        
        byte[] imagenBytes = dtOferta.getImagen();

		// Convierte la imagen en un string base64
		String imagenString = Base64.getEncoder().encodeToString(imagenBytes);

		// Agrega el encabezado de la imagen
		imagenString = "data:image/png;base64," + imagenString;
		
		
        ofertaLaboral.setImagen(imagenString);
        ofertaLaboral.setRemuneracion(dtOferta.getRemuneracion());
        ofertaLaboral.setEstado(dtOferta.getEstado());
        ofertaLaboral.setNicknameEmpresa(dtOferta.getNicknameEmpresaPublicadora());
        
        
        DTOfertaExtendidoSinPConK nuevoDatos = ctrlOferta.infoOfertaLaboralVisitante(nombreOferta);
        ofertaLaboral.setKeywords(nuevoDatos.getKeywords());

        return ofertaLaboral;
	}

	@Override
	public Set<String> listarOfertasLaboralesDeEmpresa(String nicknameParametro) {
		Set<String> todasLasOfertas = ctrlOferta.listarTodasLasOfertasLaborales(nicknameParametro);
		return todasLasOfertas;
	}

	@Override
	public Set<String> listarPostulacionesDePostulante(String nicknameParametro) {
		
		return ctrlUsuario.listarPostulacionesPostulante(nicknameParametro);
	}

	@Override
	public PostulacionBean obtenerDatosPostulacion(String nombreOferta, String nicknameParametro) {
		PostulacionBean postulacion = new PostulacionBean();
		DTPostulacion dtPostulacion = ctrlUsuario.obtenerDatosPostulacionW(nicknameParametro, nombreOferta);
		
		postulacion.setCVitae(dtPostulacion.getcVitae());
		postulacion.setFecha(dtPostulacion.getFecha());
		postulacion.setMotivacion(dtPostulacion.getMotivacion());
		postulacion.setNombreOfertaLaboral(nombreOferta);
		postulacion.setNicknamePostulante(nicknameParametro);
		postulacion.setURLDocExtras(dtPostulacion.getuRLDocExtras());
		
		
		return postulacion;
	}

	
	

	@Override
	public OfertaLaboralBean cargarPostulantes(OfertaLaboralBean ofertaBean, String empresaNickname) throws Exception {
		
		// Verificar si el nombre de la oferta es nulo
	    String nombreOferta = ofertaBean.getNombre();
	    if (nombreOferta == null) {
	        throw new Exception("ofertaBean no tiene nombre");
	    }
		
		DTOfertaExtendidoSinPConK info = ctrlOferta.infoOfertaLaboralEmpresa(empresaNickname, nombreOferta);
	
		Set<String> nicknamesDePostulantes = null;
		
		if ( info instanceof DTOfertaExtendidoConKeywordsTit) {
			ofertaBean.setMostrarPostulantes(true);
			DTOfertaExtendidoConKeywordsTit masData = (DTOfertaExtendidoConKeywordsTit) info;
			nicknamesDePostulantes = masData.getpostulaciones();
		} else {
			ofertaBean.setMostrarPostulantes(false);
			return ofertaBean;
		}
		
		
		
		Set<UsuarioBean> postulantes = new HashSet<UsuarioBean>();
		
		for(String nickname : nicknamesDePostulantes ) {
			postulantes.add(this.obtenerDatosUsuario(nickname));	
		}
		
		ofertaBean.setPostulantes(postulantes);
		return ofertaBean;
	}

	
	
	
	@Override
	public OfertaLaboralBean cargarPaquete(OfertaLaboralBean ofertaBean, String empresaNickname) throws Exception {
	    // Verificar si el nombre de la oferta es nulo
	    String nombreOferta = ofertaBean.getNombre();
	    if (nombreOferta == null) {
	        throw new Exception("ofertaBean no tiene nombre");
	    }

	    // Obtener información de la oferta laboral de la empresa
	    DTOfertaExtendidoSinPConK info = ctrlOferta.infoOfertaLaboralEmpresa(empresaNickname, nombreOferta);

	    DTPaquete dtPaquete = null;

	    if (info instanceof DTOfertaExtendidoConKeywordsTit) {
	        // La oferta contiene un paquete
	        ofertaBean.setMostrarPaquete(true);
	        DTOfertaExtendidoConKeywordsTit masData = (DTOfertaExtendidoConKeywordsTit) info;
	        dtPaquete = masData.getPaquete();
	    } else {
	        // La oferta no contiene un paquete, se establece mostrarPaquete a falso y se retorna la oferta sin cambios
	        ofertaBean.setMostrarPaquete(false);
	        return ofertaBean;
	    }

	    // Obtener datos del paquete
	    PaqueteBean paquete = this.obtenerDatosPaquete(dtPaquete.getNombre());

	    ofertaBean.setPaquete(paquete);
	    return ofertaBean;
	}

	@Override
	public OfertaLaboralBean cargarDatosDePostulante(OfertaLaboralBean ofertaBean, String postulanteNickname)
	        throws Exception {
	    // Verificar si el nombre de la oferta es nulo
	    String nombreOferta = ofertaBean.getNombre();
	    if (nombreOferta == null) {
	        throw new Exception("ofertaBean no tiene nombre");
	    }

	    // Obtener nuevos datos de la oferta para el postulante
	    DTOfertaExtendidoSinPConK nuevoDatos = ctrlOferta.infoOfertaLaboralPostulante(postulanteNickname, nombreOferta);
	    Set<UsuarioBean> postulantes = new HashSet<UsuarioBean>();

	    if (nuevoDatos instanceof DTOfertaExtendidoConKeywordsPostulante) {
	        // Si la oferta contiene información de postulantes
	        DTOfertaExtendidoConKeywordsPostulante conPostulantes = (DTOfertaExtendidoConKeywordsPostulante) nuevoDatos;
	        DTPostulacion postulacion = conPostulantes.getDatosPostulacion();
	        String nicknamePostulante = postulacion.getPostulante();

	        // Obtener información del postulante y agregarlo al conjunto de postulantes
	        postulantes.add(this.obtenerDatosUsuario(nicknamePostulante));
	    }

	    // Establecer el conjunto de postulantes en la oferta
	    ofertaBean.setPostulantes(postulantes);

	    return ofertaBean;
	}

	@Override
	public Set<OfertaLaboralBean> listarDatosOfertas() {
		Set<DTOfertaExtendido> dtOfertas = ctrlOferta.listarOfertasLaboralesConfirmadas();
		Set<OfertaLaboralBean> ofertasLaborales = new HashSet<OfertaLaboralBean>();
		for (DTOfertaExtendido dtoferta: dtOfertas) {
			ofertasLaborales.add(this.obtenerDatosOfertaLaboral(dtoferta.getNombre()));
		}
		return ofertasLaborales;
	}

	@Override
	public Set<OfertaLaboralBean> buscarOfertasPorKeyword(String keyword) {
		Set<String> ofertas = (HashSet<String>) ctrlOferta.listarOfertasLaboralesKeywords(keyword);
		
		if(ofertas.isEmpty()) {
    		return null;
    	}
    	
    	Set<OfertaLaboralBean> dtOfertas = new HashSet<OfertaLaboralBean>();
    	
    	for( String nombreOferta : ofertas) {
    		OfertaLaboralBean dtOferta = this.obtenerDatosOfertaLaboral(nombreOferta);
    		dtOfertas.add(dtOferta);
    	}
    	
    	
		return dtOfertas;
	}

	@Override
	public Set<OfertaLaboralBean> buscarOfertasPorInput(String consulta) {
		Set<String> ofertas = (HashSet<String>) ctrlOferta.listarOfertasLaboralesConfirmadas(consulta);
    	
    	if(ofertas.isEmpty()) {
    		return null;
    	}
    	
    	Set<OfertaLaboralBean> dtOfertas = new HashSet<OfertaLaboralBean>();
    	
    	for( String nombreOferta : ofertas) {
    		OfertaLaboralBean dtOferta = this.obtenerDatosOfertaLaboral(nombreOferta);
    		dtOfertas.add(dtOferta);
    	}
    	
    	
		return dtOfertas;	
	}


	
	

}
