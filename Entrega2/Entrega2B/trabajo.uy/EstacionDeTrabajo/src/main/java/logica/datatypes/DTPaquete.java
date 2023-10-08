package main.java.logica.datatypes;

import java.time.LocalDate;
import java.util.Set;
	
public class DTPaquete {
	private String nombre;
	private float costo;
	private float descuento;
	private int validez;
	private String descripcion;
	private Set<DTCantTO> tiposDePub;
	private LocalDate fechaA;
	
	public DTPaquete(String nomb,  float cost,  float descuento,  int valid,  String desc,  Set<DTCantTO> tdp,  LocalDate fechaAlta) {
		nombre = nomb;
		costo = cost;
		this.descuento = descuento;
		validez = valid;
		descripcion = desc;
		tiposDePub = tdp;
		fechaA = fechaAlta;
	}

	public String getNombre() {
		return nombre;
	}
	
	public float getCosto() {
		return costo;
	}
	
	public float getDescuento() {
		return descuento;
	}
	
	public int getValidez() {
	    return validez;
	}

	public String getDescripcion() {
	    return descripcion;
	}

	public Set<DTCantTO> getTiposDePub() {
	    return tiposDePub;
	}

	public LocalDate getFechaAlta() {
		return fechaA;
	}
	
}
