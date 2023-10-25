package logica.servidor.bean;
import java.util.ArrayList;

import logica.datatypes.DTOfertaExtendido;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DTLista {

    private ArrayList<String> listaString;
    private ArrayList<DTOfertaExtendido> ofertasExtendido;

    public DTLista() {
        listaString = new ArrayList<>();
        ofertasExtendido = new ArrayList<>();
    }

    public ArrayList<String> getListaString() {
        return listaString;
    }

    public void setListaString(ArrayList<String> listaString) {
        this.listaString = listaString;
    }

    public ArrayList<DTOfertaExtendido> getOfertasExtendido() {
        return ofertasExtendido;
    }

    public void setOfertasExtendido(ArrayList<DTOfertaExtendido> ofertasExtendido) {
        this.ofertasExtendido = ofertasExtendido;
    }


}
