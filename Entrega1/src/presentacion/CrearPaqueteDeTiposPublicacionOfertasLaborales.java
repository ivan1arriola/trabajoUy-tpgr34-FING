package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.Sizes;

import logica.Fabrica;
import logica.Interfaces.ICtrlOferta;

public class CrearPaqueteDeTiposPublicacionOfertasLaborales extends JInternalFrame {
	private JTextField textField;

	public CrearPaqueteDeTiposPublicacionOfertasLaborales() {
		ICtrlOferta ctrlOferta = Fabrica.getInstance().getICtrlOferta();
		
		
		
	    setTitle("Crear Paquete De Tipos De Publicacion De Ofertas Laborales");
	    setResizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
	    setBounds(100, 100, 588, 272);
	    getContentPane().setLayout(new BorderLayout(0, 0));

	    JPanel panel = new JPanel();
	    getContentPane().add(panel, BorderLayout.SOUTH);
	    panel.setLayout(new GridLayout(1, 0, 0, 0));

	    JPanel panel_1 = new JPanel();
	    getContentPane().add(panel_1, BorderLayout.CENTER);
	    panel_1.setLayout(new FormLayout(new ColumnSpec[] {
	    		ColumnSpec.decode("2dlu"),
	    		ColumnSpec.decode("1px:grow"),
	    		ColumnSpec.decode("0dlu"),
	    		ColumnSpec.decode("default:grow"),
	    		ColumnSpec.decode("2dlu"),},
	    	new RowSpec[] {
	    		FormSpecs.LINE_GAP_ROWSPEC,
	    		RowSpec.decode("max(23dlu;min)"),
	    		FormSpecs.LINE_GAP_ROWSPEC,
	    		RowSpec.decode("max(22dlu;default)"),
	    		FormSpecs.LINE_GAP_ROWSPEC,
	    		RowSpec.decode("max(23dlu;default)"),
	    		FormSpecs.LINE_GAP_ROWSPEC,
	    		RowSpec.decode("max(22dlu;default)"),
	    		FormSpecs.LINE_GAP_ROWSPEC,
	    		RowSpec.decode("max(21dlu;default)"),
	    		FormSpecs.LINE_GAP_ROWSPEC,}));

	    JLabel lblNombre = new JLabel("Nombre:");
	    panel_1.add(lblNombre, "2, 2, right, default");

	    JTextField textFieldNombre = new JTextField();
	    panel_1.add(textFieldNombre, "4, 2, fill, fill");

	    JLabel lblDescripcion = new JLabel("Descripción:");
	    panel_1.add(lblDescripcion, "2, 4, right, default");

	    JTextField textFieldDescripcion = new JTextField();
	    panel_1.add(textFieldDescripcion, "4, 4, fill, fill");

	    JLabel lblPeriodoValidez = new JLabel("Período de validez (días):");
	    panel_1.add(lblPeriodoValidez, "2, 6, right, fill");

	    JSpinner spinnerPeriodoValidez = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
	    panel_1.add(spinnerPeriodoValidez, "4, 6, default, fill");
	    JComponent editor = spinnerPeriodoValidez.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            ((JSpinner.DefaultEditor) editor).getTextField().setEditable(false);
        }

	    JLabel lblDescuento = new JLabel("Descuento (%):");
	    panel_1.add(lblDescuento, "2, 8, right, default");

	    JSpinner spinnerDescuento = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	    panel_1.add(spinnerDescuento, "4, 8, default, fill");
	    JComponent editor1 = spinnerDescuento.getEditor();
        if (editor1 instanceof JSpinner.DefaultEditor) {
            ((JSpinner.DefaultEditor) editor1).getTextField().setEditable(false);
        }

	    JLabel lblFechaAlta = new JLabel("Fecha de alta:");
	    panel_1.add(lblFechaAlta, "2, 10, right, default");

	    JTextField textFieldFechaAlta = new JTextField();
	    textFieldFechaAlta.setEditable(false);
	    LocalDate currentDate = LocalDate.now();
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String formattedDate = currentDate.format(dateFormatter);
	    textFieldFechaAlta.setText(formattedDate);
	    panel_1.add(textFieldFechaAlta, "4, 10, fill, fill");

	    JButton btnNewButton_1 = new JButton("Aceptar");
	    btnNewButton_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            boolean valid = true; 

	            String nombre = textFieldNombre.getText();
	            String descripcion = textFieldDescripcion.getText();

	            // Verifica el campo Nombre
	            if (nombre.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacío.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
	                valid = false;
	            } else  if (descripcion.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "El campo descripción no puede estar vacío.", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
	                valid = false;
	            }else if(!nombre.matches("[a-zA-Z]+$")) {
                	JOptionPane.showMessageDialog(CrearPaqueteDeTiposPublicacionOfertasLaborales.this, "El nombre indicado se compone de carácteres que no son letras.", "ERROR - Alta Oferta Laboral", JOptionPane.ERROR_MESSAGE);
                } else {
    	            // Verifica el campo Período de validez (días)
    	            int periodoValidez = (int) spinnerPeriodoValidez.getValue();
    	            if (periodoValidez <= 0) {
    	                JOptionPane.showMessageDialog(null, "El período de validez debe ser mayor que 0.", "Valor Inválido", JOptionPane.WARNING_MESSAGE);
    	                valid = false;
    	            } else {
    	                spinnerPeriodoValidez.setBackground(UIManager.getColor("Spinner.background"));
    	            }

    	            // Verifica el campo Descuento (%)
    	            int descuento = (int) spinnerDescuento.getValue();
    	            if (descuento < 0 || descuento > 100) {
    	                JOptionPane.showMessageDialog(null, "El descuento debe estar entre 0 y 100.", "Valor Inválido", JOptionPane.WARNING_MESSAGE);
    	                valid = false;
    	            }


    	            if (valid) {
    	                try {
    	                    boolean res = ctrlOferta.altaPaqueteOL(nombre, descripcion, periodoValidez, LocalDate.now(), descuento);
    	                    if (res) {
    	                        JOptionPane.showMessageDialog(null, "Operación completada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    	                        textFieldNombre.setText("");
    	                        textFieldDescripcion.setText("");
    	                        spinnerPeriodoValidez.setValue(1);
    	                        spinnerDescuento.setValue(0);
    	                        dispose();
    	                    } else {
    	                        JOptionPane.showMessageDialog(null, "Algo salió mal.", "Error", JOptionPane.ERROR_MESSAGE);
    	                    }
    	                } catch (IllegalArgumentException e1) {
    	                    // Mostrar el mensaje de error en una ventana emergente
    	                    JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    	                }
    	            }
                }
	        }
	    });

	    panel.add(btnNewButton_1);

	    JButton btnNewButton = new JButton("Cerrar");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		textFieldNombre.setText("");
	            textFieldDescripcion.setText("");
	            spinnerPeriodoValidez.setValue(1);
	            spinnerDescuento.setValue(0);
                dispose();
	    		
	    	}
	    });
	    panel.add(btnNewButton);
	}

}