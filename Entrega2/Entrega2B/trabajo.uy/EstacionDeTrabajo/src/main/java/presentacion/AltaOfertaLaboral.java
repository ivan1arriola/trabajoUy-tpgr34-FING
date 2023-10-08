package main.java.presentacion;

import main.java.excepciones.ExceptionEmpresaInvalida;
import main.java.excepciones.ExceptionUsuarioNoEncontrado;
import main.java.logica.interfaces.ICtrlUsuario;
import main.java.logica.interfaces.ICtrlOferta;
import main.java.logica.Fabrica;
import main.java.logica.datatypes.DTHora;
import main.java.logica.datatypes.DTHorario;
import main.java.logica.enumerados.DepUY;
import main.java.logica.enumerados.EstadoOL;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class AltaOfertaLaboral extends JInternalFrame {
	private JTable table;
	private JTextField nombre;
	private JTextField ciudad;
	private JTextField remuneracion;
	private JTextField fechaAlta1;
	private JComboBox<String> listadoEmpresas;
	private JComboBox<String> listadoOfertas;
	//private JComboBox<String> listadoKeywords;
	private JComboBox<String> listadoDepartamentos;
	private ICtrlUsuario icUsuario;
    private JTextArea descripcion;
    private String empresa;
    private String ofertaLab;
	private ICtrlOferta icOferta;
	private JSpinner desdehora;
	private JSpinner desdemin;
	private JSpinner hastahora;
	private JSpinner hastamin;
	private List<String> keywords;
	private String dep;
	
	private JList<String> availableList;
    private JList<String> selectedList;
	private DefaultListModel<String> availableListModel;
    private DefaultListModel<String> selectedListModel;
	
    /**
     * Create the frame.
     */
    public AltaOfertaLaboral(ICtrlUsuario icu) {
    	Fabrica fabrica = Fabrica.getInstance();
        ICtrlOferta ico = fabrica.getICtrlOferta();
        icUsuario = icu;
        icOferta = ico;

        setResizable(true);
        setIconifiable(false);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Oferta Laboral");
        setBounds(30,  30,  550,  500);
        getContentPane().setLayout(null);
   
        
        JLabel lblNewLabel = new JLabel("Listado Empresas");
        lblNewLabel.setBounds(21,  31,  191,  14);
        getContentPane().add(lblNewLabel);
        
        table = new JTable();
        table.setBounds(67,  45,  1,  1);
        getContentPane().add(table);
        
        //KEYWORDS
        
        /*listadoKeywords = new JComboBox<String>();
        listadoKeywords.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String k = (String) listadoKeywords.getSelectedItem();
        		ks.add(k);
        		// listadoKeywords.removeItem(k);
        	}
        });
        listadoKeywords.setBounds(140,  350,  382,  22);
        getContentPane().add(listadoKeywords);*/
         
        ////////////
        /*availableListModel = new DefaultListModel<>();
        selectedListModel = new DefaultListModel<>();
        HashSet<String> keys = icOferta.listarKeywords();
        List<String> keysSorted = new ArrayList<>(keys);
        Collections.sort(keysSorted,  String.CASE_INSENSITIVE_ORDER);
        
        for (String item : keysSorted) {
            availableListModel.addElement(item);
        }*/
        ///////////////
               
        availableListModel = new DefaultListModel<>();
        selectedListModel = new DefaultListModel<>();
        
        /*HashSet<String> keys = icOferta.listarKeywords();
        List<String> keysSorted = new ArrayList<>(keys);
        Collections.sort(keysSorted,  String.CASE_INSENSITIVE_ORDER);
        for (String item : keysSorted) {
            availableListModel.addElement(item);
        }*/
       
        
        availableList = new JList<>(availableListModel);
        availableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectedList = new JList<>(selectedListModel);
        selectedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
        JScrollPane AvailableL = new JScrollPane(availableList);
        AvailableL.setSize(180,  60);
        AvailableL.setLocation(140,  338);
        getContentPane().add(AvailableL);
        
        JScrollPane SelectedL = new JScrollPane(selectedList);
        SelectedL.setLocation(342,  338);
        SelectedL.setSize(180,  60);
        getContentPane().add(SelectedL);
        
        ///BOTONES
             
        JButton addButton = new JButton("Agregar>");
        addButton.setSize(85,  20);
        addButton.setLocation(235,  409);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                
                if (availableList.getSelectedIndex() != -1) {
                	transferirElemento(availableList,  selectedListModel,  availableListModel);
	                String key = (String) availableList.getSelectedValue();
	        		keywords.add(key);
	        	
                }
            }
        });
        
        JButton removeButton = new JButton("<Quitar");
        removeButton.setSize(85,  20);
        removeButton.setLocation(342,  409);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                
                if (selectedList.getSelectedIndex() != -1) {
                	transferirElemento(selectedList,  availableListModel,  selectedListModel);
	                String key = (String) selectedList.getSelectedValue();
	        		keywords.remove(key);
                }
            }
        });
        

        getContentPane().add(addButton);
        getContentPane().add(removeButton);
        
        
        
        ///////////////////
        listadoEmpresas = new JComboBox<String>();
        listadoEmpresas.setBounds(270,  27,  253,  22);
        getContentPane().add(listadoEmpresas);
        
        listadoEmpresas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		empresa = (String) listadoEmpresas.getSelectedItem();
        	}
        });
        
        JLabel lblNewLabel_1 = new JLabel("Listado de Tipo de Oferta");
        lblNewLabel_1.setBounds(21,  64,  191,  18);
        getContentPane().add(lblNewLabel_1);
        
        listadoOfertas = new JComboBox<String>();
        listadoOfertas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		
        		ofertaLab = (String) listadoOfertas.getSelectedItem();
        	}
        });
        listadoOfertas.setBounds(270,  60,  253,  22);
        getContentPane().add(listadoOfertas);
        
     
        JLabel lblNewLabel_2 = new JLabel("Nombre");
        lblNewLabel_2.setBounds(21,  93,  138,  14);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Descripcion");
        lblNewLabel_3.setBounds(21,  124,  139,  14);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Desde ");
        lblNewLabel_4.setBounds(174,  187,  98,  14);
        getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Hasta");
        lblNewLabel_5.setBounds(396,  187,  46,  14);
        getContentPane().add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Remuneracion");
        lblNewLabel_6.setBounds(21,  255,  177,  14);
        getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Departamento");
        lblNewLabel_7.setBounds(21,  284,  139,  14);
        getContentPane().add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Ciudad");
        lblNewLabel_8.setBounds(359,  284,  65,  14);
        getContentPane().add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Fecha de Alta");
        lblNewLabel_9.setBounds(21,  313,  177,  14);
        getContentPane().add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("Keywords");
        lblNewLabel_10.setBounds(21,  354,  139,  14);
        getContentPane().add(lblNewLabel_10);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		DTHora desde = new DTHora((int) desdehora.getValue(),  
        				  			      (int) desdemin.getValue());
        		
        		DTHora hasta = new DTHora((int) hastahora.getValue(),  
        								 (int) hastamin.getValue());
        		DTHorario horario = new DTHorario(desde,  hasta);
        		
                DepUY departamento = null;
            	
                switch (dep) {
                    case "Artigas":
                        departamento = DepUY.Artigas;
                        break;
                    case "Salto":
                    	departamento = DepUY.Salto;
                        break;
                    case "Paysandú":
                    	departamento = DepUY.Paysandú;
                        break;
                    case "RioNegro":
                    	departamento = DepUY.RioNegro;
                        break;
                    case "Soriano":
                    	departamento = DepUY.Soriano;
                        break;
                    case "Colonia":
                    	departamento = DepUY.Colonia;
                        break;
                    case "Rivera":
                    	departamento = DepUY.Rivera;
                        break;
                    case "Tacuarembo":
                    	departamento = DepUY.Tacuarembo;
                        break;
                    case "Durazno":
                    	departamento = DepUY.Durazno;
                        break;
                    case "Flores":
                    	departamento = DepUY.Flores;
                        break;
                    case "Florida":
                    	departamento = DepUY.Florida;
                        break;
                    case "SanJosé":
                    	departamento = DepUY.SanJosé;
                        break;
                    case "Canelones":
                    	departamento = DepUY.Canelones;
                        break;
                    case "Montevideo":
                    	departamento = DepUY.Montevideo;
                        break;
                    case "CerroLargo":
                    	departamento = DepUY.CerroLargo;
                        break;
                    case "TreintaYTres":
                    	departamento = DepUY.TreintaYTres;
                        break;
                    case "Lavalleja":
                    	departamento = DepUY.Lavalleja;
                        break;
                    case "Rocha":
                    	departamento = DepUY.Rocha;
                        break;
                    case "Maldonado":
                    	departamento = DepUY.Maldonado;
                        break;
                    default:
                    	JOptionPane.showMessageDialog(AltaOfertaLaboral.this,  "Departamento = Null",  "ERROR - Alta de Postulante",  JOptionPane.ERROR_MESSAGE);
                        break;
                }
        		
                String nomb = nombre.getText();
                String ciu = ciudad.getText();
                String desc = descripcion.getText();
                
                if (nomb.isEmpty() || ciu.isEmpty() || desc.isEmpty() || remuneracion.getText().isEmpty()) {
                	JOptionPane.showMessageDialog(AltaOfertaLaboral.this,  "No pueden existir campos vacíos.",  "ERROR - Alta de Oferta",  JOptionPane.ERROR_MESSAGE);
                } else if (!nomb.matches("[a-zA-Z]+$")) {
                	JOptionPane.showMessageDialog(AltaOfertaLaboral.this,  "El nombre indicado se compone de carácteres que no son letras.",  "ERROR - Alta Oferta Laboral",  JOptionPane.ERROR_MESSAGE);
                } else if (!ciu.matches("[a-zA-Z]+$")) {
                	JOptionPane.showMessageDialog(AltaOfertaLaboral.this,  "La ciudad indicada se compone de carácteres que no son letras.",  "ERROR - Alta Oferta Laboral",  JOptionPane.ERROR_MESSAGE);
                } else {
                    
                    try {
                    	Float remu = Float.parseFloat(remuneracion.getText());
                    	
                    	if (remu <= 0) {
                    		JOptionPane.showMessageDialog(AltaOfertaLaboral.this,  "La remuneración debe ser un número positivo",  "ERROR - Alta Oferta Laboral",  JOptionPane.ERROR_MESSAGE);
                    	} else {
	                		try {
	                			boolean noexiste = icUsuario.altaOfertaLaboral(empresa,  ofertaLab,  nomb,  desc,  horario,  remu,  ciu,  departamento,  LocalDate.now(),  keywords,  EstadoOL.Ingresada,  null,  null);
	                			if (!noexiste) {
	                				JOptionPane.showMessageDialog(AltaOfertaLaboral.this,  "Ya existe una oferta laboral con el nombre indicado.",  "ERROR - Alta Oferta Laboral",  JOptionPane.ERROR_MESSAGE);
	                			} else {
	                				JOptionPane.showMessageDialog(AltaOfertaLaboral.this,  "La oferta laboral se dio de alta exitosamente",  "Alta Oferta Laboral",  JOptionPane.INFORMATION_MESSAGE);
	                				limpiarFormulario();
	                			}
	                		} catch (ExceptionUsuarioNoEncontrado | ExceptionEmpresaInvalida e1) {
	                			JOptionPane.showMessageDialog(AltaOfertaLaboral.this,  e1.getMessage(),  "ERROR - Alta Oferta Laboral",  JOptionPane.ERROR_MESSAGE);
	                		}   
	                		
                    }
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(AltaOfertaLaboral.this,  "La remuneración debe ser un número.",  "ERROR - Alta Oferta Laboral",  JOptionPane.ERROR_MESSAGE);
                    }
         
             	
                }
      	
        		
        	}
        });
        
        btnAceptar.setBounds(335,  436,  89,  23);
        getContentPane().add(btnAceptar);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		setVisible(false);
        	}
        });
        btnCerrar.setBounds(434,  436,  89,  23);
        getContentPane().add(btnCerrar);
        
        nombre = new JTextField();
        nombre.setBounds(205,  93,  318,  20);
        getContentPane().add(nombre);
        nombre.setColumns(10);
        
        descripcion = new JTextArea();
        descripcion.setBounds(205,  124,  317,  54);
        getContentPane().add(descripcion);
        
        listadoDepartamentos = new JComboBox<String>();
        listadoDepartamentos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		dep = (String) listadoDepartamentos.getSelectedItem();
        	}
        });
        listadoDepartamentos.setBounds(140,  280,  191,  22);
        getContentPane().add(listadoDepartamentos);
        
        listadoDepartamentos.addItem("Artigas");
        listadoDepartamentos.addItem("Canelones");
        listadoDepartamentos.addItem("Cerro Largo");
        listadoDepartamentos.addItem("Colonia");
        listadoDepartamentos.addItem("Durazno");
        listadoDepartamentos.addItem("Flores");
        listadoDepartamentos.addItem("Florida");
        listadoDepartamentos.addItem("Lavalleja");
        listadoDepartamentos.addItem("Maldonado");
        listadoDepartamentos.addItem("Montevideo");
        listadoDepartamentos.addItem("Paysandú");
        listadoDepartamentos.addItem("RioNegro");
        listadoDepartamentos.addItem("Rivera");
        listadoDepartamentos.addItem("Rocha");
        listadoDepartamentos.addItem("Salto");
        listadoDepartamentos.addItem("SanJosé");
        listadoDepartamentos.addItem("Soriano");
        listadoDepartamentos.addItem("Tacuarembo");
        listadoDepartamentos.addItem("TreintaYTres");

       
        ciudad = new JTextField();
        ciudad.setBounds(414,  281,  109,  20);
        getContentPane().add(ciudad);
        ciudad.setColumns(10);
        
        remuneracion = new JTextField();
        remuneracion.setBounds(140,  253,  382,  20);
        getContentPane().add(remuneracion);
        remuneracion.setColumns(10);
        
        /*JList list = new JList();
        list.setBounds(172,  366,  51,  -25);
        getContentPane().add(list);*/
       
        
        fechaAlta1 = new JTextField();
        fechaAlta1.setBounds(140,  309,  100,  20);
        getContentPane().add(fechaAlta1);
        fechaAlta1.setColumns(10);
        
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate currentDate = LocalDate.now();
		fechaAlta1.setText(currentDate.format(dateFormatter));
		fechaAlta1.setEditable(false);
		
		desdehora = new JSpinner(new SpinnerNumberModel(0,  0,  23,  1));
		desdehora.setBounds(111,  212,  46,  20);
		getContentPane().add(desdehora);
	    JComponent editor = desdehora.getEditor();
	        if (editor instanceof JSpinner.DefaultEditor) {
	            ((JSpinner.DefaultEditor) editor).getTextField().setEditable(false);
	        }
		
		
		desdemin = new JSpinner(new SpinnerNumberModel(0,  0,  59,  1));
		desdemin.setBounds(194,  212,  46,  20);
		getContentPane().add(desdemin);
	     JComponent editor1 = desdemin.getEditor();
	        if (editor1 instanceof JSpinner.DefaultEditor) {
	            ((JSpinner.DefaultEditor) editor1).getTextField().setEditable(false);
	        }
		
		hastahora = new JSpinner(new SpinnerNumberModel(0,  0,  23,  1));
		hastahora.setBounds(333,  212,  46,  20);
		getContentPane().add(hastahora);
	     JComponent editor2 = hastahora.getEditor();
	        if (editor2 instanceof JSpinner.DefaultEditor) {
	            ((JSpinner.DefaultEditor) editor2).getTextField().setEditable(false);
	        }
		
		hastamin = new JSpinner(new SpinnerNumberModel(0,  0,  59,  1));
		hastamin.setBounds(420,  212,  46,  20);
		getContentPane().add(hastamin);
	     JComponent editor3 = hastamin.getEditor();
	        if (editor3 instanceof JSpinner.DefaultEditor) {
	            ((JSpinner.DefaultEditor) editor3).getTextField().setEditable(false);
	        }
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(72,  214,  70,  15);
		getContentPane().add(lblHora);
		
		JLabel lblHora_1 = new JLabel("Hora");
		lblHora_1.setBounds(301,  215,  70,  15);
		getContentPane().add(lblHora_1);
		
		JLabel lblMin = new JLabel("Min");
		lblMin.setBounds(163,  214,  35,  15);
		getContentPane().add(lblMin);
		
		JLabel lblMin_1 = new JLabel("Min");
		lblMin_1.setBounds(389,  215,  35,  15);
		getContentPane().add(lblMin_1);
    }
    
    public void actualizar() {
    	keywords = new ArrayList<>();
    	
		listadoEmpresas.removeAllItems();
  //listadoKeywords.removeAllItems();
  Set<String> empresas = icUsuario.listarEmpresas();
  Set<String> keys = icOferta.listarKeywords();
  List<String> keysSorted = new ArrayList<>(keys);
  Collections.sort(keysSorted,  String.CASE_INSENSITIVE_ORDER);
        
        // listadoKeywords.addItem("");
        /*for (String elemento1 : keysSorted) {
        	listadoKeywords.addItem(elemento1);
        }*/
              
        //availableListModel.clear();
        
        availableListModel.clear();
        selectedListModel.clear();
                          
        for (String item : keysSorted) {
            availableListModel.addElement(item);
        }
        
        /////
        
        listadoEmpresas.addItem("");
        List<String> empresaSorted = new ArrayList<>(empresas);
        Collections.sort(empresaSorted,  String.CASE_INSENSITIVE_ORDER);
                
        for (String elemento : empresaSorted) {
        	listadoEmpresas.addItem(elemento);
        }
        
        Set<String> tiposDePub = icOferta.listarTipoDePublicaciones();
        List<String> tipoSorted = new ArrayList<>(tiposDePub);
        Collections.sort(tipoSorted,  String.CASE_INSENSITIVE_ORDER);
     
        
		listadoOfertas.removeAllItems();
		listadoOfertas.addItem("");
		for (String elemento : tipoSorted) {
			listadoOfertas.addItem(elemento);
		}
	}
    
    private void limpiarFormulario() {
    	nombre.setText("");
    	descripcion.setText("");
        remuneracion.setText("");
        ciudad.setText("");
        //fechaAlta1.setText("");
        //listadoKeywords.removeAllItems();
    }
    
    private void transferirElemento(JList<String> sourceList,  DefaultListModel<String> destinationModel,  DefaultListModel<String> sourceModel) {
        int selectedIndex = sourceList.getSelectedIndex();
        
        if (selectedIndex != -1) {
            String selectedValue = sourceList.getSelectedValue();
            destinationModel.addElement(selectedValue);
            sourceList.clearSelection();
            sourceList.revalidate();
            //destinationModel.removeElementAt(selectedIndex);
            sourceModel.removeElementAt(selectedIndex);
            
            ordenarModeloAlfabeticamente(destinationModel);
            
            sourceList.revalidate();
            
        }
    }
    
    private void ordenarModeloAlfabeticamente(DefaultListModel<String> model) {
        List<String> elements = new ArrayList<>();
         
        for (int i = 0; i < model.size(); i++) {
            elements.add(model.getElementAt(i));
        }
        Collections.sort(elements,  String.CASE_INSENSITIVE_ORDER);

        model.clear();

        for (String element : elements) {
            model.addElement(element);
        }
    }   
}