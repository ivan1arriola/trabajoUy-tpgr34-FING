
package logica.servidor;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "NoHayOrdenDefinidoDePostulantes", targetNamespace = "http://servidor.logica/")
public class NoHayOrdenDefinidoDePostulantes_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NoHayOrdenDefinidoDePostulantes faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NoHayOrdenDefinidoDePostulantes_Exception(String message, NoHayOrdenDefinidoDePostulantes faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public NoHayOrdenDefinidoDePostulantes_Exception(String message, NoHayOrdenDefinidoDePostulantes faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: logica.servidor.NoHayOrdenDefinidoDePostulantes
     */
    public NoHayOrdenDefinidoDePostulantes getFaultInfo() {
        return faultInfo;
    }

}
