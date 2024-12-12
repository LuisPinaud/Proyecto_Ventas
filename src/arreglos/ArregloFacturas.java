package arreglos;
import clases.Factura;

import java.util.ArrayList;

public class ArregloFacturas {
	private ArrayList <Factura> fac;
	
	public ArregloFacturas() {
		fac = new ArrayList <Factura>();
		adicionar(new Factura());
	}
	
	public void adicionar(Factura x) {
		fac.add(x);
	}
	public int tamanio() {
		return fac.size();
	}
	public Factura obtener(int i) {
		return fac.get(i);
	}
	public void eliminar(Factura x) {
		fac.remove(x);
	}
	
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 4001;
		else
			return obtener(tamanio()-1).getCodigoFactura() + 1;		
	}
}
