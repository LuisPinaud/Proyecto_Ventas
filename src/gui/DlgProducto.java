package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import clases.Cliente;
import clases.Producto;
import arreglos.ArregloProductos;

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


public class DlgProducto extends JDialog implements ActionListener, KeyListener, MouseListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtCodigo;
	private JTable tblTable;
	private JLabel lblDescripcion;
	private JLabel lblPrecio;
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
			DlgProducto dialog = new DlgProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProducto() {
		setTitle("Mantenimiento| Producto");
		setBounds(100, 100, 225, 157);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(10, 22, 65, 14);
		contentPanel.add(lblDescripcion);
		lblDescripcion.setVisible(false);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(10, 47, 65, 14);
		contentPanel.add(lblPrecio);
		lblPrecio.setVisible(false);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(85, 22, 220, 20);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		txtDescripcion.setVisible(false);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(85, 47, 114, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setVisible(false);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(384, 11, 46, 20);
		contentPanel.add(lblCodigo);
		lblCodigo.setVisible(false);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(440, 9, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setVisible(false);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setBounds(536, 8, 54, 23);
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
		scrollPane.setBounds(10, 110, 600, 221);
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
		modelo.addColumn("Descripción");
		modelo.addColumn("Precio");
		tblTable.setModel(modelo);
		
		Columnas();
		listar();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource()==btnOk) {
			actionPerformedBtnOk(e);
		}
	}
	
	public static ArregloProductos ap=new ArregloProductos();
	
	public void actionPerformedBtnAceptar(ActionEvent e) {
		lblQue.setVisible(false);
				
		
		switch (cmbOpciones.getSelectedItem().toString()) {
		case "Ingreso":
			visualizarElementos(true, true, false, false);
			btnOk.setText("Agregar");
			posicionElementos(367, 11, 46, 20, 423, 9, 74, 20, 507, 8, 91, 23);
			posicionElementos2(510, 50, 86, 22, 509, 77, 89, 23, 10, 110, 600, 221);
			setSize(635, 155);
			limpiar();
			txtCodigo.setText("" + ap.codigoCorrelativo());	
			break;
		case "Modificación":
			visualizarElementos(true, true, true, false);	
			btnOk.setText("Modificar");	
			posicionElementos(367, 11, 46, 20, 423, 9, 74, 20, 507, 8, 91, 23);
			posicionElementos2(510, 50, 86, 22, 509, 77, 89, 23, 10, 110, 600, 221);
			setSize(635, 380);
			try {
			Producto a = ap.buscar(leerCodigo());
			txtCodigo.setText("" + a.getCodigoProducto());
			txtDescripcion.setText(a.getDescripcion());
			txtPrecio.setText("" +a.getPrecio());
			
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
		lblDescripcion.setVisible(x);
		lblPrecio.setVisible(x);
		txtDescripcion.setVisible(x);
		txtPrecio.setVisible(x);
		
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
	}
	
	
	void adicionarProducto() {
		int codigoProducto = leerCodigo();
		String descripcion = leerDescripcion();
		if (descripcion.length()>0) {
			if (ap.buscarDescripcion(descripcion)==null) {
				try {
					double precio=leerPrecio();
					Producto nuevo = new Producto(codigoProducto, descripcion, precio);
					ap.adicionar(nuevo);
					listar();
					setSize(635, 380);
					scrollPane.setVisible(true);
					txtCodigo.setText("" + ap.codigoCorrelativo());	
				}
				catch (Exception e) {
					mensaje ("Por favor, ingresar un PRECIO correcto");
				}
			}
			else
				mensaje ("Ya existe un Producto con ese NOMBRE");
			}
		else
			mensaje ("Por favor, ingresar una DESCRIPCIÓN correcta");
	setLocationRelativeTo(null);
	}
	
	void modificarProducto() {
		Producto x = ap.buscar(leerCodigo());
		String descripcion = leerDescripcion();
		if (descripcion.length()>0) {
			if (ap.buscarDescripcion(descripcion)==null || descripcion.equals(x.getDescripcion())) {
				try {
					double precio=leerPrecio();
					x.setDescripcion(descripcion);
					x.setPrecio(precio);
					listar();
				}
				catch (Exception e) {
					mensaje ("Por favor, ingresar un PRECIO correcto");
				}
			}
			else
				mensaje ("Ya existe un Producto con ese NOMBRE");
			}
		else
			mensaje ("Por favor, ingresar una DESCRIPCIÓN correcta");
	setLocationRelativeTo(null);
	}
	
	void consultarProducto() {
		try {
			if (ap.buscar(leerCodigo())!=null) {
				Producto x = ap.buscar(leerCodigo());
				JOptionPane.showMessageDialog(this, "Código : " + x.getCodigoProducto() + "\n" + 
													"Descripción : " +x.getDescripcion()+"\n" +
													"Precio: " + String.format("%.2f", x.getPrecio())+"\n", "Datos del producto", -1
													);
				}
			else
				mensaje ("El producto de código " + leerCodigo() + " no existe");
		}
		catch (Exception e){
			mensaje("Por favor, ingrese un CÓDIGO a buscar");
		}
	}
	
	void eliminarProducto() {
		try {
			if (ap.buscar(leerCodigo())!=null) {
				Producto x = ap.buscar(leerCodigo());
				ap.eliminar(x);
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
			adicionarProducto();
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
			consultarProducto();
			break;
		case "Eliminar":
			eliminarProducto();
			break;
			
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (cmbOpciones.getSelectedItem().toString() == "Ingreso" ) { 
			limpiar();
			txtCodigo.setText("" + ap.codigoCorrelativo());
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
			txtCodigo.setText("" + ap.codigoCorrelativo());
		}
		else
		editarFila();
	}
	
	void editarFila() {
		if (ap.tamanio() == 0){
			limpiar();
		}
		else {
			Producto x = ap.obtener(tblTable.getSelectedRow());
			txtCodigo.setText("" + x.getCodigoProducto());
			txtDescripcion.setText("" +x.getDescripcion());
			txtPrecio.setText("" + String.format("%.2f",x.getPrecio()));		
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
	
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ap.tamanio(); i++) {
			Object[] fila = { ap.obtener(i).getCodigoProducto(),
					          ap.obtener(i).getDescripcion(),
					          String.format("%.2f",ap.obtener(i).getPrecio())};					          
			modelo.addRow(fila);
		}
	}
	
	void limpiar() {
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
	}
	
	public int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	public String leerDescripcion() {
		return txtDescripcion.getText();
	}
	public double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	void mensaje (String s) {
		JOptionPane.showMessageDialog(this, s, "Atención", 0);
	}
}
