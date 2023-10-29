
package logica.servidor;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "ExceptionUsuarioSeSigueASiMismo", targetNamespace = "http://servidor.logica/")
public class ExceptionUsuarioSeSigueASiMismo_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ExceptionUsuarioSeSigueASiMismo faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ExceptionUsuarioSeSigueASiMismo_Exception(String message, ExceptionUsuarioSeSigueASiMismo faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public ExceptionUsuarioSeSigueASiMismo_Exception(String message, ExceptionUsuarioSeSigueASiMismo faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: logica.servidor.ExceptionUsuarioSeSigueASiMismo
     */
    public ExceptionUsuarioSeSigueASiMismo getFaultInfo() {
        return faultInfo;
    }

}
