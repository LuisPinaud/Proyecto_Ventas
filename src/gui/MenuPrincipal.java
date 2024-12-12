package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class MenuPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnReportes;
	private JMenuItem mntmVendedores;
	private JMenuItem mntmClientes;
	private JSeparator separator;
	private JMenuItem mntmProductos;
	private JSeparator separator_1;
	private JMenuItem mntmSalirDelSistema;
	private JMenuItem mntmVerReportes;
	private JMenuItem mntmGenerarVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmVendedores = new JMenuItem("Vendedores");
		mntmVendedores.addActionListener(this);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		mnMantenimiento.add(mntmVendedores);
		
		separator = new JSeparator();
		mnMantenimiento.add(separator);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mnMantenimiento.add(mntmProductos);
		
		separator_1 = new JSeparator();
		mnMantenimiento.add(separator_1);
		
		mntmSalirDelSistema = new JMenuItem("Salir del Sistema");
		mntmSalirDelSistema.addActionListener(this);
		mnMantenimiento.add(mntmSalirDelSistema);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.addActionListener(this);
		menuBar.add(mnVentas);
		
		mntmGenerarVentas = new JMenuItem("Generar Ventas");
		mntmGenerarVentas.addActionListener(this);
		mnVentas.add(mntmGenerarVentas);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.addActionListener(this);
		menuBar.add(mnReportes);
		
		mntmVerReportes = new JMenuItem("Ver Reportes");
		mntmVerReportes.addActionListener(this);
		mnReportes.add(mntmVerReportes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==mntmClientes) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource()==mntmVendedores) {
			actionPerformedMntmVendedores(e);
		}
		if (e.getSource()==mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource()==mntmGenerarVentas) {
			actionPerformedMntmGenerarVentas(e);
		}
		if (e.getSource()==mntmVerReportes) {
			actionPerformedMntmVerReportes(e);
		}
		if (e.getSource()==mntmSalirDelSistema) {
			actionPerformedSalir(e);
		}
	}
	public void actionPerformedMntmClientes(ActionEvent e) {
		DlgCliente dlgCliente = new DlgCliente();
		dlgCliente.setLocationRelativeTo(null);
		dlgCliente.setVisible(true);
	}
	public void actionPerformedMntmVendedores(ActionEvent e) {
		DlgVendedor dlgVendedor = new DlgVendedor();
		dlgVendedor.setLocationRelativeTo(null);
		dlgVendedor.setVisible(true);
	}
	public void actionPerformedMntmProductos(ActionEvent e) {
		DlgProducto dlgProducto = new DlgProducto();
		dlgProducto.setLocationRelativeTo(null);
		dlgProducto.setVisible(true);
	}
	public void actionPerformedMntmGenerarVentas(ActionEvent e) {
		DlgVentas dlgVentas = new DlgVentas();
		dlgVentas.setLocationRelativeTo(null);
		dlgVentas.setVisible(true);
	}
	public void actionPerformedMntmVerReportes(ActionEvent e) {
		DlgReportes dlgReportes = new DlgReportes();
		dlgReportes.setLocationRelativeTo(null);
		dlgReportes.setVisible(true);
	}
	public void actionPerformedSalir(ActionEvent e) {
		dispose();
	}
}
