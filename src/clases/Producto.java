package clases;

public class Producto extends Factura{
	private String descripcion;

	public int contador=0;
	public int cantidadUnidades=0;
	public double importeTotal=0;
	
	public Producto(int codigoProducto, String descripcion, double precio) {
		super(codigoProducto, precio);
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getCantidadUnidades() {
		return cantidadUnidades;
	}

	public void setCantidadUnidades(int cantidadUnidades) {
		this.cantidadUnidades = cantidadUnidades;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}
	public int sumarContador() {
		return contador++;
	}
}
