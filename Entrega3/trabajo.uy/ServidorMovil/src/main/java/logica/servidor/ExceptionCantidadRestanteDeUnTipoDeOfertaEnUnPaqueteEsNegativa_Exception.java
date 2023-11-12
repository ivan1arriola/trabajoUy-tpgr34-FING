
package logica.servidor;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa", targetNamespace = "http://servidor.logica/")
public class ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa_Exception(String message, ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa_Exception(String message, ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: logica.servidor.ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa
     */
    public ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa getFaultInfo() {
        return faultInfo;
    }

}
