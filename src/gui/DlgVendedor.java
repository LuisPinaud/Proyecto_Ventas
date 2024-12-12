package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloVendedores;
import clases.Vendedor;

public class DlgVendedor extends JDialog implements ActionListener, KeyListener, MouseListener{
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtCategoria;
	private JTextField txtTelefono;
	private JTextField txtCodigo;
	private JTable tblTable;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblCategoria;
	private JLabel lblTelefono;
	private JComboBox cmbOpciones;
	private JButton btnAceptar;
	private JLabel lblCodigo;
	private JButton btnOk;
	private JTextField txtDni;
	private JLabel lblDni;
	private JLabel lblQue;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgVendedor dialog = new DlgVendedor();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgVendedor() {
		setTitle("Mantenimiento | Vendedor");
		setBounds(100, 100, 225, 157);
		getContentPane().setLayout(null);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombres.setBounds(10, 34, 65, 14);
		getContentPane().add(lblNombres);
		lblNombres.setVisible(false);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellidos.setBounds(10, 59, 65, 14);
		getContentPane().add(lblApellidos);
		lblApellidos.setVisible(false);
		
		lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCategoria.setBounds(10, 8, 65, 18);
		getContentPane().add(lblCategoria);
		lblCategoria.setVisible(false);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono.setBounds(10, 86, 65, 14);
		getContentPane().add(lblTelefono);
		lblTelefono.setVisible(false);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(85, 34, 220, 20);
		getContentPane().add(txtNombres);
		txtNombres.setVisible(false);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(85, 59, 220, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setVisible(false);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(85, 8, 110, 20);
		getContentPane().add(txtCategoria);
		txtCategoria.setVisible(false);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(85, 84, 110, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setVisible(false);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(384, 14, 46, 20);
		getContentPane().add(lblCodigo);
		lblCodigo.setVisible(false);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(440, 12, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setVisible(false);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setBounds(536, 11, 54, 23);
		getContentPane().add(btnOk);
		btnOk.setVisible(false);
		
		cmbOpciones = new JComboBox();
		cmbOpciones.setModel(new DefaultComboBoxModel(new String[] {"Ingreso", "Modificaci\u00F3n", "Consulta", "Eliminaci\u00F3n", "Listado"}));
		cmbOpciones.setBounds(60, 48, 86, 22);
		getContentPane().add(cmbOpciones);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(59, 73, 89, 23);
		getContentPane().add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 600, 221);
		getContentPane().add(scrollPane);
		scrollPane.setVisible(false);
		
		lblQue = new JLabel("\u00BFQu\u00E9 desea realizar?");
		lblQue.setVerticalAlignment(SwingConstants.TOP);
		lblQue.setHorizontalAlignment(SwingConstants.CENTER);
		lblQue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQue.setBounds(11, 13, 176, 30);
		getContentPane().add(lblQue);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 111, 46, 14);
		getContentPane().add(lblDni);
		lblDni.setVisible(false);
		
		txtDni = new JTextField();
		txtDni.setBounds(85, 111, 110, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		txtDni.setVisible(false);
		
		tblTable = new JTable();
		tblTable.addKeyListener(this);
		tblTable.addMouseListener(this);
		tblTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTable);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Categoría");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Teléfono");
		modelo.addColumn("DNI");
		tblTable.setModel(modelo);
		
		Columnas();
		listar();

	}
	
	public static ArregloVendedores av = new ArregloVendedores();
	
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
			posicionElementos2(510, 50, 86, 22, 509, 77, 89, 23, 10, 135, 600, 221);
			setSize(635, 185);
			limpiar();
			txtCodigo.setText("" + av.codigoCorrelativo());	
			break;
		case "Modificación":
			visualizarElementos(true, true, true, false);	
			btnOk.setText("Modificar");	
			posicionElementos(367, 11, 46, 20, 423, 9, 74, 20, 507, 8, 91, 23);
			posicionElementos2(510, 50, 86, 22, 509, 77, 89, 23, 10, 135, 600, 221);
			setSize(635, 400);
			try {
			Vendedor a = av.buscar(leerCodigo());
			txtCodigo.setText("" + a.getCodigoVendedor());
			txtNombres.setText(a.getNombres());
			txtApellidos.setText("" +a.getApellidos());
			txtDni.setText("" + a.getDni());
			txtTelefono.setText("" + a.getTelefono());
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
		lblCategoria.setVisible(x);
		lblNombres.setVisible(x);
		lblApellidos.setVisible(x);
		lblTelefono.setVisible(x);
		lblDni.setVisible(x);
		txtCategoria.setVisible(x);
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
		c.getColumn(0).setPreferredWidth(90);
		c.getColumn(1).setPreferredWidth(90);
		c.getColumn(2).setPreferredWidth(200);
		c.getColumn(3).setPreferredWidth(200);
		c.getColumn(4).setPreferredWidth(120);
		c.getColumn(5).setPreferredWidth(110);
		
	}
	
