package main.java.excepciones;

import java.io.Serializable;

public class ExceptionUsuarioNoEncontrado extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public ExceptionUsuarioNoEncontrado(String string) {
        super(string);
    }
}