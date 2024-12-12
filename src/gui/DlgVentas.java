package gui;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import clases.*;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import arreglos.*;


import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;

public class DlgVentas extends JDialog implements ActionListener {
	private JTextField txtCliente;
	private JTextField txtVendedor;
	private JTextField txtProducto;
	private JTextField txtUnidades;
	private JLabel lblCliente;
	private JLabel lblVendedor;
	private JLabel lblProducto;
	private JLabel lblUnidades;
	private JTextArea txtResultado;
	private JButton btnVender;
	private JButton btnSalir;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgVentas dialog = new DlgVentas();
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
	public DlgVentas() {
		setTitle("Ventas");
		setBounds(100, 100, 450, 158);
		getContentPane().setLayout(null);
		
		lblCliente = new JLabel("C\u00F3digo del Cliente");
		lblCliente.setBounds(10, 11, 114, 14);
		getContentPane().add(lblCliente);
		
		lblVendedor = new JLabel("C\u00F3digo del Vendedor");
		lblVendedor.setBounds(10, 36, 130, 14);
		getContentPane().add(lblVendedor);
		
		lblProducto = new JLabel("C\u00F3digo del producto");
		lblProducto.setBounds(10, 61, 114, 14);
		getContentPane().add(lblProducto);
		
		lblUnidades = new JLabel("Unidades a vender");
		lblUnidades.setBounds(10, 86, 114, 14);
		getContentPane().add(lblUnidades);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(150, 5, 86, 20);
		getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		txtVendedor = new JTextField();
		txtVendedor.setColumns(10);
		txtVendedor.setBounds(150, 30, 86, 20);
		getContentPane().add(txtVendedor);
		
		txtProducto = new JTextField();
		txtProducto.setColumns(10);
		txtProducto.setBounds(150, 55, 86, 20);
		getContentPane().add(txtProducto);
		
		txtUnidades = new JTextField();
		txtUnidades.setColumns(10);
		txtUnidades.setBounds(150, 80, 86, 20);
		getContentPane().add(txtUnidades);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(318, 11, 89, 23);
		getContentPane().add(btnVender);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(318, 36, 89, 23);
		getContentPane().add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 414, 165);
		getContentPane().add(scrollPane);
		scrollPane.setVisible(false);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);

	}
	
	public static ArregloFacturas af=new ArregloFacturas();
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnVender) {
			actionPerformedBtnVender (e);
		}
	}
	
	public void actionPerformedBtnVender(ActionEvent e) {
		try {
			int codigoProducto = leerProducto();
			int codigoCliente = leerCliente();
			int codigoVendedor = leerVendedor();			
			int unidades = leerUnidades();
			
			if(DlgCliente.ac.buscar(codigoCliente)!=null) {
				if(DlgVendedor.av.buscar(codigoVendedor)!=null) {
					if(DlgProducto.ap.buscar(codigoProducto)!=null) {
						Factura f = new Factura();
						
						limpiar();
						Producto p = DlgProducto.ap.buscar(codigoProducto);
						double precio = p.getPrecio();						
						f.setUnidades(unidades);
						f.setPrecio(precio);
						listar(p, f);
						
						Producto producto = DlgProducto.ap.buscar(codigoProducto);
						producto.sumarContador();
						int cantidadUnid=producto.getCantidadUnidades();
						producto.setCantidadUnidades(cantidadUnid+=unidades);
						double importeTot= producto.getImporteTotal();
						producto.setImporteTotal(importeTot+=f.importeTotalPago());
						
						
						Vendedor vendedor = DlgVendedor.av.buscar(codigoVendedor);
		                vendedor.incrementarContadorVentas();
		                int unidadesVen=vendedor.getUnidadesVendidas();
						vendedor.setUnidadesVendidas(unidadesVen+=unidades);
						double totalVen = vendedor.getTotalVentas();
						vendedor.setTotalVentas(totalVen+=f.importeTotalPago());
						
						setSize(450, 320);
						scrollPane.setVisible(true);
						setLocationRelativeTo(null);
					}
					else 
						mensaje ("El PRODUCTO ingresado no existe");					
				}
				else
					mensaje ("El VENDEDOR ingresado no existe");
			}
			else 
				mensaje ("El CLIENTE ingresado no existe");					
		}
		catch (Exception arg0) {
			mensaje ("Por favor, complete los campos vacíos");
		}		
	}
	
	void imprimir(String s) {
		txtResultado.append(s + "\n");
	}
	
	void listar (Producto p, Factura f) {
		imprimir ("BOLETA DE VENTA");
		imprimir ("Código del Cliente\t :" + leerCliente());
		imprimir ("Código del Vendedor\t :" + leerVendedor());
		imprimir ("Código del Producto\t :" + leerProducto());
		imprimir ("Descripción del producto\t :" + p.getDescripcion());
		imprimir ("Precio unitario\t\t :" + String.format("%.2f",p.getPrecio()));
		imprimir ("Importe Subtotal\t :" + String.format("%.2f",f.importeSubtotal()));
		imprimir ("Importe del IGV\t\t :" + String.format("%.2f",f.importeIGV()));
		imprimir ("Total a pagar\t\t :" + String.format("%.2f",f.importeTotalPago()));
	}
	
	void limpiar() {
		txtResultado.setText("");
	}
	
	void mensaje (String s) {
		JOptionPane.showMessageDialog(this, s, "¡Atención!", 1);
	}
	
	public int leerVendedor() {
		return Integer.parseInt(txtVendedor.getText());
	}
	
	public int leerCliente() {
		return Integer.parseInt(txtCliente.getText());
	}
	
	public int leerProducto() {
		return Integer.parseInt(txtProducto.getText());
	}
	
	public int leerUnidades() {
		return Integer.parseInt(txtUnidades.getText());
	}
}
