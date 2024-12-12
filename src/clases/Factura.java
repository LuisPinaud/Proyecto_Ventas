package clases;

public class Factura{
	private int codigoFactura,codigoProducto, codigoVendedor;	
	private int unidades;
	private double precio;
	
	public static final double IGV=0.18;
	
	public Factura(int codigoFactura, int codigoProducto, int codigoVendedor, int unidades, double precio) {
		this.codigoFactura = codigoFactura;
		this.codigoProducto = codigoProducto;
		this.codigoVendedor = codigoVendedor;
		this.unidades = unidades;
		this.precio = precio;
	}
	
	public Factura() {		
	}
	
	public Factura(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public Factura(int codigoProducto, double precio) {
		this.codigoProducto = codigoProducto;
		this.precio = precio;
	}

	
	public int getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double importeSubtotal() {
		return precio*unidades;
	}
	
	public double importeIGV() {
		return IGV*importeSubtotal();
	}
	
	public double importeTotalPago() {
		return importeSubtotal() + importeIGV();
	}
		
}
