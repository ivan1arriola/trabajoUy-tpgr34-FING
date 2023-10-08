package main.java.logica.datatypes;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import main.java.logica.clases.Paquete;
import main.java.logica.enumerados.DepUY;
import main.java.logica.enumerados.EstadoOL;

public class DTOfertaExtendidoConKeywordsTit extends DTOfertaExtendidoSinPConK {
	private Set<String> postulaciones;
	private Paquete paq;

public DTOfertaExtendidoConKeywordsTit(String nomb,  String desc,  LocalDate fechaA,  float cost,  float remu,  DTHorario horario, 
       DepUY dep,  String ciu,  EstadoOL estado,  byte[] img,  Set<String> keys,  Paquete paq,  Set<String> postulaciones) {
  super(nomb,  desc,  fechaA,  cost,  remu,  horario,  dep,  ciu,  estado,  img,  keys);
  this.postulaciones = postulaciones;
  this.paq = paq;
}
	
public Paquete getPaquete() {
  return paq;
}
	
public Set<String>  getpostulaciones() {
  return postulaciones;
}
}
