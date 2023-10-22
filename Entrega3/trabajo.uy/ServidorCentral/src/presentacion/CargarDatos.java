package presentacion;


import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import excepciones.ExcepcionKeywordVacia;
import excepciones.ExceptionValidezNegativa;
import logica.interfaces.ICtrlCargaDeDatos;
import logica.interfaces.ICtrlOferta;
import logica.interfaces.ICtrlUsuario;
import logica.utils.Fabrica;

public class CargarDatos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ICtrlCargaDeDatos iCCDatos;
	/**
	 * Create the application.
	 */
	
	public CargarDatos(ICtrlUsuario icUsuario,  ICtrlOferta ico) {
        Fabrica fabrica = Fabrica.getInstance();
		iCCDatos = fabrica.getICtrlCargaDeDatos();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Cargar datos");
        setBounds(30,  30,  477,  153);
        getContentPane().setLayout(null); //Absolute Layout
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		try {
					iCCDatos.cargarDatos();
				} catch (ExcepcionKeywordVacia | ExceptionValidezNegativa e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(CargarDatos.this,  "Se han cargado todos los datos pero " + e.getMessage(),  "Carga de Datos",  JOptionPane.ERROR);
				}
                
                JOptionPane.showMessageDialog(CargarDatos.this,  "Se han cargado los datos exitosamente.",  "Carga de Datos",  JOptionPane.INFORMATION_MESSAGE);
                
                setVisible(false);
        	}
        });
        btnAceptar.setBounds(63,  78,  117,  25);
        getContentPane().add(btnAceptar);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		setVisible(false);
        	}
        });
        btnCerrar.setBounds(297,  78,  117,  25);
        getContentPane().add(btnCerrar);
        
        JLabel lblSeleccioneAceptarPara = new JLabel("Seleccione aceptar para cargar los datos.");
        lblSeleccioneAceptarPara.setBounds(81,  28,  332,  15);
        getContentPane().add(lblSeleccioneAceptarPara);
	}
}
