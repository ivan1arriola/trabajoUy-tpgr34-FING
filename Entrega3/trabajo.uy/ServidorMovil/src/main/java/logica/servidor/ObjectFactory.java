
package logica.servidor;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the logica.servidor package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ErrorAgregarUsuario_QNAME = new QName("http://servidor.logica/", "ErrorAgregarUsuario");
    private final static QName _ExcepcionKeywordVacia_QNAME = new QName("http://servidor.logica/", "ExcepcionKeywordVacia");
    private final static QName _ExcepcionTipoOfertaNoExistente_QNAME = new QName("http://servidor.logica/", "ExcepcionTipoOfertaNoExistente");
    private final static QName _ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa_QNAME = new QName("http://servidor.logica/", "ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa");
    private final static QName _ExceptionCompraPaqueteConValorNegativo_QNAME = new QName("http://servidor.logica/", "ExceptionCompraPaqueteConValorNegativo");
    private final static QName _ExceptionFechaInvalida_QNAME = new QName("http://servidor.logica/", "ExceptionFechaInvalida");
    private final static QName _ExceptionUsuarioCorreoRepetido_QNAME = new QName("http://servidor.logica/", "ExceptionUsuarioCorreoRepetido");
    private final static QName _ExceptionUsuarioNickRepetido_QNAME = new QName("http://servidor.logica/", "ExceptionUsuarioNickRepetido");
    private final static QName _ExceptionUsuarioNickYCorreoRepetidos_QNAME = new QName("http://servidor.logica/", "ExceptionUsuarioNickYCorreoRepetidos");
    private final static QName _ExceptionUsuarioNoEncontrado_QNAME = new QName("http://servidor.logica/", "ExceptionUsuarioNoEncontrado");
    private final static QName _ExceptionUsuarioSeSigueASiMismo_QNAME = new QName("http://servidor.logica/", "ExceptionUsuarioSeSigueASiMismo");
    private final static QName _ExceptionValidezNegativa_QNAME = new QName("http://servidor.logica/", "ExceptionValidezNegativa");
    private final static QName _ExisteOrdenFinalDePostulantes_QNAME = new QName("http://servidor.logica/", "ExisteOrdenFinalDePostulantes");
    private final static QName _NoExistePaquete_QNAME = new QName("http://servidor.logica/", "NoExistePaquete");
    private final static QName _OfertaLaboralNoEncontrada_QNAME = new QName("http://servidor.logica/", "OfertaLaboralNoEncontrada");
    private final static QName _TipoUsuarioNoValido_QNAME = new QName("http://servidor.logica/", "TipoUsuarioNoValido");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: logica.servidor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ErrorAgregarUsuario }
     * 
     * @return
     *     the new instance of {@link ErrorAgregarUsuario }
     */
    public ErrorAgregarUsuario createErrorAgregarUsuario() {
        return new ErrorAgregarUsuario();
    }

    /**
     * Create an instance of {@link ExcepcionKeywordVacia }
     * 
     * @return
     *     the new instance of {@link ExcepcionKeywordVacia }
     */
    public ExcepcionKeywordVacia createExcepcionKeywordVacia() {
        return new ExcepcionKeywordVacia();
    }

    /**
     * Create an instance of {@link ExcepcionTipoOfertaNoExistente }
     * 
     * @return
     *     the new instance of {@link ExcepcionTipoOfertaNoExistente }
     */
    public ExcepcionTipoOfertaNoExistente createExcepcionTipoOfertaNoExistente() {
        return new ExcepcionTipoOfertaNoExistente();
    }

    /**
     * Create an instance of {@link ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa }
     * 
     * @return
     *     the new instance of {@link ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa }
     */
    public ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa createExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa() {
        return new ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa();
    }

    /**
     * Create an instance of {@link ExceptionCompraPaqueteConValorNegativo }
     * 
     * @return
     *     the new instance of {@link ExceptionCompraPaqueteConValorNegativo }
     */
    public ExceptionCompraPaqueteConValorNegativo createExceptionCompraPaqueteConValorNegativo() {
        return new ExceptionCompraPaqueteConValorNegativo();
    }

    /**
     * Create an instance of {@link ExceptionFechaInvalida }
     * 
     * @return
     *     the new instance of {@link ExceptionFechaInvalida }
     */
    public ExceptionFechaInvalida createExceptionFechaInvalida() {
        return new ExceptionFechaInvalida();
    }

    /**
     * Create an instance of {@link ExceptionUsuarioCorreoRepetido }
     * 
     * @return
     *     the new instance of {@link ExceptionUsuarioCorreoRepetido }
     */
    public ExceptionUsuarioCorreoRepetido createExceptionUsuarioCorreoRepetido() {
        return new ExceptionUsuarioCorreoRepetido();
    }

    /**
     * Create an instance of {@link ExceptionUsuarioNickRepetido }
     * 
     * @return
     *     the new instance of {@link ExceptionUsuarioNickRepetido }
     */
    public ExceptionUsuarioNickRepetido createExceptionUsuarioNickRepetido() {
        return new ExceptionUsuarioNickRepetido();
    }

    /**
     * Create an instance of {@link ExceptionUsuarioNickYCorreoRepetidos }
     * 
     * @return
     *     the new instance of {@link ExceptionUsuarioNickYCorreoRepetidos }
     */
    public ExceptionUsuarioNickYCorreoRepetidos createExceptionUsuarioNickYCorreoRepetidos() {
        return new ExceptionUsuarioNickYCorreoRepetidos();
    }

    /**
     * Create an instance of {@link ExceptionUsuarioNoEncontrado }
     * 
     * @return
     *     the new instance of {@link ExceptionUsuarioNoEncontrado }
     */
    public ExceptionUsuarioNoEncontrado createExceptionUsuarioNoEncontrado() {
        return new ExceptionUsuarioNoEncontrado();
    }

    /**
     * Create an instance of {@link ExceptionUsuarioSeSigueASiMismo }
     * 
     * @return
     *     the new instance of {@link ExceptionUsuarioSeSigueASiMismo }
     */
    public ExceptionUsuarioSeSigueASiMismo createExceptionUsuarioSeSigueASiMismo() {
        return new ExceptionUsuarioSeSigueASiMismo();
    }

    /**
     * Create an instance of {@link ExceptionValidezNegativa }
     * 
     * @return
     *     the new instance of {@link ExceptionValidezNegativa }
     */
    public ExceptionValidezNegativa createExceptionValidezNegativa() {
        return new ExceptionValidezNegativa();
    }

    /**
     * Create an instance of {@link ExisteOrdenFinalDePostulantes }
     * 
     * @return
     *     the new instance of {@link ExisteOrdenFinalDePostulantes }
     */
    public ExisteOrdenFinalDePostulantes createExisteOrdenFinalDePostulantes() {
        return new ExisteOrdenFinalDePostulantes();
    }

    /**
     * Create an instance of {@link NoExistePaquete }
     * 
     * @return
     *     the new instance of {@link NoExistePaquete }
     */
    public NoExistePaquete createNoExistePaquete() {
        return new NoExistePaquete();
    }

    /**
     * Create an instance of {@link OfertaLaboralNoEncontrada }
     * 
     * @return
     *     the new instance of {@link OfertaLaboralNoEncontrada }
     */
    public OfertaLaboralNoEncontrada createOfertaLaboralNoEncontrada() {
        return new OfertaLaboralNoEncontrada();
    }

    /**
     * Create an instance of {@link TipoUsuarioNoValido }
     * 
     * @return
     *     the new instance of {@link TipoUsuarioNoValido }
     */
    public TipoUsuarioNoValido createTipoUsuarioNoValido() {
        return new TipoUsuarioNoValido();
    }

    /**
     * Create an instance of {@link WrapperLista }
     * 
     * @return
     *     the new instance of {@link WrapperLista }
     */
    public WrapperLista createWrapperLista() {
        return new WrapperLista();
    }

    /**
     * Create an instance of {@link DtOfertaExtendido }
     * 
     * @return
     *     the new instance of {@link DtOfertaExtendido }
     */
    public DtOfertaExtendido createDtOfertaExtendido() {
        return new DtOfertaExtendido();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     * @return
     *     the new instance of {@link ArrayList }
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link DtPostulacion }
     * 
     * @return
     *     the new instance of {@link DtPostulacion }
     */
    public DtPostulacion createDtPostulacion() {
        return new DtPostulacion();
    }

    /**
     * Create an instance of {@link DtUsuario }
     * 
     * @return
     *     the new instance of {@link DtUsuario }
     */
    public DtUsuario createDtUsuario() {
        return new DtUsuario();
    }

    /**
     * Create an instance of {@link DtUsuarioSinInfoSocial }
     * 
     * @return
     *     the new instance of {@link DtUsuarioSinInfoSocial }
     */
    public DtUsuarioSinInfoSocial createDtUsuarioSinInfoSocial() {
        return new DtUsuarioSinInfoSocial();
    }

    /**
     * Create an instance of {@link DtPostulante }
     * 
     * @return
     *     the new instance of {@link DtPostulante }
     */
    public DtPostulante createDtPostulante() {
        return new DtPostulante();
    }

    /**
     * Create an instance of {@link DtEmpresa }
     * 
     * @return
     *     the new instance of {@link DtEmpresa }
     */
    public DtEmpresa createDtEmpresa() {
        return new DtEmpresa();
    }

    /**
     * Create an instance of {@link DtOfertaExtendidoSinPConK }
     * 
     * @return
     *     the new instance of {@link DtOfertaExtendidoSinPConK }
     */
    public DtOfertaExtendidoSinPConK createDtOfertaExtendidoSinPConK() {
        return new DtOfertaExtendidoSinPConK();
    }

    /**
     * Create an instance of {@link DtOfertaExtendidoConKeywordsPostulante }
     * 
     * @return
     *     the new instance of {@link DtOfertaExtendidoConKeywordsPostulante }
     */
    public DtOfertaExtendidoConKeywordsPostulante createDtOfertaExtendidoConKeywordsPostulante() {
        return new DtOfertaExtendidoConKeywordsPostulante();
    }

    /**
     * Create an instance of {@link DtOfertaExtendidoConKeywordsTit }
     * 
     * @return
     *     the new instance of {@link DtOfertaExtendidoConKeywordsTit }
     */
    public DtOfertaExtendidoConKeywordsTit createDtOfertaExtendidoConKeywordsTit() {
        return new DtOfertaExtendidoConKeywordsTit();
    }

    /**
     * Create an instance of {@link DtPaquete }
     * 
     * @return
     *     the new instance of {@link DtPaquete }
     */
    public DtPaquete createDtPaquete() {
        return new DtPaquete();
    }

    /**
     * Create an instance of {@link DtCantTO }
     * 
     * @return
     *     the new instance of {@link DtCantTO }
     */
    public DtCantTO createDtCantTO() {
        return new DtCantTO();
    }

    /**
     * Create an instance of {@link DtTipoOferta }
     * 
     * @return
     *     the new instance of {@link DtTipoOferta }
     */
    public DtTipoOferta createDtTipoOferta() {
        return new DtTipoOferta();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     * @return
     *     the new instance of {@link LocalDate }
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorAgregarUsuario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ErrorAgregarUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ErrorAgregarUsuario")
    public JAXBElement<ErrorAgregarUsuario> createErrorAgregarUsuario(ErrorAgregarUsuario value) {
        return new JAXBElement<>(_ErrorAgregarUsuario_QNAME, ErrorAgregarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcepcionKeywordVacia }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExcepcionKeywordVacia }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExcepcionKeywordVacia")
    public JAXBElement<ExcepcionKeywordVacia> createExcepcionKeywordVacia(ExcepcionKeywordVacia value) {
        return new JAXBElement<>(_ExcepcionKeywordVacia_QNAME, ExcepcionKeywordVacia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcepcionTipoOfertaNoExistente }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExcepcionTipoOfertaNoExistente }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExcepcionTipoOfertaNoExistente")
    public JAXBElement<ExcepcionTipoOfertaNoExistente> createExcepcionTipoOfertaNoExistente(ExcepcionTipoOfertaNoExistente value) {
        return new JAXBElement<>(_ExcepcionTipoOfertaNoExistente_QNAME, ExcepcionTipoOfertaNoExistente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa")
    public JAXBElement<ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa> createExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa(ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa value) {
        return new JAXBElement<>(_ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa_QNAME, ExceptionCantidadRestanteDeUnTipoDeOfertaEnUnPaqueteEsNegativa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionCompraPaqueteConValorNegativo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExceptionCompraPaqueteConValorNegativo }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExceptionCompraPaqueteConValorNegativo")
    public JAXBElement<ExceptionCompraPaqueteConValorNegativo> createExceptionCompraPaqueteConValorNegativo(ExceptionCompraPaqueteConValorNegativo value) {
        return new JAXBElement<>(_ExceptionCompraPaqueteConValorNegativo_QNAME, ExceptionCompraPaqueteConValorNegativo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionFechaInvalida }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExceptionFechaInvalida }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExceptionFechaInvalida")
    public JAXBElement<ExceptionFechaInvalida> createExceptionFechaInvalida(ExceptionFechaInvalida value) {
        return new JAXBElement<>(_ExceptionFechaInvalida_QNAME, ExceptionFechaInvalida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionUsuarioCorreoRepetido }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExceptionUsuarioCorreoRepetido }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExceptionUsuarioCorreoRepetido")
    public JAXBElement<ExceptionUsuarioCorreoRepetido> createExceptionUsuarioCorreoRepetido(ExceptionUsuarioCorreoRepetido value) {
        return new JAXBElement<>(_ExceptionUsuarioCorreoRepetido_QNAME, ExceptionUsuarioCorreoRepetido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionUsuarioNickRepetido }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExceptionUsuarioNickRepetido }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExceptionUsuarioNickRepetido")
    public JAXBElement<ExceptionUsuarioNickRepetido> createExceptionUsuarioNickRepetido(ExceptionUsuarioNickRepetido value) {
        return new JAXBElement<>(_ExceptionUsuarioNickRepetido_QNAME, ExceptionUsuarioNickRepetido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionUsuarioNickYCorreoRepetidos }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExceptionUsuarioNickYCorreoRepetidos }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExceptionUsuarioNickYCorreoRepetidos")
    public JAXBElement<ExceptionUsuarioNickYCorreoRepetidos> createExceptionUsuarioNickYCorreoRepetidos(ExceptionUsuarioNickYCorreoRepetidos value) {
        return new JAXBElement<>(_ExceptionUsuarioNickYCorreoRepetidos_QNAME, ExceptionUsuarioNickYCorreoRepetidos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionUsuarioNoEncontrado }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExceptionUsuarioNoEncontrado }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExceptionUsuarioNoEncontrado")
    public JAXBElement<ExceptionUsuarioNoEncontrado> createExceptionUsuarioNoEncontrado(ExceptionUsuarioNoEncontrado value) {
        return new JAXBElement<>(_ExceptionUsuarioNoEncontrado_QNAME, ExceptionUsuarioNoEncontrado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionUsuarioSeSigueASiMismo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExceptionUsuarioSeSigueASiMismo }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExceptionUsuarioSeSigueASiMismo")
    public JAXBElement<ExceptionUsuarioSeSigueASiMismo> createExceptionUsuarioSeSigueASiMismo(ExceptionUsuarioSeSigueASiMismo value) {
        return new JAXBElement<>(_ExceptionUsuarioSeSigueASiMismo_QNAME, ExceptionUsuarioSeSigueASiMismo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionValidezNegativa }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExceptionValidezNegativa }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExceptionValidezNegativa")
    public JAXBElement<ExceptionValidezNegativa> createExceptionValidezNegativa(ExceptionValidezNegativa value) {
        return new JAXBElement<>(_ExceptionValidezNegativa_QNAME, ExceptionValidezNegativa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExisteOrdenFinalDePostulantes }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExisteOrdenFinalDePostulantes }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "ExisteOrdenFinalDePostulantes")
    public JAXBElement<ExisteOrdenFinalDePostulantes> createExisteOrdenFinalDePostulantes(ExisteOrdenFinalDePostulantes value) {
        return new JAXBElement<>(_ExisteOrdenFinalDePostulantes_QNAME, ExisteOrdenFinalDePostulantes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoExistePaquete }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NoExistePaquete }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "NoExistePaquete")
    public JAXBElement<NoExistePaquete> createNoExistePaquete(NoExistePaquete value) {
        return new JAXBElement<>(_NoExistePaquete_QNAME, NoExistePaquete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfertaLaboralNoEncontrada }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OfertaLaboralNoEncontrada }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "OfertaLaboralNoEncontrada")
    public JAXBElement<OfertaLaboralNoEncontrada> createOfertaLaboralNoEncontrada(OfertaLaboralNoEncontrada value) {
        return new JAXBElement<>(_OfertaLaboralNoEncontrada_QNAME, OfertaLaboralNoEncontrada.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoUsuarioNoValido }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TipoUsuarioNoValido }{@code >}
     */
    @XmlElementDecl(namespace = "http://servidor.logica/", name = "TipoUsuarioNoValido")
    public JAXBElement<TipoUsuarioNoValido> createTipoUsuarioNoValido(TipoUsuarioNoValido value) {
        return new JAXBElement<>(_TipoUsuarioNoValido_QNAME, TipoUsuarioNoValido.class, null, value);
    }

}
