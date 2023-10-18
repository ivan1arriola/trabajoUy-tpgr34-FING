package main.java.logica.clases;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import main.java.excepciones.ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa;
import main.java.excepciones.ExceptionCompraPaqueteConValorNegativo;
import main.java.excepciones.ExceptionCostoPaqueteNoNegativo;
import main.java.excepciones.ExceptionDescuentoInvalido;
import main.java.excepciones.ExceptionPaqueteNoVigente;
import main.java.excepciones.ExceptionRemuneracionOfertaLaboralNegativa;
import main.java.logica.datatypes.DTCantTO;
import main.java.logica.datatypes.DTEmpresa;
import main.java.logica.datatypes.DTHorario;
import main.java.logica.datatypes.DTOfertaExtendido;
import main.java.logica.datatypes.DTUsuario;
import main.java.logica.enumerados.DepUY;
import main.java.logica.enumerados.EstadoOL;


public class Empresa extends Usuario {

    private String descripcion;
    private String url;
    private Set<OfertaLaboral> ofertasLaborales;
    private Set<InfoCompra> infoCompras;
    
    public Set<InfoCompra> getInfoCompmras(){
    	return this.infoCompras;
    }
    
    // constructor empresa con imagen y url 
    public Empresa(String nickname,  String nombre,  String apellido,  String correo_electronico,  String contrasena,  String img,  String desc,  String urlE) {
        super(nickname,  nombre,  apellido,  correo_electronico,  contrasena,  img);
        descripcion = desc;
        ofertasLaborales = new HashSet<>();
        infoCompras = new HashSet<>();
        url = urlE;
    }

    // constructor empresa con url sin imagen 
    public Empresa(String nickname,  String nombre,  String apellido,  String correo_electronico,  String contrasena,  String desc,  String urlE) {
        super(nickname,  nombre,  apellido,  correo_electronico,  contrasena);
        descripcion = desc;
        ofertasLaborales = new HashSet<>();
        infoCompras = new HashSet<>();
        url = urlE;
    }

    // constructor empresa sin imagen ni url 
    public Empresa(String nickname,  String nombre,  String apellido,  String correo_electronico,  String contrasena,  String desc) {
        super(nickname,  nombre,  apellido,  correo_electronico,  contrasena);
        descripcion = desc;
        ofertasLaborales = new HashSet<>();
        infoCompras = new HashSet<>();
        url = null;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String urlE) {
        this.url = urlE;
    }

    public Set<String> listarOfertasLaborales(){
        Set<String> lista = new HashSet<String>();
        
        if (ofertasLaborales.size() != 0) {
	        for (OfertaLaboral ol : ofertasLaborales){
	            lista.add(ol.getNombre());
	        }
        }

        return lista;
    }
    
    @Override
    public boolean esEmpresa() {
        return true;
    }

    public OfertaLaboral altaOfertaLaboral(TipoOferta tipoOferta,  String nombre,  String descripcion,  DTHorario horario,  float remun,  String ciu,  DepUY dep,  LocalDate fechaA,  List<Keyword> atrkeywords,  EstadoOL estado,  String img,  Paquete paq) throws ExceptionRemuneracionOfertaLaboralNegativa, ExceptionPaqueteNoVigente, ExceptionCostoPaqueteNoNegativo, ExceptionDescuentoInvalido,ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa{
    	try {
	    	if (remun >= 0) {
	        	OfertaLaboral ofertaLab = new OfertaLaboral(this, atrkeywords,  tipoOferta,  nombre,  descripcion,  ciu,  dep,  horario,  remun,  fechaA,  estado, img, paq);
	            ofertasLaborales.add(ofertaLab);
	            
	            if(paq!=null) { //actualiza cantidad del tipo Oferta
	            	Set<OfertaPaquete> restantes =paq.getOfertaPaquete();
	               	
			    	for (OfertaPaquete offer : restantes) {

					    if (offer.getDTCantTO().getNombre().equals(tipoOferta.getNombre())) {
					        int cantidadAsociada = offer.getDTCantTO().getCantidad();
					        
					        if ( cantidadAsociada >=1 ) { 
					        	
					        	cantidadAsociada = cantidadAsociada-1;
					        	OfertaPaquete oferPaq = new OfertaPaquete(tipoOferta,  cantidadAsociada);
					           	restantes.remove(offer);
					        	restantes.add(oferPaq);
					        }
					 }
				} //cierra for
	            	
	            	
	            	
	            }
	            
	            return ofertaLab;
	    	}
	    	else {
	    		throw new ExceptionRemuneracionOfertaLaboralNegativa("La remuneración de la oferta laboral es negativa.");
	    	}
    	} catch (ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa exc) {
    		throw exc;
    		
    	}

    }
    