	void adicionarVendedor() {	
		int codigoVendedor= leerCodigo();
		String nombre = leerNombres();
		try {
			int categoria = leerCategoria();
			if (nombre.length() > 0 ) {
				String apellidos = leerApellidos();
				if (apellidos.length() >0) {
					String telefono = leerTelefono();				
					if (telefono.length() >0) {
						if(av.buscarTelf(telefono)==null) {
							String dni = leerDni();
							if (dni.length() >0) {
								if (av.buscarDni(dni)==null) {
										Vendedor nuevo = new Vendedor (codigoVendedor, categoria, nombre, apellidos, telefono, dni);
										av.adicionar(nuevo);
										listar();
										setSize(635, 400);
										scrollPane.setVisible(true);
										txtCodigo.setText("" + av.codigoCorrelativo());							
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
		}
		catch (Exception e) {
			mensaje ("Por favor introduzca una CATEGORÍA correcta");
		}
		setLocationRelativeTo(null);
	}
	
	void modificarProducto() {		
		Vendedor x = av.buscar(leerCodigo());
		String nombre = leerNombres();
		try {
			int categoria = leerCategoria();
			if (nombre.length() > 0 ) {
				String apellidos = leerApellidos();
				if (apellidos.length() >0) {				
					String telefono = leerTelefono();
					if (telefono.length() >0) {
						if(av.buscarTelf(telefono)==null || telefono.equals(x.getTelefono())) {						
							String dni = leerDni();
							if (dni.length() >0) {
								if(av.buscarDni(dni)==null || dni.equals(x.getDni())) {								
									x.setCategoria(categoria);
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
			else 
				mensaje ("Por favor introduzca un NOMBRE correcto");
		}
		catch (Exception e) {
			mensaje ("Por favor introduzca una CATEGORÍA correcta");
		}
			
	}
	
	void consultarVendedor() {
		try {
			if (av.buscar(leerCodigo())!=null) {
				Vendedor x = av.buscar(leerCodigo());
				JOptionPane.showMessageDialog(this, "Código : " + x.getCodigoVendedor() + "\n" + 
													"Nombre(s) : " +x.getNombres()+"\n" +
													"Categoría :" + x.getCategoria() +"\n"+
													"Apellidos: " + x.getApellidos()+"\n" + 
													"Teléfono : " + x.getTelefono()+"\n" +
													"Dni : " + x.getDni(), "Datos del vendedor", -1
													);
				}
			else
				mensaje ("El vendedor de código " + leerCodigo() + " no existe");
		}
		catch (Exception e){
			mensaje("Por favor, ingrese un CÓDIGO a buscar");
		}
	}
	
	void eliminarVendedor() {
		try {
			if (av.buscar(leerCodigo())!=null) {
				Vendedor x = av.buscar(leerCodigo());
				av.eliminar(x);
				}
				else
					mensaje ("el código " + leerCodigo() + " no existe");
			listar();
		}
		catch (Exception e) {
			mensaje ("Por favor, ingrese un CÓDIGO a eliminar");
		}
	}
	
	public void actionPerformedBtnOk(ActionEvent e) {
		String botonTexto =btnOk.getText() ;
		
		switch (botonTexto) {
		case "Agregar":
			adicionarVendedor();
			break;
		case "Modificar":
			try {
			modificarProducto();
			}
			catch (Exception arg0) {
				limpiar();
			}
			break;
		case "Buscar":
			consultarVendedor();
			break;
		case "Eliminar":
			eliminarVendedor();
			break;
			
	}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (cmbOpciones.getSelectedItem().toString() == "Ingreso" ) { 
			limpiar();
			txtCodigo.setText("" + av.codigoCorrelativo());
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
			txtCodigo.setText("" + av.codigoCorrelativo());
		}
		else
		editarFila();
	}
	void editarFila() {
		if (av.tamanio() == 0){
			limpiar();
		}
		else {
			Vendedor x = av.obtener(tblTable.getSelectedRow());
			txtCodigo.setText("" + x.getCodigoVendedor());
			txtCategoria.setText("" +x.getCategoria());
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
		txtCategoria.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		
	}
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<av.tamanio(); i++) {
			Object[] fila = { av.obtener(i).getCodigoVendedor(),
							  av.obtener(i).getCategoria(),
					          av.obtener(i).getNombres(),
					          av.obtener(i).getApellidos(),					          
					          av.obtener(i).getTelefono(),
					          av.obtener(i).getDni() };
			modelo.addRow(fila);
		}
	}
	
	public int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	public int leerCategoria() {
		return Integer.parseInt(txtCategoria.getText());
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
