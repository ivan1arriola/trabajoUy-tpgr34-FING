package main.java.logica.clases;

import java.time.LocalDate;
import java.util.HashSet;

import main.java.logica.datatypes.DTPostulacion;
import main.java.logica.datatypes.DTPostulante;
import main.java.logica.datatypes.DTPostulanteExtendido;
import main.java.logica.datatypes.DTUsuario;



public class Postulante extends Usuario{
    // atributos
    private LocalDate fechaNac;
    private String nacionalidad;
    // relaciones
    private HashSet<Postulacion> postulaciones;

    // constructor sin imagen
    public Postulante(String nickname,  String contrasena,  String nombre,  String apellido,  String correo_electronico,  LocalDate fechaNac,  String nacionalidad, byte[] img) {
        super(nickname,  nombre,  apellido,  correo_electronico,  contrasena,  img); // super es para llamar al constructor de la clase padre
        this.fechaNac = fechaNac;
        this.nacionalidad = nacionalidad;
        this.postulaciones = new HashSet<Postulacion>();
    }
    
    // constructor con imagen
    public Postulante(String nickname,  String contrasena,  String nombre,  String apellido,  String correo_electronico,  LocalDate fechaNac,  String nacionalidad) {
        super(nickname,  nombre,  apellido,  correo_electronico,  contrasena); // super es para llamar al constructor de la clase padre
        this.fechaNac = fechaNac;
        this.nacionalidad = nacionalidad;
        this.postulaciones = new HashSet<Postulacion>();
    }



    // Getters
    public LocalDate getFechaNac() { 
    	return fechaNac;
    }
    
    public HashSet<Postulacion> getPostulaciones() {
    	return postulaciones;
    }
    
    public String getNacionalidad() {
    	return nacionalidad;
    }

    // Setters
    public void setFechaNac(LocalDate fechaNac) {
    	this.fechaNac = fechaNac;
    }
    
    public void setNacionalidad(String nacionalidad) {
    	this.nacionalidad = nacionalidad; 
    }
    
    public void setPostulaciones(HashSet<Postulacion> postulaciones) { 
    	this.postulaciones = postulaciones; 
    }

    // Metodos
    public boolean esEmpresa() {
        return false; // es postulante,  no es empresa
    }

    public DTUsuario obtenerDatosUsuario() {
        // hacer un DTPostulante
        DTPostulante postul = new DTPostulante(this.getNickname(),  this.getcorreoElectronico(),  this.getApellido(),  this.getNombre(),  this.getcontrasenia(),  this.getImagen(),  fechaNac,  nacionalidad);
        return postul;
    }

    public Postulacion crearPostulacion(String cv,  String motivacion,  LocalDate fecha,  String URLDocExtras,  OfertaLaboral OferLab) {
        Postulacion p = new Postulacion(this,  cv,  motivacion,  fecha,  URLDocExtras,  OferLab);
        postulaciones.add(p);
        return p;
    }

    public boolean existePostulacion(String nombre) {
        for (Postulacion postulacion : postulaciones) {
            String nombreOferta = postulacion.obtenerNombreOfertaLaboral();
            if (nombreOferta.equals(nombre)) {
                return true; // si existe retorna true y sale de existepostulacion
            }
        }
        return false;
    }

    public boolean editarPostulacion(String nombre, String  cvAbreviado, String motivacion) {
        for (Postulacion postulacion : postulaciones) {
            String nombreOferta = postulacion.obtenerNombreOfertaLaboral();
            if (nombreOferta.equals(nombre)) {
                postulacion.setCV(cvAbreviado);
                postulacion.setMotivacion(motivacion);
                return true; 
            }
        }
        return false; 
    }

    public DTPostulacion obtenerDatosPostulacion(String postulante_nick, String ofer) {
        // obtener para este postulante la postulacion si trabaja en la oferta
        // si no existe retorno NULL
        DTPostulacion respuesta = null;
        for (Postulacion postulacion : postulaciones) {
            String nombreOferta = postulacion.obtenerNombreOfertaLaboral();
            if (nombreOferta.equals(ofer)) {
                respuesta = postulacion.obtenerDT();
                return respuesta;
            }
        }
        return respuesta;
    }

    // corregido,  se pasan mas parametros para la ejecucion
    public DTUsuario obtenerDatosUsuarioEspecial(String UsuarioRegistradoActual, String UsuarioQueSeHaceConsulta) {
    	DTPostulante postul;
    	if (UsuarioRegistradoActual.equals(UsuarioQueSeHaceConsulta)) {
            String nickname =  getNickname();
            String nombre = getNombre();
            String apellido = getApellido();
            String correoElectronico = getcorreoElectronico();
            String contrasenia = getcontrasenia();
            byte[] imagen = getImagen();
            LocalDate fechaNac = getFechaNac();
            String nacionalidad = getNacionalidad();
            HashSet<Postulacion> posts = getPostulaciones();
            
            HashSet<DTPostulacion> postsDT = new HashSet<DTPostulacion>();

            for (Postulacion post : posts) {
                DTPostulacion paux = post.obtenerDT();
                postsDT.add(paux);
            }
        
            postul = new DTPostulanteExtendido(nickname,   correoElectronico,   apellido,   nombre,   contrasenia,   imagen,   fechaNac,   nacionalidad,  postsDT);
            } else {
            String nickname =  getNickname();
            String nombre = getNombre();
            String apellido = getApellido();
            String correoElectronico = getcorreoElectronico();
            String contraseña = getcontrasenia();
            byte[] imagen = getImagen();
            LocalDate fechaNac = getFechaNac();
            String nacionalidad = getNacionalidad();
            postul = new DTPostulante(nickname,  correoElectronico,  apellido,  nombre,  contraseña,  imagen,  fechaNac,  nacionalidad);
        }
        return postul;
    }

    public HashSet<String> listarOfertasLaborales(){
        HashSet<String> lista = new HashSet<String>();
        
        if (postulaciones!=null) {
            for (Postulacion p : postulaciones){
                lista.add(p.obtenerNombreOfertaLaboral());
            }
        }

        return lista;
    }
 
}