    public OfertaLaboral altaOfertaLaboralForzado(TipoOferta tipoOferta,  String nombre,  String descripcion,  DTHorario horario,  float remun,  String ciu,  DepUY dep,  LocalDate fechaA,  List<Keyword> atrkeywords,  EstadoOL estado,  String img,  Paquete paq) throws ExceptionRemuneracionOfertaLaboralNegativa, ExceptionPaqueteNoVigente, ExceptionCostoPaqueteNoNegativo, ExceptionDescuentoInvalido{
    	if(remun >= 0) {
        	OfertaLaboral ofertaLab = new OfertaLaboral(true, this, atrkeywords,  tipoOferta,  nombre,  descripcion,  ciu,  dep,  horario,  remun,  fechaA,  estado, img, paq);
            ofertasLaborales.add(ofertaLab);
            return ofertaLab;
    	}
    	else {
    		throw new ExceptionRemuneracionOfertaLaboralNegativa("La remuneración de la oferta laboral es negativa.");
    	} 

    }

    
    public OfertaLaboral altaOfertaLaboralImagen(TipoOferta tipo,  String nombre,  String descripcion,  DTHorario horario,  float remun,  String ciu,  DepUY dep,  LocalDate fechaA,  List<Keyword> keyw,  EstadoOL estado,  String img) throws ExceptionRemuneracionOfertaLaboralNegativa, ExceptionPaqueteNoVigente, ExceptionCostoPaqueteNoNegativo, ExceptionDescuentoInvalido,ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa {
	   try {	
    	if (remun >= 0) {
		    	OfertaLaboral ofertaLab = new OfertaLaboral(this, keyw,  tipo,  nombre,  descripcion,  ciu,  dep,  horario,  remun,  fechaA,  estado,  img);
		    	ofertasLaborales.add(ofertaLab);
		    	return ofertaLab;
	    	}
	    	else {
	    		throw new ExceptionRemuneracionOfertaLaboralNegativa("La remuneración de la oferta laboral es negativa.");
	    	}
    	
	    } catch (ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa exc) {
			throw exc;
			
		}
    }
    
    public OfertaLaboral altaOfertaLaboralImagenPaquete(TipoOferta tipo,  String nombre,  String descripcion,  DTHorario horario,  float remun,  String ciu,  DepUY dep,  LocalDate fechaA,  List<Keyword> keyw,  EstadoOL estado,  String img,  Paquete paquete) throws ExceptionRemuneracionOfertaLaboralNegativa, ExceptionPaqueteNoVigente, ExceptionCostoPaqueteNoNegativo, ExceptionDescuentoInvalido,ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa {
	   try {	
    	if (remun >= 0) {
	    		OfertaLaboral ofertaLab = new OfertaLaboral(this, keyw,  tipo,  nombre,  descripcion,  ciu,  dep,  horario,  remun,  fechaA,  estado,  img,  paquete);
		    	ofertasLaborales.add(ofertaLab);
		    	return ofertaLab;
	    	}
	    	else {
	    		throw new ExceptionRemuneracionOfertaLaboralNegativa("La remuneración de la oferta laboral es negativa.");
	    	}
    } catch (ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa exc) {
		throw exc;
		
	}
    }
    
    public DTUsuario obtenerDatosUsuario() { // obtenerDatosUsuario(): DTUsuario
    	String nickname =  getNickname();
    	String nombre = getNombre();
        String apellido = getApellido();
        String correoElectronico = getcorreoElectronico();
        String contraseña = getcontrasenia();
        String descripcion = getDescripcion();
        String url = geturl();
        String imagen = getImagen();
        			       
        Set<DTOfertaExtendido> dtOfertas = new HashSet<DTOfertaExtendido>();
        
        for (OfertaLaboral oferta : ofertasLaborales) {
        	DTOfertaExtendido dtOferta = oferta.obtenerDatosOferta();
            dtOfertas.add(dtOferta);   
        }
        
        return new DTEmpresa(nickname,  correoElectronico,  apellido,  nombre,  contraseña,  descripcion,  url,  dtOfertas,  imagen);
        
    }
    
    public Set<String> listarOfertasLaboralesConfirmadas(){
    	Set<String> res = new HashSet<String>();
        Iterator<OfertaLaboral> iterator = ofertasLaborales.iterator();

        // Recorremos el HashSet usando el Iterator
        while (iterator.hasNext()) {
            OfertaLaboral ofertaLab = iterator.next();
            if (ofertaLab.getEstado() == EstadoOL.Confirmada) {
            	res.add(ofertaLab.getNombre());
            }
        }
        return res;
    }
    
