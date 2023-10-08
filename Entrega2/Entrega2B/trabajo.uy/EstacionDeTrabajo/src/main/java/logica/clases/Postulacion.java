package main.java.logica.clases;

import java.time.LocalDate;

import main.java.logica.datatypes.DTPostulacion;


public class Postulacion {
    // atributos
    private LocalDate fecha;
    private String curriculumVitae;
    private String motivacion;
    private String URLDocExtras;
    // relaciones
    private OfertaLaboral OferLab;
    private Postulante postulante;

    // constructor
    public Postulacion(Postulante postulante,   String curriculumVitae,   String motivacion,   LocalDate fecha,   String URLDocExtras,   OfertaLaboral OferLab) {
        this.postulante = postulante;
        this.fecha = fecha;
        this.curriculumVitae = curriculumVitae;
        this.motivacion = motivacion;
        this.URLDocExtras = URLDocExtras;
        this.OferLab = OferLab;
    }


	// GETTERS
    public LocalDate getFecha() { 
    	return fecha;
    }
    
    public String getCV() {
    	return curriculumVitae;
    }
    
    public String getMotivacion() {
    	return motivacion;
    }
    
    public String getURLDocExtras() {
    	return URLDocExtras;
    }
    
    public OfertaLaboral getOfertaLaboral()	{
    	return OferLab;
    }
    
    public Postulante getPostulante() {
    	return postulante;
    }


    // SETTERS
    public void setFecha(LocalDate fecha) { 
    	this.fecha = fecha;
    } 
    
    public void setCV(String curriculumVitae) {
    	this.curriculumVitae = curriculumVitae;
    }	
     
    public void setMotivacion(String motivacion) {
    	this.motivacion = motivacion;
    }
     
    public void setURLDocExtras(String URLDocExtras) {
    	this.URLDocExtras = URLDocExtras;
    }
    
    public void setOfertaLaboral(OfertaLaboral OferLab)	{
    	this.OferLab = OferLab; 
    }
    
    public void setPostulante(Postulante postulante) {
    	this.postulante = postulante; 
    }
    
    // METODOS
    public DTPostulacion obtenerDT() {
        DTPostulacion dtpostu = new DTPostulacion(postulante.getNickname(),   fecha,   URLDocExtras,   curriculumVitae,   motivacion);
        return dtpostu;
    } 

    public String obtenerNombreOfertaLaboral() { 
    	return OferLab.getNombre();
    }

    public void editarPostulacion(String cvAbreviado,  String motivacion) {
        this.curriculumVitae = cvAbreviado;
        this.motivacion = motivacion;
    }

    // dentro caso uso postulacion a oferta laboral
    public Boolean esPostulacion(String nombre){
        return OferLab.getNombre().equals(nombre); // retorna true si el nombre de la oferta es igual al nombre que se le pasa por parametro
    }

    public String obtenerNicknamePostulante() { 
    	return postulante.getNickname();
    }
}
