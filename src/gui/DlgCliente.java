package gui;

import java.awt.BorderLayout;
import clases.Cliente;
import arreglos.ArregloClientes;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class DlgCliente extends JDialog implements ActionListener, KeyListener, MouseListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JTextField txtCodigo;
	private JTable tblTable;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JComboBox cmbOpciones;
	private JButton btnAceptar;
	private JLabel lblCodigo;
	private JLabel lblQue;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JButton btnOk;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCliente dialog = new DlgCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog
	 */
	public DlgCliente() {
		setTitle("Mantenimiento| Cliente");
		setBounds(100, 100, 225, 157);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombres.setBounds(10, 11, 65, 14);
		contentPanel.add(lblNombres);
		lblNombres.setVisible(false);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellidos.setBounds(10, 36, 65, 14);
		contentPanel.add(lblApellidos);
		lblApellidos.setVisible(false);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono.setBounds(10, 61, 65, 14);
		contentPanel.add(lblTelefono);
		lblTelefono.setVisible(false);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDni.setBounds(10, 86, 65, 14);
		contentPanel.add(lblDni);
		lblDni.setVisible(false);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(85, 11, 220, 20);
		contentPanel.add(txtNombres);
		txtNombres.setColumns(10);
		txtNombres.setVisible(false);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(85, 36, 220, 20);
		contentPanel.add(txtApellidos);
		txtApellidos.setColumns(10);
		txtApellidos.setVisible(false);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(85, 61, 110, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		txtTelefono.setVisible(false);
		
		txtDni = new JTextField();
		txtDni.setBounds(85, 86, 110, 20);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);
		txtDni.setVisible(false);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(367, 11, 46, 20);
		contentPanel.add(lblCodigo);
		lblCodigo.setVisible(false);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(423, 9, 74, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setVisible(false);
		
		btnOk = new JButton("Agregar");
		btnOk.addActionListener(this);
		btnOk.setBounds(507, 8, 91, 23);
		contentPanel.add(btnOk);
		btnOk.setVisible(false);
		
		cmbOpciones = new JComboBox();
		cmbOpciones.setModel(new DefaultComboBoxModel(new String[] {"Ingreso", "Modificaci\u00F3n", "Consulta", "Eliminaci\u00F3n", "Listado"}));
		cmbOpciones.setBounds(60, 45, 86, 22);
		contentPanel.add(cmbOpciones);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(59, 70, 89, 23);
		contentPanel.add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 600, 221);
		contentPanel.add(scrollPane);
		scrollPane.setVisible(false);
		
		lblQue = new JLabel("\u00BFQu\u00E9 desea realizar?");
		lblQue.setVerticalAlignment(SwingConstants.TOP);
		lblQue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQue.setHorizontalAlignment(SwingConstants.CENTER);
		lblQue.setBounds(11, 10, 176, 30);
		contentPanel.add(lblQue);
		
		tblTable = new JTable();
		tblTable.addKeyListener(this);
		tblTable.addMouseListener(this);
		tblTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTable);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Teléfono");
		modelo.addColumn("DNI");
		tblTable.setModel(modelo);
		
		Columnas();
		listar();
		
	}
	
	public static ArregloClientes ac=new ArregloClientes();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource()==btnOk) {
			actionPerformedBtnOk(e);
		}
		
	}
	
	
	public void actionPerformedBtnAceptar(ActionEvent e) {
		lblQue.setVisible(false);
				
		
		switch (cmbOpciones.getSelectedItem().toString()) {
		case "Ingreso":
			visualizarElementos(true, true, false, false);
			btnOk.setText("Agregar");
			posicionElementos(367, 11, 46, 20, 423, 9, 74, 20, 507, 8, 91, 23);
			posicionElementos2(510, 50, 86, 22, 509, 77, 89, 23, 10, 121, 600, 221);
			setSize(635, 160);
			limpiar();
			txtCodigo.setText("" + ac.codigoCorrelativo());	
			break;
		case "Modificación":
			visualizarElementos(true, true, true, false);	
			btnOk.setText("Modificar");	
			posicionElementos(367, 11, 46, 20, 423, 9, 74, 20, 507, 8, 91, 23);
			posicionElementos2(510, 50, 86, 22, 509, 77, 89, 23, 10, 121, 600, 221);
			setSize(635, 400);
			try {
				Cliente a = ac.buscar(leerCodigo());
				txtCodigo.setText("" + a.getCodigoCliente());
				txtNombres.setText(a.getNombres());
				txtApellidos.setText(a.getApellidos());
				txtDni.setText(a.getDni());
				txtTelefono.setText(a.getTelefono());
			}
			catch (Exception arg0){
				limpiar();
			}
			break;
		case "Consulta":
			visualizarElementos(false, true, true, true);
			btnOk.setText("Buscar");
			posicionElementos(150, 20, 86, 22, 200, 20, 89, 23, 300, 19, 91, 23);	
			posicionElementos2(450, 7, 86, 22, 450, 33, 89, 23, 10, 60, 600, 221);
			setSize(635, 330);
			break;
		case "Eliminación":
			visualizarElementos(false, true, true, true);
			btnOk.setText("Eliminar");
			posicionElementos(150, 20, 86, 22, 200, 20, 89, 23, 300, 19, 91, 23);
			posicionElementos2(450, 7, 86, 22, 450, 33, 89, 23, 10, 60, 600, 221);
			setSize(635, 330);
			break;
		default:
			visualizarElementos(false, false, true, false);					
			posicionElementos2(210, 20, 86, 22, 310, 20, 89, 23, 10, 60, 600, 221);
			setSize(635, 330);
				
		}
		setLocationRelativeTo(null);
	}
	
	void visualizarElementos(boolean x, boolean y, boolean z, boolean a) {
		lblNombres.setVisible(x);
		lblApellidos.setVisible(x);
		lblTelefono.setVisible(x);
		lblDni.setVisible(x);
		txtNombres.setVisible(x);
		txtApellidos.setVisible(x);
		txtTelefono.setVisible(x);
		txtDni.setVisible(x);
		
		lblCodigo.setVisible(y);
		txtCodigo.setVisible(y);
		btnOk.setVisible(y);
		
		scrollPane.setVisible(z);
		
		txtCodigo.setEditable(a);	
	}
	
	void posicionElementos(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l) {
		lblCodigo.setBounds(a, b, c, d);
		txtCodigo.setBounds(e, f, g, h);			
		btnOk.setBounds(i, j, k, l);	
	}
	
	void posicionElementos2(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l) {
		cmbOpciones.setBounds(a, b, c, d);
		btnAceptar.setBounds(e, f, g, h);		
		scrollPane.setBounds(i, j, k, l);	
		
	}
	
	void Columnas() {
		TableColumnModel c = tblTable.getColumnModel();
		c.getColumn(0).setPreferredWidth(100);
		c.getColumn(1).setPreferredWidth(200);
		c.getColumn(2).setPreferredWidth(200);
		c.getColumn(3).setPreferredWidth(150);
		
	}
	
	public void actionPerformedBtnOk(ActionEvent e) {
		String botonTexto =btnOk.getText() ;
		
		switch (botonTexto) {
		case "Agregar":
			adicionarCliente();
			break;
		case "Modificar":
			modificarCliente();
			break;
		case "Buscar":
			consultarCliente();
			break;
		default:
			eliminarCliente();			
		}
	}
	
	void adicionarCliente() {	
		int codigoCliente = leerCodigo();
		String nombre = leerNombres();
		if (nombre.length() > 0 ) {
			String apellidos = leerApellidos();
			if (apellidos.length() >0) {
				String telefono = leerTelefono();
				if (telefono.length() >0) {
					if(ac.buscarTelf(telefono)==null) {
						String dni = leerDni();
						if (dni.length() >0) {
							if (ac.buscarDni(dni)==null) {
									Cliente nuevo = new Cliente (codigoCliente, nombre, apellidos, telefono, dni);
									ac.adicionar(nuevo);
									listar();
									setSize(635, 400);
									scrollPane.setVisible(true);
									txtCodigo.setText("" + ac.codigoCorrelativo());							
							}
							else 
								mensaje ("El número de DNI ingresado ya existe");
							
						}
						else 
							mensaje ("Por favor introduzca un DNI correcto");
						
					}
					else 
						mensaje ("El número de TELÉFONO ingresado ya existe");
						
				}
				else
					mensaje ("Por favor introduzca un TELÉFONO correcto");
				
			}
			else
				mensaje ("Por favor introduzca un APELLIDO correcto");
		}
		else 
			mensaje ("Por favor introduzca un NOMBRE correcto");	
		setLocationRelativeTo(null);
	}
	
	void modificarCliente() {		
		try {
			Cliente x = ac.buscar(leerCodigo());
			String nombre = leerNombres();
			if (nombre.length() > 0 ) {
				String apellidos = leerApellidos();
				if (apellidos.length() >0) {				
					String telefono = leerTelefono();
					if (telefono.length() >0) {
						if(ac.buscarTelf(telefono)==null || telefono.equals(x.getTelefono())) {						
							String dni = leerDni();
							if (dni.length() >0) {
								if(ac.buscarDni(dni)==null || dni.equals(x.getDni())) {								
									x.setNombres(nombre);
									x.setApellidos(apellidos);
									x.setTelefono(telefono);
									x.setDni(dni);
									listar();													
								}
								else {
									mensaje ("El número de DNI ingresado ya existe");
								}
							}
							else{
								mensaje ("Por favor introduzca un DNI correcto");
							}
						}
						else {
							mensaje ("El número de TELÉFONO ingresado ya existe");
						}		
					}
					else{
						mensaje ("Por favor introduzca un TELÉFONO correcto");
					}
				}
				else
					mensaje ("Por favor introduzca un APELLIDO correcto");
			}
			else {
				mensaje ("Por favor introduzca un NOMBRE correcto");
			}
		}
		catch (Exception e) {
			mensaje ("Por favor introduzca un CÓDIGO correcto");
		}
	}
	
	void consultarCliente() {
		try {
			if (ac.buscar(leerCodigo())!=null) {
				Cliente x = ac.buscar(leerCodigo());
				JOptionPane.showMessageDialog(this, "Código : " + x.getCodigoCliente() + "\n" + 
													"Nombre(s) : " +x.getNombres()+"\n" +
													"Apellidos: " + x.getApellidos()+"\n" + 
													"Teléfono : " + x.getTelefono()+"\n" +
													"Dni : " + x.getDni(), "Datos del cliente", -1
													);
				}
			else
				mensaje ("El cliente de código " + leerCodigo() + " no existe");
		}
		catch (Exception e){
			mensaje("Por favor, ingrese un CÓDIGO a buscar");
		}
	}
	
	void eliminarCliente() {
		try {
			if (ac.buscar(leerCodigo())!=null) {
				Cliente x = ac.buscar(leerCodigo());
				ac.eliminar(x);
				}
				else
					mensaje ("el código " + leerCodigo() + " no existe");
			listar();
		}
		catch (Exception e) {
			mensaje ("Por favor, ingrese un CÓDIGO a eliminar");
		}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (cmbOpciones.getSelectedItem().toString() == "Ingreso" ) { 
			limpiar();
			txtCodigo.setText("" + ac.codigoCorrelativo());
		}
		else {
			e.consume();
			editarFila();
		}
			
	}
	public void keyTyped(KeyEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblTable) {
			mouseClickedTblTable(e);
		}
	}
	protected void mouseClickedTblTable(MouseEvent e) {
		if (cmbOpciones.getSelectedItem().toString() == "Ingreso" ) { 
			limpiar();
			txtCodigo.setText("" + ac.codigoCorrelativo());
		}
		else
		editarFila();
	}
	void editarFila() {
		if (ac.tamanio() == 0){
			limpiar();
		}
		else {
			Cliente x = ac.obtener(tblTable.getSelectedRow());
			txtCodigo.setText("" + x.getCodigoCliente());
			txtNombres.setText(x.getNombres());
			txtApellidos.setText("" +x.getApellidos());
			txtDni.setText("" + x.getDni());
			txtTelefono.setText("" + x.getTelefono());
			
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}	
	
	void limpiar() {
		txtCodigo.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		
	}
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ac.tamanio(); i++) {
			Object[] fila = { ac.obtener(i).getCodigoCliente(),
					          ac.obtener(i).getNombres(),
					          ac.obtener(i).getApellidos(),
					          ac.obtener(i).getTelefono(),
					          ac.obtener(i).getDni() };
			modelo.addRow(fila);
		}
	}
	
	public int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	public String leerNombres() {
		return txtNombres.getText();
	}
	public String leerApellidos() {
		return txtApellidos.getText();
	}
	public String leerTelefono() {
		return txtTelefono.getText();
	}
	public String leerDni() {
		return txtDni.getText(); 
	}
	void mensaje (String s) {
		JOptionPane.showMessageDialog(this, s, "Atención", 0);
	}
}