    public Set<String> listarOfertasLaboralesConfirmadasKeyword(String keywords){
    	Set<String> res = new HashSet<String>();
        Iterator<OfertaLaboral> iterator = ofertasLaborales.iterator();

        // Recorremos el HashSet usando el Iterator
        while (iterator.hasNext()) {
            OfertaLaboral ofertaLab = iterator.next();
            if (ofertaLab.getEstado() == EstadoOL.Confirmada && ofertaLab.tieneKeyword(keywords)) {
            	res.add(ofertaLab.getNombre());
            }
        }
        return res;
    }
    
    public Set<String> listarOfertasLaboralesIngresadas(){
    	Set<String> res = new HashSet<String>();
        Iterator<OfertaLaboral> iterator = ofertasLaborales.iterator();

        // Recorremos el HashSet usando el Iterator
        while (iterator.hasNext()) {
            OfertaLaboral ofertaLab = iterator.next();
            if (ofertaLab.getEstado() == EstadoOL.Ingresada) {
            	res.add(ofertaLab.getNombre());
            }
        }
        return res;
    }
    
    public boolean existeOfertaLaboral(String nombre_oferta) {
        Iterator<OfertaLaboral> iterator = ofertasLaborales.iterator();

        // Recorremos el HashSet usando el Iterator
        while (iterator.hasNext()) {
            OfertaLaboral ofertaLab = iterator.next();
            if (ofertaLab.getNombre().equals(nombre_oferta)) {
            	return true;
            }
        }
        
    	return false;
    }
    
    public boolean tieneURL() {
    	return url != null;
    }
    
    public boolean compraPaquetes(Paquete paq, LocalDate fecha, int valor) throws ExceptionCompraPaqueteConValorNegativo, ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa {
    	if (valor >= 0) {
	        for (InfoCompra ic : infoCompras) {
	        	if ((ic.getPaquete()).getNombre().equals(paq.getNombre())) {
	        		return false;
	        	}
	        }
	    	float costo = paq.getCosto();
	    	LocalDate fechaA = paq.getfechaAlta();
	    	// int val = paq.getValidez();
	    	Set<DTCantTO> ConjuntoS = paq.obtenerDTSCantTO();
	    	
	    	InfoCompra infoComp = new InfoCompra(fecha,  valor,  paq,  this,  ConjuntoS);
	    	infoCompras.add(infoComp);
	    	return true;    		
    	}
    	else {
    		throw new ExceptionCompraPaqueteConValorNegativo("El valor de la compra de un paquete no puede ser negativo.");
    	}

    }

	@Override
    // corregido,  se pasan mas parametros para la ejecucion
    public DTUsuario obtenerDatosUsuarioEspecial(String UsuarioRegistradoActual,  String UsuarioQueSeHaceConsulta) {
		DTEmpresa empre;
		if (UsuarioRegistradoActual.equals(UsuarioQueSeHaceConsulta)) {
            String nickname =  getNickname();
            String nombre = getNombre();
            String apellido = getApellido();
            String correoElectronico = getcorreoElectronico();
            String contraseña = getcontrasenia();
            String imagen = getImagen(); 
            Set<DTOfertaExtendido> dtOfertas = new HashSet<DTOfertaExtendido>();
            
            for (OfertaLaboral oferta : ofertasLaborales) {
                DTOfertaExtendido dtOferta = oferta.obtenerDatosOferta();
                dtOfertas.add(dtOferta);
                // muestro toda oferta laboral 
            }
            empre = new DTEmpresa(nickname,  correoElectronico,  apellido,  nombre,  contraseña,  descripcion,  url,  dtOfertas,  imagen);   
        } else {
            String nickname =  getNickname();
            String nombre = getNombre();
            String apellido = getApellido();
            String correoElectronico = getcorreoElectronico();
            String contraseña = getcontrasenia();
            String imagen = getImagen(); 
            Set<DTOfertaExtendido> dtOfertas = new HashSet<DTOfertaExtendido>();
            
            for (OfertaLaboral oferta : ofertasLaborales) {
                if (oferta.getEstado() == EstadoOL.Confirmada) {
                    DTOfertaExtendido dtOferta = oferta.obtenerDatosOferta();
                    dtOfertas.add(dtOferta);   
                }// si oferta laboral confirmada se muestra
            }
            empre = new DTEmpresa(nickname,  correoElectronico,  apellido,  nombre,  contraseña,  descripcion,  url,  dtOfertas,  imagen); 
        }
        return empre;
    }
	
	public Set<String> listarPaquetesNoVencidos() {
		Set<String> res = new HashSet<String>();
		for (InfoCompra infoCompra : infoCompras) {
		    // Accede a cada elemento 'infoCompra' y realiza las operaciones necesarias
		    if (!infoCompra.estaVencido()) {
		    	res.add(infoCompra.obtenerDatosPaquete().getNombre());
		    }
		}
		return res;
	}
}

