package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import arreglos.ArregloFacturas;
import arreglos.ArregloProductos;
import arreglos.ArregloVendedores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class DlgReportes extends JDialog implements ActionListener{
	private JComboBox cmbReportes;
	private JButton btnAceptar;
	private JTextArea txtResultado;
	private JScrollPane scrollPane;
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	private JButton btnMostrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgReportes dialog = new DlgReportes();
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
	public DlgReportes() {
		setBounds(100, 100, 450, 494);
		getContentPane().setLayout(null);
		
		cmbReportes = new JComboBox();
		cmbReportes.setModel(new DefaultComboBoxModel(new String[] {"Reporte General por productos", "Reporte General por Vendedores", "Reporte por vendedor", "Reporte por producto", "Reporte de precios"}));
		cmbReportes.setBounds(10, 11, 258, 22);
		getContentPane().add(cmbReportes);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(314, 11, 89, 23);
		getContentPane().add(btnAceptar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 414, 394);
		getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		scrollPane.setViewportView(txtResultado);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(76, 46, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setVisible(false);
		txtCodigo.setColumns(10);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(this);
		btnMostrar.setBounds(179, 43, 89, 23);
		btnMostrar.setVisible(false);
		getContentPane().add(btnMostrar);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(20, 46, 46, 20);
		lblCodigo.setVisible(false);
		getContentPane().add(lblCodigo);

	}
	
	ArregloProductos prod= DlgProducto.ap;
	ArregloVendedores vend = DlgVendedor.av;
	ArregloFacturas fac = DlgVentas.af;
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnAceptar) {
			actionPerformedBtnAceptar (e);
		}
	}
	public void actionPerformedBtnAceptar(ActionEvent e) {
		int opciones = cmbReportes.getSelectedIndex();
		
		switch (opciones) {
		case 0:
			scrollPane.setBounds(10, 50, 414, 394);
			lblCodigo.setVisible(false);
			txtCodigo.setVisible(false);
			btnMostrar.setVisible(false);
			limpiar();
			reporteGeneralProducto();
			break;
		case 1:
			scrollPane.setBounds(10, 50, 414, 394);
			lblCodigo.setVisible(false);
			txtCodigo.setVisible(false);
			btnMostrar.setVisible(false);
			limpiar();
			reporteGeneralVendedor();
			break;
		case 2:
			lblCodigo.setVisible(true);
			txtCodigo.setVisible(true);
			btnMostrar.setVisible(true);
			scrollPane.setBounds(10, 77, 414, 367);
			limpiar();			
		}
		
	}
	
	public void reporteGeneralProducto() {
		for (int i=0; i<prod.tamanio(); i++) {
			Producto producto = prod.obtener(i);
			imprimir ("PRODUCTO DE CÓDIGO: " + producto.getCodigoProducto());
			imprimir ("Número de ventas efectuadas\t:" + producto.getContador());
			imprimir ("Ventas vendidas acumuladas\t:" + producto.getCantidadUnidades());
			imprimir ("Importe total acumulado\t:" + producto.getImporteTotal() );
			imprimir ("");
		}
	}
	
	public void reporteGeneralVendedor() {
		for (int i=0; i<vend.tamanio(); i++) {
			Vendedor vendedor = vend.obtener(i);
			imprimir ("VENDEDOR DE CÓDIGO :" + vendedor.getCodigoVendedor());
			imprimir ("N° ventas\t\t :" + vendedor.getContadorVentas());
			imprimir ("N° unidades vendidas\t :" + vendedor.getUnidadesVendidas());
			imprimir ("Importe total de ventas\t :" + String.format("%.2f",vendedor.getTotalVentas()));
			imprimir ("");
		}
	}
	
	public int leerCodigo() {
		return Integer.parseInt(txtResultado.getText());
	}
	
	void imprimir(String s) {
		txtResultado.append(s+"\n");
	}
	
	void limpiar () {
		txtResultado.setText("");
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, "s");
	}
}
	
	
