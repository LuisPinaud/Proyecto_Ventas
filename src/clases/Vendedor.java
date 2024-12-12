package clases;

public class Vendedor extends Factura{
	private int categoria;
	private String nombres, apellidos, telefono, dni;
	private int contadorVentas = 0;
	private int unidadesVendidas = 0;
	private double TotalVentas = 0;
	
	public Vendedor(int codigoVendedor, int categoria, String nombres, String apellidos, String telefono, String dni) {
		super(codigoVendedor);
		this.categoria = categoria;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.dni = dni;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	 public int getContadorVentas() {
		return contadorVentas;
	}
	public void setContadorVentas(int contadorVentas) {
		this.contadorVentas = contadorVentas;
	}
	public int getUnidadesVendidas() {
		return unidadesVendidas;
	}
	public void setUnidadesVendidas(int unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}
	public double getTotalVentas() {
		return TotalVentas;
	}
	public void setTotalVentas(double totalVentas) {
		TotalVentas = totalVentas;
	}
	public void incrementarContadorVentas() {
        contadorVentas++;
	}
	
}

