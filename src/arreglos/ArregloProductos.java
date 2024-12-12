package arreglos;

import java.util.ArrayList;
import clases.Producto;

public class ArregloProductos {
	private ArrayList <Producto> pro;
	

	public ArregloProductos() {
		pro = new ArrayList <Producto>();
		adicionar (new Producto(3001, "Producto1", 12.00));
		adicionar (new Producto(3002, "Producto2", 54.35));
		adicionar (new Producto(3003, "Producto3", 12.84));
		adicionar (new Producto(3004, "Producto4", 52.73));
		adicionar (new Producto(3005, "Producto5", 87.00));
		adicionar (new Producto(3006, "Producto6", 21.84));
		adicionar (new Producto(3007, "Producto7", 12.83));
		adicionar (new Producto(3008, "Producto8", 78.00));
		adicionar (new Producto(3009, "Producto9", 9.00));
		adicionar (new Producto(3010, "Producto10", 39.38));
		adicionar (new Producto(3011, "Producto11", 22.35));
		adicionar (new Producto(3012, "Producto12", 78.24));
		adicionar (new Producto(3013, "Producto13", 3.87));
		adicionar (new Producto(3014, "Producto14", 7.98));
		adicionar (new Producto(3015, "Producto15", 41.70));
		adicionar (new Producto(3016, "Producto16", 10.10));
		
	}
	
	public void adicionar(Producto x) {
		pro.add(x);
	}
	public int tamanio() {
		return pro.size();
	}
	public Producto obtener(int i) {
		return pro.get(i);
	}
	public void eliminar(Producto x) {
		pro.remove(x);
	}
	public Producto buscar(int codigo) {
		Producto x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getCodigoProducto() == codigo)
				return x;
		}
		return null;
	}
	public Producto buscarDescripcion(String desc) {
		Producto x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getDescripcion().equals(desc))
				return x;
		}
		return null;
	}
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 1001;
		else
			return obtener(tamanio()-1).getCodigoProducto() + 1;		
	}
}
